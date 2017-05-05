# Tomcat环境配置

> @authur Bingbing He,
> 2017/04/25

## 下载Tomcat

从官网 [http://tomcat.apache.org](http://tomcat.apache.org/) 下载对应的版本，我所下载的是Tomcat 7.0.77版本，Core里的**64-bit Windows zip**，解压即可。

![下载界面](http://ootah442n.bkt.clouddn.com/%E4%B8%8B%E8%BD%BD%E7%95%8C%E9%9D%A2.jpg)

## 配置环境变量

1. **Java**环境变量配置

	略。
2. **Tomcat**环境变量配置

	右击【计算机】--【属性】--【高级系统设置】--【环境变量】
	- 新建用户变量名：`CATALINA_HOME`,变量值：`D:\develop\apache-tomcat-7.0.77`
	
		> D:\develop\apache-tomcat-7.0.77为解压的那个目录。
	
	- 打开PATH，添加变量值：`%CATALINA_HOME%\lib` 和 `%CATALINA_HOME%\bin`

## 启动Tomcat服务（手动）

在CMD命令下输入命令：startup，出现如下对话框，表明服务启动成功。

>但是这样启动有一个不好的地方就是任务栏会一直存在着一个dos的窗口，这个窗口便是tomcat的控制台，实时的输出tomcat的运行情况，便于查找存在着的错误。

![](http://ootah442n.bkt.clouddn.com/%E6%88%90%E5%8A%9F%E5%BC%80%E5%90%AF%E6%9C%8D%E5%8A%A1.png)

## 启动Tomcat服务（自动，后台开启）

要做到后台启动，按步骤进行：

1. 打开tomcat的bin目录找到service.bat
2. 开始->运行->cmd
3. 将service.bat左键点击拖入到dos窗口，当然也可以把该地址写进去，然后按Enter

	![](http://ootah442n.bkt.clouddn.com/%E6%B7%BB%E5%8A%A0%E5%90%8E%E5%8F%B0.jpg)

4. 成功之后在dos窗口键入 service.bat install Tomcat 输完然后按Enter键，出现如下窗口，便成功了。
	> 这里因为我之前已经成功了，所以再次运行，显示Fail，按理来说应该是Successful!!! 

	![](http://ootah442n.bkt.clouddn.com/%E6%B7%BB%E5%8A%A0%E5%90%8E%E5%8F%B0%E6%88%90%E5%8A%9F.jpg)

5. 于是，在计算机--管理--服务中添加了一个tomcat的服务，只需要将此服务开启即可，若要开机启动就将服务设成是自动的。

	![](http://ootah442n.bkt.clouddn.com/%E6%9C%8D%E5%8A%A1.jpg)


## 配置成功

打开浏览器，键入http://localhost:8080，如果出现页面，那么配置成功。

![](http://ootah442n.bkt.clouddn.com/%E6%88%90%E5%8A%9F.jpg)
