package Abdelhafid.pglp_9_9.Formes;

public class Point {
	/**
     * Valeur de l'abscisse du point.
     */
    private int x;
    /**
     * Valeur de l'ordonnée du point.
     */
    private int y;
    
    /**
     * Constructeur par défaut du Point.
     */
    public Point() {
      this.x = 0;
      this.y = 0;
    }
    /**
     * Constructeur.
     * @param abscisse Valeur en abscisse du point.
     * @param ord Valeur en ordonnée du point.
     */
    public Point(final int abscisse, final int  ordonnee) {
        this.x = abscisse;
        this.y = ordonnee;
    }
    
    /**
     * Getter de x.
     * @return La valeur de l'abscisse.
     */
    public int getX() {
        return x;
    }
    /**
     * Getter de y.
     * @returnLa valeur de l'ordonnée.
     */
    public int getY() {
        return y;
    }
    /**
     * Setter de x.
     * @param abs La nouvelle valeur de l'abscisse.
     */
    public void setX(final int abs) {
        this.x = abs;
    }
    /**
     * Setter de y.
     * @param ord La nouvelle valeur de l'ordonnée.
     */
    public void setY(final int ord) {
        this.y = ord;
    }
   
    
    /**
     *  Fonction qui Copie un point.
     * @return Le point copié.
     */
    public Point copie() {
        return new Point(this.x, this.y);
    }
    
    /**
     * Fonction pour déplacer un point.
     * @param abs valeur ajoutée à l'abscisse initiale.
     * @param ord valeur ajoutée  à l'ordonnée initiale.
     */
    public void move_point(final int abs, final int ord) {
    	
    	this.x +=abs;
    	this.y +=ord;
    }
    /**
    *Fonction d'affichage des coordonnées du point.
    *@return chaine de caractéres.
    */
    
    public String toString() {
		return  " Point(" + x + "," + y + ")"; 

    	
    }
    
    
    
}
