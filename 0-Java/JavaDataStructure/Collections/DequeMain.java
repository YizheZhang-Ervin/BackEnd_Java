import java.util.Deque;
import java.util.LinkedList;

public class DequeMain {
    public static void main(String[] args) {
//        添加元素到队尾	addLast(E e) / offerLast(E e)
//        取队首元素并删除		E removeFirst() / E pollFirst()
//        取队首元素但不删除		E getFirst() / E peekFirst()
//        添加元素到队首		addFirst(E e) / offerFirst(E e)
//        取队尾元素并删除	E removeLast() / E pollLast()
//        取队尾元素但不删除	E getLast() / E peekLast()

        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // A <- B
        deque.offerFirst("C"); // C <- A <- B
        System.out.println(deque.pollFirst()); // C, 剩下A <- B
        System.out.println(deque.pollLast()); // B, 剩下A
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }
}
