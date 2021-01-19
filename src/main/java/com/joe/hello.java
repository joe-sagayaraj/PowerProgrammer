package main.java.com.joe;
import java.util.*;

class Student{
	int marks;
	String name;
	Double rating;
	Float height;
	Student(int marks,String name,double rating, float height)
	{
		this.marks=marks;
		this.name=name;
		this.rating=rating;
		this.height=height;
	}
	public String toString()
	{
		return this.name+" : "+this.marks+" : "+this.rating+" : "+this.height;
	}

}

class studentComparator implements Comparator<Student>
{
	private String field;
	private boolean ascending;
	public studentComparator(String field)
	{
		this.field=field;
	}
	public studentComparator(String field,boolean ascending)
	{
		this.field=field;
		this.ascending=ascending;
	}
	
	

	@Override
	public int compare(Student o1, Student o2) {
		
		// TODO Auto-generated method stub
		if(field.equalsIgnoreCase("marks"))
		{
			if(ascending)
				return o1.marks-o2.marks;
		
			return o2.marks-o1.marks;
		}
		else if(field.equalsIgnoreCase("rating"))
		{
			if(ascending)
				return o1.rating.compareTo(o2.rating);
			return o2.rating.compareTo(o1.rating);
		}
		else if(field.equalsIgnoreCase("height"))
		{
			if(ascending)
				return o1.height.compareTo(o2.height);
			return o2.height.compareTo(o1.height);
		}
		else
		{
			if(ascending)
				
			return o1.name.compareToIgnoreCase(o2.name);
			return o2.name.compareToIgnoreCase(o1.name);
		}
		
	}
	
}







public class hello {
		
	
	public static void main(String[] args) {
	
		Student[] stud = new Student[6];
		stud[0]=new Student(10,"Joe",5.5,6.3f);
		stud[1]=new Student(20,"Meriza",2.0,5.5f);
		stud[2]=new Student(30,"Jafita",1.0,3.5f);
		stud[3]=new Student(40,"Marwin",2.5,2.5f);
		stud[4]=new Student(10,"Alphonse",7.8,5.5f);
		stud[5]=new Student(10,"Amala",3.5,5.5f);
		sortStudents(stud,"height",false);
	}
	
	
	static void sortStudents(Student[] stud, String orderBy,boolean ascending)
	{
		List<Student> studentList = Arrays.asList(stud);
		Collections.sort(studentList, new studentComparator(orderBy,ascending));
		studentList.stream().filter(student->student.height>=2.0f).forEach(student->System.out.println(student.toString()));
	}
	
	
	
	
	
	
	
	

}
