package examples.boot.shop.controller.api;

import examples.boot.shop.dto.Member;
import org.springframework.web.bind.annotation.*;

// @RestController = @Controller + @ResponseBody
// @ResponseBody - 컨트롤러 메소드가 리턴 값을 응답 바디로 전달.
// @Controller - 메소드가 리턴하는 값은 View name.
@RestController
@RequestMapping("/api/members")
public class MemberApiController {
    @GetMapping("/member1")
    public String member1() {
        return "member1";
    }

    @GetMapping("/member2")
    public Member member2() {
        Member member = new Member(1L, "kim", "test@gmail.com");
        return member;
    }

    // /member3?name=kim&id=5
    // 파라미터는 모두 문자열로 구성
    @GetMapping("/member3")
    public Member member3(@RequestParam(name = "name", required = true) String name,
                          @RequestParam(name = "id", required = false, defaultValue = "1") Long id) {
        Member member = new Member(id, name, "");
        return member;
    }

    // /member4?name=kim&id=5
    // @ModelAttribute 사용시 파라미터명과 프로퍼티명이 같아야 설정 됨
    @GetMapping("/member4")
    public Member member4(@ModelAttribute Member member) {
        return member;
    }

    @PostMapping("/member5")
    public String member5() {
        return "member5";
    }


    @PostMapping("/member6")
    public Member member6(@RequestParam(name = "name", required = true) String name,
                          @RequestParam(name = "id", required = false, defaultValue = "1") Long id) {
        Member member = new Member(id, name, "");
        return member;
    }

    // 요청에서 Content-Type : application/json
    @PostMapping("/member7")
    public Member member7(@RequestBody Member member) {
        return member;
    }

    // http://localhost:8080/members/member8/10
    @GetMapping("/member8/{id}")
    public String member8(@PathVariable(name = "id") String id) {
        return id;
    }
}
