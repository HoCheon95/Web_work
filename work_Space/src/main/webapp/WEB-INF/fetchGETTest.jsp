<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script>
        document.addEventListener("DOMContentLoaded", function(){
            //객체 처리
            document.querySelector("#objBtn").addEventListener("click", function(){
                fetch("/json/jsonTest.do?choice=object")
                .then(response => {
                    console.log("response", response);
                    if(response.ok){
                        <%-- return response.text(); --%>
                        return response.json();
                    }else{
                        throw new Error(response.statusText);
                    }
                })
                .then(data => {
                    console.log("응답 데이터", data);
                    let htmlCode = "<h3>객체 응답 결과</h3>";
                    htmlCode += "이 름 : " + data.name + "<br>";
                    htmlCode += "나 이 : " + data.age + "<br>";
                    htmlCode += "주 소 : " + data.addr + "<br>";
                    htmlCode += "전 화 : " + data.tel + "<br>";

                    document.querySelector("#result").innerHTML = htmlCode;
                })
            });

            //------------------------------------------------------------------

            // List
            document.querySelector("#listBtn").addEventListener("click", () =>{
                fetch("/json/jsonTest.do?choice=list")
                .then(res => {
                    if(res.ok){
                        return res.json();
                    }else{
                        throw new Error(res.statusText);
                    }
                })
                .then(data => {
                    htmlCode = "<h3>리스트 응답 결과</h3>"

                    //JSP문서에서 백틱(``)안에 값을 출력하기 위해 `$ {변수명}`를 사용할 경우에는 '$'문자 앞에 역슬래쉬(\)를 붙여줘야 한다.
                    data.forEach((v,i) => {
                        htmlCode +=
                        `
                            ${i+1}번째 자료<br>
                            이름 : ${v.name}<br>
                            나이 : ${v.age}<br>
                            주소 : ${v.addr}<br>
                            전화 : ${v.tel}<br>
                        `;
                    });
                    document.querySelector("#result").innerHTML = htmlCode;
                })
            });

            //------------------------------------------------------------------

            // Map
             document.querySelector("#mapBtn").addEventListener("click", () =>{
                fetch("/json/jsonTest.do?choice=map")
                .then(res => {
                    if(res.ok){
                        return res.json();
                    }else{
                        throw new Error(res.statusText);
                    }
                })
                .then(data =>{
                    let htmlCode =
                    `
                        <h3>Map 응답 결과</h3>
                        nahe
                    `;
                })

        });
    </script>
    
</head>
<body>
   <form>
      <input type="button" value="obj데이터" id="objBtn" />
      <input type="button" value="list데이터" id="listBtn" />
      <input type="button" value="map데이터" id="mapBtn" />
    </form>
    <hr color="red">
    <div id="result"></div>
</body>
</html>