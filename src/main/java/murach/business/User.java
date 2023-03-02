package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String[] listTypeofmusic;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
    }

    public User(String firstName, String lastName, String email, String[] listTypeofmusic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.listTypeofmusic = listTypeofmusic;
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

    //lưu thêm thuộc tính sở thích âm nhạc.
    public String getListTypeOfMusic() {
        return String.join("<br>", listTypeofmusic);
    }
    public String getListLikeMusic() {
        return String.join(", ", listTypeofmusic);
    }
}
