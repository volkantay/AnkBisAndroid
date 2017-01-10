package tr.gov.meb.ankara.ankbs.Activity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import tr.gov.meb.ankara.ankbs.Activity.BaseActivity;
import tr.gov.meb.ankara.ankbs.Data.User;
import tr.gov.meb.ankara.ankbs.DataLayer.UserPersistenceManager;
import tr.gov.meb.ankara.ankbs.Fragments.OgmListesiFragment;
import tr.gov.meb.ankara.ankbs.Fragments.OgmDetayFragment;
import tr.gov.meb.ankara.ankbs.Fragments.OgmEkleDuzenleFragment;
import tr.gov.meb.ankara.ankbs.R;

public class MainActivity extends BaseActivity
        implements OgmListesiFragment.OgmListesiFragmentListener,
        OgmDetayFragment.OgmDetayFragmentListener,
        OgmEkleDuzenleFragment.OgmEkleDuzenleFragmentListener {


    private String TAG = getClass().getSimpleName();

    private UserPersistenceManager userPersistenceManager;
    private OgmListesiFragment ogmlistesifragment;
    private static String ID= "_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Yapılandırmalarda tekrar fragment oluşturmamak için kullanılıyor.
        if(savedInstanceState!=null){
            return;
        }

        // manager objesini oluşturma
        userPersistenceManager = new UserPersistenceManager(this);

        // kişileri kaydetme

        User u1= new User();
        u1.set_id(4);
        u1.setAd("volkan");
        u1.setSoyad("tay");
        userPersistenceManager.create(u1);
        userPersistenceManager.create(new User(1, "Barış", "Manço"));
        userPersistenceManager.create(new User(2, "Kemal", "Sunal"));
        userPersistenceManager.create(new User(3, "Barış", "Akarsu"));

        // kişi listesini alma
        List<User> personList = userPersistenceManager.readAll();

        // kişi listesini yazdırma
        Log.d(TAG, "Kayıtlı kişiler:");
        for (User person : personList) {
            Log.d(TAG, person.toString());
        }

        // ismi Barış olan kişilerin listesini yazdırma
        Log.d(TAG, "İsmi Barış olan kişiler:");
        for (User person : userPersistenceManager.getUsersWithName("Barış")) {
            Log.d(TAG, person.toString());
        }

        // kullanıcları listview'da gösterme
       // ((ListView) findViewById(R.id.personList))
        //        .setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, personList));


        if(findViewById(R.id.activity_container)!= null){
            //telefon
            // ogmlistesifragmentine oluşturup listeyi ona ekliyoruz.
            ogmlistesifragment = new OgmListesiFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.activity_container,ogmlistesifragment);
            transaction.commit();

        }

    }

    @Override
    public void secilenItem(long id) {

        if(findViewById(R.id.activity_container)!= null){
            //Telefon
            OgmDetayFragmentiniAc(id,R.id.activity_container);
        }
        else {
            //Tablet

            getSupportFragmentManager().popBackStack();
            OgmDetayFragmentiniAc(id,R.id.sagfragmentcontainer);
        }

    }

    private void OgmDetayFragmentiniAc(long id, int containerId) {

        Bundle arguments= new Bundle();
        arguments.putLong(ID,id);

        OgmDetayFragment ogmdetayfragment =  new OgmDetayFragment();
        ogmdetayfragment.setArguments(arguments);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId,ogmdetayfragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void ogmEkleme(Bundle arguments) {

        if(findViewById(R.id.activity_container)!= null){
            //Telefon
            OgmEkleFragmentiniAc(R.id.activity_container,null);
        }
        else {
            //Tablet

            getSupportFragmentManager().popBackStack();
            OgmEkleFragmentiniAc(R.id.sagfragmentcontainer,null);
        }
    }

    private void OgmEkleFragmentiniAc(int activity_container, Object o) {

    }



    @Override
    public void OgmEkleDuzenleIslemiYapildi(long id) {

    }

    @Override
    protected void onResume() {

        super.onResume();

        // Tablet ise ogmlistesifragment içi boş olacak
        if (ogmlistesifragment == null){
            // tablet ise

            ogmlistesifragment = (OgmListesiFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragmentogmlistesi);

        }

    }

    @Override
    public void ogmsilindi() {

    }

    @Override
    public void ogmduzenle() {

    }
}
