# 2018.07.28
WEB-INF > web.xml (존재 또는 없음. 배치기술자)
        > lib 폴더 (*.jar)
        > classes 폴더 (사용자 작성 클래스, 패키지 등)
        > 기타 각종 폴더, 파일

파일명.war 배포파일 생성 (jar 명령 사용)
was (Web Application Server)

Context Path (벤더마다 설정 방법이 다름)

일반적인 요청 방법
http://ip:port/context path 경로/path?파라미터

Nginx(웹서버 중 성능 으뜸)

Was 내에 default servlet 존재

이중화

일반적으로 Nginx(웹서버)는 확장 필요 없음, was는 성능 문제로 확장 필요성 빈번
따라서 웹서버가 존재할 시 was를 서비스를 죽이지 않고 서비스 가능

스프링 부트의 경우에는 jar 파일 생성. 해당 jar 파일을 바로 실행. (내장된 was 실행 jsp 사용불가)

xml 루트 태그, 요소(엘리먼트) > 정해진 양식 xml schema

가장 기본 설정은 parent

java는 classPath에 있는 경로에 파일 실행
JVM에는 클래스로더가 존재

클래스 로더는 여러개 존재 가능
각 클래스 로더마다 클래스 패스를 설정 가능
시스템 클래스 로더
커스텀 클래스 로더

spring, was는 커스텀 클래스 로더를 소유

tomcat lib 제공

jdk - jre 포함 (System 클래스로더가 사용)

클래스 로더는 부모(클래스로더)를 가지고 있어서
먼저 부모 클래스 로더에게 물어본 후 자신의 클래스패스를 확인
클래스패스가 메모리에 올라가면 메모리를 먼저 확인
클래스로더가 죽기전까진 메모리에 올라간 클래스패스는 지워지지 않음

was 벤더마다 클래스로더 계층 구조가 다르다

스프링부트 또한 내장 클래스 로더 소유.
각 클래스로더가 없을 시 시스템 클래스 로더를 사용하는 경우도 존재.

java config > import config
java config > import xml
xml > import config
xml > import xml

스프링 > 빈팩토리 > 어플리케이션 컨텍스트(빈 컨테이너)

스프링에서는 빈을 싱글톤으로 관리

Java는 인터페이스를 구현해야 프록시를 만들 수 있음

CGLIB

종단관심, 횡단관심

EJB

advice(로그, 이셉션 등 횡단관심을 처리), joinPoint, pointCut > Aspect

AOP: 객체지향이 못하는 부분을 도와줌
빈컨테이너의 등장

Java Config 또한 빈으로 관리 됨

컴포넌트
Controller > RestController
Service
Repository

http://localhost:8080/hello

빈 팩토리, 어플리케이션 컨텍스트, 웹 어플리케이션 컨텍스트
빈 생명주기

Java Config
Bean 생성, 컴포넌트 스캔

커뮤니티, 쇼핑몰
UI 프로토타이핑