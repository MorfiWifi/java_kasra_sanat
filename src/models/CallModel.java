package models;

import com.sun.xml.internal.bind.v2.TODO;
import jdk.nashorn.internal.ir.WhileNode;
import network.RetrofitDataProvider;
import network.RetrofitDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utility.ErrorUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tweet Model to send new tweet for request body and get in in response
 * NOTE: all of the attr should define as public and also the name should match in REST API
 */
public class CallModel {
    public int Id;
    public String Message;
    public Date Date;
    private static RetrofitDataService mTService;

    public static ArrayList<CallModel> list = new ArrayList<CallModel>();
    public static void getcallFromServer(JList list , ArrayList<CallModel> List) {
        //List = new ArrayList<>();
        if (TokenModel.isTokenBad()){
            TokenModel.getToken();
        }

        if (TokenModel.isTokenBad()){
            // TODO: 1/15/2018  Break Token is Broken!
        }
        //if (TokenModel.)

        RetrofitDataProvider provider = new RetrofitDataProvider();
        mTService = provider.getTService();
        Call<List<CallModel>> call = mTService.getCalls(TokenModel.TokenSTR);
        //TempFill_Model.GetCurrentToken().Value
        call.enqueue(new Callback<List<CallModel>>() {
            @Override
            public void onResponse(Call<List<CallModel>> call, Response<List<CallModel>> response) {
                if (response.isSuccessful()) {
                    //List = new ArrayList<CallModel>();
                    List.clear();
                    //update the adapter data
                    DefaultListModel demoList = new DefaultListModel();
                    for (int i = 0; i < response.body().size(); i++) {
                        List.add(response.body().get(i));
                        demoList.addElement(response.body().get(i).Message + " : " + response.body().get(i).Date);
                    }

                    list.setModel(demoList);
                    //list.updateUI();
                    //mAdapter.updateAdapterData(response.body());
                    //mAdapter.notifyDataSetChanged();
                    System.out.println("Recoved CallModels Successfully");
                } else {
                    ErrorModel errorModel =ErrorUtils.parseError(response);
                    System.out.println(errorModel.Message);
                    //Toast.makeText(getBaseContext(), "Eror type is " + errorModel.Message + " , description " + errorModel.MessageDetail, Toast.LENGTH_SHORT).show();
                    // TODO: 12/11/2017  add Dialogue For Error
                }
            }

            @Override
            public void onFailure(Call<List<CallModel>> call, Throwable t) {
                //occur when fail to deserialize || no network connection || server unavailable
                //Toast.makeText(getBaseContext(), "Fail it >> " + t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Serious Error in Call List CallModel");
                // TODO: 12/11/2017  add Dialogue For Error
            }
        });
    }
    public static void Edit_CallModel (CallModel callModel , JList list , ArrayList<CallModel> List){
        if (TokenModel.isTokenBad()){
            TokenModel.getToken();
        }
        if (TokenModel.isTokenBad()){
            // TODO: 1/15/2018  Some Real ERROR
        }
        RetrofitDataProvider provider = new RetrofitDataProvider();
        mTService = provider.getTService();
        Call<CallModel> call = mTService.updateCallById(TokenModel.TokenSTR , String.valueOf(callModel.Id), callModel);
        call.enqueue(new Callback<CallModel>() {
            @Override
            public void onResponse(Call<CallModel> call, Response<CallModel> response) {
                if (response.isSuccessful()){

                    System.out.println("Success Edit Call Model");
                    getcallFromServer(list , List);
                }else {
                    System.out.println("mid err in Edit Call Model");
                }

            }

            @Override
            public void onFailure(Call<CallModel> call, Throwable throwable) {
                System.out.println(throwable.getMessage());

            }
        });
    }
    public static void Remove_CallMOdel(CallModel callModel , JList list , ArrayList<CallModel> List){
        if (TokenModel.isTokenBad()){
            TokenModel.getToken();
        }
        if (TokenModel.isTokenBad()){
            // TODO: 1/15/2018  Some Real ERROR
        }
        Call<CallModel> call = mTService.deleteCallById(TokenModel.TokenSTR , String.valueOf(callModel.Id));
        call.enqueue(new Callback<CallModel>() {
            @Override
            public void onResponse(Call<CallModel> call, Response<CallModel> response) {
                if (response.isSuccessful()){

                    System.out.println("Success del Call Model");
                    getcallFromServer(list , List);
                }else {
                    System.out.println("mid err in delet Call Model");
                }

            }

            @Override
            public void onFailure(Call<CallModel> call, Throwable throwable) {
                System.out.println(throwable.getMessage());

            }
        });
    }



}
