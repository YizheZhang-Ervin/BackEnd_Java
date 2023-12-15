# Nacos

# 1.打包
```
git clone https://gitee.com/mirrors/Nacos.git
cd Nacos/
mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U  
ls -al distribution/target/
cd distribution/target/nacos-server-版本号/nacos/bin
```

# 2.解压
```
unzip nacos-server-版本号.zip 或 tar -xvf nacos-server-版本号.tar.gz
cd nacos/bin
```

# 3.启动
```
# centos
sh startup.sh -m standalone

# ubuntu
bash startup.sh -m standalone

# windows
startup.cmd -m standalone
```

# 4.注册&配置
```
# 服务注册
curl -X POST 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=nacos.naming.serviceName&ip=20.18.7.10&port=8080'

# 服务发现
curl -X GET 'http://127.0.0.1:8848/nacos/v1/ns/instance/list?serviceName=nacos.naming.serviceName'

# 发布配置
curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=nacos.cfg.dataId&group=test&content=HelloWorld"

# 获取配置
curl -X GET "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=nacos.cfg.dataId&group=test"
```

# 5.关闭服务器
```
# Linux/Unix/Mac
sh shutdown.sh

# Windows
shutdown.cmd
```

# 6.帐号
```
# 默认账号密码
nacos-nacos
```