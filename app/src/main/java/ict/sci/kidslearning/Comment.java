

package ict.sci.kidslearning;

import java.util.Observable;


public class Comment  {
	private long id;
	private String comment;
	private String stud;
	private String clas;
	private String roll;




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setSchool(String comment) {
		this.comment = comment;
	}

	public String getSchool() {
		return stud;
	}

	public void setStudent(String stu) {
		this.stud = stu;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getRoll() {
		return comment;
	}

	public void setRoll(String rol) {
		this.roll = rol;
	}




	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return comment;
	}
}
