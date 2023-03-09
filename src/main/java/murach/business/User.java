package murach.business;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String[] listTypeOfMusic;

    public User() {
    }

    public User(String firstName, String lastName, String email, String[] listTypeOfMusic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.listTypeOfMusic = listTypeOfMusic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getListTypeOfMusic() {
        return String.join("<br/>", listTypeOfMusic);
    }
    public String getListLikeMusic(){
        return String.join(", ", listTypeOfMusic);
    }
}