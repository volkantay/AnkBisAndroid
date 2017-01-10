package tr.gov.meb.ankara.ankbs.Fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import org.w3c.dom.Text;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.List;

import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;
import tr.gov.meb.ankara.ankbs.Data.User;
import tr.gov.meb.ankara.ankbs.DataLayer.OgmHedeflerPersistanceManager;
import tr.gov.meb.ankara.ankbs.R;


public class CustomAdapter extends BaseAdapter {


    private Context context;
    private List<OgmHedefler> hedeflistesi;
    private OgmHedeflerPersistanceManager ogmPersistenceManager;


    public CustomAdapter(Context context, List<OgmHedefler> gelenogmlistesi) {
        this.context=context;
        this.hedeflistesi= gelenogmlistesi;
    }

    @Override
    public int getCount() {

        if (hedeflistesi!=null)
        return hedeflistesi.size();
        return 0;

    }

    @Override
    public Object getItem(int position) {
        if (hedeflistesi!=null)
        return hedeflistesi.get(position);

        return  null;

    }

    @Override
    public long getItemId(int position) {

        if (hedeflistesi!=null)
            return hedeflistesi.get(position).getID();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (hedeflistesi==null)
        return null;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View container = inflater.inflate( R.layout.custom_ogmlist, null );


        //ImageView profil= (ImageView) container.findViewById(R.id.profil_custom_list);
        TextView soruntv= (TextView) container.findViewById(R.id.sorunCustomList);
        TextView hedeftv= (TextView) container.findViewById(R.id.hedefCustomList);
        TextView yapıilcakCalismalar= (TextView) container.findViewById(R.id.yapilanCalismalarCustomList);
        TextView sonuctv= (TextView) container.findViewById(R.id.sonucCustomList);
        TextView baslangicTarihi= (TextView) container.findViewById(R.id.baslamaTarihiCustomList);
        TextView bitisTarihi= (TextView) container.findViewById(R.id.bitisTarihiCustomList);

        // Model den gelen verileri alıp teker teker tabloya dolduruyoruz.


        Type listType = new TypeToken<List<OgmHedefler>>() {}.getType();

       // List<OgmHedefler> serialDetails = new Gson().fromJson((JsonElement) hedeflistesi, listType);

        Gson gson = new Gson();

        ogmPersistenceManager = new OgmHedeflerPersistanceManager(context);
        List<OgmHedefler> ogmlist = ogmPersistenceManager.readAll();
       // OgmHedefler hedef= hedeflistesi.get(position);

        OgmHedefler hedef = ogmlist.get(position);

       hedeftv.setText(hedef.getHedef().toString());
       // hedeftv.setText(ogmlist.get(position).getHedef());
        String text ="wedsa";
        soruntv.setText(text);
        yapıilcakCalismalar.setText(hedef.getYapilacakCalismalar());
        baslangicTarihi.setText(hedef.getBaslamaTarihi());
       bitisTarihi.setText(hedef.getBitisTarihi());


       /* if (model.getProfilFoto() != null) {

            byte[] bytes = model.getProfilFoto();
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            profil.setImageBitmap(bitmap);
        }*/

        return container;


    }
}
