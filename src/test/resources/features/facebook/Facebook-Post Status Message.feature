#Author: kumar.beee2007@gmail.com
@ui @Facebook @FacebookPostStatus @Assignment1 @All
Feature: FaceBook - Post Status

  Scenario Outline: FaceBook - Post Status
    Given Login to Facebook as "<User>"
    Then Post a status message "<StatusMessage>"

    Examples: 
      | User     | StatusMessage |
      | TestUser | Hello World   |
