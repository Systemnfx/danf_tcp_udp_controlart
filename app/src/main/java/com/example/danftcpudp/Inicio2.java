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

public class Inicio2 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private ImageButton btn_próximo3;
    private ImageButton btn_iluminação5;
    private ImageButton btn_iluminação6;
    private ImageButton btn_iluminação7;
    private ImageButton btn_iluminação8;
    private ImageButton btn_próximo2;

    String valorFeedC502 = " ";
    String valorFeedC602 = " ";
    String valorFeedC702 = " ";
    String valorFeedC701 = " ";
    String valorFeedC101 = " ";
    String valorFeedC201 = " ";
    String valorFeedC501 = " ";
    String valorFeedC801 = " ";
    String valorFeedC202 = " ";
    String valorFeedC302 = " ";
    String valorFeedC402 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);
        new DHCP().execute();

        btn_próximo3    = findViewById(R.id.btn_proximo3);
        btn_próximo2    = findViewById(R.id.btn_proximo2);
        btn_iluminação5 = findViewById(R.id.btn_iluminação_teste5);
        btn_iluminação6 = findViewById(R.id.btn_iluminação_teste6);
        btn_iluminação7 = findViewById(R.id.btn_iluminação_teste7);
        btn_iluminação8 = findViewById(R.id.btn_iluminação_teste8);

        btn_próximo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltarambiente3();
            }
        });
        btn_próximo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltarambiente2();
            }
        });
        btn_iluminação5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambiente5();
            }
        });
        btn_iluminação6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambiente6();
            }
        });
        btn_iluminação7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambiente7();
            }
        });
        btn_iluminação8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambiente8();
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

                        valorFeedC502 = Mpadrao.group(13);
                        valorFeedC602 = Mpadrao.group(14);
                        valorFeedC702 = Mpadrao.group(15);
                        valorFeedC701 = Mpadrao.group(7);
                        valorFeedC101 = Mpadrao.group(1);
                        valorFeedC201 = Mpadrao.group(2);
                        valorFeedC501 = Mpadrao.group(5);
                        valorFeedC801 = Mpadrao.group(8);
                        valorFeedC202 = Mpadrao.group(10);
                        valorFeedC302 = Mpadrao.group(11);
                        valorFeedC402 = Mpadrao.group(12);

                        ImageView imgC502 = findViewById(R.id.imageView15);
                        ImageView imgC602 = findViewById(R.id.imageView16);
                        ImageView imgC702 = findViewById(R.id.imageView17);
                        ImageView imgC701 = findViewById(R.id.imageView18);
                        ImageView imgC101 = findViewById(R.id.imageView19);
                        ImageView imgC201 = findViewById(R.id.imageView20);
                        ImageView imgC501 = findViewById(R.id.imageView21);
                        ImageView imgC801 = findViewById(R.id.imageView22);
                        ImageView imgC202 = findViewById(R.id.imageView23);
                        ImageView imgC302 = findViewById(R.id.imageView24);
                        ImageView imgC402 = findViewById(R.id.imageView25);



                        if (valorFeedC502.equals("L")) {
                            imgC502.setVisibility(View.VISIBLE);
                        } else if (valorFeedC502.equals("D")) {
                            imgC502.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC602.equals("L")) {
                            imgC602.setVisibility(View.VISIBLE);
                        } else if (valorFeedC602.equals("D")) {
                            imgC602.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC702.equals("L")) {
                            imgC702.setVisibility(View.VISIBLE);
                        } else if (valorFeedC702.equals("D")) {
                            imgC702.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC701.equals("L")) {
                            imgC701.setVisibility(View.VISIBLE);
                        } else if (valorFeedC701.equals("D")) {
                            imgC701.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC101.equals("L")) {
                            imgC101.setVisibility(View.VISIBLE);
                        } else if (valorFeedC101.equals("D")) {
                            imgC101.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC201.equals("L")) {
                            imgC201.setVisibility(View.VISIBLE);
                        } else if (valorFeedC201.equals("D")) {
                            imgC201.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC501.equals("L")) {
                            imgC501.setVisibility(View.VISIBLE);
                        } else if (valorFeedC501.equals("D")) {
                            imgC501.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC801.equals("L")) {
                            imgC801.setVisibility(View.VISIBLE);
                        } else if (valorFeedC801.equals("D")) {
                            imgC801.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC202.equals("L")) {
                            imgC202.setVisibility(View.VISIBLE);
                        } else if (valorFeedC202.equals("D")) {
                            imgC202.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC302.equals("L")) {
                            imgC302.setVisibility(View.VISIBLE);
                        } else if (valorFeedC302.equals("D")) {
                            imgC302.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC402.equals("L")) {
                            imgC402.setVisibility(View.VISIBLE);
                        } else if (valorFeedC402.equals("D")) {
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

    public void voltarambiente2() {
      //volta para o INICIO
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
        finish();
    }
    public void voltarambiente3() {
        // abre Inicio 3
        Intent intent = new Intent(this, Inicio3.class);
        startActivity(intent);
        finish();
    }
    public void ambiente5() {

        Intent intent = new Intent(this, Iluminacao5.class);
        startActivity(intent);
        finish();
    }
    public void ambiente6() {

        Intent intent = new Intent(this, Iluminacao6.class);
        startActivity(intent);
        finish();
    }
    public void ambiente7() {

        Intent intent = new Intent(this, Iluminacao7.class);
        startActivity(intent);
        finish();
    }
    public void ambiente8() {

        Intent intent = new Intent(this, Iluminacao8.class);
        startActivity(intent);
        finish();
    }



}
