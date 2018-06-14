package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import source.Obligatorio;

public class TestObligatorio {
	
	private Obligatorio obligatorio= new Obligatorio();
	
	@Before
	public void testLectura() throws IOException {
		obligatorio = new Obligatorio();
		obligatorio.lectura("v_producto_real_updated.csv");
	}
	@Test
	public void testReporte1() throws IOException {
		System.out.println("--------------------------------------------------");
		long startTime = System.nanoTime();
		obligatorio.reporte20EmpresasConMasProductosHabilitados();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime); 
		System.out.println(duration/1000000);
	}

	@Test
	public void testReporte2() throws IOException {
		System.out.println("--------------------------------------------------");
		long startTime = System.nanoTime();
		obligatorio.reporte10MarcasConMasProductosHabilitados();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime); 
		System.out.println(duration/1000000);
	}

	@Test
	public void testReporte3() throws IOException {
		System.out.println("--------------------------------------------------");
		long startTime = System.nanoTime();
		obligatorio.reporte10PaisesConMasProductosHabilitados();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime); 
		System.out.println(duration/1000000);
	}

	@Test
	public void testReporte4() throws IOException {
		System.out.println("--------------------------------------------------");
		long startTime = System.nanoTime();
		obligatorio.reporte20ClasesConMasProductosHabilitados();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime); 
		System.out.println(duration/1000000);
	}
}
