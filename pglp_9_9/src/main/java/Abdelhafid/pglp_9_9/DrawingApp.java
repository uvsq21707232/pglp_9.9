package Abdelhafid.pglp_9_9;

import java.sql.SQLException;
import java.util.Scanner;

import Abdelhafid.pglp_9_9.Command.Command;
import Abdelhafid.pglp_9_9.Command.DrawingTUI;
import Abdelhafid.pglp_9_9.Dao.Initializer;
import Abdelhafid.pglp_9_9.Dao.TableExist;

public class DrawingApp {
	/**
	 * Scanner.
	 */
	private Scanner clavier;
	
	private DrawingTUI  drawing;
	/**
	 * constructeur de la classe.
	 */
	public DrawingApp(){
		 drawing = new DrawingTUI();
       clavier = new Scanner(System.in);
	}
	/**
	 * Cataloque des commandes possible à saisir.
	 */
	
	public void Catalogue() {
	System.out.println("**********Catalogue de commande possible ********* :\n"
			
			    + "******************************************************************* \n"
				+ " 1- Pour créer un Carre veuillez taper : \n"
				+ " nom = Carre((valeur, valeur), valeur)\n"
				+ " exemple de Création : c1 = Carre((5,9),15) \n"
				+ " 2- Pour deplacer un Carre veuillez taper : \n"
				+ " move(nomCarre,(x,y) \n"
				+ " exemple  de deplacement : move(c1,(5,1)) \n"
				+ " 3- Pour supprimer un Carre veuillez taper : \n"
				+ " delete(nomCarre) \n"
				+ " exemple  de suppression: delete(c1) \n"
				+ "*******************************************************************\n"
				+ " 1- Pour créer un Cercle veuillez taper : \n"
				+ " nom = Cercle((valeur, valeur), valeur)\n"
				+ " exemple de Création : c2 = Cercle((5,9),15) \n"
				+ " 2- Pour deplacer un Carre veuillez taper : \n"
				+ " move(nomCercle,(x,y) \n"
				+ " exemple  de deplacement : move(c2,(5,1)) \n"
				+ " 3- Pour supprimer un Cercle veuillez taper : \n"
				+ " delete(nomCercle) \n"
				+ " exemple  de suppression : delete(c2) \n"
				+ "********************************************************************** \n"
				+ " 1- Pour créer un Rectangle veuillez taper : \n"
				+ " nom = Carre((valeur, valeur), longeur, largeur)\n"
				+ " exemple de vréation : r1 = Rectangle((5,9),15,10) \n"
				+ " 2- Pour deplacer un Rectangle veuillez taper : \n"
				+ " move(nomRectagle,(x,y) \n"
				+ " exemple  de deplacement : move(r1,(5,1)) \n"
				+ " 3- Pour supprimer un Rectangle veuillez taper : \n"
				+ " delete(nomRectangle) \n"
				+ " exemple  de suppression : delete(r1) \n"
				+ "********************************************************************\n"
				+ " 1- Pour créer un Triangle veuillez taper : \n"
				+ " nom = Triangle((valeur, valeur), (valeur, valeur), (valeur, valeur))\n"
				+ " exemple de Création :  t10 = Triangle((5, 8), (7, 3), (4, 0)) \n"
				+ " 2- Pour deplacer un Triangle veuillez taper : \\n"
				+ " move(nomtriangle,(x,y) \n"
				+ " exemple de deplacement : move(t10,(5,1)) \n"
				+ " 3- Pour supprimer un Triangle veuillez taper : \n"
				+ " delete(nomTriangle ) \n"
				+ " Exemple  de suppression : delete(t10) \n"
				+ "********************************************************** \n"
				+ " 1- Pour créer un groupe veuillez taper : \n"
				+ " nom = Groupe((forme1, forme2, ...) ) \n"
				+ " Exemple de Création :  g1 = Groupe(c1, c2) \n"
				+ " 2- Pour deplacer un groupe veuillez taper : \n"
				+ " move(nomGroupe,(x,y) \n"
				+ " Exemple de deplacement : move(g1,(5,1)) \n"
				+ " 3- Pour supprimer un Groupe veuillez taper : \n"
				+ " delete(nomGroupe) ou delete(forme1, forme2, ...) \n"
				+ " Exemple  de suppression : delete(g1) ou delete(c1,c2) \n"
				+ "************************************************************ \n"
				
			);
		
	}
	
	
	public static void main(final String[] args) throws SQLException, TableExist {
		Initializer init = new Initializer();
		
		init.supprimerAllTables();
		init.CreateAllTables();
		
		DrawingApp app = new DrawingApp();
        app.run();
			
	}
	
	public void run() {

		Catalogue();
		
		System.out.println("  Saisissez votre commande :");
		
		 String input = clavier.nextLine();
		 
		 Command cmd;
	        while (!input.equals("exit")) {
	            cmd = drawing.nextCommand(input);
	            
	            if (cmd != null){   	
	                cmd.execute();
	                
	                drawing.dessiner();
	                
	            }
	            System.out.println(" Saisissez une nouvelle commande : ");
	            input = clavier.nextLine();
	        }
	}
	
	
	
	
}
