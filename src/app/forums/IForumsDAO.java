package app.forums;

import java.util.List;

/**
 * 
 * @author G_Ivan
 *
 *	Data access object interface.
 */
public interface IForumsDAO {
	
	/**
	 * 
	 * @return list of Forum objects
	 * 
	 * 	Queries the database.
	 */
	List<Forum> getForumsList();

}
