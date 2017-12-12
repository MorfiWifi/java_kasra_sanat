package network;

import models.UserModel;
import retrofit2.Callback;
import retrofit2.http.POST;

/**
 * Created by WifiMorfi on 12/12/2017.
 */
public interface LoginService {
    @POST("/login")
    void basicLogin(Callback<UserModel> cb);
}
