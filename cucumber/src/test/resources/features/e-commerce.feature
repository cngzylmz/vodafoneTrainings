Feature: E-commerce

  Background:
    Given I initialize chrome driver
    When I go to "http://www.hepsiburada.com" url
    Then I see banner page

  @cngz
  Scenario: 1 - Change Location
    When I click element: select location button
    Then I click element: location list
    Then I click element: location search
    Then I click element: istanbul
    And I see location selected alert element

  @cngz
  Scenario: 2 - Search Product Add Basket And Delete
    When I enter "tuvalet kağıdı" text to search input box text area
    Then I click element: search button
    And I see search results page

    And I wait for 3 seconds

    When I click element: order product
    Then I wait for 1 seconds
    Then I click element: order best seller

    And I click element: toilet paper brand

    When I focus first product element and click add to basket element

    When I see banner page
    Then I wait basket item count element 2 seconds
    And I check expected basket count: 1

    When I click element: basket button
    When I see basket page
    Then I wait for 3 seconds
    Then I check expected product quantity: 1

    When I click element: finish shopping
    Then I see login page
    And I wait continue without login element 3 seconds

    When I click element: continue without login
    Then I wait for 2 seconds
    When I wait email address without login element 3 seconds




