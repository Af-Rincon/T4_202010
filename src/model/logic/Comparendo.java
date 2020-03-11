package model.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comparendo implements Comparable<Comparendo>{

	private int objectID;

	/**
	 * Fecha del comparendo
	 */

	private Date fecha;

	/**
	 * Medio dete del comparendo.
	 */

	private String medioDete;

	/**
	 * Clase de vehiculo del comparendo.
	 */

	private String claseVehiculo;

	/**
	 * Tipo de servicio del vehiculo del comparendo.
	 */

	private String tipoServicio;

	/**
	 * Infraccion del comparendo.
	 */

	private String infraccion;

	/**
	 * Descripcion de la infraccion del comparendo.
	 */

	private String descripInfraccion; 

	/**
	 * Localidad del comparendo.
	 */

	private String localidad;

	/**
	 * 
	 */
	private double latitud;

	/**
	 * 
	 */
	private double longitud;


	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea un comparendo con toda la informacion respectiva.
	 * @param pObjectID ObjectID del comparendo.
	 * @param pFecha Fecha del comparendo.
	 * @param pMedioDete Medio dete del comparendo.
	 * @param pClaseVehiculo Clase de vehiculo del comparendo.
	 * @param pTipoServicio Tipo de servicio del vehiculo del comparendo.
	 * @param pInfraccion Infraccion del comparendo.
	 * @param pDesInfraccion Descripcion de la infraccion del comparendo.
	 * @param pLocalidad Localidad del comparendo.
	 */

	public Comparendo(int pObjectID, Date pFecha, String pMedioDete, String pClaseVehiculo, String pTipoServicio, String pInfraccion, String pDesInfraccion, String pLocalidad, double pLatitud, double pLongitud)
	{
		objectID = pObjectID;
		fecha = pFecha; 
		medioDete = pMedioDete;
		claseVehiculo = pClaseVehiculo; 
		tipoServicio = pTipoServicio; 
		infraccion = pInfraccion;
		descripInfraccion = pDesInfraccion;
		localidad = pLocalidad;
		latitud =pLatitud; 
		longitud = pLongitud;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	public int darObjectID()
	{
		return objectID;
	}

	public Date darFecha()
	{
		return fecha;
	}

	public String darMedioDete()
	{
		return medioDete;
	}

	public String darClaseVehiculo()
	{
		return claseVehiculo;
	}

	public String darTipoServicio()
	{
		return tipoServicio;
	}

	public String darInfraccion()
	{
		return infraccion;
	}

	public String darDesInfraccion()
	{
		return descripInfraccion;
	}

	public String darLocalidad()
	{
		return localidad;
	}
	
	public String darSimpleDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
	    String strDate= formatter.format(fecha);
	    return strDate;
	}

	@Override
	public String toString() {
		return "Comparendo [OBJECTID=" + objectID + ", FECHA_HORA=" + fecha + ", DES_INFRAC=" + descripInfraccion
				+ ", MEDIO_DETE=" + medioDete + ", CLASE_VEHI=" + claseVehiculo + ", TIPO_SERVI=" + tipoServicio
				+ ", INFRACCION=" + infraccion + ", LOCALIDAD=" + localidad + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}

	public String datosCluster()
	{
		return "INFRACCION: "+infraccion+" OBJECTID: "+objectID+" FECHA_HORA: "+fecha+" CLASE_VEHI:"+claseVehiculo+" TIPO_SERVI:"+tipoServicio+" LOCALIDAD: "+localidad;	
	}
	
	
	@Override
	public int compareTo(Comparendo o) {
		int num = 0;
		if(fecha.before(o.darFecha()))
		{
			num = -1;
		}
		if(fecha.after(o.darFecha()))
		{
			num = 1;
		}
		if(fecha.equals(o.darFecha()))
		{
			num = 0;
		}
		if(num==0)
		{
			if(objectID<o.darObjectID())
			{
				num = -1;
			}
			if(objectID>o.darObjectID())
			{
				num = 1;
			}
			if(objectID==o.darObjectID())
			{
				num = 0;
			}
		}
		return num;
	}
	
	
	public int compararPorInfraccion(Comparendo c1)
	{
		int  num = infraccion.compareToIgnoreCase(c1.darInfraccion());
		
		if(num > 0)
			num = 1;
		
		if(num < 0)
			num = -1;
		
		if(num == 0)
		{
			if(objectID<c1.darObjectID())
			{
				num = -1;
			}
			if(objectID>c1.darObjectID())
			{
				num = 1;
			}
			if(objectID==c1.darObjectID())
			{
				num = 0;
			}
		}
		
		return num;
	
	}

	
	public int compararPorLocalidad(Comparendo c1)
	{
		int  num = localidad.compareToIgnoreCase(c1.darLocalidad());
		
		if(num > 0)
			num = 1;
		
		if(num < 0)
			num = -1;
		
		if(num == 0)
		{
			if(objectID<c1.darObjectID())
			{
				num = -1;
			}
			if(objectID>c1.darObjectID())
			{
				num = 1;
			}
			if(objectID==c1.darObjectID())
			{
				num = 0;
			}
		}
		
		return num;
	
	}
}
