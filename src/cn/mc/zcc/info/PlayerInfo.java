package cn.mc.zcc.info;

import cn.mc.zcc.entity.RoleBase;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

//玩家信息类
public class PlayerInfo implements Serializable {
    private String player;
    //玩家所有角色卡
    private final HashMap<Integer, RoleBase> roles = new LinkedHashMap<>();
    //当前正在使用角色
    private RoleBase usedRole;

    public PlayerInfo() {
    }

    //Fun
    public void addRole(RoleBase roleBase) {
        this.roles.put(roleBase.getId(), roleBase);
    }


    //GET SET


    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public HashMap<Integer, RoleBase> getRoles() {
        return roles;
    }

    public RoleBase getUsedRole() {
        if (usedRole == null) {
            this.setUsedRole(this.roles.get(1));
        }
        return usedRole;
    }

    public void setUsedRole(RoleBase usedRole) {
        this.usedRole = usedRole;
    }
}
