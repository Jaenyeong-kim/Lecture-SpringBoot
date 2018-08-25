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

# 2018.08.11

MSA는 개발과 함께 운영, 배포 또한 중요함
트랜잭션 - 업무, 시스템 작업단위
커밋, 롤백 개념
CRUD
DB-repository

데이터 규모에 따라 샤딩처리

java는 인터페이스만 제공 각 벤더별로 구현체 제공(driver class)
-> JDBC
SQL query, 파라미터 바인딩, select 절 컬럼 핸들링이 다름 < 이것만 다르게 처리
나머지는 동일하게 처리
IBatis 탄생 > MyBatis 파생
Spring JDBC

commonCP2

엔티티 매니저는 조회, 삭제 (수정 없음) 메소드 소유

JPA Repository 인터페이스를 상속받는 Repository 엔티티 생성
그 엔티티를 구현하는 구현체 자동 생성 > 빈 등록

1.Method query 메소드명을 이용해 쿼리 생성
2.@Query - JPQL, SQL(native query)

QueryDSL - 서드파티 라이브러리
           JPQL을 클래스타입으로 사용하도록 지원
           1) Entity 작성
           2) Entity read, QClass 작성(Mave, Gradle 등 플러그인이 )
           3) QClass를 이용한 DB 프로그래밍

JPQL, SQL 오타 문제
Jooq는 오라클 등 사용하면 유료 그 외 무료

dynamic SQL
            where id = ? and name =?

dynamic JPQL 사용시 편리()

QuerydslRepositorySupport를 상속 받으면

gradle - starter-data-jpa

application.properties
           .yml(구조적으로 표현)



@Entity
@Table

id는 보통 Long(래퍼클래스, 기본형은 null을 가질 수 없음) 자동생성으로 하는것이 좋음

@column 애노테이션(컬럼명 지정시)

@Transactional (readonly = true)
다른 서비스에서 서비스를 호출할 수도 있음 그 서비스도 트랜잭션일 경우 늦게 호출된 서비스에 트랜잭션은
그 전 트랜잭션에 편입됨

메세지 컨버터가 DTO를 json으로 변환해 주는데 변환 못하는 속성때문에 에러 출력

starter-jpa-data
hikaricp (커넥션 풀 객체)

h2database 메모리 디비 - 데이터소스가 설정


# 2018.08.18
lombok 추가시 환경설정 : Compiler > annotation 설정
스프링부트 프로젝트 생성시 데이터소스가 자동으로
데이터소스 - 커넥션 풀 만들고 설정됨

Java App이 종료될 때 특별한 기능이 수행되고 싶을 경우
- Shutdown hook
  > java 문법
  > 스프링
  > Bean이 생성 되려면 생성자가 호출 되어야 함
    생성자가 호출된 이후에 해당 빈의 특정 메소드를 자동으로 실행할 경우
  > 모든 Bean이 생성된 후 어떠한 동작을 해야할 경우
    Bean 생명주기 확인
  > 데이터베이스 프로그래밍 발전순서(java)
    JDBC(java.sql) > SQL Mapper, iBatis(MyBatis), Spring JDBC
    > ORM, Hibernate(구현체)
    > JPA(표준), EntityManager(영속성관리자), 트랜잭션 단위마다 영속성 컨텍스트가 생성 및 삭제됨
    트랜잭션이 종료될 때 지연쓰기(sql을 압축실행)
    > Data JPA(Spring)

Data JPA를 사용하면 JpaRepository 인터페이스를 상속받은 interface를 생성
해당 인터페이스를 구현하는 객체는 자동으로 Bean으로 등록

JPA에서는 SQL을 일반적으로 사용하지 않고 JPQL을 사용
SQL은 특정 DB에 종속되기때문에
Hibernate의 경우 사용하는 DB에 맞는 dialect를 설정

JPQL은 보통 @Query("SELECT b FROM Board b WHERE id = :id")와 같이 사용
:id > 바인딩하여 사용
문제는 Dynamic JPQL의 경우
WHERE id = :id and name = :name, WHERE id = :id and title = :title 와 같이
where절 조건이 완전 바뀌는 경우가 존재

JpaRepository를 상속받는 BoardRepository를 생성
Dynamic JPQL 기능이 필요한 메소드를 가지는 BoardRepositoryCustom 인터페이스를 생성
BoardRepositoryCustom을 구현하는 클래스(BoardRepositoryImpl)를 작성
- BoardRepositoryImpldp EntityManager를 주입, 동적 JPQL을 사용
- QuerydslRepositorySupport를 상속받는 BoardRepositoryImpl를 생성
  QueryDSL을 이용 maven, gradle에 plugin을 설정
BoardRepository는 Custom 인터페이스를 상속

- Entity를 정의할 수 있어야 함
- Entity 간의 관계를 설정할 수 있어야 함
- Entity 간의 관계를 보고 자동 생성되는 table에 유추할 수 있어야 함
- table을 보고 관련된 Entity 클래스들을 작성할 수 있어야 함

DB 프로그래밍에서 가장 성능을 떨어지게 만드는 원인들 중 하나는 잘못된 select문 실행

Board -- BoardFile
1대 다 관계
목록을 출력시 쿼리 1+N 건의 문제가 발생
1) SELECT b FROM Board b
2) b.getBoardFiles() // lazyLoading
   > SELECT bf FROM BoardFile bf WHERE bf.fileId = :fileId
   해당 리스트에서 하니씩 꺼내 name을 출력
Board.title, BoardFile.name을 출력

이 문제를 해결 > JPQL fetch join을 사용
이 때 Entity가 중복되서 가지고 올 수 있기 때문에
JPQL에 distinct를 사용 혹은 Set 자료 구조 사용

Board(table)     BoardFile(table)
1                1   1(fk)
2                2   1(fk)
3                3   2(fk)
4                4   2(fk)
                 5   3(fk)

  BoardRepository 인터페이스(구현체는 자동 생성)
  1) Method Query (메소드명)
  2) @Query (JPQL)

  BoardRepositoryImpl (QuerydslRepositorySupport상속)
  BoardRepositoryCustom을 상속
  1) EntityManager
  2) QueryDSL
  3) plugin 에서 설정


@PostConstruct, @PreDestroy


- JPA, H2 모듈 추가한 프로젝트 생성

자동으로 in-memory DataSource가 만들어짐
schema.sql을 실행해서 database 테이블을 자동으로 생성
data.sql(insert문)을 실행해서 sample data를 자동으로 추가
EntityManager가 Bean으로 등록됨
PlatformTransactionManager가 Bean으로 등록됨
@Transaction 애노테이션 사용


https://www.baeldung.com/spring-boot-data-sql-and-schema-sql

스프링은 설정이 잘못되면 Test메소드 자체가 실행이 안됨

자동으로 테이블 생성 시 문자열의 길이 등을 설정하는 방법
Mysql의 경우 대용량 문자열은 text 타입 > 타입 선언하는 방법


단위 테스트
Mockito 프레임워크

Mock, Spis

spring data jpa 문서
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

QuerydslRepositorySupport를 상속 받으면 EntityManager를

JPQL fetch join

schema.sql로도 테이블 생성 가능

# 2018.08.25

jpaexam 패키지 아래에
controller, service, security, dto 패키지 생성

jpaexam 프로젝트 maven에 sprinng-boot-starter-web 추가

controller 패키지에 TestApiController 클래스를 생성

jpaexam 프로젝트 maven에 sprinng-boot-starter-security 추가

------------------------------------------------------------
ManyToMany

Member                        MemberRole

member   member_member_role   member_role
  1             1(fk)              5
                5(fk)

회원           주문 상품             상품

data.sql 에서
암호 1234를
{bcrypt}$2a$10$9vT04iwbU/VeeeF9AE7vYuOcqNFPPxnC7KgAubX9A4/ISraCL2ubO
로 변경

service 패키지에 인터페이스, 클래스 생성

interface: MemberService
class : MemberServiceImpl (MemberService 구현)

MemberService는 2개의 메소드 소유
Member addMember(Member member)
Member getMemberByEmail(String email)

userDetailService 구현 시 암호 출력이 안됨

------------------------------------------------------------

config 패키지 생성

WebSecurityConfig 파일 생성
@Configuration 애노테이션

/members/login 구현

pom.xml > web.jar 라이브러리 추가 (jQuery, Bootstarp)

th:src 는 컨텍스트 경로 때문에 사용

템플릿에서 해당 라이브러리 사용

BoardService 인터페이스
BoardServiceImpl 클래스 구현

Page<Board> getBoards(int page) // 1이 시작 page

Oauth 2 로그인

Spring Boot doc 내용
- 스프링 부트 설정 (profile 설정)

Spring boot App 배포
- 개념, 도커 이용

RestTemplate 학습, 응용
