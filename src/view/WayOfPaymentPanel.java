package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WayOfPaymentPanel extends JPanel {

    private JComboBox<WayOfPaymentStrategy> wayOfPaymentCombo;

    public WayOfPaymentPanel(JComboBox<WayOfPaymentStrategy> wayOfPaymentCombo) {
        this.wayOfPaymentCombo = wayOfPaymentCombo;
        setSizeOfWayOfPaymentPanel();
        setBorderOfWayOfPaymentPanel();
        layoutAllWayOfPaymentComponents();
    }

    private void setSizeOfWayOfPaymentPanel() {
        Dimension dimension = new Dimension();
        dimension.height = 160;
        dimension.width = 250;
        setPreferredSize(dimension);
    }

  
    private void setBorderOfWayOfPaymentPanel(){
        Border innerBorder = BorderFactory.createTitledBorder("Way of payment");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    private void layoutAllWayOfPaymentComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,20,0);

        //combo box
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose way of payment:"),gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(wayOfPaymentCombo,gbc);

    }

}
