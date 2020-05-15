package Abdelhafid.pglp_9_9.Formes;

public class Carre extends Forme {
	
	/**
     * longueur du coté du carré.
     */
	private int cote;
	/**
     * point au centre du carré .
     */
	Point centre_carre;
	
	/**
     * Getter de la longueur de la côte du carré.
     * @return la longueur.
     */
	public int getCote() {
		return cote;
	}

	/**
     * Setter de la longueur de la côte du carré.
     * @param cote La nouvelle longueur de la côte du carré.
     */
	public void setCote(int cote) {
		this.cote = cote;
	}
	
	/**
     * Getter du point au centre du carre.
     * @return le point au centre du carre.
     */
	public Point getCentre_carre() {
		return this.centre_carre;
	}

	/**
     * Setter du point au centre du carré.
     * @param centre Le nouveau point au centre  du carré.
     */
	public void setCentre_carre(Point centre) {
		this.centre_carre = centre.copie();
	}

	/**
	 * Constructeur de la class Carre.
	 * @param nom Nom du carré.
	 * @param centre le  point de depart bas_gauche.
	 * @param longeur la longueur de la côte.
	 */
	public Carre(String nom,final Point centre, final int cote){
		super(nom);
		this.centre_carre= centre.copie();
		this.cote=cote;	
	}
	
	/**
     * Fonction pour déplacer le carré.
     * @param a la valeur à ajoutée à l'abscisse du point bas_gauche du carré.
     * @param b la valeur à ajoutée à l'ordonées du point bas_gauche du carré.
     **/
	public void move_Forme(final int a,final int b) {
		centre_carre.move_point(a, b);
	}

	/**
     * Fonction pour l'affichage du carré.
     */
	public void affiche_forme() {
		
		System.out.println("Carre(point_centre=(" + centre_carre.getX()
        + "," + centre_carre.getY() + "),Côte=" + cote + ")");
		
	}

}
