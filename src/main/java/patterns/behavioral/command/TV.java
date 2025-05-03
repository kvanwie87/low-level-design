package patterns.behavioral.command;

public class TV {
	private boolean isOn = false;
	private int channel = 0;
	private int volume = 0;
	public void turnOn() {
		isOn = true;
	}
	public void turnOff() {
		isOn = false;
	}
	public void increaseVolume() {
		volume++;
		if(volume > 100)
			volume = 100;
	}
	public void decreaseVolume() {
		volume--;
		if(volume < 0)
			volume = 0;
	}
	public void setVolume(int volume) {
		this.volume = volume;
		if(volume > 100)
			volume = 100;
		if(volume < 0)
			volume = 0;
	}
	public void increaseChannel() {
		channel++;
	}
	public void decreaseChannel() {
		channel--;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	
	
	public boolean isOn() {
		return isOn;
	}
	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	public void describe() {
		System.out.println("TV is " + (isOn ? "ON": "OFF") + ", Volume: " + volume + ", Channel: " + channel);
	}
}
