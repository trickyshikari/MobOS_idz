package com.tolstenkov.idz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tolstenkov.idz.R;
import com.tolstenkov.idz.models.Theory;

import java.util.ArrayList;


public class TheoryAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Theory> theories;

    public TheoryAdapter(Context context, ArrayList<Theory> theories){
        this.context = context;
        this.theories = theories;
    }

    @Override
    public int getCount() {
        return theories.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.listview_layout_theory,parent,false);
        }
        Theory currentTheory = (Theory) getItem(position);
        TextView textViewTheoryTitle = (TextView) convertView.findViewById(R.id.theory_title);
        textViewTheoryTitle.setText(currentTheory.getmTitle());
        TextView textViewTheoryContent = (TextView) convertView.findViewById(R.id.theory_content);
        textViewTheoryContent.setText(currentTheory.getmContent());
        TextView textViewTheoryMark = (TextView) convertView.findViewById(R.id.theory_mark);
        textViewTheoryMark.setText(currentTheory.getmMark());

        return convertView;
    }
}
