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

public class CommandCreate implements Command {
	
	/**
	 *  la forme a créer.
	 */
      private Forme forme;
      
     /**
  	 *  Constructeur de la classe.
  	 * @param la forme a créer.
  	 */
	public  CommandCreate(Forme f) {
		this.forme=f;
		
	}
	
	/**
	 * Fonction qui exécute une commande pour créer un objet 
	 * selon le type de forme.
	 */
	
	@Override
	public void execute() {
		
	
		DaoFactory fabrique=  new DaoFactory();
		Forme form = null;
		if(this.forme instanceof Carre) {
        
            	CarreDaoJdbc carredao=(CarreDaoJdbc) fabrique.getCarreDaoJdbc();
            	 form=carredao.Create((Carre) forme);
            	 
        		}else if (this.forme instanceof Cercle){
        			
        			CercleDaoJdbc cercleDao = (CercleDaoJdbc) fabrique.getCercleDaoJdbc();
        			form = cercleDao.Create((Cercle) forme);
        			
        		}else if (this.forme instanceof Rectangle){
        			RectangleDaoJdbc rectangleDao = (RectangleDaoJdbc) fabrique.getRectangleDaoJdbc();
        			form = rectangleDao.Create((Rectangle) forme);
        			
        		}else if (this.forme instanceof Triangle){
        			TriangleDaoJdbc triangleDao = (TriangleDaoJdbc ) fabrique.getTriangleDaoJdbc();
        			form = triangleDao.Create((Triangle) forme);
        			
        		}else if (this.forme instanceof Composite){
        			GroupeDaoJdbc grpDao=(GroupeDaoJdbc) fabrique.getGroupeDaoJdbc();
        			form = grpDao.Create((Composite) forme);
        			
        		}
		
		
		
		
		
	}

}
