package Rate_Limiter.Factory;

import Rate_Limiter.Strategy.FixedWindowStrategy;
import Rate_Limiter.Strategy.RateLimitStrategy;

public class RateLimiterFactory {
    public static RateLimitStrategy createRateLimiterStrategy(String type, int limit, int window){
        if("FIXED".equalsIgnoreCase(type)){
            return new FixedWindowStrategy(window, limit);
        }
        throw new IllegalArgumentException("Strategy ot supported");
    }
}
