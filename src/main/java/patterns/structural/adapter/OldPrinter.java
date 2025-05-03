package patterns.structural.adapter;

public class OldPrinter {
	public void doSomePrinting(StringBuffer str) {
		System.out.println("Old:"+str.toString());
	}
}
