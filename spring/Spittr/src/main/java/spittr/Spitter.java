package spittr;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;

public class Spitter {
    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String firstName;

    @NotNull
    @Size(min = 5, max = 25)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 30)
    private String userName;

    @NotNull
    @Size(min = 2, max = 30)
    private String password;

    public Spitter(Long id, String firstName, String lastName, String userName,
                   String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public Spitter(String userName, String password, String firstName, String lastName) {
        this.id = 0L;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
}
