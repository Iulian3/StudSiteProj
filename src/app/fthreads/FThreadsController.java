package app.fthreads;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

/**
 * 
 * @author G_Ivan
 *
 * See info here (why is Singleton):
 * <a href="https://jersey.java.net/documentation/latest/jaxrs-resources.html#d0e2496">Jersey Sub-resources</a>
 * 
 */
@Singleton
public class FThreadsController {

	/**
	 * 
	 * @return Viewable for template 'app/views/fthreads/threads-list.jsp'
	 * 
	 * Controller sends to threads-list.jsp all forum threads
	 * list from database.
	 * 
	 */
	@GET
	public Viewable getThreadsListPage()
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
	@GET
	@Path("{threadid}")
	public Class<app.tposts.TPostsController> dispatchWorkFPostsController()
	{
		return app.tposts.TPostsController.class;
	}
}
