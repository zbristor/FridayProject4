import java.util.Scanner;

public class Work {
private String position;

private String company;
private String start;
private String end;
private String duties;
Scanner sc = new Scanner(System.in);
public Work()
{
	
}
public Work(String position, String company, String start, String end, String duties)
{
	this.position=position;
	this.company=company;
	this.start=start;
	this.end=end;
	this.duties=duties;
}
public String getWork()
{
	System.out.println("Enter the position: ");
	position=sc.nextLine();
	System.out.println("Enter the company: ");
	company=sc.nextLine();
	System.out.println("Enter the start date: ");
	start=sc.nextLine();
	System.out.println("Enter the end date: ");
	end=sc.nextLine();
	System.out.println("Enter your duties: ");
	duties=sc.nextLine();
	return position+"/"+company+"/"+start+"/"+end+"/"+duties;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getStart() {
	return start;
}
public void setStart(String start) {
	this.start = start;
}
public String getEnd() {
	return end;
}
public void setEnd(String end) {
	this.end = end;
}
public String getDuties() {
	return duties;
}
public void setDuties(String duties) {
	this.duties = duties;
}
}
