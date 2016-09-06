package com.example.administrator.myapplication4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private final static String PRODUCT = "product";
    private final static String PRICE = "price";
    private final static String CONFIGURATION = "configuration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] products = {"小明", "小红", "小刚", "小雷"};
        String[] prices = {"软工1301", "软工1302", "软工1303", "软工1304"};
        String[] configurations = {"男，2013011250", "女，2013011251", "男，2013011252", "男，2013011253"};
        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < products.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put(PRODUCT, products[i]);
            item.put(PRICE, prices[i]);
            item.put(CONFIGURATION, configurations[i]);
            items.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.item, new String[]{PRODUCT, PRICE, CONFIGURATION}, new int[]{R.id.txtProduct, R.id.txtPrice, R.id.txtConfiguration});
        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
