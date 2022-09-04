package Utils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

public class gui extends JFrame implements ActionListener {

    protected JButton button1, button2, button3, button4, button5;

    FileOutputStream outputStream;

    File f1;
    File f2;
    File f3;
    File f4;

    String s1 = "Regular";
    String s2 = "Sheet1";
    String s3 = "Sheet1";
    String s4 = "Form responses 1";

    // Reader r1 = new Reader(f1, s1, f2, s2);

    gui() {
        // GUI
        JLabel header = new JLabel("Shri G.S Institue of Technology & Science, Indore", SwingConstants.CENTER);
        // header.setText("Shri G.S Institue of Technology & Science, Indore");
        header.setFont(new Font("Calbiri", Font.BOLD, 30));
        header.setBounds(0, 50, 1000, 80);
        add(header);

        try {
            final ImageIcon icon = new ImageIcon(
                    Objects.requireNonNull(this.getClass().getResource("/Internproject/src/main/java")));
            JLabel logo = new JLabel();
            logo.setIcon(icon);
            logo.setBounds(50, 300, 200, 40);
            add(logo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Generate Button
        button1 = new JButton("Generate");
        button1.setBounds(450, 600, 100, 40);
        add(button1);

        // File 1
        JLabel label2 = new JLabel();
        label2.setText("Input File 1");
        label2.setFont(new Font("Calbiri", Font.BOLD, 20));
        label2.setBounds(180, 300, 200, 40);
        add(label2);

        button2 = new JButton("Choose File");
        button2.setBounds(700, 300, 150, 40);
        button2.addActionListener(this);
        add(button2);

        JButton button6 = new JButton("View sample file");
        button6.setBounds(500, 300, 150, 40);
        button6.addActionListener(this);
        add(button6);

        // File 2
        JLabel label3 = new JLabel();
        label3.setText("Input File 2");
        label3.setFont(new Font("Calbiri", Font.BOLD, 20));
        label3.setBounds(180, 350, 200, 40);
        add(label3);

        button3 = new JButton("Choose file");
        button3.setBounds(700, 350, 150, 40);
        button3.addActionListener(this);
        add(button3);

        JButton button7 = new JButton("View sample file");
        button7.setBounds(500, 350, 150, 40);
        button7.addActionListener(this);
        add(button7);

        // File 3
        JLabel label4 = new JLabel();
        label4.setText("Input File 3");
        label4.setFont(new Font("Calbiri", Font.BOLD, 20));
        label4.setBounds(180, 400, 200, 40);
        add(label4);

        button4 = new JButton("Choose file");
        button4.setBounds(700, 400, 150, 40);
        button4.addActionListener(this);
        add(button4);

        JButton button8 = new JButton("View sample file");
        button8.setBounds(500, 400, 150, 40);
        button8.addActionListener(this);
        add(button8);

        // File 4
        JLabel label5 = new JLabel();
        label5.setText("Input File 4");
        label5.setFont(new Font("Calbiri", Font.BOLD, 20));
        label5.setBounds(180, 450, 200, 40);
        add(label5);

        button5 = new JButton("Choose file");
        button5.setBounds(700, 450, 150, 40);
        button5.addActionListener(this);
        add(button5);

        JButton button9 = new JButton("View sample file");
        button9.setBounds(500, 450, 150, 40);
        button9.addActionListener(this);
        add(button9);

        // JLabel label6= new JLabel();
        // label6.setText("Sample File");
        // label6.setBounds(700, 500, 100, 40);
        // add(label6);

        // JButton button6 = new JButton("Choose file");
        // button6.setBounds(800, 500, 100, 40);
        // button6.addActionListener(this);
        // add(button6);
    }

    private void setFile1(File ss) {
        this.f1 = ss;
    }

    private void setFile2(File sss) {
        this.f2 = sss;
    }

    private void setFile3(File ssss) {
        this.f3 = ssss;
    }

    private void setFile4(File sssss) {
        this.f4 = sssss;
    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == button2) {
            JFileChooser fileChooser = new JFileChooser();
            // restrict the user to select files of all types
            fileChooser.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            fileChooser.setDialogTitle("Select a .xlsx file");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx");
            fileChooser.addChoosableFileFilter(restrict);
            int i = fileChooser.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File file1 = fileChooser.getSelectedFile();
                setFile1(file1);
                System.out.println("File 1 selected");
            }
        } else if (evt.getSource() == button3) {
            JFileChooser fileChooser = new JFileChooser();
            // restrict the user to select files of all types
            fileChooser.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            fileChooser.setDialogTitle("Select a .xlsx file");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx");
            fileChooser.addChoosableFileFilter(restrict);
            int i = fileChooser.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File file1 = fileChooser.getSelectedFile();
                setFile2(file1);
                System.out.println("File 2 selected");
            }
        } else if (evt.getSource() == button4) {
            JFileChooser fileChooser = new JFileChooser();
            // restrict the user to select files of all types
            fileChooser.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            fileChooser.setDialogTitle("Select a .xlsx file");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx");
            fileChooser.addChoosableFileFilter(restrict);
            int i = fileChooser.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File file1 = fileChooser.getSelectedFile();
                setFile3(file1);
                System.out.println("File 3 selected");
            }
        } else if (evt.getSource() == button5) {
            JFileChooser fileChooser = new JFileChooser();
            // restrict the user to select files of all types
            fileChooser.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            fileChooser.setDialogTitle("Select a .xlsx file");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx");
            fileChooser.addChoosableFileFilter(restrict);
            int i = fileChooser.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File file1 = fileChooser.getSelectedFile();
                setFile4(file1);
                System.out.println("File 4 selected");
            }
        } else if (evt.getSource() == button1) {

            System.out.println("Generate clicked");
            Reader r1 = new Reader(f1, s1, f2, s2);
            r1.store();
            // r1.print();
            r1.readHeader(f3, s3);
            // r1.printHeader();
            r1.availabilityStore(f4, s4);

            try {
                outputStream = new FileOutputStream("ResultSheet.xlsx");
                r1.generateFile(outputStream);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }

        }
    }
}