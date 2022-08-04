package cn.mc.zcc.entity;

import cn.mc.zcc.info.Element;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Role extends RoleBase {


    public Role(String name, int id, Element element, int exp, int damage) {
        super(name, id, element, exp, damage);
    }

    @Override
    public void attackEvent(Player player) {

    }

    @Override
    public void attackEntityEvent(Player player, Entity entity) {

    }

    @Override
    public void jumpEvent(Player player) {

    }

    @Override
    public void shiftEvent(Player player) {

    }

    @Override
    public void spawnEvent(Player player) {

    }

    @Override
    public void elementUpEvent(Player player, Element element, EntityElement entityElement) {

    }

    @Override
    public void elementDownEvent(Player player, Element element, EntityElement entityElement) {

    }

    @Override
    public void elementNewUpEvent(Player player, Element newElement, Element... oldElement) {

    }


}
