package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CustomerInformationPanel extends JPanel {

    private JTextField customerName;  
    private JTextField lastName;    
    private JTextField address;  
    private JTextField email;

    public CustomerInformationPanel(JTextField customerName, JTextField lastName, JTextField address, JTextField email) {
        this.customerName = customerName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        setSizeCustmInfPnl();
        setBorderCustmInfPnl();
        setLayoutCustmComps();
    }

    private void setSizeCustmInfPnl(){
        Dimension dimension = new Dimension();
        dimension.width = 250;
        dimension.height = 250;
        setPreferredSize(dimension);
    }

    private void setBorderCustmInfPnl(){

        Border innerBorder = BorderFactory.createTitledBorder("Customer info:");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    private void setLayoutCustmComps(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,15,0);

        //customerName field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Customer name:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(customerName,gbc);

        //lastName field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Last name:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(lastName,gbc);

        //address field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Address:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(address,gbc);

        //email field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Email:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(email,gbc);

    }
}
