package examples.boot.shop.controller;

import examples.boot.shop.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {
    @GetMapping
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("name", "kim");

        List<Member> list = new ArrayList<>();
        list.add(new Member(1L, "kim", "kim@gmail.com"));
        list.add(new Member(2L, "lee", "lee@gmail.com"));
        list.add(new Member(3L, "kang", "kang@gmail.com"));
        modelMap.addAttribute("list", list);
        return "list"; // view name return
    }
}
