package Chapter04_ANNO.userbean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class UserDTO {
    private String name;
    private String id;
    private String pwd;

    @Override
    public String toString(){
        return name + "\t" + id + "\t" + pwd;
    }
}
