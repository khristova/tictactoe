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
	
//	//private int x_,y_;
//	enum Sign {x,o,empty};
//	private Sign sign_;
//	
//	void changeSign(Sign sign) {
//		sign_ = sign;
//	}
//	
//	public Sign getSign() {
//		return sign_;
//	}
//	
//	//public int getX() { 
//	//	return x_;
//	//}
//	
//	//public int getY() { 
//	//	return y_;
//	//}
//	
//	public Cell() {
//	//	x_=x;
//		sign_ = Sign.empty;
//	}
//	
//	public Cell(Sign sign) {
//		//x_=x;
//		//y_=y;
//		sign_=sign;
//		
//	}
//	
//	@Override
//	public String toString() {
//		if(sign_ == Sign.x) {
//			return "x";
//		} else if(sign_ == Sign.o) {
//			return "o";
//		} else return "empty";
//	}
	
}
