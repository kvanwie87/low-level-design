package casestudy.elevator;

public class Floor {
	public String label;
	public int number;
	public Floor next;
	public Floor prev;
	public Floor(String label, int number) {
		this.label = label;
		this.number = number;
	}
	
}
