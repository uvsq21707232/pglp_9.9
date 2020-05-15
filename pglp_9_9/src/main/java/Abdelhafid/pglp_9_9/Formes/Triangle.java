package Abdelhafid.pglp_9_9.Formes;

public class Triangle extends Forme {
	
	
	/**
     * point au sommet du triangle .
     */
	private Point haut;
	
	/**
     * point bas_gauche du triangle.
     */
	private Point bas_gauche;
	
	/**
    * point bas_droite du triangle.
    */
	private Point bas_droite;
	
	/**
	 * Constructeur de la class triangle.
	 * @param nom Nom du triangle.
	 * @param haut le point au sommet du triangle.
	 * @param bas_gauche le point bas_gauche du trinagle.
	 * @param bas_droite le point bas_droite du trinagle.
	 */
	public Triangle(String nom, final Point haut,final Point bas_gauche, final Point bas_droite) {
		super(nom);
		this.haut=haut.copie();
		this.bas_gauche=bas_gauche.copie();
		this.bas_droite=bas_droite.copie();
		
	}

	/**
     * Fonction pour déplacer le triangle.
     * @param a la valeur à ajoutée aux abscisses des points constituant le triangle.
     * @param b la valeur à ajoutée aux ordonées des point points constituant le triangle.
     **/
	public void move_Forme(final int a, final int b) {
		haut.move_point(a, b);
		bas_gauche.move_point(a, b);
		bas_droite.move_point(a, b);
		
	}

	/**
     * Fonction pour l'affichage du triangle.
     */
	public void affiche_forme() {
		System.out.println("Triangle(point_haut=(" + haut.getX()
        + "," + haut.getY() + "), point_bas_gauche=(" + bas_gauche.getX()+ "," + bas_gauche.getY()
        +"), point_bas_droite=(" + bas_droite.getX() + "," + bas_droite.getY() + "))");
	
		
	}


	/**
     * Getter du point sommet du triangle.
     * @return le point sommet du triangle.
     */
	public Point getHaut() {
		return haut;
	}
	
	/**
     * Setter du point le plus haut du triangle.
     * @param haut Le nouveau point au sommet du triangle.
     */
	public void setHaut(Point haut) {
		this.haut = haut;
	}


	/**
     * Getter du point bas_gauche du triangle.
     * @return le point bas_gauche du triangle.
     */
	public Point getBas_gauche() {
		return bas_gauche;
	}

	/**
     * Setter du point bas_gauche du triangle.
     * @param bas_gauche Le nouveau point bas_gauche du triangle.
     */
	public void setBas_gauche(Point bas_gauche) {
		this.bas_gauche = bas_gauche;
	}

	/**
     * Getter du point bas_droite du triangle.
     * @return le point bas_droite du triangle.
     */
	public Point getBas_droite() {
		return bas_droite;
	}

	/**
     * Setter du point bas_droite du triangle.
     * @param bas_droite Le nouveau point bas_droite du triangle.
     */
	public void setBas_droite(Point bas_droite) {
		this.bas_droite = bas_droite;
	}

}
