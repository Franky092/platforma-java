package test.hvac;

public enum Topologies {
    Num124("Форма МОП 124"),
    Num128("Форма МОП 128");
    private final String desc;

    Topologies(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}