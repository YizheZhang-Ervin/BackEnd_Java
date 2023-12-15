# Skywalking

# 1.下载
```
https://dlcdn.apache.org/skywalking/8.9.1/apache-skywalking-apm-8.9.1.tar.gz
https://dlcdn.apache.org/skywalking/java-agent/8.9.0/apache-skywalking-java-agent-8.9.0.tgz
```

# 2.启动时加入探针
```
java -javaagent:/path/to/skywalking-agent/skywalking-agent.jar -Dskywalking.agent.service_name=服务名 -Dskywalking.collector.backend_service=localhost:9003 -jar 包名.jar
```

# 3.启动Skywalking
```
解压/dist/apache-skywalking-apm-8.9.1.tar.gz
改配置文件端口为9003
sh startup.sh
```