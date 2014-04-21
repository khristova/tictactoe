package com.example.tictactoegamee;

public class Cell {
	
	// 0 = empty, 1 = X, 2 = O
	private int sign_ = 0;
	
	int getSign() {
		return sign_;
	}
	
	void changeSign(int sign) {
		sign_ = sign;
	}
	
	public Cell() {
		sign_ = 0;
	}
	
	public Cell(int sign) {
		sign_ = sign;
	}
	
}
