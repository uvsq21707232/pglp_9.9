package Abdelhafid.pglp_9_9.Command;

public class CommandExit implements Command {

	/**
	 * constructeur de la classe. 
	 */
	public  CommandExit() {
		
	}
	
	
	
	/**
	 * Fonction qui permet d'exucter la commande Exit pour terminé le programme. 
	 */
	public void execute() {
		
		System.out.println("Vous venez de quitter le programme , A trés bientot");
    	System.exit(0);
		
	}
	

}
