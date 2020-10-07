@suiteCrm
Feature: suite CRM features

  Background: Open Alchemy CRM application and login
    Given user is Alchemy CRM site
    When user enters the "admin" and "pa$$w0rd"
    Then user is navigated to the Homepage

  @countingDashlets
  Scenario: Counting Dashlets
    Given user is on Homepage
    When user counts the dashlets
    Then Print the number and title of each dashlet
    And Close the Browser

  @createLeadsWithParameterization
  Scenario Outline: Create Leads With Paramterization
    Given user is on Homepage
    When user navigates to Create Lead page
    And Fill in the "<leadName>"
    And click on save lead button
    Then navigate to View leads page
    And Validate the results
    And Close the Browser
    Examples:
      | leadName |
      |Mk Gandhi |
      |Vir Savarkar|
      |Bhagat Singh|

  @scheduleAMeetingAndInviteMembers
   Scenario Outline: Schedule a meeting and invite members
     Given user is on Homepage
     When user navigates to Schedule a meeting page
     And Enter the details of the meeting "<Meeting title>"
     And Search for members and add them to the meeting "<Invitee 1>", "<Invitee 2>", "<Invitee 3>"
     And click Save Meeting button
     Then user navigates to view meeting page
     And confirms if meeting is created
     And Close the Browser
    Examples:
      | Meeting title | Invitee 1 | Invitee 2 | Invitee 3 |
      |testmeet       |fname.lname14@test.com | fname.lname16@test.com	    |cucumbertest@test.com	     |




  @creatingAProduct
    Scenario Outline: Add products using examples
      Given user is on Homepage
      When user navigates to the Create Product page
      And Enter the details of the product "<productName>", "<productPrice>"
      And click Save products
      Then navigate to View Products page
      And validate the products created
      And Close the Browser
    Examples:
      | productName | productPrice |
      |Sample Product 400|500      |





