package com.eason.servlet;

import com.eason.http.Request;
import com.eason.http.Response;

import java.io.OutputStream;

public class LoginServlet extends Servlet{
    public void doGet(Request request, Response response) {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response)  {
        try {
            //doSomething...
            OutputStream outputStream = response.outputStream;
            String res = Response.responseHeader+"Hello,welcome to here !";
            outputStream.write(res.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
