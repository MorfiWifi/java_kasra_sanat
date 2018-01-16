package models;

import com.sun.corba.se.impl.oa.toa.TOA;
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
    public final static String bad = "BADTOKEN";

    private static RetrofitDataService mTService;
    public String access_token;
  //  public Long expire_in_sec;
    //public Date expire_at;
   // public String refresh_token;
    public String app_id;
    public String Value;

    public static  String TokenSTR = "";

    public static void getToken (){

        if (isTokenGood()){
            return;
        }

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

                    TokenSTR = bad;
                    System.out.println("Minor Error in Token!!");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                TokenSTR = bad;
                System.out.println("Serious Error in Togen!");
            }
        });
        WaitForToken();
    }
    public static String getToken (String Usernaeme , String pass){

        if (isTokenGood()){
            return "";
        }

        RetrofitDataProvider provider = new RetrofitDataProvider();
        mTService = provider.getTService();

        LogInViewModel logInViewModel = new LogInViewModel();
        logInViewModel.setUserName(Usernaeme);
        logInViewModel.setPassword(pass);

        Call<String> call = mTService.getToken(logInViewModel);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()){
                    TokenSTR = response.body();
                    System.out.println("Token Good : "+ response.body());
                }else {

                    TokenSTR = bad;
                    System.out.println("Minor Error in Token!!");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                TokenSTR = bad;
                System.out.println("Serious Error in Togen!");
            }
        });
        WaitForToken();
        return TokenSTR;
    }
    public static boolean isTokenGood (){
        if (TokenSTR.equals(bad)){
            return false;
        }
        if (TokenSTR.equals("")){
            return false;
        }
        return true;

    }
    public static boolean isTokenEmpty () {
        if (TokenSTR.equals("")){
            return true;
        }
        return false;
    }
    public static boolean isTokenBad (){
        if (TokenSTR.equals(bad)){
            return true;
        }
        if (TokenSTR.equals("")){
            return true;
        }
        return false;
    }
    public static void  WaitForToken (){
            while (TokenModel.isTokenEmpty()){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}
