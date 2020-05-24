package Abdelhafid.pglp_9_9.Dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import Abdelhafid.pglp_9_9.Formes.Point;
import Abdelhafid.pglp_9_9.Formes.Rectangle;

public class TestRectangleDaoJdbc {
	
Point p1,p2,p3;
Rectangle r,r1,r2,create,create1,find;
RectangleDaoJdbc recDao;
 
 @Before()
	public void setUp() {
		
		Point p1=new Point(1, 1);
		Point p2=new Point(2, 2);
		Point p3=new Point(5, 5);
		
		 r= new Rectangle("rect", p1, 20,10);
		 r1= new Rectangle("rect2", p2, 30,20);
		 r2= new Rectangle("rect3", p3, 40,30);
		 
		 recDao= new RectangleDaoJdbc();
		
 }
 
 @Test
	public void testCreation() {
			
		create= recDao.Create(r);
		
		assertEquals( create.getNomForme(),r.getNomForme());
		assertEquals( create.getLongueur(),r.getLongueur());
		assertEquals( create.getLargeur(),r.getLargeur());
		assertEquals( create.getCentre_rectangle().getX(),r.getCentre_rectangle().getX());
		assertEquals( create.getCentre_rectangle().getY(),r.getCentre_rectangle().getY());
	
	}
 
 @Test
	public void testFind() {
	
		create= recDao.Create(r);
		
		find=recDao.Find(create.getNomForme());
		
		assertEquals( create.getNomForme(),find.getNomForme());
		assertEquals( create.getLongueur(),find.getLongueur());
		assertEquals( create.getLargeur(),find.getLargeur());
		assertEquals( create.getCentre_rectangle().getX(),find.getCentre_rectangle().getX());
		assertEquals( create.getCentre_rectangle().getY(),find.getCentre_rectangle().getY());
	}
 
 @Test
 public void testUpdate() {
 		
 		create1= recDao.Create(r1);
 		
 		Point p = new Point(3,2);
 		
 		r1.setCentre_rectangle(p);
 		r1.setLongueur(100);
 		r1.setLargeur(50);
 		
 		create1=recDao.Update(r1);
 		
 		assertEquals( create1.getNomForme(),r1.getNomForme());
		assertEquals( create1.getLongueur(),r1.getLongueur());
		assertEquals( create1.getLargeur(),r1.getLargeur());
		assertEquals( create1.getCentre_rectangle().getX(),r1.getCentre_rectangle().getX());
		assertEquals( create1.getCentre_rectangle().getY(),r1.getCentre_rectangle().getY());
 	}
 
 @Test
 public void testdelete() {
 	
 	Rectangle create2,find2;
 	create2= recDao.Create(r2);
 	recDao.delete(r2);
 	find2=recDao.Find(create2.getNomForme());
 	

 	assertEquals(find2,null);
 	
 	}
 @Test
 public void testFindAll() {
	 recDao.delete(r);
	 recDao.delete(r1);
 	
 	 create=recDao.Create(r);
 	 Rectangle create1 =recDao.Create(r1);
 	 
 	assertEquals(recDao.FindAll().size(),2);
 	
 	recDao.delete(r);
 	recDao.delete(r1);
 	recDao.delete(r2);
 	assertEquals(recDao.FindAll().size(),0);
 	

 	
 }

}
