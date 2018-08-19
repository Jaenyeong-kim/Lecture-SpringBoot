package examples.boot.jpaexam.repository.custom;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.domain.QBoard;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BoardRepositoryCustomImpl extends QuerydslRepositorySupport
        implements BoardRepositoryCustom {
    public BoardRepositoryCustomImpl() {
        super(Board.class);
    }

    @Override
    public Board getBoardByDsl(Long id) {
        QBoard qBoard = QBoard.board;
//        JPQLQuery<Board> jpqlQuery = from(qBoard); // From Board
//        jpqlQuery = jpqlQuery.where(qBoard.id.eq(id)); // From Board Where b.id = :id
//        return jpqlQuery.fetchOne();

        return from(qBoard).where(qBoard.id.eq(id)).fetchOne();
    }

}
