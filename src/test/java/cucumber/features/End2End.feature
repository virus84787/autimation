Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

#  Scenario: Search on Google and compare
#    Given user is on Google Page
#    When he search for "trololo"
#    And comparing search text with title
#    And comparing search text with url
#    And comparing search text with search results
#    And comparing search text with search result source

  Scenario: Search on Google and compare with title
    Given user is on Google Page
    When he search for "trololo"
    And comparing search text with title

  Scenario: Search on Google and compare with url
    Given user is on Google Page
    When he search for "trololo"
    And comparing search text with url


  Scenario: Search on Google and compare with search results
    Given user is on Google Page
    When he search for "trololo"
    And comparing search text with search results

  Scenario: Search on Google and compare result source
    Given user is on Google Page
    When he search for "trololo"
    And comparing search text with search result source
