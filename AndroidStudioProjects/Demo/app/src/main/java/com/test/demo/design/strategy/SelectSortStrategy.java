package com.test.demo.design.strategy;

import com.test.demo.algorithm.SortUtil;

/**
 * Created by Li Zhi
 * 2017/3/9.
 */

public class SelectSortStrategy implements Strategy{
    @Override
    public void sort(Integer[] data) {
        SortUtil.selectSort(data);
    }
}
