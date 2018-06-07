//
// Created by F2845590 on 2018/6/6.
//

#ifndef DEMO_NATIVE_ALGORITHM_H
#define DEMO_NATIVE_ALGORITHM_H

#include "data_factory.h"
#include "jni_define.h"

#ifdef __cplusplus
extern "C" {
#endif


/*
 * 搜索倒数K个元素
 */
int search(list_node *node, int k_);

/*
 * 合并两升序列表，依旧保持升序
 */
list_node* merge(list_node *node1, list_node *node2);

/*
 * n的二进制中1的个数
 */
int getOneNum(int n);

/*
 * 动态规划求字数组内最大子集最大和
 */
int FindGreatestSumOfSubArray(int arr[], int n);

/*
 * 把数组排列成最小数
 */
int* rankArrayToMin(int arr[], int n);


#ifdef __cplusplus
}
#endif
#endif //DEMO_NATIVE_ALGORITHM_H
