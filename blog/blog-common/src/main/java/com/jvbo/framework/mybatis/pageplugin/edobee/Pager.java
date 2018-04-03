package com.jvbo.framework.mybatis.pageplugin.edobee;

public class Pager {

    public static Pager create(int pageNo, int pageSize) {
        Pager pager = new Pager();
        pager.setPageNo(pageNo);
        pager.setPageSize(pageSize);
        return pager;
    }

    public static Pager create(int pageNo, int pageSize, int startPage) {
        Pager pager = new Pager();
        pager.setPageNo(pageNo);
        pager.setPageSize(pageSize);
        pager.setStartPage(startPage);
        return pager;
    }

    private int pageNo;
    private int pageSize;
    private int startPage;

    public int getSkip() {
        return (pageNo - startPage) * pageSize;
    }

    public int getLimit() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
}
