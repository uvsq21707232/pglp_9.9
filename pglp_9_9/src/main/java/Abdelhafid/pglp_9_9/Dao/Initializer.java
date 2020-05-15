package Abdelhafid.pglp_9_9.Dao;

import java.sql.*;

import java.util.Properties;


public class Initializer {

	static final String userName = "";
	private static final String password = "";

	public static String url = "jdbc:derby:Dessin;create=true";

	public Initializer() {

		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}

	public void CreateAllTables() throws TableExist {

		try (Connection connect = DriverManager.getConnection(url)) {
			Statement state = connect.createStatement();
			DatabaseMetaData databaseMetadata = connect.getMetaData();
			
			ResultSet result = databaseMetadata.getTables(null, null, "FORME", null);

			if (result.next()) {
				throw new TableExist("TABLE ALREADY EXISTS");
			} else {

				state.addBatch(

						"CREATE TABLE FORME(" 
								+ "Nom VARCHAR(20),"
							    + "PRIMARY KEY(Nom)" + ")");
				
			}

			ResultSet result1 = databaseMetadata.getTables(null, null, "CARRE", null);
			if (result1.next()) {
				throw new TableExist("TABLE ALREADY EXISTS");
			} else {
				state.addBatch("CREATE TABLE CARRE (" 
			                   + "Nom VARCHAR(20), "
			                   + "Centre_Abs int, "
			                   + "Centre_Ord int, "
			                   + "Cote int, "
						       + "PRIMARY KEY(Nom),"
						       + "FOREIGN KEY(Nom) REFERENCES FORME(Nom)" + ")");
			}

			
			  ResultSet result2 = databaseMetadata.getTables(null, null, "CERCLE", null);
			 if (result2.next()) {
				 throw new TableExist("TABLE ALREADY EXISTS");
				 
				 } else {
					 
			  state.addBatch("CREATE TABLE CERCLE (" 
	                   + "Nom VARCHAR(20), "
	                   + "Centre_Abs int, "
	                   + "Centre_Ord int, "
	                   + "Rayon int, "
				       + "PRIMARY KEY(Nom),"
				       + "FOREIGN KEY(Nom) REFERENCES FORME(Nom)" + ")");}
			  
			 ResultSet result3= databaseMetadata.getTables(null, null, "RECTANGLE", null);
			 if (result3.next()) {
				 throw new TableExist("TABLE ALREADY EXISTS");
				 
				 } else {
					 
			  state.addBatch("CREATE TABLE RECTANGLE (" 
	                   + "Nom VARCHAR(20), "
	                   + "Centre_Abs int, "
	                   + "Centre_Ord int, "
	                   + "Longueur int, "
	                   + "Largeur int, "
				       + "PRIMARY KEY(Nom),"
				       + "FOREIGN KEY(Nom) REFERENCES FORME(Nom)" + ")");}
			
			 ResultSet result4= databaseMetadata.getTables(null, null, "TRIANGLE", null);
			 if (result4.next()) {
				 throw new TableExist("TABLE ALREADY EXISTS");
				 
				 } else {
					 
			  state.addBatch("CREATE TABLE TRIANGLE (" 
	                   + "Nom VARCHAR(20), "
	                   + "haut_Abs int, "
	                   + "haut_Ord int, "
	                   + "bas_gauche_Abs int, "
	                   + "bas_gauche_Ord int, "
	                   + "bas_droite_Abs int, "
	                   + "bas_droite_Ord int, "
				       + "PRIMARY KEY(Nom),"
				       + "FOREIGN KEY(Nom) REFERENCES FORME(Nom)" + ")");}
			 
			 ResultSet result_grp= databaseMetadata.getTables(null, null, "GROUPE", null);
			 if ( result_grp.next()) {
				 throw new TableExist("TABLE ALREADY EXISTS");
				 
				 } else {
					 
			  state.addBatch("CREATE TABLE GROUPE(" 
	                   + "Nom VARCHAR(20)," 
	                   + "PRIMARY KEY(Nom),"
				       + "FOREIGN KEY(Nom) REFERENCES GROUPE(Nom)" + ")");}
			 
			 
			 ResultSet result_Ass= databaseMetadata.getTables(null, null, "ASSOCIATION", null);
			 if ( result_Ass.next()) {
				 throw new TableExist("TABLE ALREADY EXISTS");
				 
				 } else {
					 
			  state.addBatch("CREATE TABLE ASSOCIATION(" 
	                   + "NomGroupe VARCHAR(20), "
	                   + "NomForme VARCHAR(20), "
	                   + "PRIMARY KEY(NomGroupe,NomForme),"
	                   +" FOREIGN KEY(NomGroupe) REFERENCES GROUPE(Nom),"
				       + "FOREIGN KEY(NomForme) REFERENCES FORME(Nom)" + ")");}
			 
			state.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void Show_FORME() {
		
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
		PreparedStatement stmt = connect.prepareStatement("SELECT * FROM FORME");

		ResultSet resultat1 = stmt.executeQuery();

		System.out.println("---Table Forme ---\n");
		System.out.println("Nom");

		while (resultat1.next()) {
			System.out.printf("%s%n",
					resultat1.getString("Nom"));
					
		}
		System.out.println("---------------------" + "---------------\n");

		resultat1.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		

	}
	
	public void Show_CARRE() {
		
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			PreparedStatement stmt = connect.prepareStatement("SELECT * FROM CARRE");

			ResultSet resultat1 = stmt.executeQuery();
			System.out.println("---Table Carré---\n");
			System.out.println("Nom Abs Ord côte");

			while (resultat1.next()) {
				System.out.printf("%s\t%d\t%d\t%d%n",
						resultat1.getString("Nom"),
						resultat1.getInt("Centre_Abs"), 
						resultat1.getInt("Centre_Ord"),
						resultat1.getInt("Cote"));
			}
			System.out.println("---------------------" + "---------------\n");

			resultat1.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
			
		
	}
		
	
	public void Show_CERCLE() {
		
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			PreparedStatement stmt = connect.prepareStatement("SELECT * FROM CERCLE");

			ResultSet resultat1 = stmt.executeQuery();
			System.out.println("---Table CERCLE---\n");
			System.out.println("Nom Abs Ord rayon");

			while (resultat1.next()) {
				System.out.printf("%s\t%d\t%d\t%d%n",
						resultat1.getString("Nom"),
						resultat1.getInt("Centre_Abs"), 
						resultat1.getInt("Centre_Ord"),
						resultat1.getInt("Rayon"));
			}
			System.out.println("---------------------" + "---------------\n");

			resultat1.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
			
		
	}
public void Show_RECTANGLE() {
		
		try (Connection connect = DriverManager.getConnection(Initializer.url)) {
			PreparedStatement stmt = connect.prepareStatement("SELECT * FROM RECTANGLE");

			ResultSet resultat1 = stmt.executeQuery();
			System.out.println("-----Table RECTAANGLE-----\n");
			System.out.println("Nom Abs Ord Longueur  largeur");

			while (resultat1.next()) {
				System.out.printf("%s\t%d\t%d\t%d\t%d%n",
						resultat1.getString("Nom"),
						resultat1.getInt("Centre_Abs"), 
						resultat1.getInt("Centre_Ord"),
						resultat1.getInt("Longueur"),
						resultat1.getInt("Largeur"));
			}
			System.out.println("---------------------" + "---------------\n");

			resultat1.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
			
		
	}
	
public void Show_Triangle() {
	
	try (Connection connect = DriverManager.getConnection(Initializer.url)) {
		PreparedStatement stmt = connect.prepareStatement("SELECT * FROM TRIANGLE");

		ResultSet resultat1 = stmt.executeQuery();
		System.out.println("---Table TRIANGLE---\n");
		System.out.println("Nom Haut_X Haut_Y Gauche_X Gauche_Y Droite_X Droite_Y");

		while (resultat1.next()) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d%n",
					resultat1.getString("Nom"),
					resultat1.getInt("haut_Abs"), 
					resultat1.getInt("haut_Ord"),
					resultat1.getInt("bas_gauche_Abs"),
					resultat1.getInt("bas_gauche_Ord"),
					resultat1.getInt("bas_droite_Abs"),
					resultat1.getInt("bas_droite_Ord")); 
            
		}
		System.out.println("---------------------" + "---------------\n");

		resultat1.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	
}
	
public void Show_GROUPE() {
	
	try (Connection connect = DriverManager.getConnection(Initializer.url)) {
		PreparedStatement stmt = connect.prepareStatement("SELECT * FROM GROUPE");

		ResultSet resultat1 = stmt.executeQuery();
		System.out.println("---Table Groupe---\n");
		System.out.println("NomGroupe");

		while (resultat1.next()) {
			System.out.printf("%s%n",
					resultat1.getString("Nom")
					); 
            
		}
		System.out.println("---------------------" + "---------------\n");

		resultat1.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	
}

public void Show_ASSOCIATION() {
	
	try (Connection connect = DriverManager.getConnection(Initializer.url)) {
		PreparedStatement stmt = connect.prepareStatement("SELECT * FROM ASSOCIATION");

		ResultSet resultat1 = stmt.executeQuery();
		System.out.println("---Table ASSOCIATION---\n");
		System.out.println("NomGroupe, NomForme");
		

		while (resultat1.next()) {
			System.out.printf("%s\t%s%n",
					resultat1.getString("NomGroupe"),
					resultat1.getString("NomForme")); 
					
            
		}
		System.out.println("---------------------" + "---------------\n");

		resultat1.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	
}
	
	
}
