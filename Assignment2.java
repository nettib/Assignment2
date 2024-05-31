package com.aait.assignment2;

// Node class represents a node in the linked list containing a value and reference to the next node
class Node {
    int value;
    Node next;

    // Constructor to initialize a Node with a value
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}
// LinkedList class represents a singly linked list with various operations
class LinkedList {
    Node head; // Reference to the head of the linked list

    // Constructor to initialize an empty LinkedList
    LinkedList() {
        head = null;
    }

    // Method to insert a node at a specified position
    void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete a node at a specified position
    void deleteAtPos(int position) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Empty List");
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        int count = 1;
        while (current.next != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current.next == null) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        current.next = current.next.next;
    }

    // Method to delete a node after a given node
    void deleteAfterNode(int nodeValue) {
        Node current = head;
        while (current != null && current.value != nodeValue) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Node not found or no node exists after the given node");
        }
        current.next = current.next.next;
    }

    // Method to search for a node with a specific value
    int searchNode(int data) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.value == data) {
                System.out.println("Node with value " + data + " found at position: " + position);
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    // Method to display the LinkedList
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
// Stack class implements a stack using a linked list
class Stack {
    Node top; // Reference to the top of the stack

    // Constructor to initialize an empty stack
    Stack() {
        this.top = null;
    }

    // Method to push an element onto the stack
    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Method to pop an element from the stack
    int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    // Method to peek the top element of the stack
    int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    // Method to check if the stack is empty
    boolean isEmpty() {
        return top == null;
    }
}

// Main class to test the implementation of LinkedList and Stack
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding nodes to the linked list
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(40, 4);
        list.insertAtPos(50, 5);
        // Inserting a node at the middle position
        list.insertAtPos(60, 3);
        // Deleting a node at given position
        list.deleteAtPos(2);
        // Deleting a node after a given node
        list.deleteAfterNode(30);
        // Searching for a node
        list.searchNode(50);

        // Displaying the linked list
        list.display();

        // Creating a stack and performing operations
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Displaying top element of the stack
        System.out.println("Top element of the stack: " + stack.peek());

        // Popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());

        // Checking if stack is empty
        System.out.println("Is stack empty? " + (stack.isEmpty() ? "Yes" : "No"));
    }
}
