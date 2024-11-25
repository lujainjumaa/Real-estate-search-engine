package org.example.Models;

public class HomeProperty {
    private String theOwner;
    private String id;
    private String moreInfo;
    private long price;
    private String governorate;
    private int propertyArea;
    private String realStateArea;
    private String RealEstateYield;

    public HomeProperty(String theOwner, String id, String moreInfo, String governorate, long price, int propertyArea, String realStateArea, String realEstateYield) {
        this.theOwner = theOwner;
        this.id = id;
        this.moreInfo = moreInfo;
        this.governorate = governorate;
        this.price = price;
        this.propertyArea = propertyArea;
        this.realStateArea = realStateArea;
        this.RealEstateYield = realEstateYield;
    }

    @Override
    public String toString(){
        return this.theOwner;
    }


    public String getId() {
        return id;
    }

    public String getTheOwner() {
        return theOwner;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public long getPrice() {
        return price;
    }

    public String getGovernorate() {
        return governorate;
    }

    public int getPropertyArea() {
        return propertyArea;
    }

    public String getRealStateArea() {
        return realStateArea;
    }

    public String getRealEstateYield() {
        return RealEstateYield;
    }

}
