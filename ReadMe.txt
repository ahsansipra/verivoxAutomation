Verivox Automation Assignment--

Please follow the instructions to run the project.

Instructions:

1: Access following URL to get project from GITHub https://github.com/ahsansipra/verivoxAutomation.git

2: Once downloaded, execute 'verivox.bat' file and project test run execution will get started
or open command prompt and navigate to project root directory
 Type following command and project execution will get started

command:
mvn clean test


Project Overview:

It is Maven/Cucumber project along with Page Object Model (POM) is used

1:	Object Identification & actions are kept separate.
2:	For object identification, locators used are: ID, xpath, name
3:	In 'WebDriverManager' class, WebDriver is configured and initialized which is singleton class. browser config details are given in ‘config.properties’ file.
    	Once initialized it will be used throughout test suit execution.
4:  	Reports will be generated inside project 'target\surefire-reports' 
5:  	Log file will be generated inside project root directory with name 'logfile.log'


Dependencies:

Its maven project-based project, so maven should be installed on machine where project will be launched
1: Java version is used in Project: 1.8
2: Apache maven version in Project: used 3.6.2
