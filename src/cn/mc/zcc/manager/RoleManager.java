package cn.mc.zcc.manager;

import cn.mc.zcc.entity.Role;
import cn.mc.zcc.entity.roles.Paimo;
import cn.mc.zcc.info.Element;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RoleManager {
    public static HashMap<Integer, Role> defaultRole = new LinkedHashMap<>();

    static {
        add(new Paimo("派蒙", 1, Element.FIRE, 1, 100));
    }

    public static void add(Role role) {
        defaultRole.put(role.getId(), role);
    }

    public static Role getRole(int id) {
        return defaultRole.get(id);
    }
}
