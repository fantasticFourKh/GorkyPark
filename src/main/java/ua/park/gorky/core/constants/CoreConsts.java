package ua.park.gorky.core.constants;

/**
 * @author Vladyslav
 */
public class CoreConsts {

    public static class Pattern {
        public static final String NUMBERS = "^[0-9]+$";
        public static final String INTERNATIONAL = "^[a-zA-Z0-9\\-\\_\\.\\,]{4,20}$";
        public static final String PHONE = "^(\\+38)?[0](50|63|66|67|68|91|92|93|94|95|96|97|98|99)\\d{7}$";
        public static final String PASS = "^[a-zA-Z0-9\\_\\-\\.]{3,16}$";
        public static final String EMAIL = "^[\\w|\\.|\\-|\\_]+@[a-z]{2,}\\.[a-z]{2,3}$";
        public static final String PERSONAL = "^[А-ЯA-Z][а-яa-z]{1,20}$";
    }
}
