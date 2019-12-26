package homework;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Goldbach extends JApplet{
	Random random = new Random();
	int problem = generate();
	boolean answer = false;
	int number1 = 0;
	int number2 = 0;
	
	private int generate()
	{
		int evenNumber = 2*((random.nextInt(9997)+4)/2);
		return evenNumber;
	}
	
	public boolean prime(int num)
	{
		boolean isPrime = true;
		forout:
		for(int n = 2; n < num; n++)
		{
			if (num % n == 0)
			{
				isPrime = false;
				break forout;
			}
		}
		
		return isPrime;
	}
	
	public void init()

	{
		setSize(400,300);
		JOptionPane.showMessageDialog(null, "The number is " + problem);
		
		String firstString =
				JOptionPane.showInputDialog("Enter the first number:");
		int firstNumber = Integer.parseInt(firstString);
		
		String secondString =
				JOptionPane.showInputDialog("Enter the first number:");
		int secondNumber = Integer.parseInt(secondString);
		
		
		
		for(int i = problem/2; i > 0; i--)
		{
			number1 = i;
			number2 = problem-i;
			if ( prime(number1) && prime(number2))
			{
				break;
			}
			
		}
		
		
		if (((firstNumber == number1)&&(secondNumber == number2))||((firstNumber == number2)&&(secondNumber == number1)))
		{
			answer = true;
		}

	}

	public void rigntAnswer(Graphics canvas) {
		super.paint(canvas);
		if (answer == true) {
			canvas.drawString("Solution is " + number1 + ", " + number2, 10, 20);
			canvas.setColor(Color.GREEN);
			canvas.fillOval(100, 50, 200, 200);
			canvas.setColor(Color.BLACK);
			canvas.fillOval(155, 100, 10, 20);
			canvas.fillOval(230, 100, 10, 20);
			canvas.drawArc(150,160,100,50,180,180);
		}		
	}
	
	public void wrongAnswer(Graphics canvas1) {
		super.paint(canvas1);
		if (answer == false) {
			canvas1.drawString("Solution is " + number1 + ", " + number2, 10, 20);
			canvas1.setColor(Color.RED);
			canvas1.fillOval(100, 50, 200, 200);
			canvas1.setColor(Color.BLACK);
			canvas1.fillOval(155, 100, 10, 20);
			canvas1.fillOval(230, 100, 10, 20);
			canvas1.drawArc(150,160,100,50,0,180);
		}
	}
}
