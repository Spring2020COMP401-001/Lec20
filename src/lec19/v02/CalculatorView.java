package lec19.v02;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CalculatorView extends JPanel {
	
	private JTextArea tape;
	private JLabel display;
	private JPanel button_panel;
	
	public CalculatorView() {
		setLayout(new BorderLayout());
		
		tape = new JTextArea(10,20);
		tape.setEditable(false);
		add(tape, BorderLayout.CENTER);
		
		JPanel subpanel = new JPanel();
		subpanel.setLayout(new BorderLayout());
		
		display = new JLabel("0");
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		subpanel.add(display, BorderLayout.NORTH);

		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(5,4));

		// First row of buttons

		button_panel.add(new JButton("7"));
		button_panel.add(new JButton("8"));
		button_panel.add(new JButton("9"));
		button_panel.add(new JButton("+"));

		// Second row of buttons

		button_panel.add(new JButton("4"));
		button_panel.add(new JButton("5"));
		button_panel.add(new JButton("6"));
		button_panel.add(new JButton("-"));

		// Third row of buttons

		button_panel.add(new JButton("1"));
		button_panel.add(new JButton("2"));
		button_panel.add(new JButton("3"));
		button_panel.add(new JButton("*"));

		// Fourth row of buttons
		
		button_panel.add(new JButton("."));
		button_panel.add(new JButton("0"));
		button_panel.add(new JButton("+/-"));
		button_panel.add(new JButton("/"));

		// Fifth row of buttons
		
		button_panel.add(new JButton("C"));
		button_panel.add(new JButton("CE"));
		button_panel.add(new JButton("CT"));
		button_panel.add(new JButton("="));

		subpanel.add(button_panel, BorderLayout.SOUTH);
		
		add(subpanel, BorderLayout.SOUTH);
	}

}
