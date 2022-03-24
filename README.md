# sp_springnreact

https://hellodoor.tistory.com/107

<pre><code>

curl -X GET http://localhost:8080/clients 


curl -d '{"name": "John Doe", "email": "john.doe@baeldgung.com"}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/clients 

</code></pre>

# client 환경 생성
npx create-react-app frontend

npm install --save bootstrap@5.1 react-cookie@4.1.1 react-router-dom@5.3.0 reactstrap@8.10.0




# server start

mvn springboot:run


# client start

yarn start


# 데이터 입력 

curl -d '{"name": "John Doe", "email": "john.doe@baeldgung.com"}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/clients 

데이터 입력하고 Reflesh 하면 정상적으로 출력이 된다.

# Creating a ClientList Component #6 까지 진행했을때 에러메시지
<pre><code>
Compiled with problems:X

ERROR in ./src/App.js

Module build failed (from ./node_modules/babel-loader/lib/index.js):
SyntaxError: /Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/src/App.js: Unexpected token (81:7)

  79 | }
  80 |
> 81 | export default App;
     |        ^
    at instantiate (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:72:32)
    at constructor (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:358:12)
    at Object.raise (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:3334:19)
    at Object.unexpected (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:3372:16)
    at Object.parseClassMemberWithIsStatic (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:15597:12)
    at Object.parseClassMember (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:15464:10)
    at Object.parseClassMember (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:6130:11)
    at /Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:15404:14
    at Object.withSmartMixTopicForbiddingContext (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:14208:14)
    at Object.parseClassBody (/Users/hyunminlee/work/_sf/SpringnReact/demo/frontend/node_modules/@babel/parser/lib/index.js:15379:10)


ERROR


src/App.js
  Line 81:7:  Parsing error: Unexpected token (81:7)
</code></pre>

중괄호 하나를 빠져먹었다. 다른 에러메시지

<pre><code>
Compiled with problems:X

ERROR


src/App.js
  Line 48:16:  'ButtonGroup' is not defined  react/jsx-no-undef
  Line 49:20:  'Button' is not defined       react/jsx-no-undef
  Line 49:58:  'Link' is not defined         no-undef
  Line 50:20:  'Button' is not defined       react/jsx-no-undef
  Line 58:12:  'AppNavbar' is not defined    react/jsx-no-undef
  Line 59:12:  'Container' is not defined    react/jsx-no-undef
  Line 61:20:  'Button' is not defined       react/jsx-no-undef
  Line 61:48:  'Link' is not defined         no-undef
  Line 64:16:  'Table' is not defined        react/jsx-no-undef

Search for the keywords to learn more about each error.
</code></pre>


Creating a ClientEdit Component #7  

여기까지 했을때  화면에 아무것도 나오지 않는다.


<pre><code>
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.177 s
[INFO] Finished at: 2022-03-24T09:53:04+09:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal com.github.eirslett:frontend-maven-plugin:1.6:install-node-and-yarn (install node) on project demo: Could not download Node.js: Could not download https://nodejs.org/dist/v14.8.0/node-v14.8.0-darwin-x64.tar.gz: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
</code></pre>


maven  node install 할때 아래의 에러메시지 발생

<pre><code>
javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
</code></pre>

https://sailing-ship.tistory.com/5891

https://confluence.atlassian.com/kb/unable-to-connect-to-ssl-services-due-to-pkix-path-building-failed-error-779355358.html

회사망에서 밖으로 나가서 그런거다. 테더링을 해서 하면 에러가 발생을 하지 않는다.

jdk 위치확인하기
mvn -info

bin/keytool -importcert -keystore lib/security/cacerts -storepass changeit -file /Users/hyunminlee/work/_sf/SpringnReact/SK_holdings_CC.cer


mvn spring-boot:run 할때 실행 로그
<pre><code>
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.6.4:run (default-cli) > test-compile @ demo >>>
[INFO] 
[INFO] --- frontend-maven-plugin:1.6:install-node-and-yarn (install node) @ demo ---
[INFO] Node v14.8.0 is already installed.
[INFO] Yarn 1.12.1 is already installed.
[INFO] 
[INFO] --- frontend-maven-plugin:1.6:yarn (yarn install) @ demo ---
[INFO] Running 'yarn ' in /Users/hyunminlee/work/_sf/SpringnReact/demo/frontend
[INFO] yarn install v1.12.1
[INFO] info No lockfile found.
[ERROR] warning package-lock.json found. Your project contains lock files generated by tools other than Yarn. It is advised not to mix package managers in order to avoid resolution inconsistencies caused by unsynchronized lock files. To clear this warning, remove package-lock.json.
[INFO] [1/4] Resolving packages...
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ demo ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- frontend-maven-plugin:1.6:yarn (yarn build) @ demo ---
[INFO] Running 'yarn build' in /Users/hyunminlee/work/_sf/SpringnReact/demo/frontend
[INFO] yarn run v1.12.1
[INFO] $ react-scripts build
[INFO] Creating an optimized production build...
[INFO] Compiled successfully.
[INFO] 
[INFO] File sizes after gzip:
[INFO] 
[INFO]   59.17 kB  build/static/js/main.9ef4e51a.js
[INFO]   24.6 kB   build/static/css/main.04179b6f.css
[INFO]   1.78 kB   build/static/js/787.cda612ba.chunk.js
[INFO] 
[INFO] The project was built assuming it is hosted at /.
[INFO] You can control this with the homepage field in your package.json.
[INFO] 
[INFO] The build folder is ready to be deployed.
[INFO] You may serve it with a static server:
[INFO] 
[INFO]   npm install -g serve
[INFO]   serve -s build
[INFO] 
[INFO] Find out more about deployment here:
[INFO] 
[INFO]   https://cra.link/deployment
[INFO] 
[INFO] Done in 8.78s.
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:copy-resources (copy-resources) @ demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 14 resources
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/hyunminlee/work/_sf/SpringnReact/demo/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ demo ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.6.4:run (default-cli) < test-compile @ demo <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.6.4:run (default-cli) @ demo ---
[INFO] Attaching agents: []
11:11:26.545 [Thread-0] DEBUG org.springframework.boot.devtools.restart.classloader.RestartClassLoader - Created RestartClassLoader org.springframework.boot.devtools.restart.classloader.RestartClassLoader@1c892e29

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.4)

2022-03-24 11:11:31.910  INFO 65895 --- [  restartedMain] com.example.demo.DemoApplication         : Starting DemoApplication using Java 11.0.2 on MacBook-Pro.local with PID 65895 (/Users/hyunminlee/work/_sf/SpringnReact/demo/target/classes started by hyunminlee in /Users/hyunminlee/work/_sf/SpringnReact/demo)
2022-03-24 11:11:31.911  INFO 65895 --- [  restartedMain] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
2022-03-24 11:11:31.956  INFO 65895 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2022-03-24 11:11:31.956  INFO 65895 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2022-03-24 11:11:32.462  INFO 65895 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-03-24 11:11:32.501  INFO 65895 --- [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 31 ms. Found 1 JPA repository interfaces.
2022-03-24 11:11:32.972  INFO 65895 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-03-24 11:11:32.983  INFO 65895 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-03-24 11:11:32.983  INFO 65895 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.58]
2022-03-24 11:11:33.059  INFO 65895 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-03-24 11:11:33.059  INFO 65895 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1102 ms
2022-03-24 11:11:33.092  INFO 65895 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-03-24 11:11:33.199  INFO 65895 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-03-24 11:11:33.206  INFO 65895 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:dd7c0955-baf0-4fe9-8cd0-ff382115a142'
2022-03-24 11:11:33.356  INFO 65895 --- [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-03-24 11:11:33.398  INFO 65895 --- [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.6.5.Final
2022-03-24 11:11:33.511  INFO 65895 --- [  restartedMain] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2022-03-24 11:11:33.594  INFO 65895 --- [  restartedMain] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2022-03-24 11:11:33.941  INFO 65895 --- [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-03-24 11:11:33.946  INFO 65895 --- [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-03-24 11:11:34.194  WARN 65895 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-03-24 11:11:34.364  INFO 65895 --- [  restartedMain] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page: class path resource [static/index.html]
2022-03-24 11:11:34.474  INFO 65895 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2022-03-24 11:11:34.511  INFO 65895 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-03-24 11:11:34.521  INFO 65895 --- [  restartedMain] com.example.demo.DemoApplication         : Started DemoApplication in 7.966 seconds (JVM running for 8.415)
2022-03-24 11:11:50.192  INFO 65895 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-03-24 11:11:50.193  INFO 65895 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-03-24 11:11:50.194  INFO 65895 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
</code></pre>
