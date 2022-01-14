
/*

--------------------------------------------------------------------------------------
This principle is just an extension of the Open Close Principle
it means that we must make sure that new derived classes are extending the base classes without changing their behavior.
--------------------------------------------------------------------------------------
Derived types must be completely substitutable for their base types.
--------------------------------------------------------------------------------------
if a program module is using a Base class, 
then the reference to the Base class can be replaced with a Derived class without affecting the functionality of the program module.
--------------------------------------------------------------------------------------

 */



/**
* The base Transaction class that defines a buy and sell feature.
*/
class Transaction{
    
    public void buy(String stock, int quantity, float price){
        // implement buy logic here
    };
    public void sell(String stock, int quantity, float price){
        // implement sell logic here
    }; 
}
/**
* A subclass implementation of the Transaction class that 
* defines Stock-specific buy and sell action logic.
*/
class StockTransaction extends Transaction{
    
    @Override
    public void buy(String stock, int quantity, float price){
        // implement Stock-specific buy logic here
    }
    @Override
    public void sell(String stock, int quantity, float price){
        // implement Stock-specific sell logic here
    }
}


// ============================================================================================================================================= //

//** references */
// https://www.alpharithms.com/liskov-substitution-principle-lsp-solid-114908/
// https://www.oodesign.com/liskov-s-substitution-principle.html