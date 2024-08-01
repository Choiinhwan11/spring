package Chapter04_XML.user.dao;

import Chapter04_XML.user.bean.UserDTO;
import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Setter
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(UserDTO userDTO) {
        String sql = "insert into usertable values(?, ?, ?)";
        // insert, update, delete -> update()
        jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
    }

    @Override
    public List<UserDTO> getUserList() {
        String sql = "select * from usertable";
        List<UserDTO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDTO.class));// 한줄 한줄 Mapping처리를 해줌(UserDTO.class 타입으로)
        return list;
    }
}
