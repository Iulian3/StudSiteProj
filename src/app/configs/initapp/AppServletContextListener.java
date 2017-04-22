package app.configs.initapp;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import app.logging.formatters.AppLogFormatter;
import app.logging.loggers.ClassLogger;
import db.conn.DBConnMaster;

@WebListener
public class AppServletContextListener implements ServletContextListener{

	private DBConnMaster moDBConnMaster;
	private app.logging.ILogger moLogger;
	
	
	@Override
	public void contextInitialized(ServletContextEvent oEvent) {
		
		moDBConnMaster = DBConnMaster.getInstance();
		
		// setup logger for this class
		moLogger = new ClassLogger(new AppLogFormatter());
		moLogger.configureLogger(AppServletContextListener.class.getName());	
		
		java.sql.Connection oDbConnection = moDBConnMaster.getDBConnection();
		
		ServletContext oServletContext = oEvent.getServletContext();
		
		//save database connection in ServletContext
		oServletContext.setAttribute("oDbConnection", oDbConnection);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent oEvent) {
		moDBConnMaster.destroyDBConnection();
	}

}
