/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8_nic_multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class MulticastServer {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket();
            int i = 0;
            while(true)
            {
                String send = "message " + i;
                byte[] sendData = send.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length
                        ,InetAddress.getByName("224.2.2.3"), 1107);

                server.send(sendPacket);
                Thread.sleep(3000);
                i++;
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MulticastServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
