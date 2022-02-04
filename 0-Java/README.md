# TMPL_JavaTools

## 目录
1. 核心类 (自带见JavaLibs,外部见JavaUtils)
2. 异常与日志 (见JavaBasic.Exception)
3. 反射 (见JavaBasic.Reflection)
4. 注解 (见JavaBasic.Annotation)
5. 泛型 (见JavaBasic.GenericParadigm)
6. 集合 (见JavaDataStructure)
7. IO (见JavaBasic.IO)
8. 日期时间 (见Java8)
9. 单元测试 (见JavaBasic.Test)
10. 正则表达式 (见JavaBasic.RegExp)
11. 加密安全 (见JavaBasic.Encrypt)
12. 多线程(见JavaThread)
13. Maven (JavaMaven)
14. 网络编程 (见JavaNetwork)
15. XML与JSON (见JavaBasic.XML_JSON)
16. JDBC (见JavaBasic.JDBC)
17. 函数式编程 (见Java8)
18. 设计模式 (见JavaDesignPattern)
19. Web开发 (无)
20. Spring (无)
21. Spring Boot (无)
22. Spring Cloud (无)

### Java 8
- Lambda
- Stream
- Optional
- Interface
- Date
- Annotation

### Java Basic
- 注解
- 加密安全
- 异常与日志
- 泛型
- IO
- JDBC
- 正则表达式
- 单元测试
- XML与JSON
- 反射

### JavaDataStructure
- Collections
  - List
  - Map
  - Properties
  - Set
  - Queue
  - Deque
  - PriorityQueue
  - Stack
  - Iterator
  - Collections
- Algorithms
  - graph
  - heap
  - linear
  - priority
  - sort
  - symbol
  - test
  - tree
  - uf

### JavaDesignPattern
- Creational Pattern
- Structural Pattern
- Behavioral Pattern

### JavaLibs
- 字符串
- StringBuilder
- StringJoiner
- 包装类型
- JavaBean
- 枚举
- 常用工具类

### JavaMaven
- plugin
- wrapper

### Java Network
- Socket / ServerSocket

### JavaThread
- Thread
  - run/start/setname/join/getid/getname/getpriority/getstate
  - isinterrupted/isalive/interrupted/interrupt/currentthread/sleep/yield
- futuretask
  - get
- LockSupport
  - park/unpark/setdaemon
- synchronized
  - wait/notify/notifyall
- volatile
- cas
  - 原子整数AtomicInteger/atomicinteger/atomiclong
  - 原子引用 AtomicReference/AtomicStampedReference/AtomicMarkableReference
  - 原子数组AtomicIntegerArray/atomiclongarray/atomicreferencearray
  - 原子更新器AtomicReferenceFieldUpdater/atomicintegerfieldupdater/atomiclongdieldupdater
  - 原子累加器LongAdder/LongAccumulator
    - increment
  - 原子整数atomicboolean
  - unsafe
    - setaccessible/get.objectfieldoffset/get.compareandswap
- 不可变对象 + final
- 线程池
  - ThreadPoolExecutor
    - newfixedthreadpool/newcachedthreadpool/newsinglethreadexecutor
      - execute/submit/invokeAll/invokeAny/shutdown/shutdownnow/isshutdown/isterminated/awaittermination
  - ScheduledThreadPoolExecutor
    - schedule/scheduleatfixedrate/schedulewithfixeddelay
  - fork/join
    - invoke(recursivetask)
  - aqs
    - tryacquire/tryrelease/tryacquireshared/tryreleaseshared/isheldexclusively
    - ReentrantLock
      - lock/unlock/lockinterruptibly/trylock
      - newcondition/await/signal/signalall
      - reentrantreadwritelock(readlock/writelock)
      - stampedlock(unlockread(stamp)/unlockwrite(stamp))
    - semaphore
      - acquire/release
    - countdownlatch
    - future
    - cyclicbarrier
      - await
- 线程安全类    
  - Hashtable/vector
  - synchronizedmap/synchronizedlist
  - blocking(linkedblockingqueue/arrayblckingqueue/concurrentlinkedqueue)
  - concurrent(concurrenthashmap/concurrentlinkedqueue)
  - copyonwriter(copyonwritearraylist)
- 设计模式
  - 两阶段终止
  - 保护性暂停
  - 生产者消费者
  - 固定运行顺序
  - 交替输出
  - 犹豫模式
  - 享元模式
  - 工作线程

### JavaUtils
- Apache Commons
- Google Guava
- Spring
- 其他核心类