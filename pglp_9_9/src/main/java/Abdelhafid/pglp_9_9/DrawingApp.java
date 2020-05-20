package Abdelhafid.pglp_9_9;

import java.sql.SQLException;
import java.util.Scanner;

import Abdelhafid.pglp_9_9.Command.Command;
import Abdelhafid.pglp_9_9.Command.DrawingTUI;

public class DrawingApp {
	
	private Scanner clavier;
	
	private DrawingTUI  drawing;
	
	/**
	 * constructeur de la classe
	 */
	public DrawingApp(){
		 drawing = new DrawingTUI();
       clavier = new Scanner(System.in);
	}

	
	public void Catalogue() {
	System.out.println("**********Catalogue de commande possible ********* :\n"
			    + "***************************************** \n"
				+ " 1- Pour créer un Carre veuillez taper : \n"
				+ " nom = Carre((valeur, valeur), valeur)\n"
				+ " exemple de vréation : c1 = Carre((5,9),15) \n"
				+ " 1- Pour deplacer un Carre veuillez taper : \\n"
				+ " move(nomCarre,(x,y) \n"
				+ " exemple  de deplacement : move(c1,(5,1)) \n"
				+ "***************************************** \n"
				);
		
	}
	
	
	public static void main(final String[] args) throws SQLException {
		
		DrawingApp app = new DrawingApp();
        app.run();
			
	}
	
	public void run() {

		Catalogue();
		
		System.out.println(" vous pouvez saisir désormais votre commande :");
		
		 String input = clavier.nextLine();
		 
		 Command cmd;
	        while (true) {
	            cmd = drawing.nextCommand(input);
	            
	            if (cmd != null){   	
	                cmd.execute();
	                
	                drawing.dessiner();
	                
	            }
	            System.out.println(" nouvelle commande : ");
	            input = clavier.nextLine();
	        }
	}
	
	
	
	
}
