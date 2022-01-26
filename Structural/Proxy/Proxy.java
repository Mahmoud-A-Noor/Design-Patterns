
/*

--------------------------------------------------------------------------------------
In proxy pattern, a class represents functionality of another class.
--------------------------------------------------------------------------------------
used in Java API: java.rmi.*.
--------------------------------------------------------------------------------------
Proxy pattern is used when we need to create a wrapper to cover the main object’s complexity from the client.
--------------------------------------------------------------------------------------
There are few differences between the related patterns. Like Adapter pattern gives a different interface to its subject, 
while Proxy patterns provides the same interface from the original object but the decorator provides an enhanced interface. 
Decorator pattern adds additional behaviour at runtime.
--------------------------------------------------------------------------------------
Types of proxies
    1- Virtual Proxies => delaying the creation and initialization of expensive objects until needed, where the objects are created on demand.
    2- Remote Proxies => providing a local representation for an object that is in a different address space (Java RMI stub objects).
    3- Protection Proxies => where a proxy controls access to RealSubject methods, by giving access to some objects while denying access to others.
    4- Smart References => providing a sophisticated access to certain objects such as tracking the number of references to an object and denying access if a certain number is reached, 
       as well as loading an object from database into memory on demand.
--------------------------------------------------------------------------------------
Benefits of using Singleton    
    1- Security.
    2- avoids duplication of objects which might be huge size and memory intensive.
    3- The remote proxy also ensures about security by installing the local code proxy (stub) in the client machine and then accessing the server with help of the remote code.
--------------------------------------------------------------------------------------
 
*/


//** Proxy Implementation */

public interface Image {
    void display();
 }

 public class RealImage implements Image {

    private String fileName;
 
    public RealImage(String fileName){
       this.fileName = fileName;
       loadFromDisk(fileName);
    }
 
    @Override
    public void display() {
       System.out.println("Displaying " + fileName);
    }
 
    private void loadFromDisk(String fileName){
       System.out.println("Loading " + fileName);
    }
 }

 public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;
 
    public ProxyImage(String fileName){
       this.fileName = fileName;
    }
 
    @Override
    public void display() {
       if(realImage == null){
          realImage = new RealImage(fileName);
       }
       realImage.display();
    }
 }

//** Usage */

public class ProxyPatternDemo {
	
    public static void main(String[] args) {
       Image image = new ProxyImage("test_10mb.jpg");
 
       //image will be loaded from disk
       image.display(); 
       System.out.println("");
       
       //image will not be loaded from disk
       image.display(); 	
    }
 }


// ============================================================================================================================================= //

//** references */
// https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
// https://www.oodesign.com/proxy-pattern.html
// https://www.geeksforgeeks.org/proxy-design-pattern/
// https://www.javatpoint.com/proxy-pattern