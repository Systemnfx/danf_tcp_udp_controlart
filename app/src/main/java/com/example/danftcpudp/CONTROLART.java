package com.example.danftcpudp;

import static com.example.danftcpudp.TCP.receivedMessage;

public class CONTROLART {
    private static final String SERVER_IP = "danfescritorio.dyndns.org"; // Insira o endereço IP do servidor
    private static final int SERVER_PORT = 4997; // Insira a porta do servidor



    public static void SOM_ON() {

        String messageToSend = "sendir,1:2,1,38000,1,1,340,170,20,21,20,64,20,21,20,21,20,65,20,22,20,65,20,65,20,65,20,22,20,65,20,65,20,21,20,65,20,65,20,22,20,22,20,22,20,65,20,21,20,22,20,22,20,22,20,22,20,65,20,65,20,22,20,64,20,65,20,65,20,65,20,65,20,1470,340,86,20,3644,340,86,20,3644,340,86,20,2000";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend,receivedMessage);
        tcpClient.execute();
    }
    public static void SOM_OFF() {

        String messageToSend = "sendir,1:2,1,38000,1,1,342,172,20,22,20,65,20,22,20,22,20,65,20,22,20,65,20,65,20,22,20,22,20,65,20,65,20,22,20,65,20,65,20,22,20,65,20,65,20,65,20,22,20,22,20,22,20,65,20,22,20,22,20,22,20,22,20,65,20,65,20,65,20,22,20,65,20,14563,342,172,20,22,20,65,20,22,20,22,20,65,20,22,20,65,20,65,20,22,20,22,20,65,20,65,20,22,20,65,20,65,20,22,20,65,20,65,20,65,20,22,20,22,20,22,20,65,20,22,20,22,20,22,20,22,20,65,20,65,20,65,20,22,20,65,20,2000";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend,receivedMessage);
        tcpClient.execute();
    }
}

