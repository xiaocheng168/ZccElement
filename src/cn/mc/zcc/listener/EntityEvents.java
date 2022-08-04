package cn.mc.zcc.listener;

import cn.mc.zcc.entity.EntityElement;
import cn.mc.zcc.info.Element;
import cn.mc.zcc.manager.ElementManager;
import cn.mc.zcc.manager.PlayerManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.HashSet;
import java.util.Set;


//实体相关事件
public class EntityEvents implements Listener {

    //附着火元素所需反应
    public Set<EntityDamageEvent.DamageCause> fireElement = new HashSet<>();

    {
        //岩浆伤害
        fireElement.add(EntityDamageEvent.DamageCause.LAVA);
        //火伤害
        fireElement.add(EntityDamageEvent.DamageCause.FIRE);
        //火间伤
        fireElement.add(EntityDamageEvent.DamageCause.FIRE_TICK);
        //岩浆块火伤
        fireElement.add(EntityDamageEvent.DamageCause.HOT_FLOOR);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        System.out.println(event.getCause().name());
        //火元素附着处理
        if (this.fireElement.contains(event.getCause())) {
            Entity entity = event.getEntity();
            ElementManager.entityElement(entity, Element.FIRE, 5);
        }
    }

    //实体攻击实体事件
    @EventHandler
    public void onEntityDamageEntity(EntityDamageByEntityEvent event) {
        //被攻击者
        Entity entity = event.getEntity();
        //攻击者
        Entity damager = event.getDamager();

        //如果攻击者是玩家将传递攻击事件
        if (damager instanceof Player) {
            PlayerManager.attackEntity(((Player) damager), entity);
        }
    }
}

