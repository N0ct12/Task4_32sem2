package main;

import utils.ArrayUtils;
import utils.JTableUtils;
import utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.Arrays;


public class Table extends JFrame {
    Boolean[] fix;
    private JPanel panel1;
    private JButton randomButton;
    private JButton importButton;

    private JTable inputTable;
    private JButton fixButton;
    private JButton sortButton;
    private JTable outputTable;
    private JTable booleanTable;
    private JFileChooser fileChooserOpen;

    private JMenuBar menuBarMain;

    private JMenu menuLookAndFeel;
    public Table() throws ParseException {
        this.setTitle("FrameMain");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        JTableUtils.initJTableForArray(inputTable, 40, false, true, false, true);
        JTableUtils.initJTableForArray(booleanTable, 80, false, true, false, true);
        JTableUtils.initJTableForArray(outputTable, 40, false, true, false, false);
        //tableOutput.setEnabled(false);
        inputTable.setRowHeight(25);
        booleanTable.setRowHeight(25);
        outputTable.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);


        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(inputTable, new int[]{
                0, 1, 2, 3, 4
        });
        JTableUtils.writeArrayToJTable(booleanTable, new Boolean[]{
                true,false,true,false,false
        });
        this.pack();


        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panel1) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(inputTable, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(inputTable.getColumnCount(),-100,100);
                    Boolean[] fix = ArrayUtils.createRandomBooleanArray(booleanTable.getColumnCount());
                    JTableUtils.writeArrayToJTable(inputTable, arr);
                    JTableUtils.writeArrayToJTable(booleanTable, fix);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        fixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                     fix = JTableUtils.readBooleanArrayFromJTable(booleanTable);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Integer[] array = Arrays.stream(JTableUtils.readIntArrayFromJTable(inputTable)).boxed().toArray( Integer[]::new );
                    Boolean[] fixed = fix;
                    Main.sort(array,fixed);
                    JTableUtils.writeArrayToJTable(outputTable,ArrayUtils.toPrimitive(array));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
