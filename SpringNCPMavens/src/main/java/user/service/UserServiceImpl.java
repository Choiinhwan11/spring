package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.bean.UserDTO;
import user.bean.UserPaging;
import user.dao.UserDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserPaging userPaging;

    @Override
    public String isExistId(String id){
        UserDTO userDTO = userDAO.isExistId(id);
        if(userDTO == null)
            return "non_exist";
        else return "exist";
    }

    @Override
    public void write(UserDTO userDTO) {
        userDAO.write(userDTO);
    }

  /*  @Override
    public List<UserDTO> getUserList(String pg1) {
        // 1페이지당 3개씩
        // ~~~
        int pg = Integer.parseInt(pg1);
        int endNum = pg*3;
        int startNum = endNum - 2;

        int totalA = userDAO.getTotalA();

        UserPaging userPaging = new UserPaging();

        userPaging.setCurrentPage(pg);
        userPaging.setPageBlock(3);
        userPaging.setPageSize(3);
        userPaging.setTotalA(totalA);
        userPaging.makePagingHTML();


        List<UserDTO> list = userDAO.getUserList(pg1);

        // List => JSON 변환시켜서 보내야한다.
        // Spring이 변환시켜줌 => dependency 추가해주자
        // 그럼 뭐 안해줘도 알아서 JSON으로 변환시켜준다.

        return list;
    }*/

    @Override
    public Map<String,Object> getUserList(String pg1) {
        // 1페이지당 3개씩 - MySQL
        // ~~~
        int pg = Integer.parseInt(pg1);
        int endNum = 3; // 개수
        int startNum = pg*3 - 3; // 시작위치

        System.out.println("DAO.getuserlist 전 "+ startNum);

        List<UserDTO> list = userDAO.getUserList(startNum);

        System.out.println(list);

        /* 페이징 처리 */
        int totalA = userDAO.getTotalA(); // 총 글수


        userPaging.setCurrentPage(pg);
        userPaging.setPageBlock(3);
        userPaging.setPageSize(3);
        userPaging.setTotalA(totalA);
        userPaging.makePagingHTML();

        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
//        map.put("pagingHTML", userPaging.getPagingHTML().toString());
        map.put("userPaging",userPaging);
        // List => JSON 변환시켜서 보내야한다.
        // Spring이 변환시켜줌 => dependency 추가해주자
        // 그럼 뭐 안해줘도 알아서 JSON으로 변환시켜준다.

        return map;
    }

    @Override
    public UserDTO getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public void update(UserDTO userDTO) {
        userDAO.update(userDTO);
    }

    @Override
    public void delete(String id) {
        userDAO.delete(id);
    }
}
