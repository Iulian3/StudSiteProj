package app.configs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/*")
public class AppConfigs extends ResourceConfig {
	
	public AppConfigs()
	{
		packages("");
		
		register(new AbstractBinder() {
            @Override
            protected void configure() {
            	bind(java.util.logging.Formatter.class)
            	.to(app.logging.formatters.AppLogFormatter.class);
            	bind(app.logging.Logger.class)
            	.to(app.logging.loggers.ClassLogger.class);
            }
        });
		
	}
}
