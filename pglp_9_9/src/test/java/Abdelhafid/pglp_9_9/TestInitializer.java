package Abdelhafid.pglp_9_9;

import org.junit.Test;

import Abdelhafid.pglp_9_9.Dao.Initializer;
import Abdelhafid.pglp_9_9.Dao.TableExist;

public class TestInitializer {

	
	
	@Test
	public void CreateTables() throws TableExist {
	Initializer base_donnes= new Initializer();
	 base_donnes.CreateAllTables();
	 
	}
	
	
	/*
	@Test
	public void dropCreateTables () throws TableExist, SQLException {
		Initializer base_donnes= new Initializer();
		 base_donnes.dropCreateTables();
	}
	 */
}
