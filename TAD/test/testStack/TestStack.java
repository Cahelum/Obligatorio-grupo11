package testStack;

import static org.junit.Assert.*;

import org.junit.Test;

import stack.ExepcionStackVacio;
import stack.MyStack;

public class TestStack {
	@Test
	public void test(){
		
	MyStack<Integer> l1 = new MyStack<>();

	l1.push(0);
	l1.push(1);
	l1.push(2);
	l1.push(3);

	System.out.println(l1.isEmpty());

		try {
			l1.pop();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			assertEquals((int)l1.top(), 2);
		} catch (ExepcionStackVacio e1) {
			e1.printStackTrace();
		}
		try {

			System.out.println(l1.top());

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

