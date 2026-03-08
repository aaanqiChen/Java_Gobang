package gobang_upgrade;

import java.io.Serializable;

public class User implements Serializable{
private String name;
private int id;
private int password;
private  int gender;
@Override
public String toString() {
	return "User [name=" + name + ", id=" + id + ", password=" + password + ", gender=" + gender + ", score=" + score
			+ ", level=" + level + "]";
}
private int score;
private int level;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public int getGender() {
	return gender;
}
public void setGender(int gender) {
	this.gender = gender;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public User(String name, int id, int password, int gender, int score, int level) {
	super();
	this.name = name;
	this.id = id;
	this.password = password;
	this.gender = gender;
	this.score = score;
	this.level = level;
}
public User() {}
}
