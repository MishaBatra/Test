package employee;
import java.util.Scanner;
class person
{
	String name,email;
	long contact;
	int date, month, year;
	person()
	{
		name="";
		email="";
		date=year=month=0;
		contact=0;
	}
	void accept()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("\n enter the following info of the employee:");
		System.out.println("\n enter the name of the employee:");
		name=s.next();
		System.out.println("\n enter the email id :");
		email=s.next();
		System.out.println("\n enter contact number:");
		contact=s.nextLong();
		do
		{
		System.out.println("\n enter birthdate:");
		date=s.nextInt();
		month=s.nextInt();
		year=s.nextInt();
		if(date>31 || month>12 || year>2000)
		{
			System.out.println("\n invalid content.");
			System.out.println("\n please re-enter the birthdate.");
			date=s.nextInt();
			month=s.nextInt();
			year=s.nextInt();
		}
	}while(date>31 && month>12 && year>2000);
}
	void display()
	{
		System.out.println("\n EMPLOYEE INFO :");
		System.out.println("\n NAME :\t"+name);
		System.out.println("\n EMAIL ID :\t"+email);
		System.out.println("\n CONTACT NUMBER :\t"+contact);
		System.out.println("\n BIRTHDATE :\t "+date+"-"+month+"-"+year);
	}
}
class employee extends person
{
	int empid,basic,gross,hra,da,ta;
	char grade;
	employee()
	{
		empid=basic=gross=hra=da=ta=0;
		grade='\0';
	}
	void accept()
	{
		super.accept();
		Scanner s=new Scanner(System.in);
		System.out.println("\n enter the employee id:");
		empid=s.nextInt();
		System.out.println("\n enter the employee grade:");
		grade=s.next().charAt(0);
	}
	void calc()
	{
		if(grade=='A')
		{
			basic=8000;
			ta=1000;
		}
		else if(grade=='B')
		{
			basic=7000;
			ta=800;
		}
		else if(grade=='C')
		{
			basic=6000;
			ta=600;
		}
		else if(grade=='D')
		{
			basic=5000;
			ta=400;
		}
		hra=basic/5;
		da=basic/2;
		gross=basic+hra+da+ta;
	}
	void display()
	{
		super.display();
		System.out.println("\n EMPLOYEE ID :\t"+empid);
		System.out.println("\n GRADE :\t"+grade);
		System.out.println("\n BASIC :\t"+basic);
		System.out.println("\n HRA :\t"+hra);
		System.out.println("\n DA :\t"+da);
		System.out.println("\n TA :\t"+ta);
		System.out.println("\n GROSS SALARY :\t"+gross);
		System.out.println("\n\n");
	}
	void display(employee[]a,char g,int n)
	{
//		Scanner s=new Scanner(System.in);
//		char g='\0';
//		employee empl=a[10];
		for(int i=0;i<n;i++)
		{
		  if(g==a[i].grade)
		  {
			  a[i].display();
		  }
		}
	}
}
public class emp 
{

	public static void main(String[] args)
	
	{
		Scanner s=new Scanner(System.in);
		int n=0;
		char g='\0';
		System.out.println("\n enter the number of employees:");
		n=s.nextInt();
		employee e[]=new employee[10];
		for(int i=0;i<n;i++)
		{
			e[i]=new employee();
			e[i].accept();
			e[i].calc();
		}
		
		for(int i=0;i<n;i++)
		{
			e[i].display();
		}
		System.out.println("\n enter the grade to display the employees:");
		g=s.next().charAt(0);
		e[0].display(e,g,n);
	}
}
