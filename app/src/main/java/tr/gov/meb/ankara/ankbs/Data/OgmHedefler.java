package tr.gov.meb.ankara.ankbs.Data;


import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.lang.reflect.Type;
import java.util.List;

import tr.gov.meb.ankara.ankbs.DataLayer.PersistenceManager;


@DatabaseTable(tableName = "OgmHedefler")
public class OgmHedefler extends BaseClass implements PersistenceManager.Modal {

    public OgmHedefler(){}

    public OgmHedefler(long id,
                       String sorun,
                       String hedef,
                       String calişmalar,
                       String sonuc){

        ID=id;
        this.sorun=sorun;
        this.hedef =hedef;
        this.yapilacakCalismalar =calişmalar;
        this.sonuc =sonuc;

    }


    @DatabaseField
    @SerializedName("ID")
    @Expose
    private long ID;


    @DatabaseField
    @SerializedName("Sorun")
    @Expose
    private String sorun;

    @DatabaseField
    @SerializedName("Hedef")
    @Expose
    private String hedef;

    @DatabaseField
    @SerializedName("YapilacakCalismalar")
    @Expose
    private String yapilacakCalismalar;

    @DatabaseField
    @SerializedName("BaslamaTarihi")
    @Expose
    private String baslamaTarihi;


    @DatabaseField
    @SerializedName("BitisTarihi")
    @Expose
    private String bitisTarihi;

    @DatabaseField
    @SerializedName("Sonuc")
    @Expose
    private String sonuc;


    @DatabaseField
    @SerializedName("KurumKodu")
    @Expose
    private String kurumKodu;

    @DatabaseField
    @SerializedName("KurumAdi")
    @Expose
    private String kurumAdi;

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getSorun() {
        return sorun;
    }

    public void setSorun(String sorun) {
        this.sorun = sorun;
    }

    public String getHedef() {
        return hedef;
    }

    public void setHedef(String hedef) {
        this.hedef = hedef;
    }

    public String getYapilacakCalismalar() {
        return yapilacakCalismalar;
    }

    public void setYapilacakCalismalar(String yapilacakCalismalar) {
        this.yapilacakCalismalar = yapilacakCalismalar;
    }

    public String getBaslamaTarihi() {
        return baslamaTarihi;
    }

    public void setBaslamaTarihi(String baslamaTarihi) {
        this.baslamaTarihi = baslamaTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public String getKurumKodu() {
        return kurumKodu;
    }

    public void setKurumKodu(String kurumKodu) {
        this.kurumKodu = kurumKodu;
    }

    public String getKurumAdi() {
        return kurumAdi;
    }

    public void setKurumAdi(String kurumAdi) {
        this.kurumAdi = kurumAdi;
    }

    public static List<OgmHedefler> getData(){
        Gson gson = new Gson();
        String jsonString = "[{\"id\":ID,\"Hedef\":\"hedef\"," +
                "\"sorun\":\"sorun\"}]";
        Type type = new TypeToken<List<OgmHedefler>>(){}.getType();
        return gson.fromJson(jsonString, type);
    }

    @Override
    public long getId() {
        return ID;
    }

    public long getID() {
        return ID;
    }
}