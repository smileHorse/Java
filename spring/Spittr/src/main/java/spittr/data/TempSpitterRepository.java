package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spitter;

@Component
public class TempSpitterRepository implements SpitterRepository {

    public Spitter save(Spitter spitter) {
        return null;
    }

    public Spitter findByUsername(String userName) {
        return null;
    }
}
