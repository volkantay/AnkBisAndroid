package tr.gov.meb.ankara.ankbs.DataLayer;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;
import tr.gov.meb.ankara.ankbs.Data.User;

/**
 * Created by Basak on 4.01.2017.
 */

public class OgmHedeflerPersistanceManager  extends PersistenceManager<OgmHedefler>  {


    public OgmHedeflerPersistanceManager(Context context) {
        super(context, OgmHedefler.class);
    }

    public List<OgmHedefler> getHedefwithKurumKodu(String name) {

        // query for all users which has the given name
        try {
            return dao.query(dao.queryBuilder().where().eq("KurumKodu", name).prepare());

        } catch (SQLException e) {

            e.printStackTrace();
            return new ArrayList<OgmHedefler>();
        }
    }


  /*  public boolean synckontrol(List<OgmHedefler> hedef) {

        // query for all users which has the given name
        try {

            List<OgmHedefler>  l1=  readAll();






        } catch (SQLException e) {

            e.printStackTrace();
            return new ArrayList<OgmHedefler>();
        }
    }*/



}
