package com.bornander.tools.sheetcreator;

import static com.bornander.utils.Log.*;
import javax.swing.UIManager;

public class SheetCreator {

    public static void main(String[] args) throws Exception {
        i("Starting Sheet Creator");
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        java.awt.EventQueue.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}
