This repo will help you to create a from scratch selenium based test automation framework
GOAL
The aim of this customised framework is to test any UI applicaiton easily just by adding Locators to it and no need to change step definitions
The below is the setup steps in simple way to build a selenium based automation framework.

1) Install JDK
https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html
Verification --> "java -version" (appropriate version should display)

3) Apache Maven
https://maven.apache.org/download.cgi --> (Binary zip archive ,Link)
After downloading keep the extracted files here "C:\Program Files\Apache\Maven"
Go to Control Panel → System → Advanced System Settings → Environment Variables.
Under System Variables, find Path and click Edit.
Click New and add the path: C:\Program Files\Apache\Maven\bin
Verification --> "mvn -version"

4) Install Chrome Driver
https://googlechromelabs.github.io/chrome-for-testing/#stable
Check your Chrome Driver "chrome://version"
Check your system type in settings-> About-> System Type 
Download appropriate Binary and platform
Extract the folder to "C:\chromedriver"
Verification --> "chromedriver --version"

5) Install VS Code
https://code.visualstudio.com/
Go to Extensions (Ctrl + Shift + X)
Cucumber (Gherkin) Full Support

