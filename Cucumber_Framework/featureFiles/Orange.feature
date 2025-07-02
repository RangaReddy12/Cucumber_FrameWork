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