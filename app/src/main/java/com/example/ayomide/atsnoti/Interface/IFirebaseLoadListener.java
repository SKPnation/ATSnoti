package com.example.ayomide.atsnoti.Interface;

import com.example.ayomide.atsnoti.Model.PupilGroup;

import java.util.List;

public interface IFirebaseLoadListener {

    void onFirebaseLoadSuccess(List<PupilGroup> pupilGroupList);
    void onFirebaseLoadFailed(String message);
}
