package Abdelhafid.pglp_9_9.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Point;

/**
 * Classe Fabrique du Carre.
 */
public class CarreDaoJdbc implements DaoJDBC<Carre> {
	/**
	 * Fonction de création du Carée.
	 * @param carre le Carrée a créer.
	 * @return le Carré crée.
	 */
	@Override
	public Carre Create(final Carre carre) {
		if (Find(carre.getNomForme()) == null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {

				PreparedStatement prepare = connect.prepareStatement("INSERT  INTO Forme (Nom)" + "VALUES (?)");
				prepare.setString(1, carre.getNomForme());
				int result = prepare.executeUpdate();

				prepare = connect
						.prepareStatement("INSERT INTO CARRE (Nom,Centre_Abs,Centre_Ord,Cote)" + "VALUES (?,?,?,?)");
				prepare.setString(1, carre.getNomForme());
				prepare.setInt(2, carre.getCentre_carre().getX());
				prepare.setInt(3, carre.getCentre_carre().getY());
				prepare.setInt(4, carre.getCote());
				result = prepare.executeUpdate();
				assert result == 1;

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		return carre;
	}
	/**
	 * Fonction de recherche du Carée.
	 * @param nom le nom du Carée a retrouver.
	 * @return le Carré si retrouvé.
	 */
	@Override
	public Carre Find(String nom) {

		Carre carre = null;

		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM CARRE WHERE Nom = ?");
			prepare.setString(1, nom);
			ResultSet rs = prepare.executeQuery();
			if (rs.next()) {
				carre = new Carre(rs.getString("Nom"), new Point(rs.getInt("Centre_Abs"), rs.getInt("Centre_Ord")),
						rs.getInt("Cote"));

				rs.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return carre;
	}
	/**
	 * Fonction de recherche des Carré.
	 * @return la list des Carrés.
	 */
	@Override
	public ArrayList<Carre> FindAll() {

		ArrayList<Carre> list_carre = new ArrayList<Carre>();
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect.prepareStatement("SELECT Nom FROM CARRE");
			ResultSet rs = prepare.executeQuery();
			while (rs.next()) {
				list_carre.add(Find(rs.getString("Nom")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Carre>();
		}

		return list_carre;
	}
	/**
	 * Fonction de mise a jour du Carée.
	 * @param carre le Carée a mettre a jour.
	 * @return le Carré mit a jour.
	 */
	@Override
	public Carre Update(Carre carre) {

		if (Find(carre.getNomForme()) != null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement(
						"UPDATE CARRE SET Centre_Abs = ?," + "Centre_Ord = ?, Cote = ? WHERE Nom = ?");
				prepare.setString(4, carre.getNomForme());
				prepare.setInt(1, carre.getCentre_carre().getX());
				prepare.setInt(2, carre.getCentre_carre().getY());
				prepare.setInt(3, carre.getCote());

				int rs = prepare.executeUpdate();
				assert rs == 1;

			} catch (SQLException e) {
				e.printStackTrace();
				return this.Find(carre.getNomForme());
			}
		} else {
			System.out.println("le carré que vous voulez modifier n'existe pas");
			return this.Find(carre.getNomForme());

		}

		return carre;
	}
	/**
	 * Fonction qui supprime un carre.
	 * @param carre le Carré a supprimer.
	 */
	@Override
	public void delete(Carre carre) {
		if (Find(carre.getNomForme()) != null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement("DELETE FROM CARRE WHERE Nom = ?");
				prepare.setString(1, carre.getNomForme());
				int rs = prepare.executeUpdate();

				prepare = connect.prepareStatement("DELETE FROM FORME WHERE Nom = ?");
				prepare.setString(1, carre.getNomForme());
				rs = prepare.executeUpdate();
				assert rs == 1;

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
	}

}
