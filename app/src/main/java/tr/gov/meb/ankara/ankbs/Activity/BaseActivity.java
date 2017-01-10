package tr.gov.meb.ankara.ankbs.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;
import tr.gov.meb.ankara.ankbs.Data.User;
import tr.gov.meb.ankara.ankbs.DataLayer.OgmHedeflerPersistanceManager;
import tr.gov.meb.ankara.ankbs.DataLayer.UserPersistenceManager;
import tr.gov.meb.ankara.ankbs.Fragments.OgmListesiFragment;
import tr.gov.meb.ankara.ankbs.Fragments.ProfilimFragment;
import tr.gov.meb.ankara.ankbs.R;

import static tr.gov.meb.ankara.ankbs.App.Const.Kullanici;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String TAG = getClass().getSimpleName();

    private UserPersistenceManager userPersistenceManager;
    private OgmHedeflerPersistanceManager ogmPersistenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        Menu menu = navigationView.getMenu();

        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.nav_name);
        nav_user.setText(Kullanici.getAd());

        TextView nav_n = (TextView)hView.findViewById(R.id.nav_surname);
        nav_n.setText(Kullanici.getSoyad());
        // find MenuItem you want to change

        MenuItem nav1 = menu.findItem(R.id.nav_profilim);
        MenuItem  nav2 = menu.findItem(R.id.nav_ogmil);


        // manager objesini oluşturma
        userPersistenceManager = new UserPersistenceManager(this);
        ogmPersistenceManager = new OgmHedeflerPersistanceManager(this);

        // kişileri kaydetme

        User u1= new User();
        u1.set_id(4);
        u1.setAd("volkan");
        u1.setSoyad("tay");
        userPersistenceManager.create(u1);
        userPersistenceManager.create(new User(1, "Barış", "Manço"));
        userPersistenceManager.create(new User(2, "Kemal", "Sunal"));
        userPersistenceManager.create(new User(3, "Barış", "Akarsu"));



        ogmPersistenceManager.create(new OgmHedefler(1, "Sorun1", "Hedef1","Çalişmalar1","Sonuc1" ));
        ogmPersistenceManager.create(new OgmHedefler(2, "Sorun2", "Hedef2","Çalişmalar2","Sonuc2" ));
        ogmPersistenceManager.create(new OgmHedefler(3, "Sorun3", "Hedef34","Çalişmalar3","Sonuc3" ));
        ogmPersistenceManager.create(new OgmHedefler(4, "Sorun4", "Hedef4","Çalişmalar4","Sonuc4" ));

        // kişi listesini alma
        List<User> personList = userPersistenceManager.readAll();
        List<OgmHedefler> ogmlist = ogmPersistenceManager.readAll();
        // kişi listesini yazdırma
        Log.d(TAG, "Kayıtlı kişiler:");
        for (User person : personList) {
            Log.d(TAG, person.toString());
        }

        //OgmListesi

        Log.d(TAG, "Kayıtlı Hedefler:");
        for (OgmHedefler person : ogmlist) {
            Log.d(TAG, ogmlist.toString());
        }
        // ismi Barış olan kişilerin listesini yazdırma
        Log.d(TAG, "İsmi Barış olan kişiler:");
        for (User person : userPersistenceManager.getUsersWithName("Barış")) {
            Log.d(TAG, person.toString());
        }

        Toast.makeText(this, "MERHABA "+ Kullanici.getAd(), Toast.LENGTH_SHORT).show();
        // set new title to the MenuItem
       //nav1.setTitle("ad");
        //ad="tay";
       // nav2.setTitle(soyad) ;
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
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
            Toast.makeText(this, "Ayarlar", Toast.LENGTH_SHORT).show();
        }else if (id== R.id.action_logout){
            Toast.makeText(this, "Çıkış", Toast.LENGTH_SHORT).show();

        }else
        {

            Toast.makeText(this, "Paylaş", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (id == R.id.nav_ogmil) {

            OgmListesiFragment homefragment =  new OgmListesiFragment();

            transaction.replace(R.id.maincontainer,homefragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(null);
            transaction.commit();

            // Handle the camera action
        } else if (id == R.id.nav_profilim) {

            ProfilimFragment pfragment =  new ProfilimFragment();

            transaction.replace(R.id.maincontainer,pfragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.addToBackStack(null);
            transaction.commit();




        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
