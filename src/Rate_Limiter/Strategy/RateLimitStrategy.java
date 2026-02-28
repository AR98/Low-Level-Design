package Rate_Limiter.Strategy;

public interface RateLimitStrategy {
    boolean isAllowed(String userId);
}
