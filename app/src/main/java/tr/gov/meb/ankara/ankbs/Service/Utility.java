package tr.gov.meb.ankara.ankbs.Service;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Basak on 2.01.2017.
 */



    public class Utility {
        private static Pattern pattern;
        private static Matcher matcher;
        //Email Pattern
        private static final String EMAIL_PATTERN = "";

        /**
         * Validate Email with regular expression
         *
         * @param email
         * @return true for Valid Email and false for Invalid Email
         */
        public static boolean validate(String email) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email);
            return matcher.matches();

        }
        /**
         * Checks for Null String object
         *
         * @param txt
         * @return true for not null and false for null String object
         */
        public static boolean isNotNull(String txt){
            return txt!=null && txt.trim().length()>0 ? true: false;
        }


        public static <T> List<T> GsonToList(String gsonString, Class<T[]> cls) {
            T[] arr = new Gson().fromJson(gsonString, cls);
            return Arrays.asList(arr);
        }
    }


