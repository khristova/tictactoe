package com.example.tictactoegamee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MultiPlayerActivity extends Activity {

	boolean isCurrPlayerO = false;
	Field field;
	ImageButton button;
	int moveCount = 0;
	int aiSign = 0;

	String moveCoords = "err";
	String serverData;

	String isConnected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multi_player);

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
			moveCoords = "00";
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
			moveCoords = "01";
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
			moveCoords = "02";
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
			moveCoords = "10";
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
			moveCoords = "11";
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
			moveCoords = "12";
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
			moveCoords = "20";
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
			moveCoords = "21";
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
			moveCoords = "22";

		}

		new Thread(new Runnable() {
			public void run() {

				try {

					Socket socket = new Socket("192.168.0.101", 1234);

					BufferedReader input = null;

					DataOutputStream out = null;

					try {
						out = new DataOutputStream(socket.getOutputStream());
						out.writeChars(moveCoords);

						input = new BufferedReader(new InputStreamReader(
								socket.getInputStream())); 

						Log.w("client recieved: ", input.readLine());
						System.out.println("probaaaaaa");
						
						button = (ImageButton) findViewById(R.id.button01);
						button.setBackgroundResource(R.drawable.o);
						input.close();

					} catch (IOException e) {
						// Bail out
					}

					out.flush();
					out.close();
					

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

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
