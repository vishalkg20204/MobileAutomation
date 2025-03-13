Feature: Creating a text note

  @test
  Scenario: Create a text note and save it
    Given user is on launcher page
    And user clicks on plus icon
    And tap on create a text note from menu options shown
    And create a note with title and paragraph
    And click on save button
    Then verify the saved notes is shown on My Notes page
