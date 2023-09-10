package view;

import model.OrderDetail;

import java.util.EventObject;

public class OrderDetailEvent extends EventObject {

    private String name;
   
    private String lastName;
   
    private String address;
    
    private String email;
    
    private String prodNme;
    
    private String numProd;
   
    private String placeOfDel;
    
    private String delTyp;
   
    private String pymStr;

   
    public OrderDetailEvent(Object source , OrderDetail orderDetail) {
        super(source);

        name = orderDetail.getCstName();
        lastName = orderDetail.getCstLastName();
        address = orderDetail.getCstAddress();
        email = orderDetail.getCstEmail();
        prodNme = orderDetail.getProdNme();
        numProd = orderDetail.getNumProd();
        placeOfDel = orderDetail.getPlaceOfDelivery();
        delTyp = orderDetail.getDeliveryType();
        pymStr = orderDetail.getPaymentStrategy();
    }

 
    public String getName() {
        return name;
    }

  
    public String getLastName() {
        return lastName;
    }

  
    public String getAddress() {
        return address;
    }

 
    public String getEmail() {
        return email;
    }

  
    public String getProdNme() {
        return prodNme;
    }

    public String getNumProd() {
        return numProd;
    }

   
    public String getPlaceOfDel() {
        return placeOfDel;
    }

  
    public String getDelTyp() {
        return delTyp;
    }

    
    public String getPymStr() {
        return pymStr;
    }
}
