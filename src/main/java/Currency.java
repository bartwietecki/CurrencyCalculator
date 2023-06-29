public enum Currency {
    USD("US Dollar"),
    JPY("Japanese Yen"),
    BGN("Bulgarian Lev"),
    DKK("Danish Krone"),
    GBP("British Pound"),
    HUF("Hungarian Forint"),
    PLN("Polish Zloty"),
    RON("Romanian Leu"),
    SEK("Swedish Krona"),
    CHF("Swiss Franc"),
    ISK("Icelandic Krona"),
    NOK("Norwegian Krone"),
    HRK("Croatian Kuna"),
    RUB("Russian Ruble"),
    TRY("Turkish Lira"),
    AUD("Australian Dollar"),
    BRL("Brazilian Real"),
    CAD("Canadian Dollar"),
    CNY("Chinese Yuan"),
    HKD("Hong Kong Dollar"),
    IDR("Indonesian Rupiah"),
    ILS("Israeli Shekel"),
    INR("Indian Rupee"),
    KRW("South Korean Won"),
    MXN("Mexican Peso"),
    MYR("Malaysian Ringgit"),
    NZD("New Zealand Dollar"),
    PHP("Philippine Peso"),
    SGD("Singapore Dollar"),
    THB("Thai Baht"),
    ZAR("South African Rand");

    private String fullName;

    Currency(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
