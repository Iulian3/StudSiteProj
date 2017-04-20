package db;


import javax.ws.rs.core.MediaType;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.server.mvc.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("foo")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Hello {
 
	public final Map<String, String> map = new TreeMap<>();
	public String name;
	
	public Hello()
	{}
	
	@GET
    public Viewable get() {
    	
		this.name = "Some name";
        map.put("user", "xxx");
        map.put("useder", "yyyy");
        map.put("udser", "xxx");
		// relative template reference
		return new Viewable("NewFile", this);// or "NewFile" without '.jsp'
		
		// or
		// absolute template reference
        // return new Viewable("/db/Hello/NewFile.jsp"); // or "/db/Hello/NewFile" without '.jsp'
    }
	
	
	public Map<String, String> getMap()
	{
		return map;
	}
	
	public String getName()
	{
		return name;
	}
	

}


