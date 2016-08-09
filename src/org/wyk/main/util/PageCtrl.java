package org.wyk.main.util;

/**
 * @author wyk
 * @time  2016年6月5日
 */
public class PageCtrl {
    private int pageSize;

    private int pageNo;

    private int allCount;

    private int pageCount;

    private int rowCount;

    private static final int PAGE_SIZE_DEFAULT_VALUE = 2;

    public int getPageSize() {
        if (this.pageSize <= 0) {
            return PAGE_SIZE_DEFAULT_VALUE;
        }
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        if (this.pageNo <= 0)
            return 1;
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getAllCount() {
        return this.allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public boolean isNext() {
        return ((this.pageCount > 1) && (this.pageNo < this.pageCount));
    }

    public boolean isFornt() {
        return ((this.pageCount > 1) && (this.pageNo > 1));
    }

    public boolean isFirst() {
        return ((this.pageCount > 1) && (this.pageNo > 1));
    }

    public boolean isLast() {
        return ((this.pageCount > 1) && (this.pageNo != this.pageCount));
    }
}