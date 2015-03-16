/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi_server;
import imagermi.Image;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdminMobility
 */
public class JavaRMI_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            
            Image stub = new Image();
            //Image stub = (Image) UnicastRemoteObject.exportObject(robj, 0);
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("toBW", stub);
            System.out.println("Server run ...");
            
        } catch (RemoteException ex) {
            Logger.getLogger(JavaRMI_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
