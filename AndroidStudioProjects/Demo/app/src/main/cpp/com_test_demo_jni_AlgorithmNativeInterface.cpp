#include "com_test_demo_jni_AlgorithmNativeInterface.h"
#include "native_algorithm.h"

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_com_test_demo_jni_AlgorithmNativeInterface_runAlgorithm
  (JNIEnv *env, jobject clazz, jint id)
  {
      switch (id){
          case 0:
              search_K_from_link();
              break;
          case 1:
              mergeIntLinkList();
              break;
          case 2:
              runGetOneNum();
              break;
          default:
              search_K_from_link();
      }
  }

#ifdef __cplusplus
}
#endif
