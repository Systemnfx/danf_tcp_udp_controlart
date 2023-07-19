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

public class Inicio3 extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private ImageButton btn_voltar3;
    private ImageButton btn_iluminação9;
    private ImageButton btn_iluminação10;
    private ImageButton btn_iluminação11;

    String valorFeedC303 = " ";
    String valorFeedC403 = " ";
    String valorFeedC503 = " ";
    String valorFeedC603 = " ";
    String valorFeedC703 = " ";
    String valorFeedC803 = " ";
    String valorFeedC104 = " ";
    String valorFeedC204 = " ";
    String valorFeedC304 = " ";
    String valorFeedC504 = " ";
    String valorFeedC604 = " ";
    String valorFeedC704 = " ";
    String valorFeedC804 = " ";
    String valorFeedC105 = " ";
    String valorFeedC205 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio3);
        new DHCP().execute();

        btn_voltar3 = (ImageButton) findViewById(R.id.btn_proximo5);
        btn_iluminação9 = (ImageButton) findViewById(R.id.btn_iluminação_teste9);
        btn_iluminação10 = (ImageButton) findViewById(R.id.btn_iluminação_teste10);
        btn_iluminação11 = (ImageButton) findViewById(R.id.btn_iluminação_teste11);

        btn_voltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltarambiente3();
            }
        });
        btn_iluminação9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambiente9();
            }
        });
        btn_iluminação10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambiente10();
            }
        });
        btn_iluminação11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ambiente11();
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

                        valorFeedC303 = Mpadrao.group(19);
                        valorFeedC403 = Mpadrao.group(20);
                        valorFeedC503 = Mpadrao.group(21);
                        valorFeedC603 = Mpadrao.group(22);
                        valorFeedC703 = Mpadrao.group(23);
                        valorFeedC803 = Mpadrao.group(24);
                        valorFeedC104 = Mpadrao.group(25);
                        valorFeedC204 = Mpadrao.group(26);
                        valorFeedC304 = Mpadrao.group(27);
                        valorFeedC504 = Mpadrao.group(29);
                        valorFeedC604 = Mpadrao.group(30);

                        ImageView imgC303 = findViewById(R.id.imageView26);
                        ImageView imgC403 = findViewById(R.id.imageView27);
                        ImageView imgC503 = findViewById(R.id.imageView28);
                        ImageView imgC603 = findViewById(R.id.imageView29);
                        ImageView imgC703 = findViewById(R.id.imageView30);
                        ImageView imgC803 = findViewById(R.id.imageView31);
                        ImageView imgC104 = findViewById(R.id.imageView32);
                        ImageView imgC204 = findViewById(R.id.imageView34);
                        ImageView imgC304 = findViewById(R.id.imageView35);
                        ImageView imgC504 = findViewById(R.id.imageView42);
                        ImageView imgC604 = findViewById(R.id.imageView37);
                        ImageView imgC704 = findViewById(R.id.imageView38);
                        ImageView imgC804 = findViewById(R.id.imageView39);
                        ImageView imgC105 = findViewById(R.id.imageView40);
                        ImageView imgC205 = findViewById(R.id.imageView41);



                        if (valorFeedC303.equals("L")) {
                            imgC303.setVisibility(View.VISIBLE);
                        } else if (valorFeedC303.equals("D")) {
                            imgC303.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC403.equals("L")) {
                            imgC403.setVisibility(View.VISIBLE);
                        } else if (valorFeedC403.equals("D")) {
                            imgC403.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC503.equals("L")) {
                            imgC503.setVisibility(View.VISIBLE);
                        } else if (valorFeedC503.equals("D")) {
                            imgC503.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC603.equals("L")) {
                            imgC603.setVisibility(View.VISIBLE);
                        } else if (valorFeedC603.equals("D")) {
                            imgC603.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC703.equals("L")) {
                            imgC703.setVisibility(View.VISIBLE);
                        } else if (valorFeedC703.equals("D")) {
                            imgC703.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC803.equals("L")) {
                            imgC803.setVisibility(View.VISIBLE);
                        } else if (valorFeedC803.equals("D")) {
                            imgC803.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC104.equals("L")) {
                            imgC104.setVisibility(View.VISIBLE);
                        } else if (valorFeedC104.equals("D")) {
                            imgC104.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC204.equals("L")) {
                            imgC204.setVisibility(View.VISIBLE);
                        } else if (valorFeedC204.equals("D")) {
                            imgC204.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC304.equals("L")) {
                            imgC304.setVisibility(View.VISIBLE);
                        } else if (valorFeedC304.equals("D")) {
                            imgC304.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC504.equals("L")) {
                            imgC504.setVisibility(View.VISIBLE);
                        } else if (valorFeedC504.equals("D")) {
                            imgC504.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC604.equals("L")) {
                            imgC604.setVisibility(View.VISIBLE);
                        } else if (valorFeedC604.equals("D")) {
                            imgC604.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC704.equals("L")) {
                            imgC704.setVisibility(View.VISIBLE);
                        } else if (valorFeedC704.equals("D")) {
                            imgC704.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC804.equals("L")) {
                            imgC804.setVisibility(View.VISIBLE);
                        } else if (valorFeedC804.equals("D")) {
                            imgC804.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC105.equals("L")) {
                            imgC105.setVisibility(View.VISIBLE);
                        } else if (valorFeedC105.equals("D")) {
                            imgC105.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC205.equals("L")) {
                            imgC205.setVisibility(View.VISIBLE);
                        } else if (valorFeedC205.equals("D")) {
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

    public void voltarambiente3() {
        //voltar MAIN_activity
        Intent intent = new Intent(this, Inicio2.class);
        startActivity(intent);
        finish();
    }
    public void ambiente9() {
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacao9.class);
        startActivity(intent);
        finish();
    }
    public void ambiente10() {
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacao10.class);
        startActivity(intent);
        finish();
    }
    public void ambiente11() {
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacao11.class);
        startActivity(intent);
        finish();
    }



}
