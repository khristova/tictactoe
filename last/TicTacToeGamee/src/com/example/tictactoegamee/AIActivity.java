package com.example.tictactoegamee;

import java.util.Random;

import android.os.Bundle;
import android.widget.ImageButton;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

public class AIActivity extends Activity {

	Field field;
	int aiSign = 2; // AI is with sign "O"
	boolean AIturn = false;
	int moves = 0;
	// boolean isCurrPlayerO = false;
	ImageButton button;
	int thirdEmptyCell;
	int moveCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ai);
		field = new Field();
		field.fillArray();
	}

	public void moveAI(View view) {

		putPicOnButton(view);

		AIturn = !AIturn;

		makeAImove();

		Result();

	}

	private void makeAImove() {

		thirdEmptyCell = checkTwoInLine(aiSign);

		if (thirdEmptyCell < 23) {
			putPicOnCord(thirdEmptyCell);
			moveCount++;
		} else

			thirdEmptyCell = checkTwoInLine(1);
		if (thirdEmptyCell < 23) {
			putPicOnCord(thirdEmptyCell);
			moveCount++;
		} else

		{
			int coordinates;

			if (moves < 4) {
				do {
					Random r = new Random();
					int i = r.nextInt(3);
					int p = r.nextInt(3);
					String s = Integer.toString(i) + Integer.toString(p);
					coordinates = Integer.parseInt(s);
				} while (isCellTaken(coordinates));

				putPicOnCord(coordinates);
				moveCount++;
			}

		}

		AIturn = !AIturn;
		moves++;
	}

	// TO DO
	// 1. Ako imame 2 poredni aiSign i ako tretoto e svobodno, slagame 3-to
	// 2. Ako oponenta ima 2 poredni i tretoto e svobodno go zapushvame
	// 3. Ako ima svobodno do nashe(na bota), i tretoto e svobodno, slagame tam.
	// Ako
	// ima poveche ot edno podhodqshto, izbirame na random
	// 4. Random

	private void putPicOnCord(int cords) {
		int y = cords % 10;
		int x = cords / 10;
		field.array[x][y].changeSign(aiSign);

		if (x == 0 && y == 0) {
			button = (ImageButton) findViewById(R.id.button00);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 0 && y == 1) {
			button = (ImageButton) findViewById(R.id.button01);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 0 && y == 2) {
			button = (ImageButton) findViewById(R.id.button02);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 1 && y == 0) {
			button = (ImageButton) findViewById(R.id.button10);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 1 && y == 1) {
			button = (ImageButton) findViewById(R.id.button11);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 1 && y == 2) {
			button = (ImageButton) findViewById(R.id.button12);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 2 && y == 0) {
			button = (ImageButton) findViewById(R.id.button20);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 2 && y == 1) {
			button = (ImageButton) findViewById(R.id.button21);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 2 && y == 2) {
			button = (ImageButton) findViewById(R.id.button22);
			button.setBackgroundResource(R.drawable.o);
		}
		if (x == 0 && y == 0) {
			button = (ImageButton) findViewById(R.id.button00);
			button.setBackgroundResource(R.drawable.o);
		}
		button.setEnabled(false);
	}

	private void putPicOnButton(View view) { // When clicked

		if (view.getId() == R.id.button00) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button00);
				button.setBackgroundResource(R.drawable.o);
				field.array[0][0].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button00);
				button.setBackgroundResource(R.drawable.x);
				field.array[0][0].changeSign(1);
			}
		}

		if (view.getId() == R.id.button01) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button01);
				button.setBackgroundResource(R.drawable.o);
				field.array[0][1].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button01);
				button.setBackgroundResource(R.drawable.x);
				field.array[0][1].changeSign(1);
			}

		}

		if (view.getId() == R.id.button02) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button02);
				button.setBackgroundResource(R.drawable.o);
				field.array[0][2].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button02);
				button.setBackgroundResource(R.drawable.x);
				field.array[0][2].changeSign(1);
			}
		}

		if (view.getId() == R.id.button10) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button10);
				button.setBackgroundResource(R.drawable.o);
				field.array[1][0].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button10);
				button.setBackgroundResource(R.drawable.x);
				field.array[1][0].changeSign(1);
			}
		}

		if (view.getId() == R.id.button11) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button11);
				button.setBackgroundResource(R.drawable.o);
				field.array[1][1].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button11);
				button.setBackgroundResource(R.drawable.x);
				field.array[1][1].changeSign(1);
			}
		}

		if (view.getId() == R.id.button12) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button12);
				button.setBackgroundResource(R.drawable.o);
				field.array[1][2].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button12);
				button.setBackgroundResource(R.drawable.x);
				field.array[1][2].changeSign(1);
			}
		}

		if (view.getId() == R.id.button20) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button20);
				button.setBackgroundResource(R.drawable.o);
				field.array[2][0].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button20);
				button.setBackgroundResource(R.drawable.x);
				field.array[2][0].changeSign(1);
			}
		}

		if (view.getId() == R.id.button21) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button21);
				button.setBackgroundResource(R.drawable.o);
				field.array[2][1].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button21);
				button.setBackgroundResource(R.drawable.x);
				field.array[2][1].changeSign(1);
			}
		}

		if (view.getId() == R.id.button22) {
			if (AIturn) {
				button = (ImageButton) findViewById(R.id.button22);
				button.setBackgroundResource(R.drawable.o);
				field.array[2][2].changeSign(2);
			} else {
				button = (ImageButton) findViewById(R.id.button22);
				button.setBackgroundResource(R.drawable.x);
				field.array[2][2].changeSign(1);
			}
		}
		button.setEnabled(false);
		moveCount++;
		// isCurrPlayerO = !isCurrPlayerO;
	}

	private int checkTwoInLine(int sign) {

		if (field.array[0][0].getSign() == sign
				&& field.array[0][1].getSign() == sign
				&& field.array[0][2].getSign() == 0) {
			return 2;
		}

		if (field.array[0][2].getSign() == sign
				&& field.array[0][0].getSign() == sign
				&& field.array[0][1].getSign() == 0) {
			return 1;
		}
		if (field.array[0][1].getSign() == sign
				&& field.array[0][2].getSign() == sign
				&& field.array[0][0].getSign() == 0) {
			return 0;
		}
		if (field.array[1][0].getSign() == sign
				&& field.array[1][1].getSign() == sign
				&& field.array[1][2].getSign() == 0) {
			return 12;
		}
		if (field.array[1][2].getSign() == sign
				&& field.array[1][0].getSign() == sign
				&& field.array[1][1].getSign() == 0) {
			return 11;
		}
		if (field.array[1][1].getSign() == sign
				&& field.array[1][2].getSign() == sign
				&& field.array[1][0].getSign() == 0) {
			return 10;
		}
		if (field.array[2][1].getSign() == sign
				&& field.array[2][0].getSign() == sign
				&& field.array[2][2].getSign() == 0) {
			return 22;
		}
		if (field.array[2][2].getSign() == sign
				&& field.array[2][1].getSign() == sign
				&& field.array[2][0].getSign() == 0) {
			return 20;
		}
		if (field.array[2][0].getSign() == sign
				&& field.array[2][2].getSign() == sign
				&& field.array[2][1].getSign() == 0) {
			return 21;
		}

		if (field.array[0][0].getSign() == sign
				&& field.array[1][0].getSign() == sign
				&& field.array[2][0].getSign() == 0) {
			return 20;
		}
		if (field.array[0][0].getSign() == sign
				&& field.array[2][0].getSign() == sign
				&& field.array[1][0].getSign() == 0) {
			return 10;
		}
		if (field.array[1][0].getSign() == sign
				&& field.array[2][0].getSign() == sign
				&& field.array[0][0].getSign() == 0) {
			return 0;
		}
		if (field.array[0][1].getSign() == sign
				&& field.array[1][1].getSign() == sign
				&& field.array[2][1].getSign() == 0) {
			return 21;
		}
		if (field.array[2][1].getSign() == sign
				&& field.array[0][1].getSign() == sign
				&& field.array[1][1].getSign() == 0) {
			return 11;
		}
		if (field.array[1][1].getSign() == sign
				&& field.array[2][1].getSign() == sign
				&& field.array[0][1].getSign() == 0) {
			return 1;
		}
		if (field.array[0][2].getSign() == sign
				&& field.array[1][2].getSign() == sign
				&& field.array[2][2].getSign() == 0) {
			return 22;
		}
		if (field.array[2][2].getSign() == sign
				&& field.array[1][2].getSign() == sign
				&& field.array[0][2].getSign() == 0) {
			return 2;
		}
		if (field.array[2][2].getSign() == sign
				&& field.array[0][2].getSign() == sign
				&& field.array[1][2].getSign() == 0) {
			return 12;
		}
		if (field.array[2][2].getSign() == sign
				&& field.array[1][1].getSign() == sign
				&& field.array[0][0].getSign() == 0) {
			return 0;
		}
		if (field.array[2][2].getSign() == sign
				&& field.array[0][0].getSign() == sign
				&& field.array[1][1].getSign() == 0) {
			return 11;
		}
		if (field.array[0][0].getSign() == sign
				&& field.array[1][1].getSign() == sign
				&& field.array[2][2].getSign() == 0) {
			return 22;
		}
		if (field.array[0][2].getSign() == sign
				&& field.array[1][1].getSign() == sign
				&& field.array[2][0].getSign() == 0) {
			return 20;
		}
		if (field.array[0][2].getSign() == sign
				&& field.array[2][0].getSign() == sign
				&& field.array[1][1].getSign() == 0) {
			return 11;
		}
		if (field.array[2][0].getSign() == sign
				&& field.array[1][1].getSign() == sign
				&& field.array[2][2].getSign() == 0) {
			return 2;
		}
		return 25; // No empty cell code
	}

	private boolean isCellTaken(int cords) {
		int y = cords % 10;
		int x = cords / 10;
		if (field.array[x][y].getSign() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void Result() {
		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		builder1.setTitle("");
		builder1.setMessage("");
		builder1.setNeutralButton(R.string.back_to_menu,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
						finish();
					}
				});
		builder1.setPositiveButton(R.string.new_game,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = getIntent();
						finish();
						startActivity(intent);

					}
				});
		builder1.setCancelable(false);

		if (field.checkWin() == 0 && moveCount == 8) {
			builder1.setMessage("Tie");
			builder1.setTitle("Result");
			builder1.show();
		} else if (field.checkWin() == 1) {
			builder1.setMessage("X wins");
			builder1.setTitle("Result");
			builder1.show();
			setFinishOnTouchOutside(false);
		} else if (field.checkWin() == 2) {
			builder1.setMessage("O wins");
			builder1.setTitle("Result");
			builder1.show();
		}
	}
}
