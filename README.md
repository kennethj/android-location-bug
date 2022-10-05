# Android location Bug

Recreating issue reported here: https://issuetracker.google.com/issues/250945811

This does not crash the app when debugging, but does restart app and disconnectes debugger.

![request_location](https://user-images.githubusercontent.com/862054/194105616-85330370-991a-4284-8613-5270cb955282.gif)

![return_to_app](https://user-images.githubusercontent.com/862054/194105856-c7380165-8a00-45f9-b877-a4527156b252.gif)

```log

10/05 10:45:45: Launching 'app' on Pixel 6 Pro API 31.
Install successfully finished in 77 ms.
$ adb shell am start -n "com.example.locationbug/com.example.locationbug.MainActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER
Connected to process 5529 on device 'Pixel_6_Pro_API_31 [emulator-5554]'.
Capturing and displaying logcat messages from application. This behavior can be disabled in the "Logcat output" section of the "Debugger" settings page.
I/ple.locationbu: Late-enabling -Xcheck:jni
W/re-initialized>: type=1400 audit(0.0:69): avc: granted { execute } for path="/data/data/com.example.locationbug/code_cache/startup_agents/31c79e06-agent.so" dev="dm-4" ino=30041 scontext=u:r:untrusted_app:s0:c147,c256,c512,c768 tcontext=u:object_r:app_data_file:s0:c147,c256,c512,c768 tclass=file app=com.example.locationbug
V/studio.deploy: Startup agent attached to VM
V/studio.deploy: No existing instrumentation found. Loading instrumentation from instruments-dc04a095.jar
W/ple.locationbu: DexFile /data/data/com.example.locationbug/code_cache/.studio/instruments-dc04a095.jar is in boot class path but is not in a known location
V/studio.deploy: Applying transforms with cached classes
W/ple.locationbu: Redefining intrinsic method java.lang.Thread java.lang.Thread.currentThread(). This may cause the unexpected use of the original definition of java.lang.Thread java.lang.Thread.currentThread()in methods that have already been compiled.
W/ple.locationbu: Redefining intrinsic method boolean java.lang.Thread.interrupted(). This may cause the unexpected use of the original definition of boolean java.lang.Thread.interrupted()in methods that have already been compiled.
D/CompatibilityChangeReporter: Compat change id reported: 171979766; UID 10147; state: ENABLED
V/GraphicsEnvironment: ANGLE Developer option for 'com.example.locationbug' set to: 'default'
V/GraphicsEnvironment: Neither updatable production driver nor prerelease driver is supported.
D/NetworkSecurityConfig: No Network Security Config specified, using platform default
D/NetworkSecurityConfig: No Network Security Config specified, using platform default
D/libEGL: loaded /vendor/lib64/egl/libEGL_emulation.so
D/libEGL: loaded /vendor/lib64/egl/libGLESv1_CM_emulation.so
D/libEGL: loaded /vendor/lib64/egl/libGLESv2_emulation.so
W/ple.locationbu: Accessing hidden method Landroid/view/View;->computeFitSystemWindows(Landroid/graphics/Rect;Landroid/graphics/Rect;)Z (unsupported, reflection, allowed)
W/ple.locationbu: Accessing hidden method Landroid/view/ViewGroup;->makeOptionalFitsSystemWindows()V (unsupported, reflection, allowed)
D/HostConnection: createUnique: call
D/HostConnection: HostConnection::get() New Host Connection established 0xb40000749776d150, tid 5558
D/HostConnection: HostComposition ext ANDROID_EMU_CHECKSUM_HELPER_v1 ANDROID_EMU_native_sync_v2 ANDROID_EMU_native_sync_v3 ANDROID_EMU_native_sync_v4 ANDROID_EMU_dma_v1 ANDROID_EMU_direct_mem ANDROID_EMU_host_composition_v1 ANDROID_EMU_host_composition_v2 ANDROID_EMU_vulkan ANDROID_EMU_deferred_vulkan_commands ANDROID_EMU_vulkan_null_optional_strings ANDROID_EMU_vulkan_create_resources_with_requirements ANDROID_EMU_YUV_Cache ANDROID_EMU_vulkan_ignored_handles ANDROID_EMU_has_shared_slots_host_memory_allocator ANDROID_EMU_vulkan_free_memory_sync ANDROID_EMU_vulkan_shader_float16_int8 ANDROID_EMU_vulkan_async_queue_submit ANDROID_EMU_vulkan_queue_submit_with_commands ANDROID_EMU_sync_buffer_data ANDROID_EMU_read_color_buffer_dma GL_OES_EGL_image_external_essl3 GL_OES_vertex_array_object GL_KHR_texture_compression_astc_ldr ANDROID_EMU_host_side_tracing ANDROID_EMU_gles_max_version_3_0 
W/OpenGLRenderer: Failed to choose config with EGL_SWAP_BEHAVIOR_PRESERVED, retrying without...
W/OpenGLRenderer: Failed to initialize 101010-2 format, error = EGL_SUCCESS
D/EGL_emulation: eglCreateContext: 0xb40000749776ca90: maj 3 min 0 rcv 3
D/EGL_emulation: eglMakeCurrent: 0xb40000749776ca90: ver 3 0 (tinfo 0x76ba17b080) (first time)
I/Gralloc4: mapper 4.x is not supported
D/HostConnection: createUnique: call
D/HostConnection: HostConnection::get() New Host Connection established 0xb400007497774410, tid 5558
D/goldfish-address-space: allocate: Ask for block of size 0x100
D/goldfish-address-space: allocate: ioctl allocate returned offset 0x1e3ff8000 size 0x8000
W/Gralloc4: allocator 4.x is not supported
D/HostConnection: HostComposition ext ANDROID_EMU_CHECKSUM_HELPER_v1 ANDROID_EMU_native_sync_v2 ANDROID_EMU_native_sync_v3 ANDROID_EMU_native_sync_v4 ANDROID_EMU_dma_v1 ANDROID_EMU_direct_mem ANDROID_EMU_host_composition_v1 ANDROID_EMU_host_composition_v2 ANDROID_EMU_vulkan ANDROID_EMU_deferred_vulkan_commands ANDROID_EMU_vulkan_null_optional_strings ANDROID_EMU_vulkan_create_resources_with_requirements ANDROID_EMU_YUV_Cache ANDROID_EMU_vulkan_ignored_handles ANDROID_EMU_has_shared_slots_host_memory_allocator ANDROID_EMU_vulkan_free_memory_sync ANDROID_EMU_vulkan_shader_float16_int8 ANDROID_EMU_vulkan_async_queue_submit ANDROID_EMU_vulkan_queue_submit_with_commands ANDROID_EMU_sync_buffer_data ANDROID_EMU_read_color_buffer_dma GL_OES_EGL_image_external_essl3 GL_OES_vertex_array_object GL_KHR_texture_compression_astc_ldr ANDROID_EMU_host_side_tracing ANDROID_EMU_gles_max_version_3_0 
W/System: A resource failed to call close. 
D/EGL_emulation: app_time_stats: avg=764.19ms min=8.24ms max=7950.20ms count=11
D/EGL_emulation: app_time_stats: avg=94.53ms min=4.45ms max=1987.83ms count=25
D/EGL_emulation: app_time_stats: avg=166.14ms min=14.77ms max=1288.20ms count=9
```
