package Abdelhafid.pglp_9_9.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Abdelhafid.pglp_9_9.Formes.Point;
import Abdelhafid.pglp_9_9.Formes.Triangle;

/**
 * Classe Fabrique du Triangle.
 */
public class TriangleDaoJdbc implements DaoJDBC<Triangle> {
	/**
	 * Fonction de création du triangle.
	 * @param triangle le triangle a créer.
	 * @return le triangle crée.
	 */
	@Override
	public Triangle Create(Triangle triangle) {

		if (Find(triangle.getNomForme()) == null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {

				PreparedStatement prepare = connect.prepareStatement("INSERT  INTO Forme (Nom)" + "VALUES (?)");
				prepare.setString(1, triangle.getNomForme());
				int result = prepare.executeUpdate();

				prepare = connect
						.prepareStatement("INSERT INTO TRIANGLE (Nom,haut_Abs,haut_Ord,bas_gauche_Abs,bas_gauche_Ord ,"
								+ "bas_droite_Abs,bas_droite_Ord)" + "VALUES (?,?,?,?,?,?,?)");
				prepare.setString(1, triangle.getNomForme());
				prepare.setInt(2, triangle.getHaut().getX());
				prepare.setInt(3, triangle.getHaut().getY());
				prepare.setInt(4, triangle.getBas_gauche().getX());
				prepare.setInt(5, triangle.getBas_gauche().getY());
				prepare.setInt(6, triangle.getBas_droite().getX());
				prepare.setInt(7, triangle.getBas_droite().getY());
				result = prepare.executeUpdate();
				assert result == 1;

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

		return triangle;

	}
	/**
	 * Fonction de recherche du Triangle .
	 * @param nom le nom duTriangle a retrouver.
	 * @return le Triangle si retrouvé.
	 */
	@Override
	public Triangle Find(String nom) {

		Triangle triangle = null;

		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM TRIANGLE WHERE Nom = ?");
			prepare.setString(1, nom);
			ResultSet rs = prepare.executeQuery();
			if (rs.next()) {
				triangle = new Triangle(rs.getString("Nom"), new Point(rs.getInt("haut_Abs"), rs.getInt("haut_Ord")),
						new Point(rs.getInt("bas_gauche_Abs"), rs.getInt("bas_gauche_Ord")),
						new Point(rs.getInt("bas_droite_Abs"), rs.getInt("bas_droite_Ord")));

				rs.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return triangle;
	}
	/**
	 * Fonction de recherche des Triangles.
	 * @return la list des Triangles.
	 */
	@Override
	public ArrayList<Triangle> FindAll() {
		ArrayList<Triangle> list_triangle = new ArrayList<Triangle>();
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {

			PreparedStatement prepare = connect.prepareStatement("SELECT Nom FROM TRIANGLE");
			ResultSet rs = prepare.executeQuery();
			while (rs.next()) {
				list_triangle.add(Find(rs.getString("Nom")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Triangle>();
		}

		return list_triangle;
	}
	/**
	 * Fonction de mise a jour du triangle.
	 * @param triangle le triangle a mettre a jour.
	 * @return le triangle  mit a jour.
	 */
	@Override
	public Triangle Update(Triangle triangle) {
		if (this.Find(triangle.getNomForme()) != null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement(
						"UPDATE Triangle SET haut_Abs = ?," + "haut_Ord = ?, bas_gauche_Abs= ?, bas_gauche_Ord= ?,"
								+ "bas_droite_Abs = ?, bas_droite_Ord= ? WHERE Nom = ?");
				prepare.setString(7, triangle.getNomForme());
				prepare.setInt(1, triangle.getHaut().getX());
				prepare.setInt(2, triangle.getHaut().getY());
				prepare.setInt(3, triangle.getBas_gauche().getX());
				prepare.setInt(4, triangle.getBas_gauche().getY());
				prepare.setInt(5, triangle.getBas_droite().getX());
				prepare.setInt(6, triangle.getBas_droite().getY());

				int rs = prepare.executeUpdate();
				assert rs == 1;

			} catch (SQLException e) {
				e.printStackTrace();
				return this.Find(triangle.getNomForme());
			}
		} else {
			System.out.println("le Triangle que vous voulez modifier n'existe pas");
			return this.Find(triangle.getNomForme());

		}

		return triangle;
	}
	/**
	 * Fonction qui supprime un triangle.
	 * @param triangle le triangle a supprimer.
	 */
	@Override
	public void delete(Triangle triangle) {

		if (Find(triangle.getNomForme()) != null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement("DELETE FROM TRIANGLE WHERE Nom = ?");
				prepare.setString(1, triangle.getNomForme());
				int rs = prepare.executeUpdate();

				prepare = connect.prepareStatement("DELETE FROM FORME WHERE Nom = ?");
				prepare.setString(1, triangle.getNomForme());
				rs = prepare.executeUpdate();
				assert rs == 1;

			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
	}

}
