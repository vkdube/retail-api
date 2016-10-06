@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  retail-api-ws startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and RETAIL_API_WS_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\retail-api-ws-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\spring-beans-4.3.2.RELEASE.jar;%APP_HOME%\lib\spring-context-4.3.2.RELEASE.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.12.jar;%APP_HOME%\lib\commons-lang-2.5.jar;%APP_HOME%\lib\bcel-5.1.jar;%APP_HOME%\lib\swagger-annotations-1.5.3-M1.jar;%APP_HOME%\lib\jersey-test-framework-provider-grizzly2-2.6.jar;%APP_HOME%\lib\jersey-container-servlet-core-2.6.jar;%APP_HOME%\lib\jersey-client-2.6.jar;%APP_HOME%\lib\jsr305-3.0.0.jar;%APP_HOME%\lib\codemodel-2.6.jar;%APP_HOME%\lib\cucumber-java-1.2.2.jar;%APP_HOME%\lib\cucumber-junit-1.2.2.jar;%APP_HOME%\lib\dropwizard-core-0.6.2.jar;%APP_HOME%\lib\commons-collections-3.2.1.jar;%APP_HOME%\lib\testng-6.5.2.jar;%APP_HOME%\lib\retail-api-service-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\retail-api-data-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\retail-api-entity-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\servlet-api-2.5.jar;%APP_HOME%\lib\cglib-2.2.jar;%APP_HOME%\lib\metrics-core-3.1.0.jar;%APP_HOME%\lib\metrics-annotation-3.1.0.jar;%APP_HOME%\lib\logback-json-core-0.1.2.jar;%APP_HOME%\lib\logback-json-classic-0.1.2.jar;%APP_HOME%\lib\logback-jackson-0.1.2.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\javax.websocket-api-1.0.jar;%APP_HOME%\lib\logback-ext-spring-0.1.1.jar;%APP_HOME%\lib\org.mortbay.jetty.plus-5.1.10.jar;%APP_HOME%\lib\spring-core-4.3.2.RELEASE.jar;%APP_HOME%\lib\spring-aop-4.3.2.RELEASE.jar;%APP_HOME%\lib\spring-expression-4.3.2.RELEASE.jar;%APP_HOME%\lib\jersey-test-framework-core-2.6.jar;%APP_HOME%\lib\jersey-container-grizzly2-http-2.6.jar;%APP_HOME%\lib\junit-4.11.jar;%APP_HOME%\lib\asm-all-repackaged-2.2.0.jar;%APP_HOME%\lib\javax.inject-2.2.0.jar;%APP_HOME%\lib\jersey-server-2.6.jar;%APP_HOME%\lib\jersey-common-2.6.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.jar;%APP_HOME%\lib\hk2-api-2.2.0.jar;%APP_HOME%\lib\hk2-locator-2.2.0.jar;%APP_HOME%\lib\cucumber-core-1.2.2.jar;%APP_HOME%\lib\jersey-core-1.17.1.jar;%APP_HOME%\lib\jersey-server-1.17.1.jar;%APP_HOME%\lib\jersey-servlet-1.17.1.jar;%APP_HOME%\lib\metrics-core-2.2.0.jar;%APP_HOME%\lib\metrics-servlet-2.2.0.jar;%APP_HOME%\lib\metrics-jetty-2.2.0.jar;%APP_HOME%\lib\metrics-logback-2.2.0.jar;%APP_HOME%\lib\metrics-jersey-2.2.0.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.1.4.jar;%APP_HOME%\lib\jackson-datatype-guava-2.1.2.jar;%APP_HOME%\lib\argparse4j-0.4.0.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.4.jar;%APP_HOME%\lib\logback-core-1.0.10.jar;%APP_HOME%\lib\logback-classic-1.0.10.jar;%APP_HOME%\lib\log4j-over-slf4j-1.7.4.jar;%APP_HOME%\lib\jetty-server-8.1.10.v20130312.jar;%APP_HOME%\lib\jetty-servlet-8.1.10.v20130312.jar;%APP_HOME%\lib\jetty-http-8.1.10.v20130312.jar;%APP_HOME%\lib\guava-14.0.1.jar;%APP_HOME%\lib\hibernate-validator-4.3.1.Final.jar;%APP_HOME%\lib\joda-time-2.2.jar;%APP_HOME%\lib\jackson-datatype-joda-2.1.2.jar;%APP_HOME%\lib\bsh-2.0b4.jar;%APP_HOME%\lib\jcommander-1.12.jar;%APP_HOME%\lib\snakeyaml-1.6.jar;%APP_HOME%\lib\java-client-2.3.1.jar;%APP_HOME%\lib\spring-data-couchbase-1.0.0.RELEASE.jar;%APP_HOME%\lib\jackson-core-asl-1.9.13.jar;%APP_HOME%\lib\jackson-xc-1.9.13.jar;%APP_HOME%\lib\jackson-core-2.6.0.jar;%APP_HOME%\lib\jackson-annotations-2.6.0.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.6.0.jar;%APP_HOME%\lib\asm-3.1.jar;%APP_HOME%\lib\grizzly-http-server-2.3.8.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\jersey-guava-2.6.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\hk2-utils-2.2.0.jar;%APP_HOME%\lib\aopalliance-repackaged-2.2.0.jar;%APP_HOME%\lib\javassist-3.18.1-GA.jar;%APP_HOME%\lib\cucumber-html-0.2.3.jar;%APP_HOME%\lib\cucumber-jvm-deps-1.0.3.jar;%APP_HOME%\lib\gherkin-2.12.2.jar;%APP_HOME%\lib\metrics-annotation-2.2.0.jar;%APP_HOME%\lib\jetty-security-8.1.10.v20130312.jar;%APP_HOME%\lib\jetty-io-8.1.10.v20130312.jar;%APP_HOME%\lib\jboss-logging-3.1.0.CR2.jar;%APP_HOME%\lib\core-io-1.3.1.jar;%APP_HOME%\lib\spring-web-3.2.8.RELEASE.jar;%APP_HOME%\lib\spring-tx-3.2.8.RELEASE.jar;%APP_HOME%\lib\spring-data-commons-1.7.1.RELEASE.jar;%APP_HOME%\lib\couchbase-client-1.3.2.jar;%APP_HOME%\lib\jackson-mapper-asl-1.9.13.jar;%APP_HOME%\lib\grizzly-http-2.3.8.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\jetty-util-8.1.10.v20130312.jar;%APP_HOME%\lib\rxjava-1.1.5.jar;%APP_HOME%\lib\netty-3.5.5.Final.jar;%APP_HOME%\lib\jettison-1.1.jar;%APP_HOME%\lib\commons-codec-1.5.jar;%APP_HOME%\lib\spymemcached-2.10.5.jar;%APP_HOME%\lib\httpcore-4.3.jar;%APP_HOME%\lib\httpcore-nio-4.3.jar;%APP_HOME%\lib\grizzly-framework-2.3.8.jar;%APP_HOME%\lib\stax-api-1.0.1.jar;%APP_HOME%\lib\slf4j-api-1.7.12.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\jackson-databind-2.6.0.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.6.0.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.6.0.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\javax.servlet-3.0.0.v201112011016.jar;%APP_HOME%\lib\jetty-continuation-8.1.10.v20130312.jar

@rem Execute retail-api-ws
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %RETAIL_API_WS_OPTS%  -classpath "%CLASSPATH%" com.retail.api.service.product.RetailProductService %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable RETAIL_API_WS_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%RETAIL_API_WS_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
