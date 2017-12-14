package models;

import com.sun.xml.internal.bind.v2.TODO;
import network.FakeDataProvider;
import network.FakeDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utility.ErrorUtils;

import javax.swing.*;
import java.awt.*;
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
    private static FakeDataService mTService;

    public static void getcallFromServer(JList list) {
        FakeDataProvider provider = new FakeDataProvider();
        mTService = provider.getTService();
        Call<List<CallModel>> call = mTService.getCalls();
        call.enqueue(new Callback<List<CallModel>>() {
            @Override
            public void onResponse(Call<List<CallModel>> call, Response<List<CallModel>> response) {
                if (response.isSuccessful()) {
                    //update the adapter data
                    DefaultListModel demoList = new DefaultListModel();
                    for (int i = 0; i < response.body().size(); i++) {
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



}
