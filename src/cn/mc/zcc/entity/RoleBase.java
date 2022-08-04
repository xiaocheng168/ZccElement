package cn.mc.zcc.entity;


import cn.mc.zcc.info.Element;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

//角色信息
public abstract class RoleBase implements Serializable {
    //角色名称
    private String name;
    //角色id
    private int id;
    //角色元素
    private Element element;
    //角色经验
    private int exp;
    //角色最大加经验值
    private int maxExp;
    //角色基本伤害
    private int damage;
    //暴击伤害加成
    private float crit = 0f;
    //暴击率
    private float luck_crit = 0f;
    //元素伤害
    private final HashMap<Element, Float> elementDamage = new LinkedHashMap<>();

    public RoleBase(String name, int id, Element element, int exp, int damage) {
        this.name = name;
        this.id = id;
        this.element = element;
        this.exp = exp;
        this.damage = damage;
        //初始化角色基本信息
        this.init();

    }

    //角色初始化
    public void init() {
        //计算元素反应伤害
        for (Element value : Element.values()) {
            elementDamage.put(value, 0f);
        }
    }

    //事件表
    //使用角色攻击时，触发的事件
    abstract public void attackEvent(Player player);

    //使用角色攻击到实体时触发，触发的事件
    abstract public void attackEntityEvent(Player player, Entity entity);

    //跳跃事件
    abstract public void jumpEvent(Player player);

    //蹲下事件
    abstract public void shiftEvent(Player player);

    //切换当前角色出场时触发
    abstract public void spawnEvent(Player player);

    //当角色被一个元素附着事触发
    abstract public void elementUpEvent(Player player, Element element, EntityElement entityElement);

    //当前角色一个元素附着消失触发
    abstract public void elementDownEvent(Player player, Element element, EntityElement entityElement);

    //元素反应 参 为 玩家、新附着的元素、附着新元素之前已附着的元素
    abstract public void elementNewUpEvent(Player player, Element newElement, Element... oldElement);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public HashMap<Element, Float> getElementDamage() {
        return elementDamage;
    }

    public float getCrit() {
        return crit;
    }

    public void setCrit(float crit) {
        this.crit = crit;
    }

    public float getLuck_crit() {
        return luck_crit;
    }

    public void setLuck_crit(float luck_crit) {
        this.luck_crit = luck_crit;
    }


    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }
}
