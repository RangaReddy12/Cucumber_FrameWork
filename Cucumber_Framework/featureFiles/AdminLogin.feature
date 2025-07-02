@Tag
Feature: Admin login Functionality
As admin user i want to test with valid data
@Validdata
Scenario:
Validate login with valid username and password
Given i navigate url"http://orangehrm.qedgetech.com/" in a browser
Then i check login button displayed in home page
When user enter username as"Admin"
And user enter password as "Qedge123!@#"
When i click login button
Then i verify url for login success
When i close  browser
@MultipleData
Scenario Outline:
Validate Login with multiple data
Given i navigate url"http://orangehrm.qedgetech.com/" in a browser
When user enter username as"<Username>"
And user enter password as "<Password>"
When i click login button
Then i verify url for login success
When i close  browser
Examples:
|Username|Password|
|Admin|Qedge123!@#|
|test|Qedge123!@#|
|Admin|Qedge123!@#|
|Admin||
|Admin|Qedge123!@#|
||Qedge123!@#|
|Admin|Qedge123!@#|
|||
|Admin|Qedge123!@#|
@AddEmp
Scenario Outline:
Validate Add emp with Multiple data
Given i navigate url"http://orangehrm.qedgetech.com/" in a browser
When user enter username as"Admin"
And user enter password as "Qedge123!@#"
When i click login button
Then i verify url for login success
When i navigate to add employee page
When user enter fname as"<FirstName>"
When user enter mname as "<Middlename>"
When user enter as lname "<Lastname>"
When user capture emp id
When  i click save button
Then verify emp id in table
When i close  browser
When i click admin
Examples:
|FirstName|Middlename|Lastname|
|Akhilesh1|Ranga1|Selenium1|
|Akhilesh12|Ranga14|Selenium4441|
|Akhilesh31|Ranga17|Selenium133|
|Akhilesh51|Ranga15|Selenium12|
|Akhilesh21|Ranga13|Selenium11|
|Akhilesh11|Ranga13|Selenium16|
|Akhilesh51|Ranga144|Selenium17|
|Akhilesh14|Ranga122|Selenium15|
