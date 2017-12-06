package com.java.rehber.theme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ThemeSwitcherView {

    private Map<String, String> themes;

    private List<Theme>         advancedThemes;

    private String              theme;


    public Map<String, String> getThemes() {
        return this.themes;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(final String theme) {
        this.theme = theme;
    }

    @PostConstruct
    public void init() {

        this.advancedThemes = new ArrayList<Theme>();
        this.advancedThemes.add(new Theme("afterdark", "afterdark.png"));
        this.advancedThemes.add(new Theme("afternoon", "afternoon.png"));
        this.advancedThemes.add(new Theme("afterwork", "afterwork.png"));
        this.advancedThemes.add(new Theme("aristo", "aristo.png"));
        this.advancedThemes.add(new Theme("black-tie", "black-tie.png"));
        this.advancedThemes.add(new Theme("blitzer", "blitzer.png"));
        this.advancedThemes.add(new Theme("bluesky", "bluesky.png"));
        this.advancedThemes.add(new Theme("bootstrap", "bootstrap.png"));
        this.advancedThemes.add(new Theme("casablanca", "casablanca.png"));
        this.advancedThemes.add(new Theme("cruze", "cruze.png"));
        this.advancedThemes.add(new Theme("cupertino", "cupertino.png"));
        this.advancedThemes.add(new Theme("dark-hive", "dark-hive.png"));
        this.advancedThemes.add(new Theme("delta", "delta.png"));
        this.advancedThemes.add(new Theme("dot-luv", "dot-luv.png"));
        this.advancedThemes.add(new Theme("eggplant", "eggplant.png"));
        this.advancedThemes.add(new Theme("excite-bike", "excite-bike.png"));
        this.advancedThemes.add(new Theme("flick", "flick.png"));
        this.advancedThemes.add(new Theme("glass-x", "glass-x.png"));
        this.advancedThemes.add(new Theme("home", "home.png"));
        this.advancedThemes.add(new Theme("hot-sneaks", "hot-sneaks.png"));
        this.advancedThemes.add(new Theme("humanity", "humanity.png"));
        this.advancedThemes.add(new Theme("le-frog", "le-frog.png"));
        this.advancedThemes.add(new Theme("midnight", "midnight.png"));
        this.advancedThemes.add(new Theme("mint-choc", "mint-choc.png"));
        this.advancedThemes.add(new Theme("overcast", "overcast.png"));
        this.advancedThemes.add(new Theme("pepper-grinder", "pepper-grinder.png"));
        this.advancedThemes.add(new Theme("redmond", "redmond.png"));
        this.advancedThemes.add(new Theme("rocket", "rocket.png"));
        this.advancedThemes.add(new Theme("sam", "sam.png"));
        this.advancedThemes.add(new Theme("smoothness", "smoothness.png"));
        this.advancedThemes.add(new Theme("south-street", "south-street.png"));
        this.advancedThemes.add(new Theme("start", "start.png"));
        this.advancedThemes.add(new Theme("sunny", "sunny.png"));
        this.advancedThemes.add(new Theme("swanky-purse", "swanky-purse.png"));
        this.advancedThemes.add(new Theme("trontastic", "trontastic.png"));
        this.advancedThemes.add(new Theme("ui-darkness", "ui-darkness.png"));
        this.advancedThemes.add(new Theme("ui-lightness", "ui-lightness.png"));
        this.advancedThemes.add(new Theme("vader", "vader.png"));

        this.themes = new TreeMap<String, String>();
        this.themes.put("Afterdark", "afterdark");
        this.themes.put("Afternoon", "afternoon");
        this.themes.put("Afterwork", "afterwork");
        this.themes.put("Aristo", "aristo");
        this.themes.put("Black-Tie", "black-tie");
        this.themes.put("Blitzer", "blitzer");
        this.themes.put("Bluesky", "bluesky");
        this.themes.put("Bootstrap", "bootstrap");
        this.themes.put("Casablanca", "casablanca");
        this.themes.put("Cupertino", "cupertino");
        this.themes.put("Cruze", "cruze");
        this.themes.put("Dark-Hive", "dark-hive");
        this.themes.put("Delta", "delta");
        this.themes.put("Dot-Luv", "dot-luv");
        this.themes.put("Eggplant", "eggplant");
        this.themes.put("Excite-Bike", "excite-bike");
        this.themes.put("Flick", "flick");
        this.themes.put("Glass-X", "glass-x");
        this.themes.put("Home", "home");
        this.themes.put("Hot-Sneaks", "hot-sneaks");
        this.themes.put("Humanity", "humanity");
        this.themes.put("Le-Frog", "le-frog");
        this.themes.put("Midnight", "midnight");
        this.themes.put("Mint-Choc", "mint-choc");
        this.themes.put("Overcast", "overcast");
        this.themes.put("Pepper-Grinder", "pepper-grinder");
        this.themes.put("Redmond", "redmond");
        this.themes.put("Rocket", "rocket");
        this.themes.put("Sam", "sam");
        this.themes.put("Smoothness", "smoothness");
        this.themes.put("South-Street", "south-street");
        this.themes.put("Start", "start");
        this.themes.put("Sunny", "sunny");
        this.themes.put("Swanky-Purse", "swanky-purse");
        this.themes.put("Trontastic", "trontastic");
        this.themes.put("UI-Darkness", "ui-darkness");
        this.themes.put("UI-Lightness", "ui-lightness");
        this.themes.put("Vader", "vader");
    }

    public List<Theme> getAdvancedThemes() {
        return this.advancedThemes;
    }

    public void saveTheme() {

    }
}
