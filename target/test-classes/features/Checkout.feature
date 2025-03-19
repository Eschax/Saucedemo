Feature:    Purchase a product from saucedemo

Background: Buyer landed to website saucedemo
Given       Buyer landing to saucedemo

Scenario Outline: Checkout two products Saucedemo
    Given   Buyer login to the saucedemo username <username> and password <password>
    When    Buyer add a saucedemo product <productname> and <productname2> to the cart
    And     Buyer checkout saucedemo product <productname> and <productname2>
    And     Buyer insert <Firstname> <Lastname> <PostalCode> for shipping
    And     Buyer will see checkout overview <productname>
    Then    Buyer will see message confirmation page Thank you for your order!

    Examples:
    |username       |password        |productname           |productname2           |Firstname    |Lastname    | PostalCode    |
    |standard_user  |secret_sauce    |Sauce Labs Backpack   |Sauce Labs Bike Light  |Jhon         |Wick         | 12345        |

    Scenario Outline: Checkout one product Saucedemo
    Given   Buyer login to the saucedemo username <username> and password <password>
    When    Buyer add a product <productname> to the cart
    And     Buyer checkout product <productname>
    And     Buyer insert <Firstname> <Lastname> <PostalCode> for shipping
    And     Buyer will see checkout overview <productname>
    Then    Buyer will see message confirmation page Thank you for your order!

    Examples:
    |username       |password        |productname                |Firstname    |Lastname     | PostalCode    |
    |standard_user  |secret_sauce    |Sauce Labs Fleece Jacket   |Jhon         |Wick         | 12345         |