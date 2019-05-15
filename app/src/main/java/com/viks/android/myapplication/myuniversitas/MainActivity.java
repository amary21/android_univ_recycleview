package com.viks.android.myapplication.myuniversitas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcCategory;
    private ArrayList<Universitas> list = new ArrayList<>();
    String title = "Universitas di Indonesia";
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcCategory = findViewById(R.id.rc_category);
        rcCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null){
            setActionBarTitle("Universitas di Indonesia");
            list.addAll(UniversitasData.getListData());
            showRecyclerCardView();
            mode = R.id.action_list;
        }else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Universitas> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedUniv(Universitas univ){
        Intent detailUniv = new Intent(MainActivity.this, DetailUniversitas.class);
        detailUniv.putExtra("img_logo", univ.getLogo());
        detailUniv.putExtra("txt_nama", univ.getNama());
        detailUniv.putExtra("txt_daerah",univ.getDaerah());
        detailUniv.putExtra("txt_sinopsis", univ.getSinopsis());
        detailUniv.putExtra("txt_singkatan", univ.getSingkatan());
        detailUniv.putExtra("txt_didirikan", univ.getDidirikan());
        detailUniv.putExtra("txt_alamat",univ.getAlamat());
        detailUniv.putExtra("img_taman",univ.getTaman());
        startActivity(detailUniv);
    }

    private void showRecyclerList() {
        rcCategory.setLayoutManager(new LinearLayoutManager(this));
        ListUniversitasAdapter listUnivAdapter = new ListUniversitasAdapter(this);
        listUnivAdapter.setListUniversitas(list);
        rcCategory.setAdapter(listUnivAdapter);

        ItemClickSupport.addTo(rcCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedUniv(list.get(position));
            }
        });
    }

    private void showRecyclerGrid(){
        rcCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridUniversitasAdapter gridUniversitasAdapter =  new GridUniversitasAdapter(this);
        gridUniversitasAdapter.setListUniversitas(list);
        rcCategory.setAdapter(gridUniversitasAdapter);

        ItemClickSupport.addTo(rcCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedUniv(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rcCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewUniversitasAdapter cardViewUniversitasAdapter = new CardViewUniversitasAdapter(this);
        cardViewUniversitasAdapter.setListUniversitas(list);
        rcCategory.setAdapter(cardViewUniversitasAdapter);

        ItemClickSupport.addTo(rcCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedUniv(list.get(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {

        switch (selectedMode){
            case R.id.action_list:
                showRecyclerList();
                setActionBarTitle(title);
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                setActionBarTitle(title);
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                setActionBarTitle(title);
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}

