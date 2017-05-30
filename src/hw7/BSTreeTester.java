/*
 * Name: Jinxiao Chen
 * ID:A14236655
 * Login:cs12xii
 */

package hw7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import hw7.BSTree.BSTree_Iterator;

public class BSTreeTester {
	private BSTree<Integer> tree1;
	private BSTree<Integer> empty;
	private ArrayList<Integer> list;
	private BSTree<Integer> tree2;
	private BSTree<Integer> com;
	BSTree tree = new BSTree();
	private ArrayList<Integer> result;
	
	
	
	@Before
	public void setup(){
		tree1 = new BSTree<Integer>();
		empty = new BSTree<Integer>();
		tree2 = new BSTree<Integer>();
		com = new BSTree<Integer>();
		list = new ArrayList<Integer>();
		result = new ArrayList<Integer>();
		list.add(300);
		
		tree1.insert(300);tree1.insert(200);tree1.insert(400);		
		tree1.insert(150);
		tree1.insert(100);
		tree1.insert(175);tree1.insert(176);
		
		tree2.insert(300);tree2.insert(100);
		tree2.insert(20);
		
		
		com.insert(10);
		com.insert(8);
		com.insert(12);		
		com.insert(3);

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
		assertEquals("Check leaf",3,tree1.leafCount()) ;
	}
	
//	@Test
//	public void testlevel(){
//		assertEquals("Check level",2,tree1.levelCount(1)) ;
//	}
//	
//	@Test
//	public void testareCousins(){
//		tree1.insert(450);
//		assertEquals("Check areCousins",true,tree1.areCousins(150,450)) ;
//	}
//	@Test
//	public void testcomplete(){
//		assertEquals("Check isComplete",false,tree1.isCompleteBST()) ;
//		assertEquals("Check isComplete",true,com.isCompleteBST());
//
//	}
	
//	@Test
//	public void testtwotrees(){
//		result.add(100);
//		result.add(300);
//		BSTree_Iterator ite1 = (BSTree_Iterator) tree1.iterator();
//		BSTree_Iterator ite2 = (BSTree_Iterator) tree2.iterator();
//		assertEquals("Check two trees",result,tree.intersection(ite1,ite2)) ;
//	}

}
