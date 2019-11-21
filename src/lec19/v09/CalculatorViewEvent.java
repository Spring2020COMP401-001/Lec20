package lec19.v09;

abstract public class CalculatorViewEvent {
	
	public boolean isDigitEvent() {
		return false;
	}

	public boolean isOperationEvent() {
		return false;
	}
	
	public boolean isInversionEvent() {
		return false;
	}

	public boolean isPointEvent() {
		return false;
	}

}

class DigitEvent extends CalculatorViewEvent {
	private int value;
	
	public DigitEvent(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public String getString() {
		return Integer.toString(value);
	}
	
	@Override
	public boolean isDigitEvent() {
		return true;
	}
	
}

class OperationEvent extends CalculatorViewEvent {
	private Operation.OpType op_type;
	
	public OperationEvent(Operation.OpType op_type) {
		this.op_type = op_type;
	}

	public Operation.OpType getOpType() {
		return op_type;
	}
	
	@Override
	public boolean isOperationEvent() {
		return true;
	}	
}

class InversionEvent extends CalculatorViewEvent {	
	@Override
	public boolean isInversionEvent() {
		return true;
	}
}

class PointEvent extends CalculatorViewEvent {
	@Override
	public boolean isPointEvent() {
		return true;
	}
}