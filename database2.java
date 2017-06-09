package database;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class database2 implements ActionListener {

    String fname;
    String lname;
    String regno;
    String marks;
    
    
    JLabel jfname, jlname, jreg, jsave, jregno, jdelete,jview,jmarks;
    JButton button;
    JComboBox cbox;
    JRadioButton RMale, RFemale;
    JTextField jtfname, jtlname, jtregno,jtmarks;

    public database2() {
        JFrame jfrm = new JFrame("database2");
        jfrm.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        jreg = new JLabel("Student Details");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        jfrm.add(jreg, c);
        jfrm.setSize(400,300);
        JMenu rb= new JMenu("REGISTRATION");
        rb.add(new JMenuItem("LOGIN"));
        rb.add(new JMenuItem("CREATE ACCOUNT"));
        JMenuBar menubar = new JMenuBar();
        menubar.add(rb);
        jfrm.setJMenuBar(menubar);
        jfrm.addWindowListener(new WindowAdapter( ){
            public void windowClosing(WindowEvent we){ System.exit(0);}
        });
        jfrm.setVisible(true);
        
//FIRST NAME
        jfname = new JLabel("First Name");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(10, 0, 0, 10);  //left padding
        c.gridx = 0;
        c.gridy = 1;
        jfrm.add(jfname, c);
        jtfname = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        jfrm.add(jtfname, c);
//LAST NAME
        jlname = new JLabel("Last Name");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(10, 0, 0, 10);  //left padding set to 10
        c.gridx = 0;
        c.gridy = 2;
        jfrm.add(jlname, c);
        jtlname = new JTextField(10); //JTextfield  size
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 2;
        jfrm.add(jtlname, c);
//REG NUMBER
        jregno = new JLabel("Reg Number");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(10, 0, 0, 10);  //left padding set to 10
        c.gridx = 0;
        c.gridy = 3;
        jfrm.add(jregno, c);
        jtregno = new JTextField(10); //JTextfield  size
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 3;
        jfrm.add(jtregno, c);
//MARKS
        jmarks = new JLabel("Marks");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(10, 0, 0, 10);  //left padding set to 10
        c.gridx = 0;
        c.gridy = 4;
        jfrm.add(jmarks, c);
        jtmarks = new JTextField(5); //JTextfield  size
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 4;
        jfrm.add(jtmarks, c);
        

//RADIOBUTTONS
        RMale = new JRadioButton("Male");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 5;
        jfrm.add(RMale, c);

        RFemale = new JRadioButton("Female");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 5;
        jfrm.add(RFemale, c);

        ButtonGroup bg = new ButtonGroup();
        bg.add(RMale);
        bg.add(RFemale);
        
        RadioButtonHandler h= new  RadioButtonHandler();


// SAVE BUTTON
        button = new JButton("Save");
        c.fill = GridBagConstraints.HORIZONTAL;
        button.setActionCommand("Save");
        button.addActionListener(this);
        c.weightx = 0.5;
        c.ipadx = 10;
        c.gridwidth = 3;
        c.insets = new Insets(10, 0, 0, 0);  //left padding
        c.gridx = 0;
        c.gridy = 6;
        jfrm.add(button, c);
// Delete button
        button = new JButton("Delete");
        c.fill = GridBagConstraints.HORIZONTAL;
        button.setActionCommand("Delete");
        button.addActionListener(this);
        c.weightx = 0.5;
        c.ipadx = 10;
        c.gridwidth = 3;
        c.insets = new Insets(10, 0, 0, 0);  //left padding
        c.gridx = 0;
        c.gridy = 7;
        jfrm.add(button, c);
// View Button
        button = new JButton("View");
        c.fill = GridBagConstraints.HORIZONTAL;
        button.setActionCommand("View");
        button.addActionListener(this);
        c.weightx = 0.5;
        c.ipadx = 10;
        c.gridwidth = 3;
        c.insets = new Insets(10, 0, 0, 0);  //left padding
        c.gridx = 0;
        c.gridy = 8;
        jfrm.add(button, c);
//save label
        jsave = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipadx = 10;
        c.gridwidth = 3;
        c.insets = new Insets(10, 0, 0, 0);  //left padding
        c.gridx = 0;
        c.gridy = 9;
        jfrm.add(jsave, c);
//delete label
        jdelete = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipadx = 10;
        c.gridwidth = 3;
        c.insets = new Insets(10, 0, 0, 0);  //left padding
        c.gridx = 0;
        c.gridy = 10;
        jfrm.add(jdelete, c);
//view label
        jview = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipadx = 10;
        c.gridwidth = 3;
        c.insets = new Insets(10, 0, 0, 0);  //left padding
        c.gridx = 0;
        c.gridy = 11;
        jfrm.add(jview, c);

        jfrm.setResizable(false);
        jfrm.setSize(500, 400);
//display frame
        jfrm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String f = jtfname.getText();
        this.fname = f;
        String s = jtlname.getText();
        this.lname = s;
        String r = jtregno.getText();
        this.regno = r;
        String m = jtmarks.getText();
        this.marks = m;
        if (ae.getActionCommand().equals("Save")) {
            jsave.setText("Record Saved");

            Connection conn = null;
            try {
                String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
                String url = "jdbc:mysql://localhost/braton2";
                conn = DriverManager.getConnection(url, "root", "");
                String sql = "INSERT INTO details(fname,lname,regno,marks)values('" + fname + "','" + lname + "','" + regno + "','"+marks+"')";
                Statement st = conn.createStatement();
                boolean rs = st.execute(sql);
                st.close();
                conn.close();
            } catch (SQLException es) {
                es.printStackTrace();
            } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException fe) {
                    fe.printStackTrace();
                }
            }
        }
        if (ae.getActionCommand().equals("Delete")) {
            jdelete.setText("Record Deleted");
            Connection conn = null;
            try {
                String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
                String url = "jdbc:mysql://localhost/braton2";
                conn = DriverManager.getConnection(url, "root", "");
                String sql = "DELETE FROM details where regno='0'";
                Statement st = conn.createStatement();
                boolean rs = st.execute(sql);
                st.close();
                conn.close();
            } catch (SQLException es) {
                es.printStackTrace();
            } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException fe) {
                    fe.printStackTrace();
                }
            }
        }



    }

    public static void main(String args[]) {
//event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new database2();
            }
        });
    }
    
     private class RadioButtonHandler implements ItemListener {
     // handle radio button events
       public void itemStateChanged( ItemEvent event )  {
         
          if ( event.getSource() == RMale ){
              
              
          }
   
          else if ( event.getSource() == RFemale ){
              
             
          
      }
   }  
}
}
