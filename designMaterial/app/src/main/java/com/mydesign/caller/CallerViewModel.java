package com.mydesign.caller;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.mydesign.base.BaseViewModel;
import com.mydesign.network.DataProvider;
import com.mydesign.network.response.profilelist.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.lang.reflect.Array;
import java.util.*;

public class CallerViewModel extends BaseViewModel<CallerNavigator> {

    private MutableLiveData<String> getResData = new MutableLiveData<>();
    private MutableLiveData<ArrayList<String>> getArrRes = new MutableLiveData<>();
    private MutableLiveData<Integer> getUniqueWordCounter = new MutableLiveData<>();


    public MutableLiveData<String> getGetResData() {
        return getResData;
    }

    public MutableLiveData<ArrayList<String>> getArrRes() {
        return getArrRes;
    }

    public MutableLiveData<Integer> getUniqueWordCounter() {
        return getUniqueWordCounter;
    }

    //Get single character of specific position
    public void getPosCharacter() {
        dialogVisibility.setValue(true);
        mDisposable.add(DataProvider.getInstance().fetchPosCharacter(response -> {

            Document doc = Jsoup.parse(response);
            Element link = doc.select("head").first();
            String contentData = link.getElementsByAttributeValue("name","twitter:description").attr("content");
            getGetResData().setValue(contentData);

            dialogVisibility.setValue(false);

        }, this::checkError));

    }

    //Get String array of particular position(Here multiple of 10th position)
    public void getCharacterArray(){

        mDisposable.add(DataProvider.getInstance().fetchArrCharacters(response -> {

            Document doc = Jsoup.parse(response);
            Element link = doc.select("head").first();
            String contentData = link.getElementsByAttributeValue("name","twitter:description").attr("content");

            int limit = contentData.length();
            ArrayList<String> arr = new ArrayList<>();
            for(int i=0;i <=limit;i++){
                if(i%10 == 0){
                    arr.add(String.valueOf(contentData.charAt(i)));
                }
            }
            getArrRes().setValue(arr);

        }, this::checkError));

    }


    //Get unique word counter
    public void getUniqueCharCount(){

        mDisposable.add(DataProvider.getInstance().fetchCharCounter(response -> {

            Document doc = Jsoup.parse(response);
            Element link = doc.select("head").first();
            String contentData = link.getElementsByAttributeValue("name","twitter:description").attr("content");

            //Display Counter
            String[] list = contentData.split(" ");
            Set<String> uniqueList = new HashSet<>(Arrays.asList(list));

            getUniqueWordCounter().setValue(uniqueList.size());

        }, this::checkError));

    }

    @Override
    protected void checkError(Throwable throwable) {
        super.checkError(throwable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


}
