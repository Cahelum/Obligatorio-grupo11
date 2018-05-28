package testBinaryTree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import binaryTree.BinaryTree;
import binaryTree.MyBinaryTree;
import binaryTree.NodeBST;
import nodoSimple.LinkedList;
import nodoSimple.MyLinkedList;

public class TestBinaryTree {

	private static BinaryTree<Integer, String> bt;

	@Test
	public void testInsert() {

		bt = new MyBinaryTree<>();

		bt.insert(50, "raiz");
		bt.insert(80, "derecho1");
		bt.insert(30, "izquierdo1");
		bt.insert(20, "izquierdo2.1");
		bt.insert(35, "izquierdo2.2");

		assertEquals("izquierdo2.2", bt.find(35));

	}

	@Test
	public void testDelete() {
		
		ArrayList<Integer> verifico=new ArrayList<>();
		LinkedList<Integer> resultado=new MyLinkedList<>();

		bt = new MyBinaryTree<>();

		bt.insert(50, "raiz");
		bt.insert(80, "derecho1.d");
		bt.insert(30, "izquierdo1.i");
		bt.insert(20, "izquierdo2.i");
		bt.insert(35, "izquierdo2.d");
		bt.insert(100, "dat");
		
		verifico.add(50);
		verifico.add(20);
		verifico.add(80);	
		verifico.add(35);
		verifico.add(100);
		bt.delete(30);
		
		resultado=bt.porNivel();
		
		
for (int i = 0; i < resultado.size(); i++) {
			
			assertEquals(verifico.get(i),resultado.getElementFrom(i));
			
		}

        
	//	assertEquals(null,bt.find(100) );

	}
}
