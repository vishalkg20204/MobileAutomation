Feature: Onboarding flow

  @test
  Scenario: Verify the Get Started button
    Given the app is launched
    Then the Get Started button should be visible
    And the Get Started button should have the correct text
    When the user taps on Get Started Button
    And selects Notes Launcher from settings
    And Notes floating widgets should appear with right swipe instructions
    And click on floating widget
    Then the minus one screen should be displayed
