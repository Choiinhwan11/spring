package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import user.bean.UserDTO;
import user.service.UserService;

import java.util.Map;

@Controller

@RequestMapping(value = "user")
public class UserController {



    @Autowired
    private UserService userService;

    /*라이트 폼으로 보내 쓰게 한다 . */
    @GetMapping(value = "writeForm")
    public String writeForm(){
        return "user/writeForm";
    }




/*유효성 검사 */
    @ResponseBody // jsp 파일로 가지말고 ajax success로 돌아가라
    @PostMapping(value = "isExistId")
    public String isExistId(@RequestParam String id){
        return userService.isExistId(id);
    }


    @ResponseBody
    @PostMapping(value="write")
    public void write(@ModelAttribute UserDTO userDTO){
        userService.write(userDTO);
    }



    @GetMapping(value="list")
    public String list(@RequestParam(required = false, defaultValue = "1") String pg, Model model){
        model.addAttribute("pg",pg);
        return "user/list";
    }

   /* @PostMapping(value = "getUserList")
    @ResponseBody
    public List<UserDTO> getUserList(@RequestParam String pg){
        return userService.getUserList(pg);
    }*/

    @PostMapping(value = "getUserList")
    @ResponseBody
    public Map<String, Object> getUserList(@RequestParam String pg){
        System.out.println("hi");
        Map<String, Object> data = userService.getUserList(pg);
        System.out.println(data);
        return data;
    }

    @GetMapping(value = "updateForm")
    public String updateForm(@RequestParam String id ,
                             @RequestParam String pg,
                             Model model){
        model.addAttribute("id", id);
        model.addAttribute("pg", pg);
        return "user/updateForm";
    }

    @PostMapping(value = "getUser")
    @ResponseBody
    public UserDTO getUser(@RequestParam String id){
        return userService.getUser(id);
    }

    @PostMapping(value = "update")
    @ResponseBody
    public void update(@ModelAttribute UserDTO userDTO){
        userService.update(userDTO);
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public void delete(@RequestParam String id){
        userService.delete(id);
    }
}
