/*
 * MIT License
 *
 * Copyright (c) 2022-2025 Overrun Organization
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

// This file is auto-generated. DO NOT EDIT!
package overrungl.openal;
import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.*;
import overrungl.util.*;
public final class ALCEXTEFX {
    //region ---[BEGIN GENERATOR BEGIN]---
    //@formatter:off
    //region Fields
    public static final java.lang.String ALC_EXT_EFX_NAME = "ALC_EXT_EFX";
    public static final int ALC_EFX_MAJOR_VERSION = 0x20001;
    public static final int ALC_EFX_MINOR_VERSION = 0x20002;
    public static final int ALC_MAX_AUXILIARY_SENDS = 0x20003;
    public static final int AL_METERS_PER_UNIT = 0x20004;
    public static final int AL_DIRECT_FILTER = 0x20005;
    public static final int AL_AUXILIARY_SEND_FILTER = 0x20006;
    public static final int AL_AIR_ABSORPTION_FACTOR = 0x20007;
    public static final int AL_ROOM_ROLLOFF_FACTOR = 0x20008;
    public static final int AL_CONE_OUTER_GAINHF = 0x20009;
    public static final int AL_DIRECT_FILTER_GAINHF_AUTO = 0x2000A;
    public static final int AL_AUXILIARY_SEND_FILTER_GAIN_AUTO = 0x2000B;
    public static final int AL_AUXILIARY_SEND_FILTER_GAINHF_AUTO = 0x2000C;
    public static final int AL_REVERB_DENSITY = 0x0001;
    public static final int AL_REVERB_DIFFUSION = 0x0002;
    public static final int AL_REVERB_GAIN = 0x0003;
    public static final int AL_REVERB_GAINHF = 0x0004;
    public static final int AL_REVERB_DECAY_TIME = 0x0005;
    public static final int AL_REVERB_DECAY_HFRATIO = 0x0006;
    public static final int AL_REVERB_REFLECTIONS_GAIN = 0x0007;
    public static final int AL_REVERB_REFLECTIONS_DELAY = 0x0008;
    public static final int AL_REVERB_LATE_REVERB_GAIN = 0x0009;
    public static final int AL_REVERB_LATE_REVERB_DELAY = 0x000A;
    public static final int AL_REVERB_AIR_ABSORPTION_GAINHF = 0x000B;
    public static final int AL_REVERB_ROOM_ROLLOFF_FACTOR = 0x000C;
    public static final int AL_REVERB_DECAY_HFLIMIT = 0x000D;
    public static final int AL_EAXREVERB_DENSITY = 0x0001;
    public static final int AL_EAXREVERB_DIFFUSION = 0x0002;
    public static final int AL_EAXREVERB_GAIN = 0x0003;
    public static final int AL_EAXREVERB_GAINHF = 0x0004;
    public static final int AL_EAXREVERB_GAINLF = 0x0005;
    public static final int AL_EAXREVERB_DECAY_TIME = 0x0006;
    public static final int AL_EAXREVERB_DECAY_HFRATIO = 0x0007;
    public static final int AL_EAXREVERB_DECAY_LFRATIO = 0x0008;
    public static final int AL_EAXREVERB_REFLECTIONS_GAIN = 0x0009;
    public static final int AL_EAXREVERB_REFLECTIONS_DELAY = 0x000A;
    public static final int AL_EAXREVERB_REFLECTIONS_PAN = 0x000B;
    public static final int AL_EAXREVERB_LATE_REVERB_GAIN = 0x000C;
    public static final int AL_EAXREVERB_LATE_REVERB_DELAY = 0x000D;
    public static final int AL_EAXREVERB_LATE_REVERB_PAN = 0x000E;
    public static final int AL_EAXREVERB_ECHO_TIME = 0x000F;
    public static final int AL_EAXREVERB_ECHO_DEPTH = 0x0010;
    public static final int AL_EAXREVERB_MODULATION_TIME = 0x0011;
    public static final int AL_EAXREVERB_MODULATION_DEPTH = 0x0012;
    public static final int AL_EAXREVERB_AIR_ABSORPTION_GAINHF = 0x0013;
    public static final int AL_EAXREVERB_HFREFERENCE = 0x0014;
    public static final int AL_EAXREVERB_LFREFERENCE = 0x0015;
    public static final int AL_EAXREVERB_ROOM_ROLLOFF_FACTOR = 0x0016;
    public static final int AL_EAXREVERB_DECAY_HFLIMIT = 0x0017;
    public static final int AL_CHORUS_WAVEFORM = 0x0001;
    public static final int AL_CHORUS_PHASE = 0x0002;
    public static final int AL_CHORUS_RATE = 0x0003;
    public static final int AL_CHORUS_DEPTH = 0x0004;
    public static final int AL_CHORUS_FEEDBACK = 0x0005;
    public static final int AL_CHORUS_DELAY = 0x0006;
    public static final int AL_DISTORTION_EDGE = 0x0001;
    public static final int AL_DISTORTION_GAIN = 0x0002;
    public static final int AL_DISTORTION_LOWPASS_CUTOFF = 0x0003;
    public static final int AL_DISTORTION_EQCENTER = 0x0004;
    public static final int AL_DISTORTION_EQBANDWIDTH = 0x0005;
    public static final int AL_ECHO_DELAY = 0x0001;
    public static final int AL_ECHO_LRDELAY = 0x0002;
    public static final int AL_ECHO_DAMPING = 0x0003;
    public static final int AL_ECHO_FEEDBACK = 0x0004;
    public static final int AL_ECHO_SPREAD = 0x0005;
    public static final int AL_FLANGER_WAVEFORM = 0x0001;
    public static final int AL_FLANGER_PHASE = 0x0002;
    public static final int AL_FLANGER_RATE = 0x0003;
    public static final int AL_FLANGER_DEPTH = 0x0004;
    public static final int AL_FLANGER_FEEDBACK = 0x0005;
    public static final int AL_FLANGER_DELAY = 0x0006;
    public static final int AL_FREQUENCY_SHIFTER_FREQUENCY = 0x0001;
    public static final int AL_FREQUENCY_SHIFTER_LEFT_DIRECTION = 0x0002;
    public static final int AL_FREQUENCY_SHIFTER_RIGHT_DIRECTION = 0x0003;
    public static final int AL_VOCAL_MORPHER_PHONEMEA = 0x0001;
    public static final int AL_VOCAL_MORPHER_PHONEMEA_COARSE_TUNING = 0x0002;
    public static final int AL_VOCAL_MORPHER_PHONEMEB = 0x0003;
    public static final int AL_VOCAL_MORPHER_PHONEMEB_COARSE_TUNING = 0x0004;
    public static final int AL_VOCAL_MORPHER_WAVEFORM = 0x0005;
    public static final int AL_VOCAL_MORPHER_RATE = 0x0006;
    public static final int AL_PITCH_SHIFTER_COARSE_TUNE = 0x0001;
    public static final int AL_PITCH_SHIFTER_FINE_TUNE = 0x0002;
    public static final int AL_RING_MODULATOR_FREQUENCY = 0x0001;
    public static final int AL_RING_MODULATOR_HIGHPASS_CUTOFF = 0x0002;
    public static final int AL_RING_MODULATOR_WAVEFORM = 0x0003;
    public static final int AL_AUTOWAH_ATTACK_TIME = 0x0001;
    public static final int AL_AUTOWAH_RELEASE_TIME = 0x0002;
    public static final int AL_AUTOWAH_RESONANCE = 0x0003;
    public static final int AL_AUTOWAH_PEAK_GAIN = 0x0004;
    public static final int AL_COMPRESSOR_ONOFF = 0x0001;
    public static final int AL_EQUALIZER_LOW_GAIN = 0x0001;
    public static final int AL_EQUALIZER_LOW_CUTOFF = 0x0002;
    public static final int AL_EQUALIZER_MID1_GAIN = 0x0003;
    public static final int AL_EQUALIZER_MID1_CENTER = 0x0004;
    public static final int AL_EQUALIZER_MID1_WIDTH = 0x0005;
    public static final int AL_EQUALIZER_MID2_GAIN = 0x0006;
    public static final int AL_EQUALIZER_MID2_CENTER = 0x0007;
    public static final int AL_EQUALIZER_MID2_WIDTH = 0x0008;
    public static final int AL_EQUALIZER_HIGH_GAIN = 0x0009;
    public static final int AL_EQUALIZER_HIGH_CUTOFF = 0x000A;
    public static final int AL_EFFECT_FIRST_PARAMETER = 0x0000;
    public static final int AL_EFFECT_LAST_PARAMETER = 0x8000;
    public static final int AL_EFFECT_TYPE = 0x8001;
    public static final int AL_EFFECT_NULL = 0x0000;
    public static final int AL_EFFECT_REVERB = 0x0001;
    public static final int AL_EFFECT_CHORUS = 0x0002;
    public static final int AL_EFFECT_DISTORTION = 0x0003;
    public static final int AL_EFFECT_ECHO = 0x0004;
    public static final int AL_EFFECT_FLANGER = 0x0005;
    public static final int AL_EFFECT_FREQUENCY_SHIFTER = 0x0006;
    public static final int AL_EFFECT_VOCAL_MORPHER = 0x0007;
    public static final int AL_EFFECT_PITCH_SHIFTER = 0x0008;
    public static final int AL_EFFECT_RING_MODULATOR = 0x0009;
    public static final int AL_EFFECT_AUTOWAH = 0x000A;
    public static final int AL_EFFECT_COMPRESSOR = 0x000B;
    public static final int AL_EFFECT_EQUALIZER = 0x000C;
    public static final int AL_EFFECT_EAXREVERB = 0x8000;
    public static final int AL_EFFECTSLOT_EFFECT = 0x0001;
    public static final int AL_EFFECTSLOT_GAIN = 0x0002;
    public static final int AL_EFFECTSLOT_AUXILIARY_SEND_AUTO = 0x0003;
    public static final int AL_EFFECTSLOT_NULL = 0x0000;
    public static final int AL_LOWPASS_GAIN = 0x0001;
    public static final int AL_LOWPASS_GAINHF = 0x0002;
    public static final int AL_HIGHPASS_GAIN = 0x0001;
    public static final int AL_HIGHPASS_GAINLF = 0x0002;
    public static final int AL_BANDPASS_GAIN = 0x0001;
    public static final int AL_BANDPASS_GAINLF = 0x0002;
    public static final int AL_BANDPASS_GAINHF = 0x0003;
    public static final int AL_FILTER_FIRST_PARAMETER = 0x0000;
    public static final int AL_FILTER_LAST_PARAMETER = 0x8000;
    public static final int AL_FILTER_TYPE = 0x8001;
    public static final int AL_FILTER_NULL = 0x0000;
    public static final int AL_FILTER_LOWPASS = 0x0001;
    public static final int AL_FILTER_HIGHPASS = 0x0002;
    public static final int AL_FILTER_BANDPASS = 0x0003;
    public static final float AL_LOWPASS_MIN_GAIN = 0.0f;
    public static final float AL_LOWPASS_MAX_GAIN = 1.0f;
    public static final float AL_LOWPASS_DEFAULT_GAIN = 1.0f;
    public static final float AL_LOWPASS_MIN_GAINHF = 0.0f;
    public static final float AL_LOWPASS_MAX_GAINHF = 1.0f;
    public static final float AL_LOWPASS_DEFAULT_GAINHF = 1.0f;
    public static final float AL_HIGHPASS_MIN_GAIN = 0.0f;
    public static final float AL_HIGHPASS_MAX_GAIN = 1.0f;
    public static final float AL_HIGHPASS_DEFAULT_GAIN = 1.0f;
    public static final float AL_HIGHPASS_MIN_GAINLF = 0.0f;
    public static final float AL_HIGHPASS_MAX_GAINLF = 1.0f;
    public static final float AL_HIGHPASS_DEFAULT_GAINLF = 1.0f;
    public static final float AL_BANDPASS_MIN_GAIN = 0.0f;
    public static final float AL_BANDPASS_MAX_GAIN = 1.0f;
    public static final float AL_BANDPASS_DEFAULT_GAIN = 1.0f;
    public static final float AL_BANDPASS_MIN_GAINHF = 0.0f;
    public static final float AL_BANDPASS_MAX_GAINHF = 1.0f;
    public static final float AL_BANDPASS_DEFAULT_GAINHF = 1.0f;
    public static final float AL_BANDPASS_MIN_GAINLF = 0.0f;
    public static final float AL_BANDPASS_MAX_GAINLF = 1.0f;
    public static final float AL_BANDPASS_DEFAULT_GAINLF = 1.0f;
    public static final float AL_REVERB_MIN_DENSITY = 0.0f;
    public static final float AL_REVERB_MAX_DENSITY = 1.0f;
    public static final float AL_REVERB_DEFAULT_DENSITY = 1.0f;
    public static final float AL_REVERB_MIN_DIFFUSION = 0.0f;
    public static final float AL_REVERB_MAX_DIFFUSION = 1.0f;
    public static final float AL_REVERB_DEFAULT_DIFFUSION = 1.0f;
    public static final float AL_REVERB_MIN_GAIN = 0.0f;
    public static final float AL_REVERB_MAX_GAIN = 1.0f;
    public static final float AL_REVERB_DEFAULT_GAIN = 0.32f;
    public static final float AL_REVERB_MIN_GAINHF = 0.0f;
    public static final float AL_REVERB_MAX_GAINHF = 1.0f;
    public static final float AL_REVERB_DEFAULT_GAINHF = 0.89f;
    public static final float AL_REVERB_MIN_DECAY_TIME = 0.1f;
    public static final float AL_REVERB_MAX_DECAY_TIME = 20.0f;
    public static final float AL_REVERB_DEFAULT_DECAY_TIME = 1.49f;
    public static final float AL_REVERB_MIN_DECAY_HFRATIO = 0.1f;
    public static final float AL_REVERB_MAX_DECAY_HFRATIO = 2.0f;
    public static final float AL_REVERB_DEFAULT_DECAY_HFRATIO = 0.83f;
    public static final float AL_REVERB_MIN_REFLECTIONS_GAIN = 0.0f;
    public static final float AL_REVERB_MAX_REFLECTIONS_GAIN = 3.16f;
    public static final float AL_REVERB_DEFAULT_REFLECTIONS_GAIN = 0.05f;
    public static final float AL_REVERB_MIN_REFLECTIONS_DELAY = 0.0f;
    public static final float AL_REVERB_MAX_REFLECTIONS_DELAY = 0.3f;
    public static final float AL_REVERB_DEFAULT_REFLECTIONS_DELAY = 0.007f;
    public static final float AL_REVERB_MIN_LATE_REVERB_GAIN = 0.0f;
    public static final float AL_REVERB_MAX_LATE_REVERB_GAIN = 10.0f;
    public static final float AL_REVERB_DEFAULT_LATE_REVERB_GAIN = 1.26f;
    public static final float AL_REVERB_MIN_LATE_REVERB_DELAY = 0.0f;
    public static final float AL_REVERB_MAX_LATE_REVERB_DELAY = 0.1f;
    public static final float AL_REVERB_DEFAULT_LATE_REVERB_DELAY = 0.011f;
    public static final float AL_REVERB_MIN_AIR_ABSORPTION_GAINHF = 0.892f;
    public static final float AL_REVERB_MAX_AIR_ABSORPTION_GAINHF = 1.0f;
    public static final float AL_REVERB_DEFAULT_AIR_ABSORPTION_GAINHF = 0.994f;
    public static final float AL_REVERB_MIN_ROOM_ROLLOFF_FACTOR = 0.0f;
    public static final float AL_REVERB_MAX_ROOM_ROLLOFF_FACTOR = 10.0f;
    public static final float AL_REVERB_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0f;
    public static final int AL_REVERB_MIN_DECAY_HFLIMIT = AL.AL_FALSE;
    public static final int AL_REVERB_MAX_DECAY_HFLIMIT = AL.AL_TRUE;
    public static final int AL_REVERB_DEFAULT_DECAY_HFLIMIT = AL.AL_TRUE;
    public static final float AL_EAXREVERB_MIN_DENSITY = 0.0f;
    public static final float AL_EAXREVERB_MAX_DENSITY = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_DENSITY = 1.0f;
    public static final float AL_EAXREVERB_MIN_DIFFUSION = 0.0f;
    public static final float AL_EAXREVERB_MAX_DIFFUSION = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_DIFFUSION = 1.0f;
    public static final float AL_EAXREVERB_MIN_GAIN = 0.0f;
    public static final float AL_EAXREVERB_MAX_GAIN = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_GAIN = 0.32f;
    public static final float AL_EAXREVERB_MIN_GAINHF = 0.0f;
    public static final float AL_EAXREVERB_MAX_GAINHF = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_GAINHF = 0.89f;
    public static final float AL_EAXREVERB_MIN_GAINLF = 0.0f;
    public static final float AL_EAXREVERB_MAX_GAINLF = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_GAINLF = 1.0f;
    public static final float AL_EAXREVERB_MIN_DECAY_TIME = 0.1f;
    public static final float AL_EAXREVERB_MAX_DECAY_TIME = 20.0f;
    public static final float AL_EAXREVERB_DEFAULT_DECAY_TIME = 1.49f;
    public static final float AL_EAXREVERB_MIN_DECAY_HFRATIO = 0.1f;
    public static final float AL_EAXREVERB_MAX_DECAY_HFRATIO = 2.0f;
    public static final float AL_EAXREVERB_DEFAULT_DECAY_HFRATIO = 0.83f;
    public static final float AL_EAXREVERB_MIN_DECAY_LFRATIO = 0.1f;
    public static final float AL_EAXREVERB_MAX_DECAY_LFRATIO = 2.0f;
    public static final float AL_EAXREVERB_DEFAULT_DECAY_LFRATIO = 1.0f;
    public static final float AL_EAXREVERB_MIN_REFLECTIONS_GAIN = 0.0f;
    public static final float AL_EAXREVERB_MAX_REFLECTIONS_GAIN = 3.16f;
    public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_GAIN = 0.05f;
    public static final float AL_EAXREVERB_MIN_REFLECTIONS_DELAY = 0.0f;
    public static final float AL_EAXREVERB_MAX_REFLECTIONS_DELAY = 0.3f;
    public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_DELAY = 0.007f;
    public static final float AL_EAXREVERB_DEFAULT_REFLECTIONS_PAN_XYZ = 0.0f;
    public static final float AL_EAXREVERB_MIN_LATE_REVERB_GAIN = 0.0f;
    public static final float AL_EAXREVERB_MAX_LATE_REVERB_GAIN = 10.0f;
    public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_GAIN = 1.26f;
    public static final float AL_EAXREVERB_MIN_LATE_REVERB_DELAY = 0.0f;
    public static final float AL_EAXREVERB_MAX_LATE_REVERB_DELAY = 0.1f;
    public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_DELAY = 0.011f;
    public static final float AL_EAXREVERB_DEFAULT_LATE_REVERB_PAN_XYZ = 0.0f;
    public static final float AL_EAXREVERB_MIN_ECHO_TIME = 0.075f;
    public static final float AL_EAXREVERB_MAX_ECHO_TIME = 0.25f;
    public static final float AL_EAXREVERB_DEFAULT_ECHO_TIME = 0.25f;
    public static final float AL_EAXREVERB_MIN_ECHO_DEPTH = 0.0f;
    public static final float AL_EAXREVERB_MAX_ECHO_DEPTH = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_ECHO_DEPTH = 0.0f;
    public static final float AL_EAXREVERB_MIN_MODULATION_TIME = 0.04f;
    public static final float AL_EAXREVERB_MAX_MODULATION_TIME = 4.0f;
    public static final float AL_EAXREVERB_DEFAULT_MODULATION_TIME = 0.25f;
    public static final float AL_EAXREVERB_MIN_MODULATION_DEPTH = 0.0f;
    public static final float AL_EAXREVERB_MAX_MODULATION_DEPTH = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_MODULATION_DEPTH = 0.0f;
    public static final float AL_EAXREVERB_MIN_AIR_ABSORPTION_GAINHF = 0.892f;
    public static final float AL_EAXREVERB_MAX_AIR_ABSORPTION_GAINHF = 1.0f;
    public static final float AL_EAXREVERB_DEFAULT_AIR_ABSORPTION_GAINHF = 0.994f;
    public static final float AL_EAXREVERB_MIN_HFREFERENCE = 1000.0f;
    public static final float AL_EAXREVERB_MAX_HFREFERENCE = 20000.0f;
    public static final float AL_EAXREVERB_DEFAULT_HFREFERENCE = 5000.0f;
    public static final float AL_EAXREVERB_MIN_LFREFERENCE = 20.0f;
    public static final float AL_EAXREVERB_MAX_LFREFERENCE = 1000.0f;
    public static final float AL_EAXREVERB_DEFAULT_LFREFERENCE = 250.0f;
    public static final float AL_EAXREVERB_MIN_ROOM_ROLLOFF_FACTOR = 0.0f;
    public static final float AL_EAXREVERB_MAX_ROOM_ROLLOFF_FACTOR = 10.0f;
    public static final float AL_EAXREVERB_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0f;
    public static final int AL_EAXREVERB_MIN_DECAY_HFLIMIT = AL.AL_FALSE;
    public static final int AL_EAXREVERB_MAX_DECAY_HFLIMIT = AL.AL_TRUE;
    public static final int AL_EAXREVERB_DEFAULT_DECAY_HFLIMIT = AL.AL_TRUE;
    public static final int AL_CHORUS_WAVEFORM_SINUSOID = 0;
    public static final int AL_CHORUS_WAVEFORM_TRIANGLE = 1;
    public static final int AL_CHORUS_MIN_WAVEFORM = 0;
    public static final int AL_CHORUS_MAX_WAVEFORM = 1;
    public static final int AL_CHORUS_DEFAULT_WAVEFORM = 1;
    public static final int AL_CHORUS_MIN_PHASE = -180;
    public static final int AL_CHORUS_MAX_PHASE = 180;
    public static final int AL_CHORUS_DEFAULT_PHASE = 90;
    public static final float AL_CHORUS_MIN_RATE = 0.0f;
    public static final float AL_CHORUS_MAX_RATE = 10.0f;
    public static final float AL_CHORUS_DEFAULT_RATE = 1.1f;
    public static final float AL_CHORUS_MIN_DEPTH = 0.0f;
    public static final float AL_CHORUS_MAX_DEPTH = 1.0f;
    public static final float AL_CHORUS_DEFAULT_DEPTH = 0.1f;
    public static final float AL_CHORUS_MIN_FEEDBACK = -1.0f;
    public static final float AL_CHORUS_MAX_FEEDBACK = 1.0f;
    public static final float AL_CHORUS_DEFAULT_FEEDBACK = 0.25f;
    public static final float AL_CHORUS_MIN_DELAY = 0.0f;
    public static final float AL_CHORUS_MAX_DELAY = 0.016f;
    public static final float AL_CHORUS_DEFAULT_DELAY = 0.016f;
    public static final float AL_DISTORTION_MIN_EDGE = 0.0f;
    public static final float AL_DISTORTION_MAX_EDGE = 1.0f;
    public static final float AL_DISTORTION_DEFAULT_EDGE = 0.2f;
    public static final float AL_DISTORTION_MIN_GAIN = 0.01f;
    public static final float AL_DISTORTION_MAX_GAIN = 1.0f;
    public static final float AL_DISTORTION_DEFAULT_GAIN = 0.05f;
    public static final float AL_DISTORTION_MIN_LOWPASS_CUTOFF = 80.0f;
    public static final float AL_DISTORTION_MAX_LOWPASS_CUTOFF = 24000.0f;
    public static final float AL_DISTORTION_DEFAULT_LOWPASS_CUTOFF = 8000.0f;
    public static final float AL_DISTORTION_MIN_EQCENTER = 80.0f;
    public static final float AL_DISTORTION_MAX_EQCENTER = 24000.0f;
    public static final float AL_DISTORTION_DEFAULT_EQCENTER = 3600.0f;
    public static final float AL_DISTORTION_MIN_EQBANDWIDTH = 80.0f;
    public static final float AL_DISTORTION_MAX_EQBANDWIDTH = 24000.0f;
    public static final float AL_DISTORTION_DEFAULT_EQBANDWIDTH = 3600.0f;
    public static final float AL_ECHO_MIN_DELAY = 0.0f;
    public static final float AL_ECHO_MAX_DELAY = 0.207f;
    public static final float AL_ECHO_DEFAULT_DELAY = 0.1f;
    public static final float AL_ECHO_MIN_LRDELAY = 0.0f;
    public static final float AL_ECHO_MAX_LRDELAY = 0.404f;
    public static final float AL_ECHO_DEFAULT_LRDELAY = 0.1f;
    public static final float AL_ECHO_MIN_DAMPING = 0.0f;
    public static final float AL_ECHO_MAX_DAMPING = 0.99f;
    public static final float AL_ECHO_DEFAULT_DAMPING = 0.5f;
    public static final float AL_ECHO_MIN_FEEDBACK = 0.0f;
    public static final float AL_ECHO_MAX_FEEDBACK = 1.0f;
    public static final float AL_ECHO_DEFAULT_FEEDBACK = 0.5f;
    public static final float AL_ECHO_MIN_SPREAD = -1.0f;
    public static final float AL_ECHO_MAX_SPREAD = 1.0f;
    public static final float AL_ECHO_DEFAULT_SPREAD = -1.0f;
    public static final int AL_FLANGER_WAVEFORM_SINUSOID = 0;
    public static final int AL_FLANGER_WAVEFORM_TRIANGLE = 1;
    public static final int AL_FLANGER_MIN_WAVEFORM = 0;
    public static final int AL_FLANGER_MAX_WAVEFORM = 1;
    public static final int AL_FLANGER_DEFAULT_WAVEFORM = 1;
    public static final int AL_FLANGER_MIN_PHASE = -180;
    public static final int AL_FLANGER_MAX_PHASE = 180;
    public static final int AL_FLANGER_DEFAULT_PHASE = 0;
    public static final float AL_FLANGER_MIN_RATE = 0.0f;
    public static final float AL_FLANGER_MAX_RATE = 10.0f;
    public static final float AL_FLANGER_DEFAULT_RATE = 0.27f;
    public static final float AL_FLANGER_MIN_DEPTH = 0.0f;
    public static final float AL_FLANGER_MAX_DEPTH = 1.0f;
    public static final float AL_FLANGER_DEFAULT_DEPTH = 1.0f;
    public static final float AL_FLANGER_MIN_FEEDBACK = -1.0f;
    public static final float AL_FLANGER_MAX_FEEDBACK = 1.0f;
    public static final float AL_FLANGER_DEFAULT_FEEDBACK = -0.5f;
    public static final float AL_FLANGER_MIN_DELAY = 0.0f;
    public static final float AL_FLANGER_MAX_DELAY = 0.004f;
    public static final float AL_FLANGER_DEFAULT_DELAY = 0.002f;
    public static final float AL_FREQUENCY_SHIFTER_MIN_FREQUENCY = 0.0f;
    public static final float AL_FREQUENCY_SHIFTER_MAX_FREQUENCY = 24000.0f;
    public static final float AL_FREQUENCY_SHIFTER_DEFAULT_FREQUENCY = 0.0f;
    public static final int AL_FREQUENCY_SHIFTER_MIN_LEFT_DIRECTION = 0;
    public static final int AL_FREQUENCY_SHIFTER_MAX_LEFT_DIRECTION = 2;
    public static final int AL_FREQUENCY_SHIFTER_DEFAULT_LEFT_DIRECTION = 0;
    public static final int AL_FREQUENCY_SHIFTER_DIRECTION_DOWN = 0;
    public static final int AL_FREQUENCY_SHIFTER_DIRECTION_UP = 1;
    public static final int AL_FREQUENCY_SHIFTER_DIRECTION_OFF = 2;
    public static final int AL_FREQUENCY_SHIFTER_MIN_RIGHT_DIRECTION = 0;
    public static final int AL_FREQUENCY_SHIFTER_MAX_RIGHT_DIRECTION = 2;
    public static final int AL_FREQUENCY_SHIFTER_DEFAULT_RIGHT_DIRECTION = 0;
    public static final int AL_VOCAL_MORPHER_MIN_PHONEMEA = 0;
    public static final int AL_VOCAL_MORPHER_MAX_PHONEMEA = 29;
    public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEA = 0;
    public static final int AL_VOCAL_MORPHER_MIN_PHONEMEA_COARSE_TUNING = -24;
    public static final int AL_VOCAL_MORPHER_MAX_PHONEMEA_COARSE_TUNING = 24;
    public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEA_COARSE_TUNING = 0;
    public static final int AL_VOCAL_MORPHER_MIN_PHONEMEB = 0;
    public static final int AL_VOCAL_MORPHER_MAX_PHONEMEB = 29;
    public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEB = 10;
    public static final int AL_VOCAL_MORPHER_MIN_PHONEMEB_COARSE_TUNING = -24;
    public static final int AL_VOCAL_MORPHER_MAX_PHONEMEB_COARSE_TUNING = 24;
    public static final int AL_VOCAL_MORPHER_DEFAULT_PHONEMEB_COARSE_TUNING = 0;
    public static final int AL_VOCAL_MORPHER_PHONEME_A = 0;
    public static final int AL_VOCAL_MORPHER_PHONEME_E = 1;
    public static final int AL_VOCAL_MORPHER_PHONEME_I = 2;
    public static final int AL_VOCAL_MORPHER_PHONEME_O = 3;
    public static final int AL_VOCAL_MORPHER_PHONEME_U = 4;
    public static final int AL_VOCAL_MORPHER_PHONEME_AA = 5;
    public static final int AL_VOCAL_MORPHER_PHONEME_AE = 6;
    public static final int AL_VOCAL_MORPHER_PHONEME_AH = 7;
    public static final int AL_VOCAL_MORPHER_PHONEME_AO = 8;
    public static final int AL_VOCAL_MORPHER_PHONEME_EH = 9;
    public static final int AL_VOCAL_MORPHER_PHONEME_ER = 10;
    public static final int AL_VOCAL_MORPHER_PHONEME_IH = 11;
    public static final int AL_VOCAL_MORPHER_PHONEME_IY = 12;
    public static final int AL_VOCAL_MORPHER_PHONEME_UH = 13;
    public static final int AL_VOCAL_MORPHER_PHONEME_UW = 14;
    public static final int AL_VOCAL_MORPHER_PHONEME_B = 15;
    public static final int AL_VOCAL_MORPHER_PHONEME_D = 16;
    public static final int AL_VOCAL_MORPHER_PHONEME_F = 17;
    public static final int AL_VOCAL_MORPHER_PHONEME_G = 18;
    public static final int AL_VOCAL_MORPHER_PHONEME_J = 19;
    public static final int AL_VOCAL_MORPHER_PHONEME_K = 20;
    public static final int AL_VOCAL_MORPHER_PHONEME_L = 21;
    public static final int AL_VOCAL_MORPHER_PHONEME_M = 22;
    public static final int AL_VOCAL_MORPHER_PHONEME_N = 23;
    public static final int AL_VOCAL_MORPHER_PHONEME_P = 24;
    public static final int AL_VOCAL_MORPHER_PHONEME_R = 25;
    public static final int AL_VOCAL_MORPHER_PHONEME_S = 26;
    public static final int AL_VOCAL_MORPHER_PHONEME_T = 27;
    public static final int AL_VOCAL_MORPHER_PHONEME_V = 28;
    public static final int AL_VOCAL_MORPHER_PHONEME_Z = 29;
    public static final int AL_VOCAL_MORPHER_WAVEFORM_SINUSOID = 0;
    public static final int AL_VOCAL_MORPHER_WAVEFORM_TRIANGLE = 1;
    public static final int AL_VOCAL_MORPHER_WAVEFORM_SAWTOOTH = 2;
    public static final int AL_VOCAL_MORPHER_MIN_WAVEFORM = 0;
    public static final int AL_VOCAL_MORPHER_MAX_WAVEFORM = 2;
    public static final int AL_VOCAL_MORPHER_DEFAULT_WAVEFORM = 0;
    public static final float AL_VOCAL_MORPHER_MIN_RATE = 0.0f;
    public static final float AL_VOCAL_MORPHER_MAX_RATE = 10.0f;
    public static final float AL_VOCAL_MORPHER_DEFAULT_RATE = 1.41f;
    public static final int AL_PITCH_SHIFTER_MIN_COARSE_TUNE = -12;
    public static final int AL_PITCH_SHIFTER_MAX_COARSE_TUNE = 12;
    public static final int AL_PITCH_SHIFTER_DEFAULT_COARSE_TUNE = 12;
    public static final int AL_PITCH_SHIFTER_MIN_FINE_TUNE = -50;
    public static final int AL_PITCH_SHIFTER_MAX_FINE_TUNE = 50;
    public static final int AL_PITCH_SHIFTER_DEFAULT_FINE_TUNE = 0;
    public static final float AL_RING_MODULATOR_MIN_FREQUENCY = 0.0f;
    public static final float AL_RING_MODULATOR_MAX_FREQUENCY = 8000.0f;
    public static final float AL_RING_MODULATOR_DEFAULT_FREQUENCY = 440.0f;
    public static final float AL_RING_MODULATOR_MIN_HIGHPASS_CUTOFF = 0.0f;
    public static final float AL_RING_MODULATOR_MAX_HIGHPASS_CUTOFF = 24000.0f;
    public static final float AL_RING_MODULATOR_DEFAULT_HIGHPASS_CUTOFF = 800.0f;
    public static final int AL_RING_MODULATOR_SINUSOID = 0;
    public static final int AL_RING_MODULATOR_SAWTOOTH = 1;
    public static final int AL_RING_MODULATOR_SQUARE = 2;
    public static final int AL_RING_MODULATOR_MIN_WAVEFORM = 0;
    public static final int AL_RING_MODULATOR_MAX_WAVEFORM = 2;
    public static final int AL_RING_MODULATOR_DEFAULT_WAVEFORM = 0;
    public static final float AL_AUTOWAH_MIN_ATTACK_TIME = 0.0001f;
    public static final float AL_AUTOWAH_MAX_ATTACK_TIME = 1.0f;
    public static final float AL_AUTOWAH_DEFAULT_ATTACK_TIME = 0.06f;
    public static final float AL_AUTOWAH_MIN_RELEASE_TIME = 0.0001f;
    public static final float AL_AUTOWAH_MAX_RELEASE_TIME = 1.0f;
    public static final float AL_AUTOWAH_DEFAULT_RELEASE_TIME = 0.06f;
    public static final float AL_AUTOWAH_MIN_RESONANCE = 2.0f;
    public static final float AL_AUTOWAH_MAX_RESONANCE = 1000.0f;
    public static final float AL_AUTOWAH_DEFAULT_RESONANCE = 1000.0f;
    public static final float AL_AUTOWAH_MIN_PEAK_GAIN = 0.00003f;
    public static final float AL_AUTOWAH_MAX_PEAK_GAIN = 31621.0f;
    public static final float AL_AUTOWAH_DEFAULT_PEAK_GAIN = 11.22f;
    public static final int AL_COMPRESSOR_MIN_ONOFF = 0;
    public static final int AL_COMPRESSOR_MAX_ONOFF = 1;
    public static final int AL_COMPRESSOR_DEFAULT_ONOFF = 1;
    public static final float AL_EQUALIZER_MIN_LOW_GAIN = 0.126f;
    public static final float AL_EQUALIZER_MAX_LOW_GAIN = 7.943f;
    public static final float AL_EQUALIZER_DEFAULT_LOW_GAIN = 1.0f;
    public static final float AL_EQUALIZER_MIN_LOW_CUTOFF = 50.0f;
    public static final float AL_EQUALIZER_MAX_LOW_CUTOFF = 800.0f;
    public static final float AL_EQUALIZER_DEFAULT_LOW_CUTOFF = 200.0f;
    public static final float AL_EQUALIZER_MIN_MID1_GAIN = 0.126f;
    public static final float AL_EQUALIZER_MAX_MID1_GAIN = 7.943f;
    public static final float AL_EQUALIZER_DEFAULT_MID1_GAIN = 1.0f;
    public static final float AL_EQUALIZER_MIN_MID1_CENTER = 200.0f;
    public static final float AL_EQUALIZER_MAX_MID1_CENTER = 3000.0f;
    public static final float AL_EQUALIZER_DEFAULT_MID1_CENTER = 500.0f;
    public static final float AL_EQUALIZER_MIN_MID1_WIDTH = 0.01f;
    public static final float AL_EQUALIZER_MAX_MID1_WIDTH = 1.0f;
    public static final float AL_EQUALIZER_DEFAULT_MID1_WIDTH = 1.0f;
    public static final float AL_EQUALIZER_MIN_MID2_GAIN = 0.126f;
    public static final float AL_EQUALIZER_MAX_MID2_GAIN = 7.943f;
    public static final float AL_EQUALIZER_DEFAULT_MID2_GAIN = 1.0f;
    public static final float AL_EQUALIZER_MIN_MID2_CENTER = 1000.0f;
    public static final float AL_EQUALIZER_MAX_MID2_CENTER = 8000.0f;
    public static final float AL_EQUALIZER_DEFAULT_MID2_CENTER = 3000.0f;
    public static final float AL_EQUALIZER_MIN_MID2_WIDTH = 0.01f;
    public static final float AL_EQUALIZER_MAX_MID2_WIDTH = 1.0f;
    public static final float AL_EQUALIZER_DEFAULT_MID2_WIDTH = 1.0f;
    public static final float AL_EQUALIZER_MIN_HIGH_GAIN = 0.126f;
    public static final float AL_EQUALIZER_MAX_HIGH_GAIN = 7.943f;
    public static final float AL_EQUALIZER_DEFAULT_HIGH_GAIN = 1.0f;
    public static final float AL_EQUALIZER_MIN_HIGH_CUTOFF = 4000.0f;
    public static final float AL_EQUALIZER_MAX_HIGH_CUTOFF = 16000.0f;
    public static final float AL_EQUALIZER_DEFAULT_HIGH_CUTOFF = 6000.0f;
    public static final float AL_MIN_AIR_ABSORPTION_FACTOR = 0.0f;
    public static final float AL_MAX_AIR_ABSORPTION_FACTOR = 10.0f;
    public static final float AL_DEFAULT_AIR_ABSORPTION_FACTOR = 0.0f;
    public static final float AL_MIN_ROOM_ROLLOFF_FACTOR = 0.0f;
    public static final float AL_MAX_ROOM_ROLLOFF_FACTOR = 10.0f;
    public static final float AL_DEFAULT_ROOM_ROLLOFF_FACTOR = 0.0f;
    public static final float AL_MIN_CONE_OUTER_GAINHF = 0.0f;
    public static final float AL_MAX_CONE_OUTER_GAINHF = 1.0f;
    public static final float AL_DEFAULT_CONE_OUTER_GAINHF = 1.0f;
    public static final int AL_MIN_DIRECT_FILTER_GAINHF_AUTO = AL.AL_FALSE;
    public static final int AL_MAX_DIRECT_FILTER_GAINHF_AUTO = AL.AL_TRUE;
    public static final int AL_DEFAULT_DIRECT_FILTER_GAINHF_AUTO = AL.AL_TRUE;
    public static final int AL_MIN_AUXILIARY_SEND_FILTER_GAIN_AUTO = AL.AL_FALSE;
    public static final int AL_MAX_AUXILIARY_SEND_FILTER_GAIN_AUTO = AL.AL_TRUE;
    public static final int AL_DEFAULT_AUXILIARY_SEND_FILTER_GAIN_AUTO = AL.AL_TRUE;
    public static final int AL_MIN_AUXILIARY_SEND_FILTER_GAINHF_AUTO = AL.AL_FALSE;
    public static final int AL_MAX_AUXILIARY_SEND_FILTER_GAINHF_AUTO = AL.AL_TRUE;
    public static final int AL_DEFAULT_AUXILIARY_SEND_FILTER_GAINHF_AUTO = AL.AL_TRUE;
    public static final float AL_MIN_METERS_PER_UNIT = Float.MIN_VALUE;
    public static final float AL_MAX_METERS_PER_UNIT = Float.MAX_VALUE;
    public static final float AL_DEFAULT_METERS_PER_UNIT = 1.0f;
    //endregion
    //region Method handles
    /// Method handles.
    public static final class Handles {
        private Handles() { }
        /// The method handle of `alGenEffects`.
        public static final MethodHandle MH_alGenEffects = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGenEffects", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alDeleteEffects`.
        public static final MethodHandle MH_alDeleteEffects = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alDeleteEffects", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alIsEffect`.
        public static final MethodHandle MH_alIsEffect = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alIsEffect", FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
        /// The method handle of `alEffecti`.
        public static final MethodHandle MH_alEffecti = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alEffecti", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
        /// The method handle of `alEffectiv`.
        public static final MethodHandle MH_alEffectiv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alEffectiv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alEffectf`.
        public static final MethodHandle MH_alEffectf = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alEffectf", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_FLOAT));
        /// The method handle of `alEffectfv`.
        public static final MethodHandle MH_alEffectfv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alEffectfv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetEffecti`.
        public static final MethodHandle MH_alGetEffecti = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetEffecti", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetEffectiv`.
        public static final MethodHandle MH_alGetEffectiv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetEffectiv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetEffectf`.
        public static final MethodHandle MH_alGetEffectf = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetEffectf", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetEffectfv`.
        public static final MethodHandle MH_alGetEffectfv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetEffectfv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGenFilters`.
        public static final MethodHandle MH_alGenFilters = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGenFilters", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alDeleteFilters`.
        public static final MethodHandle MH_alDeleteFilters = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alDeleteFilters", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alIsFilter`.
        public static final MethodHandle MH_alIsFilter = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alIsFilter", FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
        /// The method handle of `alFilteri`.
        public static final MethodHandle MH_alFilteri = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alFilteri", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
        /// The method handle of `alFilteriv`.
        public static final MethodHandle MH_alFilteriv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alFilteriv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alFilterf`.
        public static final MethodHandle MH_alFilterf = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alFilterf", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_FLOAT));
        /// The method handle of `alFilterfv`.
        public static final MethodHandle MH_alFilterfv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alFilterfv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetFilteri`.
        public static final MethodHandle MH_alGetFilteri = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetFilteri", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetFilteriv`.
        public static final MethodHandle MH_alGetFilteriv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetFilteriv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetFilterf`.
        public static final MethodHandle MH_alGetFilterf = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetFilterf", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetFilterfv`.
        public static final MethodHandle MH_alGetFilterfv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetFilterfv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGenAuxiliaryEffectSlots`.
        public static final MethodHandle MH_alGenAuxiliaryEffectSlots = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGenAuxiliaryEffectSlots", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alDeleteAuxiliaryEffectSlots`.
        public static final MethodHandle MH_alDeleteAuxiliaryEffectSlots = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alDeleteAuxiliaryEffectSlots", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alIsAuxiliaryEffectSlot`.
        public static final MethodHandle MH_alIsAuxiliaryEffectSlot = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alIsAuxiliaryEffectSlot", FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
        /// The method handle of `alAuxiliaryEffectSloti`.
        public static final MethodHandle MH_alAuxiliaryEffectSloti = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alAuxiliaryEffectSloti", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
        /// The method handle of `alAuxiliaryEffectSlotiv`.
        public static final MethodHandle MH_alAuxiliaryEffectSlotiv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alAuxiliaryEffectSlotiv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alAuxiliaryEffectSlotf`.
        public static final MethodHandle MH_alAuxiliaryEffectSlotf = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alAuxiliaryEffectSlotf", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_FLOAT));
        /// The method handle of `alAuxiliaryEffectSlotfv`.
        public static final MethodHandle MH_alAuxiliaryEffectSlotfv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alAuxiliaryEffectSlotfv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetAuxiliaryEffectSloti`.
        public static final MethodHandle MH_alGetAuxiliaryEffectSloti = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetAuxiliaryEffectSloti", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetAuxiliaryEffectSlotiv`.
        public static final MethodHandle MH_alGetAuxiliaryEffectSlotiv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetAuxiliaryEffectSlotiv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetAuxiliaryEffectSlotf`.
        public static final MethodHandle MH_alGetAuxiliaryEffectSlotf = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetAuxiliaryEffectSlotf", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
        /// The method handle of `alGetAuxiliaryEffectSlotfv`.
        public static final MethodHandle MH_alGetAuxiliaryEffectSlotfv = RuntimeHelper.downcallOrNull(ALInternal.lookup(), "alGetAuxiliaryEffectSlotfv", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    }
    //endregion

    public static void alGenEffects(@CType("ALsizei") int n, @CType("ALuint *") java.lang.foreign.MemorySegment effects) {
        if (Handles.MH_alGenEffects != null) {
        try {
            Handles.MH_alGenEffects.invokeExact(n, effects);
        } catch (Throwable e) { throw new RuntimeException("error in alGenEffects", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGenEffects"); }
    }

    public static void alDeleteEffects(@CType("ALsizei") int n, @CType("const ALuint *") java.lang.foreign.MemorySegment effects) {
        if (Handles.MH_alDeleteEffects != null) {
        try {
            Handles.MH_alDeleteEffects.invokeExact(n, effects);
        } catch (Throwable e) { throw new RuntimeException("error in alDeleteEffects", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alDeleteEffects"); }
    }

    public static @CType("ALboolean") boolean alIsEffect(@CType("ALuint") int effect) {
        if (Handles.MH_alIsEffect != null) {
        try {
            return (boolean) Handles.MH_alIsEffect.invokeExact(effect);
        } catch (Throwable e) { throw new RuntimeException("error in alIsEffect", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alIsEffect"); }
    }

    public static void alEffecti(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("ALint") int iValue) {
        if (Handles.MH_alEffecti != null) {
        try {
            Handles.MH_alEffecti.invokeExact(effect, param, iValue);
        } catch (Throwable e) { throw new RuntimeException("error in alEffecti", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alEffecti"); }
    }

    public static void alEffectiv(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("const ALint *") java.lang.foreign.MemorySegment piValues) {
        if (Handles.MH_alEffectiv != null) {
        try {
            Handles.MH_alEffectiv.invokeExact(effect, param, piValues);
        } catch (Throwable e) { throw new RuntimeException("error in alEffectiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alEffectiv"); }
    }

    public static void alEffectf(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("ALfloat") float flValue) {
        if (Handles.MH_alEffectf != null) {
        try {
            Handles.MH_alEffectf.invokeExact(effect, param, flValue);
        } catch (Throwable e) { throw new RuntimeException("error in alEffectf", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alEffectf"); }
    }

    public static void alEffectfv(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("const ALfloat *") java.lang.foreign.MemorySegment pflValues) {
        if (Handles.MH_alEffectfv != null) {
        try {
            Handles.MH_alEffectfv.invokeExact(effect, param, pflValues);
        } catch (Throwable e) { throw new RuntimeException("error in alEffectfv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alEffectfv"); }
    }

    public static void alGetEffecti(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("ALint *") java.lang.foreign.MemorySegment piValue) {
        if (Handles.MH_alGetEffecti != null) {
        try {
            Handles.MH_alGetEffecti.invokeExact(effect, param, piValue);
        } catch (Throwable e) { throw new RuntimeException("error in alGetEffecti", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetEffecti"); }
    }

    public static void alGetEffectiv(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("ALint *") java.lang.foreign.MemorySegment piValues) {
        if (Handles.MH_alGetEffectiv != null) {
        try {
            Handles.MH_alGetEffectiv.invokeExact(effect, param, piValues);
        } catch (Throwable e) { throw new RuntimeException("error in alGetEffectiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetEffectiv"); }
    }

    public static void alGetEffectf(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("ALfloat *") java.lang.foreign.MemorySegment pflValue) {
        if (Handles.MH_alGetEffectf != null) {
        try {
            Handles.MH_alGetEffectf.invokeExact(effect, param, pflValue);
        } catch (Throwable e) { throw new RuntimeException("error in alGetEffectf", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetEffectf"); }
    }

    public static void alGetEffectfv(@CType("ALuint") int effect, @CType("ALenum") int param, @CType("ALfloat *") java.lang.foreign.MemorySegment pflValues) {
        if (Handles.MH_alGetEffectfv != null) {
        try {
            Handles.MH_alGetEffectfv.invokeExact(effect, param, pflValues);
        } catch (Throwable e) { throw new RuntimeException("error in alGetEffectfv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetEffectfv"); }
    }

    public static void alGenFilters(@CType("ALsizei") int n, @CType("ALuint *") java.lang.foreign.MemorySegment filters) {
        if (Handles.MH_alGenFilters != null) {
        try {
            Handles.MH_alGenFilters.invokeExact(n, filters);
        } catch (Throwable e) { throw new RuntimeException("error in alGenFilters", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGenFilters"); }
    }

    public static void alDeleteFilters(@CType("ALsizei") int n, @CType("const ALuint *") java.lang.foreign.MemorySegment filters) {
        if (Handles.MH_alDeleteFilters != null) {
        try {
            Handles.MH_alDeleteFilters.invokeExact(n, filters);
        } catch (Throwable e) { throw new RuntimeException("error in alDeleteFilters", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alDeleteFilters"); }
    }

    public static @CType("ALboolean") boolean alIsFilter(@CType("ALuint") int filter) {
        if (Handles.MH_alIsFilter != null) {
        try {
            return (boolean) Handles.MH_alIsFilter.invokeExact(filter);
        } catch (Throwable e) { throw new RuntimeException("error in alIsFilter", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alIsFilter"); }
    }

    public static void alFilteri(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("ALint") int iValue) {
        if (Handles.MH_alFilteri != null) {
        try {
            Handles.MH_alFilteri.invokeExact(filter, param, iValue);
        } catch (Throwable e) { throw new RuntimeException("error in alFilteri", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alFilteri"); }
    }

    public static void alFilteriv(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("const ALint *") java.lang.foreign.MemorySegment piValues) {
        if (Handles.MH_alFilteriv != null) {
        try {
            Handles.MH_alFilteriv.invokeExact(filter, param, piValues);
        } catch (Throwable e) { throw new RuntimeException("error in alFilteriv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alFilteriv"); }
    }

    public static void alFilterf(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("ALfloat") float flValue) {
        if (Handles.MH_alFilterf != null) {
        try {
            Handles.MH_alFilterf.invokeExact(filter, param, flValue);
        } catch (Throwable e) { throw new RuntimeException("error in alFilterf", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alFilterf"); }
    }

    public static void alFilterfv(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("const ALfloat *") java.lang.foreign.MemorySegment pflValues) {
        if (Handles.MH_alFilterfv != null) {
        try {
            Handles.MH_alFilterfv.invokeExact(filter, param, pflValues);
        } catch (Throwable e) { throw new RuntimeException("error in alFilterfv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alFilterfv"); }
    }

    public static void alGetFilteri(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("ALint *") java.lang.foreign.MemorySegment piValue) {
        if (Handles.MH_alGetFilteri != null) {
        try {
            Handles.MH_alGetFilteri.invokeExact(filter, param, piValue);
        } catch (Throwable e) { throw new RuntimeException("error in alGetFilteri", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetFilteri"); }
    }

    public static void alGetFilteriv(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("ALint *") java.lang.foreign.MemorySegment piValues) {
        if (Handles.MH_alGetFilteriv != null) {
        try {
            Handles.MH_alGetFilteriv.invokeExact(filter, param, piValues);
        } catch (Throwable e) { throw new RuntimeException("error in alGetFilteriv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetFilteriv"); }
    }

    public static void alGetFilterf(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("ALfloat *") java.lang.foreign.MemorySegment pflValue) {
        if (Handles.MH_alGetFilterf != null) {
        try {
            Handles.MH_alGetFilterf.invokeExact(filter, param, pflValue);
        } catch (Throwable e) { throw new RuntimeException("error in alGetFilterf", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetFilterf"); }
    }

    public static void alGetFilterfv(@CType("ALuint") int filter, @CType("ALenum") int param, @CType("ALfloat *") java.lang.foreign.MemorySegment pflValues) {
        if (Handles.MH_alGetFilterfv != null) {
        try {
            Handles.MH_alGetFilterfv.invokeExact(filter, param, pflValues);
        } catch (Throwable e) { throw new RuntimeException("error in alGetFilterfv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetFilterfv"); }
    }

    public static void alGenAuxiliaryEffectSlots(@CType("ALsizei") int n, @CType("ALuint *") java.lang.foreign.MemorySegment effectslots) {
        if (Handles.MH_alGenAuxiliaryEffectSlots != null) {
        try {
            Handles.MH_alGenAuxiliaryEffectSlots.invokeExact(n, effectslots);
        } catch (Throwable e) { throw new RuntimeException("error in alGenAuxiliaryEffectSlots", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGenAuxiliaryEffectSlots"); }
    }

    public static void alDeleteAuxiliaryEffectSlots(@CType("ALsizei") int n, @CType("const ALuint *") java.lang.foreign.MemorySegment effectslots) {
        if (Handles.MH_alDeleteAuxiliaryEffectSlots != null) {
        try {
            Handles.MH_alDeleteAuxiliaryEffectSlots.invokeExact(n, effectslots);
        } catch (Throwable e) { throw new RuntimeException("error in alDeleteAuxiliaryEffectSlots", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alDeleteAuxiliaryEffectSlots"); }
    }

    public static @CType("ALboolean") boolean alIsAuxiliaryEffectSlot(@CType("ALuint") int effectslot) {
        if (Handles.MH_alIsAuxiliaryEffectSlot != null) {
        try {
            return (boolean) Handles.MH_alIsAuxiliaryEffectSlot.invokeExact(effectslot);
        } catch (Throwable e) { throw new RuntimeException("error in alIsAuxiliaryEffectSlot", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alIsAuxiliaryEffectSlot"); }
    }

    public static void alAuxiliaryEffectSloti(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("ALint") int iValue) {
        if (Handles.MH_alAuxiliaryEffectSloti != null) {
        try {
            Handles.MH_alAuxiliaryEffectSloti.invokeExact(effectslot, param, iValue);
        } catch (Throwable e) { throw new RuntimeException("error in alAuxiliaryEffectSloti", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alAuxiliaryEffectSloti"); }
    }

    public static void alAuxiliaryEffectSlotiv(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("const ALint *") java.lang.foreign.MemorySegment piValues) {
        if (Handles.MH_alAuxiliaryEffectSlotiv != null) {
        try {
            Handles.MH_alAuxiliaryEffectSlotiv.invokeExact(effectslot, param, piValues);
        } catch (Throwable e) { throw new RuntimeException("error in alAuxiliaryEffectSlotiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alAuxiliaryEffectSlotiv"); }
    }

    public static void alAuxiliaryEffectSlotf(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("ALfloat") float flValue) {
        if (Handles.MH_alAuxiliaryEffectSlotf != null) {
        try {
            Handles.MH_alAuxiliaryEffectSlotf.invokeExact(effectslot, param, flValue);
        } catch (Throwable e) { throw new RuntimeException("error in alAuxiliaryEffectSlotf", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alAuxiliaryEffectSlotf"); }
    }

    public static void alAuxiliaryEffectSlotfv(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("const ALfloat *") java.lang.foreign.MemorySegment pflValues) {
        if (Handles.MH_alAuxiliaryEffectSlotfv != null) {
        try {
            Handles.MH_alAuxiliaryEffectSlotfv.invokeExact(effectslot, param, pflValues);
        } catch (Throwable e) { throw new RuntimeException("error in alAuxiliaryEffectSlotfv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alAuxiliaryEffectSlotfv"); }
    }

    public static void alGetAuxiliaryEffectSloti(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("ALint *") java.lang.foreign.MemorySegment piValue) {
        if (Handles.MH_alGetAuxiliaryEffectSloti != null) {
        try {
            Handles.MH_alGetAuxiliaryEffectSloti.invokeExact(effectslot, param, piValue);
        } catch (Throwable e) { throw new RuntimeException("error in alGetAuxiliaryEffectSloti", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetAuxiliaryEffectSloti"); }
    }

    public static void alGetAuxiliaryEffectSlotiv(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("ALint *") java.lang.foreign.MemorySegment piValues) {
        if (Handles.MH_alGetAuxiliaryEffectSlotiv != null) {
        try {
            Handles.MH_alGetAuxiliaryEffectSlotiv.invokeExact(effectslot, param, piValues);
        } catch (Throwable e) { throw new RuntimeException("error in alGetAuxiliaryEffectSlotiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetAuxiliaryEffectSlotiv"); }
    }

    public static void alGetAuxiliaryEffectSlotf(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("ALfloat *") java.lang.foreign.MemorySegment pflValue) {
        if (Handles.MH_alGetAuxiliaryEffectSlotf != null) {
        try {
            Handles.MH_alGetAuxiliaryEffectSlotf.invokeExact(effectslot, param, pflValue);
        } catch (Throwable e) { throw new RuntimeException("error in alGetAuxiliaryEffectSlotf", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetAuxiliaryEffectSlotf"); }
    }

    public static void alGetAuxiliaryEffectSlotfv(@CType("ALuint") int effectslot, @CType("ALenum") int param, @CType("ALfloat *") java.lang.foreign.MemorySegment pflValues) {
        if (Handles.MH_alGetAuxiliaryEffectSlotfv != null) {
        try {
            Handles.MH_alGetAuxiliaryEffectSlotfv.invokeExact(effectslot, param, pflValues);
        } catch (Throwable e) { throw new RuntimeException("error in alGetAuxiliaryEffectSlotfv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: alGetAuxiliaryEffectSlotfv"); }
    }

    //@formatter:on
    //endregion ---[END GENERATOR END]---

    private ALCEXTEFX() {
    }
}
