package casestudy.logger;

public enum LogLevel {
	OFF(7), 
	FATAL(6), 
	ERROR(5), 
	WARN(4), 
	INFO(3), 
	DEBUG(2), 
	TRACE(1), 
	ALL(0);
	public final Integer level;
	private LogLevel(int level) {
		this.level = level;
	}
}
