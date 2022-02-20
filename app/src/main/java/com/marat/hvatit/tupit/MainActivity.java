package com.marat.hvatit.tupit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import adapter.RecycleAdapter;

import com.marat.hvatit.tupit.model.DetailsFragment;
import com.marat.hvatit.tupit.model.FilmCollectionStore;
import com.marat.hvatit.tupit.model.Objfilm;
import com.marat.hvatit.tupit.model.interfaces.IcreateFragment;

public class MainActivity extends AppCompatActivity implements IcreateFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new RecycleFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentcontainer, fragment)
                .commit();
        Log.e("TAG", getSupportFragmentManager().getFragments().toString());

    }

    @Override
    public void someFragment(Objfilm film) {
        Bundle bundle = new Bundle();
        DetailsFragment detailsFragment = new DetailsFragment();
        bundle.putString("key",film.getFilmId());
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentcontainer, detailsFragment)
                .commit();
    }
}