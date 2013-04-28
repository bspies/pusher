package org.pusher.util;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Utility class with factory methods for producing common {@link Converter}
 * implementations.
 *
 * @author Brennan Spies
 */
public final class Conversions {

    private Conversions() {}

    /**
     * Returns a Short converter.
     * @return The converter
     */
    public static Converter<Short> toShort() {
        return new Converter<Short>() {
            public Short convert(@Nonnull String value) {
                return Short.parseShort(value);
            }
        };
    }

    /**
     * Returns an Integer converter.
     * @return The converter
     */
    public static Converter<Integer> toInteger() {
        return new Converter<Integer>() {
            public Integer convert(@Nonnull String value) {
                return Integer.parseInt(value);
            }
        };
    }

    /**
     * Returns a Long converter.
     * @return The converter
     */
    public static Converter<Long> toLong() {
        return new Converter<Long>() {
            public Long convert(@Nonnull String value) {
                return Long.parseLong(value);
            }
        };
    }

    /**
     * Returns a Float converter.
     * @return The converter
     */
    public static Converter<Float> toFloat() {
        return new Converter<Float>() {
            public Float convert(@Nonnull String value) {
                return Float.parseFloat(value);
            }
        };
    }

    /**
     * Returns a Double converter.
     * @return The converter
     */
    public static Converter<Double> toDouble() {
        return new Converter<Double>() {
            public Double convert(@Nonnull String value) {
                return Double.parseDouble(value);
            }
        };
    }

    /**
     * Returns a BigDecimal converter.
     * @return The converter
     */
    public static Converter<BigDecimal> toBigDecimal() {
        return new Converter<BigDecimal>() {
            public BigDecimal convert(@Nonnull String value) {
                return new BigDecimal(value);
            }
        };
    }

    /**
     * Returns a BigInteger converter.
     * @return The converter
     */
    public static Converter<BigInteger> toBigInteger() {
        return new Converter<BigInteger>() {
            public BigInteger convert(@Nonnull String value) {
                return new BigInteger(value);
            }
        };
    }

    /**
     * Returns a Date converter.
     * @return The converter
     */
    public static Converter<Date> toDate() {
        return new Converter<Date>() {
            public Date convert(@Nonnull String value) {
                try {
                    return DateFormat.getInstance().parse(value);
                } catch (ParseException e) {
                    throw new ConversionException(String.format("Unable to parse '%s' into java.util.Date", value), e);
                }
            }
        };
    }
}
