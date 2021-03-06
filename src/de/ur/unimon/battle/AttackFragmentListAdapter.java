package de.ur.unimon.battle;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import de.ur.mi.android.excercises.starter.R;
import de.ur.unimon.unimons.Spell;

public class AttackFragmentListAdapter extends BaseAdapter {

	private Context context;
	LayoutInflater infalInflater;
	private ArrayList<Spell> spellList;
	private TextView spellTextView, spellDamageTextView;

	public AttackFragmentListAdapter(Context context, ArrayList<Spell> spellList) {
		this.context = context;
		infalInflater = LayoutInflater.from(context);
		this.spellList = spellList;
	}

	@Override
	public int getCount() {
		return spellList.size();
	}

	@Override
	public Object getItem(int position) {
		return spellList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(
					R.layout.spell_item_attack_fragment, null);

		}

		Spell spell = (Spell) getItem(position);

		if (spell != null) {
			spellTextView = (TextView) convertView
					.findViewById(R.id.spell_name);
			spellDamageTextView = (TextView) convertView
					.findViewById(R.id.spell_damage);

			spellTextView.setText(spell.getSpellName() + "  ");
			spellDamageTextView.setText(" Damage: ~"
					+ spell.getDamageforDisplay(spell.getSpellLevel()));
		}
		return convertView;

	}

}
