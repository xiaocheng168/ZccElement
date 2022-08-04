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
    void attackEntityEvent(Player player, Entity entity) {

    }

    @Override
    void JumpEvent(Player player) {

    }

    @Override
    void ShiftEvent(Player player) {

    }

    @Override
    void SpawnEvent(Player player) {

    }
}
