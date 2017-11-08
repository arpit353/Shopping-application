package project;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Project {

    public static void main(String[] args) {
        
        
         int input=1;
         int wish;
         int bill=0;
         String username = null;

         JOptionPane.showMessageDialog ( null, " Welcome to K MARKET ");
         
         int flag10=0;
         while(flag10 !=1 )
         {
         if(JOptionPane.showConfirmDialog(null,"Existing user ?","Answer First",JOptionPane.YES_NO_OPTION)==JOptionPane.NO_OPTION)
         {     
            JTextField field1 = new JTextField();
            JPasswordField field2 = new JPasswordField();
            JTextField field3 = new JTextField();
            JTextField field4 = new JTextField();
            JTextField field5 = new JTextField();
            JTextField field6 = new JTextField();
            JTextField field7 = new JTextField();
            JTextField field8 = new JTextField();
            JTextField field9 = new JTextField();
            Object[] message = {
                "User Name", field1,
                "Password", field2,
                "First Name", field3,
                "Last Name", field4,
                "Address", field5,
                "City", field6,
                "Zip Code", field7,
                "Mobile", field8,
                "E mail", field9,
                               };
            int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION)
            {
                String value1 = field1.getText();
                String value2 = String.valueOf(field2.getPassword());
                String value3 = field3.getText();
                String value4 = field4.getText();
                String value5 = field5.getText();
                String value6 = field6.getText();
                String value7 = field7.getText();
                String value8 = field8.getText();
                String value9 = field9.getText();

                username=value1;
                int flag20=0;
                try
                {                 
                    Connection conn20=null;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn20= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
                    String query20 = "SELECT * FROM user" ;
                    Statement st20 = conn20.createStatement();
                    ResultSet rs20 = st20.executeQuery(query20);
                    while (rs20.next())
                    {
                        String username20 = rs20.getString("username");
                        String password20 = rs20.getString("password");  
                        if( username20.equals(username))
                            flag20=1;
                               
                    }
                }
                 
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
                if( flag20 == 0)
                {
                    flag10=1;
    
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    PreparedStatement pstmt1 = null;
        
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        conn= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
                        pstmt= conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
                        pstmt1= conn.prepareStatement("insert into user values(?,?)");
                        pstmt1.setString(1,value1);
                        pstmt1.setString(2,value2);
                        pstmt.setString(1,value1);
                        pstmt.setString(2,value2);
                        pstmt.setString(3,value3);
                        pstmt.setString(4,value4);
                        pstmt.setString(5,value5);
                        pstmt.setString(6,value6);
                        pstmt.setString(7,value7);
                        pstmt.setString(8,value8);
                        pstmt.setString(9,value9);
                        int i=pstmt.executeUpdate();
                        int j=pstmt1.executeUpdate();
                        if(i>0 && j>0)
                        {
                            JOptionPane.showMessageDialog(null,"data saved");         
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"data not saved");
                        }
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e);
                    }
    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Username already exits");
                }     
            }
        }
        else
        {   
            String value1=null,value2=null;
            JTextField field1 = new JTextField();
            JPasswordField field2 = new JPasswordField();     
            Object[] message = {
            "User Name", field1,"Password", field2};
             int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
             if (option == JOptionPane.OK_OPTION)
             {
                value1 = field1.getText();
                value2 = String.valueOf(field2.getPassword());
                username=value1;
             }
             
             try
             {
                 int flag5=0,flag15=0;
                 Connection conn5=null;
                 Class.forName("com.mysql.jdbc.Driver");
                 conn5= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
                 String query5 = "SELECT * FROM customer" ;
                 Statement st5 = conn5.createStatement();
                 ResultSet rs5 = st5.executeQuery(query5);
                 while (rs5.next())
                 {
                
                    String username1 = rs5.getString("username");
                    String password1 = rs5.getString("password");
                    String v1 = rs5.getString("first_name");
                    String v3 = rs5.getString("last_name");
                    String v4 = rs5.getString("address");
                    String v5 = rs5.getString("city");
                    String v6 = rs5.getString("zip_code");
                    String v7 = rs5.getString("mobile");
                    String v8 = rs5.getString("email");
                    

                    if( value1.equals(username1) && password1.equals(value2))
                    {  
			JOptionPane.showMessageDialog ( null, "Logged in as "+username);
			flag5=1;
                        flag10=1;
                    }
                    if( value1.equals(username1) && !password1.equals(value2) )
                    {
			JOptionPane.showMessageDialog ( null, "Wrong password");
                        flag15=1;
                    }	               

                               
                 }
                 if(flag5 ==0 && flag15 ==0 )
                 {
                    JOptionPane.showMessageDialog ( null, "Incorrect Username");
                 }    
             }
             catch(Exception e)
             {
                JOptionPane.showMessageDialog(null,e);
             }
             
        }
             
    }         
    try
    {    
        int y=1;    
        while(y==1)    
        {
            String t = JOptionPane.showInputDialog("What is your wish for today\n1.Mobile \n2.Tab \n3.Camera\n4.Hard Disk\n5.PenDrive \n6.Memory Card\n7.Printer \n8.Laptop \n9.Mouse \n10.KeyBoard \n11.Speaker ");
            wish = Integer.parseInt(t);
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
            
            String query = "SELECT * FROM electronic_item where Type_no = "+wish  ;
            Statement st = conn.createStatement();
      
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
      
            // iterate through the java resultset
            while (rs.next())
            {
                int item_no = rs.getInt("Item_no");
                String item_name = rs.getString("Item_name");
                String company = rs.getString("Company");
                int no_of_items = rs.getInt("No_of_items");
                int price = rs.getInt("Price");
                String q = rs.getString("Type");
                
                String o = "Item Number is "+item_no+"\n"+"Item Name is "+item_name+"\n"+"Company is "+company+"\n"+"Price is "+price;
                JOptionPane.showMessageDialog ( null, o);
                
            }
            if(JOptionPane.showConfirmDialog(null,"Do You Want To See More Items","Continue To Browse",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            {
                y=1;
            }
            else 
            {
                y=0;
            }
            
            st.close();
            
        }
        int c=1;
        while( c==1)
        {
            String test = JOptionPane.showInputDialog("Enter the item number ");
            input = Integer.parseInt(test);   
            String number= JOptionPane.showInputDialog("Enter the number of items ");
            int n = Integer.parseInt(number);
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
            String query = "SELECT * FROM electronic_item where Item_no = "+input  ;            
            Statement st = conn.createStatement();
      
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
      
            // iterate through the java resultset
            while (rs.next())
            {
                int item_no = rs.getInt("Item_no");
                String item_name = rs.getString("Item_name");
                String company = rs.getString("Company");
                int no_of_items = rs.getInt("No_of_items");
                int price = rs.getInt("Price");
                String q = rs.getString("Type");
    
                bill= bill + price*n;
                JOptionPane.showMessageDialog ( null,"You have bought "+item_name );
                
                try
                {
                    Connection conn40=null;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn40= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");       
                    String query40 = "UPDATE electronic_item set No_of_items= No_of_items-"+n+" where Item_no = "+input;
                    Statement st40 = conn40.createStatement();
                    st40.executeUpdate(query40);
                }   
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,e);
                }
                
                Connection conn2 = null;
                PreparedStatement pstmt2 = null;
                
                Class.forName("com.mysql.jdbc.Driver");
                conn2= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
                pstmt2= conn.prepareStatement("insert into shopping_basket values(?,?,?,?)");
                
                pstmt2.setString(1,username);
                pstmt2.setInt(2,item_no);
                pstmt2.setInt(3,price);
                pstmt2.setInt(4,n);
                
                int p=pstmt2.executeUpdate();
                if(p>0)
                {
                    JOptionPane.showMessageDialog(null,"data saved");         
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"data not saved");
                }
                
            }            
            if(JOptionPane.showConfirmDialog(null,"Do You Want To Continue Your Shopping ","WANT MORE",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            {
                c=1;
            }
            else 
            {
                c=0;
            }
            st.close();
            }
            
            JOptionPane.showMessageDialog ( null,"Total Amount to be paid is "+bill);
            
            int check=0;
            
             while(check !=1)           
            {           
                String test1= JOptionPane.showInputDialog("Enter the payment option \n1.Debit card\n2.Cash on Delivery");
                int int1 = Integer.parseInt(test1);

                if( int1==2){
                // new NewJFrame().setVisible(true);
                check=1;
                }
            
                if( int1==1){
                    String t1= JOptionPane.showInputDialog("Enter the card number");
                    int i1 = Integer.parseInt(t1);
                
                    JPasswordField f = new JPasswordField();
                    Object[] message = { "Password", f };
                    String i2 = null;

                    int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION)
                    {
                        i2 = String.valueOf(f.getPassword());
                    }

                    Connection conn1 = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    conn1= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
            
                    String query = "SELECT * FROM card_details where card_number = "+i1  ;
                    Statement st = conn1.createStatement();
      
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery(query);
      
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        String card_username= rs.getString("card_username");
                        int card_number = rs.getInt("card_number");
                        String card_type = rs.getString("card_type");
                        String card_password = rs.getString("card_password");
                        String expiry_date = rs.getString("expiry_date");
                        int amount = rs.getInt("amount");
                
                        if( !card_password.equals(i2))
                        {
                            JOptionPane.showMessageDialog ( null,"Wrong Password");
                        }
                        else if( amount < bill)
                        {
                            JOptionPane.showMessageDialog ( null,"Not enough balance");
                        }
                        else
                        {
                            check=1;
                            JOptionPane.showMessageDialog ( null,"Transition Complete");
                            
                            try
                            {
                                Connection conn30=null;
                                Class.forName("com.mysql.jdbc.Driver");
                                conn30= DriverManager.getConnection("jdbc:mysql:///electronic_item","root","123456789");
                                int la=amount-bill;
                                
                                String query30 = "UPDATE card_details set amount= amount-"+bill+" where card_number= "+i1;
                                Statement st30 = conn30.createStatement();
                                st30.executeUpdate(query30);
                            }
                            catch(Exception e)
                            {
                                JOptionPane.showMessageDialog(null,e);
                            }
                            
                            
                            // new NewJFrame().setVisible(true);
                        }
               
                    }
                }
            }
           
            JOptionPane.showMessageDialog ( null,"Thank You For Shopping \n Visit Again");
            
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
}
         
         
         
         
  


