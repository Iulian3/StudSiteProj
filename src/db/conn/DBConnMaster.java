package db.conn;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import app.configs.initapp.AppServletContextListener;
import app.logging.formatters.AppLogFormatter;
import app.logging.loggers.ClassLogger;

public class DBConnMaster {

	private static java.sql.Connection oDbConnection = null;
	
	private app.logging.Logger moLogger = null;
	private static DBConnMaster moInstance = null;
	private static final String msURL = "jdbc:mysql://localhost:3306/studsitedb";
	private static final String msUSERNAME = "root";
	private static final String msPASSWORD = "root";
	
	private DBConnMaster(){
		moLogger = new ClassLogger(new AppLogFormatter());
		moLogger.configureLogger(DBConnMaster.class.getName());
	}
	
	public static DBConnMaster getInstance()
	{
		if (moInstance == null)
			moInstance = new DBConnMaster();
		return moInstance;
	}
	
	
	public java.sql.Connection getDBConnection()
	{
		if (oDbConnection == null)
		{
			try
			{
				 Class.forName("com.mysql.jdbc.Driver").newInstance();
				 oDbConnection = DriverManager.getConnection(msURL, msUSERNAME, msPASSWORD);
				 
			}catch (Exception oSqlEx)
			{
				if (moLogger != null)
					moLogger.getLogger().log(Level.SEVERE, oSqlEx.getMessage());
			}
		}
		
		return oDbConnection;
	}
	
	public void destroyDBConnection()
	{
		System.out.println("destroyDBConnection");
		if (oDbConnection != null)
		{
			try
			{
				oDbConnection.close();
			} catch (SQLException oSqlEx)
			{
				if (moLogger != null)
				{
					moLogger.getLogger().log(Level.SEVERE, oSqlEx.getMessage());
					
				}
			}
		}
	
	}
	
}
