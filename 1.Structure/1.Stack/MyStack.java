public class MyStack {
    private int[] stack;
    private int top;
    private int capacity;

    public MyStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int item) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        stack[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    // 테스트용 main
    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println("peek: " + myStack.peek()); // 30
        System.out.println("pop: " + myStack.pop());   // 30
        System.out.println("peek after pop: " + myStack.peek()); // 20
        System.out.println("size: " + myStack.size()); // 2
    }
}
