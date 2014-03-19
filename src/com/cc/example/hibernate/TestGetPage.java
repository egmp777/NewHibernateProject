package com.cc.example.hibernate;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGetPage {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetPageOfEmployees2() {
		//fail("Not yet implemented"); // TODO
		MainClass handler = new MainClass();
	    assertEquals(5, handler.getPageOfEmployees2().size() );
	}

}
