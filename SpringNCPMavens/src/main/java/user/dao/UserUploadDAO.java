package user.dao;

import org.apache.ibatis.annotations.Mapper;
import user.bean.UserImageDTO;

import java.util.List;

@Mapper
public interface UserUploadDAO {
    public void upload(List<UserImageDTO> userImageList);

    public List<UserImageDTO> getUploadList();


    public UserImageDTO getUploadImage(String seq);

    public String getImageFileName(int seq);

    public void uploadUpdate(UserImageDTO userImageDTO);

    public void uploadDelete(List<String> list);
}
