package db;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;


@ApplicationPath("rest")
public class MyApp extends ResourceConfig{

	public MyApp ()
	{
		// will look in /db folder for resources
		packages("db"); // or "MyApp.class.getPackage().getName()"

        // Is obligatory! 
		// Without this line the app does not work
		// (i.e.: You get an Internal Error)
		register(JspMvcFeature.class);
	}
}
