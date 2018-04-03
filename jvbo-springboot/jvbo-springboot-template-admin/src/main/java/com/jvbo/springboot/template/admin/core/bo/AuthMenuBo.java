package com.jvbo.springboot.template.admin.core.bo;

import java.util.LinkedList;

import com.jvbo.springboot.template.admin.core.model.AuthUserOperate;

public class AuthMenuBo implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3664473827728305971L;

	private String id;

    private String name;

    private String icon;

    private String url;

    private Integer type;

    private String parentMenu;

    private Integer sort;

	private LinkedList<AuthMenuBo> childenMenus;
	
	private LinkedList<AuthUserOperate> operates;
	

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public LinkedList<AuthMenuBo> getChildenManus() {
		return childenMenus;
	}
	public void setChildenManus(LinkedList<AuthMenuBo> childenManus) {
		this.childenMenus = childenManus;
	}
	
	public LinkedList<AuthUserOperate> getOperates() {
		return operates;
	}

	public void setOperates(LinkedList<AuthUserOperate> operates) {
		this.operates = operates;
	}
    
}