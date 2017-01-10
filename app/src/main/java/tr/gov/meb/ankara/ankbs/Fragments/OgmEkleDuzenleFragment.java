package tr.gov.meb.ankara.ankbs.Fragments;

import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.*;

import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;
import tr.gov.meb.ankara.ankbs.R;

/**
 * Created by Basak on 28.12.2016.
 */

public class OgmEkleDuzenleFragment extends Fragment {

    private EditText sorun,hedef,calismalar,baslangictarihi;
    private Calendar bitistarihi;
    private Spinner sorumluogretmenler;
    private Button kaydet;
    private TextInputLayout textInputLayout;
    private Bundle arguments;
    private long id;


    private OgmEkleDuzenleFragmentListener dinleyici;
    public interface OgmEkleDuzenleFragmentListener{
        public void OgmEkleDuzenleIslemiYapildi(long id);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dinleyici = (OgmEkleDuzenleFragmentListener) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        dinleyici =null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ekle_duzenle_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sorun = (EditText) getActivity().findViewById(R.id.sorun);
        hedef = (EditText) getActivity().findViewById(R.id.hedef);
        calismalar = (EditText) getActivity().findViewById(R.id.calismalar);
        baslangictarihi = (EditText) getActivity().findViewById(R.id.baslangictarihi);
        kaydet = (Button) getActivity().findViewById(R.id.btnkaydet);
        sorumluogretmenler = (Spinner) getActivity().findViewById(R.id.sorumluogretmenler);
        textInputLayout= (TextInputLayout) getActivity().findViewById(R.id.HedefInputLayout);

        arguments = getArguments();
        // Hedef Düzenleme İŞlemi yapılıyor

        if (arguments!=null)
        {
            //id= arguments.getLong(MainActivity.ID); ID gelmiyor
            sorun.setText(arguments.getString("sorun"));
            hedef.setText(arguments.getString("hedef"));
            calismalar.setText(arguments.getString("calismalar"));
            baslangictarihi.setText(arguments.getString("baslangictarihi"));


        }

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sorun.getText().toString().trim().length()!=0 ){
                    kaydetguncelle();
                    dinleyici.OgmEkleDuzenleIslemiYapildi(id);
                }
                else{
                    textInputLayout.setError("Sorun Alanını Giriniz");
                    sorun.requestFocus();
                }


            }
        });

    }

    private void kaydetguncelle() {

        OgmHedefler hedefs = new OgmHedefler();
        hedefs.setSorun(sorun.getText().toString());

        hedefs.setHedef(hedef.getText().toString());
        hedefs.setYapilacakCalismalar(calismalar.getText().toString());
       // hedefs.setBitisTarihi(bitistarihi.getDisplayName());
        //hedefs.setBaslangicTarihi(baslangictarihi.getText());


        if(arguments == null)
        {
            //Yeni Kayıt Girişi



        }else{
            //Güncelleme

        }
    }
}
