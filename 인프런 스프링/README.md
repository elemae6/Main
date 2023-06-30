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
> compileOnly 'com.google.code.findbugs:jsr305:3.0.2'  
> compileOnly 'org.checkerframework:checker-qual:3.14.0'
<br>
