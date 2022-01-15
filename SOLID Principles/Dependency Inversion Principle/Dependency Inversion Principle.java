
/*

--------------------------------------------------------------------------------------
Don’t call us, we’ll call you
--------------------------------------------------------------------------------------
High-level modules should not depend on low-level modules. Both should depend on abstractions.
High Level Classes --> Abstraction Layer --> Low Level Classes
--------------------------------------------------------------------------------------
Abstractions should not depend on details. 
Details should depend on abstractions.
--------------------------------------------------------------------------------------
Since the high level modules contain the complex logic they should not depend on the low level modules 
so the new abstraction layer should not be created based on low level modules. 
Low level modules are to be created based on the abstraction layer.
--------------------------------------------------------------------------------------
applying this principle will result in more classes and interfaces to maintain, more complex code, but more flexible. 
This principle should not be applied blindly for every class or every module. 
If we have a class functionality that is more likely to remain unchanged in the future there is not need to apply this principle.
--------------------------------------------------------------------------------------
### Dependency inversion principle VS Dependency injection ###
Dependency Inversion (general design guideline) : recommends that classes should only have direct relationships with high-level abstractions.
Dependency Injection (application of Dependency Inversion) : an implementation technique for populating instance variables of a class.
 
*/


//** Bad Example */

class Worker {
	public void work() {
		// ....working
	}
}

class Manager {
	Worker worker;

	public void setWorker(Worker w) {
		worker = w;
	}

	public void manage() {
		worker.work();
	}
}

class SuperWorker {
	public void work() {
		//.... working much more
	}
}



//** Good Example */

interface IWorker {
	public void work();
}

class Worker implements IWorker{
	public void work() {
		// ....working
	}
}

class SuperWorker implements IWorker{
	public void work() {
		//.... working much more
	}
}

class Manager {
	IWorker worker;

	public void setWorker(IWorker w) {
		worker = w;
	}

	public void manage() {
		worker.work();
	}
}

// ============================================================================================================================================= //

//** references */
// https://www.alpharithms.com/solid-guidelines-for-better-software-development-055500/
// https://www.oodesign.com/dependency-inversion-principle.html