package Abdelhafid.pglp_9_9.Formes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestGroupe {
	
	Point p1 , p2 , p3;
    Triangle tri;
    Cercle cercle;
    Carre carre;
    Rectangle rectangle;
    Composite grp;
    
	
	@Before()
	public void setUp() {
		
		 p1=new Point(3,3);
		 p2=new Point(4,4);
		 p3=new Point(5,5);
		 tri = new Triangle("triangle", p3, p1,p2);
		 cercle = new Cercle("ballon", p1, 10);
		 carre= new Carre("cadre", p2, 5);
		 rectangle = new Rectangle("porte", p3, 100, 70);
		 
		 grp=new Composite("groupe1");

}
	
	@Test
	public void testCreation() {
			
		assertEquals( grp.getNomForme(),"groupe1");
		assertEquals( grp.getAllFormes().size(),0);
		
	}
	
	@Test
	public void testAdd() {
		grp.add(carre);
		assertEquals( grp.getAllFormes().size(),1);
		
		grp.add(cercle);
		assertEquals( grp.getAllFormes().size(),2);
		
		grp.add(rectangle);
		assertEquals( grp.getAllFormes().size(),3);
		
		grp.add(tri);
		assertEquals( grp.getAllFormes().size(),4);
		
	}
	
	@Test
	public void testdelete() {
		grp.add(carre);
		grp.add(cercle);
		grp.add(rectangle);
		grp.add(tri);
		assertEquals( grp.getAllFormes().size(),4);
		
		grp.delete(carre);
		assertEquals( grp.getAllFormes().size(),3);
		grp.delete(cercle);
		assertEquals( grp.getAllFormes().size(),2);
	}
	

	@Test
	public void testgetAllFormes() {
		grp.add(carre);
		grp.add(cercle);
		grp.add(rectangle);
		grp.add(tri);
		assertEquals( grp.getAllFormes().size(),4);
		
	}
	
	@Test
	public void testdeleteAll() {
		grp.add(carre);
		grp.add(cercle);
		grp.add(rectangle);
		grp.add(tri);
		grp.deleteAll();
		assertEquals( grp.getAllFormes().size(),0);
		
	}
	
	@Test
	public void testMove() {
		grp.add(carre);
		grp.add(cercle);
		grp.move_Forme(2, 2);
		
		ArrayList<Forme> list = grp.getAllFormes();
		
		for(Forme f : list) {
			
		if ( f instanceof Carre) {
			assertEquals( ((Carre) f).getCentre_carre().getX(),6);
			assertEquals( ((Carre) f).getCentre_carre().getY(),6);
			
		}
		if ( f instanceof Cercle) {
			assertEquals( ((Cercle) f).getCentre().getX(),5);
			assertEquals( ((Cercle) f).getCentre().getY(),5);
			
		}
			
			
		}
		
		
		
		
		
		
	}
	

}
