
/*

--------------------------------------------------------------------------------------
is a design pattern that restricts the instantiation of a class to one object. 
--------------------------------------------------------------------------------------
Benefits of using Singleton    
    1- Ensure that only one instance of a class is created.
    2- Provide a global point of access to the object.
--------------------------------------------------------------------------------------
when to use Singleton
    1- Logger Classes (as it is not necessary to create an object each time a logging operations is performed)
    2- Configuration Classes (avoids the reloading the values each time the configuration parameters are used)
    3- Accesing resources in shared mode (used in the design of an application working in an multi-threading environment that needs to work with the serial port)
    4- Factories(pattern) implemented as Singletons (If the factory is instantiated twice in 2 different threads then is possible to have 2 overlapping ids for 2 different objects)
--------------------------------------------------------------------------------------
Hot Spot:
    1- Multithreading => A special care should be taken when singleton has to be used in a multithreading application.
    2- Serialization => When Singletons are implementing Serializable interface they have to implement readResolve method in order to avoid having 2 different objects.
    3- Classloaders => If the Singleton class is loaded by 2 different class loaders we'll have 2 different classes, one for each class loader.
    4- Global Access Point represented by the class name => The singleton instance is obtained using the class name. At the first view this is an easy way to access it, 
       but it is not very flexible. If we need to replace the Sigleton class, all the references in the code should be changed accordinglly
--------------------------------------------------------------------------------------
 
*/


//** Singleton Class */

class Singleton {
	private static Singleton instance;

	private Singleton() {
		// private constructor
	}
	
    // using synchronized makes sure that only one thread at a time can execute getInstance()
	public static synchronized Singleton getInstance(){

		if (instance == null)
			instance = new Singleton();

		return instance;
	}
		
	public void doSomething()
	{
		// do something code
	}
}

//** Usage */

public class SingletonPatternDemo {
    public static void main(String[] args) {
 
       //Get instance of our class
       Singleton object = Singleton.getInstance();
 
       //do something
       object.doSomething();
    }
 }


// ============================================================================================================================================= //

//** references */
// https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
// https://www.oodesign.com/singleton-pattern.html
// https://www.geeksforgeeks.org/singleton-design-pattern/