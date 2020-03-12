package test.data_structures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.MaxColaCP;

public class TestMaxCola {

	private MaxColaCP<String> cola;

	@Before
	public void setUp()
	{
		cola = new MaxColaCP<String>();
		
		cola.agregar("a");
		cola.agregar("b");
		cola.agregar("c");
		cola.agregar("d");
	}

	@Test
	public void darTamano()
	{
		assertEquals("El tamano no es correcto", 4, cola.darTamano());
	}

	@Test
	public void dequeue()
	{
		assertEquals("El elemento no es el esperado", "d",cola.darMax());
	}

	@Test
	public void enqueue()
	{
		cola.agregar("e");
		assertEquals("El elemento no es el esperado","e",cola.darMax());
		assertEquals("El tamano no es el esperado",5,cola.darTamano());
	}


}
