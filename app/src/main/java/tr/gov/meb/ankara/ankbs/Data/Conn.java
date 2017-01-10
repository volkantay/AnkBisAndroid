package tr.gov.meb.ankara.ankbs.Data;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basak on 2.01.2017.
 */

public class Conn extends AsyncTask<String,String,List<OgmHedefler>> {


    private String urlString = "https://ankara.meb.gov.tr/ankbis/api/mobilapi/ogmlistele";
    List<OgmHedefler> liste = null;

    @Override
    protected List<OgmHedefler> doInBackground(String... params) {

       liste= new ArrayList<OgmHedefler>();
        HttpURLConnection connection = null;
        URL url;
       // url = new URL(params[0]);


        return liste;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List<OgmHedefler> ogmHedeflers) {
        super.onPostExecute(ogmHedeflers);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
