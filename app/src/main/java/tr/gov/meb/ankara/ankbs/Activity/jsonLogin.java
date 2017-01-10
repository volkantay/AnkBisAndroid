package tr.gov.meb.ankara.ankbs.Activity;

import com.google.gson.Gson;

import java.io.IOException;

import tr.gov.meb.ankara.ankbs.Service.MethodType;
import tr.gov.meb.ankara.ankbs.Service.RequestPropertyType;
import tr.gov.meb.ankara.ankbs.Service.ReturnType;
import tr.gov.meb.ankara.ankbs.Service.WebServiceSendData;

/**
 * Created by Basak on 2.01.2017.
 */

public class jsonLogin {




public  static Boolean login(String tc, String sifre) {

        WebServiceSendData WSSD = new WebServiceSendData();

        WSSD.setUrl("https://ankara.meb.gov.tr/ankbis/api/mobilapi/login");
        WSSD.setData("{username:'" + tc + "',password:'" + sifre + "'}");
        WSSD.setReturnType(ReturnType.STRING);
        WSSD.setRequestProperty("accept-encoding", "gzip, deflate, gzip, deflate");
        WSSD.setRequestProperty("accept-language", "en-US,en;q=0.8, en-US,en;q=0.8");
        WSSD.setRequestProperty(RequestPropertyType.APPLICATION_JSON);
        WSSD.setRequestMethod(MethodType.POST);
        WSSD.setRequestProperty("accept", "application/json");
        WSSD.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36, Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        try {
            String donus = (String) WSSD.connect();

            Gson gson = new Gson();
/*
            User pojo = gson.fromJson(donus, User.class);

            if (pojo == null || pojo.getToken() == null) {
                return false;
            } else {

                Kullanici = pojo;
                Kullanici.setToken(pojo.getToken());

                return true;
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
