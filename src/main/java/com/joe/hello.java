package main.java.com.joe;
import java.util.*;

class Student{
	int marks;
	String name;
	Student(int marks,String name)
	{
		this.marks=marks;
		this.name=name;
	}
	public String toString()
	{
		return this.name+" : "+this.marks;
	}

}

class studentComparator implements Comparator<Student>
{
	private String field;
	public studentComparator(String field)
	{
		this.field=field;
	}
	
	

	//@Override
	public int compare(Student o1, Student o2) {
		
		// TODO Auto-generated method stub
		if(field.equalsIgnoreCase("marks"))
		{
		if(o1.marks>o2.marks)
			return -1;
		else if(o1.marks<o2.marks)
			return 1;
		else
			return o1.name.compareToIgnoreCase(o2.name);
		}
		else
		return 0;
		
	}
	
}







public class hello {
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Joe";
		System.out.println("Name is"+name);
		//test(123);
		
		Student[] stud = new Student[6];
		stud[0]=new Student(10,"Joe");
		stud[1]=new Student(20,"Meriza");
		stud[2]=new Student(30,"Jafita");
		stud[3]=new Student(40,"Marwin");
		stud[4]=new Student(10,"Alphonse");
		stud[5]=new Student(10,"Amala");
		orderStudents(stud,"marks");
		//stud.
		//int[] inte= new int[10];
	}
	
	
	static void orderStudents(Student[] stud, String orderBy)
	{
		PriorityQueue<Student> pq = new PriorityQueue<Student>(new studentComparator(orderBy));
		for(Student student: stud)
		{
			pq.offer(student);
		}
		
		while(!pq.isEmpty())
		{
			//pq.
			System.out.println(pq.poll().toString());
		}
	}
	
	
	
	
	
	
	
	

}
