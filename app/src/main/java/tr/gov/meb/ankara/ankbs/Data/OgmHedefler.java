package tr.gov.meb.ankara.ankbs.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Basak on 29.12.2016.
 */

public class OgmHedefler extends BaseClass {

    private long ID;
    private String Sorun;
    private String Hedef;
    private String YapilacakCalismlar;
    private String Sonuc;
    private Date BaslangicTarihi;
    private Date BitisTarihi;
    private String KurumKodu;
    private String KurumAdi;

    private List<OgmSorumluOgretmenler> SorumluOgretmenler;
    private List<OgmSorumluYoneticiler> SorumluYoneticiler;


    public OgmHedefler() {
    }

    public OgmHedefler(String sorun, String hedef, String yapilacakCalismlar,
                       String sonuc, Date baslangicTarihi, Date bitisTarihi) {
        Sorun = sorun;
        Hedef = hedef;
        YapilacakCalismlar = yapilacakCalismlar;
        Sonuc = sonuc;
        BaslangicTarihi = baslangicTarihi;
        BitisTarihi = bitisTarihi;
    }

    public String getKurumKodu() {
        return KurumKodu;
    }

    public void setKurumKodu(String kurumKodu) {
        KurumKodu = kurumKodu;
    }

    public String getKurumAdi() {
        return KurumAdi;
    }

    public void setKurumAdi(String kurumAdi) {
        KurumAdi = kurumAdi;
    }

    public List<OgmSorumluOgretmenler> getSorumluOgretmenler() {
        return SorumluOgretmenler;
    }

    public void setSorumluOgretmenler(List<OgmSorumluOgretmenler> sorumluOgretmenler) {
        SorumluOgretmenler = sorumluOgretmenler;
    }

    public List<OgmSorumluYoneticiler> getSorumluYoneticiler() {
        return SorumluYoneticiler;
    }

    public void setSorumluYoneticiler(List<OgmSorumluYoneticiler> sorumluYoneticiler) {
        SorumluYoneticiler = sorumluYoneticiler;
    }



    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getSorun() {
        return Sorun;
    }

    public void setSorun(String sorun) {
        Sorun = sorun;
    }

    public String getHedef() {
        return Hedef;
    }

    public void setHedef(String hedef) {
        Hedef = hedef;
    }

    public String getYapilacakCalismlar() {
        return YapilacakCalismlar;
    }

    public void setYapilacakCalismlar(String yapilacakCalismlar) {
        YapilacakCalismlar = yapilacakCalismlar;
    }

    public String getSonuc() {
        return Sonuc;
    }

    public void setSonuc(String sonuc) {
        Sonuc = sonuc;
    }

    public Date getBaslangicTarihi() {
        return BaslangicTarihi;
    }

    public void setBaslangicTarihi(Date baslangicTarihi) {
        BaslangicTarihi = baslangicTarihi;
    }

    public Date getBitisTarihi() {
        return BitisTarihi;
    }

    public void setBitisTarihi(Date bitisTarihi) {
        BitisTarihi = bitisTarihi;
    }
}
