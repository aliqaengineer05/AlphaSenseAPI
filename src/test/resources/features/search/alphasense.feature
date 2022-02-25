Feature: Search AlphaSense Keyword and Response code
  @regression

  Scenario: User validate API response code
    Given I send a request to endpoint
    Then  The api should return status 200
    Then  I display the response
