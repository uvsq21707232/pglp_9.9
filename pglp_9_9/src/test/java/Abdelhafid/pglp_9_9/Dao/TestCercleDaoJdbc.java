package Abdelhafid.pglp_9_9.Dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Point;

public class TestCercleDaoJdbc {
	
	Point p1,p2,p3;
 Cercle	c,c1,c2,create,create1,find;
 CercleDaoJdbc cercleDao;
 
 @Before()
	public void setUp() {
		
		Point p1=new Point(1, 1);
		Point p2=new Point(2, 2);
		Point p3=new Point(10, 10);
		
		 c= new Cercle("rond", p1, 2);
		 c1= new Cercle("rond1", p2, 3);
		 c2= new Cercle("rond2", p3, 4);
		 
		 cercleDao= new CercleDaoJdbc();
		
 }
 
 @Test
	public void testCreation() {
			
		create= cercleDao.Create(c);
		
		assertEquals( create.getNomForme(),c.getNomForme());
		assertEquals( create.getRayon(),c.getRayon());
		assertEquals( create.getCentre().getX(),c.getCentre().getX());
		assertEquals( create.getCentre().getY(),c.getCentre().getY());
	
	}
 
 @Test
	public void testFind() {
		
	 
	 
		create= cercleDao.Create(c);
		
		find=cercleDao.Find(create.getNomForme());
		
		assertEquals( create.getNomForme(),find.getNomForme());
		assertEquals( create.getRayon(),find.getRayon());
		assertEquals( create.getCentre().getX(),find.getCentre().getX());
		assertEquals( create.getCentre().getY(),find.getCentre().getY());
	}
	
 @Test
 public void testUpdate() {
 		
 		create1= cercleDao.Create(c1);
 		
 		Point p = new Point(3,2);
 		
 		c1.setCentre(p);
 		c1.setRayon(30);
 		
 		create1=cercleDao.Update(c1);
 		
 		assertEquals( create1.getNomForme(),c1.getNomForme());
 		assertEquals( create1.getRayon(),c1.getRayon());
 		assertEquals( create1.getCentre().getX(),c1.getCentre().getX());
 		assertEquals( create1.getCentre().getY(),c1.getCentre().getY());
 	}
 @Test
 public void testdelete() {
 	
 	Cercle create2,find2;
 	create2= cercleDao.Create(c2);
 	cercleDao.delete(c2);
 	find2=cercleDao.Find(create2.getNomForme());
 	

 	assertEquals( find2,null);
 	
 	}
 @Test
 public void testFindAll() {
	 cercleDao.delete(c);
	 cercleDao.delete(c1);
 	
 	 create=cercleDao.Create(c);
 	 Cercle create1= cercleDao.Create(c1);
 	assertEquals(cercleDao.FindAll().size(),2);
 	
 	cercleDao.delete(c);
 	cercleDao.delete(c1);
 	cercleDao.delete(c2);
 	assertEquals(cercleDao.FindAll().size(),0);
 	

 	
 }

}
