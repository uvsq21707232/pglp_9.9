package Abdelhafid.pglp_9_9.Command;

import java.sql.Connection;
import java.util.ArrayList;

import Abdelhafid.pglp_9_9.Dao.Association;
import Abdelhafid.pglp_9_9.Dao.CarreDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.CercleDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.DaoFactory;
import Abdelhafid.pglp_9_9.Dao.GroupeDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.RectangleDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.TriangleDaoJdbc;
import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Forme;
import Abdelhafid.pglp_9_9.Formes.Point;
import Abdelhafid.pglp_9_9.Formes.Rectangle;
import Abdelhafid.pglp_9_9.Formes.Triangle;

public class DrawingTUI {
	
	/**
     * Fonction qui analyse la commande de création du Cercle.
     * @param split La commande siasit par l'utilisateur en format tableau.
     * @return un cercle si la commande est valide.
     */
	private Forme CommandCercleCreate(final String[] split) {
		
		String[] chaine = split[1].split("Cercle");
		 if (!chaine[0].equals("") ||
		     !(chaine[1].startsWith("(") && chaine[1].endsWith(")"))){
			 
			 System.out.println("Votre commande est invalide ou "
			 		          + "vous manque une parenthese);");
			  
		 }else {
			chaine[1] = chaine[1].substring(1, chaine[1].length() - 1);
	            chaine = chaine[1].split(",");
	            
			 if ( chaine.length == 3){
				 int rayon = Integer.parseInt(chaine[2]);
				 if (rayon>=0) {
				 try {
					 Point centre_cercle = new Point(chaine[0] + "," + chaine[1]);
	                  
	                  
	               Cercle cercle=new Cercle(split[0],centre_cercle,rayon);
	                  
	                    return cercle;
	                    
	                } catch (Exception e) {
	                    System.err.println("Commande invalide");
	                          
	                }
				 }else {
					 System.out.println("le rayon est négatif");
				 }
				 
			 }else {
				 System.out.println("commande invalide. "
				 		+ " Veuillez verifiez le nombre d'argument de votre commande");
			 }
			 
		 }
		
		return null;
		
	}
	
	/**
     * Fonction qui analyse la commande de création du Carre.
     * @param split La commande siasit par l'utilisateur en format tableau.
     * @return un carre si la commande est valide.
     */
	private Forme CommandCarreCreate(final String[] split) {
		
		String[] chaine = split[1].split("Carre");
		 if (!chaine[0].equals("") ||
		     !(chaine[1].startsWith("(") && chaine[1].endsWith(")"))){
			 
			 System.out.println("Votre commande est invalide ou "
			 		          + "vous manque une parenthese);");
			  
		 }else {
			chaine[1] = chaine[1].substring(1, chaine[1].length() - 1);
	            chaine = chaine[1].split(",");
	            
			 if ( chaine.length == 3){
				 int cote = Integer.parseInt(chaine[2]);
               if (cote >= 0) {
				 try {
					 Point centre_carre = new Point(chaine[0] + "," + chaine[1]);
	                  
	                   Carre carre=new Carre(split[0],centre_carre,cote);
	                  
	                    return carre;
				    
	                    
	                } catch (Exception e) {
	                    System.err.println("Commande invalide");
	                          
	                }
               }else {
            	   System.out.println("le cote est negatif\n");
               }
				 
			 }else {
				 System.out.println("commande invalide. "
				 		+ " Veuillez verifiez le nombre d'argument de votre commande");
			 }
			 
		 }
		
		return null;
		
	}
	
	/**
    * Fonction qui analyse la commande de création du Rectangle.
    * @param split La commande siasit par l'utilisateur en format tableau.
    * @return un Rectangle si la commande est valide.
    */
	private Forme CommandRectangleCreate(final String[] split) {
		
		String[] chaine = split[1].split("Rectangle");
		 if (!chaine[0].equals("") ||
		     !(chaine[1].startsWith("(") && chaine[1].endsWith(")"))){
			 
			 System.out.println("Votre commande est invalide ou "
			 		          + "vous manque une parenthese);");
			  
		 }else {
			chaine[1] = chaine[1].substring(1, chaine[1].length() - 1);
	            chaine = chaine[1].split(",");
	            
			 if ( chaine.length == 4){
				 int longueur = Integer.parseInt(chaine[2]);
				 int largeur = Integer.parseInt(chaine[3]);
				 if (longueur>=0 && largeur >=0) {
				 try {
					 Point centre_rectangle = new Point(chaine[0] + "," + chaine[1]);
	                  
	                  
					 Rectangle rectangle=new Rectangle(split[0],centre_rectangle,longueur,largeur);
	                  
	                    return rectangle;
	                    
	                } catch (Exception e) {
	                    System.err.println("Commande invalide");
	                          
	                }
				 }else {
					 System.out.println("la longueur ou la largeur est négative");
				 }
				 
			 }else {
				 System.out.println("commande invalide. "
				 		+ " Veuillez verifiez le nombre d'argument de votre commande");
			 }
			 
		 }
		
		return null;
		
	}
	
	/**
	    * Fonction qui analyse la commande de création du Rectangle.
	    * @param split La commande siasit par l'utilisateur en format tableau.
	    * @return un Rectangle si la commande est valide.
	    */
		private Forme CommandTriangleCreate(final String[] split) {
			
			String[] chaine = split[1].split("Triangle");
			 if (!chaine[0].equals("") ||
			     !(chaine[1].startsWith("(") && chaine[1].endsWith(")"))){
				 
				 System.out.println("Votre commande est invalide ou "
				 		          + "vous manque une parenthese);");
				  
			 }else {
				chaine[1] = chaine[1].substring(1, chaine[1].length() - 1);
		            chaine = chaine[1].split(",");
		            
				 if ( chaine.length == 6){
					 
					 try {
						 Point haut = new Point(chaine[0] + "," + chaine[1]);
						 Point bas_gauche = new Point(chaine[2] + "," + chaine[3]);
						 Point bas_droite = new Point(chaine[4] + "," + chaine[5]);
						Triangle triangle=new Triangle(split[0],haut,bas_gauche,bas_droite);
		                  
		                    return triangle;
		                    
		                } catch (Exception e) {
		                    System.err.println("Commande invalide");
		                          
		                }
					
					 
				 }else {
					 System.out.println("commande invalide. "
					 		+ " Veuillez verifiez le nombre d'argument de votre commande");
				 }
				 
			 }
			
			return null;
			
		}
	
	/**
     * Fonction qui lit la saisie de l'utilisateur.
     * @param command La ligne de commande rentrée par l'utilisateur.
     * @return La command a executer.
     */
	public Command nextCommand(String command) {
		if (command.contains("=")) {
			
            Forme forme = this.Creation(command);
            if (forme != null) {
                return new CommandCreate(forme);
            }
		} else if (command.contains("move")) {
            return CommandMove(command);
            
		 }else if (command.contains("remove")) {
            return CommandRemove(command);
		}
		return null;
	}
	
	
	public Forme Creation(String cmd) {
		String[] split;
	    split = cmd.split("=");
	    split[0] = split[0].trim();
	    
	    if (split[0].contains(" ")) {
	        
	    		System.out.println("Le nom contient espace");
	    			
	    } else {
	        split[1] = split[1].replace(" ", "");
	        Forme forme = null;
	        if (split[1].contains("Carre")) {
	            forme = this.CommandCarreCreate(split);
	        } else if (split[1].contains("Cercle")) {
	        	forme = this.CommandCercleCreate(split);
	        }else if (split[1].contains("Rectangle")) {
	        	forme = this.CommandRectangleCreate(split);
	        }else if (split[1].contains("Triangle")) {
	        	forme = this.CommandTriangleCreate(split);
	        }
	       return forme;
	       
	    } 
	   
	    return null;
	}
	
	
	
	
	/**
     *  Foction qui recherche une forme.
     * @param nom Le nom de la forme a trouver.
     * @return La forme si trouvée.
     */
	
	private Forme recherche(String nom) {
		
		DaoFactory daoFactory= new DaoFactory();
		 
		GroupeDaoJdbc grpDao= (GroupeDaoJdbc) daoFactory.getGroupeDaoJdbc();
		CarreDaoJdbc carreDao= ( CarreDaoJdbc) daoFactory.getCarreDaoJdbc();
		TriangleDaoJdbc triDao= ( TriangleDaoJdbc) daoFactory.getTriangleDaoJdbc();
		CercleDaoJdbc cerDao= ( CercleDaoJdbc) daoFactory.getCercleDaoJdbc();
		RectangleDaoJdbc recDao= (RectangleDaoJdbc) daoFactory.getRectangleDaoJdbc();
		
		Forme forme = carreDao.Find(nom);
		if (forme == null) {

			forme = triDao.Find(nom);
		}
		if (forme == null) {
			forme = cerDao.Find(nom);
		}
		if (forme == null) {
			forme = recDao.Find(nom);
		}
		if (forme == null) {
			forme = grpDao.Find(nom);
		}
		if (forme == null) {
			System.out.println( "pas de forme a ce nom : "+ nom);
		}
		
		return forme;
		
	}
	
	/**
     * Fonction qui analyse la commande de deplacement.
     * @param cmd La commande saisit par l'utilisateur.
     * @return la command de deplacement.
     */
	public  Command CommandMove(final String cmd){
		
		String chaine = cmd.replace(" ", "");
        String[] chaine1 = chaine.split("move");
        
        
        if (!chaine1[0].equals("") ||
   		     !(chaine1[1].startsWith("(") && chaine1[1].endsWith(")"))){
   			 
   			 System.out.println("Votre commande est invalide ou "
   			 		          + "vous manque une parenthese);");
   			  
   		 }else {
   			chaine1[1] = chaine1[1].substring(1, chaine1[1].length() - 1);
   	            chaine1 = chaine1[1].split(",");
   	            
   			 if (chaine1.length == 3){
   				 try {
   					 Point coord_Deplace = new Point(chaine1[1] + "," + chaine1[2]);
   					  
   					 Forme find = this.recherche(chaine1[0]);
   					 	if (find != null) {
   					 	 return new CommandMove(find,coord_Deplace.getX(),coord_Deplace.getY());
   					 	}
   					    
   	                } catch (Exception e) {
   	                    System.err.println("coordonnes de deplacement invalide");
   	                    e.printStackTrace();
   	                          
   	                }
   				 
   			 }else {
   				 System.out.println("commande invalide. "
   				 		+ " Veuillez verifiez le nombre d'arguments de votre commande");
   			 }
   			 
   		 }
   		
   		return null;
   		
		
		
	}
	
	/**
    * Fonction qui analyse la commande de suppression.
    * @param cmd La commande saisit par l'utilisateur.
    * @return la command de suppression.
    */
	private  Command CommandRemove(String cmd){
		
		String chaine = cmd.replace(" ", "");
        String[] chaine1 = chaine.split("remove");
       
       
       if (!chaine1[0].equals("") ||
  		     !(chaine1[1].startsWith("(") && chaine1[1].endsWith(")"))){
  			 
  			 System.out.println("Votre commande est invalide, ou "
  			 		          + "vous manque une parenthese)");
  			  
  		 } else{
  			chaine1[1] = chaine1[1].substring(1, chaine1[1].length() - 1);
  	            chaine1 = chaine1[1].split(",");
  	            
  			 
  	          ArrayList<Forme> listForm = new ArrayList<Forme>();
  					for (String forme: chaine1){
  						 Forme find = this.recherche(forme);
  						 
   					 	 if (find != null) { 
   					 		listForm.add(find);
   					 	 
   					 	}else {
   					 		return null;
   					 	}
  						
  					}
  					return  new CommandRemove(listForm);
  			 
  		 }
  		
  		return null;
  		
		
		
	}
	
	
	/*Affichage du dessin  */
	public void dessiner() {
		DaoFactory daoFactory= new DaoFactory();
		 
		GroupeDaoJdbc grpDao= (GroupeDaoJdbc) daoFactory.getGroupeDaoJdbc();
		CarreDaoJdbc carreDao= ( CarreDaoJdbc) daoFactory.getCarreDaoJdbc();
		TriangleDaoJdbc triDao= ( TriangleDaoJdbc) daoFactory.getTriangleDaoJdbc();
		CercleDaoJdbc cerDao= ( CercleDaoJdbc) daoFactory.getCercleDaoJdbc();
		RectangleDaoJdbc recDao= (RectangleDaoJdbc) daoFactory.getRectangleDaoJdbc();
		
		  ArrayList<Forme> forme = new ArrayList<Forme>();
		  
		  forme.addAll(carreDao.FindAll());
		  forme.addAll(triDao.FindAll());
		  forme.addAll(cerDao.FindAll());
		  forme.addAll(recDao.FindAll());
		  forme.addAll(grpDao.FindAll());
		 
		  System.out.println("*********** Vos Création ********************");
		  for (Forme form : forme) {
			  
	             if (!Association.appartient(form.getNomForme())) {
	                form.affiche_forme();
	             }
	         }
		  System.out.println("*************************************** \n\n\n   ");

		
	}

}
