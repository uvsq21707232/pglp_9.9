package Abdelhafid.pglp_9_9.Command;

import Abdelhafid.pglp_9_9.Dao.CarreDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.CercleDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.DaoFactory;
import Abdelhafid.pglp_9_9.Dao.GroupeDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.RectangleDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.TriangleDaoJdbc;
import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Composite;
import Abdelhafid.pglp_9_9.Formes.Forme;
import Abdelhafid.pglp_9_9.Formes.Rectangle;
import Abdelhafid.pglp_9_9.Formes.Triangle;
/**
 * la classe CommandMove.
 */
public class CommandMove implements Command {
	/**
     * la forme a deplacer.
     */
    private Forme forme; 
    /**
     * Valeur a deplacer l'abscisse.
     */
    private int X;  
    /**
     * Valeur a deplacer l'ordonnée.
     */
    private int Y; 
    /**
     * Constructeur de la classe.
     * @param f La forme a deplacer.
     * @param x Valeur a deplacer l'abscisse.
     * @param y Valeur a deplacer l'ordonnée
     */
	public CommandMove(Forme f, int x, int y) {

		this.forme = f;
		this.X = x;
		this.Y = y;
	}   
    /**
	 * Fonction qui exécute une commande pour deplacer une objet 
	 * selon le type de forme.
	 */
	@Override
	public void execute() {

		DaoFactory fabrique = new DaoFactory();

		forme.move_Forme(X, Y);

		if (this.forme instanceof Carre) {

			CarreDaoJdbc carredao = (CarreDaoJdbc) fabrique.getCarreDaoJdbc();
			carredao.Update((Carre) forme);

		} else if (this.forme instanceof Cercle) {

			CercleDaoJdbc cercleDao = (CercleDaoJdbc) fabrique.getCercleDaoJdbc();
			cercleDao.Update((Cercle) forme);

		} else if (this.forme instanceof Rectangle) {
			RectangleDaoJdbc rectangleDao = (RectangleDaoJdbc) fabrique.getRectangleDaoJdbc();
			rectangleDao.Update((Rectangle) forme);

		} else if (this.forme instanceof Triangle) {
			TriangleDaoJdbc triangleDao = (TriangleDaoJdbc) fabrique.getTriangleDaoJdbc();
			triangleDao.Update((Triangle) forme);

		} else if (this.forme instanceof Composite) {
			GroupeDaoJdbc grpDao = (GroupeDaoJdbc) fabrique.getGroupeDaoJdbc();
			grpDao.Update((Composite) forme);

		}

	}

}
