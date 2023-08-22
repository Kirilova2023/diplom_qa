package ru.netology.DBWrapper;

import org.junit.jupiter.api.Order;
import ru.netology.Models.CreditEntity;
import ru.netology.Models.OrderEntity;
import ru.netology.Models.PaymentEntity;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBAdapter {
    private Connection conn;
     public DBAdapter() throws SQLException {
         String url = System.getProperty("db.url");
         String user = System.getProperty("db.user");
         String pass  = System.getProperty("db.pass");
         conn = DriverManager.getConnection(url,user,pass);
     }

     //Очистка перед выполнением теста
     public void CleanUp() throws SQLException {
         Statement statement = conn.createStatement();

         statement.executeUpdate("DELETE FROM payment_entity;");
         statement.executeUpdate("DELETE FROM credit_request_entity;");
         statement.executeUpdate("DELETE FROM order_entity;");

     }

     public PaymentEntity GetPaymentEntity() throws SQLException{
         Statement statement = conn.createStatement();

         ResultSet res = statement.executeQuery("SELECT * FROM payment_entity;");
         if(res.next()) {
             PaymentEntity ent = new PaymentEntity();
             ent.id = res.getString("id");
             ent.amount = res.getDouble("amount");
             ent.created = res.getDate("created");
             ent.status = res.getString("status");
             ent.transaction_id = res.getString("transaction_id");

             return ent;
         }
         return null;
     }

     public CreditEntity GetCreditEntity() throws SQLException {
         Statement statement = conn.createStatement();

         ResultSet res = statement.executeQuery("SELECT * FROM credit_request_entity;");
         if(res.next()) {
             CreditEntity ent = new CreditEntity();
             ent.id = res.getString("id");
             ent.bank_id = res.getString("bank_id");
             ent.created = res.getDate("created");
             ent.status = res.getString("status");

             return ent;
         }
         return null;
     }

     public OrderEntity GetOrderEntity() throws SQLException {
         Statement statement = conn.createStatement();

         ResultSet res = statement.executeQuery("SELECT * FROM order_entity;");
         if(res.next()) {
             OrderEntity ent = new OrderEntity();
             ent.id = res.getString("id");
             ent.credit_id = res.getString("credit_id");
             ent.created = res.getDate("created");
             ent.payment_id = res.getString("payment_id");

             return ent;
         }
         return null;
     }

}
