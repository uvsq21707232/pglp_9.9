package Abdelhafid.pglp_9_9.Formes;

import java.util.ArrayList;
import java.util.Iterator;

/**
* Pattern Composite.
*/
public class Composite extends Forme implements Iterable<Forme>{
	/**
    * Liste des formes.
    */
	private ArrayList<Forme> listFormes;
	
	 /**
     * constructeur du composite.
     * @param nom nom du composite.
     */      
	public Composite(String nom) {
		super(nom);
		this.listFormes = new ArrayList<Forme>();

	}
	
	 /**
     * Fonction pour déplacer les formes du groupe.
     * @param a la valeur à ajoutée aux abscisses de la forme.
     * @param b la valeur à ajoutée aux ordonées de la forme.
     **/
	public void move_Forme(final int a, final int b) {
		for (Forme forme : this.listFormes) {
			forme.move_Forme(a, b);
		}
	}

	 /**
     * Fonction pour l'affichage des formes du composite.
     */
	public void affiche_forme() {
		System.out.println("Composite(" + this.getNomForme() + ":");
		for (Forme forme : this.listFormes) {
			forme.affiche_forme();
		}

		System.out.println(")");
	}

	 /**
     * ajoute une forme ou un groupe au groupe.
     * @param forme la forme ou groupe à ajouter au groupe.
     */
	public void add(final Forme forme) {
		if (!this.listFormes.contains(forme) && forme != this) {
			this.listFormes.add(forme);
		}
	}
    
     /**
     * supprimer une forme ou un composite contenu dans le composite.
     * @param forme f la orme ou groupe à supprimer du composite.
     */
	public void delete(final Forme forme) {
		if (this.listFormes.contains(forme)) {
			this.listFormes.remove(forme);
		}
	}
    
     /**
     * supprimer  toutes les formes et groupes du composite.
     */
	public void deleteAll() {
		while (!this.listFormes.isEmpty()) {
			this.listFormes.remove(0);
		}
	}
    
     /**
     *  la liste des formes et groupes du groupe.
     * @return la liste des formes et groupes contenu dans le groupe.
     */
	@SuppressWarnings("unchecked")
	public ArrayList<Forme> getAllFormes() {
		return (ArrayList<Forme>) this.listFormes.clone();
	}

    /** 
    * Itérateur de la liste des formes du Composite.
    * @return L'iterateur de la liste des formes du Composite.
    */
	public Iterator<Forme> iterator() {

		return this.listFormes.iterator();
	}

}
