import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class PersonApp {
public static void main(String[] args) {
	Person p = new Person();
	String bio = p.getBio();
	Scanner sc = new Scanner(System.in);
	String[] bioSplit = bio.split("/");
	String fname = bioSplit[0];
	String lname = bioSplit[1];
	String email = bioSplit[2];
	p.setFname(fname);
	p.setLname(lname);
	p.setEmail(email);
	int wCount=0;
	int eCount=0;
	int sCount=0;
	String sql=null;
	String sql2=null;
	String sql3=null;
	String sql5=null;
	System.out.println("Enter at least one education experience and less than 10. Enter 'n' to move on: ");
	String input=sc.nextLine();
	do{
		eCount++;
		Education e = new Education();
		String eduInstance = e.getEdu();
		String[] eduSplit = eduInstance.split("/");
		String degree = eduSplit[0];
		String school = eduSplit[1];
		String year = eduSplit[2];
		Education eUpdated = new Education(degree, school, year);
		if(!(eduInstance.equals("stop")))
			p.addEdu(eUpdated);
		System.out.println("Would you like to enter another educational experience? (y/n)");
		input = sc.nextLine();
	}while(eCount>0 && eCount<11 && (!(input.equals("n"))));
	//System.out.println(p.getEduArray());
	System.out.println("Enter no more than 10 work experiences. Enter 'n' to move on: ");
	input = sc.nextLine();
	do{
		wCount++;
		Work w = new Work();
		String workInstance = w.getWork();
		String[] wSplit = workInstance.split("/");
		String position = wSplit[0];
		String company = wSplit[1];
		String start = wSplit[2];
		String end = wSplit[3];
		String duties = wSplit[4];
		Work wUpdated = new Work(position, company, start, end, duties);
		if(!(workInstance.equals("n")))
			p.addWork(wUpdated);
		System.out.println("Would you like to enter another work experience? (y/n)");
		input = sc.nextLine();
	}while(wCount<11 && (!(input.equals("n"))));
	
	System.out.println("Enter at least one skill but no more than 20. ENter 'n' to stop: ");
	input=sc.nextLine();
	do{
		sCount++;
		Skills s = new Skills();
		Skills updatedSkill = new Skills(s.getSkill());
		if(!(s.getSkill().equals("n")))
			p.addSkill(updatedSkill);
		System.out.println("Would you like to enter another skill? (y/n)");
		input = sc.nextLine();
	}while(sCount<20 && sCount>0 && (!(input.equals("n"))));
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	sql = "insert into Person(FirstName,LastName,Email)values(?,?,?)";
	sql2 = "insert into Education(Degree,School,Year)values(?,?,?)";
	sql3 = "insert into Work(Position,Company,StartTime,EndTime,Duty1)values(?,?,?,?,?)";
	sql5 = "insert into Skills(SkillName)values(?)";

Connection con = null;
//ResultSet rs = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt2=null;
PreparedStatement pstmt3=null;
PreparedStatement pstmt5=null;
{
try{
	Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Resume?"+ "user=root&password=password");
    pstmt = con.prepareStatement(sql);
    
    pstmt.setString(1, fname);
    pstmt.setString(2, lname);
    pstmt.setString(3, email);
    pstmt.executeUpdate();
    for (int a=0; a<p.getEduArray().size();a++)
    {
    Education edu = p.getEduArray().get(a);
	pstmt2 = con.prepareStatement(sql2);
	pstmt2.setString(1, edu.getDegree());
	pstmt2.setString(2, edu.getSchool());
	pstmt2.setString(3, edu.getYear());
	pstmt2.executeUpdate();	
    }
    // The following for loop is used in the event that someone enters more than one school

	// I could not get the work code to function. I kept on getting a Null Pointer Exception and could not figure out why.
    for(int b=0; b<p.getWorkArray().size();b++)
    {
    	Work w = p.getWorkArray().get(b);
    	pstmt3 = con.prepareStatement(sql3);
    	pstmt3.setString(1, w.getPosition() );
    	pstmt3.setString(2, w.getCompany());
    	pstmt3.setString(3, w.getStart());
    	pstmt3.setString(4, w.getEnd());
    	pstmt3.setString(5, w.getDuties());
    	pstmt3.executeUpdate();
    }
    for(int c=0; c<p.getSkillArray().size();c++)
    {
    	Skills s = p.getSkillArray().get(c);
		pstmt5 = con.prepareStatement(sql5);
		pstmt5.setString(1, s.getSkill());
		pstmt5.executeUpdate();
    }
	
	}catch (SQLException e){

} catch (ClassNotFoundException e) 
{
	e.printStackTrace();
}finally {
	try {

		pstmt.close();
		pstmt2.close();
		pstmt3.close();
		pstmt5.close();
		con.close();
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
}
}
}
}
