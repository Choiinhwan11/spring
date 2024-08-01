package Chapter05_ANNO.userdao;

import Chapter05_ANNO.userbean.UserDTO;
import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserDAOMyBatis implements UserDAO {
    @Autowired
    private SqlSession sqlSession;

    // @Transactional 밑에 method들 모두에 걸어야되니까 아예 클래스에 걸면 된다.
    @Override
    public void write(UserDTO userDTO) {
        sqlSession.insert("userSQL.write" ,userDTO);
        /*
            sqlSession.commit();
            sqlSession.close();
             => 앞으로는 @Transactional 로 AOP 사용하겠다.
         */
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
    public void update(Map<String, String> map) {
        sqlSession.update("userSQL.update", map);
    }

    @Override
    public void delete(String id) {
        sqlSession.update("userSQL.delete", id);
    }
}
