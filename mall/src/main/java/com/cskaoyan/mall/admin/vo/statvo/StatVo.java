package com.cskaoyan.mall.admin.vo.statvo;

import java.util.List;

public class StatVo<T> {

    private List<String> columns;
    private List<T> rows;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
