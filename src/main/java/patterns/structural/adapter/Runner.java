package patterns.structural.adapter;

public class Runner {
	public static void main(String[] args) {
		Printer printer = new RegularPrinter();
		OldPrinter oldPrinter = new OldPrinter();

		//oldPrinter.doSomePrinting("hello");
		Printer adapter = new OldPrinterAdapter(oldPrinter);
		doRun(adapter);
	}
	public static void doRun(Printer printer) {
		printer.print("hello");
	}
}
