package Abdelhafid.pglp_9_9.Formes;

public class Rectangle extends Forme {
	
	/**
     * point au centre du rectangle .
     */
	private Point centre_rectangle;
	
	/**
    * longueur du réctangle .
    */
	private int longueur;
	
	/**
	* largeur du réctangle .
	*/
	private int largeur;
	
	/**
	 * Constructeur de la class Rectangle.
	 * @param nom Nom du Rectangle.
	 * @param centre le point au centre du rectangle.
	 * @param longueur la longueur du réctangle.
	 * @param largeur la largeur du réctangle.
	 */
	public Rectangle(String nom, final Point centre, final int longueur, final int largeur) {
		super(nom);
		this.centre_rectangle = centre.copie();
		this.longueur = longueur;
		this.largeur = largeur;

	}

	/**
     * Fonction pour déplacer le rectangle.
     * @param a la valeur à ajoutée à l'abscisse du point bas_gauche du rectangle.
     * @param b la valeur à ajoutée à l'ordonée du point bas_gauche du rectangle.
     **/
	public void move_Forme(final int a, final int b) {
		centre_rectangle.move_point(a, b);

	}

	/**
     * Fonction pour l'affichage du rectangle.
     */
	public void affiche_forme() {
		System.out.println("Réctangle(centre=(" + centre_rectangle.getX() + "," + centre_rectangle.getY()
				+ "), longueur=" + longueur + ", largeur=" + largeur + ")");

	}

	/**
     * Getter du point au centre du rectangle.
     * @return le point au centre du rectangle.
     */
	public Point getCentre_rectangle() {
		return centre_rectangle;
	}

	/**
     * Setter du point au centredu rectangle.
     * @param centre Le nouveau point au centre du rectangle.
     */
	public void setCentre_rectangle(Point centre) {
		this.centre_rectangle = centre.copie();
	}

	/**
     * Getter de la longueur du rectangle.
     * @return la longueur.
     */
	public int getLongueur() {
		return longueur;
	}

	/**
     * Setter de la longueur du rectangle.
     * @param longueur La nouvelle longueur du rectangle.
     */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	/**
     * Getter de la largeur du rectangle.
     * @return la largeur.
     */
	public int getLargeur() {
		return largeur;
	}

	/**
     * Setter de la largeur du rectangle.
     * @param largeur La nouvelle largeur du rectangle.
     */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	

}
