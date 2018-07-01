package com.eason.tomcat;

import com.eason.http.Request;
import com.eason.http.Response;
import com.eason.servlet.Servlet;

import java.io.OutputStream;
import java.net.Socket;

public class SocketProcess extends Thread{
    protected Socket socket;

    public SocketProcess(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());

            Servlet servlet = MyTomcat.servletMapping.get(request.getUrl());

            if (servlet != null) {
                servlet.service(request,response);
            }else{
                String res = Response.responseHeader+"ERROR:404 NOT FOUND";
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(res.getBytes());
                outputStream.flush();
                outputStream.close();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
