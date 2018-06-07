#include "jni_define.h"
#include "algorithm.h"
#include <stdint.h>
#include <malloc.h>
#include "util.h"

#ifdef __cplusplus
extern "C" {
#endif


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

int FindGreatestSumOfSubArray(int arr[],int n){
    int sum = arr[0];
    int max = arr[0];
    for(int i=1;i<n;i++){
        sum = getMax(sum + arr[i], arr[i]);
        if(sum > max)
        {
            max = sum;
        }
    }
    return max;
}

int* rankArrayToMin(int arr[], int n){
    for(int i=0;i<n;i++)
    {
        for(int j = n-1;j > i; j--)
        {
            if(getLinkNum(arr[j], arr[j-1]) < getLinkNum(arr[j-1], arr[j]))
            {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
            printIntArrayList(arr, n);
        }

    }
    return arr;
}

#ifdef __cplusplus
}
#endif
