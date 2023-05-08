package sequential;

import util.Node;

public class Functions {

    private Functions() {

    }

    public static <T> boolean isCircular(Node<T> node) {
        Node<T> head = node;

        while (node != null) {
            node = node.getNext();
            if (node == head) {
                return true;
            }
        }
        return false;
    }

    public static <T> Node<T> reverse(Node<T> node) {
        Node<T> newNode = null;
        while (node != null) {
            Node<T> next = node.getNext();
            node.setNext(newNode);
            newNode = node;
            node = next;
        }
        return newNode;
    }

    public static <T> boolean isPalindrome(Node<T> node) {
        return false;
    }

}
