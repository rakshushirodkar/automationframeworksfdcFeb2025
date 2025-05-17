Feature: Login feature


Scenario: Verify valid error message
Given User is on sfdc login page
When User enters invalid username and password
Then User should see error message

Scenario: Verify valid login
Given User is on sfdc login page
When User enters valid username and password
Then User should see home page

 Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |


Scenario: Verify valid login with rememberME
Given User is on sfdc login page "http://login.salesforce.com"
When User enters valid username "rakshushirodkar854@agentforce.com" and password "Rhia@213127"
Then User should see home page

 @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step






