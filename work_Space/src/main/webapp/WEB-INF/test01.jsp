<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style type="text/css">
        #pname{
            font-size: 2.0rem; color: blue;
        }

        #ptel{
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
    <h2>응답 데이터 연습</h2>

    <p>클라이언트의 요청 시 데이터를 받아서 처리한 후 응답 데이터를 생성하는 문서</p>

    <%
        //이 영역은 JSP문에서 'java 명령'을 사용할 수 있는 곳으로 '스크립트릿(scriptlet)'영역이라 한다.

        request.setCharacterEncoding("utf-8");

        //클라이언트가 보내온 데이터 받기
        String userName = request.getParameter("username");
        String userTel = request.getParameter("usertel");
        
    %>
    <p id="pname"><%= userName %>님 환영합니다.~~~</p>
    <p id="ptel"> <%= userTel %>로 연락하겠습니다.~~~</p>
</body>
</html>