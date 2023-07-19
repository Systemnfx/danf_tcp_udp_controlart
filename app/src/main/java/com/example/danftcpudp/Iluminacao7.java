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

public class Iluminacao7 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    String valorC101 = " ";
    String valorC201 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor
    private ImageButton btn_voltar_ambiente7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao7);
        new DHCP().execute();

        btn_voltar_ambiente7 = findViewById(R.id.btn_26);//evento botao voltar
        btn_voltar_ambiente7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar_ambiente7();
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

                        valorC101 = Mpadrao.group(1);
                        ImageView imgC101 = findViewById(R.id.FEED_ON_C101);
                        valorC201 = Mpadrao.group(2);
                        ImageView imgC201 = findViewById(R.id.FEED_ON_C201);

                        if (valorC101.equals("L")) {
                            imgC101.setVisibility(View.VISIBLE);
                        } else if (valorC101.equals("D")) {
                            imgC101.setVisibility(View.INVISIBLE);
                        }
                        if (valorC201.equals("L")) {
                            imgC201.setVisibility(View.VISIBLE);
                        } else if (valorC201.equals("D")) {
                            imgC201.setVisibility(View.INVISIBLE);
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
    public void voltar_ambiente7(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, Inicio2.class);
        startActivity(intent);
        finish();
    }
    public void OFONC101(View v){
        String messageToSend = "<OFONC101>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC101(View v){
        String messageToSend = "<OFFFC101>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC201(View v){
        String messageToSend = "<OFONC201>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC201(View v){
        String messageToSend = "<OFFFC201>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }

}
