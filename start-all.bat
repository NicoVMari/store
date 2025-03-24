@echo off
echo Avvio di Apache...
cd /d "C:\xampp\apache\bin"
start /B httpd.exe

echo Avvio del backend...
cd /d "C:\Users\nmarino\Documents\Project\store\backend\store\out\artifacts\store_jar"
start /B java -jar store.jar
pause
