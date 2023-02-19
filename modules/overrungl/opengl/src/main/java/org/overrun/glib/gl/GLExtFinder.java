/*
 * MIT License
 *
 * Copyright (c) 2023 Overrun Organization
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
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.overrun.glib.gl;

import org.overrun.glib.RuntimeHelper;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

/**
 * The findExtensionGL method is moved to here to bring better performance for the IDE.
 *
 * @author squid233
 * @since 0.1.0
 */
final class GLExtFinder {
    private static boolean getExtensions(SegmentAllocator allocator,
                                         int version,
                                         MemorySegment outExts,
                                         MemorySegment outNumExtsI,
                                         MemorySegment[] outExtsI,
                                         GLCapabilities caps) {
        if (GLLoader.versionMajor(version) < 3) {
            if (caps.glGetString == null) {
                return false;
            }
            outExts.set(ADDRESS, 0, GL10C.ngetString(GLConstC.GL_EXTENSIONS));
        } else {
            if (caps.glGetStringi == null || caps.glGetIntegerv == null) {
                return false;
            }
            int numExtsI = GL10C.getInteger(GLConstC.GL_NUM_EXTENSIONS);
            var extsI = MemorySegment.NULL;
            if (numExtsI > 0) {
                extsI = allocator.allocateArray(ADDRESS, numExtsI);
            }
            if (extsI.address() == RuntimeHelper.NULL) {
                return false;
            }
            for (int index = 0; index < numExtsI; index++) {
                var glStrTmp = GL30C.getStringi(GLConstC.GL_EXTENSIONS, index);
                extsI.setAtIndex(ADDRESS, index, allocator.allocateUtf8String(glStrTmp));
            }
            outNumExtsI.set(JAVA_INT, 0, numExtsI);
            outExtsI[0] = extsI;
        }

        return true;
    }

    private static boolean hasExtension(int version, String exts, int numExtsI, MemorySegment extsI, String ext) {
        if (GLLoader.versionMajor(version) < 3) {
            if (exts == null || ext == null) {
                return false;
            }
            return exts.contains(ext);
        }
        for (int index = 0; index < numExtsI; index++) {
            if (extsI.getAtIndex(RuntimeHelper.ADDRESS_UNBOUNDED, index).getUtf8String(0).equals(ext)) {
                return true;
            }
        }
        return false;
    }

    static boolean findExtensionsGL(GLExtCaps extCaps, int version, SegmentAllocator allocator, GLCapabilities caps) {
        var pExts = allocator.allocate(ADDRESS);
        var pNumExtsI = allocator.allocate(JAVA_INT);
        var pExtsI = new MemorySegment[1];
        if (!getExtensions(allocator, version, pExts, pNumExtsI, pExtsI, caps)) return false;

        String exts = pExts.getUtf8String(0);
        int numExtsI = pNumExtsI.get(JAVA_INT, 0);
        var extsI = pExtsI[0];

        extCaps.GL_3DFX_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_3DFX_multisample");
        extCaps.GL_3DFX_tbuffer = hasExtension(version, exts, numExtsI, extsI, "GL_3DFX_tbuffer");
        extCaps.GL_3DFX_texture_compression_FXT1 = hasExtension(version, exts, numExtsI, extsI, "GL_3DFX_texture_compression_FXT1");
        extCaps.GL_AMD_blend_minmax_factor = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_blend_minmax_factor");
        extCaps.GL_AMD_conservative_depth = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_conservative_depth");
        extCaps.GL_AMD_debug_output = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_debug_output");
        extCaps.GL_AMD_depth_clamp_separate = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_depth_clamp_separate");
        extCaps.GL_AMD_draw_buffers_blend = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_draw_buffers_blend");
        extCaps.GL_AMD_framebuffer_multisample_advanced = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_framebuffer_multisample_advanced");
        extCaps.GL_AMD_framebuffer_sample_positions = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_framebuffer_sample_positions");
        extCaps.GL_AMD_gcn_shader = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gcn_shader");
        extCaps.GL_AMD_gpu_shader_half_float = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gpu_shader_half_float");
        extCaps.GL_AMD_gpu_shader_int16 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gpu_shader_int16");
        extCaps.GL_AMD_gpu_shader_int64 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_gpu_shader_int64");
        extCaps.GL_AMD_interleaved_elements = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_interleaved_elements");
        extCaps.GL_AMD_multi_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_multi_draw_indirect");
        extCaps.GL_AMD_name_gen_delete = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_name_gen_delete");
        extCaps.GL_AMD_occlusion_query_event = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_occlusion_query_event");
        extCaps.GL_AMD_performance_monitor = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_performance_monitor");
        extCaps.GL_AMD_pinned_memory = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_pinned_memory");
        extCaps.GL_AMD_query_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_query_buffer_object");
        extCaps.GL_AMD_sample_positions = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_sample_positions");
        extCaps.GL_AMD_seamless_cubemap_per_texture = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_seamless_cubemap_per_texture");
        extCaps.GL_AMD_shader_atomic_counter_ops = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_atomic_counter_ops");
        extCaps.GL_AMD_shader_ballot = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_ballot");
        extCaps.GL_AMD_shader_explicit_vertex_parameter = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_explicit_vertex_parameter");
        extCaps.GL_AMD_shader_gpu_shader_half_float_fetch = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_gpu_shader_half_float_fetch");
        extCaps.GL_AMD_shader_image_load_store_lod = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_image_load_store_lod");
        extCaps.GL_AMD_shader_stencil_export = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_stencil_export");
        extCaps.GL_AMD_shader_trinary_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_shader_trinary_minmax");
        extCaps.GL_AMD_sparse_texture = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_sparse_texture");
        extCaps.GL_AMD_stencil_operation_extended = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_stencil_operation_extended");
        extCaps.GL_AMD_texture_gather_bias_lod = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_texture_gather_bias_lod");
        extCaps.GL_AMD_texture_texture4 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_texture_texture4");
        extCaps.GL_AMD_transform_feedback3_lines_triangles = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_transform_feedback3_lines_triangles");
        extCaps.GL_AMD_transform_feedback4 = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_transform_feedback4");
        extCaps.GL_AMD_vertex_shader_layer = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_vertex_shader_layer");
        extCaps.GL_AMD_vertex_shader_tessellator = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_vertex_shader_tessellator");
        extCaps.GL_AMD_vertex_shader_viewport_index = hasExtension(version, exts, numExtsI, extsI, "GL_AMD_vertex_shader_viewport_index");
        extCaps.GL_APPLE_aux_depth_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_aux_depth_stencil");
        extCaps.GL_APPLE_client_storage = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_client_storage");
        extCaps.GL_APPLE_element_array = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_element_array");
        extCaps.GL_APPLE_fence = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_fence");
        extCaps.GL_APPLE_float_pixels = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_float_pixels");
        extCaps.GL_APPLE_flush_buffer_range = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_flush_buffer_range");
        extCaps.GL_APPLE_object_purgeable = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_object_purgeable");
        extCaps.GL_APPLE_rgb_422 = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_rgb_422");
        extCaps.GL_APPLE_row_bytes = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_row_bytes");
        extCaps.GL_APPLE_specular_vector = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_specular_vector");
        extCaps.GL_APPLE_texture_range = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_texture_range");
        extCaps.GL_APPLE_transform_hint = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_transform_hint");
        extCaps.GL_APPLE_vertex_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_vertex_array_object");
        extCaps.GL_APPLE_vertex_array_range = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_vertex_array_range");
        extCaps.GL_APPLE_vertex_program_evaluators = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_vertex_program_evaluators");
        extCaps.GL_APPLE_ycbcr_422 = hasExtension(version, exts, numExtsI, extsI, "GL_APPLE_ycbcr_422");
        extCaps.GL_ARB_ES2_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES2_compatibility");
        extCaps.GL_ARB_ES3_1_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES3_1_compatibility");
        extCaps.GL_ARB_ES3_2_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES3_2_compatibility");
        extCaps.GL_ARB_ES3_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_ES3_compatibility");
        extCaps.GL_ARB_arrays_of_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_arrays_of_arrays");
        extCaps.GL_ARB_base_instance = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_base_instance");
        extCaps.GL_ARB_bindless_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_bindless_texture");
        extCaps.GL_ARB_blend_func_extended = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_blend_func_extended");
        extCaps.GL_ARB_buffer_storage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_buffer_storage");
        extCaps.GL_ARB_cl_event = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_cl_event");
        extCaps.GL_ARB_clear_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_clear_buffer_object");
        extCaps.GL_ARB_clear_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_clear_texture");
        extCaps.GL_ARB_clip_control = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_clip_control");
        extCaps.GL_ARB_color_buffer_float = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_color_buffer_float");
        extCaps.GL_ARB_compatibility = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compatibility");
        extCaps.GL_ARB_compressed_texture_pixel_storage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compressed_texture_pixel_storage");
        extCaps.GL_ARB_compute_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compute_shader");
        extCaps.GL_ARB_compute_variable_group_size = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_compute_variable_group_size");
        extCaps.GL_ARB_conditional_render_inverted = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_conditional_render_inverted");
        extCaps.GL_ARB_conservative_depth = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_conservative_depth");
        extCaps.GL_ARB_copy_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_copy_buffer");
        extCaps.GL_ARB_copy_image = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_copy_image");
        extCaps.GL_ARB_cull_distance = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_cull_distance");
        extCaps.GL_ARB_debug_output = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_debug_output");
        extCaps.GL_ARB_depth_buffer_float = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_depth_buffer_float");
        extCaps.GL_ARB_depth_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_depth_clamp");
        extCaps.GL_ARB_depth_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_depth_texture");
        extCaps.GL_ARB_derivative_control = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_derivative_control");
        extCaps.GL_ARB_direct_state_access = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_direct_state_access");
        extCaps.GL_ARB_draw_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_buffers");
        extCaps.GL_ARB_draw_buffers_blend = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_buffers_blend");
        extCaps.GL_ARB_draw_elements_base_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_elements_base_vertex");
        extCaps.GL_ARB_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_indirect");
        extCaps.GL_ARB_draw_instanced = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_draw_instanced");
        extCaps.GL_ARB_enhanced_layouts = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_enhanced_layouts");
        extCaps.GL_ARB_explicit_attrib_location = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_explicit_attrib_location");
        extCaps.GL_ARB_explicit_uniform_location = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_explicit_uniform_location");
        extCaps.GL_ARB_fragment_coord_conventions = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_coord_conventions");
        extCaps.GL_ARB_fragment_layer_viewport = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_layer_viewport");
        extCaps.GL_ARB_fragment_program = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_program");
        extCaps.GL_ARB_fragment_program_shadow = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_program_shadow");
        extCaps.GL_ARB_fragment_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_shader");
        extCaps.GL_ARB_fragment_shader_interlock = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_fragment_shader_interlock");
        extCaps.GL_ARB_framebuffer_no_attachments = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_framebuffer_no_attachments");
        extCaps.GL_ARB_framebuffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_framebuffer_object");
        extCaps.GL_ARB_framebuffer_sRGB = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_framebuffer_sRGB");
        extCaps.GL_ARB_geometry_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_geometry_shader4");
        extCaps.GL_ARB_get_program_binary = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_get_program_binary");
        extCaps.GL_ARB_get_texture_sub_image = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_get_texture_sub_image");
        extCaps.GL_ARB_gl_spirv = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gl_spirv");
        extCaps.GL_ARB_gpu_shader5 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gpu_shader5");
        extCaps.GL_ARB_gpu_shader_fp64 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gpu_shader_fp64");
        extCaps.GL_ARB_gpu_shader_int64 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_gpu_shader_int64");
        extCaps.GL_ARB_half_float_pixel = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_half_float_pixel");
        extCaps.GL_ARB_half_float_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_half_float_vertex");
        extCaps.GL_ARB_imaging = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_imaging");
        extCaps.GL_ARB_indirect_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_indirect_parameters");
        extCaps.GL_ARB_instanced_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_instanced_arrays");
        extCaps.GL_ARB_internalformat_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_internalformat_query");
        extCaps.GL_ARB_internalformat_query2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_internalformat_query2");
        extCaps.GL_ARB_invalidate_subdata = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_invalidate_subdata");
        extCaps.GL_ARB_map_buffer_alignment = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_map_buffer_alignment");
        extCaps.GL_ARB_map_buffer_range = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_map_buffer_range");
        extCaps.GL_ARB_matrix_palette = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_matrix_palette");
        extCaps.GL_ARB_multi_bind = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multi_bind");
        extCaps.GL_ARB_multi_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multi_draw_indirect");
        extCaps.GL_ARB_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multisample");
        extCaps.GL_ARB_multitexture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_multitexture");
        extCaps.GL_ARB_occlusion_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_occlusion_query");
        extCaps.GL_ARB_occlusion_query2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_occlusion_query2");
        extCaps.GL_ARB_parallel_shader_compile = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_parallel_shader_compile");
        extCaps.GL_ARB_pipeline_statistics_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_pipeline_statistics_query");
        extCaps.GL_ARB_pixel_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_pixel_buffer_object");
        extCaps.GL_ARB_point_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_point_parameters");
        extCaps.GL_ARB_point_sprite = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_point_sprite");
        extCaps.GL_ARB_polygon_offset_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_polygon_offset_clamp");
        extCaps.GL_ARB_post_depth_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_post_depth_coverage");
        extCaps.GL_ARB_program_interface_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_program_interface_query");
        extCaps.GL_ARB_provoking_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_provoking_vertex");
        extCaps.GL_ARB_query_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_query_buffer_object");
        extCaps.GL_ARB_robust_buffer_access_behavior = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_robust_buffer_access_behavior");
        extCaps.GL_ARB_robustness = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_robustness");
        extCaps.GL_ARB_robustness_isolation = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_robustness_isolation");
        extCaps.GL_ARB_sample_locations = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sample_locations");
        extCaps.GL_ARB_sample_shading = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sample_shading");
        extCaps.GL_ARB_sampler_objects = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sampler_objects");
        extCaps.GL_ARB_seamless_cube_map = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_seamless_cube_map");
        extCaps.GL_ARB_seamless_cubemap_per_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_seamless_cubemap_per_texture");
        extCaps.GL_ARB_separate_shader_objects = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_separate_shader_objects");
        extCaps.GL_ARB_shader_atomic_counter_ops = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_atomic_counter_ops");
        extCaps.GL_ARB_shader_atomic_counters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_atomic_counters");
        extCaps.GL_ARB_shader_ballot = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_ballot");
        extCaps.GL_ARB_shader_bit_encoding = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_bit_encoding");
        extCaps.GL_ARB_shader_clock = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_clock");
        extCaps.GL_ARB_shader_draw_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_draw_parameters");
        extCaps.GL_ARB_shader_group_vote = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_group_vote");
        extCaps.GL_ARB_shader_image_load_store = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_image_load_store");
        extCaps.GL_ARB_shader_image_size = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_image_size");
        extCaps.GL_ARB_shader_objects = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_objects");
        extCaps.GL_ARB_shader_precision = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_precision");
        extCaps.GL_ARB_shader_stencil_export = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_stencil_export");
        extCaps.GL_ARB_shader_storage_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_storage_buffer_object");
        extCaps.GL_ARB_shader_subroutine = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_subroutine");
        extCaps.GL_ARB_shader_texture_image_samples = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_texture_image_samples");
        extCaps.GL_ARB_shader_texture_lod = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_texture_lod");
        extCaps.GL_ARB_shader_viewport_layer_array = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shader_viewport_layer_array");
        extCaps.GL_ARB_shading_language_100 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_100");
        extCaps.GL_ARB_shading_language_420pack = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_420pack");
        extCaps.GL_ARB_shading_language_include = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_include");
        extCaps.GL_ARB_shading_language_packing = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shading_language_packing");
        extCaps.GL_ARB_shadow = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shadow");
        extCaps.GL_ARB_shadow_ambient = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_shadow_ambient");
        extCaps.GL_ARB_sparse_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_buffer");
        extCaps.GL_ARB_sparse_texture = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_texture");
        extCaps.GL_ARB_sparse_texture2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_texture2");
        extCaps.GL_ARB_sparse_texture_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sparse_texture_clamp");
        extCaps.GL_ARB_spirv_extensions = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_spirv_extensions");
        extCaps.GL_ARB_stencil_texturing = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_stencil_texturing");
        extCaps.GL_ARB_sync = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_sync");
        extCaps.GL_ARB_tessellation_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_tessellation_shader");
        extCaps.GL_ARB_texture_barrier = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_barrier");
        extCaps.GL_ARB_texture_border_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_border_clamp");
        extCaps.GL_ARB_texture_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_buffer_object");
        extCaps.GL_ARB_texture_buffer_object_rgb32 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_buffer_object_rgb32");
        extCaps.GL_ARB_texture_buffer_range = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_buffer_range");
        extCaps.GL_ARB_texture_compression = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_compression");
        extCaps.GL_ARB_texture_compression_bptc = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_compression_bptc");
        extCaps.GL_ARB_texture_compression_rgtc = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_compression_rgtc");
        extCaps.GL_ARB_texture_cube_map = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_cube_map");
        extCaps.GL_ARB_texture_cube_map_array = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_cube_map_array");
        extCaps.GL_ARB_texture_env_add = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_add");
        extCaps.GL_ARB_texture_env_combine = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_combine");
        extCaps.GL_ARB_texture_env_crossbar = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_crossbar");
        extCaps.GL_ARB_texture_env_dot3 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_env_dot3");
        extCaps.GL_ARB_texture_filter_anisotropic = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_filter_anisotropic");
        extCaps.GL_ARB_texture_filter_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_filter_minmax");
        extCaps.GL_ARB_texture_float = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_float");
        extCaps.GL_ARB_texture_gather = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_gather");
        extCaps.GL_ARB_texture_mirror_clamp_to_edge = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_mirror_clamp_to_edge");
        extCaps.GL_ARB_texture_mirrored_repeat = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_mirrored_repeat");
        extCaps.GL_ARB_texture_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_multisample");
        extCaps.GL_ARB_texture_non_power_of_two = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_non_power_of_two");
        extCaps.GL_ARB_texture_query_levels = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_query_levels");
        extCaps.GL_ARB_texture_query_lod = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_query_lod");
        extCaps.GL_ARB_texture_rectangle = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_rectangle");
        extCaps.GL_ARB_texture_rg = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_rg");
        extCaps.GL_ARB_texture_rgb10_a2ui = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_rgb10_a2ui");
        extCaps.GL_ARB_texture_stencil8 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_stencil8");
        extCaps.GL_ARB_texture_storage = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_storage");
        extCaps.GL_ARB_texture_storage_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_storage_multisample");
        extCaps.GL_ARB_texture_swizzle = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_swizzle");
        extCaps.GL_ARB_texture_view = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_texture_view");
        extCaps.GL_ARB_timer_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_timer_query");
        extCaps.GL_ARB_transform_feedback2 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback2");
        extCaps.GL_ARB_transform_feedback3 = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback3");
        extCaps.GL_ARB_transform_feedback_instanced = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback_instanced");
        extCaps.GL_ARB_transform_feedback_overflow_query = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transform_feedback_overflow_query");
        extCaps.GL_ARB_transpose_matrix = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_transpose_matrix");
        extCaps.GL_ARB_uniform_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_uniform_buffer_object");
        extCaps.GL_ARB_vertex_array_bgra = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_array_bgra");
        extCaps.GL_ARB_vertex_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_array_object");
        extCaps.GL_ARB_vertex_attrib_64bit = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_attrib_64bit");
        extCaps.GL_ARB_vertex_attrib_binding = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_attrib_binding");
        extCaps.GL_ARB_vertex_blend = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_blend");
        extCaps.GL_ARB_vertex_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_buffer_object");
        extCaps.GL_ARB_vertex_program = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_program");
        extCaps.GL_ARB_vertex_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_shader");
        extCaps.GL_ARB_vertex_type_10f_11f_11f_rev = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_type_10f_11f_11f_rev");
        extCaps.GL_ARB_vertex_type_2_10_10_10_rev = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_vertex_type_2_10_10_10_rev");
        extCaps.GL_ARB_viewport_array = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_viewport_array");
        extCaps.GL_ARB_window_pos = hasExtension(version, exts, numExtsI, extsI, "GL_ARB_window_pos");
        extCaps.GL_ATI_draw_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_draw_buffers");
        extCaps.GL_ATI_element_array = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_element_array");
        extCaps.GL_ATI_envmap_bumpmap = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_envmap_bumpmap");
        extCaps.GL_ATI_fragment_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_fragment_shader");
        extCaps.GL_ATI_map_object_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_map_object_buffer");
        extCaps.GL_ATI_meminfo = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_meminfo");
        extCaps.GL_ATI_pixel_format_float = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_pixel_format_float");
        extCaps.GL_ATI_pn_triangles = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_pn_triangles");
        extCaps.GL_ATI_separate_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_separate_stencil");
        extCaps.GL_ATI_text_fragment_shader = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_text_fragment_shader");
        extCaps.GL_ATI_texture_env_combine3 = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_texture_env_combine3");
        extCaps.GL_ATI_texture_float = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_texture_float");
        extCaps.GL_ATI_texture_mirror_once = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_texture_mirror_once");
        extCaps.GL_ATI_vertex_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_vertex_array_object");
        extCaps.GL_ATI_vertex_attrib_array_object = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_vertex_attrib_array_object");
        extCaps.GL_ATI_vertex_streams = hasExtension(version, exts, numExtsI, extsI, "GL_ATI_vertex_streams");
        extCaps.GL_EXT_422_pixels = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_422_pixels");
        extCaps.GL_EXT_EGL_image_storage = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_EGL_image_storage");
        extCaps.GL_EXT_EGL_sync = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_EGL_sync");
        extCaps.GL_EXT_abgr = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_abgr");
        extCaps.GL_EXT_bgra = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_bgra");
        extCaps.GL_EXT_bindable_uniform = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_bindable_uniform");
        extCaps.GL_EXT_blend_color = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_color");
        extCaps.GL_EXT_blend_equation_separate = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_equation_separate");
        extCaps.GL_EXT_blend_func_separate = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_func_separate");
        extCaps.GL_EXT_blend_logic_op = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_logic_op");
        extCaps.GL_EXT_blend_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_minmax");
        extCaps.GL_EXT_blend_subtract = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_blend_subtract");
        extCaps.GL_EXT_clip_volume_hint = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_clip_volume_hint");
        extCaps.GL_EXT_cmyka = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_cmyka");
        extCaps.GL_EXT_color_subtable = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_color_subtable");
        extCaps.GL_EXT_compiled_vertex_array = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_compiled_vertex_array");
        extCaps.GL_EXT_convolution = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_convolution");
        extCaps.GL_EXT_coordinate_frame = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_coordinate_frame");
        extCaps.GL_EXT_copy_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_copy_texture");
        extCaps.GL_EXT_cull_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_cull_vertex");
        extCaps.GL_EXT_debug_label = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_debug_label");
        extCaps.GL_EXT_debug_marker = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_debug_marker");
        extCaps.GL_EXT_depth_bounds_test = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_depth_bounds_test");
        extCaps.GL_EXT_direct_state_access = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_direct_state_access");
        extCaps.GL_EXT_draw_buffers2 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_draw_buffers2");
        extCaps.GL_EXT_draw_instanced = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_draw_instanced");
        extCaps.GL_EXT_draw_range_elements = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_draw_range_elements");
        extCaps.GL_EXT_external_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_external_buffer");
        extCaps.GL_EXT_fog_coord = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_fog_coord");
        extCaps.GL_EXT_framebuffer_blit = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_blit");
        extCaps.GL_EXT_framebuffer_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_multisample");
        extCaps.GL_EXT_framebuffer_multisample_blit_scaled = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_multisample_blit_scaled");
        extCaps.GL_EXT_framebuffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_object");
        extCaps.GL_EXT_framebuffer_sRGB = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_framebuffer_sRGB");
        extCaps.GL_EXT_geometry_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_geometry_shader4");
        extCaps.GL_EXT_gpu_program_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_gpu_program_parameters");
        extCaps.GL_EXT_gpu_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_gpu_shader4");
        extCaps.GL_EXT_histogram = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_histogram");
        extCaps.GL_EXT_index_array_formats = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_array_formats");
        extCaps.GL_EXT_index_func = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_func");
        extCaps.GL_EXT_index_material = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_material");
        extCaps.GL_EXT_index_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_index_texture");
        extCaps.GL_EXT_light_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_light_texture");
        extCaps.GL_EXT_memory_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_memory_object");
        extCaps.GL_EXT_memory_object_fd = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_memory_object_fd");
        extCaps.GL_EXT_memory_object_win32 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_memory_object_win32");
        extCaps.GL_EXT_misc_attribute = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_misc_attribute");
        extCaps.GL_EXT_multi_draw_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multi_draw_arrays");
        extCaps.GL_EXT_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multisample");
        extCaps.GL_EXT_multiview_tessellation_geometry_shader = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multiview_tessellation_geometry_shader");
        extCaps.GL_EXT_multiview_texture_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multiview_texture_multisample");
        extCaps.GL_EXT_multiview_timer_query = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_multiview_timer_query");
        extCaps.GL_EXT_packed_depth_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_packed_depth_stencil");
        extCaps.GL_EXT_packed_float = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_packed_float");
        extCaps.GL_EXT_packed_pixels = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_packed_pixels");
        extCaps.GL_EXT_paletted_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_paletted_texture");
        extCaps.GL_EXT_pixel_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_pixel_buffer_object");
        extCaps.GL_EXT_pixel_transform = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_pixel_transform");
        extCaps.GL_EXT_pixel_transform_color_table = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_pixel_transform_color_table");
        extCaps.GL_EXT_point_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_point_parameters");
        extCaps.GL_EXT_polygon_offset = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_polygon_offset");
        extCaps.GL_EXT_polygon_offset_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_polygon_offset_clamp");
        extCaps.GL_EXT_post_depth_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_post_depth_coverage");
        extCaps.GL_EXT_provoking_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_provoking_vertex");
        extCaps.GL_EXT_raster_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_raster_multisample");
        extCaps.GL_EXT_rescale_normal = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_rescale_normal");
        extCaps.GL_EXT_secondary_color = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_secondary_color");
        extCaps.GL_EXT_semaphore = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_semaphore");
        extCaps.GL_EXT_semaphore_fd = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_semaphore_fd");
        extCaps.GL_EXT_semaphore_win32 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_semaphore_win32");
        extCaps.GL_EXT_separate_shader_objects = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_separate_shader_objects");
        extCaps.GL_EXT_separate_specular_color = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_separate_specular_color");
        extCaps.GL_EXT_shader_framebuffer_fetch = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_framebuffer_fetch");
        extCaps.GL_EXT_shader_framebuffer_fetch_non_coherent = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_framebuffer_fetch_non_coherent");
        extCaps.GL_EXT_shader_image_load_formatted = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_image_load_formatted");
        extCaps.GL_EXT_shader_image_load_store = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_image_load_store");
        extCaps.GL_EXT_shader_integer_mix = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shader_integer_mix");
        extCaps.GL_EXT_shadow_funcs = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shadow_funcs");
        extCaps.GL_EXT_shared_texture_palette = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_shared_texture_palette");
        extCaps.GL_EXT_sparse_texture2 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_sparse_texture2");
        extCaps.GL_EXT_stencil_clear_tag = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_stencil_clear_tag");
        extCaps.GL_EXT_stencil_two_side = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_stencil_two_side");
        extCaps.GL_EXT_stencil_wrap = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_stencil_wrap");
        extCaps.GL_EXT_subtexture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_subtexture");
        extCaps.GL_EXT_texture = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture");
        extCaps.GL_EXT_texture3D = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture3D");
        extCaps.GL_EXT_texture_array = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_array");
        extCaps.GL_EXT_texture_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_buffer_object");
        extCaps.GL_EXT_texture_compression_latc = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_compression_latc");
        extCaps.GL_EXT_texture_compression_rgtc = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_compression_rgtc");
        extCaps.GL_EXT_texture_compression_s3tc = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_compression_s3tc");
        extCaps.GL_EXT_texture_cube_map = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_cube_map");
        extCaps.GL_EXT_texture_env_add = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_env_add");
        extCaps.GL_EXT_texture_env_combine = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_env_combine");
        extCaps.GL_EXT_texture_env_dot3 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_env_dot3");
        extCaps.GL_EXT_texture_filter_anisotropic = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_filter_anisotropic");
        extCaps.GL_EXT_texture_filter_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_filter_minmax");
        extCaps.GL_EXT_texture_integer = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_integer");
        extCaps.GL_EXT_texture_lod_bias = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_lod_bias");
        extCaps.GL_EXT_texture_mirror_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_mirror_clamp");
        extCaps.GL_EXT_texture_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_object");
        extCaps.GL_EXT_texture_perturb_normal = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_perturb_normal");
        extCaps.GL_EXT_texture_sRGB = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB");
        extCaps.GL_EXT_texture_sRGB_R8 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB_R8");
        extCaps.GL_EXT_texture_sRGB_RG8 = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB_RG8");
        extCaps.GL_EXT_texture_sRGB_decode = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_sRGB_decode");
        extCaps.GL_EXT_texture_shadow_lod = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_shadow_lod");
        extCaps.GL_EXT_texture_shared_exponent = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_shared_exponent");
        extCaps.GL_EXT_texture_snorm = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_snorm");
        extCaps.GL_EXT_texture_storage = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_storage");
        extCaps.GL_EXT_texture_swizzle = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_texture_swizzle");
        extCaps.GL_EXT_timer_query = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_timer_query");
        extCaps.GL_EXT_transform_feedback = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_transform_feedback");
        extCaps.GL_EXT_vertex_array = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_array");
        extCaps.GL_EXT_vertex_array_bgra = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_array_bgra");
        extCaps.GL_EXT_vertex_attrib_64bit = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_attrib_64bit");
        extCaps.GL_EXT_vertex_shader = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_shader");
        extCaps.GL_EXT_vertex_weighting = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_vertex_weighting");
        extCaps.GL_EXT_win32_keyed_mutex = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_win32_keyed_mutex");
        extCaps.GL_EXT_window_rectangles = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_window_rectangles");
        extCaps.GL_EXT_x11_sync_object = hasExtension(version, exts, numExtsI, extsI, "GL_EXT_x11_sync_object");
        extCaps.GL_GREMEDY_frame_terminator = hasExtension(version, exts, numExtsI, extsI, "GL_GREMEDY_frame_terminator");
        extCaps.GL_GREMEDY_string_marker = hasExtension(version, exts, numExtsI, extsI, "GL_GREMEDY_string_marker");
        extCaps.GL_HP_convolution_border_modes = hasExtension(version, exts, numExtsI, extsI, "GL_HP_convolution_border_modes");
        extCaps.GL_HP_image_transform = hasExtension(version, exts, numExtsI, extsI, "GL_HP_image_transform");
        extCaps.GL_HP_occlusion_test = hasExtension(version, exts, numExtsI, extsI, "GL_HP_occlusion_test");
        extCaps.GL_HP_texture_lighting = hasExtension(version, exts, numExtsI, extsI, "GL_HP_texture_lighting");
        extCaps.GL_IBM_cull_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_cull_vertex");
        extCaps.GL_IBM_multimode_draw_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_multimode_draw_arrays");
        extCaps.GL_IBM_rasterpos_clip = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_rasterpos_clip");
        extCaps.GL_IBM_static_data = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_static_data");
        extCaps.GL_IBM_texture_mirrored_repeat = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_texture_mirrored_repeat");
        extCaps.GL_IBM_vertex_array_lists = hasExtension(version, exts, numExtsI, extsI, "GL_IBM_vertex_array_lists");
        extCaps.GL_INGR_blend_func_separate = hasExtension(version, exts, numExtsI, extsI, "GL_INGR_blend_func_separate");
        extCaps.GL_INGR_color_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_INGR_color_clamp");
        extCaps.GL_INGR_interlace_read = hasExtension(version, exts, numExtsI, extsI, "GL_INGR_interlace_read");
        extCaps.GL_INTEL_blackhole_render = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_blackhole_render");
        extCaps.GL_INTEL_conservative_rasterization = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_conservative_rasterization");
        extCaps.GL_INTEL_fragment_shader_ordering = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_fragment_shader_ordering");
        extCaps.GL_INTEL_framebuffer_CMAA = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_framebuffer_CMAA");
        extCaps.GL_INTEL_map_texture = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_map_texture");
        extCaps.GL_INTEL_parallel_arrays = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_parallel_arrays");
        extCaps.GL_INTEL_performance_query = hasExtension(version, exts, numExtsI, extsI, "GL_INTEL_performance_query");
        extCaps.GL_KHR_blend_equation_advanced = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_blend_equation_advanced");
        extCaps.GL_KHR_blend_equation_advanced_coherent = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_blend_equation_advanced_coherent");
        extCaps.GL_KHR_context_flush_control = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_context_flush_control");
        extCaps.GL_KHR_debug = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_debug");
        extCaps.GL_KHR_no_error = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_no_error");
        extCaps.GL_KHR_parallel_shader_compile = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_parallel_shader_compile");
        extCaps.GL_KHR_robust_buffer_access_behavior = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_robust_buffer_access_behavior");
        extCaps.GL_KHR_robustness = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_robustness");
        extCaps.GL_KHR_shader_subgroup = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_shader_subgroup");
        extCaps.GL_KHR_texture_compression_astc_hdr = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_texture_compression_astc_hdr");
        extCaps.GL_KHR_texture_compression_astc_ldr = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_texture_compression_astc_ldr");
        extCaps.GL_KHR_texture_compression_astc_sliced_3d = hasExtension(version, exts, numExtsI, extsI, "GL_KHR_texture_compression_astc_sliced_3d");
        extCaps.GL_MESAX_texture_stack = hasExtension(version, exts, numExtsI, extsI, "GL_MESAX_texture_stack");
        extCaps.GL_MESA_framebuffer_flip_x = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_framebuffer_flip_x");
        extCaps.GL_MESA_framebuffer_flip_y = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_framebuffer_flip_y");
        extCaps.GL_MESA_framebuffer_swap_xy = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_framebuffer_swap_xy");
        extCaps.GL_MESA_pack_invert = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_pack_invert");
        extCaps.GL_MESA_program_binary_formats = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_program_binary_formats");
        extCaps.GL_MESA_resize_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_resize_buffers");
        extCaps.GL_MESA_shader_integer_functions = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_shader_integer_functions");
        extCaps.GL_MESA_tile_raster_order = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_tile_raster_order");
        extCaps.GL_MESA_window_pos = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_window_pos");
        extCaps.GL_MESA_ycbcr_texture = hasExtension(version, exts, numExtsI, extsI, "GL_MESA_ycbcr_texture");
        extCaps.GL_NVX_blend_equation_advanced_multi_draw_buffers = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_blend_equation_advanced_multi_draw_buffers");
        extCaps.GL_NVX_conditional_render = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_conditional_render");
        extCaps.GL_NVX_gpu_memory_info = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_gpu_memory_info");
        extCaps.GL_NVX_gpu_multicast2 = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_gpu_multicast2");
        extCaps.GL_NVX_linked_gpu_multicast = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_linked_gpu_multicast");
        extCaps.GL_NVX_progress_fence = hasExtension(version, exts, numExtsI, extsI, "GL_NVX_progress_fence");
        extCaps.GL_NV_alpha_to_coverage_dither_control = hasExtension(version, exts, numExtsI, extsI, "GL_NV_alpha_to_coverage_dither_control");
        extCaps.GL_NV_bindless_multi_draw_indirect = hasExtension(version, exts, numExtsI, extsI, "GL_NV_bindless_multi_draw_indirect");
        extCaps.GL_NV_bindless_multi_draw_indirect_count = hasExtension(version, exts, numExtsI, extsI, "GL_NV_bindless_multi_draw_indirect_count");
        extCaps.GL_NV_bindless_texture = hasExtension(version, exts, numExtsI, extsI, "GL_NV_bindless_texture");
        extCaps.GL_NV_blend_equation_advanced = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_equation_advanced");
        extCaps.GL_NV_blend_equation_advanced_coherent = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_equation_advanced_coherent");
        extCaps.GL_NV_blend_minmax_factor = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_minmax_factor");
        extCaps.GL_NV_blend_square = hasExtension(version, exts, numExtsI, extsI, "GL_NV_blend_square");
        extCaps.GL_NV_clip_space_w_scaling = hasExtension(version, exts, numExtsI, extsI, "GL_NV_clip_space_w_scaling");
        extCaps.GL_NV_command_list = hasExtension(version, exts, numExtsI, extsI, "GL_NV_command_list");
        extCaps.GL_NV_compute_program5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_compute_program5");
        extCaps.GL_NV_compute_shader_derivatives = hasExtension(version, exts, numExtsI, extsI, "GL_NV_compute_shader_derivatives");
        extCaps.GL_NV_conditional_render = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conditional_render");
        extCaps.GL_NV_conservative_raster = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster");
        extCaps.GL_NV_conservative_raster_dilate = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_dilate");
        extCaps.GL_NV_conservative_raster_pre_snap = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_pre_snap");
        extCaps.GL_NV_conservative_raster_pre_snap_triangles = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_pre_snap_triangles");
        extCaps.GL_NV_conservative_raster_underestimation = hasExtension(version, exts, numExtsI, extsI, "GL_NV_conservative_raster_underestimation");
        extCaps.GL_NV_copy_depth_to_color = hasExtension(version, exts, numExtsI, extsI, "GL_NV_copy_depth_to_color");
        extCaps.GL_NV_copy_image = hasExtension(version, exts, numExtsI, extsI, "GL_NV_copy_image");
        extCaps.GL_NV_deep_texture3D = hasExtension(version, exts, numExtsI, extsI, "GL_NV_deep_texture3D");
        extCaps.GL_NV_depth_buffer_float = hasExtension(version, exts, numExtsI, extsI, "GL_NV_depth_buffer_float");
        extCaps.GL_NV_depth_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_NV_depth_clamp");
        extCaps.GL_NV_draw_texture = hasExtension(version, exts, numExtsI, extsI, "GL_NV_draw_texture");
        extCaps.GL_NV_draw_vulkan_image = hasExtension(version, exts, numExtsI, extsI, "GL_NV_draw_vulkan_image");
        extCaps.GL_NV_evaluators = hasExtension(version, exts, numExtsI, extsI, "GL_NV_evaluators");
        extCaps.GL_NV_explicit_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_NV_explicit_multisample");
        extCaps.GL_NV_fence = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fence");
        extCaps.GL_NV_fill_rectangle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fill_rectangle");
        extCaps.GL_NV_float_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_NV_float_buffer");
        extCaps.GL_NV_fog_distance = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fog_distance");
        extCaps.GL_NV_fragment_coverage_to_color = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_coverage_to_color");
        extCaps.GL_NV_fragment_program = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program");
        extCaps.GL_NV_fragment_program2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program2");
        extCaps.GL_NV_fragment_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program4");
        extCaps.GL_NV_fragment_program_option = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_program_option");
        extCaps.GL_NV_fragment_shader_barycentric = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_shader_barycentric");
        extCaps.GL_NV_fragment_shader_interlock = hasExtension(version, exts, numExtsI, extsI, "GL_NV_fragment_shader_interlock");
        extCaps.GL_NV_framebuffer_mixed_samples = hasExtension(version, exts, numExtsI, extsI, "GL_NV_framebuffer_mixed_samples");
        extCaps.GL_NV_framebuffer_multisample_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_NV_framebuffer_multisample_coverage");
        extCaps.GL_NV_geometry_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_geometry_program4");
        extCaps.GL_NV_geometry_shader4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_geometry_shader4");
        extCaps.GL_NV_geometry_shader_passthrough = hasExtension(version, exts, numExtsI, extsI, "GL_NV_geometry_shader_passthrough");
        extCaps.GL_NV_gpu_multicast = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_multicast");
        extCaps.GL_NV_gpu_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_program4");
        extCaps.GL_NV_gpu_program5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_program5");
        extCaps.GL_NV_gpu_program5_mem_extended = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_program5_mem_extended");
        extCaps.GL_NV_gpu_shader5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_gpu_shader5");
        extCaps.GL_NV_half_float = hasExtension(version, exts, numExtsI, extsI, "GL_NV_half_float");
        extCaps.GL_NV_internalformat_sample_query = hasExtension(version, exts, numExtsI, extsI, "GL_NV_internalformat_sample_query");
        extCaps.GL_NV_light_max_exponent = hasExtension(version, exts, numExtsI, extsI, "GL_NV_light_max_exponent");
        extCaps.GL_NV_memory_attachment = hasExtension(version, exts, numExtsI, extsI, "GL_NV_memory_attachment");
        extCaps.GL_NV_memory_object_sparse = hasExtension(version, exts, numExtsI, extsI, "GL_NV_memory_object_sparse");
        extCaps.GL_NV_mesh_shader = hasExtension(version, exts, numExtsI, extsI, "GL_NV_mesh_shader");
        extCaps.GL_NV_multisample_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_NV_multisample_coverage");
        extCaps.GL_NV_multisample_filter_hint = hasExtension(version, exts, numExtsI, extsI, "GL_NV_multisample_filter_hint");
        extCaps.GL_NV_occlusion_query = hasExtension(version, exts, numExtsI, extsI, "GL_NV_occlusion_query");
        extCaps.GL_NV_packed_depth_stencil = hasExtension(version, exts, numExtsI, extsI, "GL_NV_packed_depth_stencil");
        extCaps.GL_NV_parameter_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_NV_parameter_buffer_object");
        extCaps.GL_NV_parameter_buffer_object2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_parameter_buffer_object2");
        extCaps.GL_NV_path_rendering = hasExtension(version, exts, numExtsI, extsI, "GL_NV_path_rendering");
        extCaps.GL_NV_path_rendering_shared_edge = hasExtension(version, exts, numExtsI, extsI, "GL_NV_path_rendering_shared_edge");
        extCaps.GL_NV_pixel_data_range = hasExtension(version, exts, numExtsI, extsI, "GL_NV_pixel_data_range");
        extCaps.GL_NV_point_sprite = hasExtension(version, exts, numExtsI, extsI, "GL_NV_point_sprite");
        extCaps.GL_NV_present_video = hasExtension(version, exts, numExtsI, extsI, "GL_NV_present_video");
        extCaps.GL_NV_primitive_restart = hasExtension(version, exts, numExtsI, extsI, "GL_NV_primitive_restart");
        extCaps.GL_NV_primitive_shading_rate = hasExtension(version, exts, numExtsI, extsI, "GL_NV_primitive_shading_rate");
        extCaps.GL_NV_query_resource = hasExtension(version, exts, numExtsI, extsI, "GL_NV_query_resource");
        extCaps.GL_NV_query_resource_tag = hasExtension(version, exts, numExtsI, extsI, "GL_NV_query_resource_tag");
        extCaps.GL_NV_register_combiners = hasExtension(version, exts, numExtsI, extsI, "GL_NV_register_combiners");
        extCaps.GL_NV_register_combiners2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_register_combiners2");
        extCaps.GL_NV_representative_fragment_test = hasExtension(version, exts, numExtsI, extsI, "GL_NV_representative_fragment_test");
        extCaps.GL_NV_robustness_video_memory_purge = hasExtension(version, exts, numExtsI, extsI, "GL_NV_robustness_video_memory_purge");
        extCaps.GL_NV_sample_locations = hasExtension(version, exts, numExtsI, extsI, "GL_NV_sample_locations");
        extCaps.GL_NV_sample_mask_override_coverage = hasExtension(version, exts, numExtsI, extsI, "GL_NV_sample_mask_override_coverage");
        extCaps.GL_NV_scissor_exclusive = hasExtension(version, exts, numExtsI, extsI, "GL_NV_scissor_exclusive");
        extCaps.GL_NV_shader_atomic_counters = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_counters");
        extCaps.GL_NV_shader_atomic_float = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_float");
        extCaps.GL_NV_shader_atomic_float64 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_float64");
        extCaps.GL_NV_shader_atomic_fp16_vector = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_fp16_vector");
        extCaps.GL_NV_shader_atomic_int64 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_atomic_int64");
        extCaps.GL_NV_shader_buffer_load = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_buffer_load");
        extCaps.GL_NV_shader_buffer_store = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_buffer_store");
        extCaps.GL_NV_shader_storage_buffer_object = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_storage_buffer_object");
        extCaps.GL_NV_shader_subgroup_partitioned = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_subgroup_partitioned");
        extCaps.GL_NV_shader_texture_footprint = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_texture_footprint");
        extCaps.GL_NV_shader_thread_group = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_thread_group");
        extCaps.GL_NV_shader_thread_shuffle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shader_thread_shuffle");
        extCaps.GL_NV_shading_rate_image = hasExtension(version, exts, numExtsI, extsI, "GL_NV_shading_rate_image");
        extCaps.GL_NV_stereo_view_rendering = hasExtension(version, exts, numExtsI, extsI, "GL_NV_stereo_view_rendering");
        extCaps.GL_NV_tessellation_program5 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_tessellation_program5");
        extCaps.GL_NV_texgen_emboss = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texgen_emboss");
        extCaps.GL_NV_texgen_reflection = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texgen_reflection");
        extCaps.GL_NV_texture_barrier = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_barrier");
        extCaps.GL_NV_texture_compression_vtc = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_compression_vtc");
        extCaps.GL_NV_texture_env_combine4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_env_combine4");
        extCaps.GL_NV_texture_expand_normal = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_expand_normal");
        extCaps.GL_NV_texture_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_multisample");
        extCaps.GL_NV_texture_rectangle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_rectangle");
        extCaps.GL_NV_texture_rectangle_compressed = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_rectangle_compressed");
        extCaps.GL_NV_texture_shader = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_shader");
        extCaps.GL_NV_texture_shader2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_shader2");
        extCaps.GL_NV_texture_shader3 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_texture_shader3");
        extCaps.GL_NV_timeline_semaphore = hasExtension(version, exts, numExtsI, extsI, "GL_NV_timeline_semaphore");
        extCaps.GL_NV_transform_feedback = hasExtension(version, exts, numExtsI, extsI, "GL_NV_transform_feedback");
        extCaps.GL_NV_transform_feedback2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_transform_feedback2");
        extCaps.GL_NV_uniform_buffer_unified_memory = hasExtension(version, exts, numExtsI, extsI, "GL_NV_uniform_buffer_unified_memory");
        extCaps.GL_NV_vdpau_interop = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vdpau_interop");
        extCaps.GL_NV_vdpau_interop2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vdpau_interop2");
        extCaps.GL_NV_vertex_array_range = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_array_range");
        extCaps.GL_NV_vertex_array_range2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_array_range2");
        extCaps.GL_NV_vertex_attrib_integer_64bit = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_attrib_integer_64bit");
        extCaps.GL_NV_vertex_buffer_unified_memory = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_buffer_unified_memory");
        extCaps.GL_NV_vertex_program = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program");
        extCaps.GL_NV_vertex_program1_1 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program1_1");
        extCaps.GL_NV_vertex_program2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program2");
        extCaps.GL_NV_vertex_program2_option = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program2_option");
        extCaps.GL_NV_vertex_program3 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program3");
        extCaps.GL_NV_vertex_program4 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_vertex_program4");
        extCaps.GL_NV_video_capture = hasExtension(version, exts, numExtsI, extsI, "GL_NV_video_capture");
        extCaps.GL_NV_viewport_array2 = hasExtension(version, exts, numExtsI, extsI, "GL_NV_viewport_array2");
        extCaps.GL_NV_viewport_swizzle = hasExtension(version, exts, numExtsI, extsI, "GL_NV_viewport_swizzle");
        extCaps.GL_OES_byte_coordinates = hasExtension(version, exts, numExtsI, extsI, "GL_OES_byte_coordinates");
        extCaps.GL_OES_compressed_paletted_texture = hasExtension(version, exts, numExtsI, extsI, "GL_OES_compressed_paletted_texture");
        extCaps.GL_OES_fixed_point = hasExtension(version, exts, numExtsI, extsI, "GL_OES_fixed_point");
        extCaps.GL_OES_query_matrix = hasExtension(version, exts, numExtsI, extsI, "GL_OES_query_matrix");
        extCaps.GL_OES_read_format = hasExtension(version, exts, numExtsI, extsI, "GL_OES_read_format");
        extCaps.GL_OES_single_precision = hasExtension(version, exts, numExtsI, extsI, "GL_OES_single_precision");
        extCaps.GL_OML_interlace = hasExtension(version, exts, numExtsI, extsI, "GL_OML_interlace");
        extCaps.GL_OML_resample = hasExtension(version, exts, numExtsI, extsI, "GL_OML_resample");
        extCaps.GL_OML_subsample = hasExtension(version, exts, numExtsI, extsI, "GL_OML_subsample");
        extCaps.GL_OVR_multiview = hasExtension(version, exts, numExtsI, extsI, "GL_OVR_multiview");
        extCaps.GL_OVR_multiview2 = hasExtension(version, exts, numExtsI, extsI, "GL_OVR_multiview2");
        extCaps.GL_PGI_misc_hints = hasExtension(version, exts, numExtsI, extsI, "GL_PGI_misc_hints");
        extCaps.GL_PGI_vertex_hints = hasExtension(version, exts, numExtsI, extsI, "GL_PGI_vertex_hints");
        extCaps.GL_REND_screen_coordinates = hasExtension(version, exts, numExtsI, extsI, "GL_REND_screen_coordinates");
        extCaps.GL_S3_s3tc = hasExtension(version, exts, numExtsI, extsI, "GL_S3_s3tc");
        extCaps.GL_SGIS_detail_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_detail_texture");
        extCaps.GL_SGIS_fog_function = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_fog_function");
        extCaps.GL_SGIS_generate_mipmap = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_generate_mipmap");
        extCaps.GL_SGIS_multisample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_multisample");
        extCaps.GL_SGIS_pixel_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_pixel_texture");
        extCaps.GL_SGIS_point_line_texgen = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_point_line_texgen");
        extCaps.GL_SGIS_point_parameters = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_point_parameters");
        extCaps.GL_SGIS_sharpen_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_sharpen_texture");
        extCaps.GL_SGIS_texture4D = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture4D");
        extCaps.GL_SGIS_texture_border_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_border_clamp");
        extCaps.GL_SGIS_texture_color_mask = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_color_mask");
        extCaps.GL_SGIS_texture_edge_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_edge_clamp");
        extCaps.GL_SGIS_texture_filter4 = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_filter4");
        extCaps.GL_SGIS_texture_lod = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_lod");
        extCaps.GL_SGIS_texture_select = hasExtension(version, exts, numExtsI, extsI, "GL_SGIS_texture_select");
        extCaps.GL_SGIX_async = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_async");
        extCaps.GL_SGIX_async_histogram = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_async_histogram");
        extCaps.GL_SGIX_async_pixel = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_async_pixel");
        extCaps.GL_SGIX_blend_alpha_minmax = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_blend_alpha_minmax");
        extCaps.GL_SGIX_calligraphic_fragment = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_calligraphic_fragment");
        extCaps.GL_SGIX_clipmap = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_clipmap");
        extCaps.GL_SGIX_convolution_accuracy = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_convolution_accuracy");
        extCaps.GL_SGIX_depth_pass_instrument = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_depth_pass_instrument");
        extCaps.GL_SGIX_depth_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_depth_texture");
        extCaps.GL_SGIX_flush_raster = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_flush_raster");
        extCaps.GL_SGIX_fog_offset = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_fog_offset");
        extCaps.GL_SGIX_fragment_lighting = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_fragment_lighting");
        extCaps.GL_SGIX_framezoom = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_framezoom");
        extCaps.GL_SGIX_igloo_interface = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_igloo_interface");
        extCaps.GL_SGIX_instruments = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_instruments");
        extCaps.GL_SGIX_interlace = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_interlace");
        extCaps.GL_SGIX_ir_instrument1 = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ir_instrument1");
        extCaps.GL_SGIX_list_priority = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_list_priority");
        extCaps.GL_SGIX_pixel_texture = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_pixel_texture");
        extCaps.GL_SGIX_pixel_tiles = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_pixel_tiles");
        extCaps.GL_SGIX_polynomial_ffd = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_polynomial_ffd");
        extCaps.GL_SGIX_reference_plane = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_reference_plane");
        extCaps.GL_SGIX_resample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_resample");
        extCaps.GL_SGIX_scalebias_hint = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_scalebias_hint");
        extCaps.GL_SGIX_shadow = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_shadow");
        extCaps.GL_SGIX_shadow_ambient = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_shadow_ambient");
        extCaps.GL_SGIX_sprite = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_sprite");
        extCaps.GL_SGIX_subsample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_subsample");
        extCaps.GL_SGIX_tag_sample_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_tag_sample_buffer");
        extCaps.GL_SGIX_texture_add_env = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_add_env");
        extCaps.GL_SGIX_texture_coordinate_clamp = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_coordinate_clamp");
        extCaps.GL_SGIX_texture_lod_bias = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_lod_bias");
        extCaps.GL_SGIX_texture_multi_buffer = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_multi_buffer");
        extCaps.GL_SGIX_texture_scale_bias = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_texture_scale_bias");
        extCaps.GL_SGIX_vertex_preclip = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_vertex_preclip");
        extCaps.GL_SGIX_ycrcb = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ycrcb");
        extCaps.GL_SGIX_ycrcb_subsample = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ycrcb_subsample");
        extCaps.GL_SGIX_ycrcba = hasExtension(version, exts, numExtsI, extsI, "GL_SGIX_ycrcba");
        extCaps.GL_SGI_color_matrix = hasExtension(version, exts, numExtsI, extsI, "GL_SGI_color_matrix");
        extCaps.GL_SGI_color_table = hasExtension(version, exts, numExtsI, extsI, "GL_SGI_color_table");
        extCaps.GL_SGI_texture_color_table = hasExtension(version, exts, numExtsI, extsI, "GL_SGI_texture_color_table");
        extCaps.GL_SUNX_constant_data = hasExtension(version, exts, numExtsI, extsI, "GL_SUNX_constant_data");
        extCaps.GL_SUN_convolution_border_modes = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_convolution_border_modes");
        extCaps.GL_SUN_global_alpha = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_global_alpha");
        extCaps.GL_SUN_mesh_array = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_mesh_array");
        extCaps.GL_SUN_slice_accum = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_slice_accum");
        extCaps.GL_SUN_triangle_list = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_triangle_list");
        extCaps.GL_SUN_vertex = hasExtension(version, exts, numExtsI, extsI, "GL_SUN_vertex");
        extCaps.GL_WIN_phong_shading = hasExtension(version, exts, numExtsI, extsI, "GL_WIN_phong_shading");
        extCaps.GL_WIN_specular_fog = hasExtension(version, exts, numExtsI, extsI, "GL_WIN_specular_fog");

        return true;
    }
}
