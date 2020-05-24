package Abdelhafid.pglp_9_9.Command;

import java.util.ArrayList;

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
 * la classe CommandRemove.
 */
public class CommandRemove implements Command {
	/**
     * la liste de formes a supprimer.
     */
	private ArrayList<Forme> list_forme;
	/**
    * Constructeur de la classe.
    * @param list La liste de formes à supprimer.
    */
   public CommandRemove(ArrayList<Forme> list) {
	   this.list_forme=list;
	   
   }
     /**
	 * Fonction qui exécute une commande pour supprimer les formes.
	 */
	@Override
	public void execute() {

		DaoFactory fabrique = new DaoFactory();

		for (Forme forme : list_forme)

			if (forme instanceof Carre) {

				CarreDaoJdbc carredao = (CarreDaoJdbc) fabrique.getCarreDaoJdbc();
				carredao.delete((Carre) forme);

			} else if (forme instanceof Cercle) {

				CercleDaoJdbc cercleDao = (CercleDaoJdbc) fabrique.getCercleDaoJdbc();
				cercleDao.delete((Cercle) forme);

			} else if (forme instanceof Rectangle) {
				RectangleDaoJdbc rectangleDao = (RectangleDaoJdbc) fabrique.getRectangleDaoJdbc();
				rectangleDao.delete((Rectangle) forme);

			} else if (forme instanceof Triangle) {
				TriangleDaoJdbc triangleDao = (TriangleDaoJdbc) fabrique.getTriangleDaoJdbc();
				triangleDao.delete((Triangle) forme);

			} else if (forme instanceof Composite) {
				GroupeDaoJdbc grpDao = (GroupeDaoJdbc) fabrique.getGroupeDaoJdbc();
				grpDao.delete((Composite) forme);

			}
	}

}
