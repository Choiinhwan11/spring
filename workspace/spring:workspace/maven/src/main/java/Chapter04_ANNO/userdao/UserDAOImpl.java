package Chapter04_ANNO.userdao;

import Chapter04_ANNO.userbean.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

    // jdbcDaoSupport의 setDataSource가 final 이기때문에 Override를 할 수 없다.
    // 그래서 메소드명을 2로 살짝바꾸든가 / Constructor로 살짝 비껴나가든가.
    @Autowired
    public void setDataSource2(DataSource dataSource){
        setDataSource(dataSource); // jdbcDaoSupport의 setDataSource 호출
    }
  /*  @Autowired
    public UserDAOImpl(@Qualifier("dataSource") DataSource dataSource) {
            setDataSource(dataSource);
    }*/

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