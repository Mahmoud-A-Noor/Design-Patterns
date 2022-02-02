
/*

--------------------------------------------------------------------------------------
The adapter pattern is adapting between classes and objects. 
Like any adapter in the real world it is used to be an interface, a bridge between two objects.
--------------------------------------------------------------------------------------
Convert the interface of a class into another interface clients expect.
--------------------------------------------------------------------------------------
Adapter lets classes work together, that could not otherwise because of incompatible interfaces.
(Ex. when you have some class expecting some type of object and you have an object offering the same features, but exposing a different interface)
--------------------------------------------------------------------------------------
works as a bridge between two incompatible interfaces.
--------------------------------------------------------------------------------------
The client sees only the target interface and not the adapter. 
The adapter implements the target interface. Adapter delegates all requests to Adaptee.
--------------------------------------------------------------------------------------
when to use:
    1- When an object needs to utilize an existing class with an incompatible interface.
    2- When you want to create a reusable class that cooperates with classes which don't have compatible interfaces.
--------------------------------------------------------------------------------------
Benefits of using Adapter    
    1- It allows two or more previously incompatible objects to interact.
    2- It allows reusability of existing functionality.
--------------------------------------------------------------------------------------
 
*/


//** Adapter Implementation */

interface Bird
{
    // birds implement Bird interface that allows
    // them to fly and make sounds adaptee interface
    public void fly();
    public void makeSound();
}
  
class Sparrow implements Bird
{
    // a concrete implementation of bird
    public void fly()
    {
        System.out.println("Flying");
    }
    public void makeSound()
    {
        System.out.println("Chirp Chirp");
    }
}
  
interface ToyDuck
{
    // target interface
    // toyducks dont fly they just make
    // squeaking sound
    public void squeak();
}
  
class PlasticToyDuck implements ToyDuck
{
    public void squeak()
    {
        System.out.println("Squeak");
    }
}
  
class BirdAdapter implements ToyDuck
{
    // You need to implement the interface your
    // client expects to use.
    Bird bird;
    public BirdAdapter(Bird bird)
    {
        // we need reference to the object we
        // are adapting
        this.bird = bird;
    }
  
    public void squeak()
    {
        // translate the methods appropriately
        bird.makeSound();
    }
}

//** Usage */

class Main
{
    public static void main(String args[])
    {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();
  
        // Wrap a bird in a birdAdapter so that it 
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);
  
        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();
  
        System.out.println("ToyDuck...");
        toyDuck.squeak();
  
        // toy duck behaving like a bird 
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}


// ============================================================================================================================================= //

//** references */
// https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
// https://www.oodesign.com/adapter-pattern.html
// https://www.geeksforgeeks.org/adapter-pattern/
// https://www.javatpoint.com/adapter-pattern