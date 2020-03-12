package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T> implements ILinkedList<T>, Iterator<T>
{

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Primer nodo.
	 */

	private Node<T> primerNodo;

	/**
	 * Tamaño de la lista
	 */

	private int tamanio;

	/**
	 * Nodo actual
	 */

	private Node<T> nodoActual;


	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	public LinkedList()
	{
		primerNodo = null;
		nodoActual = null; 
		tamanio = 0;
	}

	// -----------------------------------------------------------------
	// Clases privadas
	// -----------------------------------------------------------------

	/**
	 * 
	 */

	private class ListIterator implements Iterator<T>
	{
		private Node<T> actual  = primerNodo;

		public boolean hasNext()
		{
			return actual != null; 
		}

		public T next()
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}

			T item = actual.darItem();
			actual = actual.darSiguiente();

			return item;
		}
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el tamanioo de total de la lista
	 * @return Tamanio de la lista
	 */

	public int darTamanio()
	{
		return tamanio;
	}


	/**
	 * Retorna true si la lista está vacía, false de lo contrario. 
	 * @return True si la lista está vacía, false de lo contrario.
	 */

	public boolean isEmpty()
	{
		return primerNodo == null;

	}

	/**
	 * Retorna el primer elemento de la lista
	 * @return Primer elemento de la lista
	 */
	public Node<T> darPrimerElemento()
	{
		return primerNodo;
	}

	/**
	 * Retorna el elemento actual de la lista
	 * @return elemento actual en la lista
	 */
	public Node<T> darElementoActual()
	{
		return nodoActual;
	}


	/**
	 * Retorna un elemento buscado que está en una posición dada. 
	 * @param pos Posicion en la que está el elemento buscado
	 * @return Retorna el elemento en la posicion dada. Si no existe un elemento en la posicion retorna null.
	 */
	public Node<T> darElementoPosicion(int pos)
	{
		if(pos >= 0 && pos < tamanio)
		{
			Node<T> act = primerNodo; 
			int i =  0; 

			while(i != pos)
			{
				act = act.darSiguiente();
				i ++;
			}

			return act;
		}

		else
		{
			return null;
		}
	}

	/**
	 * Agrega el elemento pasado por parámetro al comienzo de la lista. 
	 * @param item Elemento que se desea agregar a la lista. 
	 */

	public void agregarAlComienzo(T item)
	{
		Node<T> nodo = new Node<T>(item);

		if(primerNodo == null)
		{
			primerNodo = nodo;
		}

		else
		{
			nodo.asignarSiguiente(primerNodo);
			primerNodo.asignarSiguiente(null);
			primerNodo = nodo;
		}

		tamanio++;

	}

	/**
	 * Agrega el elemento pasado por parámetro al final de la lista. 
	 * @param item Elemento que se desea agregar a la lista.
	 */
	public void agregarAlFinal(T item)
	{
		Node<T> nodo = new Node<T>(item);

		if(primerNodo == null)
		{
			primerNodo = nodo;
		}

		else
		{
			Node<T> actual = primerNodo;

			while(actual.darSiguiente() != null)
			{
				actual = actual.darSiguiente();
			}

			actual.asignarSiguiente(nodo);
		}

		tamanio++;

	}

	/**
	 * Agrega un elemento por parametro en la posicion pasada por parametro.
	 * @param pos Posicion de la lista en la que se desea agregar el elemento.
	 * @param item Elemento que se desea agregar a la lista. 
	 */

	public void agregarEnPosicion(int pos, T item)
	{
		Node<T> nodo = new Node<T>(item);

		if(pos >= 0 && pos < tamanio )
		{
			int i = 0;

			Node<T> actual = primerNodo;

			while(i < pos-1)
			{
				actual = actual.darSiguiente();
				i++;
			}


			Node<T> siguiente = actual.darSiguiente();
			nodo.asignarSiguiente(siguiente);
			actual.asignarSiguiente(nodo);
			tamanio++;
		}

	}

	/**
	 * Elimina el primer elemento de la lista
	 */

	public void eliminarPrimero()
	{
		if(primerNodo.darSiguiente() == null)
		{
			primerNodo = null;
		}

		else
		{
			Node<T> nodo = primerNodo; 
			primerNodo = primerNodo.darSiguiente();
			nodo.asignarSiguiente(null);
		}

		tamanio--;
	}

	/**
	 * Elimina el elemento que se encuentra en la posicion pasada por parametro
	 * @param pos Posicion de la lista en la que se desea eliminar el elemento.
	 */

	public void eliminar(int pos)
	{
		if(pos >= 0 && pos < tamanio )
		{
			int i = 0; 
			Node<T> actual = primerNodo; 

			while(i < pos-1)
			{
				actual = actual.darSiguiente();
				i++;
			}

			Node<T> buscado = actual.darSiguiente();
			actual.asignarSiguiente(buscado.darSiguiente());
			buscado.asignarSiguiente(null);
		}

		tamanio--;
	}

	/**
	 * Retorna el iterador. 
	 * @return El iterador
	 */

	public Iterator<T> iterator()
	{
		return new ListIterator();
	}



	public boolean hasNext() 
	{
		if(nodoActual != null)
		{
			return nodoActual.hasNext();
		}

		else
		{

			return false;
		}
	}


	public T next() throws NoSuchElementException 
	{

		if(nodoActual == null)
		{
			nodoActual = primerNodo;
		}

		else
		{
			if(nodoActual.hasNext())
			{
				nodoActual = nodoActual.darSiguiente();
			}

			else
			{
				throw new NoSuchElementException();
			}
		}

		return nodoActual.darItem();
	}

}
