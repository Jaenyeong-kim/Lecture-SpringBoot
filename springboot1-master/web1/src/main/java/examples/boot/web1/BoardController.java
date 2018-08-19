package examples.boot.web1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @GetMapping
    public String list(ModelMap modelMap){
        List<Board> list = new ArrayList<>();
        list.add(new Board("hong", "hello", "hello java"));
        list.add(new Board("lee", "hi", "hi java"));
        list.add(new Board("choi", "bye", "bye java"));
        modelMap.addAttribute("list", list);
        modelMap.addAttribute("count", list.size());
        return "list";
    }
}
