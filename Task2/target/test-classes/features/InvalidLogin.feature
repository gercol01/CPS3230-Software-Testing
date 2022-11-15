Feature:  Invalid Login

  In order to help me with my login system
  As am invalid user of the website
  I want to be able to login and access the alert page

  Scenario Outline: (Invalid Login) Simple login using invalid credentials
    Given I am a user of marketalertum
    When I login using invalid credentials <username>
    Then I should see the login screen again <currentUrl>

    Examples:
      |username     |currentUrl |
      |"abc"        |"https://www.marketalertum.com/Alerts/Login"          |


#  Scenario : Simple addition
#    Given I am a user of marketalertum
#    I login using valid credentials abc
#    Then I should see url https://www.marketalertum.com/Alerts/Login