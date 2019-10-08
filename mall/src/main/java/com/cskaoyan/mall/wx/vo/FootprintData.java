package com.cskaoyan.mall.wx.vo;

import java.util.List;

public class FootprintData {
    List<FootData> footprintList;

    int totalPages;

    public List<FootData> getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List<FootData> footprintList) {
        this.footprintList = footprintList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
