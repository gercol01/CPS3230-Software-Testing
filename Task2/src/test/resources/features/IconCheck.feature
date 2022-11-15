Feature: Icon Check

  In order to help me with my alert system
  As a valid user of the website
  I want to be able to see the alerts and the details

  Scenario Outline: (Icon Check) Simple add alert and check icon file name
    Given I am an administrator of the website and I upload an alert of type <alert-type>
    Given I am a user of marketalertum <username>
    When I view a list of alerts
    Then I should see one alert
    And the icon displayed should be <icon_file_name>

    Examples:
      |alert-type|username                               |icon_file_name  |
      |1         |"1243555e-9957-4ff9-b13f-d3eec3f864ea" |"icon-car.png"  |

#  Scenario : Adding three alerts and viewingthem
#    Given I am a user of marketalertum
#    I login using valid credentials 1243555e-9957-4ff9-b13f-d3eec3f864ea
#    Then I should see url https://www.marketalertum.com/Alerts/List