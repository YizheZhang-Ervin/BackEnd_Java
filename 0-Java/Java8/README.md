# Java8
1. Lambda
  - (1)引用
    - 函数引用
      - 对象的引用 :: 实例方法名
      - 类名 :: 静态方法名
      - 类名 :: 实例方法名
    - 构造器引用
      - 类名 :: new
    - 数组引用
      - 类型[] :: new
  - (2)核心函数式接口
    - java.util.function.Consumer
    - java.util.function.Function
    - java.util.function.Predicate
    - java.util.function.Supplier
  
2. Stream
  - (1)创建
    - xxCollection.stream() 与 xxCollection.parallelStream()
    - Arrays.stream(数组流);
    - Stream.of()
    - 无限流
      - Stream.iterate().limit()
      - Stream.generate().limit()
  - (2)中间操作
    - 内部迭代
      - xxCollection.filter()
      - xxCollection.forEach()
    - 外部迭代
      - xxCollection.iterator()
    - 筛选与切片
      - filter
      - limit
      - skip(n)
      - distinct
    - 映射
      - map
      - flatMap
    - 排序
      - sorted()
      - sorted(Comparator com)
  - (3)终止
    - allMatch——检查是否匹配所有元素
    - anyMatch——检查是否至少匹配一个元素
    - noneMatch——检查是否没有匹配的元素
    - findFirst——返回第一个元素
    - findAny——返回当前流中的任意元素
    - count——返回流中元素的总个数
    - max——返回流中最大值
    - min——返回流中最小值
    - reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
    - collect(Collectors.方法)
      - toList/toSet/toCollection
      - maxBy/minBy/summingDouble/averagingDouble/counting/summarizingDouble
      - groupingBy 分组、多级分组
      - partitioningBy 分区
      - joining 合并
      - reducing
  - (4)并行流fork/join
    - java.util.concurrent.ForkJoinPool
    - java.util.concurrent.ForkJoinTask
    - java.util.stream.LongStream
    - java.util.concurrent.RecursiveTask
    - parallel

3. Optional
  - Optional.of(T t) : 创建一个 Optional 实例
  - Optional.empty() : 创建一个空的 Optional 实例
  - Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
  - isPresent() : 判断是否包含值
  - orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
  - orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
  - map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
  - flatMap(Function mapper):与 map 类似，要求返回值必须是Optional

4. Interface
  - default

5. Date
  - LocalDate、LocalTime、LocalDateTime
  - Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
  - Duration : 用于计算两个“时间”间隔
  - Period : 用于计算两个“日期
  - TemporalAdjusters 时间校正器
  - DateTimeFormatter 解析和格式化日期或时间
  - ZonedDate、ZonedTime、ZonedDateTime 带时区的时间或日期
6. 注解
  - 重复注解
  - 类型注解