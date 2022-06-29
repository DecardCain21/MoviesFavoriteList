package com.marat.hvatit.tupit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.marat.hvatit.tupit.model.DetailsFragment;
import com.marat.hvatit.tupit.model.Objfilm;
import com.marat.hvatit.tupit.model.interfaces.IcreateFragment;

public class MainActivity extends AppCompatActivity implements IcreateFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = new RecycleFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentcontainer, fragment)
                .commit();
        Log.e("TAG", getSupportFragmentManager().getFragments().toString());
        ImageButton gridButton = (ImageButton) findViewById(R.id.imagegrid);
        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RecycleFragment) fragment).onButtonClick();
            }
        });

    }

    @Override
    public void someFragment(Objfilm film) {
        Bundle bundle = new Bundle();
        DetailsFragment detailsFragment = new DetailsFragment();
        bundle.putString("key", film.getFilmId());
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentcontainer, detailsFragment)
                .commit();
    }

}