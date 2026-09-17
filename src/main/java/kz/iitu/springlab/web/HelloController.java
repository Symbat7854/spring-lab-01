package kz.iitu.springlab.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Value("${app.owner:unknown}")
    private String owner;

    @GetMapping("/hello")
    public Greeting hello(@RequestParam(defaultValue = "world") String name) {
        return new Greeting("Hello, " + name + "!", owner, LocalDateTime.now());
    }

    @GetMapping("/info")
    public Info info() {
        return new Info(owner,
                System.getProperty("java.version"),
                Runtime.getRuntime().availableProcessors());
    }

    @GetMapping("/temperature")
    public TemperatureResponse convertTemperature(@RequestParam(defaultValue = "32.0") double f) {
        double celsius = (f - 32.0) * 5.0 / 9.0;
        double kelvin = celsius + 273.15;

        double roundedCelsius = Math.round(celsius * 100.0) / 100.0;
        double roundedKelvin = Math.round(kelvin * 100.0) / 100.0;

        return new TemperatureResponse(f, roundedCelsius, roundedKelvin);
    }

    public record Greeting(String message, String owner, LocalDateTime timestamp) { }

    public record Info(String owner, String javaVersion, int cpuCores) { }

    public record TemperatureResponse(double fahrenheit, double celsius, double kelvin) { }
}