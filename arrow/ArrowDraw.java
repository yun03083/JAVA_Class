package arrow;

import java.util.Scanner;

public class ArrowDraw {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int offset = 0;
		int tail = 0;
		int width = 0;
		try {
			System.out.println("Please Input Offset(Positive integer)");
			offset = keyboard.nextInt();
			System.out.println("Please Input the length of tail(Positive integer)");
			tail = keyboard.nextInt();
			System.out.println("Please Input the ArrowSize(Positive integer and Odd Number)");
			width = keyboard.nextInt();
			while(width%2 == 0)
			{
				System.out.println("Please Input the ArrowSize Again (Positive integer and Odd Number)");
				width = keyboard.nextInt();
			}
			throw new Exception();
		}catch(Exception e){
			System.out.println("Not positive integer");
		}

		drawTwoArrow(offset, tail, width);
		
	}

	public static void drawTwoArrow(int offset, int tail, int width)
	{
		ArrowInterface arrowLeft = new LeftArrow(offset,tail,width);
		arrowLeft.drawHere();
		ArrowInterface arrowRight = new RightArrow(offset,tail,width);
		arrowRight.drawHere();
	}
}
