/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbank;
import bbank.Donor.DeliveryManDirectory;
import bbank.UserAccount.UserAccountDirectory;
/**
 *
 */
public class Bbank {
    private static Bbank business;
       
     private DeliveryManDirectory deliveryDirectory;

    public static Bbank getBusiness() {
        return business;
    }

    public static void setBusiness(Bbank business) {
        Bbank.business = business;
    }

    public static Bbank getInstance() {
        if (business == null) {
            business = new Bbank();
        }
        return business;
    }

    public Bbank() {
             
        deliveryDirectory=new DeliveryManDirectory();
        
    }

    public DeliveryManDirectory getDeliveryDirectory() {
        return deliveryDirectory;
    }

    public void setDeliveryDirectory(DeliveryManDirectory deliveryDirectory) {
        this.deliveryDirectory = deliveryDirectory;
    }
    
}
