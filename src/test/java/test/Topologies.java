package test;

public enum Topologies {
    Num124("Форма МОП 124"),
    Num122("Форма МОП 122"),
    Num126("Форма МОП 126"),
    Num61("Форма МОП 61"),
    Num128("Форма МОП 128");
    private final String desc;

    Topologies(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}