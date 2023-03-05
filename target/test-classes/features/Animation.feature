Feature: Verify the features of Animation

  @test1
  Scenario: Verify the feature of Default Layout Animation
    Given User click on Animation Tab
    When User click on Default Layout Animation
    And Click on add button
    Then User can see a button

  @test2
  Scenario: Verify the feature of Hide and Show Animation
    Given User click on Animation Tab
    When User click on Hide and Show Animation
    And Click on Hide and Click on button
    Then Click on Show button

  @test3
  Scenario: Verify the feature of Cloning
    Given User click on Animation Tab
    When User click on Cloning
    Then Click on Run button
