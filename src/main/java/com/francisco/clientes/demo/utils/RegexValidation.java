package com.francisco.clientes.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidation {

    public static Boolean validateEmailPattern(String email) {
        final String emailRegEx = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern _pattern = Pattern.compile(emailRegEx);
        Matcher matcher = _pattern.matcher(email);
        return matcher.matches();
    }


    public static  Boolean validateCellphoneNumberPattern(String cellphone) {
        final String cellphoneRegEx
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

        Pattern pattern = Pattern.compile(cellphoneRegEx);
        Matcher matcher = pattern.matcher(cellphone);
        return  matcher.matches();


    }

    public static Boolean validateOnlyAlphabet(String _string) {
        final String alphabetRegEx = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";

        Pattern pattern = Pattern.compile(alphabetRegEx);
        Matcher matcher = pattern.matcher(_string);
        return  matcher.matches();
    }

}
