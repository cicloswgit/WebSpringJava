package com.aprendendojava.controller.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aprendendojava.controller.PersonController;

public class PersonControllerTest {

	@Test
	public void testAddPerson() {
		PersonController controller = new PersonController();
		
		String resultado = controller.addPerson(null);
		
		assertNotNull(resultado);
	}

}
