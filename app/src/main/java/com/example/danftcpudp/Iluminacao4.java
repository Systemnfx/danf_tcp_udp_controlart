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

public class Iluminacao4 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    String valorC404 = " ";
    String valorC605 = " ";
    String valorC705 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor
    private ImageButton btn_voltar_ambiente4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao4);
        new DHCP().execute();

        btn_voltar_ambiente4 = (ImageButton) findViewById(R.id.btn_voltar4);//evento botao voltar
        btn_voltar_ambiente4.setOnClickListener(new View.OnClickListener() {
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

                        valorC404 = Mpadrao.group(28);
                        valorC605 = Mpadrao.group(38);
                        valorC705 = Mpadrao.group(39);


                        ImageView imgC404 = findViewById(R.id.FEED_ON_C404);
                        ImageView imgC605 = findViewById(R.id.FEED_ON_C605);
                        ImageView imgC705 = findViewById(R.id.FEED_ON_C705);



                        if (valorC404.equals("L")) {
                            imgC404.setVisibility(View.VISIBLE);
                        } else if (valorC404.equals("D")) {
                            imgC404.setVisibility(View.INVISIBLE);
                        }
                        if (valorC605.equals("L")) {
                            imgC605.setVisibility(View.VISIBLE);
                        } else if (valorC605.equals("D")) {
                            imgC605.setVisibility(View.INVISIBLE);
                        }
                        if (valorC705.equals("L")) {
                            imgC705.setVisibility(View.VISIBLE);
                        } else if (valorC705.equals("D")) {
                            imgC705.setVisibility(View.INVISIBLE);
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
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
        finish();
    }
    public void OFONC404(View v){
        String messageToSend = "<OFONC404>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC404(View v){
        String messageToSend = "<OFFFC404>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC605(View v){
        String messageToSend = "<OFONC605>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC605(View v){
        String messageToSend = "<OFFFC605>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC705(View v){
        String messageToSend = "<OFFFC705>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }

    public void OFONC705(View v){
        String messageToSend = "<OFONC705>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }


}
