import java.util.Scanner;

public class Education {
private String degree;
private String school;
private String year;
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
Scanner sc = new Scanner(System.in);

public Education()
{
	
}
public Education(String degree, String school, String year)
{
	this.degree=degree;
	this.school=school;
	this.year=year;
}
public String getEdu()
{
	System.out.println("Enter a degree: ");
	String degree = sc.nextLine();
	System.out.println("Enter the school that you graduated from: ");
	String school = sc.nextLine();
	System.out.println("Enter the year you graduated: ");
	String gradYear = sc.nextLine();
	
	return(degree+"/"+school+"/"+gradYear);
}
}
