/**
 * 
 */
package testNodoSimple;

import static org.junit.Assert.*;

import org.junit.Test;

import nodoSimple.LinkedList;
import nodoSimple.MyLinkedList;

/**
 * @author marti
 *
 */
public class TestNodoSimple {
	
	LinkedList<Integer> l1 = new MyLinkedList<>();
	
	@Test
	public void testAdd() {
		
	l1.add(0);
	l1.add(1);
	l1.add(2);
	l1.add(2);
	
	l1.addCoord(5, 2);
	Integer a=5;
	
	
	assertEquals(a,l1.getElementFrom(2));
	assertEquals(l1.size(),5);
	}
	
	@Test
	public void testSize() {
		l1.add(0);
		l1.add(1);
		l1.add(2);
		l1.add(2);
		
		l1.addCoord(5, 2);
		
		l1.delete(2);
		l1.delete(1);
		l1.delete(0);
		
		System.out.println(l1.size());
		
		assertEquals(2,l1.size());
	}

}
