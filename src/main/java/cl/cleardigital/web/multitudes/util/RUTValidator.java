package cl.cleardigital.web.multitudes.util;

import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;

/**
 * RUT Validator.
 * 
 * @author ALARA
 */

@Configuration
public class RUTValidator {

    /**
     * This method validates that the value corresponds to a valid
     * currency for the locale.
     * 
     * @param value
     *            The value.
     */
    public static boolean isRUT(String value, Locale currentLocale) {

        // Verify the length
        int length = value.length();
        if (length > 9) {
            return false;
        }

        // Convert to uppercase and insert zeroes if necessary
        value = "000000000".substring(0, 9 - length).concat(value.toUpperCase());

        // Validates with regular expression (first filter)
        String regexp = "[0-9]{1,8}([0-9]|K)";

        boolean isValidRUT = Pattern.matches(regexp, value);
        if (!isValidRUT) {
            return false;
        }

        // Validates verifying digit (second filter)
        int[] digits = new int[8];
        digits[0] = value.charAt(0) - '0';
        digits[1] = value.charAt(1) - '0';
        digits[2] = value.charAt(2) - '0';
        digits[3] = value.charAt(3) - '0';
        digits[4] = value.charAt(4) - '0';
        digits[5] = value.charAt(5) - '0';
        digits[6] = value.charAt(6) - '0';
        digits[7] = value.charAt(7) - '0';
        char verifying = value.charAt(8);

        int suma = 0;
        int localDigit = 432765432;
        for (int i = 7; i >= 0; i--) {
            suma += digits[i] * (localDigit % 10);
            localDigit /= 10;
        }

        int valor = 11 - (suma % 11);
        boolean result = false;
        switch (valor) {
        case 11:
            result = verifying == '0';
            break;
        case 10:
            result = verifying == 'K';
            break;
        default:
            result = verifying == ('0' + valor);
            break;
        }

        // valid RUT
        return result;
    }

    /**
     * This method parses a RUT number.
     * Este metodo parsea el rut agregando 
     * Zeros a la izquierda
     * @param value
     *            The value.
     */
    public static String parseRUT(String value) {

        // Convert to uppercase and insert zeroes if necessary
        if (value.length() > 9) {
            value = value.substring(0, 9);
        }
        int length = value.length();
        value = "000000000".substring(0, 9 - length).concat(value.toUpperCase());

        // valid RUT
        return value;
    }
    
    /**
     * Si el RUT tiene 0 al principio se lo quita y devuelve el mismo sin 0.
     * 
     * @param value
     * @return String
     */
    public static String parseRUTWithoutZeros(String value) {
		return (value.substring(0, 1).equalsIgnoreCase("0")) ? value.substring(1, value.length()) : value;
		
    }
    /**
     * This method formats a RUT number.
     * 
     * @param value
     *            The value.
     */
    public static String formatRUT(String value) {

        // Convert to uppercase
        value = value.toUpperCase();

        // Remove leading zeroes
        while (value.charAt(0) == '0' && value.length() > 2) {
            value = value.substring(1);
        }

        // Insert '.' and '-'
        StringBuffer buffer = new StringBuffer();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            buffer.append(value.charAt(i));
            if (length - i == 8 || length - i == 5) {
                buffer.append(".");
            } else if (length - i == 2) {
                buffer.append("-");
            }
        }

        // valid RUT
        return buffer.toString();
    }
    
}