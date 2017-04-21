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

	private int miForumId;
	private String msTitle;
	private Date moCreationDate;
	private String msShortDescription;
	
	public int getMiForumId() {
		return miForumId;
	}
	public void setMiForumId(int miForumId) {
		this.miForumId = miForumId;
	}
	public String getMsTitle() {
		return msTitle;
	}
	public void setMsTitle(String msTitle) {
		this.msTitle = msTitle;
	}
	public Date getMoCreationDate() {
		return moCreationDate;
	}
	public void setMoCreationDate(Date moCreationDate) {
		this.moCreationDate = moCreationDate;
	}
	public String getMsShortDescription() {
		return msShortDescription;
	}
	public void setMsShortDescription(String msShortDescription) {
		this.msShortDescription = msShortDescription;
	}
	
	
}
