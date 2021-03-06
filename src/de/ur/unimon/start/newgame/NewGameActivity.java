package de.ur.unimon.start.newgame;

import de.ur.mi.android.excercises.starter.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NewGameActivity extends Activity {

	ImageView wulfmanImg;
	TextView story_part_one;
	Button nextStoryPart;
	int pageNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game_activity);
		initUI();
	}

	@Override
	public void onBackPressed() {
	}

	private void initUI() {
		Typeface font = Typeface
				.createFromAsset(getAssets(), "PokemonFont.ttf");
		wulfmanImg = (ImageView) findViewById(R.id.wulfman_img);
		story_part_one = (TextView) findViewById(R.id.story_part_one);
		nextStoryPart = (Button) findViewById(R.id.next_button);
		nextStoryPart.setTypeface(font);
		setButtonOnClick();
	}

	private void setButtonOnClick() {
		pageNum = 0;

		nextStoryPart.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (pageNum == 0) {
					story_part_one.setText(getResources().getString(
							R.string.story_part_two));
					pageNum++;
				}

				else if (pageNum == 1) {
					story_part_one.setText(getResources().getString(
							R.string.story_part_three));
					pageNum++;
				}

				else {

					Intent choose_unimon = new Intent(NewGameActivity.this,
							ChooseUnimonActivity.class);
					choose_unimon.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					startActivity(choose_unimon);
				}

			}
		});
	}

}
