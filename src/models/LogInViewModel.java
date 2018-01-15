package models;

import network.RetrofitDataProvider;
import network.RetrofitDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utility.ErrorUtils;

import javax.swing.*;

/**
 * Created by WifiMorfi on 12/9/2017.
 */

public class LogInViewModel {
    String UserName;
    String Password;
    private static RetrofitDataService mTService;

    public void setPassword(String password) {
        Password = password;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserName() {
        return UserName;
    }


/*
    public static void LoginAsync(JList list , LogInViewModel logInViewModel) {
        RetrofitDataProvider provider = new RetrofitDataProvider();
        mTService = provider.getTService();
        Call<String> call = mTService.LoginAsync(logInViewModel);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    //update the adapter data
                    DefaultListModel demoList = new DefaultListModel();

                    demoList.addElement("The Token Cookie is : "+response.body().toString() );


                    list.setModel(demoList);
                    //list.updateUI();
                    //mAdapter.updateAdapterData(response.body());
                    //mAdapter.notifyDataSetChanged();
                    System.out.println("LoginAsnc Succcess");
                } else {
                    ErrorModel errorModel = ErrorUtils.parseError(response);
                    //Toast.makeText(getBaseContext(), "Error type is " + errorModel.Message + " , description " + errorModel.MessageDetail, Toast.LENGTH_SHORT).show();
                    // TODO: 12/11/2017  add Dialogue For Error
                    System.out.println("Mid ERROR or Bad Type in LoginAsnc");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {

                System.out.println("Fatality Error in LoginAsync");
            }




        });
    }*/
}
