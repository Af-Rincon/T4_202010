package controller;

import java.util.ArrayList;
import java.util.Scanner;


import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					modelo = new Modelo();

					long start = System.currentTimeMillis();
					modelo.cargarDatos(); 
					long end = System.currentTimeMillis();


					view.printMessage("Datos de comparendos cargados.");
					view.printMessage("Numero total de comparendos " + modelo.darTamanoCola() + "\n---------");		
					view.printMessage("Tiempo de carga (seg): " + (end-start)/1000.0 + "\n---------");
					
					break;
					
				case 2:
					break;
					
					
				case 3: 
					view.printMessage("Ingrese el numero de comparendos que desea que tenga la muestra");
					int numero1 = lector.nextInt();
					
					long start1 = System.currentTimeMillis();
					modelo.cargarMuestraParaHeap(numero1); 
					long end1 = System.currentTimeMillis();
					
					view.printMessage("Numero total de comparendos " + numero1);
					view.printMessage("Tiempo de carga (seg): " + (end1-start1)/1000.0 + "\n---------");

				case 4:
											
					break;

				case 5:
					
					view.printMessage("Ingrese el numero de comparendos que desea buscar");
					int numero = lector.nextInt();
					
					view.printMessage("Ingrese los tipos de vehiculos que quiere buscar. Separelos con - y sin espacios(ej.: MOTOCICLETA-BICICLETA)");
					String res = lector.next();
					String[] tipos = res.split("-");
					
					long start2 = System.currentTimeMillis();
					ArrayList<Comparendo> buscados = modelo.darNComparendosMasNorteHeap(numero, tipos);
					
					for(int i = 0; i < buscados.size(); i++)
					{
						view.printMessage(buscados.get(i).datosCluster2());
					}
					long end2 = System.currentTimeMillis();
					view.printMessage("Tiempo de carga (seg): " + (end2-start2)/1000.0 + "\n---------");
					
					break;

				case 6:
											
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	


				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
