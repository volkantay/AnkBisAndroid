package tr.gov.meb.ankara.ankbs.App;

import tr.gov.meb.ankara.ankbs.Data.User;

/**
 * Created by Basak on 30.12.2016.
 *
 * Burada program için gerekli olan sabitler ve rest URL yer alacak
 */

public class Const {

    public static final String getOgmList = "https://ankara.meb.gov.tr/ankbis/api/mobilapi/";
    public static final String tc ="12345678901";
    public static final String ad = "Ankbis";
    public static final String soyad ="Ankbis";

    public static User Kullanici = new User();

    //public static final String BASE_URL_APP = "http://ankara.meb.gov.tr/ankbis/api/mobil/";
    public static final String BASE_URL_APP = "https://ankara.meb.gov.tr/ankbis/api/mobilapi/";
   // public static final String BASE_URL_APP = "http://volkantay.com/api/mobilapi/";
    public static final String authToken = "Barreer 2345534";
    public static final String[] HEADERS = {"Accept: application/json"};



}
