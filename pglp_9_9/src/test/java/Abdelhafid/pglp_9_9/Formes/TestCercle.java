package Abdelhafid.pglp_9_9.Formes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestCercle {
	
	Point p1 , p2;
    Cercle c;
	
	@Before()
	public void setUp() {
		
		Point p1=new Point(2,2);
		Point p2=new Point(5,5);
		
		c=new Cercle("ballon", p1, 10);

}
	
	
	@Test
	public void testCreation() {
			
		assertEquals( c.getNomForme(),"ballon");
		assertEquals( c.getRayon(),10);
		assertEquals( c.getCentre().getX(),2);
		assertEquals( c.getCentre().getY(),2);
	}
	
	@Test
	public void testMove() {
		
		c.move_Forme(1,1);
	
		assertEquals( c.getCentre().getX(),3);
		assertEquals( c.getCentre().getY(),3);
	}
	
	@Test
	public void testGet() {
		
	String nom= c.getNomForme();
	Point p=c.getCentre();
	int a= c.getRayon();
			
		assertEquals( c.getNomForme(),nom);
		assertEquals( c.getRayon(),a);
		assertEquals( c.getCentre().getX(),p.getX());
		assertEquals( c.getCentre().getY(),p.getY());
	}
	
	@Test
	public void testSET() {
		
		Point p= new Point(4,8);
	    c.setCentre(p);
	    c.setRayon(20);
		
		assertEquals( c.getNomForme(),"ballon");
		assertEquals( c.getRayon(),20);
		assertEquals( c.getCentre().getX(),p.getX());
		assertEquals( c.getCentre().getY(),p.getY());
	}
	
	

}
