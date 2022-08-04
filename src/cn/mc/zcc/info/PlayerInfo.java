package cn.mc.zcc.info;

import org.bukkit.entity.Player;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

//玩家信息类
public class PlayerInfo {
    private final Player player;
    //角色卡
    private final Set<Role> roles = new HashSet<>();
    //当前正在使用角色
    private Role role;

    public PlayerInfo(Player player) {
        this.player = player;
    }


    public Player getPlayer() {
        return player;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
