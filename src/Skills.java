import java.util.Scanner;

public class Skills {
private String skill;
Scanner sc = new Scanner(System.in);
public Skills(){
	
}
public Skills(String skill)
{
	this.skill=skill;
}
public String getSkill()
{
	System.out.println("Enter a skill: ");
	skill = sc.nextLine();
	return skill;
}
}
