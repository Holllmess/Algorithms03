import java.util.Iterator;

public class Sample01 {
    public static void main(String[] args) {
        SingleLinkedList<Integer> demoList = new SingleLinkedList<>();
        demoList.addToEnd(11);
        demoList.addToEnd(22);
        demoList.addToEnd(33);
        demoList.addToEnd(44);

        for (Integer value : demoList) {
            System.out.println(value);
        }

        System.out.println();

        demoList.reverse();
        for (Integer value : demoList) {
            System.out.println(value);
        }
    }

    public static class SingleLinkedList<T> implements Iterable<T>{

        Node<T> head;
        Node<T> tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {

                Node<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T value = current.value;
                    current = current.next;
                    return value;
                }
            };
        }


        private static class Node<T>{
            T value;
            Node<T> next;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public void addToEnd(T value){
            Node<T> node = new Node<>();
            node.value = value;
            if (isEmpty()){
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        public void reverse(){
            if (!isEmpty() && head.next != null){
                tail = head;
                Node<T> current = head.next;
                head.next = null;
                while (current != null){
                    Node<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}
