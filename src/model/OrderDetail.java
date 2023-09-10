package model;

import view.WayOfPaymentStrategy;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    private int id;  
    private static int counter = 1; 
    private String cstName;  
    private String cstLastName; 
    private String cstAddress;   
    private String cstEmail;  
    private String prodNme;
    private String numProd;  
    private String placeOfDelivery;  
    private String deliveryType; 
    private WayOfPaymentStrategy wayOfPaymentStrategy; 
    private String paymentStrategy;

    public OrderDetail() {
    }

    public OrderDetail(String cstName, String cstLastName, String cstAddress, String cstEmail, String prod_name, String numProd, String placeOfDelivery, String deliveryType, String paymentStrategy) {
        this.id = counter;
        counter++;
        this.cstName = cstName;
        this.cstLastName = cstLastName;
        this.cstAddress = cstAddress;
        this.cstEmail = cstEmail;
        this.prodNme = prodNme;
        this.numProd = numProd;
        this.placeOfDelivery = placeOfDelivery;
        this.deliveryType = deliveryType;
        this.paymentStrategy = paymentStrategy;
    }

    public OrderDetail(int id, String cstName, String cstLastName, String cstAddress, String cstEmail, String prodNme, String numProd, String placeOfDelivery, String deliveryType, String paymentStrategy) {
        this.id = id;
        this.cstName = cstName;
        this.cstLastName = cstLastName;
        this.cstAddress = cstAddress;
        this.cstEmail = cstEmail;
        this.prodNme = prodNme;
        this.numProd = numProd;
        this.placeOfDelivery = placeOfDelivery;
        this.deliveryType = deliveryType;
        this.paymentStrategy = paymentStrategy;
    }

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public String getCstLastName() {
        return cstLastName;
    }


    public void setCstLastName(String cstLastName) {
        this.cstLastName = cstLastName;
    }

    public String getCstAddress() {
        return cstAddress;
    }


    public void setCstAddress(String cstAddress) {
        this.cstAddress = cstAddress;
    }

    public String getCstEmail() {
        return cstEmail;
    }

    public void setCstEmail(String cstEmail) {
        this.cstEmail = cstEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdNme() {
        return prodNme;
    }

    public void setProdNme(String prodNme) {
        this.prodNme = prodNme;
    }

    public String getNumProd() {
        return numProd;
    }

    public void setNumProd(String numProd) {
        this.numProd = numProd;
    }

    public String getPlaceOfDelivery() {
        return placeOfDelivery;
    }

    public void setPlaceOfDelivery(String placeOfDelivery) {
        this.placeOfDelivery = placeOfDelivery;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(String paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void info(){
        System.out.println(toString());
    }

    public static void setCounter(int cnt) {
        counter = cnt;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", cstName='" + cstName + '\'' +
                ", cstLastName='" + cstLastName + '\'' +
                ", cstAddress='" + cstAddress + '\'' +
                ", cstEmail='" + cstEmail + '\'' +
                ", prodNme='" + prodNme + '\'' +
                ", numProd='" + numProd + '\'' +
                ", placeOfDelivery='" + placeOfDelivery + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                ", paymentStrategy='" + paymentStrategy + '\'' +
                '}';
    }
}
