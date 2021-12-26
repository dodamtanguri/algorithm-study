package datastructure;

import sun.security.util.DerEncoder;

public class BST {
    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        //CASE 1 : Node가 하나도 없을 경우
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            //CASE 2: Node가 하나 이상 들어가 있을 경우
            Node findNode = this.head;
            while (true) {
                //CASE 2-1 현재 Node의 왼쪽에 Node 가 들어가야 할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                    //CASE 2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할 때
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node searchNode(int data) {
        if (this.head == null) {
            return null;
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        BST test = new BST();
        test.insertNode(2);
        test.insertNode(3);
        test.insertNode(4);
        test.insertNode(6);

        Node testNode = test.searchNode(3);
        System.out.println(testNode.right.value);
    }
}
