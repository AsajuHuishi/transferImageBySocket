import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    /**
     * 先运行服务器端
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器准备就绪");
        // 等待客户端连接
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功");
        // 获取输入输出流
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        // 通信
        // 读数据
        byte[] bytes = new byte[30];
        int tempLength;
        while((tempLength = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,tempLength));
        }
        // 发送数据
        outputStream.write("欢迎登录".getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.write("图片传输将要开始".getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        // 服务器读取图片发送到客户端
        File file = new File("src//1.png");
        if(file.exists()){
            System.out.println("图片存在，可以传输");
            // 输入缓冲流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            // 输出缓冲流
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int length;
            while((length = bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,length);
                bufferedOutputStream.flush();
            }
        }else{
            System.out.println("图片不存在");
        }

        // 关闭
        socket.close();

    }
}
