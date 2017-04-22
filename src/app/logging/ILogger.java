package app.logging;

public interface ILogger {
	
	/**
	 * 
	 * @param sClassName absolute class name (ex.: app.logging.ILogger)
	 * 
	 * 	Create directory tree corresponding to absolute class name.
	 * 	Set logger formatter and handler.
	 */
	public void configureLogger(String sClassName);
	/**
	 * 
	 * @return the configured logger object
	 */
	public java.util.logging.Logger getLogger();
	/**
	 * 
	 * @return true if logger is configured, false if not
	 */
	public boolean isConfigured(); 
}
