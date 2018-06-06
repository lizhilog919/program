#include "jni_define.h"
#include "native_algorithm.h"
#include <stdint.h>
#include <malloc.h>

#ifdef __cplusplus
extern "C" {
#endif

void search_K_from_link(){
    int data[] = {9,8,7,6,5,4,3,2,1};
    list_node *node = createIntLinkList(data, 9);
    printIntLinkList(node);
    LOGV(TAG, "result: %d", search(node, 8));
}

void mergeIntLinkList(){
    int data1[] = {1,3,7,8,12};
    int data2[] = {2,4,6,11,15,18};
    list_node *node1 = createIntLinkList(data1, 5);
    printIntLinkList(node1);
    list_node *node2 = createIntLinkList(data2, 6);
    printIntLinkList(node2);
    printIntLinkList(merge(node1, node2));
}

void runGetOneNum(){
    LOGV(TAG, "%d", getOneNum(13));
}

/**
 * 搜索倒数K个元素
 * @param node
 * @param k_
 * @return
 */
int search(list_node *node, int k_){
    int i=0;
    list_node *next = node;
    while (i < k_){
        next = next->next;
        i++;
    }
    list_node *head = node;
    while (next != NULL){
        head = head->next;
        next = next->next;
    }
    return head->data;

}

list_node* merge(list_node *node1, list_node *node2){
    list_node *node = (list_node*)malloc(sizeof(list_node));
    list_node * result = node;
    list_node *head1 = node1;
    list_node *head2 = node2;
    if(head1 == NULL)
    {
        return head2;
    }
    if(head2 == NULL){
        return head1;
    }
    while (head1 != NULL && head2 != NULL)
    {
        if(head1->data > head2->data)
        {
            node->next = head2;
            head2 = head2->next;
        } else {
            node->next = head1;
            head1 = head1->next;
        }
        node = node->next;
    }
    if(head1 != NULL)
    {
        node->next = head1;
    }
    if(head2 != NULL)
    {
        node->next = head2;
    }
    return result->next;
}

int getOneNum(int n){
    int k = 0;
    while(n){
        n &= n-1;
        k++;
    }
    return k;
}

int FindGreatestSumOfSubArray(int array[], int n) {

    if(array == NULL || (n == 1 && array[0] <= 0))
        return 0;

    int cur = array[0];
    int sum = array[0];
    for(int i = 1;i < n;i++){
        if(cur < 0)
            cur = 0;
        cur = cur + array[i];
        if(sum <= cur)
            sum = cur;
    }
    return sum;
}

int FindGreatestSumOfSubArray2(int arr[],int n){
    int sum = arr[0];
    int max = arr[0];
    for(int i = 1; i < n; i++){
        sum = getMax(sum+arr[i],arr[i]);
        if(sum >= max)
            max = sum;
    }

    return max;
}

int getMax(int a,int b){
    return a > b ? a: b;
}


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

#ifdef __cplusplus
}
#endif
