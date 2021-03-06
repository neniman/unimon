package de.ur.unimon.battle;

import de.ur.mi.android.excercises.starter.R;
import de.ur.unimon.database.DatabaseController;
import de.ur.unimon.mapoverview.MapActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BattleEndActivity extends Activity {

	private TextView moneyEarned, xpEarned, moneyEarnedTextView,
			xpEarnedTextView, battleLostTextView;
	private Button backToMapButton;
	private ImageView battleEndImage;
	private boolean isGameWon;
	private int xp;
	private int money;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battle_end_activity);
		getIntentValues();
		initUI();
	}

	@Override
	public void onBackPressed() {
	}

	@Override
	protected void onDestroy() {
		DatabaseController databaseController = new DatabaseController(this);
		databaseController.save();
		super.onDestroy();
	}

	private void getIntentValues() {
		isGameWon = getIntent().getExtras().getBoolean("IsGameWon");
		xp = getIntent().getExtras().getInt("XP");
		money = getIntent().getExtras().getInt("Money");
	}

	private void initUI() {
		Typeface font = Typeface
				.createFromAsset(getAssets(), "PokemonFont.ttf");

		xpEarned = (TextView) findViewById(R.id.xpwon_textview);
		moneyEarned = (TextView) findViewById(R.id.moneywon_textview);
		moneyEarnedTextView = (TextView) findViewById(R.id.battle_end_moneywon_textview);
		xpEarnedTextView = (TextView) findViewById(R.id.battle_end_xpwon_textview);
		battleEndImage = (ImageView) findViewById(R.id.battle_end_img);

		if (isGameWon) {
			moneyEarned.setText(" " + money);
			xpEarned.setText(" " + xp);

			battleEndImage.setImageResource(R.drawable.win_logo);

		} else {
			moneyEarned.setText(" " + 0);
			xpEarned.setText(" " + 0);
			battleEndImage.setImageResource(R.drawable.you_lost_screen);
		}

		backToMapButton = (Button) findViewById(R.id.back_to_map_button);
		backToMapButton.setTypeface(font);
		backToMapButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent toMapActivity = new Intent(BattleEndActivity.this,
						MapActivity.class);
				startActivity(toMapActivity);
				toMapActivity.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			}
		});

	}
}
