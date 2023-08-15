### Dependencies  
- Spring Initializer
```
Spring Web
Validation  
Thymeleaf
Lombok  
Spring Boot DevTools  
Spring Data JPA  
H2 Database
```
- 외부 사이트  
```
testCompileOnly 'org.projectlombok:lombok'  
testAnnotationProcessor 'org.projectlombok:lombok'                                   // 테스트용 Lombok
implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0'            // Spring Boot Data Source Decorator
```
 

<br>

---  
<br>

### IntelliJ IDEA Spring Boot Project 초기 설정  
1. application.yml
```yaml
logging:
  level:
    hello.springmvc: debug                                      // hello.springmvc는 프로젝트명에 따라 변경
    org.hibernate.SQL: debug                                    // SQL 로깅
spring:
  output.ansi.enabled: ALWAYS                                   // 로깅 색깔
  datasource:
    url: jdbc:h2:tcp://localhost/~/jpashop                      // H2 접속 주소
    username: sa                                                // H2 접속 아이디
    password:                                                   // H2 접속 비밀번호
  jpa:
    hibernate.ddl-auto: none                                    // 하이버네이트 데이터를 시작할 때마다 생성할지 여부
    properties.hibernate:
      format_sql: true                                          // SQL 로깅
      default_batch_fetch_size: 1000                            // Lazy 로딩 시 fetch하는 데이터의 양
    open-in-view: false                                         // OSIV
  messages.basename: messages                                   // 메시지 사용 시, 추가  
server.servlet.session:
  tracking-modes: cookie                                        // 쿠키 사용 시, 추가
  timeout: 1800                                                 // 세션 타임아웃 설정 변경 시, 추가
```
<br>  

2. 파일 > 설정 > 빌드, 실행, 배포 > 빌드 도구 > Gradle   
```
다음을 사용하여 빌드 및 실행: IntelliJ IDEA  
다음을 사용하여 테스트 실행: IntelliJ IDEA
```
<br>

3. 파일 > 설정 > 빌드, 실행, 배포 > 컴파일러 > 어노테이션 프로세서
```
어노테이션 처리 활성화
```
<br>

---  
<br>  

### QueryDsl 설정
1. build.gradle
```gradle
plugins {
	id 'com.ewerk.gradle.plugins.querydsl' version '1.0.10'
}
dependencies {
	implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
	implementation fileTree(dir: 'libs', include: ['*.jar'])
	annotationProcessor 'com.querydsl:querydsl-apt:5.0.0:jakarta'
	annotationProcessor 'jakarta.persistence:jakarta.persistence-api'
	annotationProcessor 'jakarta.annotation:jakarta.annotation-api'
}
def querydslDir = "$buildDir/generated/querydsl"
querydsl {
	jpa = true
	querydslSourcesDir = querydslDir
}
sourceSets {
	main.java.srcDir querydslDir
}
configurations {
	querydsl.extendsFrom compileClasspath
}
compileQuerydsl {
	options.annotationProcessorPath = configurations.querydsl
}
```
- 스프링 부트 3.0 이상일 경우  
2. C:\Users\\{사용자명}\\.gradle\caches\modules-2\files-2.1\com.querydsl\querydsl-jpa\5.0.0
```
여러 숫자 디렉터리 안의 파일 중 'querydsl-jpa-5.0.0-jakarta' 복사
```
3. 프로젝트의 루트 디렉토리 (build.gradle 있는 디렉토리)
```
/libs 디렉토리 생성
'querydsl-jpa-5.0.0-jakarta' 붙여넣기
```
##### ** 외부 라이브러리의 javax import한 파일 대신 /libs의 jakarta를 import한 파일 사용 **
<br>

- 스프링 부트 버전 상관 없이 공통
4. IntelliJ에서 Gradle > Tasks > other > compileQuerydsl 더블 클릭
##### ** 앞으로 QueryDsl 사용 시, 빌드 전에 ./gradle clean 후 실행 **
<br>

---
<br>  

#### 스프링 부트 3.0 이상일 경우  
1. Java 17 이상 사용
- 로컬 운영체제의 java -version
- 파일 > 설정 > 빌드, 실행, 배포 > 빌드 도구 > Gradle > Gradle 프로젝트 > Gradle > Gradle JVM   
- 파일 >프로젝트 구조 > 프로젝트 설정 > 프로젝트 > SDK  
  
2. javax 패키지 이름을 jakarta로 변경     
> 예) javax.persistence.Entity => jakarta.persistence.Entity  
  
3. H2 데이터베이스는 2.1.214 버전 이상 사용   
<br>

---
<br>  

### H2 서버 종료  
1. 윈도우 > 명령 프롬프트  
2. jps 입력  
3. Console 앞에 숫자 확인 (예. 12612 Console)  
4. taskkill /f /pid 12612 입력 (12612 대신 해당 숫자)  
<br>

---
<br>  

### OpenJDK로 실행 시 해당 경고 문구 끄기  
> OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended  
- 실행 > 구성 편집 > VM 옵션 창 > '-Xshare:off' 추가  
<br>  

---
<br>  

