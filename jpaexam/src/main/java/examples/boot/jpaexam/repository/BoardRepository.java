package examples.boot.jpaexam.repository;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.repository.custom.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Entity 클래스, Id Type 클래스가 제네릭으로 온다
public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {
    Board getBoardById(Long id); // method query의 추가

    @Query("SELECT b FROM Board b WHERE b.id = :id")
    Board getBoard(@Param("id") Long id);

    @Query("SELECT distinct b FROM Board b left join fetch b.boardFileList order by b.id")
    List<Board> getBoards();
}
