import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	private String fname;
	private String lname;
	private String email;
	private ArrayList<Education> eduArray = new ArrayList<Education>();
	private ArrayList<Work> workArray = new ArrayList<Work>();
	private ArrayList<Skills> skillArray = new ArrayList<Skills>();
	public ArrayList<Education> getEduArray() {
		return eduArray;
	}
	public void setEduArray(ArrayList<Education> eduArray) {
		this.eduArray = eduArray;
	}
	public ArrayList<Work> getWorkArray() {
		return workArray;
	}
	public void setWorkArray(ArrayList<Work> workArray) {
		this.workArray = workArray;
	}
	public ArrayList<Skills> getSkillArray() {
		return skillArray;
	}
	public void setSkillArray(ArrayList<Skills> skillArray) {
		this.skillArray = skillArray;
	}
	Scanner sc = new Scanner(System.in);
public Person() //String name, String email
{
	//this.name=name;
	//this.email=email;
}
public String getBio(){
	System.out.println("Enter your first name: ");
	fname=sc.nextLine();
	System.out.println("Enter your last name: ");
	lname=sc.nextLine();
	System.out.println("Enter the email: ");
	email=sc.nextLine();
	return fname+"/"+lname+"/"+email;
	
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public void addEdu(Education e){
	eduArray.add(e);
}
public void addWork(Work w)
{
	workArray.add(w);
}
public void addSkill(Skills s)
{
	skillArray.add(s);
}
}
