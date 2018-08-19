package examples.boot.jpaexam.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

// Member, BoardCategory, Board, BoardFile
@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime joinDate;


}
