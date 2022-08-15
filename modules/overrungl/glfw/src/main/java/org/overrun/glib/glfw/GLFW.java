package org.overrun.glib.glfw;

import org.jetbrains.annotations.Nullable;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;

import static java.lang.foreign.ValueLayout.*;
import static org.overrun.glib.glfw.Handles.*;

/**
 * The GLFW binding.
 *
 * @author squid233
 * @since 0.1.0
 */
@SuppressWarnings("unused")
//todo
public class GLFW {
    /**
     * The major version number of the GLFW header.
     * <p>
     * This is incremented when the API is changed in non-compatible ways.
     */
    public static final int VERSION_MAJOR = 3;
    /**
     * The minor version number of the GLFW header.
     * <p>
     * This is incremented when features are added to the API, but it remains backward-compatible.
     */
    public static final int VERSION_MINOR = 3;
    /**
     * The revision number of the GLFW header.
     * <p>
     * This is incremented when a bug fix release is made that does not contain any API changes.
     */
    public static final int VERSION_REVISION = 8;

    /**
     * One.
     * <p>
     * This is only semantic sugar for the number 1.  You can instead use {@code 1} or
     * {@code true} or {@code _True} or {@code GL_TRUE} or {@code VK_TRUE} or anything else that is equal
     * to one.
     */
    public static final int TRUE = 1;
    /**
     * Zero.
     * <p>
     * This is only semantic sugar for the number 0.  You can instead use {@code 0} or
     * {@code false} or {@code _False} or {@code GL_FALSE} or {@code VK_FALSE} or anything else that is
     * equal to zero.
     */
    public static final int FALSE = 0;

    /**
     * The key or mouse button was released.
     */
    public static final int RELEASE = 0;
    /**
     * The key or mouse button was pressed.
     */
    public static final int PRESS = 1;
    /**
     * The key was held down until it repeated.
     */
    public static final int REPEAT = 2;

    /**
     * Joystick hat states.
     */
    public static final int HAT_CENTERED = 0,
        HAT_UP = 1,
        HAT_RIGHT = 2,
        HAT_DOWN = 4,
        HAT_LEFT = 8,
        HAT_RIGHT_UP = (HAT_RIGHT | HAT_UP),
        HAT_RIGHT_DOWN = (HAT_RIGHT | HAT_DOWN),
        HAT_LEFT_UP = (HAT_LEFT | HAT_UP),
        HAT_LEFT_DOWN = (HAT_LEFT | HAT_DOWN);


    /**
     * The unknown key
     */
    public static final int KEY_UNKNOWN = -1;

    /**
     * Printable keys
     */
    public static final int KEY_SPACE = 32,
        KEY_APOSTROPHE = 39, /* ' */
        KEY_COMMA = 44, /* , */
        KEY_MINUS = 45, /* - */
        KEY_PERIOD = 46, /* . */
        KEY_SLASH = 47, /* / */
        KEY_0 = 48,
        KEY_1 = 49,
        KEY_2 = 50,
        KEY_3 = 51,
        KEY_4 = 52,
        KEY_5 = 53,
        KEY_6 = 54,
        KEY_7 = 55,
        KEY_8 = 56,
        KEY_9 = 57,
        KEY_SEMICOLON = 59, /* ; */
        KEY_EQUAL = 61, /* = */
        KEY_A = 65,
        KEY_B = 66,
        KEY_C = 67,
        KEY_D = 68,
        KEY_E = 69,
        KEY_F = 70,
        KEY_G = 71,
        KEY_H = 72,
        KEY_I = 73,
        KEY_J = 74,
        KEY_K = 75,
        KEY_L = 76,
        KEY_M = 77,
        KEY_N = 78,
        KEY_O = 79,
        KEY_P = 80,
        KEY_Q = 81,
        KEY_R = 82,
        KEY_S = 83,
        KEY_T = 84,
        KEY_U = 85,
        KEY_V = 86,
        KEY_W = 87,
        KEY_X = 88,
        KEY_Y = 89,
        KEY_Z = 90,
        KEY_LEFT_BRACKET = 91, /* [ */
        KEY_BACKSLASH = 92, /* \ */
        KEY_RIGHT_BRACKET = 93, /* ] */
        KEY_GRAVE_ACCENT = 96, /* ` */
        KEY_WORLD_1 = 161, /* non-US #1 */
        KEY_WORLD_2 = 162; /* non-US #2 */

    /**
     * Function keys
     */
    public static final int KEY_ESCAPE = 256,
        KEY_ENTER = 257,
        KEY_TAB = 258,
        KEY_BACKSPACE = 259,
        KEY_INSERT = 260,
        KEY_DELETE = 261,
        KEY_RIGHT = 262,
        KEY_LEFT = 263,
        KEY_DOWN = 264,
        KEY_UP = 265,
        KEY_PAGE_UP = 266,
        KEY_PAGE_DOWN = 267,
        KEY_HOME = 268,
        KEY_END = 269,
        KEY_CAPS_LOCK = 280,
        KEY_SCROLL_LOCK = 281,
        KEY_NUM_LOCK = 282,
        KEY_PRINT_SCREEN = 283,
        KEY_PAUSE = 284,
        KEY_F1 = 290,
        KEY_F2 = 291,
        KEY_F3 = 292,
        KEY_F4 = 293,
        KEY_F5 = 294,
        KEY_F6 = 295,
        KEY_F7 = 296,
        KEY_F8 = 297,
        KEY_F9 = 298,
        KEY_F10 = 299,
        KEY_F11 = 300,
        KEY_F12 = 301,
        KEY_F13 = 302,
        KEY_F14 = 303,
        KEY_F15 = 304,
        KEY_F16 = 305,
        KEY_F17 = 306,
        KEY_F18 = 307,
        KEY_F19 = 308,
        KEY_F20 = 309,
        KEY_F21 = 310,
        KEY_F22 = 311,
        KEY_F23 = 312,
        KEY_F24 = 313,
        KEY_F25 = 314,
        KEY_KP_0 = 320,
        KEY_KP_1 = 321,
        KEY_KP_2 = 322,
        KEY_KP_3 = 323,
        KEY_KP_4 = 324,
        KEY_KP_5 = 325,
        KEY_KP_6 = 326,
        KEY_KP_7 = 327,
        KEY_KP_8 = 328,
        KEY_KP_9 = 329,
        KEY_KP_DECIMAL = 330,
        KEY_KP_DIVIDE = 331,
        KEY_KP_MULTIPLY = 332,
        KEY_KP_SUBTRACT = 333,
        KEY_KP_ADD = 334,
        KEY_KP_ENTER = 335,
        KEY_KP_EQUAL = 336,
        KEY_LEFT_SHIFT = 340,
        KEY_LEFT_CONTROL = 341,
        KEY_LEFT_ALT = 342,
        KEY_LEFT_SUPER = 343,
        KEY_RIGHT_SHIFT = 344,
        KEY_RIGHT_CONTROL = 345,
        KEY_RIGHT_ALT = 346,
        KEY_RIGHT_SUPER = 347,
        KEY_MENU = 348;

    public static final int KEY_LAST = KEY_MENU;

    /**
     * If this bit is set one or more Shift keys were held down.
     */
    public static final int MOD_SHIFT = 0x0001;
    /**
     * If this bit is set one or more Control keys were held down.
     */
    public static final int MOD_CONTROL = 0x0002;
    /**
     * If this bit is set one or more Alt keys were held down.
     */
    public static final int MOD_ALT = 0x0004;
    /**
     * If this bit is set one or more Super keys were held down.
     */
    public static final int MOD_SUPER = 0x0008;
    /**
     * If this bit is set the Caps Lock key is enabled and the
     * {@link #LOCK_KEY_MODS} input mode is set.
     */
    public static final int MOD_CAPS_LOCK = 0x0010;
    /**
     * If this bit is set the Num Lock key is enabled and the
     * {@link #LOCK_KEY_MODS} input mode is set.
     */
    public static final int MOD_NUM_LOCK = 0x0020;

    /**
     * Mouse button IDs.
     */
    public static final int MOUSE_BUTTON_1 = 0,
        MOUSE_BUTTON_2 = 1,
        MOUSE_BUTTON_3 = 2,
        MOUSE_BUTTON_4 = 3,
        MOUSE_BUTTON_5 = 4,
        MOUSE_BUTTON_6 = 5,
        MOUSE_BUTTON_7 = 6,
        MOUSE_BUTTON_8 = 7,
        MOUSE_BUTTON_LAST = MOUSE_BUTTON_8,
        MOUSE_BUTTON_LEFT = MOUSE_BUTTON_1,
        MOUSE_BUTTON_RIGHT = MOUSE_BUTTON_2,
        MOUSE_BUTTON_MIDDLE = MOUSE_BUTTON_3;

    /**
     * Joystick IDs.
     **/
    public static final int JOYSTICK_1 = 0,
        JOYSTICK_2 = 1,
        JOYSTICK_3 = 2,
        JOYSTICK_4 = 3,
        JOYSTICK_5 = 4,
        JOYSTICK_6 = 5,
        JOYSTICK_7 = 6,
        JOYSTICK_8 = 7,
        JOYSTICK_9 = 8,
        JOYSTICK_10 = 9,
        JOYSTICK_11 = 10,
        JOYSTICK_12 = 11,
        JOYSTICK_13 = 12,
        JOYSTICK_14 = 13,
        JOYSTICK_15 = 14,
        JOYSTICK_16 = 15,
        JOYSTICK_LAST = JOYSTICK_16;

    /**
     * Gamepad buttons.
     */
    public static final int GAMEPAD_BUTTON_A = 0,
        GAMEPAD_BUTTON_B = 1,
        GAMEPAD_BUTTON_X = 2,
        GAMEPAD_BUTTON_Y = 3,
        GAMEPAD_BUTTON_LEFT_BUMPER = 4,
        GAMEPAD_BUTTON_RIGHT_BUMPER = 5,
        GAMEPAD_BUTTON_BACK = 6,
        GAMEPAD_BUTTON_START = 7,
        GAMEPAD_BUTTON_GUIDE = 8,
        GAMEPAD_BUTTON_LEFT_THUMB = 9,
        GAMEPAD_BUTTON_RIGHT_THUMB = 10,
        GAMEPAD_BUTTON_DPAD_UP = 11,
        GAMEPAD_BUTTON_DPAD_RIGHT = 12,
        GAMEPAD_BUTTON_DPAD_DOWN = 13,
        GAMEPAD_BUTTON_DPAD_LEFT = 14,
        GAMEPAD_BUTTON_LAST = GAMEPAD_BUTTON_DPAD_LEFT,

    GAMEPAD_BUTTON_CROSS = GAMEPAD_BUTTON_A,
        GAMEPAD_BUTTON_CIRCLE = GAMEPAD_BUTTON_B,
        GAMEPAD_BUTTON_SQUARE = GAMEPAD_BUTTON_X,
        GAMEPAD_BUTTON_TRIANGLE = GAMEPAD_BUTTON_Y;

    /**
     * Gamepad axes.
     **/
    public static final int GAMEPAD_AXIS_LEFT_X = 0,
        GAMEPAD_AXIS_LEFT_Y = 1,
        GAMEPAD_AXIS_RIGHT_X = 2,
        GAMEPAD_AXIS_RIGHT_Y = 3,
        GAMEPAD_AXIS_LEFT_TRIGGER = 4,
        GAMEPAD_AXIS_RIGHT_TRIGGER = 5,
        GAMEPAD_AXIS_LAST = GAMEPAD_AXIS_RIGHT_TRIGGER;

    /**
     * No error has occurred.
     *
     * <h3>Analysis</h3>
     * Yay.
     */
    public static final int NO_ERROR = 0;
    /**
     * GLFW has not been initialized.
     * <p>
     * This occurs if a GLFW function was called that must not be called unless the
     * library is <a href="https://www.glfw.org/docs/latest/intro_guide.html#intro_init">initialized</a>.
     *
     * <h3>Analysis</h3>
     * Application programmer error. Initialize GLFW before calling any
     * function that requires initialization.
     */
    public static final int NOT_INITIALIZED = 0x00010001;
    /**
     * No context is current for this thread.
     * <p>
     * This occurs if a GLFW function was called that needs and operates on the
     * current OpenGL or OpenGL ES context but no context is current on the calling
     * thread.  One such function is @ref glfwSwapInterval.
     *
     * <h3>Analysis</h3>
     * Application programmer error. Ensure a context is current before
     * calling functions that require a current context.
     */
    public static final int NO_CURRENT_CONTEXT = 0x00010002;
    /**
     * One of the arguments to the function was an invalid enum value, for example
     * requesting {@link #RED_BITS} with {@link #getWindowAttrib}.
     *
     * <h3>Analysis</h3>
     * Application programmer error. Fix the offending call.
     */
    public static final int INVALID_ENUM = 0x00010003;
    /**
     * One of the arguments to the function was an invalid value, for example
     * requesting a non-existent OpenGL or OpenGL ES version like 2.7.
     * <p>
     * Requesting a valid but unavailable OpenGL or OpenGL ES version will instead
     * result in a {@link #VERSION_UNAVAILABLE} error.
     *
     * <h3>Analysis</h3>
     * Application programmer error. Fix the offending call.
     */
    public static final int INVALID_VALUE = 0x00010004;
    /**
     * A memory allocation failed.
     *
     * <h3>Analysis</h3>
     * A bug in GLFW or the underlying operating system. Report the bug
     * to the <a href="https://github.com/glfw/glfw/issues">issue tracker</a>.
     */
    public static final int OUT_OF_MEMORY = 0x00010005;
    /**
     * GLFW could not find support for the requested API on the system.
     *
     * <h3>Analysis</h3>
     * The installed graphics driver does not support the requested
     * API, or does not support it via the chosen context creation backend.
     * Below are a few examples.
     * <p>
     * Some pre-installed Windows graphics drivers do not support OpenGL.  AMD only
     * supports OpenGL ES via EGL, while Nvidia and Intel only support it via
     * a WGL or GLX extension.  macOS does not provide OpenGL ES at all.  The Mesa
     * EGL, OpenGL and OpenGL ES libraries do not interface with the Nvidia binary
     * driver.  Older graphics drivers do not support Vulkan.
     */
    public static final int API_UNAVAILABLE = 0x00010006;
    /**
     * The requested OpenGL or OpenGL ES version (including any requested context
     * or framebuffer hints) is not available on this machine.
     *
     * <h3>Analysis</h3>
     * The machine does not support your requirements.  If your
     * application is sufficiently flexible, downgrade your requirements and try
     * again.  Otherwise, inform the user that their machine does not match your
     * requirements.
     * <p>
     * Future invalid OpenGL and OpenGL ES versions, for example OpenGL 4.8 if 5.0
     * comes out before the 4.x series gets that far, also fail with this error and
     * not {@link #INVALID_VALUE}, because GLFW cannot know what future versions
     * will exist.
     */
    public static final int VERSION_UNAVAILABLE = 0x00010007;
    /**
     * A platform-specific error occurred that does not match any of the more
     * specific categories.
     *
     * <h3>Analysis</h3>
     * A bug or configuration error in GLFW, the underlying operating
     * system or its drivers, or a lack of required resources.  Report the issue to
     * the <a href="https://github.com/glfw/glfw/issues">issue tracker</a>.
     */
    public static final int PLATFORM_ERROR = 0x00010008;
    /**
     * The requested format is not supported or available.
     * <p>
     * If emitted during window creation, the requested pixel format is not
     * supported.
     * <p>
     * If emitted when querying the clipboard, the contents of the clipboard could
     * not be converted to the requested format.
     *
     * <h3>Analysis</h3>
     * If emitted during window creation, one or more
     * <a href="https://www.glfw.org/docs/latest/window_guide.html#window_hints_hard">hard constraints</a> did not match any of the
     * available pixel formats.  If your application is sufficiently flexible,
     * downgrade your requirements and try again.  Otherwise, inform the user that
     * their machine does not match your requirements.
     * <p>
     * If emitted when querying the clipboard, ignore the error or report it to
     * the user, as appropriate.
     */
    public static final int FORMAT_UNAVAILABLE = 0x00010009;
    /**
     * The specified window does not have an OpenGL or OpenGL ES context.
     * <p>
     * A window that does not have an OpenGL or OpenGL ES context was passed to
     * a function that requires it to have one.
     *
     * <h3>Analysis</h3>
     * Application programmer error. Fix the offending call.
     */
    public static final int NO_WINDOW_CONTEXT = 0x0001000A;

    /**
     * <h3>Window related hints</h3>
     * <ul>
     * <li>{@link #RESIZABLE}: specifies whether the windowed mode window will be resizable by the user.
     * The window will still be resizable using the {@link setWindowSize} function.
     * Possible values are {@link #TRUE} and {@link #FALSE}.
     * This hint is ignored for full screen and undecorated windows.</li>
     * <li>{@link #VISIBLE}: specifies whether the windowed mode window will be initially visible.
     * Possible values are {@link #TRUE} and {@link #FALSE}.
     * This hint is ignored for full screen windows.</li>
     * <li>{@link #DECORATED}: specifies whether the windowed mode window will have window decorations such as a border,
     * a close widget, etc. An undecorated window will not be resizable by the user but will still allow the user
     * to generate close events on some platforms. Possible values are {@link #TRUE} and {@link #FALSE}.
     * This hint is ignored for full screen windows.</li>
     * <li>{@link #FOCUSED}: specifies whether the windowed mode window will be given input focus when created.
     * Possible values are {@link #TRUE} and {@link #FALSE}. This hint is ignored for full screen and initially hidden windows.</li>
     * <li>{@link #AUTO_ICONIFY}: specifies whether the full screen window will automatically iconify
     * and restore the previous video mode on input focus loss.
     * Possible values are {@link #TRUE} and {@link #FALSE}.
     * This hint is ignored for windowed mode windows.</li>
     * <li>{@link #FLOATING}: specifies whether the windowed mode window will be floating above other regular windows,
     * also called topmost or always-on-top. This is intended primarily for debugging purposes and cannot be used
     * to implement proper full screen windows. Possible values are {@link #TRUE} and {@link #FALSE}.
     * This hint is ignored for full screen windows.</li>
     * <li>{@link #MAXIMIZED}: specifies whether the windowed mode window will be maximized when created.
     * Possible values are {@link #TRUE} and {@link #FALSE}. This hint is ignored for full screen windows.</li>
     * <li>{@link #CENTER_CURSOR}: specifies whether the cursor should be centered over newly created full screen windows.
     * Possible values are {@link #TRUE} and {@link #FALSE}. This hint is ignored for windowed mode windows.</li>
     * <li>{@link #TRANSPARENT_FRAMEBUFFER}: specifies whether the window framebuffer will be transparent.
     * If enabled and supported by the system, the window framebuffer alpha channel will be used to combine the framebuffer
     * with the background. This does not affect window decorations. Possible values are {@link #TRUE} and {@link #FALSE}.</li>
     * <li>{@link #FOCUS_ON_SHOW}: specifies whether the window will be given input focus when {@link #showWindow} is called.
     * Possible values are {@link #TRUE} and {@link #FALSE}.</li>
     * <li>{@link #SCALE_TO_MONITOR}: specified whether the window content area should be resized based
     * on the <a href="https://www.glfw.org/docs/latest/monitor_guide.html#monitor_scale">monitor content scale</a>
     * of any monitor it is placed on. This includes the initial placement when the window is created.
     * Possible values are {@link #TRUE} and {@link #FALSE}.
     * <p>
     * This hint only has an effect on platforms where screen coordinates and pixels always map 1:1 such as Windows and X11.
     * On platforms like macOS the resolution of the framebuffer is changed independently of the window size.</li>
     * </ul>
     */
    public static final int FOCUSED = 0x00020001,
        ICONIFIED = 0x00020002,
        RESIZABLE = 0x00020003,
        VISIBLE = 0x00020004,
        DECORATED = 0x00020005,
        AUTO_ICONIFY = 0x00020006,
        FLOATING = 0x00020007,
        MAXIMIZED = 0x00020008,
        CENTER_CURSOR = 0x00020009,
        TRANSPARENT_FRAMEBUFFER = 0x0002000A,
        FOCUS_ON_SHOW = 0x0002000C,
        SCALE_TO_MONITOR = 0x0002200C;

    /**
     * <b>HOVERED</b> indicates whether the cursor is currently directly over the content area of the window, with no other windows between.
     * See <a href="https://www.glfw.org/docs/latest/input_guide.html#cursor_enter">Cursor enter/leave events</a> for details.
     */
    public static final int HOVERED = 0x0002000B;

    /**
     * <h3>Framebuffer related hints</h3>
     * <ul>
     * <li>{@link #RED_BITS}, {@link #GREEN_BITS}, {@link #BLUE_BITS}, {@link #ALPHA_BITS}, {@link #DEPTH_BITS} and {@link #STENCIL_BITS}:
     * specify the desired bit depths of the various components of the default framebuffer.
     * A value of {@link #DONT_CARE} means the application has no preference.</li>
     * <li>{@link #ACCUM_RED_BITS}, {@link #ACCUM_GREEN_BITS}, {@link #ACCUM_BLUE_BITS} and {@link #ACCUM_ALPHA_BITS}:
     * specify the desired bit depths of the various components of the accumulation buffer.
     * A value of {@link #DONT_CARE} means the application has no preference.
     * <p>
     * Accumulation buffers are a legacy OpenGL feature and should not be used in new code.</li>
     * <li>{@link #AUX_BUFFERS}: specifies the desired number of auxiliary buffers.
     * A value of {@link #DONT_CARE} means the application has no preference.
     * <p>
     * Auxiliary buffers are a legacy OpenGL feature and should not be used in new code.</li>
     * <li>{@link #STEREO}: specifies whether to use OpenGL stereoscopic rendering.
     * Possible values are {@link #TRUE} and {@link #FALSE}. This is a hard constraint.</li>
     * <li>{@link #SAMPLES}: specifies the desired number of samples to use for multisampling.
     * Zero disables multisampling. A value of {@link #DONT_CARE} means the application has no preference.</li>
     * <li>{@link #SRGB_CAPABLE}: specifies whether the framebuffer should be sRGB capable.
     * Possible values are {@link #TRUE} and {@link #FALSE}.
     * <p>
     * <b>Note</b><br>
     * <b>OpenGL</b>: If enabled and supported by the system,
     * the {@link GL30C#FRAMEBUFFER_SRGB FRAMEBUFFER_SRGB} enable will control sRGB rendering.
     * By default, sRGB rendering will be disabled.<br>
     * <b>OpenGL ES</b>: If enabled and supported by the system, the context will always have sRGB rendering enabled.
     * </li>
     * <li>{@link #DOUBLEBUFFER}: specifies whether the framebuffer should be double buffered.
     * You nearly always want to use double buffering. This is a hard constraint.
     * Possible values are {@link #TRUE} and {@link #FALSE}.</li>
     * </ul>
     */
    public static final int RED_BITS = 0x00021001,
        GREEN_BITS = 0x00021002,
        BLUE_BITS = 0x00021003,
        ALPHA_BITS = 0x00021004,
        DEPTH_BITS = 0x00021005,
        STENCIL_BITS = 0x00021006,
        ACCUM_RED_BITS = 0x00021007,
        ACCUM_GREEN_BITS = 0x00021008,
        ACCUM_BLUE_BITS = 0x00021009,
        ACCUM_ALPHA_BITS = 0x0002100A,
        AUX_BUFFERS = 0x0002100B,
        STEREO = 0x0002100C,
        SAMPLES = 0x0002100D,
        SRGB_CAPABLE = 0x0002100E,
        DOUBLEBUFFER = 0x00021010;

    /**
     * <b>REFRESH_RATE</b> specifies the desired refresh rate for full screen windows.
     * A value of {@link #DONT_CARE} means the highest available refresh rate will be used.
     * This hint is ignored for windowed mode windows.
     */
    public static final int REFRESH_RATE = 0x0002100F;

    /**
     * <h3>Context related hints</h3>
     * <ul>
     * <li>{@link #CLIENT_API}: specifies which client API to create the context for.
     * Possible values are {@link #OPENGL_API}, {@link #OPENGL_ES_API} and {@link #NO_API}.
     * This is a hard constraint.</li>
     * <li>{@link #CONTEXT_CREATION_API}: specifies which context creation API to use to create the context.
     * Possible values are {@link #NATIVE_CONTEXT_API}, {@link #EGL_CONTEXT_API} and {@link #OSMESA_CONTEXT_API}.
     * This is a hard constraint. If no client API is requested, this hint is ignored.
     * <p>
     * An <a href="https://www.glfw.org/docs/latest/context_guide.html#context_glext_auto">extension loader library</a>
     * that assumes it knows which API was used to create the current context may fail if you change this hint.
     * This can be resolved by having it load functions via {@link #getProcAddress}.
     * <p>
     * <b>Note</b><br>
     * <b>Wayland</b>: The EGL API is the native context creation API, so this hint will have no effect.<br>
     * <b>X11</b>: On some Linux systems, creating contexts via both the native and EGL APIs in a single process
     * will cause the application to segfault. Stick to one API or the other on Linux for now.<br>
     * <b>OSMesa</b>: As its name implies, an OpenGL context created with OSMesa does not update the window contents
     * when its buffers are swapped. Use OpenGL functions or the OSMesa native access functions
     * {@link GLFWNative#getOSMesaColorBuffer getOSMesaColorBuffer} and {@link GLFWNative#getOSMesaDepthBuffer getOSMesaDepthBuffer}
     * to retrieve the framebuffer contents.
     * </li>
     * <li>{@link #CONTEXT_VERSION_MAJOR} and {@link #CONTEXT_VERSION_MINOR}: specify the client API version
     * that the created context must be compatible with.
     * The exact behavior of these hints depend on the requested client API.
     * <p>
     * While there is no way to ask the driver for a context of the highest supported version,
     * GLFW will attempt to provide this when you ask for a version 1.0 context,
     * which is the default for these hints.
     * <p>
     * Do not confuse these hints with {@link #VERSION_MAJOR} and {@link #VERSION_MINOR},
     * which provide the API version of the GLFW header.
     * <p>
     * <b>Note</b><br>
     * <b>OpenGL</b>: These hints are not hard constraints, but creation will fail if the OpenGL version
     * of the created context is less than the one requested. It is therefore perfectly safe to use the default
     * of version 1.0 for legacy code and you will still get backwards-compatible contexts of version 3.0 and above when available.<br>
     * <b>OpenGL ES</b>: These hints are not hard constraints, but creation will fail if the OpenGL ES version
     * of the created context is less than the one requested. Additionally, OpenGL ES 1.x cannot be returned
     * if 2.0 or later was requested, and vice versa. This is because OpenGL ES 3.x is backward compatible with 2.0,
     * but OpenGL ES 2.0 is not backward compatible with 1.x.<br>
     * <b>macOS</b>: The OS only supports forward-compatible core profile contexts for OpenGL versions 3.2 and later.
     * Before creating an OpenGL context of version 3.2 or later you must set the {@link #OPENGL_FORWARD_COMPAT}
     * and {@link #OPENGL_PROFILE} hints accordingly. OpenGL 3.0 and 3.1 contexts are not supported at all on macOS.
     * </li>
     * <li>{@link #OPENGL_FORWARD_COMPAT}: specifies whether the OpenGL context should be forward-compatible,
     * i.e. one where all functionality deprecated in the requested version of OpenGL is removed.
     * This must only be used if the requested OpenGL version is 3.0 or above.
     * If OpenGL ES is requested, this hint is ignored.
     * <p>
     * Forward-compatibility is described in detail in the <a href="https://www.opengl.org/registry/">OpenGL Reference Manual</a>.
     * </li>
     * <li>{@link #OPENGL_DEBUG_CONTEXT}: specifies whether the context should be created in debug mode,
     * which may provide additional error and diagnostic reporting functionality. Possible values are {@link #TRUE} and {@link #FALSE}.
     * <p>
     * Debug contexts for OpenGL and OpenGL ES are described in detail
     * by the <a href="https://www.khronos.org/registry/OpenGL/extensions/KHR/KHR_debug.txt">GL_KHR_debug</a> extension.
     * </li>
     * <li>{@link #OPENGL_PROFILE}: specifies which OpenGL profile to create the context for.
     * Possible values are one of {@link #OPENGL_CORE_PROFILE} or {@link #OPENGL_COMPAT_PROFILE},
     * or {@link #OPENGL_ANY_PROFILE} to not request a specific profile. If requesting an OpenGL version below 3.2,
     * {@link #OPENGL_ANY_PROFILE} must be used. If OpenGL ES is requested, this hint is ignored.
     * <p>
     * OpenGL profiles are described in detail in the <a href="https://www.opengl.org/registry/">OpenGL Reference Manual</a>.
     * </li>
     * <li>{@link #CONTEXT_ROBUSTNESS}: specifies the robustness strategy to be used by the context.
     * This can be one of {@link #NO_RESET_NOTIFICATION} or {@link #LOSE_CONTEXT_ON_RESET},
     * or {@link #NO_ROBUSTNESS} to not request a robustness strategy.</li>
     * <li>{@link #CONTEXT_RELEASE_BEHAVIOR}: specifies the release behavior to be used by the context.
     * Possible values are one of {@link #ANY_RELEASE_BEHAVIOR}, {@link #RELEASE_BEHAVIOR_FLUSH} or {@link #RELEASE_BEHAVIOR_NONE}.
     * If the behavior is {@link #ANY_RELEASE_BEHAVIOR}, the default behavior of the context creation API will be used.
     * If the behavior is {@link #RELEASE_BEHAVIOR_FLUSH}, the pipeline will be flushed whenever the context is released from being the current one.
     * If the behavior is {@link #RELEASE_BEHAVIOR_NONE}, the pipeline will not be flushed on release.
     * <p>
     * Context release behaviors are described in detail
     * by the <a href="https://www.opengl.org/registry/specs/KHR/context_flush_control.txt">GL_KHR_context_flush_control</a> extension.
     * </li>
     * <li>{@link #CONTEXT_NO_ERROR}: specifies whether errors should be generated by the context.
     * Possible values are {@link #TRUE} and {@link #FALSE}. If enabled, situations that would have generated errors instead cause undefined behavior.
     * <p>
     * The no error mode for OpenGL and OpenGL ES is described in detail
     * by the <a href="https://www.opengl.org/registry/specs/KHR/no_error.txt">GL_KHR_no_error</a> extension.
     * </li>
     * </ul>
     */
    public static final int CLIENT_API = 0x00022001,
        CONTEXT_VERSION_MAJOR = 0x00022002,
        CONTEXT_VERSION_MINOR = 0x00022003,
        CONTEXT_ROBUSTNESS = 0x00022005,
        OPENGL_FORWARD_COMPAT = 0x00022006,
        OPENGL_DEBUG_CONTEXT = 0x00022007,
        OPENGL_PROFILE = 0x00022008,
        CONTEXT_RELEASE_BEHAVIOR = 0x00022009,
        CONTEXT_NO_ERROR = 0x0002200A,
        CONTEXT_CREATION_API = 0x0002200B;

    /**
     * {@link #CONTEXT_VERSION_MAJOR}, {@link #CONTEXT_VERSION_MINOR} and {@code CONTEXT_REVISION} indicate the client API version of the window's context.
     */
    public static final int CONTEXT_REVISION = 0x00022004;

    /**
     * <h3>macOS specific window hints</h3>
     * <ul>
     * <li>{@link #COCOA_RETINA_FRAMEBUFFER}: specifies whether to use full resolution framebuffers on Retina displays.
     * Possible values are {@link #TRUE} and {@link #FALSE}. This is ignored on other platforms.</li>
     * <li>{@link #COCOA_FRAME_NAME}: specifies the UTF-8 encoded name to use for autosaving the window frame,
     * or if empty disables frame autosaving for the window.
     * This is ignored on other platforms. This is set with {@link #windowHintString}.</li>
     * <li>{@link #COCOA_GRAPHICS_SWITCHING}: specifies whether to in Automatic Graphics Switching,
     * i.e. to allow the system to choose the integrated GPU for the OpenGL context and move it between GPUs
     * if necessary or whether to force it to always run on the discrete GPU. This only affects systems
     * with both integrated and discrete GPUs. Possible values are {@link #TRUE} and {@link #FALSE}.
     * This is ignored on other platforms.
     * <p>
     * Simpler programs and tools may want to enable this to save power,
     * while games and other applications performing advanced rendering will want to leave it disabled.
     * <p>
     * A bundled application that wishes to participate in Automatic Graphics Switching should also declare this
     * in its {@code Info.plist} by setting the {@code NSSupportsAutomaticGraphicsSwitching} key to {@code true}.
     * </li>
     * </ul>
     */
    public static final int COCOA_RETINA_FRAMEBUFFER = 0x00023001,
        COCOA_FRAME_NAME = 0x00023002,
        COCOA_GRAPHICS_SWITCHING = 0x00023003;

    /**
     * <h3>X11 specific window hints</h3>
     * {@link #X11_CLASS_NAME} and {@link #X11_INSTANCE_NAME} specifies the desired ASCII encoded class and instance parts
     * of the ICCCM {@code WM_CLASS} window property. These are set with {@link #windowHintString}.
     */
    public static final int X11_CLASS_NAME = 0x00024001,
        X11_INSTANCE_NAME = 0x00024002;

    /**
     * @see #CLIENT_API
     */
    public static final int NO_API = 0,
        OPENGL_API = 0x00030001,
        OPENGL_ES_API = 0x00030002;

    /**
     * @see #CONTEXT_ROBUSTNESS
     */
    public static final int NO_ROBUSTNESS = 0,
        NO_RESET_NOTIFICATION = 0x00031001,
        LOSE_CONTEXT_ON_RESET = 0x00031002;

    /**
     * @see #OPENGL_PROFILE
     */
    public static final int OPENGL_ANY_PROFILE = 0,
        OPENGL_CORE_PROFILE = 0x00032001,
        OPENGL_COMPAT_PROFILE = 0x00032002;

    public static final int CURSOR = 0x00033001;
    public static final int STICKY_KEYS = 0x00033002;
    public static final int STICKY_MOUSE_BUTTONS = 0x00033003;
    public static final int LOCK_KEY_MODS = 0x00033004;
    public static final int RAW_MOUSE_MOTION = 0x00033005;

    /**
     * <h3>Cursor mode</h3>
     * The {@code CURSOR} input mode provides several cursor modes for special forms of mouse motion input.
     * By default, the cursor mode is {@code CURSOR_NORMAL}, meaning the regular arrow cursor
     * (or another cursor set with {@link #setCursor}) is used and cursor motion is not limited.
     * <p>
     * If you wish to implement mouse motion based camera controls or other input schemes
     * that require unlimited mouse movement, set the cursor mode to {@code CURSOR_DISABLED}.
     * <!-- todo don't use snippet because some bugs -->
     * <pre>{@code
     * GLFW.setInputMode(window, GLFW.CURSOR, GLFW.CURSOR_DISABLED);
     * }</pre>
     * This will hide the cursor and lock it to the specified window. GLFW will then take care of all the details of cursor re-centering
     * and offset calculation and providing the application with a virtual cursor position. This virtual position is provided normally
     * via both the cursor position callback and through polling.
     * <p>
     * <b>Note</b><br>
     * You should not implement your own version of this functionality using other features of GLFW.
     * It is not supported and will not work as robustly as {@code CURSOR_DISABLED}.
     * <p>
     * If you only wish the cursor to become hidden when it is over a window but still want it to behave normally,
     * set the cursor mode to {@code CURSOR_HIDDEN}.
     * <pre>{@code
     * GLFW.setInputMode(window, GLFW.CURSOR, GLFW.CURSOR_HIDDEN);
     * }</pre>
     * This mode puts no limit on the motion of the cursor.
     * <p>
     * To exit out of either of these special modes, restore the {@code CURSOR_NORMAL} cursor mode.
     * <pre>{@code
     * GLFW.setInputMode(window, GLFW.CURSOR, GLFW.CURSOR_NORMAL);
     * }</pre>
     */
    public static final int CURSOR_NORMAL = 0x00034001,
        CURSOR_HIDDEN = 0x00034002,
        CURSOR_DISABLED = 0x00034003;

    public static final int ANY_RELEASE_BEHAVIOR = 0;
    public static final int RELEASE_BEHAVIOR_FLUSH = 0x00035001;
    public static final int RELEASE_BEHAVIOR_NONE = 0x00035002;

    public static final int NATIVE_CONTEXT_API = 0x00036001;
    public static final int EGL_CONTEXT_API = 0x00036002;
    public static final int OSMESA_CONTEXT_API = 0x00036003;

    /**
     * The regular arrow cursor.
     */
    public static final int ARROW_CURSOR = 0x00036001;
    /**
     * The text input I-beam cursor shape.
     */
    public static final int IBEAM_CURSOR = 0x00036002;
    /**
     * The crosshair shape.
     */
    public static final int CROSSHAIR_CURSOR = 0x00036003;
    /**
     * The hand shape.
     */
    public static final int HAND_CURSOR = 0x00036004;
    /**
     * The horizontal resize arrow shape.
     */
    public static final int HRESIZE_CURSOR = 0x00036005;
    /**
     * The vertical resize arrow shape.
     */
    public static final int VRESIZE_CURSOR = 0x00036006;

    public static final int CONNECTED = 0x00040001;
    public static final int DISCONNECTED = 0x00040002;

    /**
     * {@code JOYSTICK_HAT_BUTTONS} specifies whether to also expose joystick hats as buttons,
     * for compatibility with earlier versions of GLFW that did not have {@link #getJoystickHats}.
     * Possible values are {@link #TRUE} and {@link #FALSE}.
     */
    public static final int JOYSTICK_HAT_BUTTONS = 0x00050001;
    /**
     * <h3>macOS specific init hints</h3>
     * <ul>
     * <li>{@link #COCOA_CHDIR_RESOURCES}: specifies whether to set the current directory to the application
     * to the {@code Contents/Resources} subdirectory of the application's bundle, if present. Set this with {@link #initHint}.</li>
     * <li>{@link #COCOA_MENUBAR}: specifies whether to create a basic menu bar, either from a nib or manually,
     * when the first window is created, which is when AppKit is initialized. Set this with {@link #initHint}.</li>
     * </ul>
     */
    public static final int COCOA_CHDIR_RESOURCES = 0x00051001,
        COCOA_MENUBAR = 0x00051002;

    public static final int DONT_CARE = -1;

    static {
        create();
    }

    /**
     * Initializes the GLFW library.
     * <p>
     * This function initializes the GLFW library.  Before most GLFW functions can
     * be used, GLFW must be initialized, and before an application terminates GLFW
     * should be terminated in order to free any resources allocated during or
     * after initialization.
     * <p>
     * If this function fails, it calls {@link #terminate} before returning.  If it
     * succeeds, you should call {@link #terminate} before the application exits.
     * <p>
     * Additional calls to this function after successful initialization but before
     * termination will return {@code TRUE} immediately.
     *
     * <h3>Errors</h3>
     * Possible errors include {@link #PLATFORM_ERROR}.
     *
     * <h3>Remarks</h3>
     * <b>macOS</b>: This function will change the current directory of the
     * application to the {@code Contents/Resources} subdirectory of the application's
     * bundle, if present.  This can be disabled with the
     * {@link #COCOA_CHDIR_RESOURCES} init hint.<br>
     * <b>X11</b>: This function will set the {@code LC_CTYPE} category of the
     * application locale according to the current environment if that category is
     * still "C".  This is because the "C" locale breaks Unicode text input.
     *
     * <h3>Thread safety</h3>
     * This function must only be called from the main thread.
     *
     * @return {@code TRUE} if successful, or {@code FALSE} if an
     * <a href="https://www.glfw.org/docs/latest/intro_guide.html#error_handling">error</a> occurred.
     * @throws Throwable anything thrown by the underlying method propagates unchanged through the method handle call
     * @see #terminate
     */
    public static boolean init() throws Throwable {
        return (int) glfwInit.invoke() == TRUE;
    }

    /**
     * Terminates the GLFW library.
     * <p>
     * This function destroys all remaining windows and cursors, restores any
     * modified gamma ramps and frees any other allocated resources.  Once this
     * function is called, you must again call {@link #init} successfully before
     * you will be able to use most GLFW functions.
     * <p>
     * If GLFW has been successfully initialized, this function should be called
     * before the application exits.  If initialization fails, there is no need to
     * call this function, as it is called by {@link #init} before it returns
     * failure.
     * <p>
     * This function has no effect if GLFW is not initialized.
     *
     * <h3>Errors</h3>
     * Possible errors include {@link #PLATFORM_ERROR}.
     *
     * <h3>Remarks</h3>
     * This function may be called before {@link #init}.
     *
     * <h3>Warning</h3>
     * The contexts of any remaining windows must not be current on any
     * other thread when this function is called.
     *
     * <h3>Reentrancy</h3>
     * This function must not be called from a callback.
     *
     * <h3>Thread safety</h3>
     * This function must only be called from the main thread.
     *
     * @throws Throwable anything thrown by the underlying method propagates unchanged through the method handle call
     * @see #init
     */
    public static void terminate() throws Throwable {
        glfwTerminate.invoke();
    }

    public static void initHint(int hint, int value) throws Throwable {
        glfwInitHint.invoke(hint, value);
    }

    public static void ngetVersion(MemoryAddress major, MemoryAddress minor, MemoryAddress rev) throws Throwable {
        glfwGetVersion.invoke(major, minor, rev);
    }

    public static void getVersion(int @Nullable [] major, int @Nullable [] minor, int @Nullable [] rev) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pMajor = major != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var pMinor = minor != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var pRev = rev != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetVersion(pMajor, pMinor, pRev);
            if (major != null && major.length > 0) {
                major[0] = pMajor.get(JAVA_INT, 0L);
            }
            if (minor != null && minor.length > 0) {
                minor[0] = pMinor.get(JAVA_INT, 0L);
            }
            if (rev != null && rev.length > 0) {
                rev[0] = pRev.get(JAVA_INT, 0L);
            }
        }
    }

    public static MemoryAddress ngetVersionString() throws Throwable {
        return (MemoryAddress) glfwGetVersionString.invoke();
    }

    public static String getVersionString() throws Throwable {
        return ngetVersionString().getUtf8String(0L);
    }

    public static int ngetError(MemoryAddress description) throws Throwable {
        return (int) glfwGetError.invoke(description);
    }

    public static int getError(String @Nullable [] description) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pDesc = description != null ? session.allocate(ADDRESS).address() : MemoryAddress.NULL;
            int err = ngetError(pDesc);
            if (description != null && description.length > 0) {
                description[0] = pDesc.get(ADDRESS, 0L).getUtf8String(0L);
            }
            return err;
        }
    }

    public static MemoryAddress nsetErrorCallback(MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetErrorCallback.invoke(callback);
    }

    public static MemoryAddress setErrorCallback(@Nullable IGLFWErrorFun callback) throws Throwable {
        return nsetErrorCallback(callback != null ? callback.address(MemorySession.global()) : MemoryAddress.NULL);
    }

    public static MemoryAddress ngetMonitors(MemoryAddress count) throws Throwable {
        return (MemoryAddress) glfwGetMonitors.invoke(count);
    }

    public static MemoryAddress @Nullable [] getMonitors() throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pCount = session.allocate(JAVA_INT);
            var pMonitors = ngetMonitors(pCount.address());
            if (pMonitors == MemoryAddress.NULL) {
                return null;
            }
            MemoryAddress[] monitors = new MemoryAddress[pCount.get(JAVA_INT, 0L)];
            for (int i = 0; i < monitors.length; i++) {
                monitors[i] = pMonitors.getAtIndex(ADDRESS, i);
            }
            return monitors;
        }
    }

    public static MemoryAddress getPrimaryMonitor() throws Throwable {
        return (MemoryAddress) glfwGetPrimaryMonitor.invoke();
    }

    public static void ngetMonitorPos(MemoryAddress monitor, MemoryAddress xpos, MemoryAddress ypos) throws Throwable {
        glfwGetMonitorPos.invoke(monitor, xpos, ypos);
    }

    public static void getMonitorPos(MemoryAddress monitor, int @Nullable [] xpos, int @Nullable [] ypos) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var px = xpos != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var py = ypos != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetMonitorPos(monitor, px, py);
            if (xpos != null && xpos.length > 0) {
                xpos[0] = px.get(JAVA_INT, 0L);
            }
            if (ypos != null && ypos.length > 0) {
                ypos[0] = py.get(JAVA_INT, 0L);
            }
        }
    }

    public static void ngetMonitorWorkarea(MemoryAddress monitor, MemoryAddress xpos, MemoryAddress ypos, MemoryAddress width, MemoryAddress height) throws Throwable {
        glfwGetMonitorWorkarea.invoke(monitor, xpos, ypos, width, height);
    }

    public static void getMonitorWorkarea(MemoryAddress monitor, int @Nullable [] xpos, int @Nullable [] ypos, int @Nullable [] width, int @Nullable [] height) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var px = xpos != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var py = ypos != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var pw = width != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var ph = height != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetMonitorWorkarea(monitor, px, py, pw, ph);
            if (xpos != null && xpos.length > 0) {
                xpos[0] = px.get(JAVA_INT, 0L);
            }
            if (ypos != null && ypos.length > 0) {
                ypos[0] = py.get(JAVA_INT, 0L);
            }
            if (width != null && width.length > 0) {
                width[0] = pw.get(JAVA_INT, 0L);
            }
            if (height != null && height.length > 0) {
                height[0] = ph.get(JAVA_INT, 0L);
            }
        }
    }

    public static void ngetMonitorPhysicalSize(MemoryAddress monitor, MemoryAddress widthMM, MemoryAddress heightMM) throws Throwable {
        glfwGetMonitorPhysicalSize.invoke(monitor, widthMM, heightMM);
    }

    public static void getMonitorPhysicalSize(MemoryAddress monitor, int @Nullable [] widthMM, int @Nullable [] heightMM) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pw = widthMM != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var ph = heightMM != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetMonitorPhysicalSize(monitor, pw, ph);
            if (widthMM != null && widthMM.length > 0) {
                widthMM[0] = pw.get(JAVA_INT, 0L);
            }
            if (heightMM != null && heightMM.length > 0) {
                heightMM[0] = ph.get(JAVA_INT, 0L);
            }
        }
    }

    public static void ngetMonitorContentScale(MemoryAddress monitor, MemoryAddress xscale, MemoryAddress yscale) throws Throwable {
        glfwGetMonitorContentScale.invoke(monitor, xscale, yscale);
    }

    public static void getMonitorContentScale(MemoryAddress monitor, float @Nullable [] xscale, float @Nullable [] yscale) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var px = xscale != null ? session.allocate(JAVA_FLOAT).address() : MemoryAddress.NULL;
            var py = yscale != null ? session.allocate(JAVA_FLOAT).address() : MemoryAddress.NULL;
            ngetMonitorContentScale(monitor, px, py);
            if (xscale != null && xscale.length > 0) {
                xscale[0] = px.get(JAVA_FLOAT, 0L);
            }
            if (yscale != null && yscale.length > 0) {
                yscale[0] = py.get(JAVA_FLOAT, 0L);
            }
        }
    }

    public static MemoryAddress ngetMonitorName(MemoryAddress monitor) throws Throwable {
        return (MemoryAddress) glfwGetMonitorName.invoke(monitor);
    }

    @Nullable
    public static String getMonitorName(MemoryAddress monitor) throws Throwable {
        var pName = ngetMonitorName(monitor);
        return pName != MemoryAddress.NULL ? pName.getUtf8String(0L) : null;
    }

    public static void setMonitorUserPointer(MemoryAddress monitor, MemoryAddress pointer) throws Throwable {
        glfwSetMonitorUserPointer.invoke(monitor, pointer);
    }

    public static MemoryAddress getMonitorUserPointer(MemoryAddress monitor) throws Throwable {
        return (MemoryAddress) glfwGetMonitorUserPointer.invoke(monitor);
    }

    public static MemoryAddress nsetMonitorCallback(MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetMonitorCallback.invoke(callback);
    }

    public static MemoryAddress setMonitorCallback(@Nullable IGLFWMonitorFun callback) throws Throwable {
        return nsetMonitorCallback(callback != null ? callback.address(MemorySession.global()) : MemoryAddress.NULL);
    }

    public static MemoryAddress ngetVideoModes(MemoryAddress monitor, MemoryAddress count) throws Throwable {
        return (MemoryAddress) glfwGetVideoModes.invoke(monitor, count);
    }

    public static GLFWVidMode @Nullable [] getVideoModes(MemoryAddress monitor) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pCount = session.allocate(JAVA_INT);
            var pModes = ngetVideoModes(monitor, pCount.address());
            if (pModes == MemoryAddress.NULL) {
                return null;
            }
            GLFWVidMode[] modes = new GLFWVidMode[pCount.get(JAVA_INT, 0L)];
            for (int i = 0; i < modes.length; i++) {
                var pMode = pModes.getAtIndex(ADDRESS, i);
                modes[i] = new GLFWVidMode(pMode);
            }
            return modes;
        }
    }

    public static MemoryAddress ngetVideoMode(MemoryAddress monitor) throws Throwable {
        return (MemoryAddress) glfwGetVideoMode.invoke(monitor);
    }

    @Nullable
    public static GLFWVidMode getVideoMode(MemoryAddress monitor) throws Throwable {
        var pMode = ngetVideoMode(monitor);
        return pMode != MemoryAddress.NULL ? new GLFWVidMode(pMode) : null;
    }

    public static void setGamma(MemoryAddress monitor, float gamma) throws Throwable {
        glfwSetGamma.invoke(monitor, gamma);
    }

    public static MemoryAddress ngetGammaRamp(MemoryAddress monitor) throws Throwable {
        return (MemoryAddress) glfwGetGammaRamp.invoke(monitor);
    }

    @Nullable
    public static GLFWGammaRamp getGammaRamp(MemoryAddress monitor) throws Throwable {
        var pRamp = ngetGammaRamp(monitor);
        return pRamp != MemoryAddress.NULL ? new GLFWGammaRamp(pRamp) : null;
    }

    public static void setGammaRamp(MemoryAddress monitor, GLFWGammaRamp ramp) throws Throwable {
        glfwSetGammaRamp.invoke(monitor, ramp.address());
    }

    public static void defaultWindowHints() throws Throwable {
        glfwDefaultWindowHints.invoke();
    }

    public static void windowHint(int hint, int value) throws Throwable {
        glfwWindowHint.invoke(hint, value);
    }

    public static void windowHint(int hint, boolean value) throws Throwable {
        windowHint(hint, value ? TRUE : FALSE);
    }

    public static void nwindowHintString(int hint, MemoryAddress value) throws Throwable {
        glfwWindowHintString.invoke(hint, value);
    }

    public static void windowHintString(int hint, String value) throws Throwable {
        try (var session = MemorySession.openShared()) {
            nwindowHintString(hint, session.allocateUtf8String(value).address());
        }
    }

    public static MemoryAddress ncreateWindow(int width, int height, MemoryAddress title, MemoryAddress monitor, MemoryAddress share) throws Throwable {
        return (MemoryAddress) glfwCreateWindow.invoke(width, height, title, monitor, share);
    }

    public static MemoryAddress createWindow(int width, int height, String title, MemoryAddress monitor, MemoryAddress share) throws Throwable {
        try (var session = MemorySession.openShared()) {
            return ncreateWindow(width, height, session.allocateUtf8String(title).address(), monitor, share);
        }
    }

    public static void destroyWindow(MemoryAddress window) throws Throwable {
        glfwDestroyWindow.invoke(window);
    }

    public static boolean windowShouldClose(MemoryAddress window) throws Throwable {
        return (int) glfwWindowShouldClose.invoke(window) == TRUE;
    }

    public static void setWindowShouldClose(MemoryAddress window, boolean value) throws Throwable {
        glfwSetWindowShouldClose.invoke(window, value ? TRUE : FALSE);
    }

    public static void nsetWindowTitle(MemoryAddress window, MemoryAddress title) throws Throwable {
        glfwSetWindowTitle.invoke(window, title);
    }

    public static void setWindowTitle(MemoryAddress window, String title) throws Throwable {
        try (var session = MemorySession.openShared()) {
            nsetWindowTitle(window, session.allocateUtf8String(title).address());
        }
    }

    public static void nsetWindowIcon(MemoryAddress window, int count, MemoryAddress images) throws Throwable {
        glfwSetWindowIcon.invoke(window, count, images);
    }

    public static void setWindowIcon(MemoryAddress window, int count, GLFWImage[] images) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pImages = session.allocateArray(ADDRESS, count);
            for (int i = 0; i < count; i++) {
                pImages.setAtIndex(ADDRESS, i, images[i].address());
            }
            nsetWindowIcon(window, count, pImages.address());
        }
    }

    public static void setWindowIcon(MemoryAddress window, GLFWImage[] images) throws Throwable {
        setWindowIcon(window, images.length, images);
    }

    public static void ngetWindowPos(MemoryAddress window, MemoryAddress xpos, MemoryAddress ypos) throws Throwable {
        glfwGetWindowPos.invoke(window, xpos, ypos);
    }

    public static void getWindowPos(MemoryAddress window, int @Nullable [] xpos, int @Nullable [] ypos) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var px = xpos != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var py = ypos != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetWindowPos(window, px, py);
            if (xpos != null && xpos.length > 1) {
                xpos[0] = px.get(JAVA_INT, 0L);
            }
            if (ypos != null && ypos.length > 1) {
                ypos[0] = py.get(JAVA_INT, 0L);
            }
        }
    }

    public static void setWindowPos(MemoryAddress window, int xpos, int ypos) throws Throwable {
        glfwSetWindowPos.invoke(window, xpos, ypos);
    }

    public static void ngetWindowSize(MemoryAddress window, MemoryAddress width, MemoryAddress height) throws Throwable {
        glfwGetWindowSize.invoke(window, width, height);
    }

    public static void getWindowSize(MemoryAddress window, int @Nullable [] width, int @Nullable [] height) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pw = width != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var ph = height != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetWindowSize(window, pw, ph);
            if (width != null && width.length > 0) {
                width[0] = pw.get(JAVA_INT, 0);
            }
            if (height != null && height.length > 0) {
                height[0] = ph.get(JAVA_INT, 0);
            }
        }
    }

    public static void setWindowSizeLimits(MemoryAddress window, int minWidth, int minHeight, int maxWidth, int maxHeight) throws Throwable {
        glfwSetWindowSizeLimits.invoke(window, minWidth, minHeight, maxWidth, maxHeight);
    }

    public static void setWindowAspectRatio(MemoryAddress window, int numer, int denom) throws Throwable {
        glfwSetWindowAspectRatio.invoke(window, numer, denom);
    }

    public static void setWindowSize(MemoryAddress window, int width, int height) throws Throwable {
        glfwSetWindowSize.invoke(window, width, height);
    }

    public static void ngetFramebufferSize(MemoryAddress window, MemoryAddress width, MemoryAddress height) throws Throwable {
        glfwGetFramebufferSize.invoke(window, width, height);
    }

    public static void getFramebufferSize(MemoryAddress window, int @Nullable [] width, int @Nullable [] height) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pw = width != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var ph = height != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetFramebufferSize(window, pw, ph);
            if (width != null && width.length > 0) {
                width[0] = pw.get(JAVA_INT, 0L);
            }
            if (height != null && height.length > 0) {
                height[0] = ph.get(JAVA_INT, 0L);
            }
        }
    }

    public static void ngetWindowFrameSize(MemoryAddress window, MemoryAddress left, MemoryAddress top, MemoryAddress right, MemoryAddress bottom) throws Throwable {
        glfwGetWindowFrameSize.invoke(window, left, top, right, bottom);
    }

    public static void getWindowFrameSize(MemoryAddress window, int @Nullable [] left, int @Nullable [] top, int @Nullable [] right, int @Nullable [] bottom) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pl = left != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var pt = top != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var pr = right != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            var pb = bottom != null ? session.allocate(JAVA_INT).address() : MemoryAddress.NULL;
            ngetWindowFrameSize(window, pl, pt, pr, pb);
            if (left != null && left.length > 0) {
                left[0] = pl.get(JAVA_INT, 0L);
            }
            if (top != null && top.length > 0) {
                top[0] = pt.get(JAVA_INT, 0L);
            }
            if (right != null && right.length > 0) {
                right[0] = pr.get(JAVA_INT, 0L);
            }
            if (bottom != null && bottom.length > 0) {
                bottom[0] = pb.get(JAVA_INT, 0L);
            }
        }
    }

    public static void ngetWindowContentScale(MemoryAddress window, MemoryAddress xscale, MemoryAddress yscale) throws Throwable {
        glfwGetWindowContentScale.invoke(window, xscale, yscale);
    }

    public static void getWindowContentScale(MemoryAddress window, float @Nullable [] xscale, float @Nullable [] yscale) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var px = xscale != null ? session.allocate(JAVA_FLOAT).address() : MemoryAddress.NULL;
            var py = yscale != null ? session.allocate(JAVA_FLOAT).address() : MemoryAddress.NULL;
            ngetWindowContentScale(window, px, py);
            if (xscale != null && xscale.length > 0) {
                xscale[0] = px.get(JAVA_FLOAT, 0L);
            }
            if (yscale != null && yscale.length > 0) {
                yscale[0] = py.get(JAVA_FLOAT, 0L);
            }
        }
    }

    public static float getWindowOpacity(MemoryAddress window) throws Throwable {
        return (float) glfwGetWindowOpacity.invoke(window);
    }

    public static void setWindowOpacity(MemoryAddress window, float opacity) throws Throwable {
        glfwSetWindowOpacity.invoke(window, opacity);
    }

    public static void iconifyWindow(MemoryAddress window) throws Throwable {
        glfwIconifyWindow.invoke(window);
    }

    public static void restoreWindow(MemoryAddress window) throws Throwable {
        glfwRestoreWindow.invoke(window);
    }

    public static void maximizeWindow(MemoryAddress window) throws Throwable {
        glfwMaximizeWindow.invoke(window);
    }

    public static void showWindow(MemoryAddress window) throws Throwable {
        glfwShowWindow.invoke(window);
    }

    public static void hideWindow(MemoryAddress window) throws Throwable {
        glfwHideWindow.invoke(window);
    }

    public static void focusWindow(MemoryAddress window) throws Throwable {
        glfwFocusWindow.invoke(window);
    }

    public static void requestWindowAttention(MemoryAddress window) throws Throwable {
        glfwRequestWindowAttention.invoke(window);
    }

    public static MemoryAddress getWindowMonitor(MemoryAddress window) throws Throwable {
        return (MemoryAddress) glfwGetWindowMonitor.invoke(window);
    }

    public static void setWindowMonitor(MemoryAddress window, MemoryAddress monitor, int xpos, int ypos, int width, int height, int refreshRate) throws Throwable {
        glfwGetWindowMonitor.invoke(window, monitor, xpos, ypos, width, height, refreshRate);
    }

    public static int getWindowAttrib(MemoryAddress window, int attrib) throws Throwable {
        return (int) glfwGetWindowAttrib.invoke(window, attrib);
    }

    public static void setWindowAttrib(MemoryAddress window, int attrib, boolean value) throws Throwable {
        glfwSetWindowAttrib.invoke(window, attrib, value ? TRUE : FALSE);
    }

    public static void setWindowUserPointer(MemoryAddress window, MemoryAddress pointer) throws Throwable {
        glfwSetWindowUserPointer.invoke(window, pointer);
    }

    public static MemoryAddress getWindowUserPointer(MemoryAddress window) throws Throwable {
        return (MemoryAddress) glfwSetWindowUserPointer.invoke(window);
    }

    public static MemoryAddress nsetWindowPosCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowPosCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowPosCallback(MemoryAddress window, @Nullable IGLFWWindowPosFun callback) throws Throwable {
        return nsetWindowPosCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetWindowSizeCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowSizeCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowSizeCallback(MemoryAddress window, @Nullable IGLFWWindowSizeFun callback) throws Throwable {
        return nsetWindowSizeCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetWindowCloseCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowCloseCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowCloseCallback(MemoryAddress window, @Nullable IGLFWWindowCloseFun callback) throws Throwable {
        return nsetWindowCloseCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetWindowRefreshCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowRefreshCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowRefreshCallback(MemoryAddress window, @Nullable IGLFWWindowRefreshFun callback) throws Throwable {
        return nsetWindowRefreshCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetWindowFocusCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowFocusCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowFocusCallback(MemoryAddress window, @Nullable IGLFWWindowFocusFun callback) throws Throwable {
        return nsetWindowFocusCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetWindowIconifyCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowIconifyCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowIconifyCallback(MemoryAddress window, @Nullable IGLFWWindowIconifyFun callback) throws Throwable {
        return nsetWindowIconifyCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetWindowMaximizeCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowMaximizeCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowMaximizeCallback(MemoryAddress window, @Nullable IGLFWWindowMaximizeFun callback) throws Throwable {
        return nsetWindowMaximizeCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetFramebufferSizeCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetFramebufferSizeCallback.invoke(window, callback);
    }

    public static MemoryAddress setFramebufferSizeCallback(MemoryAddress window, @Nullable IGLFWFramebufferSizeFun callback) throws Throwable {
        return nsetFramebufferSizeCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetWindowContentScaleCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetWindowContentScaleCallback.invoke(window, callback);
    }

    public static MemoryAddress setWindowContentScaleCallback(MemoryAddress window, @Nullable IGLFWWindowContentScaleFun callback) throws Throwable {
        return nsetWindowContentScaleCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static void pollEvents() throws Throwable {
        glfwPollEvents.invoke();
    }

    public static void waitEvents() throws Throwable {
        glfwWaitEvents.invoke();
    }

    public static void waitEventsTimeout(double timeout) throws Throwable {
        glfwWaitEventsTimeout.invoke();
    }

    public static void postEmptyEvents() throws Throwable {
        glfwPostEmptyEvent.invoke();
    }

    public static int getInputMode(MemoryAddress window, int mode) throws Throwable {
        return (int) glfwGetInputMode.invoke(window, mode);
    }

    public static void setInputMode(MemoryAddress window, int mode, int value) throws Throwable {
        glfwSetInputMode.invoke(window, mode, value);
    }

    public static boolean rawMouseMotionSupported() throws Throwable {
        return (int) glfwRawMouseMotionSupported.invoke() == TRUE;
    }

    public static MemoryAddress ngetKeyName(int key, int scancode) throws Throwable {
        return (MemoryAddress) glfwGetKeyName.invoke(key, scancode);
    }

    @Nullable
    public static String getKeyName(int key, int scancode) throws Throwable {
        var pName = ngetKeyName(key, scancode);
        return pName != MemoryAddress.NULL ? pName.getUtf8String(0L) : null;
    }

    public static int getKeyScancode(int key) throws Throwable {
        return (int) glfwGetKeyScancode.invoke(key);
    }

    public static int getKey(MemoryAddress window, int key) throws Throwable {
        return (int) glfwGetKey.invoke(window, key);
    }

    public static int getMouseButton(MemoryAddress window, int button) throws Throwable {
        return (int) glfwGetMouseButton.invoke(window, button);
    }

    public static void ngetCursorPos(MemoryAddress window, MemoryAddress xpos, MemoryAddress ypos) throws Throwable {
        glfwGetCursorPos.invoke(window, xpos, ypos);
    }

    public static void getCursorPos(MemoryAddress window, double @Nullable [] xpos, double @Nullable [] ypos) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var px = xpos != null ? session.allocate(JAVA_DOUBLE).address() : MemoryAddress.NULL;
            var py = ypos != null ? session.allocate(JAVA_DOUBLE).address() : MemoryAddress.NULL;
            ngetCursorPos(window, px, py);
            if (xpos != null && xpos.length > 0) {
                xpos[0] = px.get(JAVA_DOUBLE, 0L);
            }
            if (ypos != null && ypos.length > 0) {
                ypos[0] = py.get(JAVA_DOUBLE, 0L);
            }
        }
    }

    public static void setCursorPos(MemoryAddress window, double xpos, double ypos) throws Throwable {
        glfwSetCursorPos.invoke(window, xpos, ypos);
    }

    public static MemoryAddress ncreateCursor(MemoryAddress image, int xhot, int yhot) throws Throwable {
        return (MemoryAddress) glfwCreateCursor.invoke(image, xhot, yhot);
    }

    public static MemoryAddress createCursor(GLFWImage image, int xhot, int yhot) throws Throwable {
        return ncreateCursor(image.address(), xhot, yhot);
    }

    public static MemoryAddress createStandardCursor(int shape) throws Throwable {
        return (MemoryAddress) glfwCreateStandardCursor.invoke(shape);
    }

    public static void destroyCursor(MemoryAddress cursor) throws Throwable {
        glfwDestroyCursor.invoke(cursor);
    }

    public static void setCursor(MemoryAddress window, MemoryAddress cursor) throws Throwable {
        glfwSetCursor.invoke(window, cursor);
    }

    public static MemoryAddress nsetKeyCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetKeyCallback.invoke(window, callback);
    }

    public static MemoryAddress setKeyCallback(MemoryAddress window, @Nullable IGLFWKeyFun callback) throws Throwable {
        return nsetKeyCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetCharCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetCharCallback.invoke(window, callback);
    }

    public static MemoryAddress setCharCallback(MemoryAddress window, @Nullable IGLFWCharFun callback) throws Throwable {
        return nsetCharCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    @Deprecated(forRemoval = true)
    public static MemoryAddress nsetCharModsCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetCharModsCallback.invoke(window, callback);
    }

    @Deprecated(forRemoval = true)
    public static MemoryAddress setCharModsCallback(MemoryAddress window, @Nullable IGLFWCharModsFun callback) throws Throwable {
        return nsetCharModsCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetMouseButtonCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetMouseButtonCallback.invoke(window, callback);
    }

    public static MemoryAddress setMouseButtonCallback(MemoryAddress window, @Nullable IGLFWMouseButtonFun callback) throws Throwable {
        return nsetMouseButtonCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetCursorPosCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetCursorPosCallback.invoke(window, callback);
    }

    public static MemoryAddress setCursorPosCallback(MemoryAddress window, @Nullable IGLFWCursorPosFun callback) throws Throwable {
        return nsetCursorPosCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetCursorEnterCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetCursorEnterCallback.invoke(window, callback);
    }

    public static MemoryAddress setCursorEnterCallback(MemoryAddress window, @Nullable IGLFWCursorEnterFun callback) throws Throwable {
        return nsetCursorEnterCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetScrollCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetScrollCallback.invoke(window, callback);
    }

    public static MemoryAddress setScrollCallback(MemoryAddress window, @Nullable IGLFWScrollFun callback) throws Throwable {
        return nsetScrollCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static MemoryAddress nsetDropCallback(MemoryAddress window, MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetDropCallback.invoke(window, callback);
    }

    public static MemoryAddress setDropCallback(MemoryAddress window, @Nullable IGLFWDropFun callback) throws Throwable {
        return nsetDropCallback(window, callback != null ? callback.address(Callbacks.create(window)) : MemoryAddress.NULL);
    }

    public static boolean joystickPresent(int jid) throws Throwable {
        return (int) glfwJoystickPresent.invoke(jid) == TRUE;
    }

    public static MemoryAddress ngetJoystickAxes(int jid, MemoryAddress count) throws Throwable {
        return (MemoryAddress) glfwGetJoystickAxes.invoke(jid, count);
    }

    public static float[] getJoystickAxes(int jid) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pCount = session.allocate(JAVA_INT);
            var pAxes = ngetJoystickAxes(jid, pCount.address());
            float[] axes = new float[pCount.get(JAVA_INT, 0L)];
            for (int i = 0; i < axes.length; i++) {
                axes[i] = pAxes.getAtIndex(JAVA_FLOAT, i);
            }
            return axes;
        }
    }

    public static MemoryAddress ngetJoystickButtons(int jid, MemoryAddress count) throws Throwable {
        return (MemoryAddress) glfwGetJoystickButtons.invoke(jid, count);
    }

    public static boolean[] getJoystickButtons(int jid) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pCount = session.allocate(JAVA_INT);
            var pButtons = ngetJoystickButtons(jid, pCount.address());
            boolean[] buttons = new boolean[pCount.get(JAVA_INT, 0L)];
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = pButtons.getAtIndex(JAVA_INT, i) == PRESS;
            }
            return buttons;
        }
    }

    public static MemoryAddress ngetJoystickHats(int jid, MemoryAddress count) throws Throwable {
        return (MemoryAddress) glfwGetJoystickHats.invoke(jid, count);
    }

    public static byte[] getJoystickHats(int jid) throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pCount = session.allocate(JAVA_INT);
            var pHats = ngetJoystickHats(jid, pCount.address());
            byte[] hats = new byte[pCount.get(JAVA_INT, 0L)];
            for (int i = 0; i < hats.length; i++) {
                hats[i] = pHats.get(JAVA_BYTE, i);
            }
            return hats;
        }
    }

    public static MemoryAddress ngetJoystickName(int jid) throws Throwable {
        return (MemoryAddress) glfwGetJoystickName.invoke(jid);
    }

    @Nullable
    public static String getJoystickName(int jid) throws Throwable {
        var pName = ngetJoystickName(jid);
        return pName != MemoryAddress.NULL ? pName.getUtf8String(0L) : null;
    }

    public static MemoryAddress ngetJoystickGUID(int jid) throws Throwable {
        return (MemoryAddress) glfwGetJoystickGUID.invoke(jid);
    }

    @Nullable
    public static String getJoystickGUID(int jid) throws Throwable {
        var pGUID = ngetJoystickGUID(jid);
        return pGUID != MemoryAddress.NULL ? pGUID.getUtf8String(0L) : null;
    }

    public static void setJoystickUserPointer(int jid, MemoryAddress pointer) throws Throwable {
        glfwSetJoystickUserPointer.invoke(jid, pointer);
    }

    public static MemoryAddress getJoystickUserPointer(int jid) throws Throwable {
        return (MemoryAddress) glfwGetJoystickUserPointer.invoke(jid);
    }

    public static boolean joystickIsGamepad(int jid) throws Throwable {
        return (int) glfwJoystickIsGamepad.invoke(jid) == TRUE;
    }

    public static MemoryAddress nsetJoystickCallback(MemoryAddress callback) throws Throwable {
        return (MemoryAddress) glfwSetJoystickCallback.invoke(callback);
    }

    public static MemoryAddress setJoystickCallback(@Nullable IGLFWJoystickFun callback) throws Throwable {
        return nsetJoystickCallback(callback != null ? callback.address(MemorySession.global()) : MemoryAddress.NULL);
    }

    public static boolean nupdateGamepadMappings(MemoryAddress string) throws Throwable {
        return (int) glfwUpdateGamepadMappings.invoke(string) == TRUE;
    }

    public static boolean updateGamepadMappings(String string) throws Throwable {
        try (var session = MemorySession.openShared()) {
            return nupdateGamepadMappings(session.allocateUtf8String(string).address());
        }
    }

    public static MemoryAddress ngetGamepadName(int jid) throws Throwable {
        return (MemoryAddress) glfwGetGamepadName.invoke(jid);
    }

    @Nullable
    public static String getGamepadName(int jid) throws Throwable {
        var pName = ngetGamepadName(jid);
        return pName != MemoryAddress.NULL ? pName.getUtf8String(0L) : null;
    }

    public static boolean ngetGamepadState(int jid, MemoryAddress state) throws Throwable {
        return (int) glfwGetGamepadState.invoke(jid, state) == TRUE;
    }

    public static boolean getGamepadState(int jid, GLFWGamepadState state) throws Throwable {
        return ngetGamepadState(jid, state.address());
    }

    public static void nsetClipboardString(@Deprecated MemoryAddress window, MemoryAddress string) throws Throwable {
        glfwSetClipboardString.invoke(window, string);
    }

    public static void setClipboardString(@Deprecated MemoryAddress window, String string) throws Throwable {
        try (var session = MemorySession.openShared()) {
            nsetClipboardString(window, session.allocateUtf8String(string).address());
        }
    }

    public static MemoryAddress ngetClipboardString(@Deprecated MemoryAddress window) throws Throwable {
        return (MemoryAddress) glfwGetClipboardString.invoke(window);
    }

    @Nullable
    public static String getClipboardString(@Deprecated MemoryAddress window) throws Throwable {
        var pString = ngetClipboardString(window);
        return pString != MemoryAddress.NULL ? pString.getUtf8String(0L) : null;
    }

    public static double getTime() throws Throwable {
        return (double) glfwGetTime.invoke();
    }

    public static void setTime(double time) throws Throwable {
        glfwSetTime.invoke(time);
    }

    public static long getTimerValue() throws Throwable {
        return (long) glfwGetTimerValue.invoke();
    }

    public static long getTimerFrequency() throws Throwable {
        return (long) glfwGetTimerFrequency.invoke();
    }

    public static void makeContextCurrent(MemoryAddress window) throws Throwable {
        glfwMakeContextCurrent.invoke(window);
    }

    public static MemoryAddress getCurrentContext() throws Throwable {
        return (MemoryAddress) glfwGetCurrentContext.invoke();
    }

    public static void swapBuffers(MemoryAddress window) throws Throwable {
        glfwSwapBuffers.invoke(window);
    }

    public static void swapInterval(int interval) throws Throwable {
        glfwSwapInterval.invoke(interval);
    }

    public static boolean nextensionSupported(MemoryAddress extension) throws Throwable {
        return (int) glfwExtensionSupported.invoke(extension) == TRUE;
    }

    public static boolean extensionSupported(String extension) throws Throwable {
        try (var session = MemorySession.openShared()) {
            return nextensionSupported(session.allocateUtf8String(extension).address());
        }
    }

    public static MemoryAddress ngetProcAddress(MemoryAddress procName) throws Throwable {
        return (MemoryAddress) glfwGetProcAddress.invoke(procName);
    }

    public static MemoryAddress getProcAddress(String procName) throws Throwable {
        try (var session = MemorySession.openShared()) {
            return ngetProcAddress(session.allocateUtf8String(procName).address());
        }
    }

    public static boolean vulkanSupported() throws Throwable {
        return (int) glfwVulkanSupported.invoke() == TRUE;
    }

    public static MemoryAddress ngetRequiredInstanceExtensions(MemoryAddress count) throws Throwable {
        return (MemoryAddress) glfwGetRequiredInstanceExtensions.invoke(count);
    }

    public static String[] getRequiredInstanceExtensions() throws Throwable {
        try (var session = MemorySession.openShared()) {
            var pCount = session.allocate(JAVA_INT);
            var pExt = ngetRequiredInstanceExtensions(pCount.address());
            String[] ext = new String[pCount.get(JAVA_INT, 0L)];
            for (int i = 0; i < ext.length; i++) {
                ext[i] = pExt.get(ADDRESS, i).getUtf8String(0L);
            }
            return ext;
        }
    }
}
