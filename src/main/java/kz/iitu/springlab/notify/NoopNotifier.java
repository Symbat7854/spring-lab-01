package kz.iitu.springlab.notify;

import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Component;

@Component("noop")
@Fallback
public class NoopNotifier implements Notifier {

    @Override
    public String send(String message) {
        return "noop";
    }

    @Override
    public String channel() {
        return "noop";
    }
}