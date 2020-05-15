package Abdelhafid.pglp_9_9.Formes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCarre {
	
	Point p1 , p2;
    Carre c;
	
	@Before()
	public void setUp() {
		
		Point p1=new Point(2, 2);
		Point p2=new Point(5, 5);
		
		c=new Carre("CARRE", p2, 10);

}
	
	
	@Test
	public void testCreation() {
			
		assertEquals( c.getNomForme(),"CARRE");
		assertEquals( c.getCote(),10);
		assertEquals( c.getCentre_carre().getX(),5);
		assertEquals( c.getCentre_carre().getY(),5);
	}
	
	@Test
	public void testMove() {
		
		c.move_Forme(1, 1);
			
		assertEquals( c.getNomForme(),"CARRE");
		assertEquals( c.getCote(),10);
		assertEquals( c.getCentre_carre().getX(),6);
		assertEquals( c.getCentre_carre().getY(),6);
	}
	@Test
	public void testget() {
		
	Point p=c.getCentre_carre();
	int a= c.getCote();
			
		assertEquals( c.getNomForme(),"CARRE");
		assertEquals( c.getCote(),a);
		assertEquals( c.getCentre_carre().getX(),p.getX());
		assertEquals( c.getCentre_carre().getY(),p.getY());
	}
	
	@Test
	public void testSET() {
		
		Point p= new Point(4,8);
	    c.setCentre_carre(p);
	    c.setCote(15);
		
		assertEquals( c.getNomForme(),"CARRE");
		assertEquals( c.getCote(),15);
		assertEquals( c.getCentre_carre().getX(),p.getX());
		assertEquals( c.getCentre_carre().getY(),p.getY());
	}
	
	
}
