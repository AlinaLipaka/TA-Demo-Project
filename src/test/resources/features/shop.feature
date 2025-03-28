Feature: demo.prestashop.com

  Background:
    Given I open Shop page

  Scenario: Create an order in demo.prestashop.com
    When I click "Create account" button
      And I fill in the Registration form
      And I save the Registration form
    Then I am logged in
      And I navigate to "Home accessories" section
      And I can see items in Shop
      And I filter items by price from 18 to 23
      And All item prices are in range from 18.0 to 23.0
    When I open quick view for filtered item 1 of the list
      And I increase item quantity for 1
      And I click "Add to cart" button in quick view
    Then Success modal is displayed
      And I can see correct total items price in success modal
    When I close success modal window
      And I can see items in Shop
      And I open quick view for filtered item 3 of the list
      And I click "Add to cart" button in quick view
    Then Success modal is displayed
      And I can see correct total items price in success modal
      And I close success modal window
    When I navigate to cart
    Then I can see correct total items price on Cart page
      And I click "Proceed to checkout" button in Cart
      And I can see shipping address form
      And I fill in the Shipping address form
      And I click "Continue" button in Cart
      And I am on shipping method step
      And I confirm shipping method
    When I am on the Payment method step
      And I choose "Pay by Check" payment option
    Then I see the correct total price on Payment step
      And I agree to the terms of service on Cart page
    When I click "Place order" button in Cart
    Then I am on Order confirmed page
      And I can see correct confirmed order details
    When I click "Sign out" button
    Then I am not signed in
