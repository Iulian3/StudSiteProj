package app.forums;

import java.util.Date;

/**
 * 
 * @author G_Ivan
 * 
 * Data model class
 * 
 */
public class Forum {

	private long miForumId;
	private String msTitle;
	private Date moCreationDate;
	private String msShortDescription;
	
	public long getForumId() {
		return miForumId;
	}
	public void setForumId(long miForumId) {
		this.miForumId = miForumId;
	}
	public String getTitle() {
		return msTitle;
	}
	public void setTitle(String msTitle) {
		this.msTitle = msTitle;
	}
	public Date getCreationDate() {
		return moCreationDate;
	}
	public void setCreationDate(Date moCreationDate) {
		this.moCreationDate = moCreationDate;
	}
	public String getShortDescription() {
		return msShortDescription;
	}
	public void setShortDescription(String msShortDescription) {
		this.msShortDescription = msShortDescription;
	}
	
	
}
