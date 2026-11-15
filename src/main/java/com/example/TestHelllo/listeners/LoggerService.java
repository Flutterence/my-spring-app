package com.example.TestHelllo.listeners;

import com.example.TestHelllo.events.RequestReceivedEvent;
import com.example.TestHelllo.events.ServerStartEvent;
import com.example.TestHelllo.events.ServerStopEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class LoggerService {
    private static final String log = "src\\main\\java\\com\\example\\TestHelllo\\logs\\logs.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @EventListener
    public void ServerStarted(ServerStartEvent event) {
        log("SERVER STARTED", "Сервер запущен на порту " + event.getPort());
    }

    @EventListener
    public void RequestReceived(RequestReceivedEvent event) {
        log("REQUEST RECEIVED", event.getMethod() + " " + event.getUrl());
    }

    @EventListener
    public void ServerStopped(ServerStopEvent event) {
        log("SERVER STOPPED", "Сервер остановлен");
    }

    private void log(String eventType, String data) {
        String timestamp = LocalDateTime.now().format(formatter);
        String message = String.format("[%s] %s: %s", timestamp, eventType, data);
        try (FileWriter fw = new FileWriter(log, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог: " + e.getMessage());
        }
    }
}
