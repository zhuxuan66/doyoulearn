package com.maiyaduomi.doyoulearn.redis.bio;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 模拟redis server
 *
 * accept(),readLine()都是阻塞的
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        System.out.println("----------------connect successfully, wait data");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        String content;
        while (!StringUtils.isEmpty(content = bufferedReader.readLine())) {
            System.out.println("----------------process data");
            System.out.println(content);
        }
    }
}
