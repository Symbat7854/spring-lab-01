package kz.iitu.springlab.notify;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component("noop")
@ConditionalOnMissingBean(Notifier.class)
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