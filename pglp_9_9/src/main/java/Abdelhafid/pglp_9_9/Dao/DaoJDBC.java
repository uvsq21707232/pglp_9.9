package Abdelhafid.pglp_9_9.Dao;

import java.util.ArrayList;

public interface DaoJDBC<T> {
	
	/**
     * Ajouter un objet.
     * @param t L'objet à ajouter.
     * @return L'objet crée.
     */
	 T Create(T object) ;

	 /**
	  * rechercher un objet.
	  * @param nom Le nom de l'objet à rechercher.
	  * @return L'objet si trouvé.
	  */
	 T Find(String nom);
	 
	 /**
	  * rechercher tous les objets.
	  * @return  tous les objets si trouvés.
	  */
	 ArrayList<T> FindAll();
	 
	 /**
	 * Modifier un objet.
	 * @param t L'objet à modifier.
	 * @return L'objet modifié.
	 */
	 T Update(T object);
	 
	 /**
     * supprimer un objet.
	 * @param t L'objet à supprimer.
     */	 
	 void delete(T obj);

	
	

}
