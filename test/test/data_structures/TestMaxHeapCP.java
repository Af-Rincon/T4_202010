package test.data_structures;

import model.data_structures.MaxHeapCP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMaxHeapCP 
{

	private MaxHeapCP<String> heapPrioridad;
	
	@Before
	public void setUpEscenario1()
	{
		heapPrioridad = new MaxHeapCP<String>();
		
		heapPrioridad.agregar("B");
		heapPrioridad.agregar("U");
		heapPrioridad.agregar("E");
		heapPrioridad.agregar("N");
		heapPrioridad.agregar("O");
		heapPrioridad.agregar("C");
		heapPrioridad.agregar("P");
		heapPrioridad.agregar("L");
		heapPrioridad.agregar("S");
		heapPrioridad.agregar("F");
	}
	
	
	public void setUpEscenario2()
	{
		heapPrioridad = new MaxHeapCP<String>();
	}
	
	@Test 
	public void testDarNumElementos()
	{
	
		assertEquals("El numero de elementos no es el esperado", heapPrioridad.darNumElementos(),10);
		
	}
	
	
	@Test 
	public void testAgregar()
	{
		heapPrioridad.agregar("Z");
		assertEquals("El numero de elementos no es el esperado", heapPrioridad.darNumElementos(),11 );
		assertEquals("El elemento no se encuentra en la posicion esperada", "Z", heapPrioridad.darMax());

		heapPrioridad.agregar("H");
		assertEquals("El numero de elementos no es el esperado", heapPrioridad.darNumElementos(),12 );
	}
	
	@Test 
	public void testEsVacia()
	{
		assertFalse("El heap no debería ser vacio pero lo es", heapPrioridad.esVacia());
		
		setUpEscenario2();
		assertTrue("El heap debería estar vacio", heapPrioridad.esVacia());
	}
	

	@Test
	public void testSacarMax()
	{
		Comparable maximo = heapPrioridad.sacarMax();
		assertEquals("El maximo no es el esperado", maximo, "U");
	}

}
