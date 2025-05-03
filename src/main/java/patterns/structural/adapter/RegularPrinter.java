package patterns.structural.adapter;

public class RegularPrinter implements Printer {

	@Override
	public void print(String str) {
		System.out.println("Regular:"+str);
	}

}
