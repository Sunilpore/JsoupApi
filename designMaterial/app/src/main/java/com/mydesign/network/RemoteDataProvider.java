package com.mydesign.network;

import com.mydesign.network.response.profilelist.Result;
import com.mydesign.network.response.profilelist.UserProfileListsModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;

public interface RemoteDataProvider {

    Disposable fetchPosCharacter(Consumer<String> success, Consumer<Throwable> error);

    Disposable fetchArrCharacters(Consumer<String> success, Consumer<Throwable> error);

    Disposable fetchCharCounter(Consumer<String> success, Consumer<Throwable> error);
}
