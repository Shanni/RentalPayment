/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author shanliu
 */
public class Transaction {
    private float amount;
    String from;
    String to;
    boolean succeed;
    Date date;
    
    public Transaction(){
        
    };
    
    public float getAmount(){
        return amount;
    }
    public boolean makeTransaction(String from, String to, float amount){
        // call API to make transaction
        //succeed = succeed making transaction through third party
        return succeed; // return true if transaction succeed
    }

}
