package lec19.v10;

public class Operation {

	public enum OpType {ADD, MULT, DIV, SUB, SET}
	
	private OpType type;
	private double operand;
	
	public Operation(OpType type, double operand) {
		this.type = type;
		this.operand = operand;
	}
	
	public OpType getType() {
		return type;
	}
	
	public double getOperand() {
		return operand;
	}
	
	public String toString() {
		String str = "";
		switch (type) {
		case ADD:
			str = "+ "; break;
		case MULT:
			str = "* "; break;
		case DIV:
			str = "/ "; break;
		case SUB:
			str = "- "; break;
		case SET:
			str = "= "; break;
		}
		str += operand;
		return str;
	}
}
