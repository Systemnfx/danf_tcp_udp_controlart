package com.example.danftcpudp;

import android.os.AsyncTask;
import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHCP extends AsyncTask<Void, Void, String> {

    public static String IP;

    @Override
    protected String doInBackground(Void... voids) {
        try {
            // Cria um socket UDP
            DatagramSocket socket = new DatagramSocket();

            // Dados a serem enviados
            String comando = "<SI>";
            byte[] dados = comando.getBytes();

            // Informações do destino (endereço IP e porta do servidor)
            InetAddress enderecoServidor = InetAddress.getByName("255.255.255.255"); // Substitua pelo endereço IP correto
            int portaServidor = 5555; // Substitua pela porta correta

            // Cria um pacote UDP com os dados, o endereço e a porta
            DatagramPacket pacote = new DatagramPacket(dados, dados.length, enderecoServidor, portaServidor);

            // Envia o pacote para o servidor
            socket.send(pacote);

            // Cria um buffer para receber a resposta
            byte[] buffer = new byte[1024];
            DatagramPacket pacoteResposta = new DatagramPacket(buffer, buffer.length);

            // Aguarda a resposta do servidor
            socket.receive(pacoteResposta);

            // Obtém os dados da resposta
            byte[] dadosResposta = pacoteResposta.getData();
            int tamanhoResposta = pacoteResposta.getLength();
            String resposta = new String(dadosResposta, 0, tamanhoResposta);

            // Fecha o socket
            socket.close();

            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    protected void onPostExecute(String resposta) {
        if (resposta != null) {
            // Exibe a resposta recebida
            Log.d("DHCP", "Resposta do servidor: " + resposta);

            String input = resposta;
            String regex = "<(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String ipAddress = matcher.group(1);
                IP = ipAddress;
                Log.d("DHCP", "Endereço IP: " + ipAddress);
                MainActivity.receiveIP(ipAddress);
                Inicio.receiveIP(ipAddress);
                Inicio2.receiveIP(ipAddress);
                Inicio3.receiveIP(ipAddress);
                Iluminacao.receiveIP(ipAddress);
                Iluminacao2.receiveIP(ipAddress);
                Iluminacao3.receiveIP(ipAddress);
                Iluminacao4.receiveIP(ipAddress);
                Iluminacao5.receiveIP(ipAddress);
                Iluminacao6.receiveIP(ipAddress);
                Iluminacao7.receiveIP(ipAddress);
                Iluminacao8.receiveIP(ipAddress);
                Iluminacao9.receiveIP(ipAddress);
                Iluminacao10.receiveIP(ipAddress);
                Iluminacao11.receiveIP(ipAddress);
                Iluminacaocenas.receiveIP(ipAddress);



                // Chama o método estático na outra classe para enviar o endereço IP
            } else {
                Log.d("DHCP", "Endereço IP não encontrado");
            }
        } else {
            Log.d("DHCP", "Erro ao receber resposta do servidor");
        }
    }

}
