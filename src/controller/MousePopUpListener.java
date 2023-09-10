package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MousePopUpListener extends MouseAdapter {

    private final AppPopUpMenu appPopUpMenu;

 
    public MousePopUpListener(AppPopUpMenu appPopUpMenu) {
        this.appPopUpMenu = appPopUpMenu;
    }

    public void mousePressed(MouseEvent mev) {
        if (mev.isPopupTrigger())
            doSomething(mev);
    }


    public void mouseReleased(MouseEvent mev) {
        if (mev.isPopupTrigger())
            doSomething(mev);
    }


    private void doSomething(MouseEvent mev) {
        if (mev.isPopupTrigger()) {
            appPopUpMenu.show(mev.getComponent(), mev.getX(), mev.getY());
        }
    }


}
