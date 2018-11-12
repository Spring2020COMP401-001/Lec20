package lec20.v08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

public class CalculatorController implements ActionListener, CalculatorObserver {

	CalculatorModel model;
	CalculatorView view;

	boolean start_of_number;
	boolean point_pressed;
	Operation.OpType in_progress;

	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;

		view.addActionListener(this);

		start_of_number = true;
		point_pressed = false;
		view.setDisplay("0");
		in_progress = Operation.OpType.SET;

		model.addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		char button_char = button.getText().charAt(0);
		
		// Catch the case where button_char is '+'
		// because of the inversion operation rather
		// than addition. Use 'i' instead for
		// inversion.
		
		if (button.getText().equals("+/-")) {
			button_char = 'i';
		}

		switch (button_char) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			
			// Any digit, including zero, is possible if 
			// we are starting a new number.
			if (start_of_number) {
				view.setDisplay(Character.toString(button_char));
				start_of_number = false;
			} else {
				// Already started a number. If the number started is
				// zero, allow non-zero digit to replace it. Otherwise,
				// append new digit to what is already on display.
				
				if (view.getDisplay().equals("0")) {
					if (button_char != '0') {
						view.setDisplay(Character.toString(button_char));
					}
				} else {
					view.appendToDisplay(Character.toString(button_char));
				}
			}
			break;

		case '.':
			if (start_of_number) {
				view.setDisplay("0.");
				start_of_number = false;
			} else if (!point_pressed) {
				view.appendToDisplay(".");
			}
			point_pressed = true;
			break;

		case '+':
		case '-':
		case '/':
		case '*':
		case '=':
			
			// Evaluate the current operation if we are not at the
			// start of a number. If we are at the start of a number
			// don't evaluate current operation thus allowing a 
			// new operation to replace current operation.
			
			if (!start_of_number) {
				double disp_value = Double.parseDouble(view.getDisplay());
				model.eval(new Operation(in_progress, disp_value));
			}
			start_of_number = true;
			point_pressed = false;
			switch (button_char) {
			case '+':
				in_progress = Operation.OpType.ADD; break;
			case '-':
				in_progress = Operation.OpType.SUB; break;				
			case '/':
				in_progress = Operation.OpType.DIV; break;
			case '*':
				in_progress = Operation.OpType.MULT; break;			
			case '=':
				in_progress = Operation.OpType.SET;
				
				// Go ahead evaluate the set operation since it
				// does not depend on the next number. 
				
				model.eval(new Operation(in_progress, model.getValue()));
				break;
			}
			break;

		case 'i':
			// Handle inversion button
			// If what is in display is equivalent to 0, then
			// don't do anything. Otherwise, look for leading
			// negative sign and either remove if there or
			// prepend it if not.
			if (Double.parseDouble(view.getDisplay()) != 0) {
				String in_display = view.getDisplay();
				if (in_display.charAt(0) != '-') {
					view.setDisplay("-" + in_display);
				} else {
					view.setDisplay(in_display.substring(1));
				}
			}
			break;
		}
	}

	@Override
	public void update(CalculatorModel calc, Operation op) {
		view.appendToTape(op.toString() + "\n");
		view.setDisplay(Double.toString(model.getValue()));
	}
}
