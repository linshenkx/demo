# 文档

## 简介：
该后台demo使用基于springboot的SSM架构实现简单的登录注册功能。
采用技术有：通用Mapper，JWT，Swagger

## 演示：
swagger调试链接：http://120.79.168.114:9999/swagger-ui.html
登录或注册后可获取token，通过在消息头携带"Authorization"字段的键值对进行验证。

## 部署

### 一 安装docker和docker-compose环境
#### 1 安装docker
参照官方文档（以centos为例）：https://docs.docker.com/install/linux/docker-ce/centos/
#### 2 安装docker-compose
参照官方文档：https://docs.docker.com/compose/install/#install-compose

### 二 构造docker镜像并运行
前提：将本项目docker文件夹复制至服务器任意位置
#### 1 MySQL
##### 安装方式
在mysql目录下运行`docker-compose up -d`
##### 注意事项
1. 数据库的密码默认为： 123456
2. 连接端口号默认为： 3307
3. mysql相关数据默认挂载位置为： /opt/docker-volumes/mysql/datadir
4. mysql默认数据库备份文件位置为： /opt/docker-volumes/mysql/datadir/backup
5. mysql默认编码字符集为： utf8mb4
以上皆可在docker-compose.yml文件进行配置
6. 默认备份规则为： 每分钟全数据库备份一次
可通过crontab.bak修改备份频率，通过backup.sh修改备份范围
#### 2 JAVA后台
##### 安装方式
在demo-project目录下运行`docker-compose up -d`
##### 注意事项
1. 默认访问端口为：9999
2. 日志默认存放位置为：/opt/docker-volumes/demo/logs
以上皆可在docker-compose.yml文件进行配置