package preview.tech.showmejava.newtorkSetup;

import java.util.List;

import okhttp3.ResponseBody;
import preview.tech.showmejava.model.Hero;
import preview.tech.showmejava.model.Menues;
import preview.tech.showmejava.model.SignUp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

     String BASE_URL = "https://simplifiedcoding.net/demos/";
     String BASE_URL1 = "https://api.androidhive.info/json/shimmer/";

    @FormUrlEncoded
    @POST("SignUp")
    Call<List<SignUp>> getSignUp(@Field("email") String email, @Field("password") String password, @Field("cpassword") String cpassword);

    @GET("marvel")
    Call<List<Hero>> getHeroes();

    @GET("menu.php")
    Call<List<Menues>> getMenus();


}
