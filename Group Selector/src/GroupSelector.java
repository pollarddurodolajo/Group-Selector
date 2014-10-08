import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
		
public class GroupSelector
	{
	static ArrayList<Student> school = new ArrayList<Student>();
	static int numberOfGroups;
	public static void main(String[] args) throws IOException
		{
		Scanner classRoster = new Scanner( new File("classroster.txt"));
		
		int classSize = classRoster.nextInt();
		
		for (int i = 0; i < classSize; i++)
			{
			String firstName = classRoster.next();
			String lastName = classRoster.next();
			double score = classRoster.nextDouble();
			int groupNumber = 0;
			school.add(new Student(firstName, lastName, score, groupNumber));
			}
		
		Scanner userInput1 = new Scanner(System.in);
		System.out.println("How many groups do you want?");
		numberOfGroups = userInput1.nextInt();
		
		Collections.sort(school, new ScoreSorter());
		
		for (int i = 0; i < classSize; i++)
			{
			int group = 0;
			school.get(i).setGroupNumber(group);
			if(group < numberOfGroups)
				{
				group++;
				}
			else
				{
				group = 1;
				}
			}
		Collections.sort(school, new NameSorter());
		}

	}
