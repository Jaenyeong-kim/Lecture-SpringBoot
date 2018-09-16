package examples.boot.jpaexam.controller.api;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/boards")
public class BoardApiController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public ResponseEntity<Page<Board>> boards(
            Principal principal,
            @RequestParam(name = "page",
                    required = false,
                    defaultValue = "1")
                    int page){

        if(principal != null)
            System.out.println("pricipal name :" + principal.getName());

        Page<Board> boardPage = boardService.getBoards(page);
        return new ResponseEntity<>(boardPage, HttpStatus.OK);
    }
}
