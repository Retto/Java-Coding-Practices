package com.retto.practices03;

import java.util.Stack;

/**
 * Hi, here's your problem today. This problem was recently asked by Apple:

Given an integer k and a binary search tree, find the floor (less than or equal to) of k, and the ceiling (larger than or equal to) of k. 
If either does not exist, then print them as None.

Here is the definition of a node for the tree.

Solution: Use Stack data structure to solve problem
 *
 */
public class Solution {
	   
    private static void findCeilingFloor(Node root, int k) {
        // System.out.println("root:" + root);
       
        // perform Depth First Search Algorithm
        // use Stack for graph traversal
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
       
        Node lastParent = root;
        while(!stack.empty()) {
            Node current = stack.pop();
            if(current.value == k) {
                System.out.println("Floor:" + current.value);
                System.out.println("Ceiling:" + current.value);
                break;
            } else if(current.value > k ){
                if(current.left != null) {
                    stack.push(current.left);
                    lastParent = current;
                }
                else{
                    System.out.println("Floor:" + lastParent.value);
                    System.out.println("Ceiling:" + current.value);
                }
            } else {
                if(current.right != null) {
                    stack.push(current.right);
                    lastParent = current;
                }
                else {
                    System.out.println("Floor:" + current.value);
                    System.out.println("Ceiling:" + lastParent.right.value);
                }
            }
        }
    }
   
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
 
        root.left.left = new Node(2);
        root.left.right = new Node(6);
 
        root.right.left = new Node(10);
        root.right.right = new Node(14);
       
        findCeilingFloor(root, 5);
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;
   
    public Node(int value) {
        this.value = value;
    }
   
    @Override
    public String toString() {
        return String.format("[value:%s, left: %s, right: %s]", value, left, right);
    }
   
}
