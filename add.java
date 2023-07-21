import static java.awt.Color.white;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class add{
    int store = hmpge.loanupdate;
    add(){
        JLabel loannum,loannumfld,name,custit,regno,addres,num,gu_add,gu_name,gu_num,land,amt,mon,bike,mod,resultshw,rs;
        JTextField namefld,regnofld,numfld,gu_namefld,gu_numfld,landfld,amtfld,monfld,bikefld,modfld;
        JFrame frme=new JFrame("Customer Entry");
        custit=new JLabel("Customer Details  ");
        loannum=new JLabel("Loan Number  ");
        loannumfld=new JLabel(" ");
        loannumfld.setText(""+store);
        name=new JLabel("Customer Name  ");
        namefld=new JTextField();
        regno=new JLabel( "Registration Number  ");
        regnofld=new JTextField();
        addres = new JLabel("Address");
        JTextArea addressfld = new JTextArea();
        JTextArea gu_addfld = new JTextArea();
        num=new JLabel("Phone Number");
        numfld=new JTextField();
        gu_name=new JLabel("Guaranteer Name  ");
        gu_namefld=new JTextField();
        gu_add=new JLabel("Guaranteer Address  ");
        gu_num=new JLabel("Guaranteer Number  ");
        gu_numfld=new JTextField();
        land = new JLabel("Landmark  ");
        landfld = new JTextField();
        bike= new JLabel("Vehicle Name");
        bikefld= new JTextField();
        mod= new JLabel("Model Year");
        modfld= new JTextField();
        amt= new JLabel("Amount  ");
        amtfld = new JTextField();
        mon= new JLabel("Number of Months  ");
        monfld = new JTextField();

        resultshw=new JLabel("Amount per month:");
        rs =new JLabel(" ");

        JButton enterbButton = new JButton("Save");
        JButton canButton = new JButton("Cancel");
        JButton calculate = new JButton("Calculate");
        enterbButton.addActionListener(e->{
          int loannumber=hmpge.loanupdate;
          String namestr=namefld.getText();
          String regstr=regnofld.getText();
          String numstr=numfld.getText();
          String gu_namestr=gu_namefld.getText();
          String gu_numstr=gu_numfld.getText();
          String landstr=landfld.getText();
          String amtstr=amtfld.getText();
          String monstr=monfld.getText();
          String bikestr=bikefld.getText();
          String modelstr=modfld.getText();
          String cusadd=addressfld.getText();
          String guranteeradd=gu_addfld.getText();
          try{
            String urlString="jdbc:mysql://localhost:3306/loandetails";
            String username="root";
            String pass="";
            String queryString="insert into loandetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection con=DriverManager.getConnection(urlString,username,pass);
            PreparedStatement stmt=con.prepareStatement(queryString);
            stmt.setInt(1,loannumber);
            stmt.setString(2,namestr);
            stmt.setString(3,numstr);
            stmt.setString(4,cusadd);
            stmt.setString(5,landstr);
            stmt.setString(6,bikestr);
            stmt.setString(7,modelstr);
            stmt.setString(8,regstr);
            stmt.setString(9,gu_namestr);
            stmt.setString(10,gu_numstr);
            stmt.setString(11,guranteeradd);
            stmt.setString(12,amtstr);
            stmt.setString(13,monstr);
            stmt.executeUpdate();
            con.close();
            frme.dispose();
            
            new hmpge();
          }
          catch(Exception f){
            System.out.println(f);
          }


        });
        calculate.addActionListener(e ->{
            int getval=Integer.parseInt(amtfld.getText());
            int getval2=Integer.parseInt(monfld.getText());
            int tot=getval/getval2;
            rs.setText("  "+tot);
        });
        canButton.addActionListener(e ->{
            
            frme.dispose();
            new hmpge();
            
        });
        

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
        rs.setBounds(1190, 375, 200, 40);
        resultshw.setFont(new Font("Bookman Old Style",Font.BOLD,18));
        rs.setFont(new Font("Bookman Old Style",Font.BOLD,18));

        calculate.setBounds(1200, 250, 100, 40);

        enterbButton.setBounds(650, 740, 80, 30);
        enterbButton.setBackground(white);
        canButton.setBounds(770,740,80,30);
        canButton.setBackground(white);
        frme.add(custit);
        frme.add(loannum);
        frme.add(loannumfld);
        frme.add(namefld);
        frme.add(name);
        frme.add(regno);
        frme.add(regnofld);
        frme.add(num);
        frme.add(numfld);
        frme.add(addres);
        frme.add(addressfld);
        frme.add(gu_name);
        frme.add(gu_namefld);
        frme.add(gu_addfld);
        frme.add(gu_add);
        frme.add(gu_num);
        frme.add(gu_numfld);
        frme.add(land);
        frme.add(landfld);
        frme.add(mon);
        frme.add(monfld);
        frme.add(amt);
        frme.add(amtfld);
        frme.add(bike);
        frme.add(bikefld);
        frme.add(mod);
        frme.add(modfld);
        frme.add(enterbButton); 
        frme.add(canButton);
        frme.add(calculate);
        frme.add(resultshw);
        frme.add(rs);
        frme.setSize(1600,900); 
        frme.setLayout(null);
        frme.setVisible(true);
    }
}