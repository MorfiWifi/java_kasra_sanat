package models;

import network.RetrofitDataProvider;
import network.RetrofitDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.security.PublicKey;
import java.util.Date;

/**
 * Token Model used in sign in, sign up and refresh token response
 */
public class TokenModel {
    private static RetrofitDataService mTService;
    public String access_token;
  //  public Long expire_in_sec;
    //public Date expire_at;
   // public String refresh_token;
    public String app_id;
    public String Value;

    public static  String TokenSTR = "";

    public static void getToken (){
        RetrofitDataProvider provider = new RetrofitDataProvider();
        mTService = provider.getTService();

        LogInViewModel logInViewModel = new LogInViewModel();
        logInViewModel.setUserName("admin");
        logInViewModel.setPassword("bbBB11!!");

        Call<String> call = mTService.getToken(logInViewModel);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()){
                    TokenSTR = response.body();
                    System.out.println("Token Good : "+ response.body());
                }else {

                    System.out.println("Minor Error in Token!!");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                System.out.println("Serious Error in Togen!");
            }
        });
    }
}
