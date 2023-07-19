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

public class Iluminacao3 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    String valorC802 = " ";
    String valorC103 = " ";
    String valorC805 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor
    private ImageButton btn_voltar_ambiente3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacao3);
        new DHCP().execute();

        btn_voltar_ambiente3 = (ImageButton) findViewById(R.id.btn_voltar3);//evento botao voltar
        btn_voltar_ambiente3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar_ambiente3();
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

                        valorC802 = Mpadrao.group(16);
                        valorC103 = Mpadrao.group(17);
                        valorC805 = Mpadrao.group(40);


                        ImageView imgC802 = findViewById(R.id.FEED_ON_C802);
                        ImageView imgC103 = findViewById(R.id.FEED_ON_C103);
                        ImageView imgC805 = findViewById(R.id.FEED_ON_C805);



                        if (valorC802.equals("L")) {
                            imgC802.setVisibility(View.VISIBLE);
                        } else if (valorC802.equals("D")) {
                            imgC802.setVisibility(View.INVISIBLE);
                        }
                        if (valorC103.equals("L")) {
                            imgC103.setVisibility(View.VISIBLE);
                        } else if (valorC103.equals("D")) {
                            imgC103.setVisibility(View.INVISIBLE);
                        }
                        if (valorC805.equals("L")) {
                            imgC805.setVisibility(View.VISIBLE);
                        } else if (valorC805.equals("D")) {
                            imgC805.setVisibility(View.INVISIBLE);
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
    public void voltar_ambiente3(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
        finish();
    }
    public void OFONC802(View v){
        String messageToSend = "<OFONC802>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC802(View v){
        String messageToSend = "<OFFFC802>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC103(View v){
        String messageToSend = "<OFONC103>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC103(View v){
        String messageToSend = "<OFFFC103>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFFFC805(View v){
        String messageToSend = "<OFFFC805>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }
    public void OFONC805(View v){
        String messageToSend = "<OFONC805>";
        TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
        tcpClient.execute();
    }


}
