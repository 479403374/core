package com.mainframe.web.controller.monitor;

import com.mainframe.common.annotation.Log;
import com.mainframe.common.base.AjaxResult;
import com.mainframe.common.enums.BusinessType;
import com.mainframe.common.enums.OnlineStatus;
import com.mainframe.framework.shiro.session.OnlineSession;
import com.mainframe.framework.shiro.session.OnlineSessionDAO;
import com.mainframe.framework.util.ShiroUtils;
import com.mainframe.framework.web.base.BaseController;
import com.mainframe.framework.web.page.TableDataInfo;
import com.mainframe.system.domain.SysUserOnline;
import com.mainframe.system.service.impl.SysUserOnlineServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 在线用户监控
 * 
 * @author zhangzhao
 */
@Controller
@RequestMapping("/monitor/online")
public class SysUserOnlineController extends BaseController
{
    private String prefix = "monitor/online";

    @Autowired
    private SysUserOnlineServiceImpl userOnlineService;

    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    @RequiresPermissions("monitor:online:view")
    @GetMapping()
    public String online()
    {
        return prefix + "/online";
    }

    @RequiresPermissions("monitor:online:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUserOnline userOnline)
    {
        startPage();
        List<SysUserOnline> list = userOnlineService.selectUserOnlineList(userOnline);
        return getDataTable(list);
    }

    @RequiresPermissions("monitor:online:batchForceLogout")
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    @PostMapping("/batchForceLogout")
    @ResponseBody
    public AjaxResult batchForceLogout(@RequestParam("ids[]") String[] ids)
    {
        for (String sessionId : ids)
        {
            SysUserOnline online = userOnlineService.selectOnlineById(sessionId);
            if (online == null)
            {
                return error("用户已下线");
            }
            OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
            if (onlineSession == null)
            {
                return error("用户已下线");
            }
            if (sessionId.equals(ShiroUtils.getSessionId()))
            {
                return error("当前登陆用户无法强退");
            }
            onlineSession.setStatus(OnlineStatus.off_line);
            online.setStatus(OnlineStatus.off_line);
            userOnlineService.saveOnline(online);
        }
        return success();
    }

    @RequiresPermissions("monitor:online:forceLogout")
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    @PostMapping("/forceLogout")
    @ResponseBody
    public AjaxResult forceLogout(String sessionId)
    {
        SysUserOnline online = userOnlineService.selectOnlineById(sessionId);
        if (sessionId.equals(ShiroUtils.getSessionId()))
        {
            return error("当前登陆用户无法强退");
        }
        if (online == null)
        {
            return error("用户已下线");
        }
        OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
        if (onlineSession == null)
        {
            return error("用户已下线");
        }
        onlineSession.setStatus(OnlineStatus.off_line);
        online.setStatus(OnlineStatus.off_line);
        userOnlineService.saveOnline(online);
        return success();
    }
}
