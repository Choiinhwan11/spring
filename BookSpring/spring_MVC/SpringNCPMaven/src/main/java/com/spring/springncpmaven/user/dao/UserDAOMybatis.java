package com.spring.springncpmaven.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.spring.springncpmaven.user.bean.UserDTO;

import java.util.List;

@Repository
@Transactional
public class UserDAOMybatis implements UserDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserDTO isExistId(String id) {
        return sqlSession.selectOne("userSQL.isExistId", id);
    }

    @Override
    public void write(UserDTO userDTO) {
        sqlSession.insert("userSQL.write", userDTO);
    }

    @Override
    public List<UserDTO> getUserList(int pg) {
        List<UserDTO> list = sqlSession.selectList("userSQL.getUserList", pg);
        return list;
    }

    @Override
    public int getTotalA() {
        return sqlSession.selectOne("userSQL.getTotalA");
    }

    @Override
    public UserDTO getUser(String id) {
        System.out.println("userDAO start");
        UserDTO userDTO = sqlSession.selectOne("userSQL.isExistId", id);
        System.out.println("userDAO result : " + userDTO);
        return userDTO;
    }

    @Override
    public void update(UserDTO userDTO) {
        sqlSession.update("userSQL.update", userDTO);
    }

    @Override
    public void delete(String id) {
        sqlSession.delete("userSQL.delete", id);
    }
}
