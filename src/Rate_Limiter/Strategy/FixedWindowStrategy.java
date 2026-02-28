package Rate_Limiter.Strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowStrategy implements RateLimitStrategy {
    private final int maxRequest;
    private  final int windowSizems;
    private final Map<String, Window> userData = new ConcurrentHashMap<>() ;

    public FixedWindowStrategy(int windowSize, int maxRequest){
        this.windowSizems = windowSize;
        this.maxRequest = maxRequest;
    }

    @Override
    public boolean isAllowed(String userId) {
        long now = System.currentTimeMillis();
        Window window = userData.computeIfAbsent(userId, k-> new Window(now));
        synchronized (window){
            if(now-window.startTime>windowSizems){
                window.startTime = now;
                window.count = 0;
            }
            if(window.count<maxRequest){
                window.count++;
                return true;
            }
            return false;
        }

    }


    private static  class  Window{
        long startTime;
        int count;
        Window(long startTime){
            this.startTime = startTime;
            this.count = 0;
        }
    }
}
