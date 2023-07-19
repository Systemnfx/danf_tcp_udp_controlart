package com.example.danftcpudp;

import static android.content.ContentValues.TAG;
import static com.example.danftcpudp.TCP.receivedMessage;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iluminacao2 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    String valorC301 = " ";
    String valorC401 = " ";
    String valorC305 = " ";
    String valorC405 = " ";
    String valorC505 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor
    private ImageButton btn_voltar_ambiente2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao2);
        new DHCP().execute();

        btn_voltar_ambiente2 = (ImageButton) findViewById(R.id.btn_voltar2);//evento botao voltar
        btn_voltar_ambiente2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar_ambiente2();
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

                        valorC301 = Mpadrao.group(3);
                        valorC401 = Mpadrao.group(4);
                        valorC305 = Mpadrao.group(35);
                        valorC405 = Mpadrao.group(36);
                        valorC505 = Mpadrao.group(37);


                        ImageView imgC301 = findViewById(R.id.FEED_ON_C301);
                        ImageView imgC401 = findViewById(R.id.FEED_ON_C401);
                        ImageView imgC305 = findViewById(R.id.FEED_ON_C305);
                        ImageView imgC405 = findViewById(R.id.FEED_ON_C405);
                        ImageView imgC505 = findViewById(R.id.FEED_ON_C505);


                        if (valorC301.equals("L")) {
                            imgC301.setVisibility(View.VISIBLE);
                        } else if (valorC301.equals("D")) {
                            imgC301.setVisibility(View.INVISIBLE);
                        }
                        if (valorC401.equals("L")) {
                            imgC401.setVisibility(View.VISIBLE);
                        } else if (valorC401.equals("D")) {
                            imgC401.setVisibility(View.INVISIBLE);
                        }
                        if (valorC305.equals("L")) {
                            imgC305.setVisibility(View.VISIBLE);
                        } else if (valorC305.equals("D")) {
                            imgC305.setVisibility(View.INVISIBLE);
                        }
                        if (valorC405.equals("L")) {
                            imgC405.setVisibility(View.VISIBLE);
                        } else if (valorC405.equals("D")) {
                            imgC405.setVisibility(View.INVISIBLE);
                        }
                        if (valorC505.equals("L")) {
                            imgC505.setVisibility(View.VISIBLE);
                        } else if (valorC505.equals("D")) {
                            imgC505.setVisibility(View.INVISIBLE);
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
    public void voltar_ambiente2(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
        finish();
    }
    public void OFONC505(View v){
        String messageToSend = "<OFONC505>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC505(View v){
        String messageToSend = "<OFFFC505>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC405(View v){
        String messageToSend = "<OFONC405>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC405(View v){
        String messageToSend = "<OFFFC405>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC305(View v){
        String messageToSend = "<OFFFC305>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC305(View v){
        String messageToSend = "<OFONC305>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC301(View v){
        String messageToSend = "<OFONC301>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC301(View v){
        String messageToSend = "<OFFFC301>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC401(View v){
        String messageToSend = "<OFFFC401>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }


    public void OFONC401(View v){
        String messageToSend = "<OFONC401>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();

    }



}
