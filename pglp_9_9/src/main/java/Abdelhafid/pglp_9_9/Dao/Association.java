package Abdelhafid.pglp_9_9.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Abdelhafid.pglp_9_9.Formes.Forme;

/**
 * Classe qui associe une forme a son groupe d'appartenace.
 */
public class Association {
	/**
	 * Fonction qui insére dans la table ASSOCIATION.
	 * @param nomgroupe Le nom du groupe auquel la forme appartient.
	 * @param nomforme Le nom de la forme.
	 */
	public static void CreateAssociation(final String nomgroupe, final String nomforme) {

		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect
					.prepareStatement("INSERT INTO ASSOCIATION (NomGroupe,NomForme)" + "VALUES (?,?)");
			prepare.setString(1, nomgroupe);
			prepare.setString(2, nomforme);
			int result = prepare.executeUpdate();
			assert result == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Fonction qui supprime dans la table ASSOCIATION toute la forme dans tous les groupes .
	 * @param nom_forme Le nom de la forme a retirer.
	 */
	public static void Remove_Association(final String nom_forme) {
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect.prepareStatement("DELETE FROM ASSOCIATION WHERE NomForme = ?");

			prepare.setString(1, nom_forme);
			int result = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Fonction qui supprime dans la table ASSOCIATION les associations
	 * vers le groupe.
	 * @param nom_Groupe Le nom du groupe a retirer.
	 */
	public static void Remove_All_Asso(final String nom_Groupe) {
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect.prepareStatement("DELETE FROM ASSOCIATION WHERE NomGroupe = ?");

			prepare.setString(1, nom_Groupe);
			int result = prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Fonction qui rechedans l'appartenace d'une forme dans un groupe .
	 * @param nomforme Le nom de la forme a retirer.
	 * @return vrai si c'est vrai.
	 */
	public static boolean appartient(final String nomforme) {
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM ASSOCIATION WHERE NomForme = ?");
			prepare.setString(1, nomforme);
			ResultSet result = prepare.executeQuery();
			return result.next();
		} catch (SQLException e) {
			return false;
		}
	}
	/**
	 * Fonction qui cherche dans la table ASSOCIATION les forme
	 * contenues dans un  groupe .
	 * @param nom_Groupe Le nom du groupe.
	 * @return liste ds formes.
	 */
	public static ArrayList<Forme> Find_All(final String nom_Groupe) {
		ArrayList<Forme> form = new ArrayList<Forme>();
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect
					.prepareStatement("SELECT NomForme FROM ASSOCIATION WHERE NomGroupe = ? ");

			prepare.setString(1, nom_Groupe);

			ResultSet result = prepare.executeQuery();

			while (result.next()) {

				DaoFactory daoFactory = new DaoFactory();

				GroupeDaoJdbc grpDao = (GroupeDaoJdbc) daoFactory.getGroupeDaoJdbc();
				CarreDaoJdbc carreDao = (CarreDaoJdbc) daoFactory.getCarreDaoJdbc();
				TriangleDaoJdbc triDao = (TriangleDaoJdbc) daoFactory.getTriangleDaoJdbc();
				CercleDaoJdbc cerDao = (CercleDaoJdbc) daoFactory.getCercleDaoJdbc();
				RectangleDaoJdbc recDao = (RectangleDaoJdbc) daoFactory.getRectangleDaoJdbc();

				Forme formes = carreDao.Find(result.getString("NomForme"));

				if (formes == null) {
					formes = triDao.Find(result.getString("NomForme"));
				}
				if (formes == null) {
					formes = cerDao.Find(result.getString("NomForme"));
				}
				if (formes == null) {
					formes = recDao.Find(result.getString("NomForme"));
				}
				if (formes == null) {
					formes = grpDao.Find(result.getString("NomForme"));
				}

				form.add(formes);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			new ArrayList<Forme>();
		}
		return form;

	}

}
