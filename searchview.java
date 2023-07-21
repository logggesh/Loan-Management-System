import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;

public class searchview {
    public static JTable tab;
    public static JTextField lnumsc,namesc,mobsc,vechsc,vechnamesc;
    public static String op1,op2,op3,op4,op5,lnnum2,lnnum3,lnnum4,lnnum1;
    public static int lnnum;
    searchview(){
        JLabel search,name,select;
        String options[]={"Select","Loan Number","Mobile No","Name","Vechicle No","Vechicle Name"};
        JFrame frme = new JFrame("Search");
        select = new JLabel("Select your option");
        select.setBounds(700,160,150,30);
        search = new JLabel("Search");
        search.setFont(new Font("sans",Font.BOLD,20));
        JComboBox option = new JComboBox(options);
        search.setBounds(450,30,150,30);
        option.setBounds(700,200,120,30);
        


        
        option.addActionListener(e->{  
            
            JButton lnsearchbtn,mobnobtn,namebtn,vnumbtn,vnumscbtn;
            JButton lnumbtn1,lnumbtn2,lnumbtn3,lnumbtn4,lnumbtn5;

            String urlString="jdbc:mysql://localhost:3306/loandetails";
            String username="root";
            String pass="";
            op1 =(String) option.getSelectedItem();
            if(op1 == "Loan Number"){
                lnumsc = new JTextField();
                lnumsc.setBounds(700,260,120,20);
                frme.add(lnumsc);
                lnsearchbtn = new JButton("Search");
                lnsearchbtn.setBounds(700,300,100,30);
                frme.add(lnsearchbtn);
                lnumbtn1 = new JButton("Display all");
                lnumbtn1.setBounds(700,350,100,30);
                frme.add(lnumbtn1);
                frme.setVisible(true);
                lnumbtn1.addActionListener(z->{
                    new loandetviewsc();
                });
                lnsearchbtn.addActionListener(f->{
                    try{
                        JTable tab;
                        DefaultTableModel tablemod1;
                    lnnum = Integer.parseInt(lnumsc.getText());
                    String querystr1="select Loannumber,customername,phonenumber,registrationnumber,vechiclename from loandetails where Loannumber=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setInt(1,lnnum);
                    ResultSet rs=ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int noofcol = rsmd.getColumnCount();
                    String[] colname = new String[noofcol];
                    for(int i=0;i<noofcol;i++){
                        colname[i]=rsmd.getColumnName(i+1);
                    }
                    tablemod1=new DefaultTableModel();
                    tablemod1.setColumnIdentifiers(colname);
                    while(rs.next()){
                        String lnum = rs.getString("Loannumber");
                        String custname = rs.getString("customername");
                        String phnnum = rs.getString("phonenumber");
                        String regnum = rs.getString("registrationnumber");
                        String[] tbldata={lnum,custname,phnnum,regnum};
                        tablemod1.addRow(tbldata);
                    }
                    tab = new JTable(tablemod1);
                    tab.setBounds(50,100,500,500);
                    tab.setFont(new Font("sans",Font.BOLD,15));
                    frme.add(tab);
                    frme.setVisible(true);
                    con.close();

                }
                catch(Exception x){
                    System.out.println(x);
                }
            });
        }
            else if(op1 == "Mobile No"){
                mobsc = new JTextField();
                mobsc.setBounds(700,260,120,20);
                frme.add(mobsc);
                 mobnobtn = new JButton("Search");
                mobnobtn.setBounds(700,300,100,30);
                frme.add(mobnobtn);
                lnumbtn2 = new JButton("Display all");
                lnumbtn2.setBounds(700,350,100,30);
                frme.add(lnumbtn2);
                frme.setVisible(true);
                lnumbtn2.addActionListener(z->{
                    new loandetviewsc();
                });
                mobnobtn.addActionListener(f->{
                    try{
                        JTable tab;
                        DefaultTableModel tablemod1;
                    lnnum1 = mobsc.getText();
                    String querystr1="select Loannumber,customername,phonenumber,registrationnumber,vechiclename from loandetails where phonenumber=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum1);
                    ResultSet rs=ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int noofcol = rsmd.getColumnCount();
                    String[] colname = new String[noofcol];
                    for(int i=0;i<noofcol;i++){
                        colname[i]=rsmd.getColumnName(i+1);
                    }
                    tablemod1=new DefaultTableModel();
                    tablemod1.setColumnIdentifiers(colname);
                    while(rs.next()){
                        String lnum = rs.getString("Loannumber");
                        String custname = rs.getString("customername");
                        String phnnum = rs.getString("phonenumber");
                        String regnum = rs.getString("registrationnumber");
                        String vechname = rs.getString("vechiclename");
                        String[] tbldata={lnum,custname,phnnum,regnum,vechname};
                        tablemod1.addRow(tbldata);
                    }
                    tab = new JTable(tablemod1);
                    tab.setBounds(50,100,500,500);
                    tab.setFont(new Font("sans",Font.BOLD,15));
                    frme.add(tab);
                    frme.setVisible(true);
                    con.close();

                }
                catch(Exception x){
                    System.out.println(x);
                }
            });
            }
            else if(op1 == "Name"){
                namesc = new JTextField();
                namesc.setBounds(700,260,120,20);
                frme.add(namesc);
                namebtn = new JButton("Search");
                namebtn.setBounds(700,300,100,30);
                frme.add(namebtn);
                lnumbtn3 = new JButton("Display all");
                lnumbtn3.setBounds(700,350,100,30);
                frme.add(lnumbtn3);
                frme.setVisible(true);
                lnumbtn3.addActionListener(z->{
                    new loandetviewsc();
                });
                namebtn.addActionListener(f->{
                    try{
                        JTable tab;
                        DefaultTableModel tablemod1;
                        lnnum2 = namesc.getText();
                    String querystr1="select Loannumber,customername,phonenumber,registrationnumber,vechiclename from loandetails where customername=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum2);
                    ResultSet rs=ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int noofcol = rsmd.getColumnCount();
                    String[] colname = new String[noofcol];
                    for(int i=0;i<noofcol;i++){
                        colname[i]=rsmd.getColumnName(i+1);
                    }
                    tablemod1=new DefaultTableModel();
                    tablemod1.setColumnIdentifiers(colname);
                    while(rs.next()){
                        String lnum = rs.getString("Loannumber");
                        String custname = rs.getString("customername");
                        String phnnum = rs.getString("phonenumber");
                        String regnum = rs.getString("registrationnumber");
                        String vechname = rs.getString("vechiclename");
                        String[] tbldata={lnum,custname,phnnum,regnum,vechname};
                        tablemod1.addRow(tbldata);
                    }
                    tab = new JTable(tablemod1);
                    tab.setBounds(50,100,500,500);
                    tab.setFont(new Font("sans",Font.BOLD,15));
                    frme.add(tab);
                    frme.setVisible(true);
                    con.close();

                }
                catch(Exception z){
                    System.out.println(z);
                }
            });
            }
            else if(op1 == "Vechicle No"){
                vechsc = new JTextField();
                vechsc.setBounds(700,260,120,20);
                frme.add(vechsc);
                vnumbtn = new JButton("Search");
                vnumbtn.setBounds(700,300,100,30);
                frme.add(vnumbtn);
                lnumbtn4 = new JButton("Display all");
                lnumbtn4.setBounds(700,350,100,30);
                frme.add(lnumbtn4);
                frme.setVisible(true);
                lnumbtn4.addActionListener(z->{
                    new loandetviewsc();
                });
                vnumbtn.addActionListener(f->{
                    try{
                        JTable tab;
                        DefaultTableModel tablemod1;
                        lnnum3 = vechsc.getText();
                    String querystr1="select Loannumber,customername,phonenumber,registrationnumber,vechiclename from loandetails where registrationnumber=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum3);
                    ResultSet rs=ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int noofcol = rsmd.getColumnCount();
                    String[] colname = new String[noofcol];
                    for(int i=0;i<noofcol;i++){
                        colname[i]=rsmd.getColumnName(i+1);
                    }
                    tablemod1=new DefaultTableModel();
                    tablemod1.setColumnIdentifiers(colname);
                    while(rs.next()){
                        String lnum = rs.getString("Loannumber");
                        String custname = rs.getString("customername");
                        String phnnum = rs.getString("phonenumber");
                        String regnum = rs.getString("registrationnumber");
                        String vechname = rs.getString("vechiclename");
                        String[] tbldata={lnum,custname,phnnum,regnum,vechname};
                        tablemod1.addRow(tbldata);
                    }
                    tab = new JTable(tablemod1);
                    tab.setFont(new Font("sans",Font.BOLD,15));
                    tab.setBounds(50,100,500,500);
                    frme.add(tab);
                    frme.setVisible(true);
                    con.close();

                }
                catch(Exception z){
                    System.out.println(z);
                }
            });
            }
            else if(op1 == "Vechicle Name" ){
                vechnamesc = new JTextField();
                vechnamesc.setBounds(700,260,120,20);
                frme.add(vechnamesc);
                vnumscbtn = new JButton("Search");
                vnumscbtn.setBounds(700,300,100,30);
                frme.add(vnumscbtn);
                lnumbtn5 = new JButton("Display all");
                lnumbtn5.setBounds(700,350,100,30);
                frme.add(lnumbtn5);
                frme.setVisible(true);
                lnumbtn5.addActionListener(z->{
                    new loandetviewsc();
                });
                vnumscbtn.addActionListener(f->{
                    try{
                        JTable tab;
                        DefaultTableModel tablemod1;
                        lnnum4 = vechnamesc.getText();
                    String querystr1="select Loannumber,customername,phonenumber,registrationnumber,vechiclename from loandetails where vechiclename=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum4);
                    ResultSet rs=ps.executeQuery();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int noofcol = rsmd.getColumnCount();
                    String[] colname = new String[noofcol];
                    for(int i=0;i<noofcol;i++){
                        colname[i]=rsmd.getColumnName(i+1);
                    }
                    tablemod1=new DefaultTableModel();
                    tablemod1.setColumnIdentifiers(colname);
                    while(rs.next()){
                        String lnum = rs.getString("Loannumber");
                        String custname = rs.getString("customername");
                        String phnnum = rs.getString("phonenumber");
                        String regnum = rs.getString("registrationnumber");
                        String vechname = rs.getString("vechiclename");
                        String[] tbldata={lnum,custname,phnnum,regnum,vechname};
                        tablemod1.addRow(tbldata);
                    }
                    tab = new JTable(tablemod1);
                    tab.setFont(new Font("sans",Font.BOLD,15));
                    tab.setBounds(50,100,500,500);
                    frme.add(tab);
                    frme.setVisible(true);
                    con.close();

                }
                catch(Exception z){
                    System.out.println(z);
                }
            });

            }



        });
        


        JButton backButton = new JButton("Back");
        backButton.setBounds(430,600,100,30);
        backButton.addActionListener(e->{
            frme.dispose();
            new hmpge();
        });
        frme.add(backButton);
        frme.add(search);
        frme.getContentPane().setBackground(Color.cyan);
        frme.setLayout(null);
        frme.add(option);
        frme.add(select);
        
        frme.setSize(1000,700);
        frme.setVisible(true);



    }
    
}
