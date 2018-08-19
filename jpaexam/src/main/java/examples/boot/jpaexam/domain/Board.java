package examples.boot.jpaexam.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 글쓴이
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    // 카테고리
    @ManyToOne
    @JoinColumn(name = "board_category_id")
    private BoardCategory boardCategory;
    // 어떤 파일을 가지고 있는가
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardFile> boardFileList;
    private String title;
    private String content;
//    @Column(name ="read_count") // 스프링부트가 아니면 명시적으로 컬럼명 지정
    private int readCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
