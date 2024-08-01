package Chapter04_XML.userdao;

import Chapter04_XML.userbean.UserDTO;
import lombok.Setter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




/*
public class UserDAOImpl implements UserDAO{
    @Setter
    private JdbcTemplate jdbcTemplate;
    @Override
    public void write(UserDTO userDTO) {
        // 1. driver loading
        // 2. Connection
        // 3. preparedStatement(SQL)
        // 이제 안한다. => Spring JdbcTemplate이 알아서 해준다
        String sql = "insert into usertable values(?,?,?)";
        jdbcTemplate.update(sql
                          , userDTO.getName()
                          , userDTO.getId()
                          , userDTO.getPwd()); // insert도, update, delete => update() 메소드 사용
    }
    @Override
    public List<UserDTO> getUserList() {
        String sql = "select * from usertable";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); // Resultset Row 한줄한줄 처리해준다
    }
}
*/

//------------------------------------------------
/*

public class UserDAOImpl extends JdbcDaoSupport implements UserDAO{
    @Override
    public void write(UserDTO userDTO) {
        // 1. driver loading
        // 2. Connection
        // 3. preparedStatement(SQL)
        // 이제 안한다. => Spring JdbcTemplate이 알아서 해준다
        String sql = "insert into usertable values(?,?,?)";
        getJdbcTemplate().update(sql
                , userDTO.getName()
                , userDTO.getId()
                , userDTO.getPwd()); // insert도, update, delete => update() 메소드 사용
    }
    @Override
    public List<UserDTO> getUserList() {
        String sql = "select * from usertable";
        return getJdbcTemplate().query(sql,new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); // Resultset Row 한줄한줄 처리해준다
    }
}*/

//--------------------------------------------------
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{

    @Override
    public void write(UserDTO userDTO) {
        Map<String, String> map = new HashMap<>();
        map.put("name", userDTO.getName());
        map.put("id", userDTO.getId());
        map.put("pwd", userDTO.getPwd());
        // 이제 물음표에 이름을 주겠다.
        String sql = "insert into usertable values(:name,:id,:pwd)";
        getNamedParameterJdbcTemplate().update(sql,map);
    }

    @Override
    public List<UserDTO> getUserList() {
        String sql = "select * from usertable";
        return getJdbcTemplate().query(sql,new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); // Resultset Row 한줄한줄 처리해준다
    }

    @Override
    public UserDTO getUser(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        String sql = "select * from usertable where id = ?";
        try {
            return getJdbcTemplate().queryForObject(
                    sql
                    ,new BeanPropertyRowMapper<UserDTO>(UserDTO.class)
                    ,id
            );
          /* return getNamedParameterJdbcTemplate().queryForObject(
                   sql
                  ,map
                  ,new BeanPropertyRowMapper<UserDTO>(UserDTO.class));*/
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void update(Map<String, String> map) {
        String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
        getNamedParameterJdbcTemplate().update(sql,map);
    }

    @Override
    public void delete(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);

        String sql = "delete from usertable where id=:id";
        getNamedParameterJdbcTemplate().update(sql,map);
    }
}