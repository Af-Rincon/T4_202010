package model.data_structures;

public class ArregloDinamico<T extends Comparable<T>> 
{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private String elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = new String[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( String dato )
	{
		if ( tamanoAct == tamanoMax )
		{ 
			tamanoMax = 2 * tamanoMax;
			String [ ] copia = elementos;
			elementos = new String[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public String darElemento(int i) 
	{
		String elemento = null; 

		if( i >= 0 && i < tamanoAct)
		{
			elemento = elementos[i];
		}

		return elemento;

	}

	public String buscar(String dato) 
	{	
		for(int i = 0; i < tamanoAct; i++)
		{
			String comparado = elementos[i];
			if(comparado.compareTo(dato) == 0)
			{
				return comparado;
			}
		}

		return null;
	}

	public String eliminar(String dato) {


		int pos  = 0;
		boolean encontre = false;
		String buscado  = null;

		for(int i = 0; i < tamanoAct && !encontre; i++ )
		{
			String comparado = elementos[i];
			if(comparado.compareTo(dato) == 0)
			{
				encontre = true;
				buscado  = comparado;
				pos = i;
			}

		}

		if(buscado  == null)
		{
			return null;
		}

		else
		{
			for (int j  = pos; j < tamanoAct -1; j++)
			{
				elementos[j] = elementos[j+1];
			}

			tamanoAct = tamanoAct-1;
			return buscado;
		}


	}

}
