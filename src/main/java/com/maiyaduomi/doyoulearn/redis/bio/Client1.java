package com.maiyaduomi.doyoulearn.redis.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 模拟连接redis的客户端，可以把它当成一个jedis
 */
public class Client1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6379);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("set key value ");
        bufferedWriter.flush();
        socket.shutdownOutput();
    }

}
