package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.List;

@Component
public class TempSpittleRepository implements SpittleRepository {

    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public Spittle findOne(long id) {
        return null;
    }
}
