package Rate_Limiter.Model;

public class User {
    private  final String userId;

    public User(String id){
        this.userId = id;
    }

    public String getUserId() {
        return userId;
    }
}
