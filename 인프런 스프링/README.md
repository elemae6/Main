### Spring Initializr Dependencies  
> Spring Web  
> Validation  
> Thymeleaf  
> Lombok  
> Spring Boot DevTools  
> Spring Data JPA  
> H2 Database  
- 외부 사이트에서 추가
  - test용 lombok
  - P6SPY (Spring Bootd Data Source  Decorator)
 
---  
### IntelliJ IDEA Spring Boot Project 초기 설정  
1. application.properties
```
logging.level.hello.springmvc=debug                    //hello.springmvc는 프로젝트명에 따라 변경
spring.output.ansi.enabled=ALWAYS
#spring.messages.basename=messages                     //메시지 사용 시, 추가  
#server.servlet.session.tracking-modes=cookie          //쿠키 사용 시, 추가
#server.servlet.session.timeout=1800                   //세션 타임아웃 설정 변경 시, 추가
```
<br>

2. 파일 > 설정 > 빌드, 실행, 배포 > 빌드 도구 > Gradle   
> 다음을 사용하여 빌드 및 실행: IntelliJ IDEA  
> 다음을 사용하여 테스트 실행: IntelliJ IDEA
<br>

3. 파일 > 설정 > 빌드, 실행, 배포 > 컴파일러 > 어노테이션 프로세서
> 어노테이션 처리 활성화
<br>

4. 파일 > 설정 > 에디터 > 파일 인코딩
> 프로퍼티 파일에 대한 디폴트 인코딩: UTF-8
<br>

5. build.gradle > dependencies
> testCompileOnly 'org.projectlombok:lombok:1.18.28'  
> testAnnotationProcessor 'org.projectlombok:lombok:1.18.28'
> implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0'          // JPA 사용 시 추가
<br>

--- 

#### 스프링 부트 3.0 이상일 경우  
1. Java 17 이상 사용
- 로컬 운영체제의 java -version
- 파일 > 설정 > 빌드, 실행, 배포 > 빌드 도구 > Gradle > Gradle 프로젝트 > Gradle > Gradle JVM:   
- 파일 >프로젝트 구조 > 프로젝트 설정 > 프로젝트 > SDK  
  
2. javax 패키지 이름을 jakarta로 변경     
> 예) javax.persistence.Entity => jakarta.persistence.Entity  
  
3. H2 데이터베이스는 2.1.214 버전 이상 사용   
<br>

---
### H2 서버 종료  
1. 윈도우 > 명령 프롬프트  
2. jps 입력  
3. Console 앞에 숫자 확인 (예. 12612 Console)  
4. taskkill /f /pid 12612 입력 (12612대신 해당 숫자)  

---  
### OpenJDK로 실행 시 해당 경고 문구 끄기  
> OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended  
- 실행 > 구성 편집 > VM 옵션 창 > '-Xshare:off' 추가  
---
