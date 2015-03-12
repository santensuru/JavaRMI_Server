/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi_server;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author AdminMobility
 */
public class imageClass extends UnicastRemoteObject implements imageInterfaces {

    imageClass()throws RemoteException {
        super();
    }
    @Override
    public BufferedImage toBW(BufferedImage input) throws RemoteException {
        
        int width = input.getWidth();
        int height = input.getHeight();
        
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_GRAY);
        
        int x, y;
        for (y=0; y<height; y++) {
            for (x=0; x<width; x++) {
                Color c = new Color(input.getRGB(x, y));
                int temp = (int)(c.getRed() * 0.299 + c.getGreen() * 0.587 + c.getBlue() * 0.114);
                output.setRGB(x, y, temp << 16 | temp << 8 | temp);
            }
        }
        
        return output;
    }
    
}
