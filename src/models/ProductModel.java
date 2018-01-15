package models;


import network.RetrofitDataProvider;
import network.RetrofitDataService;
import utility.ErrorUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.*;

/**
 * Created by m.hosein on 11/10/2017.
 */

public class ProductModel {
    public int Id;
    public String Name;
    public int UnitPrice;
    public int UnitsInStock;
    private static RetrofitDataService mTService;
    public int SupplierId;
    public SupplierModel Supplier;
    public List<Order_DetailsModel> Order_Details;
    public int SellUnitPrice;

    public static ArrayList<ProductModel> lis = new ArrayList<>();




    public static void getProductFromServer(JList list , ArrayList<ProductModel> List) {
        if (TokenModel.isTokenBad()){
            TokenModel.getToken();
        }
        if (TokenModel.isTokenBad()){
            // TODO: 1/15/2018  Problem with Token
        }

        RetrofitDataProvider provider = new RetrofitDataProvider();
        mTService = provider.getTService();
        Call<List<ProductModel>> call = mTService.getProduct(TokenModel.TokenSTR);
        call.enqueue(new Callback<List<ProductModel>>() {
            TempFill_Model temp = new TempFill_Model();
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {

                if (response.isSuccessful()) {
                    List.clear();



                    DefaultListModel demoList = new DefaultListModel();
                    for (int i = 0; i < response.body().size(); i++) {
                        List.add(response.body().get(i));
                        demoList.addElement(response.body().get(i).Name + " , Price :" + response.body().get(i).UnitPrice);
                    }

                    list.setModel(demoList);


                    temp.list = response.body();
                    temp.res = true;
                } else {
                    temp.list = null;
                    temp.res = false;
                    ErrorModel errorModel = ErrorUtils.parseError(response);
                   // Toast.makeText(context, "Error type is " + errorModel.Message + " , description " + errorModel.MessageDetail, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                //occur when fail to deserialize || no network connection || server unavailable
                //Toast.makeText(context, "Fail it >> " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
