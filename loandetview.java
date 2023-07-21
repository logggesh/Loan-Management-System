import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class loandetview {
    public static int loandisnum;

    public loandetview() {
        JLabel ldetails, disp;
        JTable tab;
        DefaultTableModel tablemod;
        JTextField getlnum;
        JButton displayButton;
        JFrame frme = new JFrame("Loan Details");

        try {
            String urlString = "jdbc:mysql://localhost:3306/loandetails";
            String username = "root";
            String pass = "";
            String query = "select Loannumber, customername, phonenumber, registrationnumber from loandetails";

            tablemod = new DefaultTableModel();
            Connection con = DriverManager.getConnection(urlString, username, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int noofcol = rsmd.getColumnCount();
            String[] colname = new String[noofcol];
            for (int i = 0; i < noofcol; i++) {
                colname[i] = rsmd.getColumnName(i + 1);
            }
            tablemod.setColumnIdentifiers(colname);

            while (rs.next()) {
                String loannum = rs.getString("Loannumber");
                String custname = rs.getString("customername");
                String phnnum = rs.getString("phonenumber");
                String regnum = rs.getString("registrationnumber");
                String[] tbldata = { loannum, custname, phnnum, regnum };
                tablemod.addRow(tbldata);
            }

            tab = new JTable(tablemod) {
                @Override
                public boolean getScrollableTracksViewportWidth() {
                    return getPreferredSize().width < getParent().getWidth();
                }
            };

            JScrollPane scrollPane = new JScrollPane(tab);
            scrollPane.setBounds(70, 140, 900, 570);
            frme.add(scrollPane);

            disp = new JLabel("Enter Loan Number");
            getlnum = new JTextField();

            displayButton = new JButton("Display");
            displayButton.setBounds(1130, 255, 100, 30);
            frme.add(displayButton);

            displayButton.addActionListener(e -> {
                loandisnum = Integer.parseInt(getlnum.getText());
                frme.dispose();
                new loantotalview();
            });

            getlnum.setBounds(1200, 207, 100, 30);
            disp.setBounds(1070, 170, 200, 100);
            
            JButton backButton = new JButton("Back");
            backButton.setBounds(700, 730, 100, 30);
            frme.add(backButton);
            
            backButton.addActionListener(e -> {
                frme.dispose();
                new hmpge();
            });

            ldetails = new JLabel("Loan Details");
            ldetails.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
            ldetails.setBounds(700, 10, 200, 100);

            frme.add(ldetails);
            frme.add(disp);
            frme.add(getlnum);
            frme.setSize(1800, 1200);
            frme.getContentPane().setBackground(Color.CYAN);
            frme.setLayout(null);
            frme.setVisible(true);
        } catch (Exception f) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        new loandetview();
    }
}
