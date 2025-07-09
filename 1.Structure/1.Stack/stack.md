## 스택이란?

LIFO → Last In First Out 구조로

가장 마지막에 들어온 데이터를 가장 먼저 나오는 자료구조이다.

일반적으로 뒤로가기 버튼이나 Undo 기능같은걸 구현하거나

재귀알고리즘을 구축할때 또는 이를 이용한 DFS 같은 다른 자료구조의 쓰이기도하는데

사실 매우 특정한 상황이 아니면 서비스 개발때는 사용해본 경험이 없어서

알고 있고, 테스트때만 좀 잘 이해하면 충분한 자료구조라고 생각된다.

## 꼭 만들어야할 메서드

주로 5가지의 메서드를 사용하게 되는데

일단 넣고 빼는 Push , Pop

데이터를 꺼내지않고 확인하는 Peek

비어있는지 확인, 사이즈를 확인 하는 isEmpty , size 는 꼭 구현해야한다.

다만, 워낙 오래된 자료구조라 어지간한 레벨의 언어에서는 기본지원을

하는 경우가 많기 때문에 import해서 쓰길 바라며, 배우기 위해서 구현해보는 정도로

생각해보자

일단 Java 내장 Stack은 다음처럼 사용하면되는데

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("peek: " + stack.peek()); // C
        System.out.println("pop: " + stack.pop());   // C
        System.out.println("peek after pop: " + stack.peek()); // B
        System.out.println("isEmpty: " + stack.isEmpty()); // false
    }
}

```

이렇게 간단하게 구현할 수 있음으로 이정도만 구현해도 충분하다고 보인다.

배열을 기반해서 실제로 자료구조를 한번 구현해보면

```java
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

```

이런식으로 구현해볼 수 있는데 딱히 까다로운건 없으니 컨셉만 잘기억하면 된다.

“마지막에 들어온게 먼저 나간다”
