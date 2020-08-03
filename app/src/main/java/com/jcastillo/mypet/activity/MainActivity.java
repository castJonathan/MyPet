package com.jcastillo.mypet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.jcastillo.mypet.R;
import com.jcastillo.mypet.adapter.PageAdapter;
import com.jcastillo.mypet.fragment.PetPerfilFragment;
import com.jcastillo.mypet.fragment.RecycledViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar myActionBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myActionBar = (Toolbar) findViewById(R.id.myActionBar);

        if(myActionBar!=null) {
            setSupportActionBar(myActionBar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecycledViewFragment());
        fragments.add(new PetPerfilFragment());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.dog_house_30);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_face_30);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mSettings:
                Toast.makeText(this, R.string.menu_titulo, Toast.LENGTH_LONG).show();
                break;
            case R.id.mTopPet:
                Intent iTopPet = new Intent(MainActivity.this, TopPetActivity.class);
                startActivity(iTopPet);
                break;
            case R.id.mContact:
                Intent iContact = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(iContact);
                break;
            case R.id.mAbout:
                Intent iAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(iAbout);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}