package com.mydesign.network;

import com.mydesign.network.response.profilelist.UserProfileListsModel;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.ArrayList;

public interface ApiInterface {

    @GET("2018/01/22/life-as-an-android-engineer/")
    Single<Response<ResponseBody>> fetchCharacter();

    @GET("2018/01/22/life-as-an-android-engineer/")
    Single<Response<ResponseBody>> fetchArrCharacters();

    @GET("2018/01/22/life-as-an-android-engineer/")
    Single<Response<ResponseBody>> fetchCharCounterlist();

}
