@screen
Feature: As logged in user I can change my password

  Scenario: Change password successfully
    Given I successfully login
    When I click on Preferences button
    And I input Current Password
    And I input New Password
    And I confirm the New Password
    And I click on Save button
    Then I should see "Your password has been successfully changed." message.
    And I close the Preferences window.
    Then I can re-login with new credentials







