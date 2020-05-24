package Abdelhafid.pglp_9_9;

import static org.junit.Assert.*;

import org.junit.Test;

import Abdelhafid.pglp_9_9.Dao.GroupeDaoJdbc;
import Abdelhafid.pglp_9_9.Dao.Initializer;

import Abdelhafid.pglp_9_9.Formes.Carre;
import Abdelhafid.pglp_9_9.Formes.Cercle;
import Abdelhafid.pglp_9_9.Formes.Composite;
import Abdelhafid.pglp_9_9.Formes.Point;
import Abdelhafid.pglp_9_9.Formes.Rectangle;
import Abdelhafid.pglp_9_9.Formes.Triangle;


public class GroupeTest {
	
	@Test
	public void GroupeDaoTest(){
		
		Initializer init = new Initializer();
		
		
		Point p1=new Point(2, 2);
		Point p2=new Point(5, 5);
		Point p3=new Point(10, 10);
		Point p4=new Point(20, 20);
		Triangle tri = new Triangle("charpente", p4,p1, p2);
		Cercle cer =  new Cercle("korra", p1, 30);
		Carre car = new Carre("moraba3", p2,10);
		Rectangle rect= new Rectangle("moustatil",p4, 2, 2);
		
		Composite groupe = new Composite("t");
		Composite groupe1 = new Composite("Bousshel");
		
		  groupe.add(tri);
		  groupe.add(cer);
		  groupe.add(car);
		  groupe.add(rect);
		  groupe1.add(tri);
		  groupe.add(groupe1);
		  
		  
		  GroupeDaoJdbc grDao = new GroupeDaoJdbc();
		  Composite GrCreate, GrFinf;
		  
		  GrCreate = grDao.Create(groupe);
		  
		  GrFinf=  grDao.Find("tizi");
		  
		  assertEquals(GrCreate.getNomForme(),GrFinf.getNomForme());
		  
		  
		  
		  init.Show_GROUPE();
		  init.Show_ASSOCIATION();
		  
	     
	
		
		
		
		
		
	}

}
