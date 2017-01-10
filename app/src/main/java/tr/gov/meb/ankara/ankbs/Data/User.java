package tr.gov.meb.ankara.ankbs.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import tr.gov.meb.ankara.ankbs.DataLayer.PersistenceManager;

/**
 * Created by Basak on 30.12.2016.
 */


@DatabaseTable(tableName = "Users")
public class User implements PersistenceManager.Modal {

    public User(){}

    public User(long id, String ad, String soyad) {
        this._id = id;
        this.ad = ad;
        this.soyad = soyad;
    }
    @DatabaseField(id = true)
    @SerializedName("ID")
    @Expose
    private long _id;



    @DatabaseField
    @SerializedName("Ad")
    @Expose
    private String ad;

    @DatabaseField
    @SerializedName("Soyad")
    @Expose
    private String soyad;

    public long get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @Override
    public long getId() {
        return _id;
    }


    //@Override
  //  public String toString() {return "Kullanıcı: " + ID. + ", " + ad + " " + surName }


}
