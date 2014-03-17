MOTECH-Mini-Project
===================


Prerequisites
=============
JRE 1.7 or above
JDK 1.5 or above

How to use
==========
1. Open Command Prompt
2. Type the command "set CLASSPATH=%CLASSPATH%;../translation-api;"
3. Navigate to directory "src"
4. Type the command "javac Main.java"
5. Type the command "java Main" and follow the prompts
6. Alternatively, the command line argument version can be used: type the command:
	"java Main [source-path] [target-path] [source-language] [target-language]"

Program Description
====================
The program translates one side of a string with the '=' sign being the delimiter. This is particularly useful in translating files like properties file (See in extra -> modified_messages.properties, with the original file being messages.properties)

Hence, the source can be used for the translation of UI files, where the strings that are displayed in the UI can be translated into one of the languages supported by the software. For the list of languages supported, the user can refer to the 'Supported_Languages' file under 'extra.'

The Client Secret has to be kept... well, secret. Therefore, neither the Client ID nor the Client Secret is there in the source. However, the .class files are fully functional. Users are encouraged to visit the Azure Marketplace and get themselves registered to get their personal ID and Client Secret.

The program is developed using the Bing translation libraries. The API is provided by Microsoft on a non-commercial licence. The free account has a limit of 2 million characters per month. The Java wrapper for the API is provided by :

https://github.com/boatmeme/microsoft-translator-java-api

It is available as a JAR file from the link above. The contents of JAR have been extracted and placed under the directory named 'translation-api.'

Improvements
=============

1. The program now accepts command line arguments.
2. Prompts that indicate what values are to be entered, in case the user does not use the command line arguments to excute the program.
3. If invalid values are entered for either of the source or target languages, an error is displayed.
4. While translating, it displays the status of the file being translated in terms of percentage.

Examples
=========
Some examples of the files already translated using this script can be found in the directory named 'extra.'
Nevertheless, here is what the application of the script to the file 'Source.txt' did:
<br/>
Contents of the file 'Source.txt'
<br/>

	King=king
	Queen=queen

	Mango=mango
	Banana=banana
	
	Wind=wind
	

<br/>
The file was translated in Hindi and the contents were saved to a file named 'Target.txt', whose contents are as follows:
Contents of the file 'Target.txt':
<br/>

	King=राजा
	Queen=रानी
	
	Mango=मैंगो
	Banana=केले
	
	Wind=पवन

<br/>	
The files 'messages.properties' and 'modified_messages.properties' (under the 'extra' directory) also depict the same. 
