/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import model.Payment;
import model.User;
/**
 *
 * @author shanliu
 */
public class PaymentController {
    
    public Set<User> paymentDueIn30Days(ArrayList<Payment> payments){
        Set<User> users = new HashSet<>();
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, 30);
        Date date = calendar.getTime();

        for(Payment payment: payments){
            if(!payment.isCompleted() && payment.getPaymentDueDate().before(date)){
                users.add(payment.getUser());
            }      
        }
        return users;
    }
    
    public Set<User> paymentPastDue(ArrayList<Payment> payments){
        Set<User> users = new HashSet<>();
        Date today = new Date();
        for(Payment payment: payments){
            if(!payment.isCompleted() && payment.getPaymentDueDate().before(today)){
                users.add(payment.getUser());
        
            }
        }
        return users;
    }
    
    public static void main(String args[]){
        User userA = new User("a","v");
        User userB = new User("b","v");
        User userC = new User("c","v");
        
        Payment test1 = new Payment(userA, (float) 123.2);
        Payment test2 = new Payment(userB, (float) 1332.4);
        Payment test3 = new Payment(userC, (float) 13.4);
        
        test1.setDueDate(15);
        test2.setDueDate(20);
        test3.setDueDate(40);
        
        ArrayList<Payment> payments = new ArrayList<Payment>();
        payments.add(test2);
        payments.add(test1);
        
        PaymentController con = new PaymentController();
        
        
        Set<User> users = con.paymentDueIn30Days(payments);
        System.out.println(users);
        
        users = con.paymentPastDue(payments);
        System.out.println(users);
    }
}
