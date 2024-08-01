package userdao;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import userbean.UserDTO;

import java.util.List;
import java.util.Map;

public class userDAOMyBatis implements UserDAO{
    @Setter
    private SqlSession sqlSession;



    @Override
    public void write(UserDTO userDTO) {
         sqlSession.insert("userSQL.write" ,userDTO);
    }

    @Override
    public List<UserDTO> getUserList() {
        return sqlSession.selectList("userSQL.getUserList");
    }

    @Override
    public UserDTO getUser(String id) {
        return sqlSession.selectOne("userSQL.getUser", id);
    }

    @Override
    public UserDTO update(Map<String,String>map) {
        sqlSession.update("userSQL.getUserUpdate",map);
        return null;
    }
}
