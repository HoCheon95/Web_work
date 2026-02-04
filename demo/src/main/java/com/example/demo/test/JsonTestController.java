package com.example.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 어노테이션이 있어야 '문자열'을 바로 응답합니다.
public class JsonTestController {

    // 브라우저의 xhr.open("get", "/json/jsonTest.do?choice=str")과 매칭
    @GetMapping("/json/jsonTest.do")
    public String jsonTest(@RequestParam(name = "choice") String choice) {
        
        if ("str".equals(choice)) {
            return "사과/배/복숭아/딸기/포도";
        }
        
        return "선택된 데이터가 없습니다.";
    }
}