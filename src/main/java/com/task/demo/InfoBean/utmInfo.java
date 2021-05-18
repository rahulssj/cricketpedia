package com.task.demo.InfoBean;

public class utmInfo {

	private String utm_source;
	private String utm_term;
	private String utm_medium;
	private String utm_compaign;
	private String utm_content;
	public String getUtm_source() {
		return utm_source;
	}
	public void setUtm_source(String utm_source) {
		this.utm_source = utm_source;
	}
	public String getUtm_term() {
		return utm_term;
	}
	public void setUtm_term(String utm_term) {
		this.utm_term = utm_term;
	}
	public String getUtm_medium() {
		return utm_medium;
	}
	public void setUtm_medium(String utm_medium) {
		this.utm_medium = utm_medium;
	}
	public String getUtm_compaign() {
		return utm_compaign;
	}
	public void setUtm_compaign(String utm_compaign) {
		this.utm_compaign = utm_compaign;
	}
	public String getUtm_content() {
		return utm_content;
	}
	public void setUtm_content(String utm_content) {
		this.utm_content = utm_content;
	}
	@Override
	public String toString() {
		return "utmInfo [utm_source=" + utm_source + ", utm_term=" + utm_term + ", utm_medium=" + utm_medium
				+ ", utm_compaign=" + utm_compaign + ", utm_content=" + utm_content + "]";
	}
	
}
