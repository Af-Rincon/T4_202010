package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Queue;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";

	/**
	 * Atributos del modelo del mundo
	 */

	private Queue<Comparendo> datos;
	private MaxHeapCP<Comparendo> heap;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */

	public Modelo()
	{
		datos = new Queue<Comparendo>();
		heap = new MaxHeapCP<Comparendo>();

	}


	public int darTamanoCola()
	{
		return datos.darTamano();
	}



	public void cargarDatos() 

	{
		JsonReader reader;

		try {

			int mayorID  = 0;
			reader = new JsonReader(new FileReader( PATH));
			JsonParser jsonp = new JsonParser();

			JsonElement elem = jsonp.parse(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();


				String FECHA_HORA = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				String MUNICIPIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("MUNICIPIO").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION,DES_INFRAC, LOCALIDAD, longitud, latitud, MUNICIPIO);
				datos.enqueue(c);


			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Comparendo[] copiarDatos()
	{
		Comparendo[] comparendos = new Comparendo[datos.darTamano()];
		int i = 0;
		for(Comparendo e : datos)
		{
			comparendos[i] = e;
			i++;
		}
		return comparendos;
	}
	
	public void  shuffle(Comparendo[] total)
	{
		Random rnd = ThreadLocalRandom.current();
		  for (int i = total.length - 1; i > 0; i--)
		    {
		      int index = rnd.nextInt(i + 1);
		      // Simple swap
		      Comparendo a = total[index];
		      total[index] = total[i];
		      total[i] = a;
		    }
	}

}
