#include <stdint.h>
#include <malloc.h>
#include "data_factory.h"

#ifdef __cplusplus
extern "C" {
#endif

list_node* createIntLinkList(int data[], int n){
    list_node *node = NULL;
    node = (list_node*)malloc(sizeof(list_node));
    if(node == NULL){
        LOGE(TAG,"malloc fail");
    }
    memset(node,n, sizeof(list_node));
    list_node *tail = NULL;
    tail = node;
    list_node *head = NULL;
    head = node;
    for(int i=0;i<n;i++){
        tail->data = data[i];
        if(i == n-1){
            tail->next = NULL;
        } else{
            list_node *next = (list_node*)malloc(sizeof(list_node));
            tail->next = next;
            tail = next;
        }
    }
    return head;
}

void printIntLinkList(list_node* node){
    list_node *index = node;
    LOGV(TAG, "<<<---------------------");
    while (index != NULL){
        LOGV(TAG, "%d", index->data);
        index = index->next;
    }
    LOGV(TAG, "--------------------->>>");
}

void printIntArrayList(int *list, int n){
    LOGV(TAG, "---------------------");
    for(int i=0;i<n;i++)
    {
        LOGV(TAG, "%d", list[i]);
    }
    LOGV(TAG, "---------------------");
}


tree_node* createIntTree(int list[], int start, int end){
    if(list[start] == -1){
        return NULL;
    }
    if(start > end){
        return NULL;
    }
    tree_node *root = (tree_node*)malloc(sizeof(tree_node));
    root->data = list[start];
    root->left = createIntTree(list,start +1, (start + 1 + end )/2);
    root->right = createIntTree(list,(start + 1 + end)/2 + 1, end);
    return root;
}

void printIntTree(tree_node* tree){
    if(tree == NULL){
        return;
    }
    LOGV(TAG, "data: %d", tree->data);
    printIntTree(tree->right);
    printIntTree(tree->left);

}


#ifdef __cplusplus
}
#endif

