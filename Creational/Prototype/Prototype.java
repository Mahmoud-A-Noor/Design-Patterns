
/*

--------------------------------------------------------------------------------------
Prototype patterns are required, when object creation is time consuming, and costly operation.
Ex. an object is to be created after a costly database operation
--------------------------------------------------------------------------------------
It allows an object to create customized objects without knowing their class or any details of how to create them.
--------------------------------------------------------------------------------------
Benefits of using Singleton    
    1- It reduces the need of sub-classing.
    2- It hides complexities of creating objects.
    3- The clients can get new objects without knowing which type of object it will be.
    4- It lets you add or remove objects at runtime.
    5- Specifying new objects by varying values => 
       Highly dynamic systems let you define new behavior through object composition by specifying values for an object’s variables.
    6- Specifying new objects by varying structure =>
       Factory Method often produces a hierarchy of Creator classes that parallels the product class hierarchy. 
       The Prototype pattern lets you clone a prototype instead of asking a factory method to make a new object. 
       Hence you don’t need a Creator class hierarchy at all.
--------------------------------------------------------------------------------------
when to use Prototype
    1- system should be independent of how its products are created, composed, and represented, and:
        |- Classes to be instantiated are specified at run-time
        ||- Avoiding the creation of a factory(pattern) hierarchy is needed
        |||- It is more convenient to copy an existing instance than to create a new one.
    2- When you want to keep the number of classes in an application minimum.
    3- When the cost of creating an object is expensive or complicated.
--------------------------------------------------------------------------------------
Hot points
    1- Prototype Manager => implemented usually as a hashtable keeping the object to clone. When use it, 
       prototype become a factory method which uses cloning instead of instantiation.
    2- Deep Clones vs. Shallow Clones => when we clone complex objects which contains other objects, we should take care how they are cloned. 
       We can clone contained objects also (deep cloning) or we can the same reference for them, and to share them between cloned container objects.
    3- Initializing Internal States => there are certain situations when objects need to be initialized after they are created.
--------------------------------------------------------------------------------------
 
*/


//** Prototype Implementation */

interface Prototype{  
    public Prototype getClone();   
}

class EmployeeRecord implements Prototype{  
    private int id;  
    private String name, designation;  
    private double salary;  
    private String address;  
       
    public EmployeeRecord(){  
             System.out.println("   Employee Records of Oracle Corporation ");  
             System.out.println("---------------------------------------------");  
             System.out.println("Eid"+"\t"+"Ename"+"\t"+"Edesignation"+"\t"+"Esalary"+"\t\t"+"Eaddress");  
    }  
   
    public  EmployeeRecord(int id, String name, String designation, double salary, String address) {  
         this();  
         this.id = id;  
         this.name = name;  
         this.designation = designation;  
         this.salary = salary;  
         this.address = address;  
    }  
       
    public void showRecord(){  
         System.out.println(id+"\t"+name+"\t"+designation+"\t"+salary+"\t"+address);  
    }  
   
     @Override  
     public Prototype getClone() {  
         return new EmployeeRecord(id,name,designation,salary,address);  
    }  
} 

//** Usage */

class PrototypeDemo{  
    public static void main(String[] args) throws IOException {
          
       EmployeeRecord e1 = new EmployeeRecord(1,"John","Manager",10000,"USA");  
       e1.showRecord();

       System.out.println("\n");  
       
       EmployeeRecord e2=(EmployeeRecord) e1.getClone();  
       e2.showRecord();  
   }     
}


// ============================================================================================================================================= //

//** references */
// https://www.tutorialspoint.com/design_pattern/prototype_pattern.htm
// https://www.oodesign.com/prototype-pattern.html
// https://www.geeksforgeeks.org/prototype-design-pattern/
// https://www.javatpoint.com/prototype-design-pattern