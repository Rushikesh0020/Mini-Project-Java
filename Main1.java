import java.util.*; 
import java.lang.*; 


class info_student
{
     int rollNumber,grno;
	 public	String name,dept,password;
		
		
	   	Scanner sc=new Scanner(System.in);
        info_student()
	    {
	    	name="";
		    dept="";
		    password="";
		    rollNumber=0;
		    grno=0;
		  
	   }
    
    	
	public void create()
	  {
        System.out.println("\n********************************");
	    System.out.println("Enter GR number:");
        grno=sc.nextInt();
        sc.nextLine();//to avoid error 
	    System.out.println("Enter password:");
        password=sc.nextLine();
        
		System.out.println("Enter name:");
		name=sc.nextLine();
		System.out.println("Enter Department:");
	    dept=sc.nextLine();
	     
	     
		System.out.println("Enter Roll number:");
        rollNumber=sc.nextInt();
        sc.nextLine();
	
	  }

	public void display()
	  {
		System.out.println("");
		System.out.println("name="+name);
		System.out.println("Department="+dept);
		System.out.println("Rollno="+rollNumber);
		System.out.println("Grno="+grno);
		
	        
	  }

    public int search(final int number) {
        if (this.grno == number) {
            return 1;
        } else
            return 0;
    }

    public int password(final String pass) {
        if (this.password == pass)
            ;
        {
            return 1;
        }

    }
}

class Administrator extends studentdata {
    public String contactno;
    public double chemistry;
    public double maths;
    public double physics;
    public double percentage;

    int ch, i, j, p, key, gr;
    int n = 0;
    String px;
    Scanner sc = new Scanner(System.in);
    Administrator a[] = new Administrator[20];

    public void create1() {
        super.create();
      
        System.out.println("Enter contact no:");
        contactno = sc.nextLine();
        System.out.println("Enter Maths Marks:");
        maths = sc.nextDouble();
        System.out.println("Enter Chemistry Marks:");
        chemistry = sc.nextDouble();
        System.out.println("Enter Physics Marks:");
        physics = sc.nextDouble();
        sc.nextLine();

    }

    public void display1() {
        super.display();
        System.out.println("contact no:" + contactno);
        System.out.println("Maths:" + maths);
        System.out.println("Chemistry:" + chemistry);
        System.out.println("Physics:" + physics);
        percentage = (maths + chemistry + physics) / 3;
        System.out.println("--------------------------");
        System.out.println("Percentage:" + percentage);

    }

    public void menu() {
        do {
            System.out.println(
                    "\n1.Create\n2.Display all Record\n3.search specific Record\n4.Modify Record\n5.Delete Record\n6.Add new entry\n7.EXIT");
            System.out.println("Enter your choice");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("How many record you want to add ::");
                    n = sc.nextInt();
                    for (i = 1; i <= n; i++) {
                        a[i] = new Administrator();
                        System.out.println("Record:" + i);

                        a[i].create1();
                        
                    }
                    break;

                case 2:
                    for (i = 1; i <= n; i++) {
                        System.out.print("Record:" + i);
                        System.out.println("\n********************************");
                        a[i].display1();
                    }
                    break;

                case 3:
                    System.out.println("Enter Gr number of Student you want to search ::");
                    key = sc.nextInt();
                    int flag = 0;
                    for (i = 1; i <= n; i++) {
                        if (a[i].search(key) == 1) {
                            System.out.println("Record found!!!");
                            a[i].display1();
                            flag = 1;
                        }

                    }
                    if (flag == 0) {
                        System.out.println("Record not found!!!");
                    }
                    break;

                case 4:
                    System.out.println("Enter GR number of Student to modify ::");
                    key = sc.nextInt();
                    int flag1 = 0;
                    for (i = 1; i <= n; i++) {
                        if (a[i].search(key) == 1) {

                            System.out.println("Record found");
                            flag1 = 1;
                            a[i].create1();
                            a[i].display1();
                        }

                    }
                    if (flag1 == 0) {
                        System.out.println("Record not found");
                    }

                    break;
                case 5:
                    System.out.println("Enter grno of the student to delete ::");
                    key = sc.nextInt();
                    int flag2 = 0;
                    for (i = 1; i <= n; i++) {
                        if (a[i].search(key) == 1) {
                            System.out.println("Record found");
                            a[i] = a[i + 1];
                            System.out.println("Record Deleted");
                            flag2 = 1;
                        }
                    }
                    if (flag2 == 0) {
                        System.out.println("Record not found");
                    } else {
                        n--;
                    }
                    break;

                case 6:
                    for (i = n + 1; i <= n + 1; i++) {
                        a[i] = new Administrator();
                        System.out.println("Record:" + i);
                        a[i].create1();
                    }
                    n++;
                    break;

                case 7:
            }

            System.out.println("Do you want to continue 1/0:");
            p=sc.nextInt();
        } while (p==1);// do while
    }

    public void student() {
        System.out.println("Enter your gr no to see profile ::");
        gr = sc.nextInt();
        int flag1 = 0;
        for (i = 1; i <= n; i++) {
            if (a[i].search(gr) == 1) {
                System.out.println("Record found!!!!");
                System.out.println("Enter your password ::");
                px = sc.next();
                flag1 = 1;
                if (a[i].password(px) == 1) {
                    a[i].display1();
                }
            }
        }
        if (flag1 == 0) {

            System.out.println("RECORD NOT FOUND!!!!");
        }
    }// student closed
}// class Administrator closed

public class Main1 {
    public static void main(final String args[]) {
        int choice;
        int p;
        Administrator obj = new Administrator();
         Scanner sc = new Scanner(System.in);

         System.out.println("****************STUDENT DATA MANAGEMENT SYSTEM****************\n"); 
		do
		{
            System.out.println("**************************************************************");
			System.out.println("\n1.Administrator\n2.Student");
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice)
			 {
			    case 1:
				 obj.menu();
				break;
			    case 2:
                obj.student();
                break;
               case 99:System.exit(0);
            //    RUSHIKESH PATIL-232046                                 USMAN GANI-232040                                 REHAN QURESHI-232051                                 GARGI PATIL-232045

               break;
                default:System.out.println("Invalid Choice\n");
                break;             
             }
             System.out.println("press 1 to continue");
             p=sc.nextInt();
		    } while(p==1);
		sc.close();
		}//main closed
}//main class closed
/*

****************STUDENT DATA MANAGEMENT SYSTEM****************

**************************************************************

1.Administrator
2.Student
Enter your choice
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
1
How many record you want to add ::
3
Record:1

********************************
Enter GR number
21810558
Enter password
pass1
Enter name
Rehan 
Enter Department
IT
Enter Roll number
232051
Enter contact no:
9922334455
Enter Maths Marks:
80
Enter Chemistry Marks:
90
Enter Physics Marks:
100
Record:2

********************************
Enter GR number
21810500
Enter password
pass2
Enter name
Gargi
Enter Department
Comp
Enter Roll number
232045
Enter contact no:
7722334455
Enter Maths Marks:
100
Enter Chemistry Marks:
80
Enter Physics Marks:
90
Record:3

********************************
Enter GR number
21810663
Enter password
pass3
Enter name
Usman
Enter Department
Entc  
Enter Roll number
232037
Enter contact no:
9123456789
Enter Maths Marks:
95
Enter Chemistry Marks:
100
Enter Physics Marks:
92
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
2
Record:1
********************************

name=Rehan
Department=IT
Rollno=232051
Grno=21810558
contact no:9922334455
Maths:80.0
Chemistry:90.0
Physics:100.0
--------------------------
Percentage:90.0
Record:2
********************************

name=Gargi
Department=Comp
Rollno=232045
Grno=21810500
contact no:7722334455
Maths:100.0
Chemistry:80.0
Physics:90.0
--------------------------
Percentage:90.0
Record:3
********************************

name=Usman
Department=Entc
Rollno=232037
Grno=21810663
contact no:9123456789
Maths:95.0
Chemistry:100.0
Physics:92.0
--------------------------
Percentage:95.66666666666667
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
3
Enter Gr number of Student you want to search ::
21810500
Record found!!!

name=Gargi
Department=Comp
Rollno=232045
Grno=21810500
contact no:7722334455
Maths:100.0
Chemistry:80.0
Physics:90.0
--------------------------
Percentage:90.0
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
4
Enter GR number of Student to modify ::
21810558
Record found

********************************
Enter GR number
21810558
Enter password
pass4
Enter name
Rushikesh Patil
Enter Department
IT
Enter Roll number
232046
Enter contact no:
7755668899
Enter Maths Marks:
90
Enter Chemistry Marks:
90
Enter Physics Marks:
90

name=Rushikesh Patil
Department=IT
Rollno=232046
Grno=21810558
contact no:7755668899
Maths:90.0
Chemistry:90.0
Physics:90.0
--------------------------
Percentage:90.0
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
2
Record:1
********************************

name=Rushikesh Patil
Department=IT
Rollno=232046
Grno=21810558
contact no:7755668899
Maths:90.0
Chemistry:90.0
Physics:90.0
--------------------------
Percentage:90.0
Record:2
********************************

name=Gargi
Department=Comp
Rollno=232045
Grno=21810500
contact no:7722334455
Maths:100.0
Chemistry:80.0
Physics:90.0
--------------------------
Percentage:90.0
Record:3
********************************

name=Usman
Department=Entc
Rollno=232037
Grno=21810663
contact no:9123456789
Maths:95.0
Chemistry:100.0
Physics:92.0
--------------------------
Percentage:95.66666666666667
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
5
Enter grno of the student to delete ::
21810558
Record found
Record Deleted
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
2
Record:1
********************************

name=Gargi
Department=Comp
Rollno=232045
Grno=21810500
contact no:7722334455
Maths:100.0
Chemistry:80.0
Physics:90.0
--------------------------
Percentage:90.0
Record:2
********************************

name=Usman
Department=Entc
Rollno=232037
Grno=21810663
contact no:9123456789
Maths:95.0
Chemistry:100.0
Physics:92.0
--------------------------
Percentage:95.66666666666667
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
6
Record:3

********************************
Enter GR number
21810999
Enter password
pass5
Enter name
Rehan Qureshi
Enter Department
Civil
Enter Roll number
232051
Enter contact no:
9955223388
Enter Maths Marks:
95
Enter Chemistry Marks:
98
Enter Physics Marks:
78
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
2
Record:1
********************************

name=Gargi
Department=Comp
Rollno=232045
Grno=21810500
contact no:7722334455
Maths:100.0
Chemistry:80.0
Physics:90.0
--------------------------
Percentage:90.0
Record:2
********************************

name=Usman
Department=Entc
Rollno=232037
Grno=21810663
contact no:9123456789
Maths:95.0
Chemistry:100.0
Physics:92.0
--------------------------
Percentage:95.66666666666667
Record:3
********************************

name=Rehan Qureshi
Department=Civil
Rollno=232051
Grno=21810999
contact no:9955223388
Maths:95.0
Chemistry:98.0
Physics:78.0
--------------------------
Percentage:90.33333333333333
Do you want to continue 1/0:
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
2
Record:1
********************************

name=Gargi
Department=Comp
Rollno=232045
Grno=21810500
contact no:7722334455
Maths:100.0
Chemistry:80.0
Physics:90.0
--------------------------
Percentage:90.0
Record:2
********************************

name=Usman
Department=Entc
Rollno=232037
Grno=21810663
contact no:9123456789
Maths:95.0
Chemistry:100.0
Physics:92.0
--------------------------
Percentage:95.66666666666667
Record:3
********************************

name=Rehan Qureshi
Department=Civil
Rollno=232051
Grno=21810999
contact no:9955223388
Maths:95.0
Chemistry:98.0
Physics:78.0
--------------------------
Percentage:90.33333333333333
Do you want to continue 1/0:
0
press 1 to continue
1
**************************************************************

1.Administrator
2.Student
Enter your choice
1

1.Create
2.Display all Record
3.search specific Record
4.Modify Record
5.Delete Record
6.Add new entry
7.EXIT
Enter your choice
7
Do you want to continue 1/0:
0
press 1 to continue
1
**************************************************************

1.Administrator
2.Student
Enter your choice
2
Enter your gr no to see profile ::
21810663
RECORD NOT FOUND!!!!
press 1 to continue
1
**************************************************************

1.Administrator
2.Student
Enter your choice
2
Enter your gr no to see profile ::
21810999
Record found!!!!
Enter your password ::
pass5

name=Rehan Qureshi
Department=Civil
Rollno=232051
Grno=21810999
contact no:9955223388
Maths:95.0
Chemistry:98.0
Physics:78.0
--------------------------
Percentage:90.33333333333333
press 1 to continue
 */