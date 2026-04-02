package Movie_Booking.Service;

import Movie_Booking.Model.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScreenScheduler {
    private final Map<String, List<Show>> scheduler = new ConcurrentHashMap<>();

    public synchronized  boolean addShow(Show s){
        scheduler.putIfAbsent(s.screen.id, new ArrayList<Show>());

        for(Show sh: scheduler.get(s.screen.id)){
            if(s.startTime.isBefore(sh.endTime) && s.endTime.isAfter(sh.startTime)) return false;
        }
        scheduler.get(s.screen.id).add(s);
        return true;

    }
}
