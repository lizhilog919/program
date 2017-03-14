package com.test.demo.design.strategy;

import com.test.demo.algorithm.SortUtil;

import java.util.List;

/**
 * Created by Li Zhi
 * 2017/3/9.
 */

public class QuickSortStrategy implements Strategy {

    @Override
    public void sort(Integer[] data) {
        SortUtil.quickSort(data, 0, data.length-1);
    }
}
