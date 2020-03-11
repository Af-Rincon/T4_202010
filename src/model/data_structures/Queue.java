package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T>{
	private Node<T> primero;
	private Node<T> ultimo;
	private int size;

	public Queue()
	{
		primero = null;
		ultimo = null;
		size = 0;
	}

	public void enqueue(T item)
	{
		Node<T> nuevo = new Node<T>(item);

		if(size == 0)
		{
			primero = nuevo;
			ultimo = nuevo;
		}
		else{
			Node<T> viejo = ultimo;
			viejo.asignarSiguiente(nuevo);
			ultimo = nuevo;
		}
		size++;
	}

	public T dequeue()
	{
		Node<T> viejo = primero;
		T buscado = primero.darItem();
		primero = viejo.darSiguiente();
		viejo.asignarSiguiente(null);
		size--;
		return buscado;

	}

	public int darTamano()
	{
		return size;
	}

	public T darPrimerElemento()
	{
		return primero.darItem();
	}

	public T darUltimoElemento()
	{
		return ultimo.darItem();
	}

	protected class MiIteradorNodo implements Iterator<T>
	{
		Node<T> actual;
		T value;

		public MiIteradorNodo()
		{
			actual = primero;
			value = null;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (actual!=null);
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				value = actual.darItem();
				actual = actual.darSiguiente();

			}
			return value;
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MiIteradorNodo();
	}

	
}
