package com.mainframe.crm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.mainframe.common.base.BaseEntity;

/**
 * 客户关系管理表 t_crm_base_info
 * 
 * @author ruoyi
 * @date 2019-01-29
 */
public class CrmBaseInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 客户名称 */
	private String name;
	/** 客户编码 */
	private String code;
	/** 组织类型(是人还是企业) */
	private String orgType;
	/** 客户方联系人 */
	private String customContact;
	/** 联系人联系方式 */
	private String customContactPhone;
	/**  */
	private String contact;
	/** 我方联系人联系方式 */
	private String contactPhone;
	/** 类别(是客户还是供应商) */
	private String type;
	/** 合作状态 */
	private String status;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	public void setOrgType(String orgType) 
	{
		this.orgType = orgType;
	}

	public String getOrgType() 
	{
		return orgType;
	}
	public void setCustomContact(String customContact) 
	{
		this.customContact = customContact;
	}

	public String getCustomContact() 
	{
		return customContact;
	}
	public void setCustomContactPhone(String customContactPhone) 
	{
		this.customContactPhone = customContactPhone;
	}

	public String getCustomContactPhone() 
	{
		return customContactPhone;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}

	public String getContact() 
	{
		return contact;
	}
	public void setContactPhone(String contactPhone) 
	{
		this.contactPhone = contactPhone;
	}

	public String getContactPhone() 
	{
		return contactPhone;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("orgType", getOrgType())
            .append("customContact", getCustomContact())
            .append("customContactPhone", getCustomContactPhone())
            .append("contact", getContact())
            .append("contactPhone", getContactPhone())
            .append("type", getType())
            .append("status", getStatus())
            .toString();
    }
}
