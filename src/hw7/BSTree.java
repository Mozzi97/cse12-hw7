/*
 * Name: Jinxiao Chen
 * ID:A14236655
 * Login:cs12xii
 */

package hw7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTree<T extends Comparable<? super T>>{

	private int nelems;
	private BSTNode root;
	private BSTNode found;

	 protected class BSTNode{

		T key;
		ArrayList<T> relatedInfo = new ArrayList<T>();
		BSTNode left;
		BSTNode right;
		

		/**
		 * A constructor that initializes the BSTNode instance variables.
		 * @param left left node
		 * @param right right node
		 * @param relatedInfo arraylist which includes nodes
		 * @param key key
		 */
		public BSTNode( BSTNode left, BSTNode right, ArrayList<T> relatedInfo,
				T key){
			this.left = left;
			this.right = right;
			this.relatedInfo = relatedInfo;
			this.key = key;
		}
		
		/**
		 * A constructor that initializes BSTNode variables
		 * @param left left node
		 * @param right right node
		 * @param key key
		 */
		public BSTNode(BSTNode left, BSTNode right,T key){
			this.left = left;
			this.right = right;
			this.key = key;
		}
		
		/**
		 * get the key
		 * @return key
		 */
		public T getKey(){
			return key;
		}
		
		/**
		 * Returns the left child of the node
		 * @return left child of the node
		 */
		public BSTNode getLeft(){
			return left;
			
		}
		
		/**
		 * Returns the right child of the node
		 * @return right child of the node
		 */
		public BSTNode getRight(){
			return right;
			
		}
		
		/**
		 * Returns the ArrayList of the node
		 * @return the ArrayList of the node
		 */
		public ArrayList<T> getRelatedInfo( ){
			return relatedInfo;
			
		}
		
		/**
		 * Setter for left pointer of the node
		 * @param newLeft left node
		 */
		public void setLeft( BSTNode newLeft){
			this.left = newLeft;
		}
		
		/**
		 * Setter for right pointer of the node
		 * @param newRight right node
		 */
		public void setRight( BSTNode newRight){
			this.right = newRight;
		}
		
		/**
		 * Setter for the ArrayList of the node
		 * @param newInfo the list to be set
		 */
		public void setRelatedInfo( ArrayList<T> newInfo){
			this.relatedInfo = newInfo;
		}
		
		/**
		 * Append new info to the end of the existing ArrayList of the node
		 * @param info data to be added
		 */
		public void addNewInfo(T info){
			this.relatedInfo.add(info);
		}
		
		/**
		 * Remove info from the ArrayList of the node and return true. If 
		 * the ArrayList does not contain the value info, return false
		 * @param info data to be added
		 * @return true if info is in list, false if not
		 */
		public boolean removeInfo(T info){
			return this.relatedInfo.remove(info);	
		}
		
	}
	 


	//BSTree methods here
	 /**
	  * A 0-arg constructor that initializes root to null and nelems to 0
	  */
	 public BSTree(){
		 this.root = null;
		 this.nelems = 0;
	 }
	 
	 /**
	  * Returns the root of BSTree. Returns null if the tree is empty
	  * @return Returns the root of BSTree. Returns null if the tree is empty
	  */
	 public BSTNode getRoot(){
		 if(nelems == 0){
			 return null;
		 }
		 else{
			 return root;
		 }
	 }
	 
	 /**
	  * Returns nelems
	  * @return Returns nelems
	  */
	 public int getSize(){
		 return nelems;
	 }
	 

	 /**
	  * Inserts a key into the BST. Throws NullPointerException if key is null
	  * @param key key to be inserted
	  * @throws NullPointerException key is null
	  */
	 public void insert(T key) throws NullPointerException{
		 if(key == null){
			 throw new NullPointerException();
		 }
		 if(this.getRoot() == null){
			 BSTNode newnode = new BSTNode(null,null,key);
			 this.root = newnode;
			 nelems++;
			 return;
		 }
		 this.addhelper(root, key);
	 }
	 
	 private void addhelper(BSTNode current, T key){
		if(current.getKey().compareTo(key)<0){
			 if(current.getRight() != null){
				 current = current.getRight();
				 addhelper(current,key);
			 }
			 else{
				 BSTNode newnode = new BSTNode(null,null,key);
				 current.setRight(newnode);
				 nelems ++;
				 return;
				 
			 }
		 }
		 else if(current.getKey().compareTo(key)>0){
			 if(current.getLeft() != null){
				 current = current.getLeft();
				 addhelper(current,key);
			 }
			 else{
				 BSTNode newnode = new BSTNode(null,null,key);
				 current.setLeft(newnode);
				 nelems ++;
				 return;
			 }
		 }
		 else{
			 System.out.println("The key " + key + " is already in the tree.");
		 }
		 
	 }
	 
	 /**
	  * Return true if the key is found in the tree, false otherwise. 
	  * Throw NullPointerException if key is null
	  * @param key key to be inserted
	  * @return Return true if the key is found in the tree, false otherwise.
	  * @throws NullPointerException key is null
	  */
	 public boolean findKey(T key) throws NullPointerException{
		 if(key == null){
			 throw new NullPointerException();
		 }
		 return findhelper(root,key);
		 
	 }
	 
	 private boolean findhelper(BSTNode current, T key){
		 if(current.getKey().compareTo(key)==0){
			 found = current;
			 return true;
		 }
		 else if(current.getKey().compareTo(key)<0){
			 if(current.getRight() != null){
				 current = current.getRight();
				 return findhelper(current,key);
			 }
			 else{
				 return false;
			 }
		 }
		 else if(current.getKey().compareTo(key)>0){
			 if(current.getLeft() != null){
				 current = current.getLeft();
				 return findhelper(current,key);
			 }
			 else{
				 
				 return false;
			 }
		 }

		return false;
	 }
	 
	 /**
	  * Inserts info into the ArrayList of the node whose key is key.
	  * @param key key to be inserted
	  * @param info data to be inserted
	  * @throws NullPointerException key is null
	  * @throws IllegalArgumentException key is not found in the BST
	  */
	 public void insertInformation(T key, T info)throws 
	 	NullPointerException, IllegalArgumentException{
		 if(key == null){
			 throw new NullPointerException();
		 }
		 if(!this.findKey(key)){
			 throw new IllegalArgumentException();
		 }
		 else{
			 this.found.addNewInfo(info);
		 }
	 }
	 
	 /**
	  * Return the ArrayList of the node with key value key
	  * @param key key to be found
	  * @return Return the ArrayList of the node with key value key
	  * @throws NullPointerException key is null
	  * @throws IllegalArgumentException key is not found in the BST
	  */
	 public ArrayList<T> findMoreInformation(T key) throws 
	 	NullPointerException, IllegalArgumentException{
		 if(key == null){
			 throw new NullPointerException();
		 }
		 if(!this.findKey(key)){
			 throw new IllegalArgumentException();
		 }
		 else{
			 return this.found.getRelatedInfo();
		 }
		 
	 }
	 
	 /**
	  * Returns the height of the tree. The height of a tree is the length 
	  * of the longest downward path to a leaf from the root. By convention, 
	  * height of an empty tree is -1 and the height of the root is 0.
	  * @return he height of the tree
	  */
	 public int findHeight(){

		return this.heighthelper(root);
		 
	 }
	 
	 private int heighthelper(BSTNode node){
		 if (node == null) {
		        return -1;
		    }

		    int lefth = heighthelper(node.left);
		    int righth = heighthelper(node.right);

		    if (lefth > righth) {
		        return lefth + 1;
		    } else {
		        return righth + 1;
		    }
	 }
	 
	 /**
	  * Returns the number of leaf nodes in the tree.
	  * @return Returns the number of leaf nodes in the tree.
	  */
	 public int leafCount(){
		 return leafhealper(root);
	 }
	 private int leafhealper(BSTNode node) 
	    {
	        if (node == null)
	            return 0;
	        if (node.left == null && node.right == null)
	            return 1;
	        else
	            return leafhealper(node.left) + leafhealper(node.right);
	    }

	 /**
	  * return iterator
	  * @return return iterator
	  */
	 public Iterator<T> iterator() {
		 return new BSTree_Iterator();
		 }
	 

	 
	//BSTree_Iterator here
	 
	 protected class BSTree_Iterator implements Iterator<T>{
		public Stack<BSTNode> stack = new Stack<BSTNode>();
		BSTNode next = null;
		void AddNodeToStack(BSTNode current){
			while (current != null) {
				stack.push(current);
				current = current.getLeft();
			}
		}
		/**
		 * Constructor that initializes the Stack with the leftPath of the root
		 */
		public BSTree_Iterator(){	 
			 next = root;
		}
		
			    
		
		/**
		 * Returns false if the Stack is empty no more nodes left 
		 * to iterate, true otherwise
		 * @return Returns false if the Stack is empty
		 */
		public boolean hasNext() {
			if (next != null) {
	            AddNodeToStack(next);
	            next = null;
	        }
	        return !stack.isEmpty();
		}

		/**
		 * Returns the next item in the BST. Throws NoSuchElementException 
		 * if there is no next item
		 * @throws NoSuchElementException if there is no next item
		 */
		
		public T next() throws NoSuchElementException{
		if (!hasNext()) {
			throw new NoSuchElementException();
        }
        BSTNode cur = stack.pop();
        next = cur.getRight();
        return cur.getKey();
    }

	 }
}
