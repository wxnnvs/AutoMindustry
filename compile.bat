@echo off
REM Compile all Java files in the current directory
javac *.java

REM Create a manifest file
echo Main-Class: AutoMindustry > Manifest.txt

REM Create the JAR file
jar cvfm Main.jar Manifest.txt *.class

REM Clean up the manifest and class files
del Manifest.txt
del *.class

echo.
echo JAR file has been created.
pause
cls