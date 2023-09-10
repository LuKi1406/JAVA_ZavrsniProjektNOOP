package view;

import model.OrderDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataFields extends JPanel {

    private JTextField customerName;
    private JTextField lastName;
    private JTextField address; 
    private JTextField email;  
  
    private JCheckBox numProds;
    private JCheckBox numProds1;
    private JCheckBox numProds2;
    private JCheckBox numProds3;
    private JCheckBox numProds4;
    
    private JRadioButton prodNme;
    private JRadioButton prodNme1;
    private JRadioButton prodNme2;
    private JRadioButton prodNme3;


    private JCheckBox homeDel;
   
    private JCheckBox pickUpDel;
    
    private JCheckBox officeDelivery;
 
    private JRadioButton expressDelivery;

    private JRadioButton normalDelivery;

    private JButton submitButton;
 
    private ButtonGroup checkboxGroup;
    private ButtonGroup checkboxGroup2;
    private ButtonGroup radioButtonGrp;
    private ButtonGroup radioButtonGroup;
 
    private JComboBox<WayOfPaymentStrategy> wayOfPaymentCombo;
 
    private OrderDetailsFormListener orderDetailsFormListener;

    private OrderDetail orderDetail;

    public DataFields() {
        createComponents();
        activeDataFields();

    }

  
    public void createComponents(){
        customerName = new JTextField(10);
        lastName = new JTextField(10);
        address = new JTextField(10);
        email = new JTextField(10);

        wayOfPaymentCombo = new JComboBox<WayOfPaymentStrategy>();
        DefaultComboBoxModel<WayOfPaymentStrategy> wayOfPaymentComboModel = new DefaultComboBoxModel<>();
        wayOfPaymentComboModel.addElement(new CreditCardPaymentStrategy());
        wayOfPaymentComboModel.addElement(new GooglePayPaymentStrategy());
        wayOfPaymentComboModel.addElement(new PayPalPaymentStrategy());
        wayOfPaymentCombo.setModel(wayOfPaymentComboModel);
        wayOfPaymentCombo.setSelectedIndex(0);
        wayOfPaymentCombo.setRenderer((new DefaultPromptMsgRenderer("Choose a way of payment")));
        wayOfPaymentCombo.setSelectedIndex(-1);

        homeDel = new JCheckBox("Home delivery - on address");
        pickUpDel = new JCheckBox("Pick up spots in town");
        officeDelivery = new JCheckBox("In delivery service office");
        
        expressDelivery = new JRadioButton("Express delivery");
        normalDelivery = new JRadioButton("Normal delivery");
        
        prodNme = new JRadioButton("Product 1");
        prodNme1 = new JRadioButton("Product 2");
        prodNme2 = new JRadioButton("Product 3");
        prodNme3 = new JRadioButton("Product 4");
        
        numProds = new JCheckBox("1");
        numProds1 = new JCheckBox("2");
        numProds2 = new JCheckBox("3");
        numProds3 = new JCheckBox("4");
        numProds4 = new JCheckBox("5");
        
        submitButton = new JButton("Submit");

        // Adding checkBoxItems to group
        checkboxGroup = new ButtonGroup();
        checkboxGroup.add(homeDel);
        checkboxGroup.add(pickUpDel);
        checkboxGroup.add(officeDelivery);
        
        homeDel.setActionCommand("Home delivery - on address");
        pickUpDel.setActionCommand("Pick up spots in town");
        officeDelivery.setActionCommand("In delivery service office");

        // Adding buttons to group
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(normalDelivery);
        radioButtonGroup.add(expressDelivery);
        
        normalDelivery.setActionCommand("Normal delivery");
        expressDelivery.setActionCommand("Express delivery");

        // Adding buttons to group
        radioButtonGrp = new ButtonGroup();
        radioButtonGrp.add(prodNme);
        radioButtonGrp.add(prodNme1);
        radioButtonGrp.add(prodNme2);
        radioButtonGrp.add(prodNme3);
        
        prodNme.setActionCommand("Product 1");
        prodNme1.setActionCommand("Product 2");
        prodNme2.setActionCommand("Product 3");
        prodNme3.setActionCommand("Product 4");

     // Adding checkBoxItems to group
        checkboxGroup2 = new ButtonGroup();
        checkboxGroup2.add(numProds);
        checkboxGroup2.add(numProds1);
        checkboxGroup2.add(numProds2);
        checkboxGroup2.add(numProds3);
        checkboxGroup2.add(numProds4);
        
        numProds.setActionCommand("1");
        numProds1.setActionCommand("2");
        numProds2.setActionCommand("3");
        numProds3.setActionCommand("4");
        numProds4.setActionCommand("5");
        
/*        submitButton = new JButton("Submit data");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllData();
            }
        });*/
    }

    private void activeDataFields(){
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (orderDetailsFormListener != null){
                    orderDetail = new OrderDetail(customerName.getText(),lastName.getText(),address.getText(),email.getText(),radioButtonGrp.getSelection().getActionCommand(), checkboxGroup2.getSelection().getActionCommand() ,checkboxGroup.getSelection().getActionCommand(),radioButtonGroup.getSelection().getActionCommand(),wayOfPaymentCombo.getSelectedItem().toString());
                    OrderDetailEvent ordEv = new OrderDetailEvent(DataFields.this,orderDetail);
                    orderDetailsFormListener.orderDetailsEventOccurred(ordEv);
                    
                    //orderDetail.info();

                } 
                
                resetAllData();
            }
        });
    }

  /*  public void getAllData(){
       
        String prodsInShop = prodsShop.getSelectedValue();
        String numOfProds = (String) numProds.getSelectedItem();
       
        WayOfPaymentStrategy wayOfPaymentStrategy = (WayOfPaymentStrategy) wayOfPaymentCombo.getSelectedItem();
        String res = wayOfPaymentCombo.getSelectedItem().toString();

        if (orderDetailsFormListener != null){
            orderDetail = new OrderDetail(customerName.getText(),lastName.getText(),address.getText(),email.getText(),prodsInShop, (String) numOfProds,checkboxGroup.getSelection().getActionCommand(),radioButtonGroup.getSelection().getActionCommand(),wayOfPaymentCombo.getSelectedItem().toString());
            OrderDetailEvent ordEv = new OrderDetailEvent(DataFields.this,orderDetail);
            orderDetailsFormListener.orderDetailsEventOccurred(ordEv);
            //Promini
            orderDetail.info();

        }
        resetAllData();
    } */

    public void resetAllData(){
        customerName.setText("");
        lastName.setText("");
        address.setText("");
        email.setText("");
        numProds1.setSelected(true);
        prodNme2.setSelected(true);
        normalDelivery.setSelected(true);
        homeDel.setSelected(true);
        wayOfPaymentCombo.setSelectedIndex(-1);
    }


	public JTextField getCustomerName() {
		return customerName;
	}


	public void setCustomerName(JTextField customerName) {
		this.customerName = customerName;
	}


	public JTextField getLastName() {
		return lastName;
	}


	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}


	public JTextField getAddress() {
		return address;
	}


	public void setAddress(JTextField address) {
		this.address = address;
	}


	public JTextField getEmail() {
		return email;
	}


	public void setEmail(JTextField email) {
		this.email = email;
	}


	public JCheckBox getNumProds() {
		return numProds;
	}


	public void setNumProds(JCheckBox numProds) {
		this.numProds = numProds;
	}


	public JCheckBox getNumProds1() {
		return numProds1;
	}


	public void setNumProds1(JCheckBox numProds1) {
		this.numProds1 = numProds1;
	}


	public JCheckBox getNumProds2() {
		return numProds2;
	}


	public void setNumProds2(JCheckBox numProds2) {
		this.numProds2 = numProds2;
	}


	public JCheckBox getNumProds3() {
		return numProds3;
	}


	public void setNumProds3(JCheckBox numProds3) {
		this.numProds3 = numProds3;
	}


	public JCheckBox getNumProds4() {
		return numProds4;
	}


	public void setNumProds4(JCheckBox numProds4) {
		this.numProds4 = numProds4;
	}


	public JRadioButton getProdNme() {
		return prodNme;
	}


	public void setProdNme(JRadioButton prodNme) {
		this.prodNme = prodNme;
	}


	public JRadioButton getProdNme1() {
		return prodNme1;
	}


	public void setProdNme1(JRadioButton prodNme1) {
		this.prodNme1 = prodNme1;
	}


	public JRadioButton getProdNme2() {
		return prodNme2;
	}


	public void setProdNme2(JRadioButton prodNme2) {
		this.prodNme2 = prodNme2;
	}


	public JRadioButton getProdNme3() {
		return prodNme3;
	}


	public void setProdNme3(JRadioButton prodNme3) {
		this.prodNme3 = prodNme3;
	}


	public JCheckBox getHomeDel() {
		return homeDel;
	}


	public void setHomeDel(JCheckBox homeDel) {
		this.homeDel = homeDel;
	}


	public JCheckBox getPickUpDel() {
		return pickUpDel;
	}


	public void setPickUpDel(JCheckBox pickUpDel) {
		this.pickUpDel = pickUpDel;
	}


	public JCheckBox getOfficeDelivery() {
		return officeDelivery;
	}


	public void setOfficeDelivery(JCheckBox officeDelivery) {
		this.officeDelivery = officeDelivery;
	}


	public JRadioButton getExpressDelivery() {
		return expressDelivery;
	}


	public void setExpressDelivery(JRadioButton expressDelivery) {
		this.expressDelivery = expressDelivery;
	}


	public JRadioButton getNormalDelivery() {
		return normalDelivery;
	}


	public void setNormalDelivery(JRadioButton normalDelivery) {
		this.normalDelivery = normalDelivery;
	}


	public JButton getSubmitButton() {
		return submitButton;
	}


	public void setSubmitButton(JButton submitButton) {
		this.submitButton = submitButton;
	}


	public ButtonGroup getCheckboxGroup() {
		return checkboxGroup;
	}


	public void setCheckboxGroup(ButtonGroup checkboxGroup) {
		this.checkboxGroup = checkboxGroup;
	}


	public ButtonGroup getCheckboxGroup2() {
		return checkboxGroup2;
	}


	public void setCheckboxGroup2(ButtonGroup checkboxGroup2) {
		this.checkboxGroup2 = checkboxGroup2;
	}


	public ButtonGroup getRadioButtonGrp() {
		return radioButtonGrp;
	}


	public void setRadioButtonGrp(ButtonGroup radioButtonGrp) {
		this.radioButtonGrp = radioButtonGrp;
	}


	public ButtonGroup getRadioButtonGroup() {
		return radioButtonGroup;
	}


	public void setRadioButtonGroup(ButtonGroup radioButtonGroup) {
		this.radioButtonGroup = radioButtonGroup;
	}


	public JComboBox<WayOfPaymentStrategy> getWayOfPaymentCombo() {
		return wayOfPaymentCombo;
	}


	public void setWayOfPaymentCombo(JComboBox<WayOfPaymentStrategy> wayOfPaymentCombo) {
		this.wayOfPaymentCombo = wayOfPaymentCombo;
	}


	public OrderDetailsFormListener getOrderDetailsFormListener() {
		return orderDetailsFormListener;
	}


	public void setOrderDetailsFormListener(OrderDetailsFormListener orderDetailsFormListener) {
		this.orderDetailsFormListener = orderDetailsFormListener;
	}


	public OrderDetail getOrderDetail() {
		return orderDetail;
	}


	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
    
    

}