package cn.mc.zcc.entity.roles;

import cn.mc.zcc.entity.EntityElement;
import cn.mc.zcc.entity.Role;
import cn.mc.zcc.info.Element;
import cn.mc.zcc.info.PlayerInfo;
import cn.mc.zcc.manager.ElementManager;
import cn.mc.zcc.manager.PlayerManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Paimo extends Role {
    public Paimo(String name, int id, Element element, int exp, int damage) {
        super(name, id, element, exp, damage);
    }

    @Override
    public void elementUpEvent(Player player, Element element, EntityElement entityElement) {
        System.out.println("附着元素: " + element.getName());
    }

    @Override
    public void elementDownEvent(Player player, Element element, EntityElement entityElement) {
        System.out.println("消失元素: " + element.getName());
    }

    @Override
    public void attackEntityEvent(Player player, Entity entity) {
        System.out.println("你攻击了一个 " + entity.getName());
        //ElementManager.entityElement(player, Element.FIRE, 5);
        ElementManager.entityElement(player, Element.WATER, 5);
    }
}
