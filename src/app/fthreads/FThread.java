package app.fthreads;

import java.util.Date;

/**
 * 
 * @author G_Ivan
 * 
 * Data model class
 * 
 */
public class FThread {
	
	private int miThreadId;
	private String msTitle;
	private String msShortDescription;
	private Date moCreationDate;
	
	
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
	public String getMsShortDescription() {
		return msShortDescription;
	}
	public void setMsShortDescription(String msShortDescription) {
		this.msShortDescription = msShortDescription;
	}
	public Date getMoCreationDate() {
		return moCreationDate;
	}
	public void setMoCreationDate(Date moCreationDate) {
		this.moCreationDate = moCreationDate;
	}
}
