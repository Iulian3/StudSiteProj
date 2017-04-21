package app.configs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/*")
public class AppConfigs extends ResourceConfig {
	
	public AppConfigs()
	{
		
	}
}
