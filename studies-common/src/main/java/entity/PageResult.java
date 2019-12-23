package entity;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private List<T> datalist;

    //总页数
    private long allPage;

    //总记录数
    private long allCount;

    //当前页
    private int nowPage;

    //页大小
    private int pageSize;

    public PageResult(List<T> datalist, long allPage, long allCount, int nowPage, int pageSize) {
        this.datalist = datalist;
        this.allPage = allPage;
        this.allCount = allCount;
        this.nowPage = nowPage;
        this.pageSize = pageSize;
    }

    public PageResult() {
    }
}
