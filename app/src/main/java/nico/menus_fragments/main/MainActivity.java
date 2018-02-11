package nico.menus_fragments.main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import nico.menus_fragments.AcercaDeActivity;
import nico.menus_fragments.ContactoActivity;
import nico.menus_fragments.MascotasFavoritasActivity;
import nico.menus_fragments.R;
import nico.menus_fragments.adapters.PageAdapter;
import nico.menus_fragments.fragments.MascotaFragment;
import nico.menus_fragments.fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        setUpViewPager();

    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), listaFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ico_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ico_dog);

    }

    private ArrayList<Fragment> listaFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new MascotaFragment());
        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.m_contacto:
                intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.m_acerca:
                intent = new Intent(this, AcercaDeActivity.class);
                startActivity(intent);
                break;

            case R.id.m_refresh:
                intent = new Intent(this, MascotasFavoritasActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
