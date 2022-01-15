
/*

--------------------------------------------------------------------------------------
Clients should not be forced to depend on methods that they do not use
--------------------------------------------------------------------------------------
clients should not be forced to implement interfaces they don't use. 
Instead of one fat interface many small interfaces are preferred based on groups of methods, each one serving one submodule
--------------------------------------------------------------------------------------
Client mustn't implement unnecessary methods
--------------------------------------------------------------------------------------
Note => If the design is already done fat interfaces can be segregated using the Adapter pattern.
--------------------------------------------------------------------------------------
Note => applying this principle increase the complexity of code. But it produce a flexible design. 
        If we are going to apply it more than is necessary it will result a code containing a lot of interfaces with single methods,
        so applying should be done based on experience and common sense in identifying the areas where extension of code are more likely to happens in the future.
--------------------------------------------------------------------------------------

 */


//** Bad Example */

interface IWorker {
	public void work();
	public void eat();
}

class Worker implements IWorker{
	public void work() {
		// ....working
	}
	public void eat() {
		// ...... eating in launch break
	}
}

class SuperWorker implements IWorker{
	public void work() {
		//.... working much more
	}

	public void eat() {
		//.... eating in launch break
	}
}

class Manager {
	IWorker worker;

	public void setWorker(IWorker w) {
		worker=w;
	}

	public void manage() {
		worker.work();
	}
}


//** Good Example */

interface IWorker extends Feedable, Workable {
}

interface IWorkable {
	public void work();
}

interface IFeedable{
	public void eat();
}

class Worker implements IWorkable, IFeedable{
	public void work() {
		// ....working
	}

	public void eat() {
		//.... eating in launch break
	}
}

class Robot implements IWorkable{
	public void work() {
		// ....working
	}
}

class SuperWorker implements IWorkable, IFeedable{
	public void work() {
		//.... working much more
	}

	public void eat() {
		//.... eating in launch break
	}
}

class Manager {
	Workable worker;

	public void setWorker(Workable w) {
		worker=w;
	}

	public void manage() {
		worker.work();
	}
}

// ============================================================================================================================================= //

//** references */
// https://www.alpharithms.com/solid-guidelines-for-better-software-development-055500/
// https://www.oodesign.com/interface-segregation-principle.html