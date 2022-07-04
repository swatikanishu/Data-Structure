package array2dstack;

public class Stack {

        Node head;
        static int size;

        public void push(int data) {
            addFirst(data);
        }

        public boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        private void addFirst(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        private void enqueue(int data) {
            addLast(data);
        }

        private void addLast(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }

            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }

        public void peek() {
            if (isEmpty()) {
                return;
            }
            System.out.println(head.data);
        }

        public void pop() {
            System.out.println(head.data);
            deleteFirst();

        }

        private void dequeue() {
            deleteFirst();
        }

        private void deleteFirst() {
            if (isEmpty()) {
                return;
            }
            head = head.next;
            size--;
        }

        private void deleteLast() {
            if (isEmpty()) {
                return;
            }
            size--;
            if (head.next == null) {
                head = null;
                return;
            }
            Node currNode = head;
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            currNode.next = null;
        }

        private void delete(int data) {
            if (search(data)) {
                size--;
                if (head.data == data) {
                    head = head.next;
                    return;
                }
                Node currNode = head;
                while (currNode.next.data != data) {
                    currNode = currNode.next;
                }
                Node temp = currNode.next.next;
                currNode.next = temp;

            }
        }

        private void insertAfter(int element, int data) {
            Node currNode = head;
            if (search(element)) {
                while (currNode.data != element) {
                    currNode = currNode.next;
                }
                Node node1 = new Node(data);
                Node temp = currNode.next;
                currNode.next = node1;
                node1.next = temp;
            }
        }

        private void insertBetween(int element1, int element2, int data) {
            if (head == null || head.next == null) {
                // System.out.println("List contain only one element. So data can't be inserted
                // between one number.");
                return;
            }

            Node currNode = head;
            while (currNode.data != element1 || currNode.next.data != element2) {
                if (currNode.next.next == null) {
                    break;
                }
                currNode = currNode.next;
            }
            if (currNode.data == element1 && currNode.next.data == element2) {
                Node newNode = new Node(data);
                Node temp = currNode.next;
                currNode.next = newNode;
                newNode.next = temp;
            }
        }

        private void descOrder() {
            if (isEmpty()) {
                return;
            }
            int exchanged = 1;
            while (exchanged != 0) {
                Node currNode = head;
                exchanged = 0;
                while (currNode.next != null) {
                    if (currNode.data < currNode.next.data) {
                        int temp = currNode.next.data;
                        currNode.next.data = currNode.data;
                        currNode.data = temp;
                        exchanged++;
                    }
                    currNode = currNode.next;
                }

            }
        }

        private boolean search(int data) {
            if (isEmpty()) {
                return false;
            }
            Node currNode = head;
            while (currNode.data != data) {
                if (currNode.next == null) {
                    return false;
                }
                currNode = currNode.next;
            }
            return true;
        }

        public int getSize() {
            System.out.println();
            return size;
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("List is empty.");
                return;
            }
            Node currNode = head;
            while (currNode != null) {
                System.out.print(currNode.data + "  ");
                currNode = currNode.next;
            }
        }

        public void primeAnagramPrint() {
            PrimeAnagramStack ob1 = new PrimeAnagramStack();
            ob1.anagramNo();
            for (int i = 0; i < ob1.listAnagram.size(); i++) {
                for (int j = 0; j < ob1.listAnagram.get(i).size(); j++) {
                    push((int) ob1.listAnagram.get(i).get(j));
                }
            }
            descOrder();
            show();

        }
    }
