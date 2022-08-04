package cn.mc.zcc.info;

//元素反应列表
public enum Element {
    NOT("尘", 0, "§8"),
    FIRE("火", 1, "§4"),
    WATER("水", 2, "§3"),
    GRASS("草", 3, "§2"),
    ICE("冰", 4, "§b"),
    RAY("雷", 5, "§4"),
    WIND("风", 6, "§7"),
    ROCK("岩", 7, "§c");
    //元素名
    private final String name;
    //元素id
    private final int id;

    //元素颜色
    private final String color;

    Element(String name, int id, String color) {
        this.name = name;
        this.id = id;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getColorName() {
        return this.color + this.name;
    }
}
