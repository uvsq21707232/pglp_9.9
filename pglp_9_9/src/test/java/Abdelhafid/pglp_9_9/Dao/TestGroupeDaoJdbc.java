package Abdelhafid.pglp_9_9.Dao;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Abdelhafid.pglp_9_9.Dao.GroupeDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.Initializer;
import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Composite;
import Abdelhafid.pglp_9_9.Formes.Point;
import Abdelhafid.pglp_9_9.Formes.Rectangle;
import Abdelhafid.pglp_9_9.Formes.Triangle;

public class TestGroupeDaoJdbc {

	
	Point p1,p2,p3;
	Rectangle rec;
	Cercle cer;
	Carre car, car2;
	Triangle tri;
	Composite grp1,grp2,grp3, create, find;
	GroupeDaoJdbc grpDao;
	Initializer init;
	
	@Before()
	public void setUp() {
		
		init = new Initializer();
		Point p1=new Point(1, 1);
		Point p2=new Point(2, 2);
		Point p3=new Point(5, 5);
		
		rec = new Rectangle("rectangle", p1,10,4);
		car= new Carre("carre", p2, 10);
		cer = new Cercle("cercle",p3, 15);
		tri = new Triangle("triangle",p3,p1,p2);
		
		grp1 = new Composite("groupe1");
		grp2= new Composite("groupe2");
		grp3= new Composite("groupe3");
		
		
		grp1.add(rec);
		grp1.add(car);
		grp1.add(cer);
		grp2.add(tri);
		grp1.add(grp2);

		grpDao= new GroupeDaoJdbc();
		
		
	}
	
	@Test
	public void testCreation() {
		
		Initializer init = new Initializer();
		
		create= grpDao.Create(grp1);
		
		 assertEquals(create.getNomForme(),grp1.getNomForme());
		 init.Show_GROUPE();
		 init.Show_ASSOCIATION();
		 
		
	}
	
	@Test
	public void testFind() {
		
		create= grpDao.Create(grp1);
		find = grpDao.Find(create.getNomForme());
		
       assertEquals( create.getNomForme(),find.getNomForme());
 
		 
       
	}
	
	@Test
	public void testFindAll() {
		
		create= grpDao.Create(grp1);
	 ArrayList<Composite> find1 = grpDao.FindAll(); 
	 assertEquals( find1.size(),2);
		
       init.Show_GROUPE();
   
	}
	
	@Test
	public void testdelete() {
		
		Composite groupe3 = new Composite("groupe3");
		groupe3.add(car);
		groupe3.add(cer);	
		Composite  create2 = grpDao.Create(groupe3);
		
		grpDao.delete(create2);
		Composite findD = grpDao.Find(create2.getNomForme());
	
		assertEquals(findD,null);	
		
	}
	
	@Test
	public void testUpdate() {

		Composite cretaeup;
		
		 cretaeup = grpDao.Create(grp3);
				
		 
	grp3.add(car);
	grp3.add(rec);
	cretaeup = grpDao.Update(grp3);
	
	assertEquals(cretaeup.getAllFormes().size(),2);

	init.Show_ASSOCIATION();
			
		
	}
		
	
}
