package app.logging.loggers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.tomcat.util.http.fileupload.FileUtils;


public class ClassLogger implements app.logging.Logger{
	
	private String msClassName = "";
	private Formatter moFormatter = null;
	private java.util.logging.Logger moLogger = null;
	private static boolean mbOldDirTreeDeleted = false;
	
	
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
	
	@Override
	public void configureLogger(String sClassName) {
		
		msClassName = sClassName;

		try
		{
			String sLogFilePath = System.getProperty("java.io.tmpdir") 
					+ "StudSiteProj/applogs/" 
					+ sClassName.replaceAll(Pattern.quote("."), "/");
			
			String sLogFilePathPattern = sLogFilePath + "/log%g.log";
			
			File oFile = new File(sLogFilePath);
			
			oFile.mkdirs();
			
			moLogger = Logger.getLogger(sClassName);
			
			FileHandler oFileHandler = new FileHandler(sLogFilePathPattern, 1000000, 1, true);
			
			oFileHandler.setFormatter(moFormatter);
			moLogger.addHandler(oFileHandler);
	
			moLogger.setLevel(Level.ALL);
			
		} catch (Exception oEx)
		{
			System.out.println(oEx.getMessage());
		}
	}

	@Override
	public Logger getLogger() {
		return moLogger;
	}


}
