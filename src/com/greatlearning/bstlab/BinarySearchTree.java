package com.greatlearning.bstlab;

import java.util.ArrayList;

class Node {

 int data;
 Node left, right;

 Node(int i)
 {
     data = i;
     left = right = null;
 }
}

class BinarySearchTree {
 Node root;
 
 BinarySearchTree()
 {
     root = null;
 }

 // Inorder traversal 
 void inorder()
 {
     inorderUtil(this.root);
 }

 //  Function for inorder traversal of the tree
 void inorderUtil(Node node)
 {
     if (node == null)
         return;

     inorderUtil(node.left);
     System.out.print(node.data + " ");
     inorderUtil(node.right);
 }

 void insert(int key)
 {
     root = insertRec(root, key);
 }

 /* Recursive function to insert new key in BST */
 Node insertRec(Node root, int data)
 {
     if (root == null) {
         root = new Node(data);
         return root;
     }
     if (data < root.data)
         root.left = insertRec(root.left, data);
     else if (data > root.data)
         root.right = insertRec(root.right, data);

     return root;
 }

 ArrayList<Integer> treeToList(Node node, ArrayList<Integer>list)
 {
     if (node == null)
         return list;

     treeToList(node.left, list);
     list.add(node.data);
     treeToList(node.right, list);

     return list;
 }

 boolean isPairPresent(Node node, int target)
 {
     ArrayList<Integer> al1 = new ArrayList<>();
     ArrayList<Integer> al2 = treeToList(node, al1);

     int start = 0;

     int end = al2.size() - 1; // Ending index of al2

     while (start < end) {

         if (al2.get(start) + al2.get(end) == target)
         {
        	 System.out.println("Sum " + " = " + target);
             System.out.println("Pair is " + "(" + al2.get(start) + " , " + al2.get(end) + ")");
             return true;
         }

         if (al2.get(start) + al2.get(end) > target)
         {
             end--;
         }

         if (al2.get(start) + al2.get(end) < target)
         {
             start++;
         }
     }

     System.out.println("Nodes are not found!");
     return false;
 }

 public static void main(String[] args)
 {
     BinarySearchTree tree = new BinarySearchTree();
     tree.insert(40);
     tree.insert(20);
     tree.insert(60);
     tree.insert(10);
     tree.insert(30);
     tree.insert(50);
     tree.insert(70);

     tree.isPairPresent(tree.root, 130);
 }
}
