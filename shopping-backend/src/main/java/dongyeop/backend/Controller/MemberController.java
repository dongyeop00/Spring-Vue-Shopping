package dongyeop.backend.Controller;

import dongyeop.backend.Entity.Member;
import dongyeop.backend.Repository.MemberRepository;
import dongyeop.backend.Service.JwtService;
import dongyeop.backend.Service.JwtServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity login(
            @RequestBody Map<String, String> params,
            HttpServletResponse response) {
        Member member = memberRepository.findByEmailAndPassword(params.get("email"), params.get("password"));

        if (member != null) {
            JwtService jwtService = new JwtServiceImpl();
            log.info("success login : {}",member.getEmail());
            int id = member.getId();
            String token = jwtService.getToken("id", id);

            Cookie cookie = new Cookie("token",token);
            cookie.setHttpOnly(true); //자바스크립트로 접근하지 못하게함
            cookie.setPath("/");

            response.addCookie(cookie);
            //return ResponseEntity.ok().build();
            return new ResponseEntity<>(id,HttpStatus.OK);

        } throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
