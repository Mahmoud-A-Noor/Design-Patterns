
/*

--------------------------------------------------------------------------------------
decouple the functional abstraction from the implementation so that the two can vary independently
--------------------------------------------------------------------------------------
involves an interface which acts as a bridge which makes the functionality of concrete classes independent from interface implementer classes. 
Both types of classes can be altered structurally without affecting each other.
--------------------------------------------------------------------------------------
An Abstraction can be implemented by an abstraction implementation, and this implementation does not depend on any concrete implementers of the Implementor interface. 
Extending the abstraction does not affect the Implementor. Also extending the Implementor has no effect on the Abstraction.
--------------------------------------------------------------------------------------
Graphical User Interface Frameworks use the bridge pattern to separate abstractions from platform specific implementation.
--------------------------------------------------------------------------------------
when to use:
    1- When you don't want a permanent binding between the functional abstraction and its implementation.
    2- When both the functional abstraction and its implementation need to extended using sub-classes.
    3- It is mostly used in those places where changes are made in the implementation does not affect the clients.
--------------------------------------------------------------------------------------
Benefits of using Bridge    
    1- It enables the separation of implementation from the interface.
    2- It improves the extensibility.
    3- It allows the hiding of implementation details from the client.
    4- increases the loose coupling between class abstraction and it’s implementation.
--------------------------------------------------------------------------------------
 
*/


//** Bridge Implementation */

public interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
 }

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}

public abstract class Shape {
    protected DrawAPI drawAPI;
    
    protected Shape(DrawAPI drawAPI){
       this.drawAPI = drawAPI;
    }
    public abstract void draw();	
}

public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
       super(drawAPI);
       this.x = x;  
       this.y = y;  
       this.radius = radius;
    }
 
    public void draw() {
       drawAPI.drawCircle(radius,x,y);
    }
}

//** Usage */

public class BridgePatternDemo {
    public static void main(String[] args) {
       Shape redCircle = new Circle(100,100, 10, new RedCircle());
       Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
 
       redCircle.draw();
       greenCircle.draw();
    }
}


// ============================================================================================================================================= //

//** references */
// https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
// https://www.oodesign.com/bridge-pattern.html
// https://www.geeksforgeeks.org/bridge-design-pattern/
// https://www.javatpoint.com/bridge-pattern