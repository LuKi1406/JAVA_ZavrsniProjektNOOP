package test_server_db;

import model.DataBase;
import model.OrderDetail;

import java.sql.SQLException;

public class AppTestServer {

    public static void main(String[] args) throws SQLException {

        DataBase dataBase = new DataBase();

        OrderDetail orderDetail1 = new OrderDetail("Ime1","Prezime1","Ulica Ime Prezime 1","ime1.prezime1@gmail.com","Product with name 1", "5", "Home delivery","Normal delivery","Google pay");
        OrderDetail orderDetail2 = new OrderDetail("Mate","Matic","Ulica Mate Matica","mate.matic56@gmail.com","War and Peace by Leo Tolstoy","Hardcover with ImageWrap","House delivery","Express delivery","Pay pal");

        dataBase.addOrderDetails(orderDetail1);
        dataBase.addOrderDetails(orderDetail2);
        dataBase.listAllOrderDetailsInDataBase();

        dataBase.connect();
        dataBase.saveDataToDataBaseServer();
        dataBase.loadDataFromDataBaseServer();
        dataBase.disconnect();
    }
}
