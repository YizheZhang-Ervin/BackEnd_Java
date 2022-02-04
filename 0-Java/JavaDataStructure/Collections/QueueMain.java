import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
//        int size()：获取队列长度；
//        boolean add(E)/boolean offer(E)：添加元素到队尾；
//        E remove()/E poll()：获取队首元素并从队列中删除；
//        E element()/E peek()：获取队首元素但并不从队列中删除。

        Queue<String> q = new LinkedList<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        // 队首永远都是apple，因为peek()不会删除它:
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple

        // 从队列取出元素:
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // null,因为队列是空的
    }
}
