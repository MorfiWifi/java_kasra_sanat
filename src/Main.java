import Forms.DialogueFirst;
import Forms.FormMain;
import models.UserModel;
import network.LoginService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sun.rmi.runtime.Log;
import utility.ServiceGenerator;

public class Main {

    public static void main(String[] args) {
        //FormMain main = new FormMain();
        DialogueFirst dialogueFirst = new DialogueFirst();
        //dialogueFirst.Init();

        System.out.println("Finished RUN");

        LoginService loginService =
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
        }) ;

    }
}
