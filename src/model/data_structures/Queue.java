package model.data_structures;

public class Queue<T> {
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

}
