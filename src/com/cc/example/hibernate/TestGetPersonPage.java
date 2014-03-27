package com.cc.example.hibernate;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetPersonPage {
    
	@Test
	public final void testGetPageOfPersons() {
        
		ModelPersonData mp = new ModelPersonData();
        mp.fillPersons();
        
	    assertEquals(5, mp.getPageOfPersons().size() );
	}
    
}