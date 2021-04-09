import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        InetAddress address = socket.getInetAddress();
        System.out.println("客户端启动" + address);
        // 获取输入输出流
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        // 客户端写数据
        outputStream.write("hello".getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        socket.shutdownOutput();// 不加上这个会一直堵塞
        // 读取服务器端发送的数据
        byte[] bytes = new byte[30];
        int tempLength;
        while((tempLength = inputStream.read(bytes))!=-1){
            String s = new String(bytes, 0, tempLength);
            System.out.println(s);
            if(s.equals("图片传输将要开始")){
                break;
            }
        }
        // 接受服务器的图片，保存到本地
        int length;
        File file = new File("src//client.png");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        while ((length = inputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,length);
        }
        System.out.println("图片接收完成");
        socket.close();
    }
}
