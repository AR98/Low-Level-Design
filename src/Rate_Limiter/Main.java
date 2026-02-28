package Rate_Limiter;

import Rate_Limiter.Model.User;
import Rate_Limiter.Service.RateLimiterService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterService  rateLimiterService = RateLimiterService.getInstance();
        User u1 = new User("12345");
        rateLimiterService.checkAccess(u1.getUserId());

        System.out.println("--- Rapid Fire Requests ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Req " + i + ": " + (rateLimiterService.checkAccess(u1.getUserId()) ? "200 OK" : "429 Too Many Requests"));
            // Thread.sleep(200);
        }
        System.out.println("\n--- Waiting for window reset... ---");
        Thread.sleep(5000);

        System.out.println("Req 6: " + (rateLimiterService.checkAccess(u1.getUserId()) ? "200 OK" : "429 Too Many Requests"));
    }
}
