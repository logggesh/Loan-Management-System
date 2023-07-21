import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.awt.Font;
public class delete {
    public static JTable tab;
    public static JTextField lnumsc,namesc,mobsc,vechsc,vechnamesc;
    public static String op1,op2,op3,op4,op5,lnnum2,lnnum3,lnnum4,lnnum1;
    public static int lnnum;
    delete(){
        JLabel search,name,select;
        String options[]={"Select","Loan Number","Mobile No","Name","Vechicle No","Vechicle Name"};
        JFrame frme = new JFrame("DELETE");
        select = new JLabel("Select your option");
        select.setBounds(700,160,150,30);
        search = new JLabel("Delete");
        search.setFont(new Font("sans",Font.BOLD,20));
        JComboBox option = new JComboBox(options);
        search.setBounds(420,30,150,30);
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
                lnsearchbtn = new JButton("Delete");
                lnsearchbtn.setBounds(700,300,100,30);
                frme.add(lnsearchbtn);
                frme.setVisible(true);
                lnsearchbtn.addActionListener(f->{
                    try{
                    lnnum = Integer.parseInt(lnumsc.getText());
                    String querystr1="delete from loandetails where Loannumber=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setInt(1,lnnum);
                    ps.executeUpdate();

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
                 mobnobtn = new JButton("Delete");
                mobnobtn.setBounds(700,300,100,30);
                frme.add(mobnobtn);
                frme.setVisible(true);
                mobnobtn.addActionListener(f->{
                    try{
                    lnnum1 = mobsc.getText();
                    String querystr1="delete from loandetails where phonenumber=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum1);
                    ps.executeUpdate();

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
                namebtn = new JButton("Delete");
                namebtn.setBounds(700,300,100,30);
                frme.add(namebtn);
                frme.setVisible(true);
                namebtn.addActionListener(f->{
                    try{
                        lnnum2 = namesc.getText();
                    String querystr1="delete from loandetails where customername=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum2);
                    ps.executeUpdate();

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
                vnumbtn = new JButton("Delete");
                vnumbtn.setBounds(700,300,100,30);
                frme.add(vnumbtn);
                frme.setVisible(true);
                vnumbtn.addActionListener(f->{
                    try{
                        lnnum3 = vechsc.getText();
                    String querystr1="delete from loandetails where registrationnumber=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum3);
                    ps.executeUpdate();
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
                vnumscbtn = new JButton("Delete");
                vnumscbtn.setBounds(700,300,100,30);
                frme.add(vnumscbtn);
                frme.setVisible(true);
                vnumscbtn.addActionListener(f->{
                    try{
                        lnnum4 = vechnamesc.getText();
                    String querystr1="delete from loandetails where vechiclename=?";
                    Connection con = DriverManager.getConnection(urlString, username, pass);
                    PreparedStatement ps = con.prepareStatement(querystr1);
                    ps.setString(1,lnnum4);
                    ps.executeUpdate();
                }
                catch(Exception z){
                    System.out.println(z);
                }
            });

            }



        });
        


        JButton backButton = new JButton("Back");
        backButton.setBounds(410,570,100,30);
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
