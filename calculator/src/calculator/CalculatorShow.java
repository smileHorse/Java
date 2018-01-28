package calculator;

import java.awt.*;
import java.io.*;
import javax.swing.*;

import calculator.CalculatorPanel;

public class CalculatorShow {

	public static void main(String args[])
	{
		EventQueue.invokeLater(() -> {			
			JFrame frame = new JFrame();
			CalculatorPanel panel = new CalculatorPanel();
			frame.add(panel);
			frame.setSize(300, 400);
			frame.setTitle("Calculator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
