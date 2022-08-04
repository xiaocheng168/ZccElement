package cn.mc.zcc.info;

import cn.mc.zcc.entity.Role;
import cn.mc.zcc.entity.RoleBase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

//玩家信息类
public class PlayerInfo implements Serializable {
    private String player;
    //玩家所有角色卡
    private final HashMap<Integer, Role> roles = new LinkedHashMap<>();
    //当前正在使用角色
    private Role usedRole;

    public PlayerInfo() {
    }

    //Fun
    public void addRole(Role roleBase) {
        this.roles.put(roleBase.getId(), roleBase);
    }


    //GET SET


    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public HashMap<Integer, Role> getRoles() {
        return roles;
    }

    public Role getUsedRole() {
        if (usedRole == null) {
            this.setUsedRole(this.roles.get(1));
        }
        return usedRole;
    }

    public void setUsedRole(Role usedRole) {
        this.usedRole = usedRole;
    }
}
