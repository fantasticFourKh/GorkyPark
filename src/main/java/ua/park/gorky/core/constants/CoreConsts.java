package ua.park.gorky.core.constants;

/**
 * @author Vladyslav
 */
public class CoreConsts {

    public static class Pattern {
        private static final String INTERNATIONAL_SYMBOL = "[А-ЯA-Z][а-яa-z]";
        private static final String TEXT_START = "^";
        private static final String TEXT_END = "$";

        public static final String NUMBERS = "^[0-9]+$";
        public static final String INTERNATIONAL = TEXT_START + "[a-zA-Z0-9\\-\\_\\.\\,]{4,20}" + TEXT_END;
        public static final String PHONE = TEXT_START + "(\\+38)?[0](50|63|66|67|68|91|92|93|94|95|96|97|98|99)\\d{7}" + TEXT_END;
        public static final String PASS = TEXT_START + "[a-zA-Z0-9\\_\\-\\.]{3,16}" + TEXT_END;
        public static final String EMAIL = TEXT_START + "[\\w|\\.|\\-|\\_]+@[a-z]{2,}\\.[a-z]{2,3}" + TEXT_END;
        public static final String PERSONAL = TEXT_START + INTERNATIONAL_SYMBOL + "{1,20}" + TEXT_END;
    }
}
