
/*

--------------------------------------------------------------------------------------
comes in different variants and implementations (Ex. Factory Method and Abstract Factory)
--------------------------------------------------------------------------------------
widely used in JDK
    1- getInstance() method of java.util.Calendar, NumberFormat and ResourceBundle
    2- All the wrapper classes like Integer, Boolean etc, to evaluate the values using valueOf() method.
    3- java.nio.charset.Charset.forName(), java.sql.DriverManager.getConnection(), java.net.URL.openConnection(), java.lang.Class.newInstance(), java.lang.Class.forName()
--------------------------------------------------------------------------------------
Benefits of using Singleton 
    1- this pattern provides one of the best ways to create an object.
    2- It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code.
    3- Factory Method Pattern allows the sub-classes to choose the type of objects to create.
    4- creates objects without exposing the instantiation logic to the client and refers to the newly created object through a common interface
--------------------------------------------------------------------------------------
when to use Factory   
    1- If you have many objects of the same base type and you manipulate them mostly casted to abstract types, then you need a factory.
    2- When a class doesn't know what sub-classes will be required to create
    3- When a class wants that its sub-classes specify the objects to be created.
    4- When the parent classes choose the creation of objects to its sub-classes.
--------------------------------------------------------------------------------------
 
*/


//** Factory Implementation */

public interface Notification {
    void notifyUser();
}

public class SMSNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        // TODO Auto-generated method stub
        System.out.println("Sending an SMS notification");
    }
}

public class EmailNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        // TODO Auto-generated method stub
        System.out.println("Sending an e-mail notification");
    }
}

public class PushNotification implements Notification {
 
    @Override
    public void notifyUser()
    {
        // TODO Auto-generated method stub
        System.out.println("Sending a push notification");
    }
}

//** Usage */

public class NotificationFactory {
    public Notification createNotification(String channel)
    {
        if (channel == null || channel.isEmpty())
            return null;
        if ("SMS".equals(channel)) {
            return new SMSNotification();
        }
        else if ("EMAIL".equals(channel)) {
            return new EmailNotification();
        }
        else if ("PUSH".equals(channel)) {
            return new PushNotification();
        }
        return null;
    }
}

// Note => that the previous example is not a good example of Factory Method as it violates OCP principle.
// checkout the oodesign reference for the advanced implementation (no OCP violation).

// ============================================================================================================================================= //

//** references */
// https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
// https://www.oodesign.com/factory-pattern.html
// https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/
// https://www.javatpoint.com/factory-method-design-pattern