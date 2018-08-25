package examples.boot.jpaexam.controller;

import examples.boot.jpaexam.domain.Board;
import examples.boot.jpaexam.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    // /boards
    // /borads?page = 1
    // /borads?page = 2
    @GetMapping
    public String boards(
            Principal principal, // 로그인 시 로그인 아이디 저장
            @RequestParam(name = "page",
                    required = false,
                    defaultValue = "1") int page, ModelMap modelMap) {

        Page<Board> boardPage = boardService.getBoards(page);

        if (principal != null) {
            System.out.println("Principal name: " + principal);
        }

        // 템플릿에게 전달
        modelMap.addAttribute("boardPage", boardPage);
        return "boards/list";
    }

}
