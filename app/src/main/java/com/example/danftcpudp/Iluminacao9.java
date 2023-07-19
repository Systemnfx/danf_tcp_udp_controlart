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

public class Iluminacao9 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    String valorC303 = " ";
    String valorC403 = " ";
    String valorC503 = " ";
    String valorC603 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor
    private ImageButton btn_voltar_ambiente9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao9);
        new DHCP().execute();

        btn_voltar_ambiente9 = findViewById(R.id.btn_28);//evento botao voltar
        btn_voltar_ambiente9.setOnClickListener(new View.OnClickListener() {
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

                        valorC303 = Mpadrao.group(19);
                        valorC403 = Mpadrao.group(20);
                        valorC503 = Mpadrao.group(21);
                        valorC603 = Mpadrao.group(22);

                        ImageView imgC303 = findViewById(R.id.FEED_ON_C303);
                        ImageView imgC403 = findViewById(R.id.FEED_ON_C403);
                        ImageView imgC503  = findViewById(R.id.FEED_ON_C503);
                        ImageView imgC603 = findViewById(R.id.FEED_ON_C603);


                        if (valorC303.equals("L")) {
                            imgC303.setVisibility(View.VISIBLE);
                        } else if (valorC303.equals("D")) {
                            imgC303.setVisibility(View.INVISIBLE);
                        }
                        if (valorC403.equals("L")) {
                            imgC403.setVisibility(View.VISIBLE);
                        } else if (valorC403.equals("D")) {
                            imgC403.setVisibility(View.INVISIBLE);
                        }
                        if (valorC503.equals("L")) {
                            imgC503.setVisibility(View.VISIBLE);
                        } else if (valorC503.equals("D")) {
                            imgC503.setVisibility(View.INVISIBLE);
                        }
                        if (valorC603.equals("L")) {
                            imgC603.setVisibility(View.VISIBLE);
                        } else if (valorC603.equals("D")) {
                            imgC603.setVisibility(View.INVISIBLE);
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
        Intent intent = new Intent(this, Inicio3.class);
        startActivity(intent);
        finish();
    }
    public void OFONC303(View v){
        String messageToSend = "<OFONC303>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC303(View v){
        String messageToSend = "<OFFFC303>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC403(View v){
        String messageToSend = "<OFONC403>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC403(View v){
        String messageToSend = "<OFFFC403>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC503(View v){
        String messageToSend = "<OFONC503>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC503(View v){
        String messageToSend = "<OFFFC503>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC603(View v){
        String messageToSend = "<OFONC603>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC603(View v){
        String messageToSend = "<OFFFC603>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
}
