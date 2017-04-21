package app.forums;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

public class ForumsController {
	
	/**
	 * 
	 * @return Viewable for template /app/views/forums/index.jsp
	 * 
	 * TODO: see if exist content to send to /app/views/forums/index.jsp 
	 * 
	 */
	@GET
	public Viewable getIndexPage()
	{
		
	}
	
	/**
	 * 
	 * @return Viewable for template 'app/views/forums/forum-list.jsp'
	 * 
	 * Controller sends to forum-list.jsp all forums
	 * list from database.
	 * 
	 */
	@Path("forums")
	public Viewable getForumsListPage()
	{
		
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
	@Path("forums/{forumid}")
	public Class<app.fthreads.FThreadsController> dispatchWorkFThreadsController()
	{
		return app.fthreads.FThreadsController.class;
	}
}
