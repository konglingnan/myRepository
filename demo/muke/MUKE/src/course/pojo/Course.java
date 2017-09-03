package course.pojo;

import java.io.Serializable;

public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String course_id;
	private String course_name;
	private String course_rank;	
	private String course_direction;
	private String course_description;
	private String course_classification;
	private String course_studyTime;
	private String course_progress;
	private String course_studyNum;
	
	
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name="
				+ course_name + ", course_rank=" + course_rank
				+ ", course_direction=" + course_direction
				+ ", course_description=" + course_description
				+ ", course_classification=" + course_classification
				+ ", course_studyTime=" + course_studyTime
				+ ", course_progress=" + course_progress + ", course_studyNum="
				+ course_studyNum + ", getCourse_id()=" + getCourse_id()
				+ ", getCourse_name()=" + getCourse_name()
				+ ", getCourse_rank()=" + getCourse_rank()
				+ ", getCourse_direction()=" + getCourse_direction()
				+ ", getCourse_description()=" + getCourse_description()
				+ ", getCourse_classification()=" + getCourse_classification()
				+ ", getCourse_studyTime()=" + getCourse_studyTime()
				+ ", getCourse_progress()=" + getCourse_progress()
				+ ", getCourse_studyNum()=" + getCourse_studyNum() + "]";
	}
	public Course(String course_name, String course_rank,
			String course_direction, String course_description,
			String course_classification, String course_studyTime,
			String course_progress, String course_studyNum) {
		super();
		this.course_name = course_name;
		this.course_rank = course_rank;
		this.course_direction = course_direction;
		this.course_description = course_description;
		this.course_classification = course_classification;
		this.course_studyTime = course_studyTime;
		this.course_progress = course_progress;
		this.course_studyNum = course_studyNum;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_rank() {
		return course_rank;
	}
	public void setCourse_rank(String course_rank) {
		this.course_rank = course_rank;
	}
	public String getCourse_direction() {
		return course_direction;
	}
	public void setCourse_direction(String course_direction) {
		this.course_direction = course_direction;
	}
	public String getCourse_description() {
		return course_description;
	}
	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}
	public String getCourse_classification() {
		return course_classification;
	}
	public void setCourse_classification(String course_classification) {
		this.course_classification = course_classification;
	}
	public String getCourse_studyTime() {
		return course_studyTime;
	}
	public void setCourse_studyTime(String course_studyTime) {
		this.course_studyTime = course_studyTime;
	}
	public String getCourse_progress() {
		return course_progress;
	}
	public void setCourse_progress(String course_progress) {
		this.course_progress = course_progress;
	}
	public String getCourse_studyNum() {
		return course_studyNum;
	}
	public void setCourse_studyNum(String course_studyNum) {
		this.course_studyNum = course_studyNum;
	}

}
