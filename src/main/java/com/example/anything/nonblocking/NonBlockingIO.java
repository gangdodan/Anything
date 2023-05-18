package com.example.anything.nonblocking;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

/**
 * nio 패키지 사용하여 논블로킹 I/O 구현
 * -> TCP 소켓 사용한 네트워크 통신을 비동기적으로 처리
 * */

public class NonBlockingIO {
    public static void main(String[] args) throws Exception{
        //비동기 소켓 채널 생성
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();

        //연결 요청
        Future<Void> future = socketChannel.connect(new InetSocketAddress("localhost", 8080));
        future.get();

        //데이터 전송
        String message = "Hello, server";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("데이터 전송 완료");
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("데이터 전송 실패 : " + exc.getMessage());
            }
        });

        //데이터 수신
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(readBuffer, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                readBuffer.flip();
                byte[] data = new byte[readBuffer.limit()];
                readBuffer.get(data);
                String receivedMessage = new String(data);
                System.out.println("서버로부터 수신한 데이터 : " + receivedMessage);
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("데이터 수신 실패 : " + exc.getMessage());
            }
        });

        //비동기 작업 완료 대기
        Thread.sleep(2000);
    }
}
