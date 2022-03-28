Feature: Consuming a web service

  @ws
  Scenario: Getting the posts
    Given The user consumes the web services to get the post with id "1"
    Then the user validate that the response contains the correct title of the post