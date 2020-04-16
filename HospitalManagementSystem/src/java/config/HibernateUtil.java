/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import org.hibernate.SessionFactory; 
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
import org.hibernate.cfg.Configuration; 
import org.hibernate.service.ServiceRegistry; 
 

/**
 *
 * @author admin
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory; 
    private static ServiceRegistry serviceRegistry; 
    static { 
        try { 
            // Create the SessionFactory from standard (hibernate.cfg.xml)  
            // config file. 
            Configuration configuration = new  Configuration().configure("/config/hibernate.cfg.xml"); 
            serviceRegistry = new StandardServiceRegistryBuilder() .applySettings(configuration.getProperties()).build(); 
 
            // builds a session factory from the service registry 
            sessionFactory =  configuration.buildSessionFactory(serviceRegistry); 
 
            } catch (Throwable ex) { 
                // Log the exception.  
                System.err.println("Initial SessionFactory creation failed." + ex); 
                throw new ExceptionInInitializerError(ex); } 
        }       
        public static SessionFactory getSessionFactory() 
        {           
            return sessionFactory;      
        } 
 
        public static void closeSessionFactory() {           
            if (serviceRegistry != null) {               
                StandardServiceRegistryBuilder.destroy(serviceRegistry);           
            }      
        } 
}
