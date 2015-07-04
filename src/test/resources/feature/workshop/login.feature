@screen
Feature: Login

  Scenario: Login successfully
    Given I access the login page
    And I insert valid credentials
    When I click login button
    Then I check if user was logged in


  Scenario: Login with wrong credentials
    Given I access the login page
    And I insert invalid button
    Then I expect invalid credential message


  Scenario: Login with no password
    Given I access the login page
    When I enter "eu@fast.com"/"" credentials
    And I click login button
    Then I expect "Please enter your password!"error message
   #Then I expect invalid credential message
  #Please enter your email!



  Scenario Outline: Failed login
    Given I access the login page
    When I enter "<email>"/"<pass>" credentials
    And I click login button
    Then I expect "<message>"error message

    Examples:
      | email         | pass     | message                     |
      |               |          | Please enter your email!    |
      | aaa@fast.com  |          | Please enter your password! |
      |               | onlypass | Please enter your email!    |
      | sasa@fast.com | somepass | Invalid user or password!   |


  Scenario: Logout success
    Given I successfully login
  #Then I check if user was logged in
  #When I click on some elements









