import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonTest {
    public static void main(String[] args) {
        //GSON ==> JSON자료를 자바의 자료로 변환하고
        //         자바의 자료를 JSON 자료로 변환하는 작업을 도와주는 라이브러리이다.

        //GSON 객체 생성

        //방법1-1(일반적인 객체 생성)
        // Gson gson = new GsonBuilder().create();

        //방법1-2 (JSON문자열을 예쁘게 정리해서 출력할 때 사용)
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //방법2
        // Gson gson = new Gson();

        //자바 객체 생성
        StudentVO stdVo1 = new StudentVO("홍길동", 20, "대전시 중구 오류동", "010-1234-5678");

        //'Java 객체를'를 'JSON문자열'변환하기
        //      ==> Gson객체의 toJson()메서드를 이용한다.
        String jsonStr = gson.toJson(stdVo1);

        System.out.println("JSON 문자열 출력");
        System.out.println(jsonStr);
        System.out.println("-----------------------------------------------------------------------------");

        //'JSON문자열'을 'Java 객체'로 변환하기
        //      ==> Gson객체 fromJson()메서드를 이용한다.
        StudentVO stdVo2 = gson.fromJson(jsonStr, StudentVO.class);

        System.out.println();
        System.out.println("변환된 객체 정보 출력하기");
        System.out.println("이름 : " + stdVo2.getName());
        System.out.println("나이 : " + stdVo2.getAge());
        System.out.println("주소 : " + stdVo2.getAddr());
        System.out.println("전화 : " + stdVo2.getTel());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();

        // ===============================================================

        StudentVO[] stdArr = new StudentVO[] {
            new StudentVO("이순신", 30, "대전시 유성구 봉명동", "010-1111-1111"),
                new StudentVO("강감찬", 40, "대전시 서구 도마동", "010-2222-2222"),
                new StudentVO("일지매", 50, "대전시 대덕구 법동", "010-33333-3333")
        };

        String jsonArr = gson.toJson(stdArr);
        System.out.println("jsonArr => " + jsonArr);
        System.out.println("---------------------------");
        System.out.println();

        /*
                JSON                    자바
            -------------------------------------------------------
                객체        <==>        일반객체(예:VO객체, DTO객체)
                                        Map객체
            -------------------------------------------------------
                배열        <==>        배열
                                        List 객체
        */

        //JSON문자열을 자바의 배열 또는 List나 Map 등으로 변환할 때의 변환할 객체를 지정할 때는
        //'java.lang.reflect.Type' 객체를 생성해서 사용해야 한다.

        //배열일 때 ==> new TypeToken<자료형의클래스명[]>(){}.getType();
        //List일 때 ==> new TypeToken<ArrayList<제네릭클래스명>>(){}.getType();
        //Map일 때 ==> new TypeToken<HashMap<key제네릭, value제네릭>>(){}.getType();

        //배열
        // Type type = new TypeToken < StudentVO[] > () {}.getType();
        // StudentVO[] stdArr2 = gson.fromJson(jsonArr, type);

        //List
        Type type = new TypeToken<ArrayList<StudentVO>>() {}.getType();
        ArrayList<StudentVO> stdArr2 = gson.fromJson(jsonArr, type);

        System.out.println("배열의 내용");
        System.out.println("-----------------------------------------------------");
        for (StudentVO stdVo3: stdArr2) {
            System.out.println("이름 : " + stdVo3.getName());
            System.out.println("나이 : " + stdVo3.getAge());
            System.out.println("주소 : " + stdVo3.getAddr());
            System.out.println("전화 : " + stdVo3.getTel());
            System.out.println("-----------------------------------------------------------------------------");
        }

        System.out.println();
        System.out.println();

        //Map
        Type typeMap = new TypeToken<HashMap<String, Object>>() {}.getType();
        Map<String, Object> stdMap = gson.fromJson(jsonStr, typeMap);

        System.out.println("stdMap => " + stdMap);
    }
}
