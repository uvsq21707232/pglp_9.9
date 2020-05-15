package Abdelhafid.pglp_9_9.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Point;
import Abdelhafid.pglp_9_9.Formes.Rectangle;

public class RectangleDaoJdbc implements DaoJDBC<Rectangle> {

	@Override
	public Rectangle Create(Rectangle rectangle) {
		if( Find(rectangle.getNomForme()) == null ){
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				
				PreparedStatement prepare = connect.prepareStatement(
						      "INSERT  INTO Forme (Nom)"
								+ "VALUES (?)");
				prepare.setString(1, rectangle.getNomForme());
				int result = prepare.executeUpdate();
				
				prepare= connect.prepareStatement( 
						"INSERT INTO RECTANGLE (Nom,Centre_Abs,Centre_Ord,Longueur,Largeur)"
								+ "VALUES (?,?,?,?,?)");
				prepare.setString(1, rectangle.getNomForme());
				prepare.setInt(2, rectangle.getCentre_rectangle().getX());
				prepare.setInt(3, rectangle.getCentre_rectangle().getY());
				prepare.setInt(4, rectangle.getLongueur());
				prepare.setInt(5, rectangle.getLargeur());	
				
				result = prepare.executeUpdate();
	            assert result == 1;
	            
	            System.out.println("le "+ rectangle.getNomForme()+ " a bien été crée");
				
				 
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
	        }
			
			}
			
			return rectangle;
		
		
		
	}

	@Override
	public Rectangle Find(String nom) {
		Rectangle rectangle=null;
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			
			PreparedStatement prepare = connect.prepareStatement(
                                              "SELECT * FROM RECTANGLE WHERE Nom = ?");
            prepare.setString(1, nom);
            ResultSet rs = prepare.executeQuery();
            if (rs.next()) {
            	rectangle = new Rectangle(
                        rs.getString("Nom"),
                        new Point(rs.getInt("Centre_Abs"),rs.getInt("Centre_Ord")),
                        rs.getInt("Longueur"),
                        rs.getInt("Largeur") );
                        
            	rs.close();
            	}
            
			}catch (SQLException e) {
			e.printStackTrace();
			return null;
        }
		
		return rectangle;
	}

	@Override
	public ArrayList<Rectangle> FindAll() {
		ArrayList<Rectangle> list_rectangle = new ArrayList<Rectangle>();
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			
			PreparedStatement prepare = connect.prepareStatement(
                                        "SELECT Nom FROM RECTANGLE");
			ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
            	list_rectangle.add(Find(rs.getString("Nom")));
            }
				
		}catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Rectangle>();
        }
		
		return list_rectangle;
		
	}

	@Override
	public Rectangle Update(Rectangle rectangle) {
		
		if (Find(rectangle.getNomForme())!= null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement(
                        "UPDATE RECTANGLE SET Centre_Abs = ?,"
                        + "Centre_Ord = ?, Longueur = ? , Largeur = ? WHERE Nom = ?");
				prepare.setString(5,  rectangle.getNomForme());
				prepare.setInt(1,  rectangle.getCentre_rectangle().getX());
				prepare.setInt(2,  rectangle.getCentre_rectangle().getY());
				prepare.setInt(3,  rectangle.getLongueur());
				prepare.setInt(4,  rectangle.getLargeur());
			
				 int rs = prepare.executeUpdate();
	                assert rs == 1;
	                
			}catch (SQLException e) {
				e.printStackTrace();
				return this.Find(rectangle.getNomForme());
			}	
		}else{
			System.out.println("le cercle que vous voulez modifier n'existe pas");
			return this.Find(rectangle.getNomForme());
			
		}
	
		return rectangle;
		
		
		
	}

	@Override
	public void delete(Rectangle rectangle) {
		if (Find(rectangle.getNomForme())!= null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM RECTANGLE WHERE Nom = ?");
				prepare.setString(1,rectangle.getNomForme());
				int rs = prepare.executeUpdate();
				
				
				prepare=connect.prepareStatement(
						     "DELETE FROM FORME WHERE Nom = ?");
				prepare.setString(1,rectangle.getNomForme());
				rs = prepare.executeUpdate();
				assert rs ==1;	
				
			}catch (SQLException e) {
				e.printStackTrace();
				
	        }
		
		}	
		
	}

}
