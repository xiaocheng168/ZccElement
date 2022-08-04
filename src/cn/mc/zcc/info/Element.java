package cn.mc.zcc.info;

//元素反应列表
public enum Element {
    NOT("尘", 0),
    FIRE("火", 1),
    WATER("水", 2),
    GRASS("草", 3),
    ICE("冰", 4),
    RAY("雷", 5),
    WIND("风", 6),
    ROCK("岩", 7);
    //元素名
    private final String name;
    //元素id
    private final int id;

    Element(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
