package com.example.danftcpudp;

import static android.content.ContentValues.TAG;
import static com.example.danftcpudp.TCP.receivedMessage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iluminacao8 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    String valorC501 = " ";
    String valorC801 = " ";
    String valorC202 = " ";
    String valorC302 = " ";
    String valorC402 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor
    private ImageButton btn_voltar_ambiente8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao8);
        new DHCP().execute();

        btn_voltar_ambiente8 = findViewById(R.id.btn_27);//evento botao voltar
        btn_voltar_ambiente8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar_ambiente8();
            }
        });

        handler = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {
                String messageToSend = "<SA>";
                TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
                tcpClient.execute();

                Log.d(TAG, "Mensagem recebida IP INICIO: " + receivedMessage);
                Pattern padrao = Pattern.compile("<01C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><02C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><03C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><04C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><05C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)>");
                if (receivedMessage != null) {
                    Matcher Mpadrao = padrao.matcher(receivedMessage);
                    if (Mpadrao.find()) {

                        valorC501 = Mpadrao.group(5);
                        valorC801 = Mpadrao.group(8);
                        valorC202 = Mpadrao.group(10);
                        valorC302 = Mpadrao.group(11);
                        valorC402 = Mpadrao.group(12);
                        ImageView imgC501 = findViewById(R.id.FEED_ON_C501);
                        ImageView imgC801 = findViewById(R.id.FEED_ON_C801);
                        ImageView imgC202 = findViewById(R.id.FEED_ON_C202);
                        ImageView imgC302 = findViewById(R.id.FEED_ON_C302);
                        ImageView imgC402 = findViewById(R.id.FEED_ON_C402);

                        if (valorC501.equals("L")) {
                            imgC501.setVisibility(View.VISIBLE);
                        } else if (valorC501.equals("D")) {
                            imgC501.setVisibility(View.INVISIBLE);
                        }
                        if (valorC801.equals("L")) {
                            imgC801.setVisibility(View.VISIBLE);
                        } else if (valorC801.equals("D")) {
                            imgC801.setVisibility(View.INVISIBLE);
                        }
                        if (valorC202.equals("L")) {
                            imgC202.setVisibility(View.VISIBLE);
                        } else if (valorC202.equals("D")) {
                            imgC202.setVisibility(View.INVISIBLE);
                        }
                        if (valorC302.equals("L")) {
                            imgC302.setVisibility(View.VISIBLE);
                        } else if (valorC302.equals("D")) {
                            imgC302.setVisibility(View.INVISIBLE);
                        }
                        if (valorC402.equals("L")) {
                            imgC402.setVisibility(View.VISIBLE);
                        } else if (valorC402.equals("D")) {
                            imgC402.setVisibility(View.INVISIBLE);
                        }

                    }
                }

                int delayMillis = 500;
                handler.postDelayed(this, delayMillis);
            }
        };

        handler.postDelayed(runnable, 0);
    }

    public static void receiveIP(String ipAddress) {
        System.out.println("Received IP address: " + ipAddress);
        IPfinal = ipAddress;

        if (SERVER_IP == null || SERVER_IP.equals(IP1)) {
            SERVER_IP = IPfinal;
            Log.d("MainActivity", "Server IP: " + SERVER_IP);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
    public void voltar_ambiente8(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, Inicio2.class);
        startActivity(intent);
        finish();
    }
    public void OFONC501(View v){
        String messageToSend = "<OFONC501>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC501(View v){
        String messageToSend = "<OFFFC501>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC801(View v){
        String messageToSend = "<OFONC801>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC801(View v){
        String messageToSend = "<OFFFC801>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC202(View v){
        String messageToSend = "<OFONC202>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC202(View v){
        String messageToSend = "<OFFFC202>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC302(View v){
        String messageToSend = "<OFONC302>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC302(View v){
        String messageToSend = "<OFFFC302>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }

    public void OFONC402(View v){
        String messageToSend = "<OFONC402>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC402(View v){
        String messageToSend = "<OFFFC402>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }

}
