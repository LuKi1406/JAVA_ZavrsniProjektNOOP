package controller;

import view.ViewPanel;

import javax.swing.*;

public class CommandManager implements AllCommands {

    private JTextPane jTextPane;


    public CommandManager(ViewPanel viewPanel) {
        this.jTextPane = viewPanel.getjTextPane();

    }

    @Override
    public void cut() {
        jTextPane.cut();

    }

    @Override
    public void copy() {
        jTextPane.copy();

    }

   
    @Override
    public void paste() {
        jTextPane.paste();

    }

    @Override
    public void selectAll() {
        jTextPane.selectAll();
    }

}
