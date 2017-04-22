package app.configs.initapp;


import java.io.File;
import java.util.logging.Level;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import app.logging.formatters.AppLogFormatter;
import app.logging.loggers.ClassLogger;
import db.conn.DBConnMaster;

@WebListener
public class AppServletContextListener implements ServletContextListener{

	private DBConnMaster moDBConnMaster;
	private app.logging.Logger moLogger;
	
	
	@Override
	public void contextInitialized(ServletContextEvent oEvent) {
		
		moDBConnMaster = DBConnMaster.getInstance();
		moLogger = new ClassLogger(new AppLogFormatter());
		moLogger.configureLogger(AppServletContextListener.class.getName());	
		
		java.sql.Connection oDbConnection = moDBConnMaster.getDBConnection();
		
		ServletContext oServletContext = oEvent.getServletContext();
		oServletContext.setAttribute("oDbConnection", oDbConnection);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent oEvent) {
		moDBConnMaster.destroyDBConnection();
	}

}
