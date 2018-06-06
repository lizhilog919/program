/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#ifndef JNIDEFINES_H
#define JNIDEFINES_H
#define TAG "LogTest"

#include <jni.h>
#include <string.h>
#include <android/log.h>
#include <stdio.h>
#include <stdlib.h>
#define LOGV(tag,msg...) __android_log_print(ANDROID_LOG_VERBOSE, tag, msg)
#define LOGE(tag,msg...) __android_log_print(ANDROID_LOG_ERROR, tag, msg)
#define LOGW(tag,msg...) __android_log_print(ANDROID_LOG_WARN, tag, msg)
#define LOGI(tag,msg...) __android_log_print(ANDROID_LOG_INFO, tag, msg)

#endif
