@orangeHrmFeatures
  Feature: Orange HRM Features

    Background: Login to HRM Portal
      Given user has opened HRM login page
      When user enter the username and password
      And clicks on login button
      Then user is navigated to the HRM dashboard page

    @createJobVacancy
    Scenario: Create Job Vacancy for DevOps Engineer
      Given user is on HRM dashboard page
      When user hovers on Recruitment and clicks on vacancies option
      Then user is navigated to Vacancies page
      When user clicks on Add
      Then Add Job Vacancy form is displayed
      When user select Job Title from the dropdown
      And Adds vacancy name
      And provides name of the Hiring manager from the options
      And clicks on Save
      Then successfully saved message is displayed

    @addACandidate
    Scenario: Adding a candidate for recruitment
      Given user is on HRM dashboard page
      When user hovers on Recruitment option and clicks on candidates
      Then user is navigated to the candidates page
      When user clicks of Add
      Then user is navigated to the Add candidate form page
      When user enters First Name
      And user enters Last name
      And user enter Email Id
      And user uploads Resume
      And click Save

    @addMultipleEmployees
    Scenario Outline: Add multiple employees
      Given user is on HRM dashboard page
      When user clicks PIM on menu bar and selects Add Employee
      Then user is navigated to Add Employee page
      When user provides "<First Name>" and "<Last Name>" and "<Employee Id>"
      And enable Create Login Details checkbox
      Then verify the employee details are created
      Examples:
        | First Name | Last Name | Employee Id |
        |Vir22         |Savarkar2   |4444          |
        |MK22        |Gandhi2     |1000          |
        |Tony22        |Stark2      |9999          |

    @multipleVacancies
    Scenario Outline: Creating multiple Vacancies
      Given user is on HRM dashboard page
      When user hovers on Recruitment and clicks on vacancies option
      Then user is navigated to Vacancies page
      When user clicks on Add
      Then Add Job Vacancy form is displayed
      When user select Job Title from the dropdown
      And Adds "<vacancy name>"
      And provides name of the Hiring manager from the options
      And clicks on Save
      Then successfully saved message is displayed
      Examples:
        | vacancy name |
        |Devops10       |
        |Devope20       |


