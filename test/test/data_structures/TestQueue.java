package test.data_structures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;

public class TestQueue {

	private Queue<String> cola;

	@Before
	public void setUp()
	{
		cola = new Queue<String>();
		cola.enqueue("a");
		cola.enqueue("b");
		cola.enqueue("c");
	}

	@Test
	public void darTamano()
	{
		assertEquals("El tamano no es correcto", 3, cola.darTamano());
	}

	@Test
	public void dequeue()
	{
		assertEquals("El elemento no es el esperado", "a",cola.dequeue());
	}

	@Test
	public void enqueue()
	{
		cola.enqueue("d");
		assertEquals("El elemento no es el esperado","d",cola.darUltimoElemento());
		assertEquals("El tamano no es el esperado",4,cola.darTamano());
	}

}
