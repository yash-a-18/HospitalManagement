/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;  

/**
 *
 * @author DC
 */
public class InsertRecords {
    
    public Connection connection;
    public void databaseConnection(){
        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","");
            System.out.println("\nConnection Sucessfull.\n");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void insertRecords(String doc_name, String doc_address, Date doc_dob, int doc_age, String doc_mobileno, int doc_weight, String doc_bloodgrp, int doc_yoe, String doc_speciality, String doc_achievements, String doc_email) 
    {
        databaseConnection();
        PreparedStatement pst=null;
        
        /*Doctor d=new Doctor();
        d.setDob(doc_dob);
        d.setDocAchievements(doc_achievements);
        d.setDocAddress(doc_address);
        d.setDocAge(doc_age);
        d.setDocBloodgrp(doc_bloodgrp);
        d.setDocEmail(doc_email);
        d.setDocMobileno(doc_mobileno);
        d.setDocName(doc_name);
        d.setDocSpeciality(doc_speciality);
        d.setDocWeight(doc_weight);
        d.setDocYoe(doc_yoe);
        
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
                String strDate = formatter.format(doc_dob);   
                System.out.println("Converted String: " + strDate);*/
        
        try{
            pst=connection.prepareStatement("INSERT INTO doctor (doc_name,doc_address,doc_dob,doc_age,doc_mobileno,doc_weight,doc_bloodgrp,doc_yoe,doc_speciality,doc_achievements,doc_email) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,doc_name);
            pst.setString(2,doc_address);
            pst.setDate(3, (java.sql.Date) doc_dob);
            pst.setInt(4,doc_age);
            pst.setString(5,doc_mobileno);
            pst.setInt(6,doc_weight);
            pst.setString(7,doc_bloodgrp);
            pst.setInt(8,doc_yoe);
            pst.setString(9,doc_speciality);
            pst.setString(10,doc_achievements);
            pst.setString(11,doc_email);
            pst.executeQuery();
            
            System.out.println("\nInserted Successfully.\n");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
