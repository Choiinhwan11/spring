package hello.hellospring.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.ws.rs.GET;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id ;
    private String name;
}
