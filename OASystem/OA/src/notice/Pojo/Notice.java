package notice.Pojo;



import java.sql.Date;


public class Notice {
	
    public Notice(int notice_id, String title, String content) {
		super();
		this.notice_id = notice_id;
		this.title = title;
		this.content = content;
	}

	private int notice_id;
	
	private String title;
	
	private String content;
	
	private Date notice_time;

	public Notice() {
		super();
	}

	public Notice(int notice_id, String title, String content,Date notice_time) {
		super();
		this.notice_id = notice_id;
		this.title = title;
		this.content = content;
		this.notice_time = notice_time;
	}



	public Notice(String title, String content, Date notice_time) {
		super();
		this.title = title;
		this.content = content;
		this.notice_time = notice_time;
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getNotice_time() {
		return notice_time;
	}

	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}

	@Override
	public String toString() {
		return "notice [notice_id=" + notice_id + ", title=" + title + ", content="
				+ content + ",notice_time="+ notice_time +"]";
	}
	

}
