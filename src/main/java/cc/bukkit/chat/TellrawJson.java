package cc.bukkit.chat;

import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import cc.bukkit.item.ItemJson;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

public class TellrawJson {
	
	ComponentBuilder builder;
	boolean setupedHover = false; // Tellraw limit
	boolean setupedClick = false; // Tellraw limit
	
	public TellrawJson() {
		
	}
	public TellrawJson(ComponentBuilder builder,boolean setupedHover, boolean setupedClick) {
		this.builder = builder;
		this.setupedClick=setupedClick;
		this.setupedHover=setupedHover;
	}
	public TellrawJson clone() {
		return new TellrawJson(this.builder, this.setupedHover, this.setupedClick);
	}
	public static TellrawJson create() { // Actually this only for easy to use so i create this static method
		return new TellrawJson();
	}
	
	public TellrawJson text(String text) {
		this.builder.append(text);
		return this.clone();
	}
	
	public TellrawJson link(TellrawJson tellrawJson) {
		this.builder.append(tellrawJson.getCuttentComponentBuilder().create());
		return this.clone();
	}
	
	public TellrawJson hoverText(String text) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,new ComponentBuilder(text).create()));
		return this.clone();
	}
	
	public TellrawJson hoverItem(ItemStack iStack) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		try {
			this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_ITEM, new ComponentBuilder(ItemJson.saveJsonfromNMS(iStack)).create()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return this.clone();
	}
	
	public TellrawJson hoverAchievement(String achievement) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_ACHIEVEMENT,new ComponentBuilder(achievement).create()));
		return this.clone();
	}
	public TellrawJson hoverEntity(String entity) {
		if(setupedHover)
			throw new IllegalArgumentException("Only one hover event allow exist in same time");
		this.builder.event(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_ACHIEVEMENT,new ComponentBuilder(entity).create()));
		return this.clone();
	}
	
	public TellrawJson clickCommand(String cmd) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, cmd));
		return this.clone();
	}
	public TellrawJson clickSuggest(String cmd) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, cmd));
		return this.clone();
	}
	public TellrawJson clickURL(String url) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, url));
		return this.clone();
	}
	public TellrawJson clickPage(String page) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.CHANGE_PAGE, page));
		return this.clone();
	}
	public TellrawJson clickFile(String file) {
		if(setupedClick)
			throw new IllegalArgumentException("Only one click event allow exist in same time");
		this.builder.event(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_FILE, file));
		return this.clone();
	}
	public TellrawJson color(net.md_5.bungee.api.ChatColor color) {
		this.builder.color(color);
		return this.clone();
	}
	public TellrawJson setBold(boolean bold) {
		this.builder.bold(bold);
		return this.clone();
	}
	public TellrawJson setItalic(boolean italic) {
		this.builder.italic(italic);
		return this.clone();
	}
	public TellrawJson setObfuscated(boolean obfuscated) {
		this.builder.obfuscated(obfuscated);
		return this.clone();
	}
	public TellrawJson setUnderlined(boolean underlined) {
		this.builder.underlined(underlined);
		return this.clone();
	}
	public TellrawJson setBold() {
		this.builder.bold(true);
		return this.clone();
	}
	public TellrawJson setItalic() {
		this.builder.italic(true);
		return this.clone();
	}
	public TellrawJson setObfuscated() {
		this.builder.obfuscated(true);
		return this.clone();
	}
	public TellrawJson setUnderlined() {
		this.builder.underlined(true);
		return this.clone();
	}
	public TellrawJson reset() {
		this.builder.reset();
		return this.clone();
	}
	public TellrawJson getCurrentTellrawJson() {
		return this.clone();
	}
	public ComponentBuilder getCuttentComponentBuilder() {
		return this.clone().builder;
	}
	public void send(CommandSender sender) {
		sender.spigot().sendMessage(builder.create());
	}
}
