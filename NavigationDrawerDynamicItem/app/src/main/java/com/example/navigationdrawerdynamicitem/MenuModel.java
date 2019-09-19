package com.example.navigationdrawerdynamicitem;

import java.util.ArrayList;
import java.util.List;

public class MenuModel {

    public List<String>findAll(){
        List<String>  menus= new ArrayList<String>();
        menus.add("Menu 2.1");
        menus.add("Menu 2.2");
        menus.add("Menu 2.3");

        return menus;
    }
}
