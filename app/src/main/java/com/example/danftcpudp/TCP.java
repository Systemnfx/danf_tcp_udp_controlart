package com.example.danftcpudp;


import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "TCP";
    private final String serverIp;
    private final int serverPort;
    private final String messageToSend;

    public static String receivedMessage;


    public TCP(String serverIp, int serverPort, String messageToSend, String receivedMessage) {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.messageToSend = messageToSend;
        this.receivedMessage= receivedMessage;


    }

    @Override
    public Void doInBackground(Void... voids) {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            // Cria um socket e se conecta ao servidor
            socket = new Socket(serverIp, serverPort);

            // Cria o fluxo de saída para enviar dados para o servidor
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(messageToSend); // Envia a mensagem para o servidor

            // Cria o fluxo de entrada para receber dados do servidor
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            receivedMessage = in.readLine(); // Lê a mensagem recebida do servidor
            Log.d(TAG, "Mensagem recebida: " + receivedMessage);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Fecha os fluxos e o socket
                if (out != null) out.close();
                if (in != null) in.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        // Você pode tratar o resultado aqui, se necessário
        super.onPostExecute(aVoid);
    }
}

