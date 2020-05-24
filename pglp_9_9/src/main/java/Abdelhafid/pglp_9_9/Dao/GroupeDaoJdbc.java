package Abdelhafid.pglp_9_9.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Composite;
import Abdelhafid.pglp_9_9.Formes.Forme;
import Abdelhafid.pglp_9_9.Formes.Rectangle;
import Abdelhafid.pglp_9_9.Formes.Triangle;

/**
 * Classe Fabrique du groupe.
 */
public class GroupeDaoJdbc implements DaoJDBC<Composite> {
	/**
	 * Fonction de création du groupe.
	 * @param groupe le Groupe a créer.
	 * @return le groupe crée.
	 */
	public Composite Create(Composite groupe) {
		if (Find(groupe.getNomForme()) == null) {

			try (Connection connect = DriverManager.getConnection(Initializer.url)) {

				PreparedStatement prepare = connect.prepareStatement("INSERT  INTO FORME (Nom)" + "VALUES (?)");
				prepare.setString(1, groupe.getNomForme());
				int result = prepare.executeUpdate();

				prepare = connect.prepareStatement("INSERT INTO GROUPE(Nom)" + "VALUES (?)");
				prepare.setString(1, groupe.getNomForme());
				result = prepare.executeUpdate();

				assert result == 1;

				DaoFactory daoFactory = new DaoFactory();

				DaoJDBC<Carre> carreDao = daoFactory.getCarreDaoJdbc();
				DaoJDBC<Cercle> cercleDao = daoFactory.getCercleDaoJdbc();
				DaoJDBC<Triangle> triangleDao = daoFactory.getTriangleDaoJdbc();
				DaoJDBC<Rectangle> rectangleDao = daoFactory.getRectangleDaoJdbc();

				Iterator<Forme> iterateur = groupe.iterator();
				while (iterateur.hasNext()) {

					Forme forme = iterateur.next();
					if (forme instanceof Carre) {
						carreDao.Create((Carre) forme);

					} else if (forme instanceof Cercle) {
						cercleDao.Create((Cercle) forme);

					} else if (forme instanceof Triangle) {
						triangleDao.Create((Triangle) forme);

					} else if (forme instanceof Rectangle) {
						rectangleDao.Create((Rectangle) forme);

					} else {
						Composite grp = (Composite) forme;
						Create(grp);

					}

					/*
					 * Création des liens d'association entre groupe et forme et les inserer dans la
					 * table ASSOCIATION.
					 **/
					Association.CreateAssociation(groupe.getNomForme(), forme.getNomForme());

				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		return groupe;
	}
	/**
	 * Fonction de recherche du  groupe .
	 * @param nom le nom du Groupe  a retrouver.
	 * @return le Groupe si retrouvé.
	 */
	@Override
	public Composite Find(String nom) {

		Composite groupe = null;

		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM GROUPE WHERE Nom = ?");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			if (result.next()) {
				groupe = new Composite(nom);
			}
			// retrouver toutes les association du groupe dans la table ASSOCIATION
			ArrayList<Forme> list_forme = Association.Find_All(nom);

			for (Forme forme : list_forme) {
				groupe.add(forme);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return groupe;
	}
	/**
	 * Fonction de recherche des Groupes.
	 * @return la list des Groupes.
	 */
	@Override
	public ArrayList<Composite> FindAll() {

		ArrayList<Composite> list_Groupe = new ArrayList<Composite>();

		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect.prepareStatement("SELECT Nom FROM GROUPE");
			ResultSet rs = prepare.executeQuery();
			while (rs.next()) {
				list_Groupe.add(Find(rs.getString("Nom")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Composite>();
		}

		return list_Groupe;
	}
	/**
	 * Fonction de mise a jour du groupe.
	 * @param groupe le groupe a mettre a jour.
	 * @return le groupe mit a jour.
	 */
	@Override
	public Composite Update(Composite groupe) {
		Composite grp = this.Find(groupe.getNomForme());

		if (grp != null) {

			try (Connection connect = DriverManager.getConnection(Initializer.url)) {

				delete(grp);
				Create(groupe);

				return groupe;
			} catch (SQLException e) {
				e.printStackTrace();
				return grp;
			}
		}

		return groupe;
	}
	/**
	 * Fonction qui supprime un groupe.
	 * @param groupe le groupe a supprimer.
	 */
	@Override
	public void delete(Composite groupe) {
		if (Find(groupe.getNomForme()) != null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {

				/*
				 * Supprimer toute les associations du groupe vers les differentes formes daans
				 * la table ASSOCIATION
				 */
				Association.Remove_All_Asso(groupe.getNomForme());

				// supprimer le goupe même dans la table ASSOCIATION
				Association.Remove_Association(groupe.getNomForme());

				PreparedStatement prepare = connect.prepareStatement("DELETE FROM GROUPE WHERE Nom = ?");
				prepare.setString(1, groupe.getNomForme());
				int rs = prepare.executeUpdate();

				prepare = connect.prepareStatement("DELETE FROM FORME WHERE Nom = ?");
				prepare.setString(1, groupe.getNomForme());
				rs = prepare.executeUpdate();
				assert rs == 1;

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
	}

}
