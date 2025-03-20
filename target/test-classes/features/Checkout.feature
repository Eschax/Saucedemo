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
    |username       |password        |productname           |productname2               |Firstname    |Lastname    | PostalCode   |
    |standard_user  |secret_sauce    |Sauce Labs Backpack   |Sauce Labs Bike Light      |Jhon         |Wick        | 12345        |
    |standard_user  |secret_sauce    |Sauce Labs Onesie     |Sauce Labs Bolt T-Shirt    |Ujang        |pengkor     | 69696        |

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

    # Scenario Outline: add to cart and change product
    # Given   Buyer login to the saucedemo username <username> and password <password>

    # Scenario Outline: login and logout for change user 
    # Given   Buyer login to the saucedemo username <username> and password <password>