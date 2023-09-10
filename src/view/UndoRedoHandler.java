package view;

public class UndoRedoHandler {

    private ViewPanel viewPanel;

    public UndoRedoHandler(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

   
    public void undo(){
        viewPanel.undoManager.undo();
    }

    public void redo(){
        viewPanel.undoManager.redo();
    }

}
