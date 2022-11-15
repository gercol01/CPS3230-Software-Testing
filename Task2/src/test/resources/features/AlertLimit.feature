Feature: Alert Limit

  In order to help me with my alert system
  As a valid user of the website
  I want to upload more than 5 alerts

  Scenario Outline: (Alert Limit) Simple adding more than 5 alerts
    Given I am an administrator of the website and I upload more than 5 alerts
    Given I am a user of marketalertum <username>
    When I view a list of alerts
    Then I should see five alerts <counter>

    Examples:
      |username                               |counter|
      |"1243555e-9957-4ff9-b13f-d3eec3f864ea" |5      |

#  Scenario : Adding three alerts and viewingthem
#    Given I am a user of marketalertum
#    I login using valid credentials 1243555e-9957-4ff9-b13f-d3eec3f864ea
#    Then I should see url https://www.marketalertum.com/Alerts/List