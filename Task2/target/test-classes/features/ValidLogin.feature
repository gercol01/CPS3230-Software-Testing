Feature: Valid Login

  In order to help me with my login system
  As a valid user of the website
  I want to be able to login and access the alert page

  Scenario Outline: (Valid Login) Simple login using valid credentials
    Given I am a user of marketalertum
    When I login using valid credentials <username>
    Then I should see my alerts <currentUrl>

    Examples:
    |username                                     |currentUrl |
    |"1243555e-9957-4ff9-b13f-d3eec3f864ea"       |"https://www.marketalertum.com/Alerts/List"          |


#  Scenario : Simple addition
#    Given I am a user of marketalertum
#    I login using valid credentials 1243555e-9957-4ff9-b13f-d3eec3f864ea
#    Then I should see url https://www.marketalertum.com/Alerts/List