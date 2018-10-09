# qaauto-24.09.2018

Tools installation:
1. geckodriver;
2. Mozilla Firefox version 62 installed (latest);
3. JDK 10.0.2;
4. Intellij IDEA 'Community' version;
5. Selenium Java » 3.14.0;
6. Git

Tools setup:
1. pom.xml - the list of all libraries (dependencies) that are used in the project is stored here. Each library 
   is identified as well as the project itself - a groupId, artifactId, version (GAV) troika.
2. .gitIgnore is used to specify in it files and folders that must be hidden from the git version control system.
3. How to run the current test script:
    1) Choose 'BadCodeExample4.java'
    2) Click on menu bar 'Run'.
    3) Click in drop down menu 'Run 'BadCodeExample4''.
4. To run tests in Firefox version 48 or newer you need to have a geckodriver.
   How to install 'geckodriver':
    1) Download 'geckodriver';
    2) Paste him in C:\Windows\System32
5. Selenium is a tool for automating web browser actions.
   How to install 'Selenium Java » 3.14.0':
    1) Go to https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.14.0;
    2) Copy Maven text;
    3) Open pom.xml in Intellij IDEA;
    4) In pom.xml before '</project>' write '<dependencies>';
    5) Paste Maven text after '<dependencies>';
    6) Write after Maven text '</dependencies>'.
6. Git is a version-control system for tracking changes in computer files and coordinating work on those files 
   among multiple people. It is primarily used for source-code management in software development.
   How to install 'Git':
    1) Download 'Git setup';
    2) Run 'Git setup';
    3) Always click 'next';
    4) Click 'install'.
7. The Java Development Kit (JDK) is an implementation of either one of the Java Platform, Standard Edition, Java Platform, 
   Enterprise Edition, or Java Platform, Micro Edition platforms[1] released by Oracle Corporation 
   in the form of a binary product aimed at Java developers on Solaris, Linux, macOS or Windows.
   How to install 'JDK 10.0.2':
    1) Go to http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html;
    2) Click 'Accept License Agreement';
    3) Click 'jdk-10.0.2_windows-x64_bin.exe';
    4) Download 'jdk-10.0.2_windows-x64_bin.exe';
    5) Before download click 'jdk-10.0.2_windows-x64_bin.exe'
    6) Install 'jdk-10.0.2_windows-x64_bin.exe'.
