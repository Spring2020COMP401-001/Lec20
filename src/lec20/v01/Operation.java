package lec20.v01;

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
}
