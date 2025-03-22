/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uafs.control;
import edu.uafs.model.Customer;
import edu.uafs.model.UADataAccess;
import edu.uafs.system.UAParms;
import java.util.*;
import java.sql.*;
/**
 *
 * @author mgarcia
 */
public class CustomerDAO implements UADataAccess<Customer>{

    public List<Customer> getAllItemsFromDatabase(){
        
        Connection con = null; 
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null; 
        
        String sql = "SELECT * FROM UABAKERYSYSTEM.CUSTOMERS";
        
        String user = UAParms.getUsername();
        
        String passwd = UAParms.getPassword();
        
        String url   = "jdbc:mariadb://localhost:3306/" + UAParms.getDb();
        
        List<Customer> allCust = new ArrayList<Customer>();
        
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(ClassNotFoundException e){
        
            System.out.println("The driver could not be loaded. Check the jar files.");
            e.printStackTrace();
            return null; 
        }
        
        System.out.println("Database driver is loaded successfully!");
        
        try{
            
            con = DriverManager.getConnection(url,user,passwd);
            pstmt = con.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            if(rset != null){
                
                while(rset.next()){
                    Customer cust = new Customer();
                    
                    cust.setCustFname(rset.getString(2));
                    cust.setCustLname(rset.getString(3));
                    cust.setCustAddr(rset.getString(4));
                    cust.setCustCity(rset.getString(5));
                    cust.setCustState(rset.getString(6));
                    cust.setCustZip(rset.getString(7));
                    cust.setCustPhone(rset.getString(8));
                    cust.setCustEmail(rset.getString(9));
                    cust.setCustUsername(rset.getString(10));
                    cust.setCustPasswd(rset.getString(11));
                    
                    allCust.add(cust);  
                    
                }
            }
            
            
        }catch(SQLException e){
            
            System.out.println("Database Connection Failed");
            e.printStackTrace();
            return null;
        }
        return allCust; 
    }
    
    public Customer getItem(int key){

        return null; 
    }
    
    public void update (Customer item){}
    
    public void delete (Customer item){}
    
    public void insert (Customer item){}
    
}
