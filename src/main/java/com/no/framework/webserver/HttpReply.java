package com.no.framework.webserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class HttpReply implements Runnable {
    private Socket s;
    private StringBuilder body;

    HttpReply(Socket s, StringBuilder body) {
        this.s = s;
        this.body = body;
    }

    HttpReply() {
    }

    public void run() {
        try {
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("HTTP/1.1 200 OK");
            ps.println("Date: Mon, 27 Jul 2009 12:28:53 GMT");
            ps.println("Server: Java");
            ps.println("Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT");
            ps.println("Content-Length: " + body.length());
            ps.println("Content-Type: text/html");
            ps.println("Connection: Closed");
            ps.println();
            ps.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public StringBuilder getBody() {
        return body;
    }

    public void setBody(StringBuilder body) {
        this.body = body;
    }
}