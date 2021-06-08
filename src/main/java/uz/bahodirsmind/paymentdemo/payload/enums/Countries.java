package uz.bahodirsmind.paymentdemo.payload.enums;

public enum Countries {
    UZB("Uzbekistan"),
    KRG("Kirgizistan"),
    ENG("England"),
    USA("United states of America");
    public final String name;

    Countries(String name) {
        this.name = name;
    }
}
