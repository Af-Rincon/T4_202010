package model.data_structures;

import java.util.Iterator;

public interface ILinkedList<T> extends Iterable<T> 
{

	public int darTamanio() ;

	public boolean isEmpty(); 


	public Node<T> darPrimerElemento();

	public Node<T> darElementoActual();

	public Node<T> darElementoPosicion(int pos);


	public void agregarAlComienzo( T item);

	public void agregarAlFinal( T item);

	public void agregarEnPosicion(int pos, T item);


	public void eliminarPrimero();

	public void eliminar(int pos);


	public Iterator<T> iterator();





}
