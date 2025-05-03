package patterns.structural.adapter;

public class OldPrinterAdapter implements Printer{
	private OldPrinter printer;
	public OldPrinterAdapter(OldPrinter printer) {
		this.printer = printer;
	}
	@Override
	public void print(String str) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Adapter:");
		buffer.append(str);
		printer.doSomePrinting(buffer);
	}

}
