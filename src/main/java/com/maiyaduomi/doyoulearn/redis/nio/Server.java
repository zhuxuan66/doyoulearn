package com.maiyaduomi.doyoulearn.redis.nio;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static List<SocketChannel> socketChannels = new ArrayList<>();

    private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        SocketAddress address = new InetSocketAddress(6379);
        server.socket().bind(address);
        for (SocketChannel socketChannel : socketChannels) {
            int readBytes = socketChannel.read(byteBuffer);
            if (readBytes > 0) {
                System.out.println("readBytes = " + readBytes);
                byteBuffer.flip();
                byte[] bytes = new byte[readBytes];
                byteBuffer.get(bytes);
                String content = new String(bytes);
                System.out.println("content : "  + content);
            }
        }

        SocketChannel socketChannel = server.accept();
        if (socketChannel != null) {
            System.out.println("conn come");
            socketChannel.configureBlocking(false);
            socketChannels.add(socketChannel);
            System.out.println("list count : " + socketChannels.size());
        }

    }
}
