Feature: Selenium Easy Beginner
  Scenario: Simple Form Demo
    Given Browser is open
    And SE webpage is launched
    When User clicks Simple Form Demo
    And User lands on the simple form demo page
    And User enters message text
    And User clicks Show Message button
    Then Message should be displayed
    And Browser should close

    Scenario: Adding value in two fields
      Given Browser is open
      And SE webpage is launched
      When User clicks Simple Form Demo
      And User lands on the simple form demo page
      And User enters a and b values
      And User clicks on Get Total Button
      Then Total should be displayed
      And Browser should close

  Scenario: Radio Buttons
    Given Browser is open
    And SE webpage is launched
    When User clicks Radio Buttons Demo
    And User lands on the Radio Buttons Demo page
    And User clicks Male radio button
    And User clicks Female radio button with age group '5 to 15'
    Then Radio Buttons should be selected
    And Browser should close