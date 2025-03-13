Feature: Creating a To-Do List

  @test
  Scenario: Create a To-Do List and save it with different background color
    Given user clicks on floating widget of Notes app
    And user clicks on plus icon
    When taps on create a to-do list from menu options shown
    And create a to-do list with title
    And add list of items
    And click on color change icon
    And change color to green
    And click on save button
    Then verify the saved To-Do List shown on My Notes page