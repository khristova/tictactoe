package com.example.tictactoegamee;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;

public class SinglePlayerActivity extends Activity {

	boolean isCurrPlayerO = false;
	Field field;
	ImageButton button;
	int moveCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_player);
		field = new Field();
		field.fillArray();
	}

	public void makeMove(View view) {

		if (view.getId() == R.id.button00) {
			if (isCurrPlayerO) {	
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
			if (isCurrPlayerO) {
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
			if (isCurrPlayerO) {
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
			if (isCurrPlayerO) {
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
			if (isCurrPlayerO) {
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
			if (isCurrPlayerO) {
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
			if (isCurrPlayerO) {
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
			if (isCurrPlayerO) {
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
			if (isCurrPlayerO) {
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

		isCurrPlayerO = !isCurrPlayerO;

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
			builder1.setMessage("Равен");
			builder1.setTitle("Резултат");
			builder1.show();
		} else if (field.checkWin() == 1) {
			builder1.setMessage("X печели");
			builder1.setTitle("Резултат");
			builder1.show();
			setFinishOnTouchOutside(false);
		} else if (field.checkWin() == 2) {
			builder1.setMessage("O печели");
			builder1.setTitle("Резултат");
			builder1.show();
		}
	}
}
