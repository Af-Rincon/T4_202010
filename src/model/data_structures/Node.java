package model.data_structures;

public class Node<T> {
	
	// -----------------------------------------------------------------
		// Atributos
		// -----------------------------------------------------------------


		/**
		 * Item del nodo
		 */

		private T item; 

		/**
		 * Siguiente nodo
		 */

		private Node<T> siguiente;


		// -----------------------------------------------------------------
		// Constructores
		// -----------------------------------------------------------------

		/**
		 * Crea un nuevo nodo con el item pasado por parametro.
		 * @param pItem Objeto del nodo.
		 */

		public Node(T pItem)
		{
			item = pItem;
			siguiente = null;
		}


		// -----------------------------------------------------------------
		// Métodos
		// -----------------------------------------------------------------

		/**
		 * Retorna el item del nodo.
		 * @return Item del nodo
		 */

		public T darItem()
		{
			return item;
		}

		/**
		 * Retorna el nodo siguiente.
		 * @return Nodo siguiente. 
		 */

		public Node<T> darSiguiente()
		{
			return siguiente;
		}


		/**
		 * Asigna el item pasado por parametro al item del nodo. 
		 * @param pItem Item del nodo
		 */

		public void asignarItem(T pItem)
		{
			item = pItem;
		}


		/**
		 * Asigna un nodo al siguiente del nodo actual. 
		 * @param pSiguiente Nodo siguiente. 
		 */

		public void asignarSiguiente(Node<T> pSiguiente)
		{
			siguiente = pSiguiente;
		}


		/**
		 * Retorna si el nodo tiene uno siguiente
		 * @return Retorna si hay siguiente nodo
		 */

		public boolean hasNext()
		{
			return siguiente!=null; 
		}

}
