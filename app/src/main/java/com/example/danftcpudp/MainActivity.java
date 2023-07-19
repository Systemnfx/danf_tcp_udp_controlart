package com.example.danftcpudp;

import static android.content.ContentValues.TAG;
import static com.example.danftcpudp.TCP.receivedMessage;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Handler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    String valorC101 = " " , valorC201 = " " , valorC301 = " " , valorC401 = " ",valorC501 = " ",valorC601 = " ",valorC701 = " ",valorC801 = " ",valorC102 = " ",valorC202 = " ",valorC302 = " ",valorC402 = " ",valorC502 = " ",valorC602 = " ",valorC702 = " ",valorC802 = " ",valorC103 = " ",valorC203 = " ",valorC303 = " ",valorC403 = " ",valorC503 = " ",valorC603 = " ",valorC703 = " ",valorC803 = " ",valorC104 = " ",valorC204 = " ",valorC304 = " ",valorC404 = " ",valorC504 = " ",valorC604 = " ",valorC704 = " ",valorC804 = " ",valorC105 = " ",valorC205 = " ",valorC305 = " ",valorC405 = " ",valorC505 = " ",valorC605 = " ",valorC705 = " ",valorC805 = " ";

    static String IP1 = "192.168.1.3";
    public static String IPfinal;
    private static String SERVER_IP; // Remova a inicialização de SERVER_IP
    private static final int SERVER_PORT = 8080; // Insira a porta do servidor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new DHCP().execute();

        Button btn_entrap = (Button) findViewById(R.id.btn_entrar);//evento botao entrar

        btn_entrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrir();
            }
        });

        handler = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {
                String messageToSend = "<SA>";
                TCP tcpClient = new TCP(SERVER_IP, SERVER_PORT, messageToSend, receivedMessage);
                tcpClient.execute();

                Log.d(TAG, "Mensagem recebida NOVA: " + receivedMessage);
                Pattern padrao = Pattern.compile("<01C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><02C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><03C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><04C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)><05C1(\\w)C2(\\w)C3(\\w)C4(\\w)C5(\\w)C6(\\w)C7(\\w)C8(\\w)>");
                if (receivedMessage != null) {
                    Matcher Mpadrao = padrao.matcher(receivedMessage);
                    if (Mpadrao.find()) {

                        valorC101 = Mpadrao.group(1);
                        valorC201 = Mpadrao.group(2);
                        valorC301 = Mpadrao.group(3);
                        valorC401 = Mpadrao.group(4);
                        valorC501 = Mpadrao.group(5);
                        valorC601 = Mpadrao.group(6);
                        valorC701 = Mpadrao.group(7);
                        valorC801 = Mpadrao.group(8);
                        valorC102 = Mpadrao.group(9);
                        valorC202 = Mpadrao.group(10);
                        valorC302 = Mpadrao.group(11);
                        valorC402 = Mpadrao.group(12);
                        valorC502 = Mpadrao.group(13);
                        valorC602 = Mpadrao.group(14);
                        valorC702 = Mpadrao.group(15);
                        valorC802 = Mpadrao.group(16);
                        valorC103 = Mpadrao.group(17);
                        valorC203 = Mpadrao.group(18);
                        valorC303 = Mpadrao.group(19);
                        valorC403 = Mpadrao.group(20);
                        valorC503 = Mpadrao.group(21);
                        valorC603 = Mpadrao.group(22);
                        valorC703 = Mpadrao.group(23);
                        valorC803 = Mpadrao.group(24);
                        valorC104 = Mpadrao.group(25);
                        valorC204 = Mpadrao.group(26);
                        valorC304 = Mpadrao.group(27);
                        valorC404 = Mpadrao.group(28);
                        valorC504 = Mpadrao.group(29);
                        valorC604 = Mpadrao.group(30);
                        valorC704 = Mpadrao.group(31);
                        valorC804 = Mpadrao.group(32);
                        valorC105 = Mpadrao.group(33);
                        valorC205 = Mpadrao.group(34);
                        valorC305 = Mpadrao.group(35);
                        valorC405 = Mpadrao.group(36);
                        valorC505 = Mpadrao.group(37);
                        valorC605 = Mpadrao.group(38);
                        valorC705 = Mpadrao.group(39);
                        valorC805 = Mpadrao.group(40);

                        ImageView imgC101 = findViewById(R.id.ring);
                        ImageView imgC201 = findViewById(R.id.ring2);
                        ImageView imgC301 = findViewById(R.id.ring3);
                        ImageView imgC401 = findViewById(R.id.ring4);
                        ImageView imgC501 = findViewById(R.id.ring5);
                        ImageView imgC601 = findViewById(R.id.ring6);
                        ImageView imgC701 = findViewById(R.id.ring7);
                        ImageView imgC801 = findViewById(R.id.ring8);
                        ImageView imgC102 = findViewById(R.id.ring9);
                        ImageView imgC202 = findViewById(R.id.ring10);
                        ImageView imgC302 = findViewById(R.id.ring11);
                        ImageView imgC402 = findViewById(R.id.ring12);
                        ImageView imgC502 = findViewById(R.id.ring13);
                        ImageView imgC602 = findViewById(R.id.ring14);
                        ImageView imgC702 = findViewById(R.id.ring15);
                        ImageView imgC802 = findViewById(R.id.ring16);
                        ImageView imgC103 = findViewById(R.id.ring17);
                        ImageView imgC203 = findViewById(R.id.ring18);
                        ImageView imgC303 = findViewById(R.id.ring19);
                        ImageView imgC403 = findViewById(R.id.ring20);
                        ImageView imgC503 = findViewById(R.id.ring21);
                        ImageView imgC603 = findViewById(R.id.ring22);
                        ImageView imgC703 = findViewById(R.id.ring23);
                        ImageView imgC803 = findViewById(R.id.ring24);
                        ImageView imgC104 = findViewById(R.id.ring25);
                        ImageView imgC204 = findViewById(R.id.ring26);
                        ImageView imgC304 = findViewById(R.id.ring27);
                        ImageView imgC404 = findViewById(R.id.ring28);
                        ImageView imgC504 = findViewById(R.id.ring29);
                        ImageView imgC604 = findViewById(R.id.ring30);
                        ImageView imgC704 = findViewById(R.id.ring31);
                        ImageView imgC804 = findViewById(R.id.ring32);
                        ImageView imgC105 = findViewById(R.id.ring33);
                        ImageView imgC205 = findViewById(R.id.ring34);
                        ImageView imgC305 = findViewById(R.id.ring35);
                        ImageView imgC405 = findViewById(R.id.ring36);
                        ImageView imgC505 = findViewById(R.id.ring37);
                        ImageView imgC605 = findViewById(R.id.ring38);
                        ImageView imgC705 = findViewById(R.id.ring38);
                        ImageView imgC805 = findViewById(R.id.ring40);


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
                        if (valorC301.equals("L")) {
                            imgC301.setVisibility(View.VISIBLE);
                        } else if (valorC301.equals("D")) {
                            imgC301.setVisibility(View.INVISIBLE);
                        }
                        if (valorC401.equals("L")) {
                            imgC401.setVisibility(View.VISIBLE);
                        } else if (valorC401.equals("D")) {
                            imgC401.setVisibility(View.INVISIBLE);
                        }
                        if (valorC501.equals("L")) {
                            imgC501.setVisibility(View.VISIBLE);
                        } else if (valorC501.equals("D")) {
                            imgC501.setVisibility(View.INVISIBLE);
                        }
                        if (valorC601.equals("L")) {
                            imgC601.setVisibility(View.VISIBLE);
                        } else if (valorC601.equals("D")) {
                            imgC601.setVisibility(View.INVISIBLE);
                        }
                        if (valorC701.equals("L")) {
                            imgC701.setVisibility(View.VISIBLE);
                        } else if (valorC701.equals("D")) {
                            imgC701.setVisibility(View.INVISIBLE);
                        }
                        if (valorC801.equals("L")) {
                            imgC801.setVisibility(View.VISIBLE);
                        } else if (valorC801.equals("D")) {
                            imgC801.setVisibility(View.INVISIBLE);
                        }
                        if (valorC102.equals("L")) {
                            imgC102.setVisibility(View.VISIBLE);
                        } else if (valorC102.equals("D")) {
                            imgC102.setVisibility(View.INVISIBLE);
                        }
                        if (valorC202.equals("L")) {
                            imgC202.setVisibility(View.VISIBLE);
                        } else if (valorC202.equals("D")) {
                            imgC202.setVisibility(View.INVISIBLE);
                        }
                        if (valorC302.equals("L")) {
                            imgC302.setVisibility(View.VISIBLE);
                        } else if (valorC302.equals("D")) {
                            imgC302.setVisibility(View.INVISIBLE);
                        }
                        if (valorC402.equals("L")) {
                            imgC402.setVisibility(View.VISIBLE);
                        } else if (valorC402.equals("D")) {
                            imgC402.setVisibility(View.INVISIBLE);
                        }
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
                        if (valorC203.equals("L")) {
                            imgC203.setVisibility(View.VISIBLE);
                        } else if (valorC203.equals("D")) {
                            imgC203.setVisibility(View.INVISIBLE);
                        }
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
                        if (valorC404.equals("L")) {
                            imgC404.setVisibility(View.VISIBLE);
                        } else if (valorC404.equals("D")) {
                            imgC404.setVisibility(View.INVISIBLE);
                        }
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
                        if (valorC305.equals("L")) {
                            imgC305.setVisibility(View.VISIBLE);
                        } else if (valorC305.equals("D")) {
                            imgC305.setVisibility(View.INVISIBLE);
                        }
                        if (valorC405.equals("L")) {
                            imgC405.setVisibility(View.VISIBLE);
                        } else if (valorC405.equals("D")) {
                            imgC405.setVisibility(View.INVISIBLE);
                        }
                        if (valorC505.equals("L")) {
                            imgC505.setVisibility(View.VISIBLE);
                        } else if (valorC505.equals("D")) {
                            imgC505.setVisibility(View.INVISIBLE);
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

    public void abrir(){// volta para os ambientes
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
        finish();
    }
}
