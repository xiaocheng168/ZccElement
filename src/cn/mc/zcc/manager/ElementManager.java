package cn.mc.zcc.manager;

import cn.mc.zcc.entity.EntityElement;
import cn.mc.zcc.info.Element;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.LinkedHashMap;

//实体元素附着存储
public abstract class ElementManager {
    private static final HashMap<Entity, EntityElement> entityElements = new LinkedHashMap<>();

    //设置实体元素附着时间
    public static void entityElement(Entity entity, Element element, int time) {
        if (!entityElements.containsKey(entity)) {
            entityElements.put(entity, new EntityElement(entity, element));
        }
        EntityElement ee = entityElements.get(entity);
        ee.setElementStartTime(ee.getAddElement(), time);
    }

    //删除实体的所有元素附着
    public static void removeEntityElement(Entity entity) {
        entityElements.remove(entity);
    }

}
