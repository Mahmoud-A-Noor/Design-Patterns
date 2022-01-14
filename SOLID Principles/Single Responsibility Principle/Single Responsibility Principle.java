
/*

--------------------------------------------------------------------------------------
Do one Thing and do it well
--------------------------------------------------------------------------------------
"there should never be more than one reason for a class to change" (Uncle Bob)
--------------------------------------------------------------------------------------
Benefits of Single Responsibility Principle
    1- When an application has multiple classes, each of them following this principle, then the application becomes more maintainable, easier to understand.
    2- The code quality of the application is better, thereby having fewer defects.
    3 -Onboarding new members are easy, and they can start contributing much faster.
    4- Testing and writing test cases is much simpler
--------------------------------------------------------------------------------------
"The Single Responsibility Principle represents a good way of identifying classes during the design phase of an application
 and it reminds you to think of all the ways a class can evolve. 
 A good separation of responsibilities is done only when the full picture of how the application should work is well understand" (oodesign.com)
--------------------------------------------------------------------------------------
Note => violation of SRP can happend either in class level or in method level.
        class level >>> if a class has several unrelated methods (don't serve the same purpose)
        method level >>> if a function is used several times in a Project then it should have its own class to avoid code redundancy (increase reusability).
--------------------------------------------------------------------------------------
Note => a class can contain more than one function, but they should serve the same responsibility 
                (Eg. a class can contain 2 functions to add and remove from cart)) 
--------------------------------------------------------------------------------------
Note => every developer has their vision of the class purpose whick make things tricky
--------------------------------------------------------------------------------------

 */



//** Bad Example */

// Class to handle both Buy and Sell actions
class Transaction {
    // Method to Buy, implemented in Transaction class
    private void Buy(String stock, int quantity, float price){
        // Buy stock functinality implemented here
    }
    // Method to Sell, implemented in Transaction class
    private void Sell(String stock, int quantity, float price){
        // Sell stock functionality implemented here
    }
}


//** Good Example */


class Transaction{
    // Method to Buy, implemented in Buy class
    private void Buy(String stock, int quantity, float price){
        Buy.execute(stock, quantity, price);
    }
    // Method to Sell, implemented in Sell class
    private void Sell(String stock, int quantity, float price){
        Sell.execute(stock, quantity, price);
    }
}
class Buy{
    // Static method, accessible to other classes, to execute Buy action
    static void execute(String ticker, int quantity, float price){
        // Execute buy action here
    }
}
class Sell{
    // Static method, accessible to other classes, to execute Sell action
    static void execute(String ticker, int quantity, float price){
        // Execute sell action here
    }
}


// ============================================================================================================================================= //

//** references */
// https://www.alpharithms.com/solid-single-responsibility-principle-srp-284015/
// https://www.geeksforgeeks.org/single-responsibility-principle-in-java-with-examples/
// https://www.oodesign.com/single-responsibility-principle.html