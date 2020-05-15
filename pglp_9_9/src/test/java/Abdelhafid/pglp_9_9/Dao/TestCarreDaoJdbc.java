package Abdelhafid.pglp_9_9.Dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Point;


public class TestCarreDaoJdbc {
	
	Point p1,p2,p3;
    Carre c,c1,c2,create,create1,find;
  
    CarreDaoJdbc carreDao;
	
	@Before()
	public void setUp() {
		
		Point p1=new Point(2, 2);
		Point p2=new Point(7, 9);
		Point p3=new Point(10, 19);
		c=new Carre("CARRE", p1, 10);
		c1=new Carre("CARRE1", p2, 100);
		c2=new Carre("CARRE2", p3, 2);
		carreDao=new CarreDaoJdbc();

}
	
	@Test
	public void testCreation() {
			
		create= carreDao.Create(c);
		
		assertEquals( create.getNomForme(),c.getNomForme());
		assertEquals( create.getCote(),c.getCote());
		assertEquals( create.getCentre_carre().getX(),c.getCentre_carre().getX());
		assertEquals( create.getCentre_carre().getY(), c.getCentre_carre().getX());
		
	}

	@Test
	public void testFind() {
		
		
		create= carreDao.Create(c);
		
		find=carreDao.Find(create.getNomForme());
		
		
		
		assertEquals( create.getNomForme(),find.getNomForme());
		assertEquals( create.getCote(),find.getCote());
		assertEquals( create.getCentre_carre().getX(),find.getCentre_carre().getX());
		assertEquals( create.getCentre_carre().getY(), find.getCentre_carre().getX());
	}
	
	
	@Test
public void testUpdate() {
		
		create1= carreDao.Create(c1);
		
		Point p = new Point(3,2);
		
		c1.setCentre_carre(p);
		c1.setCote(30);
		
		create1=carreDao.Update(c1);
		
		assertEquals( create1.getNomForme(),c1.getNomForme());
		assertEquals( create1.getCote(),c1.getCote());
		assertEquals( create1.getCentre_carre().getX(),c1.getCentre_carre().getX());
		assertEquals( create1.getCentre_carre().getY(),c1.getCentre_carre().getY());
	}

	@Test
public void testdelete() {
	
	Carre create2,find2;
	create2= carreDao.Create(c2);
	 carreDao.delete(c2);
	find2=carreDao.Find(create2.getNomForme());
	

	assertEquals( find2,null);
	
	}
	


@Test
public void testFindAll() {
	carreDao.delete(c);
	carreDao.delete(c1);
	
	 create=carreDao.Create(c);
	 Carre create1= carreDao.Create(c1);
	assertEquals(carreDao.FindAll().size(),2);

	
}
	



}
