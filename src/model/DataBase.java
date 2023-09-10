package model;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DataBase {

    private List<OrderDetail> orderDetails;

    private Connection connection;

    public DataBase() {
        orderDetails = new LinkedList<OrderDetail>();

    }

    public void addOrderDetails(OrderDetail orderDetail) {
        System.out.println("Count orders in DB: " + orderDetails.size());
        System.out.println(orderDetail);
        orderDetails.add(orderDetail);
        System.out.println("In DB: " + orderDetails.size());
    }

    public List<OrderDetail> getAllOrderDetailsFromDataBase() {
        return orderDetails;
    }

    public void listAllOrderDetailsInDataBase() {
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.info();
        }
    }

    public void loadDataFromDataBaseServer() {

        ResultSet results = null;
        PreparedStatement selectStatement = null;

        if (connection != null) {
            System.out.println("Loading data from database server!");
            String selectSQL = "select * from OrderDetailsT order by name";

            try {
                selectStatement = connection.prepareStatement(selectSQL);
                results = selectStatement.executeQuery();

                orderDetails.clear();

                while (results.next()) {
                    int col = 1;
                    int id = results.getInt(col++);
                    String name = results.getString(col++);
                    String surname = results.getString(col++);
                    String address = results.getString(col++);
                    String email = results.getString(col++);
                    String prodNme = results.getString(col++);
                    String numProd = results.getString(col++);
                    String placeOfDel = results.getString(col++);
                    String deliveryType = results.getString(col++);
                    String paymentStr = results.getString(col++);

                    OrderDetail orderDetail = new OrderDetail(id, name, surname, address, email, prodNme, numProd, placeOfDel, deliveryType, paymentStr);
                    orderDetails.add(orderDetail);

                }
                results.close();
                selectStatement.close();

                System.out.println("List: " + orderDetails);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void saveDataToDataBaseServer() throws SQLException {

        System.out.println("Count in DB, size is: " + orderDetails.size());
        System.out.println("Ord details: " + orderDetails);
        if (connection != null) {

            // SQL Queries
            String countSQLOrderDetails = "select count(*) as count from OrderDetailsT where id = ?";
            String insertSQL = "insert into OrderDetailsT (id, name, surname, address, email, prod_name, num_prod, place_of_delivery, way_of_delivery, type_of_payment) values (?,?,?,?,?,?,?,?,?,?)";
            String updateSql = "update OrderDetailsT set name = ?, surname = ?, address = ?, email = ?, prod_name = ?, num_prod = ?, place_of_delivery = ?, way_of_delivery = ?, type_of_payment = ? where id = ?";

            //Statments
            PreparedStatement countStemOrderDetails = connection.prepareStatement(countSQLOrderDetails);
            PreparedStatement insertStatment = connection.prepareStatement(insertSQL);
            PreparedStatement updateStatment = connection.prepareStatement(updateSql);

            for (OrderDetail ordDet : orderDetails) {
                System.out.println("hewhdewd");
                int id = ordDet.getId();
                String name = ordDet.getCstName();
                String surname = ordDet.getCstLastName();
                String address = ordDet.getCstAddress();
                String email = ordDet.getCstEmail();
                String bookName = ordDet.getProdNme();
                String bookCover = ordDet.getNumProd();
                String placeOfDel = ordDet.getPlaceOfDelivery();
                String deliveryType = ordDet.getDeliveryType();
                String paymentStr = ordDet.getPaymentStrategy();

                countStemOrderDetails.setInt(1, id);
                ResultSet result = countStemOrderDetails.executeQuery();
                result.next();
                int count = result.getInt(1);
                System.out.println("Counted: " + count);

                if (count == 0) {
                    System.out.println("Inserting new order details in database -> id: " + id);

                    // insert commands
                    int col = 1;
                    insertStatment.setInt(col++, id);
                    insertStatment.setString(col++, name);
                    insertStatment.setString(col++, surname);
                    insertStatment.setString(col++, address);
                    insertStatment.setString(col++, email);
                    insertStatment.setString(col++, bookName);
                    insertStatment.setString(col++, bookCover);
                    insertStatment.setString(col++, placeOfDel);
                    insertStatment.setString(col++, deliveryType);
                    insertStatment.setString(col++, paymentStr);

                    insertStatment.executeUpdate();

                } else {
                    System.out.println("Update order details in database with id -> " + id);

                    // update data command
                    int col = 1;
                    updateStatment.setString(col++, name);
                    updateStatment.setString(col++, surname);
                    updateStatment.setString(col++, address);
                    updateStatment.setString(col++, email);
                    updateStatment.setString(col++, bookName);
                    updateStatment.setString(col++, bookCover);
                    updateStatment.setString(col++, placeOfDel);
                    updateStatment.setString(col++, deliveryType);
                    updateStatment.setString(col++, paymentStr);
                    updateStatment.setInt(col++, id);

                    updateStatment.executeUpdate();

                }
            }
            countStemOrderDetails.close();
            insertStatment.close();
            updateStatment.close();

        }

    }

    public void connect() {
        System.out.println("Connecting to a server...");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://db4free.net:3306/"; //Your data
            String user = ""; //Your data
            String pswd = ""; //Your data
            connection = DriverManager.getConnection(url, user, pswd);
            System.out.println("Connected to: " + connection.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            System.out.println("Success - disconnected from MySQL DB!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("No connection to close!");
        }
    }

    public void saveToFile(File file) throws IOException {
        OrderDetail[] ordDet = orderDetails.toArray(new OrderDetail[orderDetails.size()]);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(ordDet);
        os.close();
    }

    public void readFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            OrderDetail[] prgms = (OrderDetail[]) ois.readObject();
            orderDetails.clear();
            orderDetails.addAll(Arrays.asList(prgms));
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ois.close();
    }
}
























