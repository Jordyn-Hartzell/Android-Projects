package com.example.rentacarapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RentalCompaniesList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[ ] companies = {"Budget", "Enterprise", "Expedia", "Hotwire", "Kayak", "Orbitz"};
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, companies));
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch (position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.budget.com/en/home")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.enterprise.com/en/home.html")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.expedia.com/Cars")));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hotwire.com/car-rentals/")));
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kayak.com/cars")));
                break;
            case 5:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.orbitz.com/Cars")));
                break;
        }
    }
}
