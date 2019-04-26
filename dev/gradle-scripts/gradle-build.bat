@ECHO OFF
REM %1 used for doing 'clean'
SET CACHE=%CD%
CD ../../ & CALL gradlew %1 build & CD %CACHE%
PAUSE