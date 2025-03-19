Feature:    Purchase a product from saucedemo

Background: Buyer landed to website saucedemo
Given       Buyer landing to saucedemo

Scenario Outline: Create Order Saucedemo
    Given   Buyer login to the saucedemo username <username> and password <password>
    When    Buyer add a saucedemo product <productname> and <productname2> to the cart
    And     Buyer checkout saucedemo product <productname> and <productname2>
    And     Buyer insert <Firstname> <Lastname> <PostalCode> for shipping
    And     Buyer will see checkout overview <productname>
    Then    Buyer will see message confirmation page Thank you for your order!

    Examples:
    |username       |password        |productname           |productname2           |Firstname    |Lastname    | PostalCode    |
    |standard_user  |secret_sauce    |Sauce Labs Backpack   |Sauce Labs Bike Light  |Jhon         |Wick         | 12345        |