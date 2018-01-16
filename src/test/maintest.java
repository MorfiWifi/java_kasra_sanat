package test;


import models.TokenModel;
import org.junit.Test;
import utility.Init;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by WifiMorfi on 1/13/2018.
 */
public class maintest {

    @Test
    public void InternetConnect(){
        assertEquals("Connectivity" , true , Init.CheckInternet());
    }

    @Test
    public void Token(){

        TokenModel.TokenSTR  = "";
        TokenModel.getToken("lablavb" , "ladsadasda");
        assertEquals("Check tokrn" , false , TokenModel.isTokenGood());
        TokenModel.TokenSTR = "sadaqmk_213dcamkcla";
        assertEquals("check Token" , true , TokenModel.isTokenGood());

    }

    @Test
    public void Token2(){
        TokenModel.TokenSTR  = "";
        TokenModel.getToken("admin" , "bbBB11!!");
        assertEquals("Check tokrn" , true , TokenModel.isTokenGood());

    }

}
