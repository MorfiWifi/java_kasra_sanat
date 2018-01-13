import Forms.DialogueCallsModel;
import Forms.DialogueMainWindow;
import models.ErrorModel;
import models.LogInViewModel;
import network.RetrofitDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utility.ClientConfigs;
import utility.ErrorUtils;
import utility.Init;

public class Main {
    private RetrofitDataService mTService;
    public static  String Token;

    public static void main(String[] args) {
        System.out.println("Now Current Base URL is : " + ClientConfigs.REST_API_BASE_URL);

        Init.Pront_mark();
        System.out.println("Internet in Connected : "+Init.CheckInternet());


        //FormMain main = new FormMain();
        //DialogueCallsModel dialogueCallsModel = new DialogueCallsModel();
        //dialogueCallsModel.setVisible(true);

        DialogueMainWindow.main();
        //DialogueCallsModel.main();
        //dialogueCallsModel.Init();

        System.out.println("Finished RUN");

        //Main nma = new Main();
        //LogInViewModel logInViewModel = new LogInViewModel();
        //logInViewModel.setUserName("admin");
        //logInViewModel.setPassword("bbBB11!!");

        //nma.Login(logInViewModel);

        /*LoginService loginService =
                ServiceGenerator.createService(LoginService.class, "user", "secretpassword");
        UserModel model = new UserModel();
        model.UserName = "admin";
        model.pasword = "bbBB11!!"; // for Example!
        Call<UserModel> call = loginService.basicLogin(model);

        call.enqueue(new Callback<UserModel >() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    // user object available
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                // something went completely south (like no internet connection)
                //Log.d("Error", t.getMessage());
            }
        }) ;*/

    }

    private void Login (LogInViewModel logInViewModel) {
        Call login = mTService.LogIn(logInViewModel);
        login.enqueue(new Callback<LogInViewModel>() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    System.out.print("good");
                    //update the adapter data
                    // mAdapter.updateAdapterData(response.body());
                    // mAdapter.notifyDataSetChanged();
                    //Toast.makeText(getBaseContext(), "Suuccess To Log in To SYS!!!", Toast.LENGTH_SHORT).show();
                } else {
                    System.out.print("ERR 1");
                    ErrorModel errorModel = ErrorUtils.parseError(response);
                   // Toast.makeText(getBaseContext(), "Couldnt Log in" + errorModel.Message + " , description " + errorModel.MessageDetail, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
               // Toast.makeText(getBaseContext(), "Couldnt Log in" + t.getMessage() + " , description " , Toast.LENGTH_SHORT).show();
                System.out.print("ERR 2");            }


        });
    }
}
