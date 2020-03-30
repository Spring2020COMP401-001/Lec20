package lec20.v08;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {

	private List<Operation> history;
	private List<CalculatorObserver> observers;
	private double value;

	public CalculatorModel() {
		history = new ArrayList<Operation>();
		observers = new ArrayList<CalculatorObserver>();

		value = 0.0;
	}

	public double getValue() {
		return value;
	}
	
	public void eval(Operation op) {
		history.add(op);
		
		switch (op.getType()) {
		case ADD:
			value += op.getOperand();
			break;
		case SUB:
			value -= op.getOperand();
			break;
		case MULT:
			value *= op.getOperand();
			break;
		case DIV:
			value /= op.getOperand();
			break;
		case SET:
			value = op.getOperand();
			break;
		}
		
		notifyObservers(op);
	}
	
	public void reset() {
		history = new ArrayList<Operation>();
		value = 0.0;
	}
	
	public void addObserver(CalculatorObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(CalculatorObserver o) {
		observers.remove(o);
	}
	
	private void notifyObservers(Operation op) {
		for (CalculatorObserver o : observers) {
			o.update(this, op);
		}
	}
}
