package community.pojo;

public class Question {
	private String question_id;
	private String question_user;
	private String question_title;
	private String question_time;
	private String question_label;
	private String question_num;
	private String question_new;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(String question_id, String question_user, String question_title, String question_time,
			String question_label, String question_num, String question_new) {
		super();
		this.question_id = question_id;
		this.question_user = question_user;
		this.question_title = question_title;
		this.question_time = question_time;
		this.question_label = question_label;
		this.question_num = question_num;
		this.question_new = question_new;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getQuestion_user() {
		return question_user;
	}

	public void setQuestion_user(String question_user) {
		this.question_user = question_user;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public String getQuestion_time() {
		return question_time;
	}

	public void setQuestion_time(String question_time) {
		this.question_time = question_time;
	}

	public String getQuestion_label() {
		return question_label;
	}

	public void setQuestion_label(String question_label) {
		this.question_label = question_label;
	}

	public String getQuestion_num() {
		return question_num;
	}

	public void setQuestion_num(String question_num) {
		this.question_num = question_num;
	}

	public String getQuestion_new() {
		return question_new;
	}

	public void setQuestion_new(String question_new) {
		this.question_new = question_new;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question_user=" + question_user + ", question_title="
				+ question_title + ", question_time=" + question_time + ", question_label=" + question_label
				+ ", question_num=" + question_num + ", question_new=" + question_new + "]";
	}


}
