package tr.gov.meb.ankara.ankbs.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;

/**
 * Created by Basak on 28.12.2016.
 */

public class OgmDetayFragment extends Fragment {

    private OgmDetayFragmentListener dinleyici;
    public interface OgmDetayFragmentListener{
        public void ogmsilindi();
        public void ogmduzenle();
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //View daki nesneleri alıyoruz



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public OgmHedefler OgmDetayGetir(int id){
        OgmHedefler hedef = new OgmHedefler();
        // Veri tabanına bağlan Modeli al ve gönder

        return null;
    };

    @Override
    public void onResume() {
        super.onResume();
       //değişiklik durumunda veriyi tekrar getiriyoruz
        //OgmDetayGetir(id);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dinleyici = (OgmDetayFragmentListener) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        dinleyici =null;
    }
}
