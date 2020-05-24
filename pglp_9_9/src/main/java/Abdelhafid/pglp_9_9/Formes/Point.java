package Abdelhafid.pglp_9_9.Formes;

import java.io.CharConversionException;

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
     * @param ordonnee Valeur en ordonnée du point.
     */
    public Point(final int abscisse, final int ordonnee) {
        this.x = abscisse;
        this.y = ordonnee;
    }
    
    /**
     * Constructeur de Point .
     * @param chaine une chaine de caracteres.
     * @throws CharConversionException.
     */
	public Point(String chaine) throws CharConversionException {

		chaine.replace(" ", "");
		if (chaine.charAt(0) != '(' || chaine.charAt(chaine.length() - 1) != ')') {
			System.err.println(chaine);
		}

		String point = chaine.substring(1, chaine.length() - 1);
		String[] split = point.split(",");
		if (split.length != 2) {

			System.err.println(chaine);
			throw new CharConversionException();
		}

		try {
			this.x = Integer.parseInt(split[0]);
			this.y = Integer.parseInt(split[1]);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw e;
		}

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
     * @return La valeur de l'ordonnée.
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

		this.x += abs;
		this.y += ord;
	}
	
    /**
    *Fonction d'affichage des coordonnées du point.
    *@return chaine de caractéres.
    */

	public String toString() {
		return " Point(" + x + "," + y + ")";

	}

}
