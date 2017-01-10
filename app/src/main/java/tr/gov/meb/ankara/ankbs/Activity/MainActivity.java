package tr.gov.meb.ankara.ankbs.Activity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import tr.gov.meb.ankara.ankbs.Activity.BaseActivity;
import tr.gov.meb.ankara.ankbs.Fragments.OgmListesiFragment;
import tr.gov.meb.ankara.ankbs.Fragments.OgmDetayFragment;
import tr.gov.meb.ankara.ankbs.Fragments.OgmEkleDuzenleFragment;
import tr.gov.meb.ankara.ankbs.R;

public class MainActivity extends BaseActivity
        implements OgmListesiFragment.OgmListesiFragmentListener,
        OgmDetayFragment.OgmDetayFragmentListener,
        OgmEkleDuzenleFragment.OgmEkleDuzenleFragmentListener {


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
