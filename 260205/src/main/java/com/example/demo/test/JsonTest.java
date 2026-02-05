package com.example.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class JsonTest { // HttpServlet 상속은 제거해도 무방합니다.
    // [1] 화면(JSP)을 띄워주는 메서드 (브라우저 주소창 입력용)
    @RequestMapping("/testPage.do")
    public String openJsp() {
        return "fetchGETTest"; // WEB-INF/fetchGETTest.jsp 호출
    }

    // [2] JSON 데이터를 주는 메서드 (JS fetch 호출용)
    @RequestMapping("/json/jsonTest.do")
    @ResponseBody
    public String jsonTest( // <StudentVO> 제네릭 선언 삭제!
        @RequestParam(name = "choice") String choice,
        HttpServletRequest request,
        HttpServletResponse response
    ) {

        response.setContentType("application/json; charset=UTF-8");

        Gson gson = new Gson();
        String jsonData = null;

        switch (choice) {
            case "str":
                jsonData = "사과/배/복숭아/딸기/포도";
                break;
            case "array":
                String[] strArr = {
                    "홍길동",
                    "이순신",
                    "강감찬",
                    "을지문덕",
                    "김유신"
                };
                jsonData = gson.toJson(strArr);
                break;
            case "object":
                // StudentVO가 클래스로 정의되어 있고 생성자가 있어야 합니다.
                StudentVO stdVo = new StudentVO("홍길동", 20, "대전시 중구 오류동", "010-1234-5678");
                jsonData = gson.toJson(stdVo);
                break;
            case "list":
                List < StudentVO > stdList = new ArrayList <> ();
                stdList.add(new StudentVO("이순신", 30, "대전시 유성구 봉명동", "010-1111-1111"));
                stdList.add(new StudentVO("강감찬", 40, "대전시 서구 도동", "010-2222-2222"));
                stdList.add(new StudentVO("일지매", 50, "대전시 대덕구 법동", "010-3333-3333"));
                jsonData = gson.toJson(stdList);
                break;
            case "map":
                Map<String, String> map = new HashMap<>();
                map.put("name", "이순신");
                map.put("tel", "010-8888-9999");
                map.put("address", "대전시 동구 대동");

                jsonData = gson.toJson(map);
                break;
        }

        return jsonData;
    }
}
