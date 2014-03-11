package com.example.tictactoegamee;

import android.os.Bundle;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.google.example.games.basegameutils.GameHelper;
//import gms.common.api.*;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseGameActivity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.sign_in_button).setOnClickListener(this);
		findViewById(R.id.sign_out_button).setOnClickListener(this);

		Button exitButton = (Button) findViewById(R.id.exit);
		exitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				System.exit(0);
			}
		});
	}

	public void startSinglePlayer(View view) {
		Intent intent = new Intent(MainActivity.this,
				SinglePlayerActivity.class);
		startActivity(intent);
	}

	public void startAI(View view) {
		Intent intent = new Intent(MainActivity.this, AIActivity.class);
		startActivity(intent);
	}

	public void startMultiPlayer(View view) {
		Intent intent = new Intent(MainActivity.this, MultiPlayer.class);
		startActivity(intent);
	}

	@Override
	public void onClick(View view) {
	    if (view.getId() == R.id.sign_in_button) {
	        // start the asynchronous sign in flow
	        beginUserInitiatedSignIn();
	    }
	    else if (view.getId() == R.id.sign_out_button) {
	        // sign out.
	        signOut();

	        // show sign-in button, hide the sign-out button
	        findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
	        findViewById(R.id.sign_out_button).setVisibility(View.GONE);
	    }
	}

	@Override
	public void onSignInFailed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSignInSucceeded() {
		// TODO Auto-generated method stub
		
	}

}