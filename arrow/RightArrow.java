package arrow;

public class RightArrow extends ArrowBasic implements ArrowInterface{
	private int tailWidth;
	private int triangleWidth;
	
	public RightArrow()
	{
		super();
		tailWidth = 0;
		triangleWidth = 0;
	}
	
	public RightArrow(int theOffset, int newTailWidth, int newTriangleWidth)
	{
		super(theOffset);
		tailWidth = newTailWidth;
		triangleWidth = newTriangleWidth;
	}
	
	@Override
	public void setTriangle(int newWidth) {
		triangleWidth = newWidth;
	}

	@Override
	public void setTail(int newWidth) {
		tailWidth = newWidth;
	}

	public void drawHere()
	{
		drawRightArrow();
	}
	
	private void drawRightArrow() {
		for (int i = triangleWidth / 2; i >= 0; i--)
		{
			skipSpaces(getOffset());
			if (i != 0)
			{
				for (int k = 0; k < tailWidth; k++)
				{
					System.out.print(" ");
				}
			}
			else
			{
				for (int k = 0; k < tailWidth; k++)
				{
					System.out.print("*");
				}
			}
			System.out.print("*");
			if (i <= triangleWidth / 2 - 2)
			{
				for (int j = 0; j < triangleWidth / 2 - i - 1; j++)
				{
					System.out.print(" ");
				}
			}
			if (i != triangleWidth / 2)
			{
				System.out.print("*");
			}
			int temp = i;
			while (temp > 0)
			{
				System.out.print(" ");
				temp--;
			}
			
			System.out.println("");
		}

		for (int i = 1; i <= triangleWidth / 2; i++)
		{
			skipSpaces(getOffset());
			for (int m = 0; m < tailWidth; m++)
			{
				System.out.print(" ");
			}
			System.out.print("*");
			if (i <= triangleWidth / 2 - 2)
			{
				for (int k = 0; k < triangleWidth / 2 - i - 1; k++)
				{
					System.out.print(" ");
				}
			}
			if (i != triangleWidth / 2)
			{
				System.out.print("*");
			}
			int temp = i;
			while (temp > 0)
			{
				System.out.print(" ");
				temp--;
			}
			
			System.out.println("");
		}

		System.out.println("");
	}
	
	private static void skipSpaces(int number)
	{
		for(int count = 0; count < number; count++)
		{
			System.out.print(" ");
		}
	}
}
