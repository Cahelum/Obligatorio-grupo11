package testQueueSimple;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import queueSimple.MyQueue;



public class TestQueueSimple {
	
	
	private static MyQueue<String> prueba;
	
	
	
	
	@BeforeClass
	public static void antes(){
		prueba= new MyQueue<String>();

		
	}

	@Test
	public void testDequeueEnqueue(){
		
		assertEquals(0,prueba.size());
		prueba.enqueue("PRIMERO");
		prueba.enqueue("segundo");
		assertEquals(2,prueba.size());
		
		
		assertEquals(prueba.getFirst(),"PRIMERO");
		
		prueba.dequeue();
		assertEquals(prueba.getFirst(),"segundo");
		System.out.println(prueba.getFirst());
		prueba.dequeue();
		
		
		

	}
	@Test
	public void testisEmty(){
		
		assertTrue(prueba.isEmpty());
	}
	
	
	

}
