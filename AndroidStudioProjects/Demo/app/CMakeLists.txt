
cmake_minimum_required(VERSION 3.4.1)

add_library( # Sets the name of the library.
             native-lib
             SHARED
             src/main/cpp/native_algorithm.cpp
             src/main/cpp/com_test_demo_jni_AlgorithmNativeInterface.cpp)



find_library( # Sets the name of the path variable.
              log-lib
              log )

target_link_libraries( # Specifies the target library.
                       native-lib
                       ${log-lib} )