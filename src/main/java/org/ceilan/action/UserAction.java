package org.ceilan.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.ceilan.entity.SysuserEntity;
import org.ceilan.service.SysuserEntityService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Author-Date： cuifuan   2018-06-09 下午 4:06
 * Description：
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
    @Resource
    private SysuserEntityService userService;

    private SysuserEntity user;

    public SysuserEntity getUser() {
        return user;
    }

    public void setUser(SysuserEntity user) {
        this.user = user;
    }

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String login() {

        if(userService.login(user)) {
           /* Map session = ActionContext.getContext().getSession();
            session.put("user", user);*/
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            result="1";
            return SUCCESS;
        } else {
            result="-1";
            return ERROR;
        }
    }
    private List<SysuserEntity> sysuserEntities;

    public List<SysuserEntity> getSysuserEntities() {
        return sysuserEntities;
    }

    public void setSysuserEntities(List<SysuserEntity> sysuserEntities) {
        this.sysuserEntities = sysuserEntities;
    }
    /**
     * description:获取全部数据
     * @param []
     * @return java.lang.String
     * @author cuifuan  2018-06-10 上午 11:59
     */
    public String list(){
        sysuserEntities=userService.getAllSysuserEntity();
        return SUCCESS;
    }
}
