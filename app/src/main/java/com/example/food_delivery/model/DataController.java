package com.example.food_delivery.model;

import java.util.List;

public class DataController {
    public static DataController instance;
    public static DataController getInstance(){
        if(instance==null){
            instance=new DataController();
        }

        return instance;
    }
    ResaurantInterface resaurantInterface;
    List<MenuItem> currentMenuItemList;
    public ResaurantInterface getResaurantInterface(){
        return resaurantInterface;
    }
    public void setResaurantInterface(ResaurantInterface resaurantInterface){
        this.resaurantInterface=resaurantInterface;
    }

    public List<MenuItem> getCurrentMenuItemList() {
        return currentMenuItemList;
    }

    public void setCurrentMenuItemList(List<MenuItem> currentMenuItemList) {
        this.currentMenuItemList = currentMenuItemList;
    }
}
