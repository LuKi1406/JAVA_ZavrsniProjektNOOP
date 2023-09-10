package controller;

import model.DataBase;
import model.OrderDetail;
import view.ViewPanel;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {

    private DataBase dataBase;

    public Controller(){
        dataBase = new DataBase();
    }

  
    public void addNewOrderDetailsToDataBase(OrderDetail orderDetail){
        System.out.println(orderDetail);
        dataBase.addOrderDetails(orderDetail);
    }

  
    public List<OrderDetail> getAllOrderDetailsFromDataBase(){
        return dataBase.getAllOrderDetailsFromDataBase();
    }

   
    public void listAllOrderDetailsInDataBase(){
        System.out.println("------------------------- Listing all order details -------------------------");
        dataBase.listAllOrderDetailsInDataBase();
    }

    public void saveDataToTextFile(File file) throws IOException {
        dataBase.saveToFile(file);
    }

    public void loadDataFromTextFile(File file) throws IOException {
        dataBase.readFromFile(file);
    }


    public void connectToDataBase(){
        dataBase.connect();
    }

    public void disconnectFromDataBase(){
        dataBase.disconnect();
    }

  
    public void saveDataToDataBase() throws SQLException {
        dataBase.saveDataToDataBaseServer();
    }

  
    public void loadDataToDataBase(){
        dataBase.loadDataFromDataBaseServer();
    }

  
    public void showImportedDataInTextPanel(ViewPanel viewPanel){
        viewPanel.showImportedDataInTextPanel(dataBase.getAllOrderDetailsFromDataBase());
    }

   
    public void showOrderDetailData(ViewPanel viewPanel, OrderDetail orderDetail){
        viewPanel.showOnTextArea(orderDetail);
    }


    public void setData(ViewPanel viewPanel){
        viewPanel.setOrderDetails(dataBase);
    }

}


















