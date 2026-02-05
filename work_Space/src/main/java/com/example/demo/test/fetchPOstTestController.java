package com.example.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class fetchPOstTestController {
    @RequestMapping("/fetchPostTest")
    public String showFetchPage(Model model) {

        model.addAttribute("id", "id");
        model.addAttribute("name", "name");
        model.addAttribute("email", "email");
        return "fetchPostTest";
    }

    @PostMapping("/json/fetchPostParamTest.do")
    @ResponseBody
    public TestVO fetchPostParamTest(TestVO vo) {
        // 분리된 TestVO 클래스의 필드명(id, name, email)과 
        // JSP 전송 데이터의 키값이 일치하면 자동으로 매핑됩니다.
        System.out.println("수신 확인: " + vo.toString());
        return vo; // JSON 형태로 반환
    }

    @PostMapping("/json/fetchPostJsonTest.do")
    @ResponseBody
    public TestVO fetchPostJsonTest(@RequestBody TestVO vo){
        System.out.println("수신 확인 : " + vo.toString());
        return vo;
    }
    

}
