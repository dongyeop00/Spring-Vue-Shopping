package dongyeop.backend.Controller;

import dongyeop.backend.Entity.Member;
import dongyeop.backend.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping("/api/member/login")
    public int login(
            @RequestBody Map<String, String> params) {
        Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));

        if (member != null) {
            log.info("success login : {}",member.getEmail());
            return member.getId();
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
