package Rate_Limiter.Service;

import Rate_Limiter.Factory.RateLimiterFactory;
import Rate_Limiter.Strategy.RateLimitStrategy;

public class RateLimiterService {
    private static  RateLimiterService instance;
    private final RateLimitStrategy strategy;

    private RateLimiterService() {
        // Configuration: 3 requests per 5 seconds
        this.strategy = RateLimiterFactory.createRateLimiterStrategy("FIXED", 3, 5);
    }

    public static synchronized RateLimiterService getInstance(){
        if(instance==null){
            instance = new RateLimiterService();
        }

        return instance;
    }

    public boolean checkAccess(String userId){
        return strategy.isAllowed(userId);
    }

}
