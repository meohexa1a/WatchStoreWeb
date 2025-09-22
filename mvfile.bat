set SOURCE=%~dp0app\build\libs
set DEST=C:\Users\asv\tomcat\apache-tomcat-8.5.99\webapps

xcopy "%SOURCE%\*.war" "%DEST%\" /Y /Q

exit
