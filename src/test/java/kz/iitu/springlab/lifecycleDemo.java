package kz.iitu.springlab.web;

import kz.iitu.springlab.lifecycle.LifecycleDemo;
import kz.iitu.springlab.notify.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lab2")
public class Lab2Controller {

    private final NotificationService notificationService;
    private final LifecycleDemo lifecycle; // <-- 1. Мұны қосасыз

    // 2. Конструкторға lifecycle параметрін қосасыз
    public Lab2Controller(NotificationService notificationService, LifecycleDemo lifecycle) {
        this.notificationService = notificationService;
        this.lifecycle = lifecycle;
    }

    // Бұрынғы жазған әдістеріңіз...

    // 3. Жана lifecycle endpoint-ін қосасыз
    @GetMapping("/lifecycle")
    public List<String> lifecycle() {
        return lifecycle.events();
    }
}
