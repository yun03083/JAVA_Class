package hw2;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework extends JApplet implements ActionListener{

	public static int LINES = 5;
	public static int CHAR_PER_LINE = 40;
	private JTextArea theText;
	String[] prepareArray = new String[100];
	int count = 0;
	int value = 0;
	
	public void init() {
		setSize(1000,300);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel instructions = new JLabel("Enter the numbers.");
		contentPane.add(instructions);
		
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(this);
		contentPane.add(enterButton);
		
		JButton resultButton = new JButton("Result");
		resultButton.addActionListener(this);
		contentPane.add(resultButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		contentPane.add(resetButton);
		
		theText = new JTextArea(LINES, CHAR_PER_LINE);
		contentPane.add(theText);
	}
	
	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();
		
		if(actionCommand.contentEquals("Enter"))
		{
			prepareArray[count] = theText.getText();
			count++;
			theText.setText("");
		}
		else if(actionCommand.equals("Result"))
		{
			String[] playArray = new String[count];
			for(int i=0; i<count;i++) {
				playArray[i] = prepareArray[i];
			}
			String first = Arrays.toString(playArray);
			String temp = null;
			String str=null;
			int StringValue=0;
			for(int i = 0; i<count;i++) {
				for(int j = 0; j< count-1; j++) {
					temp = playArray[j];
					playArray[j]=playArray[j+1];
					playArray[j+1] = temp;
					
					str = String.join("", playArray);
					StringValue = Integer.parseInt(str,10);
					if(value<StringValue) {
						value = StringValue;
					}
				}
			}
			theText.setText("Input numbers are "+first+"\n"+"The result is "+value+"\n");
		}
		else if(actionCommand.equals("Reset"))
		{
			count = 0;
			value = 0;
			Arrays.fill(prepareArray, null);
			theText.setText("");
		}
		else
		{
			theText.setText("Error: Only one number please");
		}
	}
}
