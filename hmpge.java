import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class hmpge{
        public static int loanupdate;
        hmpge(){
        JFrame frme = new JFrame("Loan Management System");
        frme.setSize(700,500);
        JLabel headlabel=new JLabel("Loan Management System");
        JButton addbtn=new JButton("Add");
        JButton viewbtn=new JButton("View");
        JButton delbtn=new JButton("Delete");
        JButton sechbtn = new JButton("Search");
        JButton updateButton = new JButton("Update");
       headlabel.setBounds(230,30,500,100);
       sechbtn.setBounds(210,265,100,50);
       addbtn.setBounds(150,190,100,50);
       viewbtn.setBounds(280,190,100,50);
       delbtn.setBounds(410,190,100,50);
       updateButton.setBounds(330,265,100,50);
       headlabel.setFont(new Font("Serif",Font.BOLD,20));
       frme.getContentPane().setBackground(Color.pink);
       addbtn.addActionListener(e ->{
        try{
                String urlString="jdbc:mysql://localhost:3306/loandetails";
                String username="root";
                String pass="";
                String query="select loannumber from loandetails";
                Connection con=DriverManager.getConnection(urlString,username, pass);
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){
                int loanstore = rs.getInt("loannumber");
                loanupdate=loanstore+1;
                }
                frme.dispose();
                new add();                
        }
        catch(Exception f){
                System.out.println(f);
        }

       });
       sechbtn.addActionListener(e->{
        new searchview();
        frme.dispose();
       });
       viewbtn.addActionListener(e->{
        new loandetview();
        frme.dispose();
       });
       delbtn.addActionListener(e->{
        new delete();
        frme.dispose();
       });
       updateButton.addActionListener(e->{
        new updatepge();
        frme.dispose();
       });
       frme.add(addbtn);
       frme.add(sechbtn);
       frme.add(delbtn);
       frme.add(viewbtn);
       frme.add(headlabel);
       frme.add(updateButton);
       frme.setLayout(null);
       frme.setVisible(true);
}
}
