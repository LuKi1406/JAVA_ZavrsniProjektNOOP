package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class ProdShopPanel extends JPanel {

    private ButtonGroup checkboxGroup2;
    private JCheckBox numProds;
    private JCheckBox numProds1;
    private JCheckBox numProds2;
    private JCheckBox numProds3;  
    private JCheckBox numProds4;  
    
    private ButtonGroup radioButtonGrp;
    private JRadioButton prodNme;
    private JRadioButton prodNme1;
    private JRadioButton prodNme2;
    private JRadioButton prodNme3;
   
    private JButton submitButton;
 
    private ButtonGroup checkboxGroup;
    private JCheckBox homeDel;
    private JCheckBox pickUpDel;
    private JCheckBox officeDelivery;
   
    private ButtonGroup radioButtonGroup;
    private JRadioButton normalDelivery;
    private JRadioButton expressDelivery;

    public ProdShopPanel(ButtonGroup checkboxGroup2, JCheckBox numProds, JCheckBox numProds1, JCheckBox numProds2,
			JCheckBox numProds3, JCheckBox numProds4, ButtonGroup radioButtonGrp, JRadioButton prodNme,
			JRadioButton prodNme1, JRadioButton prodNme2, JRadioButton prodNme3, JButton submitButton,
			ButtonGroup checkboxGroup, JCheckBox homeDel, JCheckBox pickUpDel, JCheckBox officeDelivery,
			ButtonGroup radioButtonGroup, JRadioButton normalDelivery, JRadioButton expressDelivery) {
		super();
		this.checkboxGroup2 = checkboxGroup2;
		this.numProds = numProds;
		this.numProds1 = numProds1;
		this.numProds2 = numProds2;
		this.numProds3 = numProds3;
		this.numProds4 = numProds4;
		this.radioButtonGrp = radioButtonGrp;
		this.prodNme = prodNme;
		this.prodNme1 = prodNme1;
		this.prodNme2 = prodNme2;
		this.prodNme3 = prodNme3;
		this.submitButton = submitButton;
		this.checkboxGroup = checkboxGroup;
		this.homeDel = homeDel;
		this.pickUpDel = pickUpDel;
		this.officeDelivery = officeDelivery;
		this.radioButtonGroup = radioButtonGroup;
		this.normalDelivery = normalDelivery;
		this.expressDelivery = expressDelivery;
		
		setSizeOfShopPanel();
		setBorderShopPnl();
		layoutAllShopComps();
		
	}


	private void setSizeOfShopPanel(){
        Dimension dimension = new Dimension();
        dimension.width = 700;
        dimension.height = 250;
        setPreferredSize(dimension);
    }


    private void setBorderShopPnl(){
        Border innerBorder = BorderFactory.createTitledBorder("Bookshop");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }


    private void layoutAllShopComps(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,20,6,50);

        //First Column
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("List of product in the shop:"),gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(prodNme,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(prodNme1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(prodNme2,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(prodNme3,gbc);
        
        //Second Column
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose number of products(max 6):"),gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(numProds,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(numProds1,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(numProds2,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(numProds3,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(numProds4,gbc);
        
        //JCheckBoxes
        //Third Column
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose a place for delivery "),gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(homeDel,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(pickUpDel,gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(officeDelivery,gbc);

        //JRadioButtons
        //Forth Column
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose a way of delivery:"),gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(normalDelivery,gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(expressDelivery,gbc);

        //SubmitButton
        //Fifth Column
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        add(submitButton,gbc);

    }
}
