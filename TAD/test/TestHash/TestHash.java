package TestHash;
import static org.junit.Assert.*;

import java.awt.Transparency;

import org.junit.Test;

import hash.HashTable;
import hash.MyHashTable;

public class TestHash {

	@Test
	public void testInsertar() {
		
		Pais a1=new Pais("argentina");
		Pais a2=new Pais("brasil");
		Pais a3=new Pais("uruguay");
		Pais a4=new Pais("peru");
		Pais a5=new Pais("españa");
		Pais a6=new Pais("mexico");
		Pais a7=new Pais("el pais de los ñeri");
		Pais a8=new Pais("el pais de los mupet");
		Pais a9=new Pais("el pais");
		
		HashTable<Pais,String> ht=new MyHashTable<>(10);
		
		//verifico que permita ingresar elementos diferentes
		try {
			
			ht.insertar(a1, "traeme la copa messi");
			ht.insertar(a2, "neymar");
			ht.insertar(a3, "por favor suarz no muerdas a nadie antes de la final");
			ht.insertar(a4, "la siguiente sale");
			ht.insertar(a5, "quiero otro mundial");
			ht.insertar(a6, "quiero llegara cuarto de final");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertEquals(true, ht.pertenece(a4));
		assertEquals(false, ht.pertenece(a7));
	
		//verifico que no permita ingresar elemenots ya existentes
		
try {
			
			ht.insertar(a1, "traeme la copa messi");
			fail("deveria saltar una exepcion");
			
		} catch (Exception e) {
		     
		}

        //verifico si se agranda el jash al superar el 80% de ocupacion.


    try {
		ht.insertar(a7, "vendo celular a 300 pe o permuto por frula");
		ht.insertar(a8, "hola");
		ht.insertar(a9, "hola");
	} catch (Exception e) {
		System.out.println(e);
	}
          assertEquals(15,ht.size());

		
	}
	
	
	
    
	
	
	
	
	
	
	
	@Test
	public void testObtener() {
		
		Pais a1=new Pais("argentina");
		Pais a2=new Pais("brasil");
		Pais a3=new Pais("uruguay");
		Pais a4=new Pais("peru");
		Pais a5=new Pais("españa");
		Pais a6=new Pais("mexico");
		Pais a9=new Pais("el pais de los ñeri");
		
		HashTable<Pais,String> ht=new MyHashTable<>(10);
		
		try {
			
			ht.insertar(a1, "traeme la copa messi");
			ht.insertar(a2, "neymar");
			ht.insertar(a3, "por favor suarz no muerdas a nadie antes de la final");
			ht.insertar(a4, "la siguiente sale");
			ht.insertar(a5, "quiero otro mundial");
			ht.insertar(a6, "quiero llegara cuarto de final");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertEquals("por favor suarz no muerdas a nadie antes de la final", ht.obtener(a3));
		
		
	}
	
	@Test
	public void testEliminar() {
		
		Pais a1=new Pais("argentina");
		Pais a2=new Pais("brasil");
		Pais a3=new Pais("uruguay");
		Pais a4=new Pais("peru");
		Pais a5=new Pais("españa");
		Pais a6=new Pais("mexico");
		Pais a9=new Pais("el pais de los ñeri");
		
		HashTable<Pais,String> ht=new MyHashTable<>(10);
		
		try {
			
			ht.insertar(a1, "traeme la copa messi");
			ht.insertar(a2, "neymar");
			ht.insertar(a3, "por favor suarz no muerdas a nadie antes de la final");
			ht.insertar(a4, "la siguiente sale");
			ht.insertar(a5, "quiero otro mundial");
			ht.insertar(a6, "quiero llegara cuarto de final");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		assertEquals(true, ht.pertenece(a5));
		ht.borrar(a5);
		assertEquals(false, ht.pertenece(a5));
		
		
		
	}

}
