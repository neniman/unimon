package de.ur.unimon.buildings;

import java.util.ArrayList;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import de.ur.mi.android.excercises.starter.R;
import de.ur.unimon.actionbar.UnimonListAdapter;
import de.ur.unimon.database.DatabaseController;
import de.ur.unimon.player.Player;
import de.ur.unimon.player.PlayerController;
import de.ur.unimon.unimons.Unimon;

public class HospitalActivity extends Activity{
	
	Button button;
	private ArrayList <Unimon> unimons;
	private Player player;
	private PlayerController playerController;
	private Toast toast;
	ListView listUnimons;
	ListAdapter listUnimons_adpater;
	HospitalLogic hospital;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hospital_activty);
		
		hospital = new HospitalLogic();
		initUI();

	}
	
	@Override
	protected void onDestroy() {
		DatabaseController databaseController = new DatabaseController(this);
		databaseController.save();
		super.onDestroy();
	}

	private void initUI() {
		player = playerController.getInstance();
		unimons = player.getUnimonList();
		button = (Button) findViewById(R.id.button_healAll);
		button.setOnClickListener(new OnClickListener() { 
			
			@Override
			public void onClick(View v) {
				
				for (int i = 0; i < unimons.size(); i++){
					if (unimons.get(i).getHealth() != unimons.get(i).getMaxHealth()){
						hospital.healAll(unimons);
						initListAdapter();
					}
					else{
						showToast(R.string.hospital_heal_info);
					}
				}												
				
			}
		});
		
		initListAdapter();

	}

	private void initListAdapter() {
		listUnimons = (ListView) findViewById(R.id.listView_unimons);
		listUnimons_adpater = new UnimonListAdapter(this, unimons);
		listUnimons.setAdapter(listUnimons_adpater);
	}
	
	private void showToast(int toastText) {
		int duration = Toast.LENGTH_LONG;
		toast = Toast.makeText(this, toastText, duration);
		toast.show();
	}
	

}
