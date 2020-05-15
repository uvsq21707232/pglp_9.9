package Abdelhafid.pglp_9_9.Formes;

public abstract class Forme {
	
	 /**
     * Nom de la forme.
     */
	private String nomForme;
	
	/**
     * constructeur du nom.
     * @param nom.
     * attribuer un nom à la forme.
     */
	public Forme(String nom) {
		this.nomForme = nom;
	}
	
	/**
     * Getter du nomForme.
     * @return Le nom de la forme.
     */
	public String getNomForme() {
		return nomForme;
	}
	
	/**
     * Setter du nomForme.
     * @param nom Le nouveau nom de la forme.
     */
	public void setNomForme(String nom) {
		this.nomForme = nom;
	}
	
	/**
     * Fonction pour déplacer une forme.
     * @param a la valeur à ajoutée aux abscisses de la forme.
     * @param b la valeur à ajoutée aux ordonées de la forme.
     **/
    public abstract void move_Forme(int a, int b);
    
    /**
     * Fonction pour l'affichage de la forme.
     */
    public abstract void affiche_forme();

}
