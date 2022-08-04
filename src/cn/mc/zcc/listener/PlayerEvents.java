package cn.mc.zcc.listener;

import cn.mc.zcc.entity.RoleBase;
import cn.mc.zcc.info.Element;
import cn.mc.zcc.info.PlayerInfo;
import cn.mc.zcc.manager.PlayerManager;
import com.destroystokyo.paper.ParticleBuilder;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.minecraft.server.v1_16_R3.CommandBan;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.C;
import xyz.upperlevel.spigot.book.BookUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new Thread(() -> PlayerManager.addAndLevelPlayer(player)).start();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        new Thread(() -> PlayerManager.addAndLevelPlayer(player)).start();
    }

    @EventHandler
    public void onChat(PlayerSwapHandItemsEvent event) {
        PlayerInfo playerInfo = PlayerManager.PLAYER_PLAYER_INFO_HASH_MAP.get(event.getPlayer().getName());
        BookUtil.BookBuilder bookBuilder = BookUtil.writtenBook();
        bookBuilder.author("zcc");
        bookBuilder.title("title");
        List<BaseComponent[]> baseComponents = new LinkedList<>();
        //基础信息
        RoleBase usedRole = playerInfo.getUsedRole();
        Element element = usedRole.getElement();

        ComponentBuilder baseInfo = new ComponentBuilder();
        baseInfo.append("    角色基本信息 - " + element.getColorName()).append("\n\n");
        baseInfo.append("§3「" + usedRole.getName() + "」").append("\n");
        baseInfo.append("基础攻击: " + playerInfo.getUsedRole().getDamage()).append("\n");
        baseInfo.append("暴击率: " + playerInfo.getUsedRole().getLuck_crit()).append("\n");
        baseInfo.append("暴击伤害: " + playerInfo.getUsedRole().getCrit()).append("\n");
        //元素伤害
        ComponentBuilder elementInfo = new ComponentBuilder();
        elementInfo.append("§3「元素伤害」").append("\n");
        for (Map.Entry<Element, Float> elementIntegerEntry : usedRole.getElementDamage().entrySet()) {
            Element k = elementIntegerEntry.getKey();
            Float v = elementIntegerEntry.getValue();
            elementInfo.append(k.getColorName()).append("反应伤害加成: ").append(v.toString()).append("\n");
        }

        baseComponents.add(baseInfo.create());
        baseComponents.add(elementInfo.create());

        bookBuilder.pages(baseComponents);
        BookUtil.openPlayer(event.getPlayer(), bookBuilder.build());

    }
}
