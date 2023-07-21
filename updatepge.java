import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class updatepge {
    int store = hmpge.loanupdate;
    public  String cusdetdis,adddis,loandetnum,phnnumdis,vechiclenamedis,custnamestr,modelyeardis,regdis,gu_teernamedis,gu_teernumdis,gu_teeradddis,amtdis,numberofmondis;
    updatepge(){     
    JFrame frme = new JFrame("Update");
    JLabel uplab = new JLabel("Update");
    JLabel uplab1 = new JLabel("enter loan number:");
    JButton open = new JButton("Open");
    JButton cancel = new JButton("Cancel");
    JTextField lnum = new JTextField();
    cancel.addActionListener(e->{
        frme.dispose();
        new hmpge();
    });
    open.addActionListener(e->{
        try{
      
        int getlnum = Integer.parseInt(lnum.getText());
        String urlString="jdbc:mysql://localhost:3306/loandetails";
        String username="root";
        String pass="";
        String lquery1= "select Loannumber,customername,phonenumber,address,landmark,vechiclename,modelyear,registrationnumber,guranteername,guranteernumber,guranteeradress,amount,numberofmonths from loandetails where Loannumber=?";
        Connection con = DriverManager.getConnection(urlString,username,pass);
        PreparedStatement ps = con.prepareStatement(lquery1);
        ps.setInt(1,getlnum);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            loandetnum = rs.getString("Loannumber");
                custnamestr = rs.getString("customername");
                cusdetdis = rs.getString("phonenumber");
                phnnumdis = rs.getString ("address");
                adddis = rs.getString("landmark");
                vechiclenamedis = rs.getString("vechiclename");
                modelyeardis = rs.getString("modelyear");
                regdis = rs.getString("registrationnumber");
                gu_teernamedis = rs.getString("guranteername");
                gu_teernumdis = rs.getString("guranteernumber");
                gu_teeradddis = rs.getString("guranteeradress");
                amtdis = rs.getString("amount");
                numberofmondis = rs.getString("numberofmonths");
        }
        JLabel loannum,loannumfld,name,custit,regno,addres,num,gu_add,gu_name,gu_num,land,amt,mon,bike,mod,resultshw,rs1h;
        JTextField namefld,regnofld,numfld,gu_namefld,gu_numfld,landfld,amtfld,monfld,bikefld,modfld;
        JButton enterbButton = new JButton("Save");
        JButton canButton = new JButton("Cancel");
        JButton calculate = new JButton("Calculate");
        JFrame frme1=new JFrame("Customer Entry");
        custit=new JLabel("Customer Details  ");
        loannum=new JLabel("Loan Number  ");
        loannumfld=new JLabel(" ");
        loannumfld.setText(""+loandetnum);
        name=new JLabel("Customer Name  ");
        namefld=new JTextField();
        namefld.setText(custnamestr);
        regno=new JLabel( "Registration Number  ");
        regnofld=new JTextField();
        regnofld.setText(regdis);
        addres = new JLabel("Address");
        JTextArea addressfld = new JTextArea();
        addressfld.setText(phnnumdis);
        JTextArea gu_addfld = new JTextArea();
        gu_addfld.setText(gu_teeradddis);
        num=new JLabel("Phone Number");
        numfld=new JTextField();
        numfld.setText(cusdetdis);
        gu_name=new JLabel("Guaranteer Name  ");
        gu_namefld=new JTextField();
        gu_namefld.setText(gu_teernamedis);
        gu_add=new JLabel("Guaranteer Address  ");
        gu_num=new JLabel("Guaranteer Number  ");
        gu_numfld=new JTextField();
        gu_numfld.setText(gu_teernumdis);
        land = new JLabel("Landmark  ");
        landfld = new JTextField();
        landfld.setText(adddis);
        bike= new JLabel("Vehicle Name");
        bikefld= new JTextField();
        bikefld.setText(vechiclenamedis);
        mod= new JLabel("Model Year");
        modfld= new JTextField();
        modfld.setText(modelyeardis);
        amt= new JLabel("Amount  ");
        amtfld = new JTextField();
        amtfld.setText(amtdis);
        mon= new JLabel("Number of Months  ");
        monfld = new JTextField();
        monfld.setText(numberofmondis);

        resultshw=new JLabel("Amount per month:");
        rs1h =new JLabel(" ");
        frme.getContentPane().setBackground(Color.cyan);

        custit.setFont(new Font("Bookman Old Style",Font.BOLD,25));
        custit.setBounds(657,20,500,100);

        loannum.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        loannum.setBounds(20,110,230,100);

        loannumfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        loannumfld.setBounds(230, 143, 200, 40);
        loannumfld.setBackground(Color.white);

        name.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        name.setBounds(20,179,200,100);
        namefld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        namefld.setBounds(230,210,200,40);
        namefld.setBackground(Color.white);

        regno.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        regno.setBounds(485,245,220,100);
        regnofld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        regnofld.setBounds(700,280,200,40);
        regnofld.setBackground(Color.white);
        
        num.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        numfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        num.setBounds(20,245,180,100);
        numfld.setBounds(230,280,200,40);
        numfld.setBackground(Color.white);

        addres.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        addressfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        addres.setBounds(20,305,100,100);
        addressfld.setBounds(230,340,200,200);
        addressfld.setBackground(Color.white);

        bike.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        bike.setBounds(485,110,230,100);
        bikefld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        bikefld.setBounds(700, 143, 200, 40);
        bikefld.setBackground(Color.white);

        mod.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        mod.setBounds(485,179,200,100);
        modfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        modfld.setBounds(700, 210, 200, 40);;
        modfld.setBackground(Color.white);

        gu_name.setBounds(485,345,200,100);
        gu_namefld.setBounds(700,380,200,40);
        gu_namefld.setBackground(Color.white);
        gu_namefld.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        gu_name.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        gu_num.setBounds(485,415,220,100);
        gu_numfld.setBounds(700,440,200,40);
        gu_numfld.setBackground(Color.white);
        gu_num.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        gu_numfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        gu_add.setBounds(485,460,230,100);
        gu_addfld.setBounds(700,499,200,180);
        gu_addfld.setBackground(Color.white);
        gu_add.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        gu_addfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        land.setBounds(20, 570, 200, 100);
        landfld.setBounds(230, 600, 200, 40);
        landfld.setBackground(Color.white);
        land.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        landfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        amt.setBounds(1000, 110, 200, 100);
        amtfld.setBounds(1200, 143, 200, 40);
        amtfld.setBackground(Color.white);
        amt.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        amtfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        mon.setBounds(1000, 160, 200, 100);
        monfld.setBounds(1200, 190, 200, 40);
        monfld.setBackground(Color.white);
        mon.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        monfld.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        resultshw.setBounds(1000,345,200,100);
        rs1h.setBounds(1190, 375, 200, 40);
        resultshw.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        rs1h.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        calculate.addActionListener(z ->{
            int getval=Integer.parseInt(amtfld.getText());
            int getval2=Integer.parseInt(monfld.getText());
            int tot=getval/getval2;
            rs1h.setText("  "+tot);
        });
        canButton.addActionListener(g ->{
            
            frme1.dispose();
            new hmpge();
            
        });
        enterbButton.addActionListener(j->{
            try{
            String urlString1="jdbc:mysql://localhost:3306/loandetails";
            String username1="root";
            String pass1="";
            String lquery2= "update loandetails set customername=?,phonenumber=?,address=?,landmark=?,vechiclename=?,modelyear=?,registrationnumber=?,guranteername=?,guranteernumber=?,guranteeradress=?,amount=?,numberofmonths=? where Loannumber=?";
            Connection con1 = DriverManager.getConnection(urlString1,username1,pass1);
            PreparedStatement ps1 = con1.prepareStatement(lquery2);
            ps1.setString(1,custnamestr);
            ps1.setString(2,cusdetdis);
            ps1.setString(3,phnnumdis);
            ps1.setString(4,adddis);
            ps1.setString(5,vechiclenamedis);
            ps1.setString(6,modelyeardis);
            ps1.setString(7,regdis);
            ps1.setString(8,gu_teernamedis);
            ps1.setString(9,gu_teernumdis);
            ps1.setString(10,gu_teeradddis);
            ps1.setString(11,amtdis);
            ps1.setString(12,numberofmondis);
            ps1.setInt(13,store);
            ps1.executeUpdate();
            con1.close();
            }
            catch(Exception ce){
                System.out.println(ce);
            }
        });

        calculate.setBounds(1200, 250, 100, 40);

        enterbButton.setBounds(650, 740, 80, 30);
        canButton.setBounds(770,740,80,30);

        frme1.add(custit);
        frme1.add(loannum);
        frme1.add(loannumfld);
        frme1.add(namefld);
        frme1.add(name);
        frme1.add(regno);
        frme1.add(regnofld);
        frme1.add(num);
        frme1.add(numfld);
        frme1.add(addres);
        frme1.add(addressfld);
        frme1.add(gu_name);
        frme1.add(gu_namefld);
        frme1.add(gu_addfld);
        frme1.add(gu_add);
        frme1.add(gu_num);
        frme1.add(gu_numfld);
        frme1.add(land);
        frme1.add(landfld);
        frme1.add(mon);
        frme1.add(monfld);
        frme1.add(amt);
        frme1.add(amtfld);
        frme1.add(bike);
        frme1.add(bikefld);
        frme1.add(mod);
        frme1.add(modfld);
        frme1.add(resultshw);
        frme1.add(enterbButton); 
        frme1.add(canButton);
        frme1.add(calculate);
        frme1.add(rs1h);
        frme1.setSize(1600,900); 
        frme1.setLayout(null);
        frme1.setVisible(true);
        }
        catch(Exception z){
            System.out.println(z);
        }
    });
    cancel.setBounds(137,200,90,20);
    open.setBounds(150,130,70,20);
    lnum.setBounds(180,90,100,20);
    uplab1.setBounds(65,50,200,100);
    uplab.setBounds(170,5,500,100);
    uplab.setFont(new Font("Serif",Font.BOLD,20));
    frme.getContentPane().setBackground(Color.cyan);
    frme.add(uplab);
    frme.add(uplab1);
    frme.add(lnum);
    frme.add(open);
    frme.add(cancel);
    frme.setSize(400,300);
    frme.setLayout(null);
    frme.setVisible(true);
    }
}
