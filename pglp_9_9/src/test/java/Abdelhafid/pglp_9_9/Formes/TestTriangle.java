package Abdelhafid.pglp_9_9.Formes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestTriangle {
	
	Point p1 , p2 , p3;
    Triangle tri;
	
	@Before()
	public void setUp() {
		
		 p1=new Point(3,3);
		 p2=new Point(4,4);
		 p3=new Point(5,5);
		 tri = new Triangle("triangle", p3, p1,p2);

}
	
	@Test
	public void testCreation() {
			
		assertEquals( tri.getNomForme(),"triangle");
		
		assertEquals(tri.getHaut().getX(),p3.getX());
		assertEquals(tri.getHaut().getY(),p3.getY());
		
		assertEquals(tri.getBas_gauche().getX(),p1.getX());
		assertEquals(tri.getBas_gauche().getY(),p1.getY());
		
		
		assertEquals(tri.getBas_droite().getX(),p2.getX());
		assertEquals(tri.getBas_droite().getY(),p2.getY());
		
	
	}
	
	@Test
	public void testMove() {
		
		tri.move_Forme(1, 1);
		
		assertEquals(tri.getHaut().getX(),6);
		assertEquals(tri.getHaut().getY(),6);
		
		assertEquals(tri.getBas_gauche().getX(),4);
		assertEquals(tri.getBas_gauche().getY(),4);
		
		
		assertEquals(tri.getBas_droite().getX(),5);
		assertEquals(tri.getBas_droite().getY(),5);
		
	}
		
	@Test
	public void testGet() {
		
	String nom= tri.getNomForme();
	Point p1=tri.getHaut();
	Point p2=tri.getBas_gauche();
	Point p3=tri.getBas_droite();
	
	assertEquals( tri.getNomForme(),nom);
	assertEquals(tri.getHaut().getX(),p1.getX());
	assertEquals(tri.getHaut().getY(),p1.getY());
	
	assertEquals(tri.getBas_gauche().getX(),p2.getX());
	assertEquals(tri.getBas_gauche().getY(),p2.getY());
	
	
	assertEquals(tri.getBas_droite().getX(),p3.getX());
	assertEquals(tri.getBas_droite().getY(),p3.getY());
	
	
	}
	@Test
	public void testSET() {
		
		Point p1= new Point(3,8);
		Point p2= new Point(5,3);
		Point p3= new Point(7,4);
		tri.setHaut(p3);
		tri.setBas_gauche(p2);
		tri.setBas_droite(p1);

		assertEquals(tri.getHaut().getX(),p3.getX());
		assertEquals(tri.getHaut().getY(),p3.getY());
		
		assertEquals(tri.getBas_gauche().getX(),p2.getX());
		assertEquals(tri.getBas_gauche().getY(),p2.getY());
		
		
		assertEquals(tri.getBas_droite().getX(),p1.getX());
		assertEquals(tri.getBas_droite().getY(),p1.getY());
		
	}
	

}
