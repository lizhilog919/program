//
// Created by F2845590 on 2018/6/7.
//
#include "util.h"
#include <math.h>

#ifdef __cplusplus
extern "C" {
#endif

int getMax(int a,int b)
{
    return a > b ? a: b;
}

int getLinkNum(int a, int b)
{
    return a * (int)pow(10, getUnit(b)) + b;
}

int getUnit(int n){
    int k = 0;
    while (n != 0){
        n /= 10;
        k++;
    }
    return k;
}

#ifdef __cplusplus
}
#endif
