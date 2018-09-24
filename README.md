# full-stack-example

There are a few setup steps that you all will need to complete before you can access the web application locally. I will attempt to outline them here as best I can, if I forget something or something doesn't quite work, feel free to email me or catch me at the office and threaten me with torches and pitchforks. Either work equally well.

1) You will need to download a copy of JBoss WildFly for your personal use on your computer. You can go to http://wildfly.org/downloads/ and grab the latest version. I have 13 Final for my local copy. Once it is downloaded, it should just be able to be extracted to a folder of your choice on your machine.
2) Get a copy of Eclipse on your machine. You can technically use any IDE you want, however this sample was built in Eclipse and I use that to compile and deploy. If you use Eclipse, then you should also download JBoss Tools as an add-on to it and set it up to point to your also newly downloaded JBoss Wildfly instance.
	1) When you launch Eclipse, click Help -> Eclipse Marketplace
	2) Search for JBoss Tools. You should find JBoss Tools 4.6.0 as part of the results. Install them and restart Eclipse when prompted (or if not prompted, restart after it installs anyways.
	3) Click on the Servers tab at the bottom panel. (If it isnt open then you need to click on Window -> Show View -> Other..., search for Server and click the Servers option to open the view).
	4) In the Servers tab, right-click and select New -> Server.
	5) In the dialog box type Wildfly and select WIldfly 13.Follow the wizard to add the server and set up the new Runtime. If it doesn't default to this (which it should) I recommend calling the runtime WildFly 13.0 Runtime. When asked for the home directory, point it to the downloaded copy you have on your machine (ex: D:\Servers\wildfly-13)
3) Download a local copy of MySQL onto your machine. Follow this link to download the MSI that contains all MySQL products we care about: https://dev.mysql.com/downloads/installer/
	1) You will want to install the actual database on the machine and I recommend installing the Workbench as well so you have a decent GUI to be able to interact with it. You can configure it however you wish with username/password but just need to set up a root user.
	2) Once you have it installed and can connect to it, you will need to execute the attached SQL file. This will auto-generate the table, sequence, and fill it with data initially so that you don't run into the issues I did today with it auto-dropping the table.
4) In your copy of JBoss you have downloaded, we need to configure the standalone XML file to link JBoss to your datasource. I have attached my standalone XML file that has it already filled out. You should be able to overwrite your JBoss file with this one (it lives in JBOSS_HOME\standalone\configuration\standalone.xml)
	1) Once you have the new file, open it up in an editor (Notepad++ is a great choice if you don't have one you like to use) and search for EmpireDS. 
	2) Alter the username and password value to what your root/password value is for you locally. Save and close.
5) Now we need to add the JAR file to the JBoss modules location so that it can tag into the database.
	1) Navigate to JBOSS_HOME\modules\system\layers\base and create the following folder structure: com\mysql\main	
	2) Attached to this is a module.xml file. Place this file in the main folder created.
	3) Attached is a JAR file that is named with a .REM. Just rename the file and take off the .rem at the end and place the JAR file in the main folder. Don't ask me why, Google is trying to be slick and prevent some executable JAR files from being attachments. I mean, good on them for security but it makes this harder to email.
6) In Eclipse, you should be able to now right click on the server you created and select Start. It should start with no issues and it would also be connected to the Database instance. (There should be something in the log files that looks like WFLYJCA0001: Bound data source [java:/EmpireDS])
7) You should now be ready (finally) to import in the project to Eclipse.
	1) Download the code from https://github.com/jgraham0628/full-stack-example.
	2) In the Project Explorer tab, you should be able to right click and select Import -> Import
	3) Filter down with the word 'Existing' and select the Existing Projects into Workspace
	4) Under Select Root Directory click Browse... and select the folder that you extracted the projects into. Select all three projects to import.
	5) If all things are perfect (which I'd be surprised if it was) then there should be no red marks in your code imported and it can be built and deployed out. MORE THAN LIKELY you will need to fix the build paths for a few items, I am speculating the Java JDK/JRE and/or the Server Library.
		1) Right click on a project with red marks, select Build Path -> Configure Build Path. Click on the Libraries tab and select one of the libraries with an error. You should be able to click Edit and modify the value to whatever it needs to be (should be mostly straight forward). If need be send me screenshots / errors and I can help diagnose and repair.
8) Once all things are complete, you should be able to right click on the EmpireToday project (not the EJB or Web one) and select Run As -> Other -> Run on Server.
9) Select the Wildfly 13 Server and click Finish. This should deploy out the project to the server.
10) If it deploys out with no issues (which we all know it will right?) then you should be able to navigate in a web browser to http://localhost:8080/Empire-Web/ and see the lovely Imperial Logo backsplash you saw earlier today.

Congratulations! The application is set up and configured to deploy out for your local machine. Feel free to play around and break it. You have steps to revert it back here if you ever need them. Feel free to ask me questions if you have them and I can try to help answer them. Happy playing!