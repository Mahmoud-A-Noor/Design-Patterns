
/*

--------------------------------------------------------------------------------------
Separate the construction of a complex object from its representation so that the same construction process can create different representations.
--------------------------------------------------------------------------------------
builds a complex object using simple objects and using a step by step approach.
--------------------------------------------------------------------------------------
The process of constructing an object should be generic so that it can be used to create different representations of the same object.
--------------------------------------------------------------------------------------
mostly used when object can't be created in single step like in the de-serialization of a complex object.
--------------------------------------------------------------------------------------
The logic of this process is isolated form the actual steps used in creating the complex object, 
so the process can be used again to create a different object form the same set of simple objects as the first one.
--------------------------------------------------------------------------------------
In practice the products created by the concrete builders have a structure significantly different, 
so if there is not a reason to derive different products a common parent class. 
This also distinguishes the Builder pattern from the Abstract Factory pattern which creates objects derived from a common type.
--------------------------------------------------------------------------------------
Benefits of using Singleton 
    1- It provides clear separation between the construction and representation of an object.
    2- It provides better control over construction process.
    3- It supports to change the internal representation of objects.
--------------------------------------------------------------------------------------
 
*/


//** Builder Implementation */

public interface Packing {  // Packing interface.
    public String pack();  
    public int price();  
}

public abstract class CD implements Packing{  // abstract class CD which will implement Packing interface.
    public abstract String pack();  
    }  

public abstract class Company extends CD{  
    public abstract int price();  
    }  

public class Sony extends Company{  // implementation classes of Company sony
    @Override  
        public int price(){   
                        return 20;  
        }  
    @Override  
    public String pack(){  
                return "Sony CD";  
        }         
}//End of the Sony class.

public class Samsung extends Company {  // implementation classes of Company samsung
    @Override  
        public int price(){   
                        return 15;  
    }  
    @Override  
    public String pack(){  
             return "Samsung CD";  
        }         
}//End of the Samsung class.  

public class CDType {  // CDType class
    private List<Packing> items=new ArrayList<Packing>();  
    public void addItem(Packing packs) {    
           items.add(packs);  
    }  
    public void getCost(){  
     for (Packing packs : items) {  
               packs.price();  
     }   
    }  
    public void showItems(){  
     for (Packing packing : items){  
    System.out.print("CD name : "+packing.pack());  
    System.out.println(", Price : "+packing.price());  
    }       
   }     
}//End of the CDType class.  

public class CDBuilder {  
    public CDType buildSonyCD(){   
       CDType cds=new CDType();  
       cds.addItem(new Sony());  
       return cds;  
    }  
    public CDType buildSamsungCD(){  
    CDType cds=new CDType();  
    cds.addItem(new Samsung());  
    return cds;  
    }  
}// End of the CDBuilder class.  

//** Usage */

public class BuilderDemo{  
    public static void main(String args[]){  
      CDBuilder cdBuilder=new CDBuilder();  
      CDType cdType1=cdBuilder.buildSonyCD();  
      cdType1.showItems();  
     
      CDType cdType2=cdBuilder.buildSamsungCD();  
      cdType2.showItems();  
    }  
   }  

// ============================================================================================================================================= //

//** references */
// https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
// https://www.oodesign.com/builder-pattern.html
// https://www.geeksforgeeks.org/builder-design-pattern/
// https://www.javatpoint.com/builder-design-pattern