# transferImageBySocket
# 简介
这是一个基于Gradle的使用TCP/IP协议通信的socket项目。

**如何使用idea建立Gradle项目**

在新建Project时选择Gradle即可，具体可见[https://blog.csdn.net/qq_39288090/article/details/97664859](https://blog.csdn.net/qq_39288090/article/details/97664859)

# 环境
<ul>
<li>JDK 1.8</li>
<li>IntelliJ Idea 2020</li>
</ul>

# 功能
服务端读取图片发送给客户端，客户端保存图片到本地

# 目录结构
```bash
├── Readme.md                   // help
├── src        
│   └── main
│       └── java     
│           ├── Client      	// 客户端
│           └── Server          // 服务端
│   ├── 1.png                   // 服务端读取
│   └── client.png      	    // 客户端保存
```


# 结果
服务端
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210409170303120.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2OTM3Njg0,size_16,color_FFFFFF,t_70)
客户端
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210409170442230.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2OTM3Njg0,size_16,color_FFFFFF,t_70)
# 注意事项
先运行服务器端，再运行客户端


<hr/>
