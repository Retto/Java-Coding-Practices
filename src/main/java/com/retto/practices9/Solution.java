package com.retto.practices9;

import java.util.*;

class Queue {
    Stack<Integer> mainStack;
    Stack<Integer> helperStack;

    public Queue() {
        mainStack = new Stack<Integer>();
        helperStack = new Stack<Integer>();
    }
    
    public void enqueue(int x) {
        while(mainStack.size() > 0) {
            helperStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while(helperStack.size() > 0) {
            mainStack.push(helperStack.pop());
        }
    }
    
    public int dequeue() {
        if(mainStack.size() > 0)
            return mainStack.pop();
        else
            return -1;
    }
    
    public int peek() {
        if(mainStack.size() > 0)
            return mainStack.peek();
        else
            return -1;
    }
    
    public boolean empty() {
        return mainStack.size() == 0;
    }
}

public class Solution {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
