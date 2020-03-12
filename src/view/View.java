package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar datos");
			System.out.println("2. Generar muestra aleatoria con MaxColaCP");
			System.out.println("3. Generar muestra aleatoria con MaxHeapCP");
			System.out.println("4. Dar N comparendos mas al norte (MaxColaCP)");
			System.out.println("5. Dar N comparendos mas al norte (MaxHeapCP)");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
