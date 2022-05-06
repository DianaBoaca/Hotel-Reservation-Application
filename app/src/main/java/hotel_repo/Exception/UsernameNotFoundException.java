package hotel_repo.Exception;

public class UsernameNotFoundException extends Exception {

    private String username;

    public UsernameNotFoundException(String username) {
        super(String.format("An account with the username %s does not exist!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
