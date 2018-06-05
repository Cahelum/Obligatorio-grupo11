package testHeaps;

import static org.junit.Assert.*;

import org.junit.Test;

import heaps.Heap;
import heaps.MyHeap;

public class TestHeaps {
	 
 public static Heap<Integer,String> h;
	@Test
	public void testAdd() {
		
		h=new MyHeap<>(false);
		
		h.add(100,"primer ingresado" );
		h.add(60,"casa1");
		h.add(70,"casa dos pisos");
		h.add(40,"izuierda");
		h.add(30,"izuierda");
		h.add(45,"izuierda");
		h.imprimir();
		System.out.println("-------");
		h.delete();
		h.imprimir();
		
		assertEquals("casa dos pisos", h.find(70).getData());
		
		
	}

}
