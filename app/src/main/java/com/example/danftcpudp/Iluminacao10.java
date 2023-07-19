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

public class Iluminacao10 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private ImageButton btn_voltar_ambiente10;

    String valorC703 = " ";
    String valorC803 = " ";
    String valorC104 = " ";
    String valorC204 = " ";
    String valorC304 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao10);
        new DHCP().execute();

        btn_voltar_ambiente10 = (ImageButton) findViewById(R.id.btn_29);//evento botao voltar
        btn_voltar_ambiente10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar_ambiente10();
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

                        valorC703 = Mpadrao.group(23);
                        valorC803 = Mpadrao.group(24);
                        valorC104 = Mpadrao.group(25);
                        valorC204 = Mpadrao.group(26);
                        valorC304 = Mpadrao.group(27);

                        ImageView imgC703 = findViewById(R.id.FEED_ON_C703);
                        ImageView imgC803 = findViewById(R.id.FEED_ON_C803);
                        ImageView imgC104 = findViewById(R.id.FEED_ON_C104);
                        ImageView imgC204 = findViewById(R.id.FEED_ON_C204);
                        ImageView imgC304 = findViewById(R.id.FEED_ON_C304);



                        if (valorC703.equals("L")) {
                            imgC703.setVisibility(View.VISIBLE);
                        } else if (valorC703.equals("D")) {
                            imgC703.setVisibility(View.INVISIBLE);
                        }
                        if (valorC803.equals("L")) {
                            imgC803.setVisibility(View.VISIBLE);
                        } else if (valorC803.equals("D")) {
                            imgC803.setVisibility(View.INVISIBLE);
                        }
                        if (valorC104.equals("L")) {
                            imgC104.setVisibility(View.VISIBLE);
                        } else if (valorC104.equals("D")) {
                            imgC104.setVisibility(View.INVISIBLE);
                        }
                        if (valorC204.equals("L")) {
                            imgC204.setVisibility(View.VISIBLE);
                        } else if (valorC204.equals("D")) {
                            imgC204.setVisibility(View.INVISIBLE);
                        }
                        if (valorC304.equals("L")) {
                            imgC304.setVisibility(View.VISIBLE);
                        } else if (valorC304.equals("D")) {
                            imgC304.setVisibility(View.INVISIBLE);
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
    public void voltar_ambiente10(){
        //voltar para inicio3
        Intent intent = new Intent(this, Inicio3.class);
        startActivity(intent);
        finish();
    }
    public void OFONC703(View v){
        String messageToSend = "<OFONC703>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC703(View v){
        String messageToSend = "<OFFFC703>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC803(View v){
        String messageToSend = "<OFONC803>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC803(View v){
        String messageToSend = "<OFFFC803>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC104(View v){
        String messageToSend = "<OFONC104>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC104(View v){
        String messageToSend = "<OFFFC104>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC204(View v){
        String messageToSend = "<OFONC204>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC204(View v){
        String messageToSend = "<OFFFC204>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC304(View v){
        String messageToSend = "<OFONC304>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC304(View v){
        String messageToSend = "<OFFFC304>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }



}
