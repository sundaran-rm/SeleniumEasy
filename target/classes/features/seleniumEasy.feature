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

