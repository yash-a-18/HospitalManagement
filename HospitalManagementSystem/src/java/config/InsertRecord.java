/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class InsertRecord {
    public void insertRecords(String d_name,String d_address,Date d_dob,int d_age,String d_mobileno,int d_weight,String d_bloodgrp,String d_yoe,String d_speciality,String d_achievements,String d_email)
    { 
        Configuration con=new Configuration().configure().addAnnotatedClass(Doctor.class);
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf=con.buildSessionFactory(reg);
        
        Session session=sf.openSession();
        
        Transaction tx=session.beginTransaction();
        Doctor d=new Doctor();
        d.setDocName(d_name);
        d.setDocAddress(d_address);
        d.setDocDob(d_dob);
        d.setDocAge(d_age);
        d.setDocMobileno(d_mobileno);
        d.setDocWeight(d_weight);
        d.setDocBloodgrp(d_bloodgrp);
        d.setDocYoe(d_yoe);
        d.setDocSpeciality(d_speciality);
        d.setDocAchievements(d_achievements);
        d.setDocEmail(d_email);
        session.save(d);
        tx.commit();
        System.out.println("Record entered");
    } 
    
    
}
