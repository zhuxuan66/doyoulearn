package com.maiyaduomi.doyoulearn.redis.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client1 {

    public static void main(String[] args) throws IOException {
        SocketChannel client = SocketChannel.open();
        client.socket().connect(new InetSocketAddress("127.0.0.1", 6379));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024).put("come22222".getBytes());
        if (client.finishConnect()) {
            while(byteBuffer.hasRemaining()) {
                client.write(byteBuffer);
            }
        }
    }

}
