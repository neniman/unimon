package de.ur.unimon.battle;


import java.util.ArrayList;

import de.ur.unimon.unimons.Unimon;
import de.ur.unimon.unimons.UnimonList;

public class TrainerList {
	
	private static Trainer trainer1;
	private static Trainer trainer2;
	private static Trainer trainer3;
	private static Trainer trainer4;
	private static Trainer trainer5;
	private static Trainer trainer6;
	private static Trainer trainer7;
	private static Trainer boss;
	public ArrayList<Trainer> TrainerList;
		
	public Unimon leckMichAmArsch(int loch) {
		UnimonList allUnimonsList = new UnimonList();
		ArrayList<Unimon> unimonList = new ArrayList<Unimon>();
		unimonList = allUnimonsList.getUnimonList();
		return unimonList.get(loch);
	}

	public TrainerList(){
		TrainerList = new ArrayList<Trainer>();
		trainer1 = new Trainer(1, "B�serBube1", 48.9979054, 12.0957183, leckMichAmArsch(0), 70, 70);
		trainer2 = new Trainer(2, "B�serBube2", 48.9979054, 12.0957183, leckMichAmArsch(1), 150, 150);
		trainer3 = new Trainer(3, "B�serBube3", 48.9979054, 12.0957183, leckMichAmArsch(2), 250, 250);
		trainer4 = new Trainer(4, "B�serBube4", 48.9979054, 12.0957183, leckMichAmArsch(2), 350, 350);
		trainer5 = new Trainer(5, "B�serBube5", 48.9979054, 12.0957183, leckMichAmArsch(2), 150, 150);
		trainer6 = new Trainer(6, "B�serBube6", 48.9979054, 12.0957183, leckMichAmArsch(2), 150, 150);
		trainer7 = new Trainer(7, "B�serBube7", 48.9979054, 12.0957183, leckMichAmArsch(2), 150, 150);
		boss = new Trainer(2, "Oberb�serBube", 48.9979054, 12.0957183, leckMichAmArsch(3), 150, 150);
		TrainerList.add(trainer1);
		TrainerList.add(trainer2);
		TrainerList.add(trainer3);
		TrainerList.add(trainer4);
		TrainerList.add(trainer5);
		TrainerList.add(trainer6);
		TrainerList.add(trainer7);
		TrainerList.add(boss);
	}
}