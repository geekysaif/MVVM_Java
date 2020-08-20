package preview.tech.showmejava.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import preview.tech.showmejava.model.Hero;
import preview.tech.showmejava.model.Menues;
import preview.tech.showmejava.newtorkSetup.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuesViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Menues>> heroList;

    //we will call this method to get the data
    public LiveData<List<Menues>> getMenues() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<Menues>>();
            //we will load it asynchronously from server in this method
            loadMenues();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadMenues() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Menues>> call = api.getMenus();

        call.enqueue(new Callback<List<Menues>>() {
            @Override
            public void onResponse(Call<List<Menues>> call, Response<List<Menues>> response) {
                Log.e("menu_response",""+response);
                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Menues>> call, Throwable t) {

            }
        });
    }

}
