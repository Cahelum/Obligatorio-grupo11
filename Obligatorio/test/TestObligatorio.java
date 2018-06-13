package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import source.LeerCsv;
import source.Obligatorio;

public class TestObligatorio {

	@Test
	public void testCrearProductoSoloStrings() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testLectura() throws IOException {
		Obligatorio obligatorio = new Obligatorio();
		LeerCsv.lectura(obligatorio);
	}

	@Test
	public void testReporte1() throws IOException {
		System.out.println("--------------------------------------------------------");
		Obligatorio obligatorio = new Obligatorio();
		LeerCsv.lectura(obligatorio);
		obligatorio.reporte20EmpresasConMasProductosHabilitados();
	}

	@Test
	public void testReporte2() throws IOException {
		System.out.println("--------------------------------------------------------");
		Obligatorio obligatorio = new Obligatorio();
		LeerCsv.lectura(obligatorio);
		obligatorio.reporte10MarcasConMasProductosHabilitados();
	}

	@Test
	public void testReporte3() throws IOException {
		System.out.println("--------------------------------------------------------");
		Obligatorio obligatorio = new Obligatorio();
		LeerCsv.lectura(obligatorio);
		obligatorio.reporte10PaisesConMasProductosHabilitados();
	}

	@Test
	public void testReporte4() throws IOException {
		System.out.println("--------------------------------------------------------");
		Obligatorio obligatorio = new Obligatorio();
		LeerCsv.lectura(obligatorio);
		obligatorio.reporte20ClasesConMasProductosHabilitados();
	}
}
