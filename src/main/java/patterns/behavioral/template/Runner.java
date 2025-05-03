package patterns.behavioral.template;

public class Runner {
	public static void main(String[] args) {
		//Process process = new Process();
		//Process process = new VariationOfProcess();
		Process process = new OtherVariationOfProcess();
		process.performComplexProcess();
	}
}
