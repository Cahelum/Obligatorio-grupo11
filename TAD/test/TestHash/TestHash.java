package TestHash;
import static org.junit.Assert.*;

import org.junit.Test;

import hash.HashTable;
import hash.MyHashTable;

public class TestHash {

	@Test
	public void test() {
		
		Pais a=new Pais("argentina");
		
		HashTable<Pais,String> ht=new MyHashTable<>(120);
		try {
			
			ht.insertar(a, "traeme la copa messi");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
