package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 0. Что такое Socket? [#279269]
 */
public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean flag = true;
            while (flag) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "";
                    //noinspection CheckStyle
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("=")) {
                            if (str.contains("Hello")) {
                                answer = "Hello";
                            } else if (str.contains("Exit")) {
                                flag = false;
                            } else {
                                answer = str.split("=")[1]
                                        .split(" ")[0];
                            }
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                }
            }
        } catch (Exception e) {
            LOG.debug(Arrays.toString(e.getStackTrace()));
        }
    }
}
