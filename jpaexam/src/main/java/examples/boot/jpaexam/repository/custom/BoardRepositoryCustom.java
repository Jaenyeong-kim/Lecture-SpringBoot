package examples.boot.jpaexam.repository.custom;

import examples.boot.jpaexam.domain.Board;

// Dynamic jpql, 복잡한 jpql로 실행해야 할 메소드 선언
public interface BoardRepositoryCustom {
    Board getBoardByDsl(Long id);
}
