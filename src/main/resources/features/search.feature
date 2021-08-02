Feature: Amazon Search Functionality
  Scenario: Search Amazon Webpage
    Given Browser is open
    And Webpage is launched
    When User enters the search string
    And User enters Submit button
    Then User should land in the search results page
    And Browser should close