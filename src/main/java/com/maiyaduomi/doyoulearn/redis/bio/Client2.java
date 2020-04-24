package com.maiyaduomi.doyoulearn.redis.bio;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 模拟连接redis的客户端，可以把它当成一个jedis
 *
 * bio：当某个客户端去连接操作redis server时，另一个客户端就需要等待
 */
public class Client2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6379);
        BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        while (true) {
            String str = bufferedReader.readLine();
            bufferedWriter.write("客户端2发来消息：" + str);
            bufferedWriter.write("\n");
            bufferedWriter.flush();
        }

    }

}
