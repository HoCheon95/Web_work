package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoveController {
    // 브라우저에서 http://localhost:8080/test01 로 접속하면 실행됨
    @RequestMapping(value = "/test01")
    public String goTest01() {
        // application.properties의 prefix/suffix와 결합되어 
        // /WEB-INF/test01.jsp 를 찾아감
        return "test01"; 
    }
}
