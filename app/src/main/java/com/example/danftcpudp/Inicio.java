package com.example.danftcpudp;

import static android.content.ContentValues.TAG;
import static com.example.danftcpudp.TCP.receivedMessage;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.os.Handler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inicio extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private ImageButton btn_voltar;
    private ImageButton btn_próximo;
    private ImageButton btn_iluminação;

    private ImageButton btn_iluminação2;
    private ImageButton btn_iluminação3;
    private ImageButton btn_iluminação4;
    private ImageButton cenas;

    String valorFeedC601 = " ";
    String valorFeedC203 = " ";
    String valorFeedC301 = " ";
    String valorFeedC401 = " ";
    String valorFeedC305 = " ";
    String valorFeedC405 = " ";
    String valorFeedC505 = " ";
    String valorFeedC802 = " ";
    String valorFeedC103 = " ";
    String valorFeedC805 = " ";
    String valorFeedC404 = " ";
    String valorFeedC605 = " ";
    String valorFeedC705 = " ";
    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP = IP1; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);
        new DHCP().execute();

        btn_voltar = findViewById(R.id.btn_voltar);
        btn_próximo = (ImageButton) findViewById(R.id.btn_proximo);
        btn_iluminação = (ImageButton) findViewById(R.id.btn_iluminação_teste);
        btn_iluminação2 = (ImageButton) findViewById(R.id.btn_iluminação_teste2);
        btn_iluminação3 = (ImageButton) findViewById(R.id.btn_iluminação_teste3);
        btn_iluminação4 = (ImageButton) findViewById(R.id.btn_iluminação_teste4);
        cenas = (ImageButton) findViewById(R.id.cenas);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                voltar();
            }
        });

        btn_próximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                proximo();
            }
        });
        btn_iluminação.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iluminação();
            }
        });
        btn_iluminação2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iluminação2();
            }
        });
        btn_iluminação3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iluminação3();
            }
        });
        btn_iluminação4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iluminação4();
            }
        });
        cenas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cenas_entrar();
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

                        valorFeedC301 = Mpadrao.group(3);
                        valorFeedC401 = Mpadrao.group(4);
                        valorFeedC601 = Mpadrao.group(6);
                        valorFeedC802 = Mpadrao.group(16);
                        valorFeedC103 = Mpadrao.group(17);
                        valorFeedC203 = Mpadrao.group(18);
                        valorFeedC404 = Mpadrao.group(28);
                        valorFeedC305 = Mpadrao.group(35);
                        valorFeedC405 = Mpadrao.group(36);
                        valorFeedC505 = Mpadrao.group(37);
                        valorFeedC605 = Mpadrao.group(38);
                        valorFeedC705 = Mpadrao.group(39);
                        valorFeedC805 = Mpadrao.group(40);
                        ImageView imgC601 = findViewById(R.id.imageView1);
                        ImageView imgC203 = findViewById(R.id.imageView2);
                        ImageView imgC301 = findViewById(R.id.imageView33);
                        ImageView imgC401 = findViewById(R.id.imageView4);
                        ImageView imgC305 = findViewById(R.id.imageView5);
                        ImageView imgC405 = findViewById(R.id.imageView6);
                        ImageView imgC505 = findViewById(R.id.imageView7);
                        ImageView imgC802 = findViewById(R.id.imageView8);
                        ImageView imgC103 = findViewById(R.id.imageView9);
                        ImageView imgC805 = findViewById(R.id.imageView10);
                        ImageView imgC404 = findViewById(R.id.imageView11);
                        ImageView imgC605 = findViewById(R.id.imageView12);
                        ImageView imgC705 = findViewById(R.id.imageView13);


                        if (valorFeedC601.equals("L")) {
                            imgC601.setVisibility(View.VISIBLE);
                        } else if (valorFeedC601.equals("D")) {
                            imgC601.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC203.equals("L")) {
                            imgC203.setVisibility(View.VISIBLE);
                        } else if (valorFeedC601.equals("D")) {
                            imgC203.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC301.equals("L")) {
                            imgC301.setVisibility(View.VISIBLE);
                        } else if (valorFeedC301.equals("D")) {
                            imgC301.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC401.equals("L")) {
                            imgC401.setVisibility(View.VISIBLE);
                        } else if (valorFeedC401.equals("D")) {
                            imgC401.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC305.equals("L")) {
                            imgC305.setVisibility(View.VISIBLE);
                        } else if (valorFeedC305.equals("D")) {
                            imgC305.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC405.equals("L")) {
                            imgC405.setVisibility(View.VISIBLE);
                        } else if (valorFeedC405.equals("D")) {
                            imgC405.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC505.equals("L")) {
                            imgC505.setVisibility(View.VISIBLE);
                        } else if (valorFeedC505.equals("D")) {
                            imgC505.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC802.equals("L")) {
                            imgC802.setVisibility(View.VISIBLE);
                        } else if (valorFeedC802.equals("D")) {
                            imgC802.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC103.equals("L")) {
                            imgC103.setVisibility(View.VISIBLE);
                        } else if (valorFeedC103.equals("D")) {
                            imgC103.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC805.equals("L")) {
                            imgC805.setVisibility(View.VISIBLE);
                        } else if (valorFeedC805.equals("D")) {
                            imgC805.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC404.equals("L")) {
                            imgC404.setVisibility(View.VISIBLE);
                        } else if (valorFeedC404.equals("D")) {
                            imgC404.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC605.equals("L")) {
                            imgC605.setVisibility(View.VISIBLE);
                        } else if (valorFeedC605.equals("D")) {
                            imgC605.setVisibility(View.INVISIBLE);
                        }
                        if (valorFeedC705.equals("L")) {
                            imgC705.setVisibility(View.VISIBLE);
                        } else if (valorFeedC705.equals("D")) {
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
    public void voltar(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void proximo() {
        //Abre INICIO 2
        Intent intent = new Intent(this, Inicio2.class);
        startActivity(intent);
        finish();
    }

    public void iluminação4() {
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacao4.class);
        startActivity(intent);
        finish();
    }

    public void iluminação3() {
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacao3.class);
        startActivity(intent);
        finish();
    }

    public void iluminação2() {
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacao2.class);
        startActivity(intent);
        finish();
    }

    public void iluminação(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacao.class);
        startActivity(intent);
        finish();

    }
    public void cenas_entrar(){
        //voltar MAIN_activity
        Intent intent = new Intent(this, Iluminacaocenas.class);
        startActivity(intent);
        finish();

    }

}
