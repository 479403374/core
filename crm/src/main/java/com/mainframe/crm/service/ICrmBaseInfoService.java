package com.mainframe.crm.service;

import com.mainframe.crm.domain.CrmBaseInfo;
import java.util.List;

/**
 * 客户关系管理 服务层
 * 
 * @author ruoyi
 * @date 2019-01-29
 */
public interface ICrmBaseInfoService 
{
	/**
     * 查询客户关系管理信息
     * 
     * @param id 客户关系管理ID
     * @return 客户关系管理信息
     */
	public CrmBaseInfo selectCrmBaseInfoById(Integer id);
	
	/**
     * 查询客户关系管理列表
     * 
     * @param crmBaseInfo 客户关系管理信息
     * @return 客户关系管理集合
     */
	public List<CrmBaseInfo> selectCrmBaseInfoList(CrmBaseInfo crmBaseInfo);
	
	/**
     * 新增客户关系管理
     * 
     * @param crmBaseInfo 客户关系管理信息
     * @return 结果
     */
	public int insertCrmBaseInfo(CrmBaseInfo crmBaseInfo);
	
	/**
     * 修改客户关系管理
     * 
     * @param crmBaseInfo 客户关系管理信息
     * @return 结果
     */
	public int updateCrmBaseInfo(CrmBaseInfo crmBaseInfo);
		
	/**
     * 删除客户关系管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCrmBaseInfoByIds(String ids);
	
}
