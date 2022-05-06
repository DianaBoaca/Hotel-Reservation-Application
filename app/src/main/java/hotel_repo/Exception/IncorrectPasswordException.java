package hotel_repo.Exception;

public class IncorrectPasswordException extends Exception {

    private String username;

    public IncorrectPasswordException(String username) {
        super(String.format("Wrong password!"));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}