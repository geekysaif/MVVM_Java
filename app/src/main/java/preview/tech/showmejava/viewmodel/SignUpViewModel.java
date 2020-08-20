package preview.tech.showmejava.viewmodel;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Observable;

import preview.tech.showmejava.model.Menues;
import preview.tech.showmejava.model.SignUp;
import preview.tech.showmejava.newtorkSetup.Api;
import preview.tech.showmejava.ui.MainActivity;
import preview.tech.showmejava.ui.SignUpActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<SignUp>> heroList;
    private SignUpActivity signUpActivity= new SignUpActivity();

    //we will call this method to get the data
    public LiveData<List<SignUp>> getMenues() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<SignUp>>();
            //we will load it asynchronously from server in this method
            loadMenues();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadMenues() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<SignUp>> call = api.getSignUp(""+heroList.getValue().get(0).getEmail(),"","");

        call.enqueue(new Callback<List<SignUp>>() {
            @Override
            public void onResponse(Call<List<SignUp>> call, Response<List<SignUp>> response) {
                Log.e("menu_response",""+response);
                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SignUp>> call, Throwable t) {

            }
        });
    }

}
