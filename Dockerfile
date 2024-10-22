# 基础镜像使用java（根据自己项目中使用的是什么jdk版本设置，用于拉取执行jar包的jdk环境）
FROM openjdk:8

#设置时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

# 指定工作目录
VOLUME /tmp

# 将jar包添加到容器中并更名为app.jar(这里根据你自己打包的文件名修改)
ADD springbootdemo-0.0.1-SNAPSHOT.jar app.jar


# 暴露端口
EXPOSE 9999

# 定义jvm堆空间
ENV JAVA_OPT="-server -Xmx1024m -Xms512m"

# 定义容器启动时执行的命令
ENTRYPOINT ["java","-jar","-Dfile.encoding=UTF-8","-Dsun.jnu.encoding=UTF8","/app.jar","> /log/app.log"]



