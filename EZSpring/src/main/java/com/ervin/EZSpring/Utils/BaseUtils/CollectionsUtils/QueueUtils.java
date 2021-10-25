package com.ervin.EZSpring.Utils.BaseUtils.CollectionsUtils;

public class QueueUtils {
    static String getQueueAPI(){
        return
            """
                Queue<String> q = new LinkedList<>();
                int size()：获取队列长度；
                boolean add(E)/boolean offer(E)：添加元素到队尾；
                E remove()/E poll()：获取队首元素并从队列中删除；
                E element()/E peek()：获取队首元素但并不从队列中删除。
            """;
    }

    static String getPriorityQueueAPI(){
        return
            """
                Queue<User> q = new PriorityQueue<>(new UserComparator());
                offer()
                poll()
            """;
    }

    static String getDequeAPI(){
        return
            """
                Deque<String> deque = new LinkedList<>();
                添加元素到队尾	addLast(E e) / offerLast(E e)
                取队首元素并删除		E removeFirst() / E pollFirst()
                取队首元素但不删除		E getFirst() / E peekFirst()
                添加元素到队首		addFirst(E e) / offerFirst(E e)
                取队尾元素并删除	E removeLast() / E pollLast()
                取队尾元素但不删除	E getLast() / E peekLast()
            """;
    }

    // 遗留类stack不要用,用deque代替
    static String getStackAPI(){
        return
            """
                把元素压栈：push(E)/addFirst(E)
                把栈顶的元素“弹出”：pop()/removeFirst()
                取栈顶元素但不弹出：peek()/peekFirst()
            """;
    }
}
