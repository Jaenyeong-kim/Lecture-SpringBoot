package examples.boot.web1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class Member {
    public Member(){
        regdate = LocalDateTime.now();
    }

    public Member(String name, String email) {
        this();
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private LocalDateTime regdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }
}
