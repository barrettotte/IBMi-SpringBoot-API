@ECHO OFF
SET CACHE=%CD%
CD ../ & CALL gradle build --refresh-dependencies & CD %CACHE%
PAUSE