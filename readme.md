# Spring Boot
  강의 필기
# 2018.07.28

WEB-INF
web.xml (존재 또는 없음. 배치기술자)
lib 폴더 (*.jar)
classes 폴더 (사용자 작성 클래스, 패키지 등)
기타 각종 폴더, 파일

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

# 2018.08.04

FistWebApplication 이 곧 설정파일

@Component 애노테이션이 붙어 있는 클래스가 컴포넌트
대표적으로 @Controller, @Service, @Repository 등


Java Config, xml config, Component scan

Servlet
WAS에서 제공(JDK에 없음)
init(), destroy(), service(), doGet(), doPost(), doDelete(), doPut() 등
위 메소드들은 req, res를 인자로 받음

HttpServlet을 상속 받음

Web.xml (서블릿 3.0미만에선 반드시 필요. 3.0 이상에선 JavaConfig로 설정 가능)
- deployment descriptor 배포 기술
URL Mapping 설정

1) 접속 localhost:8080
2) 요청 정보, 요청라인(HttpMethod Path), 헤더 정보(IP 등), Body() 등이 WAS에게 감
3) HttpServletRequest에 정보를 담음
4) HttpServletResponse 객체를 WAS가 생성, 요청한 내용이 처리(실행)되어 담김
5) 응답
6) 종료

서블릿은 메모리에 1번만 적재
메모리에 로딩 후 init() 메소드 실행
그 다음 service() 메소드 실행
HttpServlet 하위 객체가 service() 오버라이딩 - 개발자 구현

Spring MVC - Dispatcher Servlet(서블릿) Web.xml(Java Config)에 설정
다른말로 FrontController 라고 지칭, JaveEE 패턴

URL Mapping을 위해 Dispatcher Servlet 실행
모든 요청은 '/'
URL 요청 식별 매핑 정보가 없을시 DefaultServlet(WAS에서 설정 되어 있음)

Dispatcher Servlet 내에 Default Servlet 설정을 가지고 있음
Default Servlet에게 위임 선택 권한

Web.xml 은 Spring과는 상관없는 파일

개발자가 사용할 객체는 Bean으로 설정, 사용됨
Web.xml 파일에서 '/' 요청이 오면 Dispatcher Servlet이 스프링 설정 파일을 읽게 설정
스프링 사용시 위 설정들을 해줘야함

ServletContainerInitializer 인터페이스
WebApplicationInitializer 인터페이스

Web.xml > ServletContainerInitializer > WebApplicationInitializer
위 순서로 WAS가 찾음

스프링부트는 WebApplicationInitializer를 구현한 객체를 지원

WebApplicationContext - Bean 관리

Dispatcher Servlet 사용하는 클래스
@Controller 등 내에 메소드는 URL을 처리하는 메소드
@RequestMapping는 HTTP 메소드, URL path 설정

아래 애노테이션은 path만 설정(내부적으로 @RequestMapping을 소유)
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping

HandlerMapping이 요청과 객체 정보를 가지고 있음
DispatcherServlet이 HandlerMapping을 확인

HandlerAdapter과 Controller 등을 실행
Controller는 ViewName을 반환

DispatcherServlet은 반환받은 ViewName을 ViewResolver에게 반환

ViewResolver는 어떠한 View를 보여줄지 선택(논리적 이름을 가지고 JSP, XML 등 확인 후 처리)
스프링부트는 ViewResolver가 기본으로 선택 되어 있음(타임리프 등은 따로 설정)

HandlerMapping, HandlerAdapter는 개발자가 가급적 건드릴 필요 없음
ViewResolver, View는 개발자가 가끔 건드릴 수도 있음


@PathVariable
@RequestParam

URL 설계 최우선(Input Data)

lombok 사용을 위해 plugin 설치
환경설정(Command + ,) Build,Execution,deployment > annotation Processors >
Check [Enable annotation processing]

@Retention(RetentionPolicy.SOURCE) 소스단계에서 처리 - @Getter 등


VO - Value Object
     값 보관 객체(Read Only)
DTO - Data Transfer Object
      VO와 동일 개념. 레이어, 네트워크 간 전송 기능 포함.
DAO - Data Access Object
      CRUD 기능. DTO를 선택적 사용

클래스로더는 상위 클래스로더 요청
DevTool가 빌드 했을 때 상위 클래스로더는 놔두고 현재 클래스로더만 내렸다가 올림

메세지컨버터가 body에 담을때 객체 등을 변환해줌

REST API Testing
postman, restlet(설치)


<dependency>
		<groupId>com.fasterxml.jackson.dataformat</groupId>
		<artifactId>jackson-dataformat-xml</artifactId>
</dependency>

위 라이브러리를 추가 해야해야만 xml파일로 변환 가능
Header(MimeType)에 따라 맞춰 전송할 때

타임리프 라이브러리 추가 시 뷰 리졸버에 자동으로 추가 됨
