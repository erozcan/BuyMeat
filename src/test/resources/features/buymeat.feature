Feature: Buy meat on migros webpage

  @smoke
  Scenario: user should buy meat
    Given user is on migros homepage
    When user select red meat
    Then red meat page should be open
    When user search for meat
    And click search button
    Then dana yemeklik kusbasi meat should be listed
    When user select product
    When user click add basket button
    And user select bring my adress
    And user select city
    And user select district
    And user select neighborhood
    When user writes note
    And click add basket buton
    And compare current price with max amount
    Then user should see the product in basket

