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