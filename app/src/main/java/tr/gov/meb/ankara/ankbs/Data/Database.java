package tr.gov.meb.ankara.ankbs.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Basak on 29.12.2016.
 */

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ankbis";
    private static final String TABLE_NAME = "OGMHedefler";
    private static final int DATABASE_VERSION = 1;

    // kolon isimleri

    private static final String ID="_id";
    private static final String SORUN="sorun";
    private static final String HEDEF="hedef";
    private static final String YAPILACAK_CALISMALAR ="yapilacak_calismlar";
    private static final String BASLANGIC_TARIHI ="baslangic_tarihi";
    private static final String BITIS_TARIHI="bitis_tarihi";



    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int Kaydet( OgmHedefler entity){
    return -1;
    }

    public int Guncelle(long id, OgmHedefler entity){
        return -1;
    }

}
