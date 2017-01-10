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
public class userankbis  implements PersistenceManager.Modal{



    @DatabaseField(id = true)
    @SerializedName("ID")
    @Expose
    private int Id;

    @DatabaseField
    @SerializedName("Personel")
    @Expose
    private Object personel;


    @DatabaseField
    @SerializedName("Ad")
    @Expose
    private String ad;

    @DatabaseField
    @SerializedName("Soyad")
    @Expose
    private String soyad;

    @DatabaseField
    @SerializedName("DogumTarihi")
    @Expose
    private String dogumTarihi;

    @DatabaseField
    @SerializedName("Email")
    @Expose
    private String email;

    @DatabaseField
    @SerializedName("Cep")
    @Expose
    private String cep;

    @DatabaseField
    @SerializedName("Token")
    @Expose
    private String token;

    public long getID() {
        return Id;
    }

    public void setID(int iD) {
        this.Id = iD;
    }

    public Object getPersonel() {
        return personel;
    }

    public void setPersonel(Object personel) {
        this.personel = personel;
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

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public long getId() {
        return 0;
    }


    //@Override
    //  public String toString() {return "Kullanıcı: " + ID. + ", " + ad + " " + surName }


}
