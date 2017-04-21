/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author shanliu
 */
public class Payment {
    
    public enum PaymentMethod{
        BANK_PAYMENT, CREDIT_CARD
    }
        
    private User user;
    private Transaction transaction;
    private PaymentMethod method;
    float amountToPay;
    Date PaymentDueDate;
    Date PaymentCreatedDate;
    boolean completed;
    
    public Payment(User u, float amount){
        user = u;
        completed = false;
        amountToPay = amount;
        PaymentCreatedDate = new Date();
    }

    public User getUser(){
        return user;
    }
    
    public Date getPaymentDueDate(){
        return PaymentDueDate;
    }
    
    public boolean setDueDate(int days){
        if(days <= 0) return false;
        
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, days);
        PaymentDueDate = calendar.getTime();
        return true;
    }
    
    public boolean isCompleted(){
        return completed;
    }
    public boolean makePayment(PaymentMethod method, Transaction transaction){
        // already made payment
        if(transaction != null) return false;
        
        if(!transaction.succeed) return false;
        
        return true;
        
    }
    
}
