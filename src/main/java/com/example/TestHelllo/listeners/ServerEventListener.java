package com.example.TestHelllo.listeners;

import com.example.TestHelllo.events.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ServerEventListener {
    @EventListener
    public void ServerStarted(ServerStartEvent event) {
        System.out.println("Сервер запущен на порту " + event.getPort());
    }
    @EventListener
    public void RequestReceived(RequestReceivedEvent event) {
        System.out.println("Получен запрос " + event.getMethod() + " ");
    }
    @EventListener
    public void ServerStoped(ServerStopEvent event) {
        System.out.println("Сервер остановлен");
    }
    @EventListener
    public void OrderCompleted(OrderCompleteEvent event) {
        String responce = "Заказ #" + event.getOrderId() + " завершён на сумму " + event.getSumm() + "руб. " + String.format("%." + 7 + "f",Math.PI);
        System.out.println(responce);
    }
    @EventListener
    public void OrderStart(OrderStartEvent event) {
        String responce = "Заказ #" + event.getOrderId() + " начат";
        System.out.println(responce);
    }
    @EventListener
    public void OrderProcess(OrderProccessEvent event) {
        String responce = "Заказ #" + event.getOrderId() + "Идет обработка...";
        System.out.println(responce);
    }
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @EventListener
    public void UserActionListener(UserActionEvent event) {
        System.out.println("Пользователь" + event.getUserId() + "совершил действие" + event.getAction());
        System.out.println("Время" + event.getTime());
        System.out.println("id события" + event.getId());
        System.out.println("Доп данные" + event.getMetadata());
    }
}
