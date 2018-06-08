//
// Created by F2845590 on 2018/6/7.
//

#ifndef DEMO_DATA_FACTORY_H
#define DEMO_DATA_FACTORY_H

#include "jni_define.h"

#ifdef __cplusplus
extern "C" {
#endif


/*
 * int link_list
 */
struct list_node{
    int data;
    struct list_node *next;
};

/*
 * create int link_list
 */
list_node* createIntLinkList(int data[], int n);

/*
 * print int link_list
 */
void printIntLinkList(list_node* node);

void printIntArrayList(int *list, int n);

/*
 * int tree
 */
struct tree_node{
    int data;
    struct tree_node *left;
    struct tree_node *right;
};


tree_node* createIntTree(int list[], int start, int end);

/*
 * 先序遍历二叉树
 */
void printIntTree(tree_node* tree);


#ifdef __cplusplus
}
#endif
#endif
