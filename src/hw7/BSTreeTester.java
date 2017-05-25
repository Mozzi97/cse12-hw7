/*
 * Name: Jinxiao Chen
 * ID:A14236655
 * Login:cs12xii
 */

package hw7;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import hw7.BSTree.BSTree_Iterator;

public class BSTreeTester {
	private BSTree<Integer> tree1;
	private BSTree<Integer> empty;
	private ArrayList<Integer> list;
	
	
	
	@Before
	public void setup(){
		tree1 = new BSTree<Integer>();
		empty = new BSTree<Integer>();
		list = new ArrayList<Integer>();
		list.add(300);
		
		tree1.insert(300);tree1.insert(200);tree1.insert(400);		
		tree1.insert(150);
		tree1.insert(100);
		tree1.insert(175);tree1.insert(176);
	}

	@Test
	public void testInsert() {
		assertEquals("Check insert",true,tree1.findKey(300)) ;
	}
	
	@Test
	public void testfind() {
		assertEquals("Check find",true,tree1.findKey(150)) ;
		tree1.insert(1);
		assertEquals("Check find",true,tree1.findKey(1)) ;
		tree1.insert(-999);
		assertEquals("Check find",true,tree1.findKey(-999)) ;
	
		assertEquals("Check find",false,tree1.findKey(30)) ;
	}
	
	@Test
	public void testsize() {
		tree1.insert(1);
		assertEquals("Check size",8,tree1.getSize()) ;
	}
	
	@Test
	public void testroot() {
		assertEquals("Check root",(Integer)300,(Integer)
				tree1.getRoot().getKey()) ;
		empty.insert(1);
		assertEquals("Check root",(Integer)1,(Integer)
				empty.getRoot().getKey());
	}
	
	@Test
	public void testinsertinfo() {
		tree1.insertInformation(300,300);
		assertEquals("Check insertInformation",list,
				tree1.findMoreInformation(300)) ;

	}
	
	
	@Test
	public void testiterator() {
		BSTree_Iterator ite;
		ite = (BSTree_Iterator) tree1.iterator();	
		assertEquals("Check iterator hasnext",true,ite.hasNext()) ;

	}
	
	@Test
	public void testitenext() {

		BSTree_Iterator ite;
		ite = (BSTree_Iterator) tree1.iterator();
		assertEquals("Check iterator next",100,ite.next()) ;

	}
	
	@Test
	public void testitenext2() {

		BSTree_Iterator ite;
		ite = (BSTree_Iterator) tree1.iterator();

		assertEquals("Check iterator next",100,ite.next());
		assertEquals("Check iterator next",150,ite.next());

		assertEquals("Check iterator next",175,ite.next());
		assertEquals("Check iterator next",176,ite.next());
		assertEquals("Check iterator next",200,ite.next());
		assertEquals("Check iterator next",300,ite.next());
		assertEquals("Check iterator next",400,ite.next());
		

	}
	
	@Test
	public void testheight(){
		assertEquals("Check height",4,tree1.findHeight()) ;
	}
	
	@Test
	public void testleaf(){
		assertEquals("Check height",3,tree1.leafCount()) ;
	}

}
