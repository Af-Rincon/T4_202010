package model.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxColaCP <T extends Comparable<T>> implements Iterable<T> {
	
	private T[]cp;
	private int N;

	private Node<T> primero;
	private Node<T> ultimo;
	private int size;

	public MaxColaCP()
	{
		primero = null;
		ultimo = null;
		size = 0;
	}

	public void agregar(T item)
	{
		Node<T> nuevo = new Node<T>(item);

		if(size == 0)
		{
			primero = nuevo;
			ultimo = nuevo;
		}
		else{

			boolean encontro = false;
			Node<T> viejo = ultimo;

			while(viejo!=null&&!encontro)
			{
				Node<T> siguiente = viejo.darSiguiente();
	
					if(item.compareTo(viejo.darItem())>=0)
					{
						nuevo.asignarSiguiente(viejo);
						ultimo = nuevo;
						encontro = true;
					}
					if(item.compareTo(viejo.darItem())<=0&&item.compareTo(siguiente.darItem())>=0)
					{
						nuevo.asignarSiguiente(siguiente);
						viejo.asignarSiguiente(nuevo);
						ultimo = nuevo;
						encontro = true;
					}

				viejo = siguiente;

			}		
		}
		size++;
	}

	public T sacarMax()
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

	public boolean esVacia()
	{
		return size == 0;
	}

	public T darMax()
	{
		return ultimo.darItem();
	}

	public T darUltimoElemento()
	{
		return primero.darItem();
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
