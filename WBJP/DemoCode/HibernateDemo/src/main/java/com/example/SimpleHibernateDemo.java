package com.example;

import com.example.entity.User;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SimpleHibernateDemo {
    public static void main(String[] args) {
        System.out.println("Hibernate Simple Demo");
        
        // Create a new user
        User user = new User("john_doe", "password123", "john@example.com", "John Doe");
        
        // Save the user
        Long userId = saveUser(user);
        System.out.println("User saved with ID: " + userId);
        
        // Retrieve the user
        User retrievedUser = getUserById(userId);
        if (retrievedUser != null) {
            System.out.println("Retrieved user: " + retrievedUser);
        }
        
        // Update the user
        retrievedUser.setEmail("john.doe@example.com");
        updateUser(retrievedUser);
        System.out.println("User updated: " + retrievedUser);
        
        // List all users
        System.out.println("All users:");
        listAllUsers();
        
        // Delete the user
        deleteUser(userId);
        System.out.println("User deleted with ID: " + userId);
        
        // Shutdown Hibernate
        HibernateUtil.shutdown();
    }
    
    private static Long saveUser(User user) {
        Session session = null;
        Transaction transaction = null;
        Long userId = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            userId = (Long) session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userId;
    }
    
    private static User getUserById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    private static void updateUser(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    private static void listAllUsers() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            List<User> users = session.createQuery("FROM User", User.class).getResultList();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    private static void deleteUser(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}