package cn.mc.zcc.entity;

import cn.mc.zcc.ElementM;
import cn.mc.zcc.info.Element;
import cn.mc.zcc.manager.ElementManager;
import cn.mc.zcc.manager.PlayerManager;
import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import java.util.*;

//元素附着
public class EntityElement extends Thread {
    private final Entity entity;
    //元素附着时间
    private final HashMap<Element, Long> elementTime = new LinkedHashMap<>();
    //预添加元素附着属性
    private final Element addElement;

    //是否为玩家
    private boolean isPlayer;
    private Player player;

    public EntityElement(Entity entity, Element element) {
        this.entity = entity;
        this.addElement = element;
        this.start();
        if (this.entity instanceof Player) {
            this.isPlayer = true;
            this.player = (Player) this.entity;
        }
    }


    @Override
    public void run() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //如果实体死亡，将直接结束这个元素附着
                if (entity.isDead()) {
                    this.cancel();
                    ElementManager.removeEntityElement(entity);
                    return;
                }
                //元素附着稀释计时器
                for (Map.Entry<Element, Long> elementIntegerEntry : elementTime.entrySet()) {
                    checkElementTime(elementIntegerEntry.getKey());
                    //如果是玩家，将释放元素效果
                    if (isPlayer) {
                        //释放元素本身的粒子特效
                        elementIntegerEntry.getKey().playEffect(player);
                    }
                }
            }
        }, 0, 100L);
    }

    //验效元素附着时间是否已结束
    private void checkElementTime(Element element) {
        //如果结束时间 小于 当前时间戳 将元素移除
        if (elementTime.getOrDefault(element, System.currentTimeMillis()) <= System.currentTimeMillis()) {
            elementTime.remove(element);
            //如果是玩家将触发角色事件 元素附着消失
            if (isPlayer) {
                Player player = (Player) this.entity;
                //指定元素消失
                PlayerManager.elementDown(player, element, this);
            }
        }
    }

    //设置元素附着时间
    public void setElementStartTime(Element element, int time) {
        if (isPlayer) {
            Player player = (Player) this.entity;
            PlayerManager.elementUp(player, element, this);
        }
        elementTime.put(element, System.currentTimeMillis() + (time * 1000L));

        //火 水 草 互相克制
        //元素反应！
        // 2022年8月5日05:50:29

    }

    //获取实体指定的元素附着时间，没有返回为0
    public Long getElementTime(Element element) {
        return elementTime.getOrDefault(element, System.currentTimeMillis());
    }

    public Entity getEntity() {
        return entity;
    }

    public HashMap<Element, Long> getElementTime() {
        return elementTime;
    }

    public Element getAddElement() {
        return addElement;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
