//
// Created by F2845590 on 2018/6/6.
//

#ifndef DEMO_NATIVE_ALGORITHM_H
#define DEMO_NATIVE_ALGORITHM_H

#ifdef __cplusplus
extern "C" {
#endif

struct list_node{
    int data;
    struct list_node *next;
};

list_node* createIntLinkList(int data[], int n);

void printIntLinkList(list_node* node);

void search_K_from_link();

void mergeIntLinkList();

void runGetOneNum();

/**
 * 搜索倒数K个元素
 * @param node
 * @param k_
 * @return
 */
int search(list_node *node, int k_);

/**
 * 合并两升序列表，依旧保持升序
 * @param node1
 * @param node2
 * @return
 */
list_node* merge(list_node *node1, list_node *node2);

/**
 * n的二进制中1的个数
 * @param n
 * @return
 */
int getOneNum(int n);

int FindGreatestSumOfSubArray(int array[], int n);
int FindGreatestSumOfSubArray2(int arr[],int n);

int getMax(int a,int b);

#ifdef __cplusplus
}
#endif
#endif //DEMO_NATIVE_ALGORITHM_H
