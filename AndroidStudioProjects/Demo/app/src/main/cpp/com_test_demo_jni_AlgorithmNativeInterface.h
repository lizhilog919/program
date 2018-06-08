
#ifndef _Included_com_test_demo_jni_NativeInterface
#define _Included_com_test_demo_jni_NativeInterface

#include <jni.h>
#include "jni_define.h"
#include "data_factory.h"
#include "algorithm.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_test_demo_jni_AlgorithmNativeInterface_runAlgorithm
  (JNIEnv *env, jobject clazz, jint id);


void runSearch_K_from_link();

void runMergeIntLinkList();

void runGetOneNum();

void runFindGreatestSumOfSubArray();

void runRankArrayToMin();

void createTree();

#ifdef __cplusplus
}
#endif
#endif
