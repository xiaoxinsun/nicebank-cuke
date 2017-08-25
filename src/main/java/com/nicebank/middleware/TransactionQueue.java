package com.nicebank.middleware;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TransactionQueue {

    private static String MESSAGE_FOLDER = "./messages";
    private static String MESSAGE_FILE_PATH = "%s/%03d";
    private int nextId = 1;

    public static void clear() {
        try {
            FileUtils.deleteDirectory(new File(MESSAGE_FOLDER));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        new File(MESSAGE_FOLDER).mkdirs();
    }

    public void write(String message) {
        String messageFilePath = String.format(MESSAGE_FILE_PATH, MESSAGE_FOLDER, nextId++);

        try (PrintWriter writer = new PrintWriter(messageFilePath, "UTF-8")) {
            writer.println(message);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String read() {
        File messagesFolder = new File(MESSAGE_FOLDER);
        File[] messages = messagesFolder.listFiles();

        String message = "";

        if (messages != null && messages.length > 0) {
            Arrays.sort(messages, Comparator.comparingInt(f -> Integer.parseInt(f.getName())));

            try (Scanner scanner = new Scanner(messages[0])) {
                if (scanner.hasNextLine()) {
                    message = scanner.nextLine();
                    messages[0].delete();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        return message;
    }

}
