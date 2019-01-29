package com.mainframe.crm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mainframe.crm.mapper.CrmBaseInfoMapper;
import com.mainframe.crm.domain.CrmBaseInfo;
import com.mainframe.crm.service.ICrmBaseInfoService;
import com.mainframe.common.support.Convert;

/**
 * 客户关系管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-29
 */
@Service
public class CrmBaseInfoServiceImpl implements ICrmBaseInfoService 
{
	@Autowired
	private CrmBaseInfoMapper crmBaseInfoMapper;

	/**
     * 查询客户关系管理信息
     * 
     * @param id 客户关系管理ID
     * @return 客户关系管理信息
     */
    @Override
	public CrmBaseInfo selectCrmBaseInfoById(Integer id)
	{
	    return crmBaseInfoMapper.selectCrmBaseInfoById(id);
	}
	
	/**
     * 查询客户关系管理列表
     * 
     * @param crmBaseInfo 客户关系管理信息
     * @return 客户关系管理集合
     */
	@Override
	public List<CrmBaseInfo> selectCrmBaseInfoList(CrmBaseInfo crmBaseInfo)
	{
	    return crmBaseInfoMapper.selectCrmBaseInfoList(crmBaseInfo);
	}
	
    /**
     * 新增客户关系管理
     * 
     * @param crmBaseInfo 客户关系管理信息
     * @return 结果
     */
	@Override
	public int insertCrmBaseInfo(CrmBaseInfo crmBaseInfo)
	{
	    return crmBaseInfoMapper.insertCrmBaseInfo(crmBaseInfo);
	}
	
	/**
     * 修改客户关系管理
     * 
     * @param crmBaseInfo 客户关系管理信息
     * @return 结果
     */
	@Override
	public int updateCrmBaseInfo(CrmBaseInfo crmBaseInfo)
	{
	    return crmBaseInfoMapper.updateCrmBaseInfo(crmBaseInfo);
	}

	/**
     * 删除客户关系管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCrmBaseInfoByIds(String ids)
	{
		return crmBaseInfoMapper.deleteCrmBaseInfoByIds(Convert.toStrArray(ids));
	}
	
}
