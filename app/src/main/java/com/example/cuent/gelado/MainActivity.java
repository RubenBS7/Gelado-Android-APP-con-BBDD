package com.example.cuent.gelado;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.example.cuent.gelado.data.InventoryDbHelper;
import com.example.cuent.gelado.data.StockItem;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getCanonicalName();
    InventoryDbHelper dbHelper;
    StockCursorAdapter adapter;
    int lastVisibleItem = 0;
    Button manual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new InventoryDbHelper(this);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        final ListView listView = (ListView) findViewById(R.id.list_view);
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

        Cursor cursor = dbHelper.readStock();

        adapter = new StockCursorAdapter(this, cursor);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState == 0) return;
                final int currentFirstVisibleItem = view.getFirstVisiblePosition();
                if (currentFirstVisibleItem > lastVisibleItem) {
                    fab.show();
                } else if (currentFirstVisibleItem < lastVisibleItem) {
                    fab.hide();
                }
                lastVisibleItem = currentFirstVisibleItem;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        //variable para incicualizar el boton manual.
        manual = (Button) findViewById(R.id.btnManual);
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToManual();
            }
        });

        //Para meter el inico de la app en el actionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.readStock());
    }

    public void clickOnViewItem(long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemId", id);
        startActivity(intent);
    }

    public void clickOnSale(long id, int quantity) {
        dbHelper.sellOneItem(id, quantity);
        adapter.swapCursor(dbHelper.readStock());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //Este metodo Inserta en la BD los datos precargados más abajo.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_dummy_data:
                // añadir datos basura para comprobar
                addDummyData();
                adapter.swapCursor(dbHelper.readStock());
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Añadir datos precargados en la Base de datos.
     */
    private void addDummyData() {
        StockItem calippo = new StockItem(
                "Calippo",
                "2 €",
                40,
                "Frigo",
                "+49 000 000 0000",
                "frigo@gmail.com",
                "android.resource://com.example.cuent.gelado/drawable/calippo");
        dbHelper.insertItem(calippo);

        StockItem chocolate = new StockItem(
                "Helado chocolate",
                "4 €",
                20,
                "Nestle",
                "+49 000 000 0000",
                "Nestle@hotmail.com",
                "android.resource://com.example.cuent.gelado/drawable/chocolate");
        dbHelper.insertItem(chocolate);

        StockItem cohete = new StockItem(
                "Cohete",
                "1 €",
                50,
                "Frigo",
                "+49 000 000 0000",
                "frigo@gmail.com",
                "android.resource://com.example.cuent.gelado/drawable/cohete");
        dbHelper.insertItem(cohete);

        StockItem dracula = new StockItem(
                "Dracula",
                "2 €",
                30,
                "Frigo",
                "+49 000 000 0000",
                "frigo@gmail.com",
                "android.resource://com.example.cuent.gelado/drawable/dracula");
        dbHelper.insertItem(dracula);

        StockItem fresa = new StockItem(
                "Helado fresa",
                "4 €",
                34,
                "Nestle",
                "+49 000 000 0000",
                "Nestle@hotmail.com",
                "android.resource://com.example.cuent.gelado/drawable/fresa");
        dbHelper.insertItem(fresa);

        StockItem frigodedo = new StockItem(
                "Frigodedo",
                "1 €",
                26,
                "Frigo",
                "+49 000 000 0000",
                "frigo@gmail.com",
                "android.resource://com.example.cuent.gelado/drawable/frigodedo");
        dbHelper.insertItem(frigodedo);

        StockItem limon = new StockItem(
                "Helado limon",
                "4 €",
                54,
                "Nestle",
                "+34 000 000 0000",
                "Nestle@hotmail.com",
                "android.resource://com.example.cuent.gelado/drawable/limon");
        dbHelper.insertItem(limon);

        StockItem menta_choco = new StockItem(
                "Helado MentaChoco",
                "6 €",
                12,
                "Nestle",
                "+34 000 000 0000",
                "Nestle@hotmail.com",
                "android.resource://com.example.cuent.gelado/drawable/menta_choco");
        dbHelper.insertItem(menta_choco);

        StockItem naranja = new StockItem(
                "Helado de naranja",
                "5 €",
                62,
                "Nestle",
                "+34 000 000 0000",
                "Nestle@hotmail.com",
                "android.resource://com.example.cuent.gelado/drawable/naranja");
        dbHelper.insertItem(naranja);

        StockItem polomix = new StockItem(
                "Polomix",
                "3 €",
                22,
                "Frigo",
                "+34 000 000 0000",
                "frigo@gmail.com",
                "android.resource://com.example.cuent.gelado/drawable/polomix");
        dbHelper.insertItem(polomix);
    }

    //Para ir a la actividad del Manual.
    public void GoToManual(){

        Intent intent = new Intent(this, Manual.class);
        startActivity(intent);
    }

}