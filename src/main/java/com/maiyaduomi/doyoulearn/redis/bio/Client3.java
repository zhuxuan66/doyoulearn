package com.maiyaduomi.doyoulearn.redis.bio;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client3 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6379);
        BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        while (true) {
            String str = bufferedReader.readLine();
            bufferedWriter.write("客户端3发来消息：" + str);
            bufferedWriter.write("\n");
            bufferedWriter.flush();
        }

    }

}
