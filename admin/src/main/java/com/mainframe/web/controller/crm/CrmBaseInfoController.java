package com.mainframe.web.controller.crm;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mainframe.common.annotation.Log;
import com.mainframe.common.enums.BusinessType;
import com.mainframe.crm.domain.CrmBaseInfo;
import com.mainframe.crm.service.ICrmBaseInfoService;
import com.mainframe.framework.web.base.BaseController;
import com.mainframe.framework.web.page.TableDataInfo;
import com.mainframe.common.base.AjaxResult;
import com.mainframe.common.utils.ExcelUtil;

/**
 * 客户关系管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-01-29
 */
@Controller
@RequestMapping("/system/crmBaseInfo")
public class CrmBaseInfoController extends BaseController
{
    private String prefix = "crmBaseInfo";
	
	@Autowired
	private ICrmBaseInfoService crmBaseInfoService;
	
	@RequiresPermissions("system:crmBaseInfo:view")
	@GetMapping()
	public String crmBaseInfo()
	{
	    return prefix + "/crmBaseInfo";
	}
	
	/**
	 * 查询客户关系管理列表
	 */
	@RequiresPermissions("system:crmBaseInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CrmBaseInfo crmBaseInfo)
	{
		startPage();
        List<CrmBaseInfo> list = crmBaseInfoService.selectCrmBaseInfoList(crmBaseInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客户关系管理列表
	 */
	@RequiresPermissions("system:crmBaseInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CrmBaseInfo crmBaseInfo)
    {
    	List<CrmBaseInfo> list = crmBaseInfoService.selectCrmBaseInfoList(crmBaseInfo);
        ExcelUtil<CrmBaseInfo> util = new ExcelUtil<CrmBaseInfo>(CrmBaseInfo.class);
        return util.exportExcel(list, "crmBaseInfo");
    }
	
	/**
	 * 新增客户关系管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客户关系管理
	 */
	@RequiresPermissions("system:crmBaseInfo:add")
	@Log(title = "客户关系管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CrmBaseInfo crmBaseInfo)
	{		
		return toAjax(crmBaseInfoService.insertCrmBaseInfo(crmBaseInfo));
	}

	/**
	 * 修改客户关系管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		CrmBaseInfo crmBaseInfo = crmBaseInfoService.selectCrmBaseInfoById(id);
		mmap.put("crmBaseInfo", crmBaseInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客户关系管理
	 */
	@RequiresPermissions("system:crmBaseInfo:edit")
	@Log(title = "客户关系管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CrmBaseInfo crmBaseInfo)
	{		
		return toAjax(crmBaseInfoService.updateCrmBaseInfo(crmBaseInfo));
	}
	
	/**
	 * 删除客户关系管理
	 */
	@RequiresPermissions("system:crmBaseInfo:remove")
	@Log(title = "客户关系管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(crmBaseInfoService.deleteCrmBaseInfoByIds(ids));
	}
	
}
