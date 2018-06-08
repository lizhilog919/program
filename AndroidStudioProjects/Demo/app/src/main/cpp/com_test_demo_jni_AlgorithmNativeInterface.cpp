#include "com_test_demo_jni_AlgorithmNativeInterface.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_test_demo_jni_AlgorithmNativeInterface_runAlgorithm
  (JNIEnv *env, jobject clazz, jint id)
  {
      switch (id){
          case 0:
              runSearch_K_from_link();
              break;
          case 1:
              runMergeIntLinkList();
              break;
          case 2:
              runGetOneNum();
              break;
          case 3:
              runFindGreatestSumOfSubArray();
              break;
          case 4:
              runRankArrayToMin();
              break;
          case 5:
              createTree();
              break;
          default:
              break;
      }
  }


void createTree(){
    int data[] = {0,1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,-1,-1,-1,7,8,-1,-1,-1,9,10,11,-1,-1,-1,-1,-1,-1,-1};
    tree_node* root = createIntTree(data,0,30);
    printIntTree(root);
}

void runFindGreatestSumOfSubArray()
{
    int data[] = {1,-2,3,10,-4,7,2,-5};
    LOGV(TAG, "max: %d", FindGreatestSumOfSubArray(data, 8));

}

void runSearch_K_from_link()
{
    int data[] = {9,8,7,6,5,4,3,2,1};
    list_node *node = createIntLinkList(data, 9);
    printIntLinkList(node);
    LOGV(TAG, "result: %d", search(node, 8));
}

void runMergeIntLinkList()
{
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

void runRankArrayToMin()
{
    int data[] = {3, 32,321};
    int *result = rankArrayToMin(data, 3);
    printIntArrayList(result, 3);

}


#ifdef __cplusplus
}
#endif
