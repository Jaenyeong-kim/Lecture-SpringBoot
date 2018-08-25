package examples.boot.jpaexam.repository;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.domain.BoardFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository; // 테스트할 대상 선언

    @Test
    public void testGetBoards() throws Exception {
        Pageable pageable = PageRequest.of(1, 2);
        Page<Board> boardPage = boardRepository.getBoards(pageable);
        System.out.println("page count " + boardPage.getTotalPages());
        System.out.println("element count " + boardPage.getTotalElements());
        for(Board board:boardPage){
            System.out.println(board.getId());
        }
    }

    @Test
    public void testGetBoardById1() throws Exception {
        System.out.println("---------------------------------------");
        Board board = boardRepository.getOne(1L); // 1L 키를 가진 Board 정보 요청
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("---------------------------------------");
    }

    @Test
    public void testGetBoardById2() throws Exception {
        System.out.println("---------------------------------------");
        Board board = boardRepository.getBoardById(1L); // 사용자가 정의한 메소드
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("---------------------------------------");
    }

    @Test
    public void testGetBoardById3() throws Exception {
        System.out.println("---------------------------------------");
        Board board = boardRepository.getBoard(1L); // 사용자가 정의한 메소드
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("---------------------------------------");
    }

    @Test
    public void testGetBoardById4() throws Exception {
        System.out.println("---------------------------------------");
        Board board = boardRepository.getBoardByDsl(1L); // 사용자가 정의한 메소드
        System.out.println(board.getClass().getName());
        System.out.println(board.getId() + " , " + board.getTitle());
        System.out.println(board.getMember().getName());
        System.out.println("---------------------------------------");
    }

    @Test
    public void testGetBoardList1() throws Exception {
        List<Board> list = boardRepository.findAll();

        for (Board board : list) {
            System.out.println(board.getId() + " , " + board.getTitle());
            System.out.println("****************************************");
            List<BoardFile> boardFiles = board.getBoardFileList();
            for (BoardFile boardFile : boardFiles) {
                System.out.println(boardFile.getName());
            }
        }
        System.out.println("--------------------------------------");
    }




//    @Test
//    public void configTest() {
//        System.out.println("config");
//    }
//
//    @Before //junit
//    public void init() {
//        System.out.println("before");
//    }
//
//    @After //junit
//    public void destroy() {
//        System.out.println("after");
//    }
//
//    @Test
//    public void getBoardId1() throws Exception {
//        System.out.println("board id 1");
//    }
//
//    @Test
//    public void getBoardId2() throws Exception {
//        System.out.println("board id 2");
//    }
//
//    @Test
//    public void getBoardId3() throws Exception {
//        System.out.println("board id 3");
//    }
}
