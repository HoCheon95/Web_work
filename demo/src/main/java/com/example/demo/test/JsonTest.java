package com.example.demo.test;

import java.io.PrintWriter;

import com.google.gson.Gson;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//응답 데이터를 JSON 문자열로 만들어서 클라이언트에게 보내는 서블릿 예제
@WebServlet("/json/jsonTest.do")
public class JsonTest extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        request.setCharacterEncoding("utf-8");

        request.setCharacterEncoding("utf-8");

        //응답 데이터의 형식 지정
        response.setContentType("application/json; charset=UTF-8");

        String choice = request.getParameter("choice");

        Gson gson = new Gson();

        String jsonData = null;
        
        switch(choice){
            //문자열 데이터
            case "str" :
                jsonData = "사과/배/복숭아/딸기/포도";
                break;
        }

        System.out.println("jsonData => " + jsonData);

        //JSON문자열을 응답으로 보내기
        PrintWriter out = response.getWriter();
        out.write(jsonData);
        response.flushBuffer();
        
    }   

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        doGet(request, response);
    }
    
}
