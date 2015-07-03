Feature: Login

  Scenario: Login successfully
    Given I access the login page
    And I insert valid credentials
    When I click login button
    Then I check if user was logged in


  Scenario: Login with wrong credentials
    Given I access the login page
    And I insert invalid credentials
    When I click login button
    Then I expect invalid credential message



  Scenario: Login with no password
    Given I access the login page
    When I enter "eu@fast.com"/"" credentials
    And I click login button
    Then I expect "Please enter your password!"error message
   #Then I expect invalid credential message

  #Please enter your email!
