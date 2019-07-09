package com.example.ayomide.atsnoti.Model;

import java.util.ArrayList;

public class PupilGroup {
    private String headerTitle;
    private ArrayList<PupilData> listPupil;

    public PupilGroup() {
    }

    public PupilGroup(String headerTitle, ArrayList<PupilData> listPupil) {
        this.headerTitle = headerTitle;
        this.listPupil = listPupil;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<PupilData> getListPupil() {
        return listPupil;
    }

    public void setListPupil(ArrayList<PupilData> listPupil) {
        this.listPupil = listPupil;
    }
}
