package app.forums;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;


/**
 * 
 * @author G_Ivan
 *
 *	Works with 'forums' table from database
 *
 */
public class ForumsDAO implements IForumsDAO{
	
	private java.sql.Connection moDBConnection = null;
	
	@Inject app.logging.ILogger moLogger;
	@Context ServletContext moServletContext;
	
	private void setupLogger()
	{
		if (!moLogger.isConfigured())
			moLogger.configureLogger(ForumsController.class.getName());
	}
	
	/**
	 *  NOTE:
	 *  Even if constructor is empty, it is obligatory.
	 *  Without it you get the following error types:
	 *  1. org.glassfish.hk2.api.UnsatisfiedDependencyException
	 *  2. java.lang.IllegalArgumentException: While attempting to resolve the dependencies of (some class) errors were found
	 */
	public ForumsDAO(){}
	
	/*
	 *  RULE: 
	 *  Do NOT ever user Injected members in constructor, because 
	 *  constructor call is executed first, then Injection is done.
	 *  So, in constructor the Injected field will be the default value for field type.
	 *  
	 */

	@Override
	public List<Forum> getForumsList() {
		
		setupLogger();
		
		// get connection variable from ServletContext
		moDBConnection = (java.sql.Connection)moServletContext.getAttribute("oDbConnection");
		
		Statement oStmt = null;
		ResultSet oRs = null;

		List<Forum> olForumList = new ArrayList<Forum>();
		try
		{
			oStmt = moDBConnection.createStatement();
			oRs = oStmt.executeQuery("SELECT * FROM forums ORDER BY creationDate ASC");
			
			// loop through all rows, and get information from each column
			while (oRs.next())
			{
				app.forums.Forum forum = new app.forums.Forum();
				forum.setForumId(oRs.getLong(1));
				forum.setTitle(oRs.getString(2));
				forum.setCreationDate(oRs.getDate(3));
				forum.setShortDescription(oRs.getString(4));
				
				olForumList.add(forum);
			}
			
		}catch (Exception oeSQLException)
		{
			moLogger.getLogger().log(Level.SEVERE, oeSQLException.getMessage());
		}
		finally
		{
			// release resources because they are not needed anymore
			
			 if (oRs != null) {
			        try {
			            oRs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        oRs = null;
			    }

			    if (oStmt != null) {
			        try {
			            oStmt.close();
			        } catch (SQLException sqlEx) { } // ignore

			        oStmt = null;
			    }
		}
		
		return olForumList;
	}

	
}
