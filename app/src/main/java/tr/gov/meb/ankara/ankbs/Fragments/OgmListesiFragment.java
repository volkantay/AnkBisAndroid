package tr.gov.meb.ankara.ankbs.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;
import tr.gov.meb.ankara.ankbs.Data.User;
import tr.gov.meb.ankara.ankbs.R;
import tr.gov.meb.ankara.ankbs.Service.OgmService;
import tr.gov.meb.ankara.ankbs.Service.ReturnType;
import tr.gov.meb.ankara.ankbs.Service.ServiceGenerator;

import tr.gov.meb.ankara.ankbs.Service.WebServiceGetData;

import static tr.gov.meb.ankara.ankbs.App.Const.authToken;

/**
 * Created by Basak on 28.12.2016.
 */

public class OgmListesiFragment extends Fragment  {

    private FloatingActionButton fab;
    private TextView tv_bos;
    private ListView liste;
    private CustomAdapter customAdapter;

    private OgmListesiFragmentListener dinleyici;

    public interface OgmListesiFragmentListener{
         public  void secilenItem(long id);
         public  void ogmEkleme(Bundle arguments);


}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ogmlistesifragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);
        // Ekran çevrildiği zaman fragmenti öldürmesi diye tutuyoruz.
        //ekran çevrildiğinde yeniden oluşturma işlemini alıkoyar


        liste= (ListView) getActivity().findViewById(R.id.ogmlist);
        tv_bos = (TextView) getActivity().findViewById(R.id.tv_bos);
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);


        liste.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              dinleyici.secilenItem(id);

            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //tıklandığı zaman listenelerden kişi ekleme fragmentini çağtmamız gerekiyor
                //dinleyici.ogmEkleme();
            }
        });

        // veri tabanı işlemlerinin yapılması gerekiyor

      // List<OgmHedefler> gelenogmlistesi = ogmlistesigetir();
        List<OgmHedefler> gelenogmlistesi=HedefListesi();
        //getir();
        // Liste boş dolu kontrolu

        if(gelenogmlistesi==null){
            tv_bos.setText("Şu Anda Herhangi bir Kayıt Bulunmuyor");
        }else{
            //Customadapter context ve veri listesini gönderiyoruz
            // Liste dğüzenleniyor
            customAdapter = new CustomAdapter(getActivity(),gelenogmlistesi);
            // Liste ye adpterdeki düzenlenen listeyi aktarıyoruz
            liste.setAdapter(customAdapter);


        }





    }


    public List<OgmHedefler> HedefListesi() {

        WebServiceGetData WSSD = new WebServiceGetData();
        WSSD.setUrl("https://ankara.meb.gov.tr/ankbis/api/mobilapi/ogmlistele");
        WSSD.setReturnType(ReturnType.JSON);

        try {
            //String donus = (String) WSSD.connect();


            List<OgmHedefler> pojoList = null;//(List<OgmHedefler>) gson.fromJson(donus, OgmHedefler.class);

            pojoList = (List<OgmHedefler>) WSSD.connect();


            if (pojoList != null && !pojoList.isEmpty()) {
                System.out.println(pojoList);

                return pojoList;


            }


        } catch (IOException e) {
            e.printStackTrace();

        }
        return  null;

    }











    private List<OgmHedefler> ogmlistesigetir() {


        //REST Adaptor ile hangi servise bağlanacağımızı belirtiyoruz.
        OgmService service = ServiceGenerator.createService(OgmService.class,authToken);


        final List<OgmHedefler> gelenHedefListesi = null;

        // Fetch and print a list of the contributors to this library.
        Call<List<OgmHedefler>> call2 =
                service.OgmHedefListesi();


        call2.enqueue(new Callback<List<OgmHedefler>>() {
            @Override
            public void onResponse(Call<List<OgmHedefler>> call, final Response<List<OgmHedefler>> response) {

                if (response.isSuccessful()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            for (OgmHedefler hedef : response.body()) {
                                OgmHedefler h = new OgmHedefler();
                                h.setHedef(hedef.getHedef());
                                h.setSorun(hedef.getSorun());
                                Toast.makeText(getActivity(), hedef.getHedef().toString(), Toast.LENGTH_LONG).show();


                                gelenHedefListesi.add(h);
                                Log.i("onResponse", hedef.toString());
                            }


                        }
                    });


                }



            }

            @Override
            public void onFailure(Call<List<OgmHedefler>> call, Throwable t) {
                Toast.makeText(getActivity(),"HAta",Toast.LENGTH_LONG).show();
            }
        });





        //  gelenHedefListesi = call2.execute().body();


        return gelenHedefListesi;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       // dinleyici = (OgmListesiFragmentListener) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        dinleyici =null;
    }


    public void guncelle(){

        List<OgmHedefler> gelenogmlistesi = ogmlistesigetir();

        // Liste boş dolu kontrolu

        if(gelenogmlistesi==null){
            tv_bos.setText("Şu Anda Herhangi bir Kayıt BUlunmuyor");
        }else{
            //Customadapter context ve veri listesini gönderiyoruz
            // Liste dğüzenleniyor
            customAdapter = new CustomAdapter(getActivity(),gelenogmlistesi);
            // Liste ye adpterdeki düzenlenen listeyi aktarıyoruz
            liste.setAdapter(customAdapter);
        }
    }


}
