class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }
}

public class BusRouteStops {

    static Node build(String[] stops) {

        Node head = null, tail = null;

        for (String stop : stops) {

            Node newNode = new Node(stop);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    static void printRoute(Node head) {

        int count = 0;
        String first = head.data;
        String last = "";

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + " -> ");
            last = temp.data;
            count++;

            temp = temp.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count +
                ", First: " + first +
                ", Last: " + last);
    }

    public static void main(String[] args) {

        String[] stops =
                {"Tambaram","Guindy","TNagar","Central"};

        Node head = build(stops);

        printRoute(head);
    }
}