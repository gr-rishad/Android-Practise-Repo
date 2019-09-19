package com.example.listviewastablelayout;

public class Model {

    private String sNo;
    private String product;
    private String category;
    private String price;

    public Model(String sNo, String product, String category, String price) {
        this.sNo = sNo;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
