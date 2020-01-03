Feature: Login into Application

Scenario Outline: login succesfully
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on login link
When User enters <username> and <password>
Then Verify that user is succesfully logged in
And Closes browser

Examples:
|username		 |password	|
|test99@gmail.com|123456	|
|test123@abc.com |12345		|