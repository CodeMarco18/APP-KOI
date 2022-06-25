package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.recyclerview.R;
import com.example.recyclerview.adaptador.RecyclerAdapter;
import com.example.recyclerview.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        initListener();
    }

    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("CEVICHE KOI", "Finos cortes de pescado blanco en la mejor leche de tigre koi nikkei amarillo, con un toque de picante acompañado de chincharon de calamar, camotes glaseados, canchita chulpi y monte.",R.drawable.comida_1));
        itemLists.add(new ItemList("CEVICHE CLASICO", "Tradicionales cortes de pescado blanco, en leche de tigre acompañado de chicharrón de pota, camotes glaseados, canchita chulpi y monte", R.drawable.comida_2));
        itemLists.add(new ItemList("ARROZ CON MARISCOS.", "Delicioso arroz preparado con la deliciosa receta peruana con nuestro toque nikkei.", R.drawable.comida_3));
        itemLists.add(new ItemList("TIRADITO CLASICO", "Cortes de pescado servidos en estilo tradicional",R.drawable.comida_4));
        itemLists.add(new ItemList("POKE BOWL", "Base de arroz, acompañados con Cortes de salmón, ensalada orgánica y fruta del dia.",R.drawable.comida_5));
        itemLists.add(new ItemList("TIRADITO CARPASSION", "Cortes de pescado en salsa carpassion", R.drawable.comida_6));
        itemLists.add(new ItemList("CHICHARRÓN DE PESCADO. ", "Deliciosos cortes de pescado fritos en panko, acompañados con papas nativas y ensalada.", R.drawable.comida_7));
        itemLists.add(new ItemList("CHAUFA NIKKEI", "Arroz salteado estilo oriental, acompañado de mariscos o trozos de pescado, tu elijes!", R.drawable.comida_8));
        itemLists.add(new ItemList("LANGOSTINOS FURAY.", "Langostinos XL, marianos en salsa nikkei y fritos en panko, acompañados de una guarnición de vegetales.",R.drawable.comida_9));
        itemLists.add(new ItemList("DÚO MARINO II", "CEVICHE DE PESCADO BLANCO + CHICHARRÓN DE PESCADO", R.drawable.comida_10));
        itemLists.add(new ItemList("DÚO MARINO III", "CEVICHE DE PESCADO BLANCO + ARROZ CON MARISCOS",R.drawable.comida_11));
        itemLists.add(new ItemList("DÚO MARINO I ", "ARROZ CHAUFA DE MARISCOS + CEVICHE DE PESCADO BLANCO", R.drawable.comida_12));

        return itemLists;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }
}
