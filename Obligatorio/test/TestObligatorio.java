package test;

import static org.junit.Assert.*;

import org.junit.Test;

import source.LeerCsv;
import source.Obligatorio;

public class TestObligatorio {

	@Test
	public void testCrearProductoSoloStrings() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testLectura() {
		Obligatorio obligatorio=new Obligatorio();
		LeerCsv.lectura(obligatorio);
	}
	@Test
	public void testReporte1() {
		Obligatorio obligatorio=new Obligatorio();
		LeerCsv.lectura(obligatorio);
		obligatorio.reporte20EmpresasConMasProductosHabilitados();
	}
	@Test
	public void testReporte2() {
		Obligatorio obligatorio=new Obligatorio();
		LeerCsv.lectura(obligatorio);
		obligatorio.reporte10MarcasConMasProductosHabilitados();
	}

}
