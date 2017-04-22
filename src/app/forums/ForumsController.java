package app.forums;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ForumsController{
	
	
	@Inject IForumsDAO moForumsDAO;
	@Inject app.logging.ILogger moLogger;
	
	/**
	 * 
	 * @return Viewable for template /app/views/forums/index.jsp
	 * 
	 * TODO: see if exist content to send to /app/views/forums/index.jsp 
	 * 
	 */
//	@GET
//	public Viewable getIndexPage()
//	{
//		
//	}
	
	/**
	 * 
	 * @return Viewable for template 'app/views/forums/forum-list.jsp'
	 * 
	 * Controller sends to forum-list.jsp all forums
	 * list from database.
	 * 
	 */
	private void setupLogger()
	{
		if (!moLogger.isConfigured())
			moLogger.configureLogger(ForumsController.class.getName());
	}
	
	
	// TODO: forward to jsp the response
	
	@Path("forums")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Forum> getForumsListPage()
	{
		setupLogger();

		List<Forum> list = moForumsDAO.getForumsList();
		
		return list;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * Function is a sub-resource locator method.
	 * See info here:
	 * <a href="https://jersey.java.net/documentation/latest/jaxrs-resources.html#d0e2496">Jersey Sub-resources</a>
	 * 
	 */
//	@Path("forums/{forumid}")
//	public Class<app.fthreads.FThreadsController> dispatchWorkFThreadsController()
//	{
//		return app.fthreads.FThreadsController.class;
//	}
}
