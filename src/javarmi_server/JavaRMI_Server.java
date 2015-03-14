/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi_server;
import java.net.MalformedURLException;
import java.rmi.*;
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
        ImageInterface stub;
        try {
            stub = new Image();
            Naming.rebind("rmi://10.151.12.201:5000/image", stub);
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(JavaRMI_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
