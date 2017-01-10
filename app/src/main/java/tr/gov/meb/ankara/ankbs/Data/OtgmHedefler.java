package tr.gov.meb.ankara.ankbs.Data;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import tr.gov.meb.ankara.ankbs.Data.BaseClass;

class OtgmHedefler extends BaseClass {

    @SerializedName("ID")
    @Expose
    private long ID;
    @SerializedName("Sorun")
    @Expose
    private String sorun;
    @SerializedName("Hedef")
    @Expose
    private String hedef;
    @SerializedName("YapilacakCalismalar")
    @Expose
    private String yapilacakCalismalar;
    @SerializedName("BaslamaTarihi")
    @Expose
    private String baslamaTarihi;
    @SerializedName("BitisTarihi")
    @Expose
    private String bitisTarihi;
    @SerializedName("Sonuc")
    @Expose
    private String sonuc;
    @SerializedName("Tamamlandi")
    @Expose
    private Boolean tamamlandi;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("IlAciklama")
    @Expose
    private String ilAciklama;
    @SerializedName("IlceAciklama")
    @Expose
    private String ilceAciklama;
    @SerializedName("ArgeAciklama")
    @Expose
    private String  argeAciklama;
    @SerializedName("KurumKodu")
    @Expose
    private String kurumKodu;
    @SerializedName("KurumAdi")
    @Expose
    private String kurumAdi;
    @SerializedName("Ilce")
    @Expose
    private String ilce;
    @SerializedName("Ilce_IlceAdi")
    @Expose
    private String ilceIlceAdi;
    @SerializedName("Gorev")
    @Expose
    private Object gorev;
    @SerializedName("Gorev_GorevAdi")
    @Expose
    private Object gorevGorevAdi;
    @SerializedName("OnayTipi")
    @Expose
    private Integer onayTipi;
    @SerializedName("OnayAsama")
    @Expose
    private Integer onayAsama;
    @SerializedName("SorumluOgretmenList")
    @Expose
    private List<OgmSorumluOgretmenler> sorumluOgretmenList = null;
    @SerializedName("SorumluYoneticiList")
    @Expose
    private List<OgmSorumluYoneticiler> sorumluYoneticiList = null;
    @SerializedName("Onaylar")
    @Expose
    private Object onaylar;

    public long getID() {
        return ID;
    }

    public void setiD(long iD) {
        this.ID = iD;
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

    public Boolean getTamamlandi() {
        return tamamlandi;
    }

    public void setTamamlandi(Boolean tamamlandi) {
        this.tamamlandi = tamamlandi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getIlAciklama() {
        return ilAciklama;
    }

    public void setIlAciklama(String ilAciklama) {
        this.ilAciklama = ilAciklama;
    }

    public String getIlceAciklama() {
        return ilceAciklama;
    }

    public void setIlceAciklama(String ilceAciklama) {
        this.ilceAciklama = ilceAciklama;
    }

    public String getArgeAciklama() {
        return argeAciklama;
    }

    public void setArgeAciklama(String argeAciklama) {
        this.argeAciklama = argeAciklama;
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

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getIlceIlceAdi() {
        return ilceIlceAdi;
    }

    public void setIlceIlceAdi(String ilceIlceAdi) {
        this.ilceIlceAdi = ilceIlceAdi;
    }

    public Object getGorev() {
        return gorev;
    }

    public void setGorev(Object gorev) {
        this.gorev = gorev;
    }

    public Object getGorevGorevAdi() {
        return gorevGorevAdi;
    }

    public void setGorevGorevAdi(Object gorevGorevAdi) {
        this.gorevGorevAdi = gorevGorevAdi;
    }

    public Integer getOnayTipi() {
        return onayTipi;
    }

    public void setOnayTipi(Integer onayTipi) {
        this.onayTipi = onayTipi;
    }

    public Integer getOnayAsama() {
        return onayAsama;
    }

    public void setOnayAsama(Integer onayAsama) {
        this.onayAsama = onayAsama;
    }

    public List<OgmSorumluOgretmenler> getSorumluOgretmenList() {
        return sorumluOgretmenList;
    }

    public void setSorumluOgretmenList(List<OgmSorumluOgretmenler> sorumluOgretmenList) {
        this.sorumluOgretmenList = sorumluOgretmenList;
    }

    public List<OgmSorumluYoneticiler> getSorumluYoneticiList() {
        return sorumluYoneticiList;
    }

    public void setSorumluYoneticiList(List<OgmSorumluYoneticiler> sorumluYoneticiList) {
        this.sorumluYoneticiList = sorumluYoneticiList;
    }

    public Object getOnaylar() {
        return onaylar;
    }

    public void setOnaylar(Object onaylar) {
        this.onaylar = onaylar;
    }
}


