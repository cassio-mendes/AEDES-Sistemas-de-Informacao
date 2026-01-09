package aula14;

public class testepilha {

    private static class Node { Object item; Node next; }

    private Node top;
    private int size;

    public testepilha() {
        this.top = null;
        this.size = 0;
    }

    public void stack(Object item) {
        Node oldTop = this.top;
        this.top = new Node();
        this.top.item = item;
        this.top.next = oldTop;
        this.size++;
    }

    public Object unstack() {
        if(this.isEmpty()) { return null; }

        Object item = this.top.item;
        this.top = this.top.next;

        this.size--;
        return item;
    }

    public void print() {
        if(!this.isEmpty()) {
            Node actual = this.top;

            while(actual != null) {
                System.out.println(actual.item);
                actual = actual.next;
            }

            System.out.println("Tamanho da pilha: " + this.size);
        }
    }

    private boolean isEmpty() { return this.top == null; }
}
