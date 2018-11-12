package lec20.v09;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView();
		CalculatorController controller = new CalculatorController(model, view);
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("MVC Calculator");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main_frame.setContentPane(view);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}
