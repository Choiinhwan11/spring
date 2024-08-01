package user.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class UserPaging {
    private int currentPage; // 현재페이지
    private int pageBlock;
    private int pageSize; // 한페이지당 3개씩
    private int totalA; // 총글수
    private StringBuffer pagingHTML;


    public void makePagingHTML(){
        pagingHTML = new StringBuffer();

        // 총 페이지 수 총글 수
        int totalP = (totalA + pageSize - 1) / pageSize;

        int startPage = (currentPage-1) / pageBlock * pageBlock + 1;

        int endPage = startPage + pageBlock - 1;

        if(endPage > totalP) endPage = totalP;

        if(startPage != 1){
            pagingHTML.append("<span id='paging' onclick='userPaging(" + (startPage-1) + ")'>이전</span>");
        }
        for(int i=startPage ; i<= endPage ; i++){
            if(i == currentPage){
                pagingHTML.append("<span id='currentPaging' onclick='userPaging(" + i + ")'>" + i + "</span>");
            }else{
                pagingHTML.append("<span id='paging' onclick='userPaging(" + i + ")'>" + i + "</span>");
            }
        }

        if(endPage < totalP){
            pagingHTML.append("<span id='paging' onclick='userPaging(" + (endPage+1) + ")'>다음</span>");
        }
    }
}
