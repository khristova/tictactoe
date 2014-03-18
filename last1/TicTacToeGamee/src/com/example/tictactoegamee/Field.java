package com.example.tictactoegamee;

import java.util.Arrays;

import android.util.Log;

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

//		array[0][0].changeSign(1);
//		array[0][1].changeSign(1);
//		array[0][2].changeSign(1);
//		array[1][0].changeSign(2);
//		array[1][1].changeSign(2);
//		array[1][2].changeSign(1);
//		array[2][0].changeSign(1);
//		array[2][1].changeSign(2);
//		array[2][2].changeSign(2);
	}

	// test
	void printArray() {
		Log.v("MainActivity", Arrays.deepToString(array));
		if (checkWin() == 0)
			Log.v("Ivan", "Tie");
		if (checkWin() == 1)
			Log.v("Ivan", "X Wins");
		if (checkWin() == 2)
			Log.v("Ivan", "O Wins");
	}

	// return 0 = tie
	// return 1 = x wins
	// return 2 = o wins
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
