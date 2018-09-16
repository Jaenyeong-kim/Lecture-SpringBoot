package examples.boot.jpaexam.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @JsonIgnore
    private String password;
    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "member_member_role",
            joinColumns = @JoinColumn(name = "member_id",
                    referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "member_role_id",
                    referencedColumnName = "id") )
    public Set<MemberRole> memberRoles = new HashSet<>();

}
