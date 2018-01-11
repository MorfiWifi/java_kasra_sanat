package models;

import java.util.List;

/**
 * Created by WifiMorfi on 12/2/2017.
 */

public class TempFill_Model {
    List list;
    boolean res;
    private static TokenModel tokenModel;

    public static TokenModel GetCurrentToken() {
        if (tokenModel == null){
            tokenModel = new TokenModel();
        }
        return tokenModel;
    }
}
