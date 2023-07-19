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

public class Iluminacao5 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    String valorC502 = " ";
    String valorC602 = " ";
    String valorC702 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor
    private ImageButton btn_voltar_ambiente5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao5);
        new DHCP().execute();

        btn_voltar_ambiente5 = (ImageButton) findViewById(R.id.btn_voltar_15);//evento botao voltar
        btn_voltar_ambiente5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar_ambiente4();
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

                        valorC502 = Mpadrao.group(13);
                        valorC602 = Mpadrao.group(14);
                        valorC702 = Mpadrao.group(15);


                        ImageView imgC502 = findViewById(R.id.FEED_ON_C502);
                        ImageView imgC602 = findViewById(R.id.FEED_ON_C602);
                        ImageView imgC702 = findViewById(R.id.FEED_ON_C702);



                        if (valorC502.equals("L")) {
                            imgC502.setVisibility(View.VISIBLE);
                        } else if (valorC502.equals("D")) {
                            imgC502.setVisibility(View.INVISIBLE);
                        }
                        if (valorC602.equals("L")) {
                            imgC602.setVisibility(View.VISIBLE);
                        } else if (valorC602.equals("D")) {
                            imgC602.setVisibility(View.INVISIBLE);
                        }
                        if (valorC702.equals("L")) {
                            imgC702.setVisibility(View.VISIBLE);
                        } else if (valorC702.equals("D")) {
                            imgC702.setVisibility(View.INVISIBLE);
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
    public void voltar_ambiente4(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, Inicio2.class);
        startActivity(intent);
        finish();
    }
    public void OFONC502(View v){
        String messageToSend = "<OFONC502>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC502(View v){
        String messageToSend = "<OFFFC502>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }

    public void OFONC602(View v){
        String messageToSend = "<OFONC602>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();

    }
    public void OFFFC602(View v){
        String messageToSend = "<OFFFC602>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }

    public void OFONC702(View v){
        String messageToSend = "<OFONC702>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC702(View v){
        String messageToSend = "<OFFFC702>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }


}
