#Author: kumar.beee2007@gmail.com
@ui @Wallethub @WallethubPostReview @Assignment2 @All
Feature: Wallethub - Post Review

  Scenario: Wallethub - Post Review
  
    Given User launch WalletHub Test Insurance Company site
    When User click on Write a review
    When User click on the Fifth star
    And User write below review comments
      """
      You can check the profile page of each professional or company to 
      determine whether they are a paying advertiser (indicated by the word sponsored). Regardless of advertiser status, none of the listings, reviews, 
      or other information on Wallet Hub constitutes, in any way, a referral or endorsement by us of the respective financial company or professional, or vice versa.
      """
    And User press submit   
    When User go to profile from test company page
    Then User can see that the review feed got updated
    And User can see that the review starred as Five
 #Then a confirmation screen with message "You have reviewed the institution" should be displayed