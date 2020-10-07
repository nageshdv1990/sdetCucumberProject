@alchemyJobs
  Feature: Alchemy Jobs Features

    @createUserFromAdminLogin
    Scenario: Alchemy Jobs Create New User
      Given user launches Alchemy Admin Login page
      When user provides username and password
      And clicks on login
      Then user will be navigated to Dashboard page
      When user hovers on the new button
      And selects User option
      Then user is navigated to Add New User page
      When user enter Username and email
      And clicks on Add New User
      Then user is navigated to Users List View page
      And new user created confirmation message is displayed
      And close the browser


    @searchingForJobsUsingXpath
    Scenario: Searching for jobs and applying to them
      Given user launches Alchemy Jobs Site
      When user clicks on Jobs
      Then user is navigated to the Jobs Search Page
      When user enters data into the search criteria
      And selects only full time
      And clicks on Search Jobs page
      Then Verify the number of matching records
      When user select the first matching record
      Then user is navigated to the Job Details page
      When user clicks on Apply for job
      Then confirmation message is displayed

    @postingJobUsingParameterization
    Scenario: Post a job using details from feature file
     // Given user launches Alchemy Jobs Site
      When user clicks on Post a Job
      Then user is navigated to Post a Job page
      When user enters Title "Test Specialist"
      And Email "vi44@gmail.com"
      And Company "IBM"
      And Description "Testing ninja"
      And user clicks on Preview
      Then user is navigated to review page
      When user clicks on Submit Listing button
      Then Job is posted successfully


    @postingJobUsingExampleTable
    Scenario Outline: Post a job using details from Example Table
    // Given user launches Alchemy Jobs Site
      When user clicks on Post a Job
      Then user is navigated to Post a Job page
      When user enters Title "<Title>"
      And Email "<Email>"
      And Company "<Company>"
      And Description "<Description>"
      And user clicks on Preview
      Then user is navigated to review page
      When user clicks on Submit Listing button
      Then Job is posted successfully
      Examples:
        | Title | Email | Company | Description |
        |QA     |vir564@gmail.com|IBM|Test Ninja |
        |Test Specialist|vir574@gmail.com|IBM|Test Ninja|