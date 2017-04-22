package app.configs;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@ApplicationPath("")
public class AppConfigs extends ResourceConfig {
	
	public AppConfigs()
	{	
		
		/*
		 * TODO: see what packages need to be added
		 * 
		 * 	Obligatory!
		 * 	Without this line app won't work.
		 * 	Error without this line:
		 * 		HTTP Status 404 - Not Found
		 * 
		 * 	It tells app where to find resource classes.
		 */
		packages("app.forums");
		
		 /*
		  * Obligatory! 
		  * Application won't work without this line.
		  *	i.e.: It won't know how to serialize/deserialize JSON type.
		  *	Error without this line:
		  *		MessageBodyWriter not found for media type=application/json ...
		  */
		register(JacksonJsonProvider.class);
	
		
		register(new AbstractBinder() {
            @Override
            protected void configure() {
            	
            	// AppLogFormatter(where injected) object will be treated as an Formatter object
            	bind(app.logging.formatters.AppLogFormatter.class)
            	.to(java.util.logging.Formatter.class);

            	// Logger(where injected) object will be treated as an ClassLogger object
            	bind(app.logging.loggers.ClassLogger.class)
            	.to(app.logging.ILogger.class);
           	
            	// IForumsDAO(where injected) object will be treated as an ForumsDAO object
            	bind(app.forums.ForumsDAO.class)
            	.to(app.forums.IForumsDAO.class)
            	.in(Singleton.class);
 
            }
        });
		
	}
}
