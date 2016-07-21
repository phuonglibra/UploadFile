@tag
Feature: Upload document

  Scenario: Upload file in English
    Given the page "https://blueimp.github.io/jQuery-File-Upload/angularjs.html" is visited
    When "name=files[]" element is clicked
    And "F:\\demo.jpg" file is uploaded
    And wait for any "demo" text to be present
    Then assert that the "demo" text is present
    When close current window
