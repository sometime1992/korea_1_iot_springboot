package org.example.이론;

public class u_communication {
    /*
        application server(애플리케이션 서버) - 8080
            : Spring Boot
            : 비즈니스 로직을 처리하는 역할 (데이터를 가공 & 클라이언트가 요청한 기능을 수행)
            - 작동방식
                : 클라이언트가 요청한 데이터나 로직을 처리하고
                    , 직접적인 통신보다는 주로 API를 통해 JSON 형태의 데이터를 반환
                    (REST API - 데이터 반환)
        web server
            : React(React 내부의 웹 서버를 사용) - 3000
            : 정적 파일(HTML, CSS, JS) 등을 제공, 주로 웹 페이지를 렌더링하는 용도
            - 작동 방식
                : 클라이언트로부터 요청을 받고 애플리케이션 서버의 데이터를 받아와서
                    , 사용자에게 보여주는 역할을 담당

        == 1. 브라우저와 프론트엔드 서버 통신 ==

        - 사용자가 브라우저를 통해 프론트엔드 웹 애플리케이션(3000번 포트)에 접근
           : 브라우저가 화면을 렌더링

        == 2. axios 요청 설정 ==

        - 프론트엔드 애플리케이션에서 백엔드와 통신하기 위해 axios를 사용하여 요청 설정
           : axios.get(`http://localhost:8080/api/v1/menus`);

        - 해당 요청에서
            localhost:8080 - 백엔드 서버 주소 & 포트번호
            /api/v1/menus - 백엔드에서 제공하는 API 경로

        == 3. Cross-Origin Resource Sharing (CORS 정책) ==

        - 브라우저는 기본적으로 다른 출처(포트번호가 다른 서버 포함)로의 요청을 차단
          : CORS 설정이 필요

        - 백엔드(Spring Boot 3)에서 다른 출처에서 오는 요청을 허용하도록 CORS 정책을 설정
          : 프론트엔드에서 백엔드로의 요청이 허용됨.

        == 4. axios 요청 전송 ==

        - axios가 HTTP 요청을 브라우저를 통해 전송
          : 요청의 주소 - `http://localhost:8080/api/v1/menus`
          : 요청 헤더에 필요한 정보가 포함

          +) 요청의 메서드가 POST, PUT일 경우 전달할 데이터도 포함

        == 5. 백엔드 서버의 요청 처리 ==

        - 요청이 백엔드 서버(Spring Boot 3)에 도착하면, 해당 경로(/api/v1/menus)에
            , 매핑된 컨트롤러가 요청을 처리
        - @GetMapping("/api/v1/menus")로 매핑된 메서드가 있다면
            , 해당 메서드가 요청을 받아 필요한 데이터를 처리하고 응답을 생성하여 반환

        == 6. 응답 전송 ==

        - 백엔드 서버는 HTTP 응답을 생성하여 요청을 보낸 프론트엔드 서버로 데이터를 전송
          : JSON 데이터 형식으로 응답
        - 응답 헤더에는 CORS 관련 헤더 (프론트엔드 경로로 응답 할 수 있음)가 포함
          : 프론트엔드가 응답을 정상적으로 수신할 수 있도록 설정

        == 7. 프론트엔드의 응답 처리 ==

        - 프론트엔드의 axios는 백엔드 서버의 응답을 받아
          , 데이터를 가공하고 화면에 표시하거나 다른 로직에 사용

        - 예외적으로 요청이 실패하거나 CORS 오류가 발생하면 axios의 catch 블록에서 에러 처리

    */

}
