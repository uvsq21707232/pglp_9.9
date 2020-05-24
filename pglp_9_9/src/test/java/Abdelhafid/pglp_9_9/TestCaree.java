package Abdelhafid.pglp_9_9;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import Abdelhafid.pglp_9_9.Dao.CarreDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.CercleDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.Initializer;
import Abdelhafid.pglp_9_9.Dao.RectangleDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.TriangleDaoJdbc;
import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Composite;
import Abdelhafid.pglp_9_9.Formes.Forme;
import Abdelhafid.pglp_9_9.Formes.Point;
import Abdelhafid.pglp_9_9.Formes.Rectangle;
import Abdelhafid.pglp_9_9.Formes.Triangle;

public class TestCaree {
	
	/*@Test
	public void testCarre() {
		Point p1= new Point(2, 3);
		
		Carre c1 = new Carre("fenétre", p1, 5);
		c1.affiche_forme();
		
		c1.move_Forme("fenetre",3, 2);
		c1.affiche_forme();
		
	}

	
	@Test
	public void testCercle() {
		Point centre= new Point(3, 3);
		int rayon=50;
		
		Cercle c = new Cercle("kora", centre, rayon) ;
		c.affiche_forme();
		
		c.move_Forme("kora",-1, 2);
		c.affiche_forme();
		
	}
	
	@Test
	public void testrectangle() {
		Point depart= new Point(1,1);
		int longeur=50;
		int largeur=10;
		
	Rectangle r=new Rectangle("porte", depart, longeur, largeur);
	r.affiche_forme();
	
	r.move_Forme(null, 5, 5);
	r.affiche_forme();
	
		
	}
	@Test
	public void testtriangle() {
		
		Point sommet = new Point(5,5);
		Point gauche = new Point(2,1);
		Point droite = new Point(7,1);
		
		Triangle t = new Triangle("charpente", sommet, gauche, droite);
		t.affiche_forme();
		t.move_Forme( 2, 1);
		t.affiche_forme();
		
		
	}
	
	@Test
	public void testComposite() {
		Point p1=new Point(1, 1);
		Point p2=new Point(2, 5);
		Point p3=new Point(3, 4);
		Point p4=new Point(10, 20);
		
		Cercle c=new Cercle("korra", p1, 50);
		Rectangle r= new Rectangle("porte", p2, 40, 10);
		Triangle t = new Triangle("charpente", p3, p1, p2);
		Rectangle chambre= new Rectangle("chambre", p2, 50, 40);
		
		Composite groupe= new Composite("maison1");
		Composite groupe1= new Composite("chambre 1 ");
		
		groupe.add(c);
		groupe.add(r);
		groupe.add(t);
		
		
		groupe1.add(chambre);
		groupe.add(groupe1);
	
		groupe.delete(groupe1);
		groupe.affiche_forme();
		
		
		
		
	}
	
	@Test
	public void testCarréDaoJdbc() {
		Initializer init = new Initializer();
		
		Carre cCreate,cCreate1, Cfind;
		CarreDaoJdbc cJDBC = new CarreDaoJdbc();
		Point p1=new Point(2, 2);
		Point p2=new Point(5, 5);
		Point p3=new Point(10, 10);
		Point p4=new Point(20, 20);
		
		Carre c = new Carre("carre1", p1, 2);
		Carre c1 = new Carre("carre2", p2, 3);
		Carre c2 = new Carre("carre3", p3, 4);
		Carre c4 = new Carre("carre4", p3, 60);
		
	
		cCreate = cJDBC.Create(c);
	
		c.setCentre_carre(p4);
		c.setCote(20);
		cCreate= cJDBC.Update(c);
		
	
		
		init.Show_FORME();	
		init.Show_CARRE();
		
		
		
	

	}
	@Test
	public void testCercleDaoJdbc() {
		Initializer init = new Initializer();
		
		Cercle cCreate,Cfind;
		CercleDaoJdbc cJDBC = new CercleDaoJdbc();
		Point p1=new Point(2, 2);
		Point p2=new Point(5, 5);
		Point p3=new Point(10, 10);
		Point p4=new Point(20, 20);
		Cercle c =new Cercle("korra",p1,10);
		
		
		cCreate = cJDBC.Create(c);
		Cfind = cJDBC.Find(c.getNomForme());
		
		assertEquals(cCreate.getNomForme(),Cfind.getNomForme());
		c.setCentre(p4);
		c.setRayon(20);
		cCreate= cJDBC.Update(c);
		init.Show_CERCLE();
		
		init.Show_FORME();	
		
		

	}

	
	@Test
	public void testRectangleDaoJdbc() {
		Initializer init = new Initializer();
		
		Rectangle cCreate,Cfind,cCreate1;
		RectangleDaoJdbc cJDBC = new RectangleDaoJdbc();
		Point p1=new Point(2, 2);
		Point p2=new Point(5, 5);
		Point p3=new Point(10, 10);
		Point p4=new Point(20, 20);
		Rectangle r =new Rectangle("moustatil",p1,10,5);
		Rectangle r2 =new Rectangle("moustatil2",p2,20,25);
		
		
		cCreate = cJDBC.Create(r);
		//Cfind = cJDBC.Find(r.getNomForme());
		
		//assertEquals(cCreate.getNomForme(),Cfind.getNomForme());
		r.setCentre_rectangle(p4);
		r.setLongueur(20);
		r.setLargeur(25);
		cCreate= cJDBC.Update(r);
		cCreate1= cJDBC.Create(r2);
		
		
		
		
		
		init.Show_FORME();	
		init.Show_RECTANGLE();	
		
		// Test FindAll()
		for (Forme  forme : cJDBC.FindAll() ) {
	          forme.affiche_forme();
	        }
		

	}
	
	@Test
	public void testTriangleDaoJdbc() {
		Initializer init = new Initializer();
		
		
		 Triangle tCreate,tfind,tCreate1;
		TriangleDaoJdbc trDao = new TriangleDaoJdbc();
		Point p1=new Point(2, 2);
		Point p2=new Point(5, 5);
		Point p3=new Point(10, 10);
		Point p4=new Point(20, 20);
		Triangle t = new Triangle("charpente", p4,p1, p2);
		
		Triangle t1 = new Triangle("charpente1", p1,p2, p3);
		Triangle t2 = new Triangle("charpente2", p1,p3, p2);
		
		
		tCreate = trDao.Create(t);
		//tfind = trDao.Find(t.getNomForme());
		
		//assertEquals(tCreate.getNomForme(),tfind.getNomForme());
		t.setHaut(p1);
		t.setBas_gauche(p4);
		t.setBas_droite(p3);
	
		tCreate= trDao.Update(t);
		tCreate1=  trDao.Create(t1);
		
		init.Show_FORME();	
		init.Show_Triangle();	
		
		 //Test FindAll()
		for (Forme  forme : trDao.FindAll() ) {
	          forme.affiche_forme();
	        }
		

	}*/
		
		
	@Test
	public void showcarre() {
		Initializer init = new Initializer();
		init.Show_Triangle();
	

	}
	
}
