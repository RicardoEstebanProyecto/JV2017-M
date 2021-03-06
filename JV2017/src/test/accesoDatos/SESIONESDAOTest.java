/** 
 * Proyecto: Juego de la vida.
 * Prueba Junit4 de la clase SesionesDAO.
 * @since: prototipo 2.1
 * @source: SesionesDAOTest.java 
 * @version: 2.1 - 2018.06.11
 * @author: DAM GRUPO 3 Ricardo Esteban Vivancos
 * 
 */
package test.accesoDatos;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import accesoDatos.Datos;
import accesoDatos.DatosException;
import modelo.Mundo;
import modelo.Sesion;
import modelo.Sesion.EstadoSesion;
import util.Fecha;

public class SesionDAOTest {

	private static Datos fachada;
	private Sesion sesionPrueba;
	
	/**
	 * Creacion de la fachada
	 */
	@BeforeClass
	public static void crearFachadaDatos() {
		try {
			fachada = new Datos();
		}
		catch (DatosException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Cargar datos de prueba
	 * @author DAM GRUPO 3 Ricardo Esteban Vivancos
	 */
	@Before
	public void crearDatosPrueba() {
		try {
			sesionPrueba= new Sesion(fachada.obtenerUsuario("III1R"), new  Fecha(), 
					new Mundo(), EstadoSesion.PREPARADA);
		}
		catch(DatosException e){
			e.printStackTrace();
		}		
	}

	/**
	 * Borrar datos de prueba antes de cada ejecucion
	 * @author DAM GRUPO 3 Ricardo Esteban Vivancos
	 */
	@After
	public void borraDatosPrueba() {
		fachada.borrarTodasSesiones();
		sesionPrueba = null;
	}
} // class
