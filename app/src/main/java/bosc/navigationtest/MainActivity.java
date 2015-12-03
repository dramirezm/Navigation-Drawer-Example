package bosc.navigationtest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import bosc.navigationtest.fragments.FRagmentoTres;
import bosc.navigationtest.fragments.FragmentDos;
import bosc.navigationtest.fragments.FragmentUno;


public class MainActivity extends ActionBarActivity {
    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater factory = LayoutInflater.from(getApplicationContext());

        final View view = factory.inflate(R.layout.header_navview, null);



        appbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(appbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.leave1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navView = (NavigationView)findViewById(R.id.navview);
        foto = (ImageView)view.findViewById(R.id.foto);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.menu_seccion_1:
                        fragment = new FragmentUno();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_seccion_2:
                        fragment = new FragmentDos();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_seccion_3:
                        fragment = new FRagmentoTres();
                        fragmentTransaction = true;
                        break;

                }

                if (fragmentTransaction) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();

                    menuItem.setChecked(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());
                }

                drawerLayout.closeDrawers();

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            //...
        }

        return super.onOptionsItemSelected(item);
    }
}
