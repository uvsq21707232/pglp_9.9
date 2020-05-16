package Abdelhafid.pglp_9_9.Dao;

import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Composite;
import Abdelhafid.pglp_9_9.Formes.Rectangle;
import Abdelhafid.pglp_9_9.Formes.Triangle;

public  class  DaoFactory {
	
	/**
     * Crée un CarreDaoJdbc.
     * @return  CareeDaoJdbc crée.
     */
	public  DaoJDBC<Carre> getCarreDaoJdbc () {
		return new CarreDaoJdbc();
		
		}
	
	/**
     * Crée un CercleDaoJdbc.
     * @return  CercleDaoJdbc crée.
     */
	public  DaoJDBC<Cercle> getCercleDaoJdbc () {
		return new CercleDaoJdbc();
		
		}
	
	/**
     * Crée un TriangleDaoJdbc.
     * @return  TriangleDaoJdbc crée.
     */
	public  DaoJDBC<Triangle> getTriangleDaoJdbc () {
		return new TriangleDaoJdbc();
		
		}
	
	/**
     * Crée un RectangleDaoJdbc.
     * @return  RectangleDaoJdbc crée.
     */
	public  DaoJDBC<Rectangle> getRectangleDaoJdbc () {
		return new RectangleDaoJdbc();
		
		}
	/**
     * Crée un GroupeDaoJdbc.
     * @return  GroupeDaoJdbc crée.
     */
	public  DaoJDBC<Composite>  getGroupeDaoJdbc (){
		return new GroupeDaoJdbc() ;
		
		}
	
}
