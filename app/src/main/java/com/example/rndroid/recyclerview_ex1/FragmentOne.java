package com.example.rndroid.recyclerview_ex1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    EditText ed1, ed2;
    Button buttonSubmit;
    MyAdapter myAdapter;
    ArrayList<Moview> arrayList;
    RecyclerView recyclerView;
    int sno = 1;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        public MyAdapter(ArrayList<Moview> myMoviewArrayList){
            arrayList = myMoviewArrayList;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tv1, tv2, tv3;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv1 = (TextView) itemView.findViewById(R.id.tvMvo);
                tv2 = (TextView) itemView.findViewById(R.id.tvAname);
                tv3 = (TextView) itemView.findViewById(R.id.tvMovName);
            }
        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.row, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv1.setText(arrayList.get(position).getSno());
            holder.tv2.setText(arrayList.get(position).getActorname());
            holder.tv3.setText(arrayList.get(position).getMoviename());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        ed1 = (EditText) v.findViewById(R.id.ed1Name);
        ed2 = (EditText) v.findViewById(R.id.edMname);
        buttonSubmit = (Button) v.findViewById(R.id.btSubmit);
        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        myAdapter = new MyAdapter(arrayList);
        arrayList = new ArrayList<>();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Moview myMovie = new Moview();
                myMovie.setSno(""+sno++);
                myMovie.setActorname(ed1.getText().toString());
                myMovie.setMoviename(ed2.getText().toString());
                ed1.setText("");
                ed2.setText("");
                ed1.requestFocus();

                arrayList.add(myMovie);
                recyclerView.setAdapter(myAdapter);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return v;

    }
}
