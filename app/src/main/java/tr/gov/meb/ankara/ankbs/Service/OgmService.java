package tr.gov.meb.ankara.ankbs.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import tr.gov.meb.ankara.ankbs.Data.OgmHedefler;

/**
 * Created by Basak on 31.12.2016.
 */

public interface OgmService {

    @Headers({
            "Accept: application/json"
    })
    @GET("ogmlistele")
    Call<List<OgmHedefler>> OgmHedefListesi();

}
