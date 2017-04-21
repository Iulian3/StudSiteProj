package app.tposts;

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
public class TPostsController {

	/**
	 * 
	 * @return Viewable for template 'app/views/fposts/posts-list.jsp'
	 * 
	 * Controller sends to posts-list.jsp all forum thread posts
	 * list from database.
	 * 
	 */
	@GET
	public Viewable getPostsListPage()
	{
		
	}
	
	/**
	 * 
	 * TODO: see what data to send to postview.jsp view.
	 * 
	 * @return View for template 'app/views/tposts/postview.jsp'
	 *  
	 */
	@GET
	@Path("{postid}")
	public Viewable getPostViewPage()
	{
		
	}
}
