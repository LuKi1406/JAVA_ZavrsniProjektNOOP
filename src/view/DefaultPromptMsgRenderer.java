package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;


public class DefaultPromptMsgRenderer extends BasicComboBoxRenderer {

    private String msg;

   
    public DefaultPromptMsgRenderer(String msg){
        this.msg = msg;
    }

  
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value == null){
            setText(msg);
        }
        return this;
    }

}
