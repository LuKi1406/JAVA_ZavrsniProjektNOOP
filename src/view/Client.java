package view;

import javax.swing.*;

import test_server_db.AppTestServer;

public class Client {

 
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new AppTestServer();
                new MainFrame();
            }
        });
    }
}
