package Abdelhafid.pglp_9_9.Formes;

public class Cercle extends Forme {
	
	/**
    * longueur du rayon du cercle.
    */
	private int rayon;
	
	/**
     * le centre du cercle.
     */
	Point centre;
	
	/**
	 * Constructeur de la class Cercle.
	 * @param nom Nom du Cercle.
	 * @param  centre le  point au centre du cercle.
	 * @param rayon la longueur du rayon.
	 */
	public Cercle(String nom, final Point centre, final int rayon) {
		super(nom);
		this.centre= centre.copie();
		this.rayon=rayon;
		
	}
	
	
	/**
     * Getter de la longueur du rayon.
     * @return la longueur du rayon.
     */

	public int getRayon() {
		return rayon;
	}


	/**
     * Setter de la longueur du rayon.
     * @param rayon La nouvelle longueur du rayon.
     */
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}


	 /** Getter du centre du cercle.
     * @return le point au centre du cercle.
     */
	public Point getCentre() {
		return centre;
	}

	/**
     * Setter du centre du cercle.
     * @param centre Le nouveau point du centre du cercle.
     */
	public void setCentre(Point centre) {
		this.centre = centre.copie();
	}

	/**
     * Fonction pour déplacer le cercle.
     * @param a la valeur à ajoutée à l'abscisse du centre du cercle.
     * @param b la valeur à ajoutée à l'ordonée du centre du cercle.
     **/
	public void move_Forme(final int a, final int b) {
		centre.move_point(a, b);
		
	}

	/**
     * Fonction pour l'affichage du cercle.
     */
	public void affiche_forme() {
		System.out.println("Cercle(centre=(" + centre.getX()
        + "," + centre.getY() + "),rayon=" + rayon + ")");
		
		
	}
	
	

}
