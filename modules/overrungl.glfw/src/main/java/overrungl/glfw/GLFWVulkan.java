/*
 * MIT License
 *
 * Copyright (c) 2022-2024 Overrun Organization
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package overrungl.glfw;

import overrun.marshal.DirectAccess;
import overrun.marshal.Downcall;
import overrun.marshal.gen.AsBool;
import overrun.marshal.gen.Convert;
import overrun.marshal.gen.Entrypoint;
import overrun.marshal.gen.Ref;
import overrungl.NativeType;

import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandles;

/**
 * The GLFW Vulkan binding.
 *
 * @author squid233
 * @since 0.1.0
 */
public interface GLFWVulkan extends DirectAccess {
    /**
     * The instance of GLFWVulkan.
     */
    GLFWVulkan INSTANCE = Downcall.load(MethodHandles.lookup(), Handles.lookup);

    /**
     * Sets the desired Vulkan {@code vkGetInstanceProcAddr} function.
     * <p>
     * This function sets the {@code vkGetInstanceProcAddr} function that GLFW will use for all
     * Vulkan related entry point queries.
     * <p>
     * This feature is mostly useful on macOS, if your copy of the Vulkan loader is in
     * a location where GLFW cannot find it through dynamic loading, or if you are still
     * using the static library version of the loader.
     * <p>
     * If set to {@link MemorySegment#NULL}, GLFW will try to load the Vulkan loader dynamically by its standard
     * name and get this function from there.  This is the default behavior.
     * <p>
     * The standard name of the loader is {@code vulkan-1.dll} on Windows, {@code libvulkan.so.1} on
     * Linux and other Unix-like systems and {@code libvulkan.1.dylib} on macOS.  If your code is
     * also loading it via these names then you probably don't need to use this function.
     * <p>
     * The function address you set is never reset by GLFW, but it only takes effect during
     * initialization.  Once GLFW has been initialized, any updates will be ignored until the
     * library is terminated and initialized again.
     *
     * @param loader The address of the function to use, or {@link MemorySegment#NULL}.
     *               Loader function signature
     *               <pre><code>PFN_vkVoidFunction vkGetInstanceProcAddr(VkInstance instance, const char* name)</code></pre>
     *               For more information about this function,
     *               see the <a href="https://www.khronos.org/registry/vulkan/">Vulkan Registry</a>.
     * @glfw.errors None.
     * @glfw.remark This function may be called before {@link GLFW#init}.
     * @glfw.thread_safety This function must only be called from the main thread.
     * @see GLFW#init
     */
    @Entrypoint("glfwInitVulkanLoader")
    void initVulkanLoader(@NativeType("PFN_vkGetInstanceProcAddr") MemorySegment loader);

    /**
     * Returns the address of the specified Vulkan instance function.
     * <p>
     * This function returns the address of the specified Vulkan core or extension
     * function for the specified instance.  If instance is set to {@link MemorySegment#NULL NULL} it can
     * return any function exported from the Vulkan loader, including at least the
     * following functions:
     *
     * <ul>
     *     <li>{@code vkEnumerateInstanceExtensionProperties}</li>
     *     <li>{@code vkEnumerateInstanceLayerProperties}</li>
     *     <li>{@code vkCreateInstance}</li>
     *     <li>{@code vkGetInstanceProcAddr}</li>
     * </ul>
     * <p>
     * If Vulkan is not available on the machine, this function returns {@link MemorySegment#NULL NULL} and
     * generates a {@link GLFW#API_UNAVAILABLE API_UNAVAILABLE} error.  Call {@link GLFW#vulkanSupported vulkanSupported}
     * to check whether Vulkan is at least minimally available.
     * <p>
     * This function is equivalent to calling {@code vkGetInstanceProcAddr} with
     * a platform-specific query of the Vulkan loader as a fallback.
     *
     * @param instance The Vulkan instance to query, or {@link MemorySegment#NULL NULL} to retrieve
     *                 functions related to instance creation.
     * @param procName The ASCII encoded name of the function.
     * @return The address of the function, or {@link MemorySegment#NULL NULL} if an
     * <a href="https://www.glfw.org/docs/latest/intro_guide.html#error_handling">error</a> occurred.
     * @glfw.errors Possible errors include {@link GLFW#NOT_INITIALIZED NOT_INITIALIZED} and
     * {@link GLFW#API_UNAVAILABLE API_UNAVAILABLE}.
     * @glfw.pointer_lifetime The returned function pointer is valid until the library
     * is terminated.
     * @glfw.thread_safety This function may be called from any thread.
     */
    @Entrypoint("glfwGetInstanceProcAddress")
    MemorySegment ngetInstanceProcAddress(MemorySegment instance, MemorySegment procName);

    /**
     * Returns the address of the specified Vulkan instance function.
     *
     * @param instance The Vulkan instance to query, or {@link MemorySegment#NULL NULL} to retrieve
     *                 functions related to instance creation.
     * @param procName The ASCII encoded name of the function.
     * @return The address of the function, or {@link MemorySegment#NULL NULL} if an
     * <a href="https://www.glfw.org/docs/latest/intro_guide.html#error_handling">error</a> occurred.
     * @see #ngetInstanceProcAddress(MemorySegment, MemorySegment) nglfwGetInstanceProcAddress
     */
    @Entrypoint("glfwGetInstanceProcAddress")
    MemorySegment getInstanceProcAddress(MemorySegment instance, String procName);

    /**
     * Returns whether the specified queue family can present images.
     * <p>
     * This function returns whether the specified queue family of the specified
     * physical device supports presentation to the platform GLFW was built for.
     * <p>
     * If Vulkan or the required window surface creation instance extensions are
     * not available on the machine, or if the specified instance was not created
     * with the required extensions, this function returns {@code false} and
     * generates a {@link GLFW#API_UNAVAILABLE API_UNAVAILABLE} error.  Call
     * {@link GLFW#vulkanSupported vulkanSupported} to check whether Vulkan is
     * at least minimally available and {@link GLFW#ngetRequiredInstanceExtensions getRequiredInstanceExtensions}
     * to check what instance extensions are required.
     *
     * @param instance    The instance that the physical device belongs to.
     * @param device      The physical device that the queue family belongs to.
     * @param queueFamily The index of the queue family to query.
     * @return {@code true} if the queue family supports presentation, or
     * {@code false} otherwise.
     * @glfw.errors Possible errors include {@link GLFW#NOT_INITIALIZED NOT_INITIALIZED},
     * {@link GLFW#API_UNAVAILABLE API_UNAVAILABLE} and {@link GLFW#PLATFORM_ERROR PLATFORM_ERROR}.
     * @glfw.remark <b>macOS:</b> This function currently always returns {@code true}, as the
     * {@code VK_MVK_macos_surface} and {@code VK_EXT_metal_surface} extensions do not provide
     * a {@code vkGetPhysicalDevice*PresentationSupport} type function.
     * @glfw.thread_safety This function may be called from any thread.  For
     * synchronization details of Vulkan objects, see the Vulkan specification.
     */
    @Convert(AsBool.INT)
    @Entrypoint("glfwGetPhysicalDevicePresentationSupport")
    boolean getPhysicalDevicePresentationSupport(MemorySegment instance, MemorySegment device, int queueFamily);

    /**
     * Creates a Vulkan surface for the specified window.
     * <p>
     * This function creates a Vulkan surface for the specified window.
     * <p>
     * If the Vulkan loader or at least one minimally functional ICD were not found,
     * this function returns {@code VK_ERROR_INITIALIZATION_FAILED} and generates a
     * {@link GLFW#API_UNAVAILABLE API_UNAVAILABLE} error.  Call {@link GLFW#vulkanSupported() vulkanSupported}
     * to check whether Vulkan is at least minimally available.
     * <p>
     * If the required window surface creation instance extensions are not
     * available or if the specified instance was not created with these extensions
     * enabled, this function returns {@code VK_ERROR_EXTENSION_NOT_PRESENT} and
     * generates a {@link GLFW#API_UNAVAILABLE API_UNAVAILABLE} error.  Call
     * {@link GLFW#ngetRequiredInstanceExtensions getRequiredInstanceExtensions} to check
     * what instance extensions are required.
     * <p>
     * The window surface cannot be shared with another API so the window must
     * have been created with the {@link GLFW#CLIENT_API client api hint}
     * set to {@code NO_API} otherwise it generates a {@link GLFW#INVALID_VALUE INVALID_VALUE} error
     * and returns {@code VK_ERROR_NATIVE_WINDOW_IN_USE_KHR}.
     * <p>
     * The window surface must be destroyed before the specified Vulkan instance.
     * It is the responsibility of the caller to destroy the window surface.  GLFW
     * does not destroy it for you.  Call {@code vkDestroySurfaceKHR} to destroy the
     * surface.
     *
     * @param instance  The Vulkan instance to create the surface in.
     * @param window    The window to create the surface for.
     * @param allocator The allocator to use, or {@link MemorySegment#NULL NULL} to use the default
     *                  allocator.
     * @param surface   Where to store the handle of the surface.  This is set
     *                  to {@code VK_NULL_HANDLE} if an error occurred.
     * @return {@code VK_SUCCESS} if successful, or a Vulkan error code if an
     * <a href="https://www.glfw.org/docs/latest/intro_guide.html#error_handling">error</a> occurred.
     * @glfw.errors Possible errors include {@link GLFW#NOT_INITIALIZED NOT_INITIALIZED},
     * {@link GLFW#API_UNAVAILABLE API_UNAVAILABLE}, {@link GLFW#PLATFORM_ERROR PLATFORM_ERROR}
     * and {@link GLFW#INVALID_VALUE INVALID_VALUE}.
     * @glfw.remark If an error occurs before the creation call is made, GLFW returns
     * the Vulkan error code most appropriate for the error.  Appropriate use of
     * {@link GLFW#vulkanSupported() vulkanSupported} and
     * {@link GLFW#ngetRequiredInstanceExtensions(MemorySegment) getRequiredInstanceExtensions} should
     * eliminate almost all occurrences of these errors.
     * <ul>
     * <li>
     * <b>macOS:</b> GLFW prefers the {@code VK_EXT_metal_surface} extension, with the
     * {@code VK_MVK_macos_surface} extension as a fallback.  The name of the selected
     * extension, if any, is included in the array returned by
     * {@link GLFW#ngetRequiredInstanceExtensions(MemorySegment) getRequiredInstanceExtensions}.
     * <p>
     * This function creates and sets a {@code CAMetalLayer} instance for
     * the window content view, which is required for MoltenVK to function.
     * </li>
     * <li>
     * <b>X11:</b> By default GLFW prefers the {@code VK_KHR_xcb_surface} extension,
     * with the {@code VK_KHR_xlib_surface} extension as a fallback.  You can make
     * {@code VK_KHR_xlib_surface} the preferred extension by setting the
     * {@link GLFW#X11_XCB_VULKAN_SURFACE} init
     * hint.  The name of the selected extension, if any, is included in the array
     * returned by {@link GLFW#ngetRequiredInstanceExtensions getRequiredInstanceExtensions}.
     * </li>
     * </ul>
     * @glfw.thread_safety This function may be called from any thread.  For
     * synchronization details of Vulkan objects, see the Vulkan specification.
     * @see GLFW#ngetRequiredInstanceExtensions(MemorySegment) getRequiredInstanceExtensions
     */
    @Entrypoint("glfwCreateWindowSurface")
    int ncreateWindowSurface(MemorySegment instance, MemorySegment window, MemorySegment allocator, MemorySegment surface);

    /**
     * Creates a Vulkan surface for the specified window.
     *
     * @param instance  The Vulkan instance to create the surface in.
     * @param window    The window to create the surface for.
     * @param allocator The allocator to use, or {@link MemorySegment#NULL NULL} to use the default
     *                  allocator.
     * @param surface   Where to store the handle of the surface.  This is set
     *                  to {@code VK_NULL_HANDLE} if an error occurred.
     * @return {@code VK_SUCCESS} if successful, or a Vulkan error code if an
     * <a href="https://www.glfw.org/docs/latest/intro_guide.html#error_handling">error</a> occurred.
     * @see #ncreateWindowSurface(MemorySegment, MemorySegment, MemorySegment, MemorySegment) nglfwCreateWindowSurface
     */
    @Entrypoint("glfwCreateWindowSurface")
    int createWindowSurface(MemorySegment instance, MemorySegment window, MemorySegment allocator, @Ref long[] surface);
}
