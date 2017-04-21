package app.tposts;

import java.util.Date;

/**
 * 
 * @author G_Ivan
 *
 * Data model class.
 * 
 */
public class TPost {
	
	private int miThreadId;
	private String msTitle;
	private Date moCreationDate;
	private String msPostBody;
	
	public int getMiThreadId() {
		return miThreadId;
	}
	public void setMiThreadId(int miThreadId) {
		this.miThreadId = miThreadId;
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
	public String getMsPostBody() {
		return msPostBody;
	}
	public void setMsPostBody(String msPostBody) {
		this.msPostBody = msPostBody;
	}
	
	
}
