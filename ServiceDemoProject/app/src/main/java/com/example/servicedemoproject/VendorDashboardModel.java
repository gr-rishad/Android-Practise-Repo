package com.example.servicedemoproject;

public class VendorDashboardModel {

    private String id;
    private String serviceName;
    private String contactNumber;
    private String location;

    public VendorDashboardModel(String id, String serviceName, String contactNumber, String location) {
        this.id = id;
        this.serviceName = serviceName;
        this.contactNumber = contactNumber;
        this.location = location;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
