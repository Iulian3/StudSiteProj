package app.logging.loggers;

import java.io.File;

import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.tomcat.util.http.fileupload.FileUtils;


public class ClassLogger implements app.logging.ILogger{
	
	private Formatter moFormatter = null;
	private java.util.logging.Logger moLogger = null;
	private static boolean mbOldDirTreeDeleted = false;  // ensure
	private boolean mbIsConfigured = false;
	
	/**
	 * 
	 * @param oFormatter
	 * 
	 * 	Set Formatter.
	 * 
	 * 	The folder: {system temporary folder}/StudSiteProj will keep all app logs.
	 *	It's hierarchy will correspond to project package hierarchy.
	 *
	 *	Delete the directory tree from last web app run. 
	 */
	@Inject
	public ClassLogger(Formatter oFormatter)
	{
		moFormatter = oFormatter;
		
		if (mbOldDirTreeDeleted == false)
		{	
			try {
				FileUtils.deleteDirectory(new File(System.getProperty("java.io.tmpdir") + "StudSiteProj"));
			} catch (Exception e) {
				System.out.println("Problem occurs when deleting the directory : " + System.getProperty("java.io.tmpdir") + "StudSiteProj");
				e.printStackTrace();
			}
			mbOldDirTreeDeleted = true;
		}
	}
	
	/**
	 * 	@param sClassName absolute class name (ex.: app.logging.loggers.ClassLogger)
	 * 
	 */
	@Override
	public void configureLogger(String sClassName) {
		
		try
		{
			String sLogFilePath = System.getProperty("java.io.tmpdir") 
					+ "StudSiteProj/applogs/" 
					+ sClassName.replaceAll(Pattern.quote("."), "/");
			
			String sLogFilePathPattern = sLogFilePath + "/log%g.log";
			
			// create new directory structure
			File oFile = new File(sLogFilePath);
			oFile.mkdirs();
			
			moLogger = Logger.getLogger(sClassName);
			
			FileHandler oFileHandler = new FileHandler(sLogFilePathPattern, 1000000, 1, true);
			
			oFileHandler.setFormatter(moFormatter);
			
			moLogger.addHandler(oFileHandler);
			moLogger.setLevel(Level.ALL);
			
			mbIsConfigured = true;
			
		} catch (Exception oEx)
		{
			System.out.println(oEx.getMessage());
		}
	}

	@Override
	public Logger getLogger() {
		return moLogger;
	}

	@Override
	public boolean isConfigured() {
		return mbIsConfigured;
	}

}
