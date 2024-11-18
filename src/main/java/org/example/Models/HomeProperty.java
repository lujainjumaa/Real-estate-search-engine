package org.example.Models;

public class HomeProperty {
    private String theOwner;
    private int id;
    private String moreInfo;
    private long price;
    private String governorate;
    private int propertyArea;
    private String realStateArea;
    private int RealEstateYield;

    public HomeProperty(String theOwner, int id, String moreInfo, String governorate, long price, int propertyArea, String realStateArea, int realEstateYield) {
        this.theOwner = theOwner;
        this.id = id;
        this.moreInfo = moreInfo;
        this.governorate = governorate;
        this.price = price;
        this.propertyArea = propertyArea;
        this.realStateArea = realStateArea;
        this.RealEstateYield = realEstateYield;
    }


    public int getId() {
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

    public int getRealEstateYield() {
        return RealEstateYield;
    }

    public int sendKeyInt(int key){
        if(key==0)
            return getId();
        else if(key==3)
            return getPropertyArea();
        else if(key==6)
            return getRealEstateYield();
        return 0;
    }
    public String senKeyString(int key){
        if(key==1)
            return getTheOwner();
        else if(key==2)
            return getGovernorate();
        else if(key==4)
            return getMoreInfo();
        else if(key==7)
            return getRealStateArea();
        return "";
    }
    public long senKeyLong(int key){
        if(key==5)
            return getPrice();
        return 0;
    }

}
