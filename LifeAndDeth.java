package hw4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class LifeAndDeth {

	public static void main(String[] args){
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new File("LifeDethProbability.txt"));
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + "LifeDethProbability.txt");
		}
		Random rand = new Random();
		double probability = 0.0;
		
		int count = 0;
		int age[] = new int[119];
		double man[] = new double[119];
		double woman[] = new double[119];
		while (inputStream.hasNextLine() && (count < 119))
		{
			if(count < 119)
			{
				if(count < 10)
				{
					String line = inputStream.nextLine();
					String[] array = line.split(" ");
					age[count] = Integer.parseInt(array[0]);
					man[count] = Double.parseDouble(array[2]);
					woman[count]= Double.parseDouble(array[3]);
					
				}
				else
				{
					String line = inputStream.nextLine();
					String[] array = line.split(" ");
					age[count] = Integer.parseInt(array[0]);
					man[count] = Double.parseDouble(array[1]);
					woman[count]= Double.parseDouble(array[2]);
				}
			}
			count++;
			
		}
		
		inputStream.close();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the age");
		int humanAge = 0;
		humanAge = keyboard.nextInt();
		while (humanAge < 0)
		{
			System.out.println("Enter the age, Again");
			humanAge = keyboard.nextInt();
		}
		String gender = null;
		System.out.println("Enter the gender (man, woman)");
		gender = keyboard.next();
		while( !gender.equals("woman") && !gender.equals("man") )
		{
			System.out.println("Enter the gender, Again(man, woman)");
			gender = keyboard.next();
		}
		
		boolean death = false;
		while(!death)
		{
			probability = rand.nextDouble();
			//System.out.println(probability);
			if(gender.equals("man"))
			{
				if(man[humanAge-1] > probability)
				{
					death = true;
				}
				else
				{
					System.out.println("Alive at "+humanAge);
					humanAge++;
				}
			}
			else
			{
				if(woman[humanAge-1] > probability)
				{
					death = true;
				}
				else
				{
					System.out.println("Alive at "+humanAge);
					humanAge++;
				}
			}
			
			
		}
		
		System.out.println("Death at "+humanAge);
		
		
		
	}

}
