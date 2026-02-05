<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fetch 연습</title>
    <script>
        // HTML 문서가 완전히 로드된 후 실행되도록 보장
        document.addEventListener("DOMContentLoaded", function() {
            
            // 파라미터 전송 예제
            document.querySelector("#paramsBtn").addEventListener("click", function() {
                
                const userId = document.querySelector("#userid").value;
                const userName = document.querySelector("#username").value;
                const userEmail = document.querySelector("#useremail").value;
                
                fetch("/json/fetchPostParamTest.do", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded"
                    },
                    body: "id=" + userId + "&name=" + userName + "&email=" + userEmail
                })
                .then(res => {
                    if(res.ok) {
                        return res.json();
                    } else {
                        throw new Error("서버 응답 오류: " + res.statusText);
                    }
                })
                .then(data => {
                    console.log("응답 데이터 수신 완료:", data);
                    
                    // htmlCode 생성을 .then 내부로 이동
                    let htmlCode = `
                        <div style="border:1px solid blue; padding:10px; margin-top:10px;">
                            <strong>서버 응답 데이터</strong><br>
                            아이디 : \${data.id}<br>
                            이 름 : \${data.name}<br>
                            이메일 : \${data.email}<br>
                        </div>
                    `;
                    
                    // 화면에 결과 출력하는 코드를 반드시 .then 안에 작성!
                    document.querySelector("#result").innerHTML = htmlCode;
                })
                .catch(error => {
                    console.error("전송 중 에러 발생:", error);
                    alert("데이터 전송에 실패했습니다.");
                });
            });

            //JSON문자열 형태로 서버로 데이터 보내기
            document.querySelector("#jsonStrBtn").addEventListener("click", function(){
                //입력한 ID, 이름, 이메일을 가져온다.
                const userId =document.querySelector("#userid").value;
                const userName = document.querySelector("#username").value;
                const userEmail = document.querySelector("#useremail").value;
                
                //가져온 데이터를 이용하여 JavaScript객체를 만든다.
                //이 때 속성명은 사용할 VO객체의 멤버변수명과 맞춰서 작성한다.
                const member = {
                    id : userId,
                    name : userName,
                    email : userEmail
                };

                fetch("/json/fetchPostJsonTest.do", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json; charset=utf-8"
                    },
                    body: JSON.stringify(member)
                })
                .then(res => {
                    if(res.ok) {
                        return res.json();
                    } else {
                        throw new Error("서버 응답 오류: " + res.statusText);
                    }
                })
                .then(data => {
                    console.log("응답 데이터 수신 완료:", data);
                    
                    // htmlCode 생성을 .then 내부로 이동
                    let htmlCode = `
                        <div style="border:1px solid blue; padding:10px; margin-top:10px;">
                            <strong>서버 응답 데이터</strong><br>
                            아이디 : \${data.id}<br>
                            이 름 : \${data.name}<br>
                            이메일 : \${data.email}<br>
                        </div>
                    `;
                    
                    // 화면에 결과 출력하는 코드를 반드시 .then 안에 작성!
                    document.querySelector("#result").innerHTML = htmlCode;
                })
                .catch(error => {
                    console.error("전송 중 에러 발생:", error);
                    alert("데이터 전송에 실패했습니다.");
                });

            })
        });
    </script>
</head>
<body>
    <h3>fetch - Post 전송 연습</h3>
    <form>
        아이디 : <input type="text" name="userid" id="userid" placeholder="id 입력">
        이 름 : <input type="text" name="username" id="username" placeholder="이름 입력">
        이메일 : <input type="text" name="useremail" id="useremail" placeholder="이메일 입력">
        <br><br>

        <input type="button" value="파라미터형식으로 전송하기" id="paramsBtn">
        <input type="button" value="JSON문자열 형식으로 전송하기" id="jsonStrBtn">
    </form>
    <hr color="red">
    <div id="result"></div>
</body>
</html>