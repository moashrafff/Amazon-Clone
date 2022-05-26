package com.moashrafff.amazon_clone.Data.Model;

public class Deal {
    private String dealText;
    private int dealImage;

    public Deal(String dealText, int dealImage) {
        this.dealText = dealText;
        this.dealImage = dealImage;
    }

    public String getDealText() {
        return dealText;
    }

    public void setDealText(String dealText) {
        this.dealText = dealText;
    }

    public int getDealImage() {
        return dealImage;
    }

    public void setDealImage(int dealImage) {
        this.dealImage = dealImage;
    }
}
