@automation_practice
Feature: Account page

  Background: :
    Given the user has already logged in to the application
      |username|password|
      |cposadaa@gmail.com|12345|

  @web
  Scenario: Accounts page title
    Given the user is on the Accounts page
    When the user gets the title of the page
    Then page title should be "My Account - My Store"