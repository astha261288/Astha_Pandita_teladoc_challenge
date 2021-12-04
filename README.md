--------------------------------
INTRODUCTION
--------------------------------

This is a maven project, integrated with Selenium and TestNg. 

---------------------------------
OBJECTIVE
---------------------------------

The objective of this project is to test Add User and Delete User test cases for 
http://www.way2automation.com/angularjs-protractor/webtables/ 

----------------------------------
RUN THE SCRIPTS
----------------------------------

1. Add the project to Eclipse
2. Right click on testNg.xml
3. Select Run > TestNgSuite

-----------------------------------
DESCRIPTION OF PROJECT
-----------------------------------

com.teladoc.BaseSetUp.java : 
Contains base methods for starting the browser and tearing down the browser

com.teladoc.challenge.testScripts.AddUserTest.java:
Before the test, the browser will be launched by calling startBrowser() of BaseSetUp.java
Method addUser() will be executed(accepts parameters from testNg.xml) - to click Add User button, fill in the details and click Save. Browser will be refreshed and verify if the new user is added.
After the test, the browser will be teared down by calling afterTest() of BaseSetUp.java

com.teladoc.challenge.testScripts.DeleteUserTest.java:
Before the test, the browser will be launched by calling startBrowser() of BaseSetUp.java
Method deleteUser() will be executed(accepts parameters from testNg.xml) - to click Delete User button of given UserName and click OK. Browser will be refreshed and verify if the given user is deleted.
After the test, the browser will be teared down by calling afterTest() of BaseSetUp.java
