

package ict.sci.kidslearning;

import java.util.Observable;


public class Comment  {
	private long id;
	private String comment;
	private String stud;
	private String clas;
	private String dat;
	private int score;
	private String roll;
	private String gen;

	private String _phone;
	private String _letter;
	private String _vocabulary;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSchool() {
		return comment;
	}

	public void setSchool(String comment) {
		this.comment = comment;
	}

	public String getStudent() {
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


	public String getDat() {
		return dat;
	}

	public void setDat(String dat) {
		this.dat = dat;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String clas) {
		this._phone = clas;
	}

	public String getLetter() {
		return _letter;
	}

	public void setLetter(String clas) {
		this._letter = clas;
	}

	public String get_vocabulary() {
		return _vocabulary;
	}

	public void set_vocabulary(String clas) {
		this._vocabulary = clas;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String rol) {
		this.roll = rol;
	}


	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}




	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return comment;
	}
}
