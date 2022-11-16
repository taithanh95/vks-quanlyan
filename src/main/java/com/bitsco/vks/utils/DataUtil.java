package com.bitsco.vks.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

public class DataUtil {

    public static boolean isNullOrZero(Long value) {
        return (value == null || value.equals(0L));
    }
    public static boolean isNullOrZero(BigDecimal value) {
        return (value == null || value.compareTo(BigDecimal.ZERO) == 0);
    }
    public static Long safeToLong(Object obj1, Long defaultValue) {
        Long result = defaultValue;
        if (obj1 != null) {
            try {
                result = Long.parseLong(obj1.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public static Long safeToLong(Object obj1) {
        Long result = null;
        if (obj1 != null) {
            try {
                result = Long.parseLong(obj1.toString());
            } catch (Exception ex) {
//                logger.error(ex.getMessage(), ex);
                ex.printStackTrace();
            }
        }

        return result;
    }
    public static BigDecimal safeToBigDecimal(Object obj1) {
        BigDecimal result = new BigDecimal(0);
        if (obj1 != null) {
            try {
                result = BigDecimal.valueOf(Long.parseLong(obj1.toString()));
            } catch (Exception ex) {
//                logger.error(ex.getMessage(), ex);
                ex.printStackTrace();
            }
        }

        return result;
    }

    public static Double safeToDouble(Object obj1) {
        Double result = null;
        if (obj1 != null) {
            try {
                result = Double.parseDouble(obj1.toString());
            } catch (Exception ex) {
//                logger.error(ex.getMessage(), ex);
                ex.printStackTrace();
            }

        }

        return result;
    }

    public static Short safeToShort(Object obj1) {
        Short result = 0;
        if (obj1 != null) {
            try {
                result = Short.parseShort(obj1.toString());
            } catch (Exception ex) {
//                logger.error(ex.getMessage(), ex);
                ex.printStackTrace();
            }
        }

        return result;
    }

    public static int safeToInt(Object obj1) {
        int result = 0;
        if (obj1 == null) {
            return 0;
        }
        try {
            result = Integer.parseInt(obj1.toString());
        } catch (Exception ex) {
//            logger.error(ex.getMessage(), ex);
            ex.printStackTrace();
        }

        return result;
    }

    public static String safeToString(Object obj1) {
        if (obj1 == null) {
            return "";
        }

        return obj1.toString();
    }

    public static Date safeToDate(Object obj1) {
        Date result = null;
        if (obj1 == null) {
            return null;
        }
        try {
            result = (Date) obj1;
        } catch (Exception ex) {
//            logger.error(ex.getMessage(), ex);
            ex.printStackTrace();
        }
        return result;
    }

    @Deprecated
    public static boolean isNullObject(Object obj1) {
        if (obj1 == null) {
            return true;
        }
        if (obj1 instanceof String) {
            return isNullOrEmpty(obj1.toString());
        }
        return false;
    }
    public static boolean isNullOrEmpty(String value) {
        return (value == null || value.isEmpty());
    }
    public static boolean isNullOrEmpty(final Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
    public static boolean safeEqual(Long obj1, Long obj2) {
        if (obj1 == obj2) {
            return true;
        }
        return ((obj1 != null) && (obj2 != null) && (obj1.compareTo(obj2) == 0));
    }

    public static boolean safeEqual(String obj1, String obj2) {
        if (obj1 == obj2) {
            return true;
        }
        return ((obj1 != null) && (obj2 != null) && obj1.equals(obj2));
    }
}

