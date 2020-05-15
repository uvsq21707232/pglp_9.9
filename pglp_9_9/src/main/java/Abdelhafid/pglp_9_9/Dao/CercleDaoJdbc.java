package Abdelhafid.pglp_9_9.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Point;

public class CercleDaoJdbc implements DaoJDBC<Cercle> {
	
	

	@Override
	public Cercle Create(Cercle cercle) {
		if( Find(cercle.getNomForme()) == null ){
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				
				PreparedStatement prepare = connect.prepareStatement(
						      "INSERT  INTO Forme (Nom)"
								+ "VALUES (?)");
				prepare.setString(1, cercle.getNomForme());
				int result = prepare.executeUpdate();
				
				prepare= connect.prepareStatement( 
						"INSERT INTO Cercle (Nom,Centre_Abs,Centre_Ord,Rayon)"
								+ "VALUES (?,?,?,?)");
				prepare.setString(1, cercle.getNomForme());
				prepare.setInt(2, cercle.getCentre().getX());
				prepare.setInt(3, cercle.getCentre().getY());
				prepare.setInt(4, cercle.getRayon());
				result = prepare.executeUpdate();
	            assert result == 1;
	            
	            System.out.println("le "+ cercle.getNomForme()+" a bien été crée");
				
				 
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
	        }
			
			}
			
			return cercle;
		}
		
	

	@Override
	public Cercle Find(String nom) {
     Cercle cercle = null;
		
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			
			PreparedStatement prepare = connect.prepareStatement(
                                              "SELECT * FROM CERCLE WHERE Nom = ?");
            prepare.setString(1, nom);
            ResultSet rs = prepare.executeQuery();
            if (rs.next()) {
            	cercle = new Cercle(
                        rs.getString("Nom"),
                        new Point(rs.getInt("Centre_Abs"),rs.getInt("Centre_Ord")),
                        rs.getInt("Rayon"));
                        
            	rs.close();
	}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
        }
		
		return cercle;
	}
	

	@Override
	public ArrayList<Cercle> FindAll() {
		ArrayList<Cercle> list_cercle = new ArrayList<Cercle>();
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			
			PreparedStatement prepare = connect.prepareStatement(
                                        "SELECT Nom FROM CERCLE");
			ResultSet rs = prepare.executeQuery();
            while (rs.next()) {
            	list_cercle.add(Find(rs.getString("Nom")));
            }
				
		}catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Cercle>();
        }
		
		return list_cercle;
	}

	@Override
	public Cercle Update(Cercle cercle) {
		
		if (Find(cercle.getNomForme())!= null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement(
                        "UPDATE CERCLE SET Centre_Abs = ?,"
                        + "Centre_Ord = ?, Rayon = ? WHERE Nom = ?");
				prepare.setString(4, cercle.getNomForme());
				prepare.setInt(1, cercle.getCentre().getX());
				prepare.setInt(2, cercle.getCentre().getY());
				prepare.setInt(3, cercle.getRayon());
			
				 int rs = prepare.executeUpdate();
	                assert rs == 1;
	                
			}catch (SQLException e) {
				e.printStackTrace();
				return this.Find(cercle.getNomForme());
			}	
		}else{
			System.out.println("le cercle que vous voulez modifier n'existe pas");
			return  this.Find(cercle.getNomForme());
			
		}
	
		return cercle;
			
	}

	@Override
	public void delete(Cercle cercle) {
		
		if (Find(cercle.getNomForme())!= null) {
			try (Connection connect = DriverManager.getConnection(Initializer.url)) {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM CERCLE WHERE Nom = ?");
				prepare.setString(1,cercle.getNomForme());
				int rs = prepare.executeUpdate();
				
				
				prepare=connect.prepareStatement(
						     "DELETE FROM FORME WHERE Nom = ?");
				prepare.setString(1,cercle.getNomForme());
				rs = prepare.executeUpdate();
				assert rs ==1;	
				
			}catch (SQLException e) {
				e.printStackTrace();
				
	        }
		
		}	
	}
	
	
	

}
