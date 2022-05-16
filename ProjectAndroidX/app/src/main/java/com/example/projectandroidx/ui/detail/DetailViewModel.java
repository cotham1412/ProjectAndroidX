package com.example.projectandroidx.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DetailViewModel {
    private final MutableLiveData<String> mText;

    public DetailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is detail fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
