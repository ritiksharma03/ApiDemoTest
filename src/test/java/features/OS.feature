Feature: Verify the features of OS 
 
@test6
  Scenario Outline: Verify functionality of SMS Messaging
    Given User Clicks on OS Tab
    When User Click on SMS messaging
    And Fill the "<Recipient>" and "<Message>" details 
    Then User Clicks on Send button

    Examples: 
      | Recipient  | Message | 
      | 1234567890 | Hello   | 
      
