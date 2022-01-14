
/*

-----------------------------------------------------------------------------------------------------------------------
software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification
which means you should be able to extend a class behavior, without modifying it.
-----------------------------------------------------------------------------------------------------------------------
any new functionality should be done by adding new classs instead of changing existing ones keeping as much as possible existing code unchanged.
-----------------------------------------------------------------------------------------------------------------------
Benefits of Open-Closed Principle
    1- separates the existing code from the modified code
    2- provides better stability, maintainability and minimizes changes as in your code.
    3- testing becomes much more easy
-----------------------------------------------------------------------------------------------------------------------
the open/closed principle is generally achieved by using inheritance and polymorphism (abstraction).
-----------------------------------------------------------------------------------------------------------------------
Note => it introduce new level of abstraction increasing the complexity of the code. So this principle should be applied in those area which are most likely to be changed
-----------------------------------------------------------------------------------------------------------------------

 */



//** Bad Example */

class Transaction {
    
    private void buy(String ticker, int quantity, float price){
        Buy.execute(ticker, quantity, price);
    }
    private void sell(String ticker, int quantity, float price){
        Sell.execute(ticker, quantity, price);
    }
}
class Buy{
    // Create a record of the Buy transaction
    public static String makeRecord(String ticker, int quantity, float price, String date){
        // Create a string containing relevant Buy metadata
        return MessageFormat.format("{0}-{1}-{2}-{3}",
                ticker, String.valueOf(quantity),String.valueOf(price),date);
    }
    // Class-specific Buy logic
    static void execute(String stock, int quantity, float price){
        // Execute buy action here
    }
}
class Sell{
    // Create a record of the Buy transaction
    public static String makeRecord(String ticker, int quantity, float price, String date){
        // Create a string containing relevant Buy metadata
        return MessageFormat.format("{0}-{1}-{2}-{3}",
                ticker, String.valueOf(quantity),String.valueOf(price),date);
    }
    // Class-specific Sell logic
    static void execute(String stock, int quantity, float price){
        // Execute buy action here
    }
}


//** Good Example */


class RecordableTransaction {
    // Create a record, in a format used by all inherited classes
    public static String makeRecord(String ticker, int quantity, float price, String date){
        // Create a string containing relevant Buy metadata
        return MessageFormat.format("{0}-{1}-{2}-{3}",
                ticker, String.valueOf(quantity),String.valueOf(price),date);
    }
}
class Transaction {
    
    // Still uses Buy class to execute buy transactions
    private void buy(String ticker, int quantity, float price){
        Buy.execute(ticker, quantity, price);
    }
    // Still uses the Sell class to execute sell transactions
    private void sell(String ticker, int quantity, float price){
        Sell.execute(ticker, quantity, price);
    }
}
class Buy extends RecordableTransaction{
    // Class-specific Buy logic still implemented here
    static void execute(String stock, int quantity, float price){
        // Execute buy action here
    }
}
class Sell extends RecordableTransaction{
    // Class-specific Sell logic still implemented here
    static void execute(String stock, int quantity, float price){
        // Execute sell action here
    }
}

// Note => if makeRecord() function is changed in any of the children classes,
//         then we will make RecordableTransaction class as abstract class and makeRecord() as abstract function
//         then we will have to implement makeRecord() function in all the children classes.

// ============================================================================================================================================= //

//** references */
// https://www.alpharithms.com/open-closed-principle-ocp-solid-263212/
// https://www.geeksforgeeks.org/open-closed-principle-in-java-with-examples/
// https://www.oodesign.com/open-close-principle.html