package cn.mc.zcc.info;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.C;

//元素反应列表
public enum Element {
    NOT("尘", 0, "§8", Color.fromRGB(102, 102, 102)),
    FIRE("火", 1, "§4", Color.fromRGB(243, 18, 8)),
    WATER("水", 2, "§3", Color.fromRGB(58, 156, 225)),
    GRASS("草", 3, "§2", Color.fromRGB(114, 187, 0)),
    ICE("冰", 4, "§b", Color.fromRGB(131, 217, 255)),
    RAY("雷", 5, "§4", Color.fromRGB(240, 67, 255)),
    WIND("风", 6, "§7", Color.fromRGB(153, 153, 153)),
    ROCK("岩", 7, "§c", Color.fromRGB(217, 116, 0));
    //元素名
    private final String name;
    //元素id
    private final int id;

    //元素颜色
    private final String color;
    //元素粒子特效颜色
    private final Color effectColor;

    Element(String name, int id, String color, Color effectColor) {
        this.name = name;
        this.id = id;
        this.color = color;
        this.effectColor = effectColor;
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

    public Color getEffectColor() {
        return effectColor;
    }

    public void playEffect(Player player) {
        ParticleBuilder builder = Particle.REDSTONE.builder();
        Particle.DustOptions dustOptions = new Particle.DustOptions(this.effectColor, 1);
        player.spawnParticle(builder.particle(), player.getLocation().clone().add(0, 2, 0), 2, dustOptions);
    }
}
