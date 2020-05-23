package ShuntingYard_Pseudocode;

import java.util.LinkedList;

public class MyStack<E> {

    private LinkedList<E> list = new LinkedList<>();

    public MyStack() {

    }


    public void push(E x) {
        list.add(x);
    }


    public E pop() {
        return list.removeLast();
    }


    public E top() {
        return list.peekLast();
    }


    public boolean empty() {
        return list.isEmpty();
    }

}
