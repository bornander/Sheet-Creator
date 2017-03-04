package com.bornander.tools.sheetcreator;

import javax.swing.JOptionPane;
import static com.bornander.utils.Log.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooserSaveAs = new javax.swing.JFileChooser();
        tileGrid = new com.bornander.tools.sheetcreator.TileGrid();
        menuBarMain = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemNew = new javax.swing.JMenuItem();
        menuItemSaveAs = new javax.swing.JMenuItem();
        menuItemOpen = new javax.swing.JMenuItem();
        separatorFileMenu1 = new javax.swing.JPopupMenu.Separator();
        menuItemExit = new javax.swing.JMenuItem();
        menuOptions = new javax.swing.JMenu();
        checkBoxMenuItemShowGrid = new javax.swing.JCheckBoxMenuItem();

        fileChooserSaveAs.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fileChooserSaveAs.setApproveButtonToolTipText("");
        fileChooserSaveAs.setDialogTitle("Save as");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sheet Creator");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout tileGridLayout = new javax.swing.GroupLayout(tileGrid);
        tileGrid.setLayout(tileGridLayout);
        tileGridLayout.setHorizontalGroup(
            tileGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        tileGridLayout.setVerticalGroup(
            tileGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        menuFile.setText("File");

        menuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItemNew.setText("New...");
        menuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewActionPerformed(evt);
            }
        });
        menuFile.add(menuItemNew);

        menuItemSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSaveAs.setText("Save as...");
        menuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSaveAs);

        menuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemOpen.setText("Open...");
        menuFile.add(menuItemOpen);
        menuFile.add(separatorFileMenu1);

        menuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExit.setMnemonic('x');
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuFile.add(menuItemExit);

        menuBarMain.add(menuFile);

        menuOptions.setText("Options");

        checkBoxMenuItemShowGrid.setSelected(true);
        checkBoxMenuItemShowGrid.setText("Show grid");
        checkBoxMenuItemShowGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxMenuItemShowGridActionPerformed(evt);
            }
        });
        menuOptions.add(checkBoxMenuItemShowGrid);

        menuBarMain.add(menuOptions);

        setJMenuBar(menuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tileGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tileGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewActionPerformed
        SheetPropertiesPanel newSheetPanel = new SheetPropertiesPanel();
        int result = JOptionPane.showConfirmDialog(this, newSheetPanel, "New sheet", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            tileGrid.reset(newSheetPanel.getTileSize(), newSheetPanel.getTilePadding());
        }
    }//GEN-LAST:event_menuItemNewActionPerformed

    private void checkBoxMenuItemShowGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxMenuItemShowGridActionPerformed

        tileGrid.setShowGrid(checkBoxMenuItemShowGrid.isSelected());

    }//GEN-LAST:event_checkBoxMenuItemShowGridActionPerformed

    private void menuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveAsActionPerformed
        if (fileChooserSaveAs.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File targetFile = fileChooserSaveAs.getSelectedFile();
            i("Saving to file %s.", targetFile);
            try {
                tileGrid.save(targetFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, String.format("Failed to save to file %s (%s).", targetFile, e.getMessage()), "File save error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuItemSaveAsActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (tileGrid.isDirty()) {
            int result = JOptionPane.showOptionDialog(this, "There are unsaved changes,\nare you sure you want to exit?", "Exit without saving", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"Yes", "No"}, "No");
            if (result == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem checkBoxMenuItemShowGrid;
    private javax.swing.JFileChooser fileChooserSaveAs;
    private javax.swing.JMenuBar menuBarMain;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemNew;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemSaveAs;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JPopupMenu.Separator separatorFileMenu1;
    private com.bornander.tools.sheetcreator.TileGrid tileGrid;
    // End of variables declaration//GEN-END:variables
}
