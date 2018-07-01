package com.eason.http;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
    private String method;
    private String url;
    private static int BUFFER_SIZE = 1024;

    public Request(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer request = new StringBuffer(BUFFER_SIZE * 4);
        //将读取到的第一行显按空格拆分出方法与url
        String requestParamter = bufferedReader.readLine();//打印socket中的内容
        System.out.println("Request:" + requestParamter);
        String[] methodAndUrl = requestParamter.split(" ");
        this.method= methodAndUrl[0];
        this.url=methodAndUrl[1];

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}