package Abdelhafid.pglp_9_9.Formes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestRectangle {
	
	Point p1 , p2;
    Rectangle rec;
	
	@Before()
	public void setUp() {
		
		Point p1=new Point(3,3);
		rec= new Rectangle("porte", p1, 15, 10);

}
	
	
	@Test
	public void testCreation() {
			
		assertEquals( rec.getNomForme(),"porte");
		assertEquals( rec.getLongueur(),15);
		assertEquals( rec.getLargeur(),10);
		assertEquals( rec.getCentre_rectangle().getX(),3);
		assertEquals( rec.getCentre_rectangle().getY(),3);
	}
	
	@Test
	public void testMove() {
		
		rec.move_Forme(2, 2);
	
		assertEquals( rec.getCentre_rectangle().getX(),5);
		assertEquals( rec.getCentre_rectangle().getY(),5);
	}
	
	@Test
	public void testGet() {
		
	String nom= rec.getNomForme();
	Point p=rec.getCentre_rectangle();
	int a= rec.getLongueur();
	int b= rec.getLargeur();
			
		assertEquals( rec.getNomForme(),nom);
		assertEquals( rec.getLongueur(),a);
		assertEquals( rec.getLargeur(),b);
		assertEquals( rec.getCentre_rectangle().getX(),p.getX());
		assertEquals( rec.getCentre_rectangle().getY(),p.getY());
	}
	
	@Test
	public void testSET() {
		
		Point p= new Point(5,10);
	    rec.setCentre_rectangle(p);
	    rec.setLongueur(30);
	    rec.setLargeur(25);
		
	  
		assertEquals( rec.getLongueur(),30);
		assertEquals( rec.getLargeur(),25);
		assertEquals( rec.getCentre_rectangle().getX(),p.getX());
		assertEquals( rec.getCentre_rectangle().getY(),p.getY());
	}
	
	

}
