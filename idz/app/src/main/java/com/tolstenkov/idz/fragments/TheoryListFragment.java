package com.tolstenkov.idz.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tolstenkov.idz.R;
import com.tolstenkov.idz.TheoryActivity;
import com.tolstenkov.idz.adapters.TheoryAdapter;
import com.tolstenkov.idz.models.Theory;

import java.util.ArrayList;
import java.util.Date;

public class TheoryListFragment extends Fragment {
    private ArrayList<Theory> theories;
    private TheoryAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        theories = Theory.get();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // зв’язуємо з відповідним макетом
        View view = inflater.inflate(R.layout.fragment_theory_list, container, false);
        ListView listTheories = (ListView)view.findViewById(R.id.list_theory);
        // для формування структури списку використовуємо відповідний адаптер (див.нижче п.9)
        adapter = new TheoryAdapter(this.getContext(), theories);
        listTheories.setAdapter(adapter);
        listTheories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // тут будуть функції обробки при натисканні на елемент списку
                Intent intent = new Intent(getActivity(), TheoryActivity.class);
                Bundle inventory = new Bundle();
                inventory.putParcelable("inventory",theories.get(position));
                intent.putExtra("inventory", inventory);
                intent.putExtra("position", position);
                startActivityForResult(intent, 0);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK ) {

            int position = data.getIntExtra("position",-1);

            Theory theory = new Theory();
            theory.setmTitle(data.getStringExtra("title"));
            theory.setmContent(data.getStringExtra("content"));
            theory.setmMark(data.getIntExtra("mark",0));
            theories.set(position,theory);

            adapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(getActivity(), "Wrong result", Toast.LENGTH_SHORT).show();
        }
    }
}
