package com.no.framework.webserver;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Integer port = 8080;
            Boolean running = true;
            System.out.println("Server star on %d".formatted(port));
            ServerSocket ss = ServerSocketFactory.getDefault().createServerSocket(port, 10);
            StringBuilder body = new StringBuilder();
            body.append("<html><body><h1>Hello, World!</h1></body></html>");
            HttpReply httpReply = new HttpReply();
            while (running) {
                Socket s = ss.accept();
                httpReply.setBody(body);
                httpReply.setS(s);
                Thread t = new Thread(httpReply);
                t.start();
                System.out.println("run ");
            }
            //System.out.println("stoped");
        } catch (IOException e) {
            System.err.println("Server stop becose have error ");
            e.printStackTrace();
        }
    }
}

