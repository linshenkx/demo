#基础镜像：仓库是java，标签用8
FROM java:8

#通过 VOLUME 指令创建的挂载点，无法指定主机上对应的目录，是自动生成的
VOLUME ["/opt/app/myLogsDir"]

#系统日志所在文件夹
ENV logdir /opt/app/myLogsDir

#将打包好的spring程序拷贝到容器中的指定位置
COPY app.jar /opt/app/app.jar

##修复时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

#容器对外暴露9090端口
EXPOSE 9090

WORKDIR /opt/app

CMD java -jar app.jar