/*
 * MIT License
 *
 * Copyright (c) 2022 Overrun Organization
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

package org.overrun.glib;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.ValueLayout;

import static java.lang.foreign.ValueLayout.*;

/**
 * The function descriptors.
 *
 * <h2>Char-table</h2>
 * <pre>{@code
 * switch (c) {
 *     case 'B' -> JAVA_BYTE;
 *     case 'S' -> JAVA_SHORT;
 *     case 'I' -> JAVA_INT;
 *     case 'J' -> JAVA_LONG;
 *     case 'C' -> JAVA_CHAR;
 *     case 'Z' -> JAVA_BOOLEAN;
 *     case 'F' -> JAVA_FLOAT;
 *     case 'D' -> JAVA_DOUBLE;
 *     case 'P' -> ADDRESS;
 *     case 'p' -> RuntimeHelper.ADDRESS_UNBOUNDED;
 *     default -> throw();
 * }}</pre>
 *
 * @author squid233
 * @since 0.1.0
 */
public enum FunctionDescriptors {
    // 1
    D, I, J, P, p, V,
    // 2
    BV, DV, FV, II, IJ, IP, Ip, IV, IZ, JP, JV, JZ, PF,
    /**
     * Make it doesn't confuse with {@link Math#PI}.
     */
    fd_PI("PI"),
    PP, Pp, PV, PZ, SV, ZV,
    // 3
    DDV, FFV, FZV, IDV, IFV, III, IIJ, IIP, IIp, IIV, IIZ, IJV, IPI, IPP, IPp, IPV, ISV, JIV, JJP, PFV, PII, PIV, PJP, PPI,
    PPP, PPp, PPV, SSV,
    // 4
    BBBV, DDDV, FFFV, IDDV, IFFV, IIDV, IIFV, IIII, IIIV, IIJV, IIPI, IIPV, IJJV, IPIV, IPPV, IPPZ, ISSV, PDDV, PIIP, PIIV,
    PIJI, PIJP, PIJV, PIPp, PIPV, PPII, PPIP, PPJP, PPPV, SSSV,
    // 5
    BBBBV, DDDDV, FFFFV, IDDDV, IFFFV, IIDDV, IIFFV, IIFIV, IIIIV, IIIJV, IIIPV, IIJIV, IIPIV, IIPPV, IIZIV, IIZPV, IJJIP,
    IJJPV, IJPIV, IPIIV, IPPIV, ISSSV, PIIIP, PIIPp, PIPII, PIPIp, PIPPV, PPPPI, PPPPV, SSSSV, ZZZZV,
    // 6
    FFFFFV, IBBBBV, IDDDDV, IFFFFV, IIDDDV, IIFFFV, IIIFIV, IIIIIV, IIIIPV, IIIJIV, IIIJJV, IIIPIV, IIIPPP, IIIPPV, IIIPZV,
    IIIZIV, IIIZPV, IIJJJV, IIPIIV, IIPIPV, IIPPPP, IIPPPV, IIZIIJ, IPIPIV, IPIPPV, IPJIIV, IPPIPV, ISSSSV, IZIIPV, IZZZZV,
    PIIIIV, PIIIPI, PIIPIp, PIIPPV, PIPPPI, PPIIIP, PPPIIV, PPPPIp, PPPPPI, PPPPPV,
    // 7
    BBBBFFV, DDDDDDV, FFFFFFV, IDDIDDV, IDDIIPV, IFFFFFV, IFFIFFV, IFFIIPV, IIDDDDV, IIFFFFV, IIIIIIV, IIIIIPV, IIIIIZV,
    IIIIPPV, IIIIPZV, IIIIZIV, IIIPIIV, IIIPPIV, IIIPPPV, IIIZIPV, IIPJIIV, IPIPIPV, PIIIIPp, PIPPPIp, PPIIIPI, PPIPIIV,
    PPPPPIp,
    // 8
    BBBBFFFV, IFFFFFFV, IIDDIIPV, IIFFFFPV, IIFFIIPV, IIIIIIIV, IIIIIIPV, IIIIIIZV, IIIIIPIV, IIIPIIIV, IIIPPPPV, IIIZIIIV,
    IIJJIIPV, IIPIIIIV, IIPPPPPI, IIPPPPPV, PPIIIIIV,
    // 9
    FFFFFFFFV, IBBBBFFFV, IIIIIIIIV, IIIIIIIPV, IIIIPIPPV, IIPPPPPPI, PIPPPPPIp,
    // 10
    FFBBBBFFFV, IFFFFFFFFV, IIIIIIIIIV, IIIIIIIIPV, PIIIPIIIII,
    // 11
    FFFFFFFFFFV, IDDIIDDIIPV, IFFIIFFIIPV, IIIIIIIIIIV, IIIIIIIIIPV,
    // 12
    IFFFFFFFFFFV, IIDDIIDDIIPV, IIFFIIFFIIPV, IIIIIIIIIIPV, IIIPIPPPPPPV, PIIIPIIIIIII,
    // 13
    FFFFFFFFFFFFV, IIIIIIIIIIIIV, IIIIIIIIIIIPV, PIIIPIIIIIIII,
    // 14
    IFFFFFFFFFFFFV,
    // 16
    FFFFFFFFFFFFFFFV, IIIIIIIIIIIIIIIV, PIIIPIIIIIIIIIPI,
    // 19
    PIIIPIIIIIIIIIIIIPI,
    // 23
    PIIIPIIIIIIIIIIIIPFFFFI,
    ;

    private final FunctionDescriptor descriptor;

    FunctionDescriptors(String customName) {
        descriptor = ofDescriptor(customName);
    }

    FunctionDescriptors() {
        descriptor = ofDescriptor(name());
    }

    /**
     * Gets the value layout of the specified char.
     *
     * @param c the character
     * @return the value layout
     * @throws IllegalArgumentException if <i>{@code c}</i> is not a value layout mark.
     */
    public static ValueLayout ofValue(char c) throws IllegalArgumentException {
        return switch (c) {
            case 'B' -> JAVA_BYTE;
            case 'S' -> JAVA_SHORT;
            case 'I' -> JAVA_INT;
            case 'J' -> JAVA_LONG;
            case 'C' -> JAVA_CHAR;
            case 'Z' -> JAVA_BOOLEAN;
            case 'F' -> JAVA_FLOAT;
            case 'D' -> JAVA_DOUBLE;
            case 'P' -> ADDRESS;
            case 'p' -> RuntimeHelper.ADDRESS_UNBOUNDED;
            default ->
                throw new IllegalArgumentException("Invalid mark of argument c: expected B,S,I,J,C,Z,F,D,P,p; got '" + c + '\'');
        };
    }

    /**
     * Create the function descriptor of the string.
     *
     * @param str the string
     * @return the function descriptor
     */
    public static FunctionDescriptor ofDescriptor(String str) {
        final int len = str.length();
        ValueLayout[] layouts = new ValueLayout[len - 1];
        for (int i = 0; i < layouts.length; i++) {
            layouts[i] = ofValue(str.charAt(i));
        }
        if (str.endsWith("V")) {
            return FunctionDescriptor.ofVoid(layouts);
        }
        return FunctionDescriptor.of(ofValue(str.charAt(len - 1)), layouts);
    }

    /**
     * Gets the function descriptor.
     *
     * @return the function descriptor
     */
    public FunctionDescriptor descriptor() {
        return descriptor;
    }
}
