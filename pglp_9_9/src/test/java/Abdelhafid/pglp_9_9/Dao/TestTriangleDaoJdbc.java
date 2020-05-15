package Abdelhafid.pglp_9_9.Dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Abdelhafid.pglp_9_9.Formes.Point;

import Abdelhafid.pglp_9_9.Formes.Triangle;

public class TestTriangleDaoJdbc {
	
	
Point p1,p2,p3;
Triangle t,t1,t2,create,create1,find;
TriangleDaoJdbc triDao;
 
 @Before()
	public void setUp() {
		
		Point p1=new Point(1, 1);
		Point p2=new Point(2, 2);
		Point p3=new Point(5, 5);
		
		t= new Triangle("tri", p3, p1, p2);
		t1= new Triangle("tri1", p1, p2, p3);
		t2= new Triangle("tri2", p2, p3, p1);
		 
		triDao= new TriangleDaoJdbc();
		
 }
 @Test
	 public void testCreation() {
	 
	 create = triDao.Create(t);
	 assertEquals( create.getNomForme(),t.getNomForme());
	 assertEquals( create.getHaut().getX(),t.getHaut().getX());
	 assertEquals( create.getHaut().getY(),t.getHaut().getY());
	 assertEquals( create.getBas_gauche().getX(),t.getBas_gauche().getX());
	 assertEquals( create.getBas_gauche().getY(),t.getBas_gauche().getY());
	 assertEquals( create.getBas_droite().getX(),t.getBas_droite().getX());
	 assertEquals( create.getBas_droite().getY(),t.getBas_droite().getY());
	 
	 
	 
 }
 @Test
	public void testFind() {
	
		create= triDao.Create(t);
		
		 find=triDao.Find(create.getNomForme());
		 
		 assertEquals( create.getNomForme(),find.getNomForme());
		 assertEquals( create.getHaut().getX(),find.getHaut().getX());
		 assertEquals( create.getHaut().getY(),find.getHaut().getY());
		 assertEquals( create.getBas_gauche().getX(),find.getBas_gauche().getX());
		 assertEquals( create.getBas_gauche().getY(),find.getBas_gauche().getY());
		 assertEquals( create.getBas_droite().getX(),find.getBas_droite().getX());
		 assertEquals( create.getBas_droite().getY(),find.getBas_droite().getY());
		 
		
 
 }		

 @Test
 public void testUpdate() {
	 
	 Point p11 = new Point(50,45);
	 Point p22 = new Point(13,10);
	 Point p33 = new Point(25,10);
	 
	 create1= triDao.Create(t1);
	 
	 t1.setHaut(p11);
	 t1.setBas_gauche(p22);
	 t1.setBas_droite(p33);
	 assertEquals( create1.getNomForme(),t1.getNomForme());
	 assertEquals( create1.getHaut().getX(),t1.getHaut().getX());
	 assertEquals( create1.getHaut().getY(),t1.getHaut().getY());
	 assertEquals( create1.getBas_gauche().getX(),t1.getBas_gauche().getX());
	 assertEquals( create1.getBas_gauche().getY(),t1.getBas_gauche().getY());
	 assertEquals( create1.getBas_droite().getX(),t1.getBas_droite().getX());
	 assertEquals( create1.getBas_droite().getY(),t1.getBas_droite().getY());
	 
	  
 }
 
 @Test
 public void testdelete() {
 	
 	Triangle create2,find2;
 	create2= triDao.Create(t2);
 	triDao.delete(t2);
 	find2=triDao.Find(create2.getNomForme());
 		assertEquals(find2,null);
 	
 	}
 
 @Test
 public void testFindAll() {
	 triDao.delete(t);
	 triDao.delete(t1);
 	
 	 create=triDao.Create(t);
 	 Triangle create1= triDao.Create(t1);
 	 
 	assertEquals(triDao.FindAll().size(),2);
 	
 	triDao.delete(t);
 	triDao.delete(t1);
 	triDao.delete(t2);
 	assertEquals(triDao.FindAll().size(),0);
 
 
 
 
 
 }
}
