package ru.netology.DBWrapper;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Order;
import ru.netology.Models.CreditEntity;
import ru.netology.Models.OrderEntity;
import ru.netology.Models.PaymentEntity;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DBAdapter {

    @SneakyThrows
    private static Connection getConn(){
        return DriverManager.getConnection(System.getProperty("db.url"),System.getProperty("db.user"),System.getProperty("db.pass"));
    }

    @SneakyThrows
     //Очистка перед выполнением теста
     public static void CleanUp()  {
         Statement statement = getConn().createStatement();

         statement.executeUpdate("DELETE FROM payment_entity;");
         statement.executeUpdate("DELETE FROM credit_request_entity;");
         statement.executeUpdate("DELETE FROM order_entity;");

     }

     @SneakyThrows
     public static PaymentEntity GetPaymentEntity() {
         Statement statement = getConn().createStatement();

         ResultSet res = statement.executeQuery("SELECT * FROM payment_entity order by created desc limit 1;");
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

     @SneakyThrows
     public  static CreditEntity GetCreditEntity() {
         Statement statement = getConn().createStatement();

         ResultSet res = statement.executeQuery("SELECT * FROM credit_request_entity order by created desc limit 1;");
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

     @SneakyThrows
     public static OrderEntity GetOrderEntity() {
         Statement statement = getConn().createStatement();

         ResultSet res = statement.executeQuery("SELECT * FROM order_entity ORDER BY created desc limit 1;");
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
