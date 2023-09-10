package view;

import controller.CommandManager;
import controller.Controller;
import model.DataBase;
import model.OrderDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class MainFrame extends JFrame {

    private ProdShopPanel prodShopPnl;

  
    private CustomerInformationPanel customerInformationPanel;
   
    private WayOfPaymentPanel wayOfPaymentPanel;
    
    private ViewPanel viewPanel;
    
    private JMenuBar menuBar;
   
    private DataFields dataFields;
  
    private Controller controller;
   
    private DataBase dataBase;

   
    public MainFrame() {
        super("Bookshop");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        initializeAllComponents();
        setFormLayout();
        activateMainFrame();
    }

  
    private void initializeAllComponents() {
        dataFields = new DataFields();
        prodShopPnl = new ProdShopPanel(dataFields.getCheckboxGroup2(), dataFields.getNumProds(), dataFields.getNumProds1(), dataFields.getNumProds2(),
        		dataFields.getNumProds3(), dataFields.getNumProds4(), dataFields.getRadioButtonGroup(), dataFields.getProdNme(),
        		dataFields.getProdNme1(), dataFields.getProdNme2(), dataFields.getProdNme3(),
			dataFields.getSubmitButton(), dataFields.getCheckboxGroup(), dataFields.getHomeDel(), dataFields.getPickUpDel(), dataFields.getOfficeDelivery(),
			dataFields.getRadioButtonGroup(), dataFields.getNormalDelivery(), dataFields.getExpressDelivery()); 
	
        customerInformationPanel = new CustomerInformationPanel(dataFields.getCustomerName(), dataFields.getLastName(), dataFields.getAddress(), dataFields.getEmail());
        wayOfPaymentPanel = new WayOfPaymentPanel(dataFields.getWayOfPaymentCombo());
        viewPanel = new ViewPanel(customerInformationPanel);
        menuBar = createMenuBar(viewPanel);
        controller = new Controller();
        controller.setData(viewPanel);
        dataBase = new DataBase();
    }

    
    private void setFormLayout() {
        add(prodShopPnl, BorderLayout.SOUTH);
        add(wayOfPaymentPanel, BorderLayout.EAST);
        add(viewPanel, BorderLayout.CENTER);
        add(menuBar, BorderLayout.NORTH);
    }

    private JMenuBar createMenuBar(ViewPanel viewPanel) {

        JMenuBar menuBar = new JMenuBar();


        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");
        JMenu menuServer = new JMenu("Server");

        JMenuItem cutButton = new JMenuItem("Cut / Ctrl+R");
        JMenuItem copyButton = new JMenuItem("Copy / Ctrl+K");
        JMenuItem pasteButton = new JMenuItem("Paste / Ctrl+Z");
        JMenuItem selectAllButton = new JMenuItem("Select All / Ctrl+W");
        JMenuItem undoButton = new JMenuItem("Undo / Ctrl+B");
        JMenuItem redoButton = new JMenuItem("Redo / Ctrl+A");

        JMenuItem saveAsButton = new JMenuItem("Save as...");
        JMenuItem openFileButton = new JMenuItem("Open file...");
        JMenuItem exitButton = new JMenuItem("Exit");

        JMenuItem connectButton = new JMenuItem("Connect");
        JMenuItem disconnectButton = new JMenuItem("Disconnect");
        JMenuItem saveToDataBaseButton = new JMenuItem("Save data");

        JMenuItem loadFromDataBaseButton = new JMenuItem("Load data");

        this.viewPanel = viewPanel;
        JFileChooser fileChooser = new JFileChooser();

        UndoRedoHandler undoRedoHandler = new UndoRedoHandler(viewPanel);

        menuBar.add(menuFile);

        menuBar.add(menuEdit);
        menuBar.add(menuServer);
        add(menuBar);

        menuFile.add(saveAsButton);
        menuFile.add(openFileButton);
        menuFile.add(exitButton);

        menuEdit.add(cutButton);
        menuEdit.add(copyButton);
        menuEdit.add(pasteButton);
        menuEdit.add(selectAllButton);
        menuEdit.add(undoButton);
        menuEdit.add(redoButton);

        menuServer.add(connectButton);
        menuServer.add(disconnectButton);
        menuServer.add(saveToDataBaseButton);
        menuServer.add(loadFromDataBaseButton);

        // add accelerators and mnemonics
        menuEdit.setMnemonic(KeyEvent.VK_E);
        selectAllButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        copyButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
        pasteButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        cutButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        redoButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        undoButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));

        saveAsButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        openFileButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        exitButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        //Izlaz iz aplikacije
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit app!?", "Exit confirmation",
                        JOptionPane.OK_CANCEL_OPTION);
                if (val == JOptionPane.OK_OPTION) {
                    System.exit(0);
                } else {
                    System.out.println("canceled by user...");

                    JOptionPane.showMessageDialog(MainFrame.this, "Canceled by user", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        //Citanje iz filea
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val = fileChooser.showOpenDialog(MainFrame.this);

                if (val == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        controller.loadDataFromTextFile(file);
                        controller.showImportedDataInTextPanel(viewPanel);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Unable to read data from the file!", "Open error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        //Spremanje u file
        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val = fileChooser.showSaveDialog(MainFrame.this);

                if (val == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        controller.saveDataToTextFile(file);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Unable to save data into the file!", "Save error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        cutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandManager commandManager = new CommandManager(viewPanel);
                commandManager.cut();
            }
        });

        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandManager commandManager = new CommandManager(viewPanel);
                commandManager.copy();

            }
        });

        pasteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandManager commandManager = new CommandManager(viewPanel);
                commandManager.paste();
            }
        });

        selectAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandManager commandManager = new CommandManager(viewPanel);
                commandManager.selectAll();
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoRedoHandler.undo();
            }
        });

        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoRedoHandler.redo();
            }
        });

        //Spajanje na bazu
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.connectToDataBase();
                JOptionPane.showMessageDialog(MainFrame.this, "Connection to server has been established!", "Server status", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Odspajanje sa baze
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.disconnectFromDataBase();
                    JOptionPane.showMessageDialog(MainFrame.this, "Disconnected from server!", "Server status", JOptionPane.WARNING_MESSAGE);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(MainFrame.this, "There is no active connection!", "Server status", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //Spremanje u bazu
        saveToDataBaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.connectToDataBase();
                    controller.saveDataToDataBase();
                    controller.disconnectFromDataBase();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Data base connection error!!!", "Save Data base error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //ucitavanje sa baze
        loadFromDataBaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.connectToDataBase();
                } catch (Exception e3) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Unable to connect to a DB server!!!", "Connection DB error",
                            JOptionPane.ERROR_MESSAGE);
                }
                try {
                    controller.loadDataToDataBase();
                    controller.showImportedDataInTextPanel(viewPanel);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Unable to load data from a DB server!!!", "Load DB error",
                            JOptionPane.ERROR_MESSAGE);
                }
                try {
                    controller.disconnectFromDataBase();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Unable to disconnect from a DB server!!!", "Disconnect DB error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        return menuBar;

    }


    private void activateMainFrame() {

        dataFields.setOrderDetailsFormListener(new OrderDetailsFormListener() {
            @Override
            public void orderDetailsEventOccurred(OrderDetailEvent orderDetailEvent) {
                OrderDetail orderDetail = dataFields.getOrderDetail();
                System.out.println("Dat field: " + dataFields.getOrderDetail());
                controller.addNewOrderDetailsToDataBase(orderDetail);
                controller.listAllOrderDetailsInDataBase();
                controller.showOrderDetailData(viewPanel, orderDetail);
            }
        });

    }
}
