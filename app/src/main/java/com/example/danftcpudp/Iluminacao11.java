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

public class Iluminacao11 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private ImageButton btn_voltar_ambiente11;

    String valorC504 = " ";
    String valorC604 = " ";
    String valorC704 = " ";
    String valorC804 = " ";
    String valorC105 = " ";
    String valorC205 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao11);
        new DHCP().execute();

        btn_voltar_ambiente11 = (ImageButton) findViewById(R.id.btn_30);//evento botao voltar
        btn_voltar_ambiente11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar_ambiente11();
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

                        valorC504 = Mpadrao.group(29);
                        valorC604 = Mpadrao.group(30);
                        valorC704 = Mpadrao.group(31);
                        valorC804 = Mpadrao.group(32);
                        valorC105 = Mpadrao.group(33);
                        valorC205 = Mpadrao.group(34);

                        ImageView imgC504 = findViewById(R.id.FEED_ON_C504);
                        ImageView imgC604 = findViewById(R.id.FEED_ON_C604);
                        ImageView imgC704 = findViewById(R.id.FEED_ON_C704);
                        ImageView imgC804 = findViewById(R.id.FEED_ON_C804);
                        ImageView imgC105 = findViewById(R.id.FEED_ON_C105);
                        ImageView imgC205 = findViewById(R.id.FEED_ON_C205);



                        if (valorC504.equals("L")) {
                            imgC504.setVisibility(View.VISIBLE);
                        } else if (valorC504.equals("D")) {
                            imgC504.setVisibility(View.INVISIBLE);
                        }
                        if (valorC604.equals("L")) {
                            imgC604.setVisibility(View.VISIBLE);
                        } else if (valorC604.equals("D")) {
                            imgC604.setVisibility(View.INVISIBLE);
                        }
                        if (valorC704.equals("L")) {
                            imgC704.setVisibility(View.VISIBLE);
                        } else if (valorC704.equals("D")) {
                            imgC704.setVisibility(View.INVISIBLE);
                        }
                        if (valorC804.equals("L")) {
                            imgC804.setVisibility(View.VISIBLE);
                        } else if (valorC804.equals("D")) {
                            imgC804.setVisibility(View.INVISIBLE);
                        }
                        if (valorC105.equals("L")) {
                            imgC105.setVisibility(View.VISIBLE);
                        } else if (valorC105.equals("D")) {
                            imgC105.setVisibility(View.INVISIBLE);
                        }
                        if (valorC205.equals("L")) {
                            imgC205.setVisibility(View.VISIBLE);
                        } else if (valorC205.equals("D")) {
                            imgC205.setVisibility(View.INVISIBLE);
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
    public void voltar_ambiente11(){
        //voltar para inicio3
        Intent intent = new Intent(this, Inicio3.class);
        startActivity(intent);
        finish();
    }
    public void OFONC504(View v){
        String messageToSend = "<OFONC504>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC504(View v){
        String messageToSend = "<OFFFC504>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC604(View v){
        String messageToSend = "<OFONC604>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC604(View v){
        String messageToSend = "<OFFFC604>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC704(View v){
        String messageToSend = "<OFONC704>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC704(View v){
        String messageToSend = "<OFFFC704>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC804(View v){
        String messageToSend = "<OFONC804>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC804(View v){
        String messageToSend = "<OFFFC804>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC105(View v){
        String messageToSend = "<OFONC105>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC105(View v){
        String messageToSend = "<OFFFC105>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC205(View v){
        String messageToSend = "<OFONC205>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC205(View v){
        String messageToSend = "<OFFFC205>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }



}
