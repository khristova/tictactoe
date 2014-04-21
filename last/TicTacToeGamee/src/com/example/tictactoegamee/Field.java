package com.example.tictactoegamee;

public class Field {

	public Cell[][] array;
	
	public Field() {
		array = new Cell[3][3];
	}


	void fillArray() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array[i][j] = new Cell(0);
			}
		}
	}

	int checkWin() {
		
		if (array[0][0].getSign() == array[0][1].getSign()
				&& array[0][1].getSign() == array[0][2].getSign()) {
			if (array[0][0].getSign() == 1) {
				return 1;
			} else if (array[0][0].getSign() == 2) {
				return 2;
			}
		}

		if (array[1][0].getSign() == array[1][1].getSign()
				&& array[1][1].getSign() == array[1][2].getSign()) {
			if (array[1][0].getSign() == 1) {
				return 1;
			} else if (array[1][0].getSign() == 2){
				return 2;
			}
		}

		if (array[2][0].getSign() == array[2][1].getSign()
				&& array[2][1].getSign() == array[2][2].getSign()) {
			if (array[2][0].getSign() == 1) {
				return 1;
			} else if (array[2][0].getSign() == 2){
				return 2;
			}
		}

		if (array[0][0].getSign() == array[1][0].getSign()
				&& array[1][0].getSign() == array[2][0].getSign()) {
			if (array[0][0].getSign() == 1) {
				return 1;
			} else if (array[0][0].getSign() == 2){
				return 2;
			}
		}

		if (array[0][1].getSign() == array[1][1].getSign()
				&& array[1][1].getSign() == array[2][1].getSign()) {
			if (array[0][1].getSign() == 1) {
				return 1;
			} else if (array[0][1].getSign() == 2){
				return 2;
			}
		}

		if (array[0][2].getSign() == array[1][2].getSign()
				&& array[1][2].getSign() == array[2][2].getSign()) {
			if (array[0][2].getSign() == 1) {
				return 1;	
			} else if (array[0][2].getSign() == 2){
				return 2;
			}
		}

		if (array[0][0].getSign() == array[1][1].getSign()
				&& array[1][1].getSign() == array[2][2].getSign()) {
			if (array[0][0].getSign() == 1) {
				return 1;
			} else if (array[0][0].getSign() == 2){
				return 2;
			}
		}

		if (array[0][2].getSign() == array[1][1].getSign()
				&& array[1][1].getSign() == array[2][0].getSign()) {
			if (array[0][2].getSign() == 1) {
				return 1;
			} else if (array[0][2].getSign() == 2){
				return 2;
			}
		}

		return 0;
	}

}
