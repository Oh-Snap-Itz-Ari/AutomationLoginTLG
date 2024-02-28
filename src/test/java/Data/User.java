package Data;

public enum User {

    User("testqa@automate.com", "Alfamego123");

    public String email;
    public String password;

    User(String email, String password) {
        this.email = email;
        this.password = password;

    }
}
