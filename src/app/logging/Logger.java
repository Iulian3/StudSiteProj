package app.logging;

public interface Logger {
	
	public void configureLogger(String sClassName);
	public java.util.logging.Logger getLogger();
}
