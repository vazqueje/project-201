# project-201
CSE201 Software Development Project

Image References
1. Main page background: CD Project Red. Cypberpunk2077 (2021)
2. All game cover arts belong to their respective game publishing companies.
    a) (Hearts of Iron 4) https://www.dlh.net/de/news/65063/hearts-of-iron-iv-battle-for-the-bosporus---neues-country-pack-ab-sofort-erhaltlich.html
    b) (Call of Duty Modern Warfare) https://gadgetshelp.com/windows/gde-naiti-luchshie-igry-dlia-xbox-one-v-2019-godu-po-samym-deshevym-tsenam-v-etu-chernuiu-piatnitsu/
    c) (Dark Souls III) https://twitter.com/haniawaja?lang=cs
    d) (Donkey Kong 64) https://imgur.com/gallery/KvGdVug
    e) (Donkey Kong Country) https://twitter.com/runawaykid205
    f) (Super Smash Bros) https://www.reddit.com/r/SmashBrosUltimate/comments/e7ikj9/happy_birthday_ssbu/
3. Gaming Library Logo and GUI design: Jessica Vazquez-Estrada
4. All Descriptions of games were provided by Wikipedia.

Javadoc:
Please Navigate to the folder "Docs" in order to view the JavaDocs.

----Running The Build Script----
Disclaimer: You will need to run this on a Window OS.

--Installing Apache Ant--
Step 1: Go to this link (https://ant.apache.org/bindownload.cgi) 
    Under “1.9.15 release - requires minimum of Java 5 at runtime”
        Download “1.9.15 .zip archive: apache-ant-1.9.15-bin.zip”

Step 2: Extract the compressed zip file 

Step 3: Navigate to the folder “apache-ant-1.9.15”
    Move to the bin
    Copy the bin’s path

Step 4: Search in the Window search bar “This PC”
    Right click “Properties”
    Click on “Advanced system settings”

Step 5: In the system properties window click on “Environment Variables…”
    Under system variables click on “Path” and then click on the “Edit” button
    Then click on “New” button 
    Paste in the bin’s path
    Press Ok.
Step 6: In your Environment variables window and specifically under system variables
    Click the “New” button
    Add into the text field variable name “ANT_HOME”
    Paste in the bin path and remove the bin from the path
        Ex: C:\softwares\apache-ant-1.19.5\bin → C:\softwares\apache-ant-1.19.5\
    Click ok.
Note: If it is not working try restarting your computer.

Step 7: Close all the windows and your Apache Ant should be fully installed and properly configured

--Installing MariaDB--
Step 1: Please refer to https://mariadb.com/kb/en/installing-mariadb-msi-packages-on-windows/ in order to install the database
    Please make sure that the username is “root” and the password is “pV9KrKZbcM!rx6&G”

Step 2: Search in the window search bar “This PC”
    Right click “Properties”
    Click on “Advanced system settings”

Step 3: In the system properties window click on “Environment Variables…”
Under system variables click on “Path” and then click on the “Edit” button
    Then click on “New” button 
    Paste in “C:\Program Files\MariaDB 10.5\bin”
    Press Ok
Step 4: Close all the windows and MariaDB should be fully installed and properly configured


--Gaming Library Build Script instructions--

Step 1: Download the attached zip file from the email.

Step 2: Extract the zip folder in your downloads folder

Step 3: Run the batch script “DatabaseLoader”

Step 4: Run the batch script “AutoRunBuildScript”
    This should create a runnable executable jar.

Step 6: Open up a file explorer window and
    Navigate to CSE 201 Project GUI (it should be in your downloads folder)
    Navigate to dist folder
    Navigate to lib folder
    You should find the GamingLibrary.jar in here
    Double-click on it and the program should run.

