import javax.swing.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class loantotalview {
    public  String cusdetdis,adddis,loandetnum,phnnumdis,vechiclenamedis,custnamestr,modelyeardis,regdis,gu_teernamedis,gu_teernumdis,gu_teeradddis,amtdis,numberofmondis;
    loantotalview(){
        JFrame frme;
        JLabel cusdet,gurandet,vechdet,loannum,custname,phno,address,landmark,gu_name,gu_num,gu_add,vechname,mdlyr,amtdet,amt,noofmon,loannodis,cunmdis;
        JLabel phnumdis,adddisp,lndmrkdis,gu_namedis,gu_numdis,gu_adddis,vechnmedis,mdlyrdis,amtdisshw,numofmondis;
        JButton close;
        int loandisplay=loandetview.loandisnum;
        try{
                String urlString="jdbc:mysql://localhost:3306/loandetails";
                String username="root";
                String pass="";
                String lquery1= "select Loannumber,customername,phonenumber,address,landmark,vechiclename,modelyear,registrationnumber,guranteername,guranteernumber,guranteeradress,amount,numberofmonths from loandetails where Loannumber=?";
                Connection con = DriverManager.getConnection(urlString,username,pass);
                PreparedStatement ps = con.prepareStatement(lquery1);
                ps.setInt(1,loandisplay);
                ResultSet rs1=ps.executeQuery();
                while(rs1.next()){
                loandetnum = rs1.getString("Loannumber");
                custnamestr = rs1.getString("customername");
                cusdetdis = rs1.getString("phonenumber");
                phnnumdis = rs1.getString ("address");
                adddis = rs1.getString("landmark");
                vechiclenamedis = rs1.getString("vechiclename");
                modelyeardis = rs1.getString("modelyear");
                regdis = rs1.getString("registrationnumber");
                gu_teernamedis = rs1.getString("guranteername");
                gu_teernumdis = rs1.getString("guranteernumber");
                gu_teeradddis = rs1.getString("guranteeradress");
                amtdis = rs1.getString("amount");
                numberofmondis = rs1.getString("numberofmonths");
                }
        }
        catch(Exception f){
            System.out.println(f);
        }
        frme = new JFrame("Details");
        cusdet = new JLabel("Customer Details");
        cusdet.setBounds(100,60,130,30);

        vechdet=new JLabel("Vechicle details");
        vechdet.setBounds(600,60,130,30);

        gurandet = new JLabel("Guranteer Details");
        gurandet.setBounds(370,60,130,30);

        amtdet = new JLabel("Amount Details");
        amtdet.setBounds(790,60,130,30);
        
        loannum = new JLabel("Loan No:");
        loannum.setBounds(40,110,130,30);

        custname = new JLabel("Customer Name:");
        custname.setBounds(40,150,130,30);

        phno = new JLabel("Phone Number:");
        phno.setBounds(40,190,130,30);

        address = new JLabel("Address:");
        address.setBounds(40,230,130,30);

        landmark = new JLabel("Landmark:");
        landmark.setBounds(40,270,130,30);

        gu_name = new JLabel("Guranteer Name:");
        gu_name.setBounds(280,110,130,30);

        gu_num = new JLabel("Guranteer Number:");
        gu_num.setBounds(280,150,130,30);

        gu_add = new JLabel("Guranteer Address:");
        gu_add.setBounds(280,190,130,30);

        vechname = new JLabel("Vechicle Name:");
        vechname.setBounds(550,110,130,30);

        mdlyr = new JLabel("Model Year:");
        mdlyr.setBounds(550,150,130,30);

        amt = new JLabel("Amount:");
        amt.setBounds(750,110,130,30);

        noofmon = new JLabel("Number Of Months:");
        noofmon.setBounds(750,150,130,30);

        loannodis = new JLabel(" ");
        loannodis.setBounds(90,110,200,30);
        loannodis.setText(" "+loandetnum);

        cunmdis = new JLabel(" ");
        cunmdis.setBounds(135,155,130,20);
        cunmdis.setText(" "+custnamestr);

        phnumdis = new JLabel(" ");
        phnumdis.setBounds(135,190,130,30);
        phnumdis.setText(""+cusdetdis);

        adddisp = new JLabel("");
        adddisp.setBounds(95,230,130,30);
        adddisp.setText(""+phnnumdis);

        lndmrkdis = new JLabel("");
        lndmrkdis.setBounds(100,270,130,30);
        lndmrkdis.setText(""+adddis);

        gu_namedis = new JLabel("");
        gu_namedis.setBounds(380,110,130,30);
        gu_namedis.setText(""+gu_teernamedis);

        gu_numdis = new JLabel("");
        gu_numdis.setBounds(390,150,130,30);
        gu_numdis.setText(""+gu_teernumdis);

        gu_adddis = new JLabel("");
        gu_adddis.setBounds(400,190,130,30);
        gu_adddis.setText(""+gu_teeradddis);

         vechnmedis= new JLabel("");
        vechnmedis.setBounds(640,110,130,30);
        vechnmedis.setText(""+vechiclenamedis);

        mdlyrdis = new JLabel("");
        mdlyrdis.setBounds(620,150,130,30);
        mdlyrdis.setText(""+modelyeardis);

        amtdisshw = new JLabel("");
        amtdisshw.setBounds(800,110,130,30);
        amtdisshw.setText(""+amtdis);

        numofmondis = new JLabel("");
        numofmondis.setBounds(870,150,130,30);
        numofmondis.setText(""+numberofmondis);

        close = new JButton("Close");
        close.setBounds(470,310,70,30);
        close.addActionListener(e->{
            frme.dispose();
            new loandetview();
        });



        frme.add(close);
        frme.add(lndmrkdis); 
        frme.add(gu_numdis);
        frme.add(gu_namedis);
        frme.add(numofmondis);
        frme.add(gu_adddis);
        frme.add(mdlyrdis);
        frme.add(amtdisshw);
        frme.add(vechnmedis);
        frme.add(gu_name);
        frme.add(phnumdis);
        frme.add(noofmon);
        frme.add(cunmdis);
        frme.add(adddisp);
        frme.add(amt);
        frme.add(loannodis);
        frme.add(mdlyr);
        frme.add(amtdet);
        frme.add(vechname);
        frme.add(gu_num);
        frme.add(gu_add);
        frme.add(landmark);
        frme.add(address);
        frme.add(phno);
        frme.add(custname);
        frme.add(cusdet);
        frme.add(gurandet);
        frme.add(loannum);
        frme.add(vechdet);
        frme.setSize(1000,410);
        frme.getContentPane().setBackground(Color.cyan);
        frme.setLayout(null);
        frme.setVisible(true);

    }
    
}
