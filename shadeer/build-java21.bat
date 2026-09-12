@echo off
setlocal
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot"
set "PATH=C:\Program Files\Eclipse Adoptium\jdk-21.0.11.10-hotspot\bin;%PATH%"
echo Using Java 21 for build
java -version
echo.
echo Starting build...
gradlew.bat build
endlocal