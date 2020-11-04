package com.example.food_delivery.model;

import java.util.List;

public class Restrurent {
    String RestrurentName;
    String RestrurentDescription;
    String RestrurentImageUrl;
    String RestrurentLocation;
    List<MenuItem> restaurantMenuList;

    public Restrurent() {
    }

    public List<MenuItem> getRestaurantMenuList() {
        return restaurantMenuList;
    }

    public void setRestaurantMenuList(List<MenuItem> restaurantMenuList) {
        this.restaurantMenuList = restaurantMenuList;
    }

    public String getRestrurentName() {
        return RestrurentName;
    }

    public void setRestrurentName(String restrurentName) {
        RestrurentName = restrurentName;
    }

    public String getRestrurentDescription() {
        return RestrurentDescription;
    }

    public void setRestrurentDescription(String restrurentDescription) {
        RestrurentDescription = restrurentDescription;
    }

    public String getRestrurentImageUrl() {
        return RestrurentImageUrl;
    }

    public void setRestrurentImageUrl(String restrurentImageUrl) {
        RestrurentImageUrl = restrurentImageUrl;
    }

    public String getRestrurentLocation() {
        return RestrurentLocation;
    }

    public void setRestrurentLocation(String restrurentLocation) {
        RestrurentLocation = restrurentLocation;
    }
}
