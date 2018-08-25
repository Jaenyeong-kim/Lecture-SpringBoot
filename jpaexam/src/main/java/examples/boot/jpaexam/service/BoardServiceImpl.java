package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    public Page<Board> getBoards(int pages) {
        Pageable pageable = PageRequest.of(1, 2);
        return boardRepository.getBoards(pageable);
    }
}
