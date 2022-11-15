Feature: Alert Layout

  In order to help me with my alert system
  As a valid user of the website
  I want to be able to see the alerts and the details

  Scenario Outline: (Alert Layout) Simple adding alerts and viewing them
    Given I am an administrator of the website and I upload 3 alerts
    Given I am a user of marketalertum <username>
    When I view a list of alerts
    Then each alert should contain an icon <iconFlag>
    And each alert should contain a heading <headingFlag>
    And each alert should contain a description <descriptionFlag>
    And each alert should contain an image <imageFlag>
    And each alert should contain a price <priceFlag>
    And each alert should contain a link to the original product website <linkFlag>

    Examples:
      |username                               |iconFlag |headingFlag|descriptionFlag|imageFlag|priceFlag|linkFlag|
      |"1243555e-9957-4ff9-b13f-d3eec3f864ea" |true     |true       |true           |true     |true     |true    |

#  Scenario : Adding three alerts and viewingthem
#    Given I am a user of marketalertum
#    I login using valid credentials 1243555e-9957-4ff9-b13f-d3eec3f864ea
#    Then I should see url https://www.marketalertum.com/Alerts/List