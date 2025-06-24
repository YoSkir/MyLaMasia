package wu.code.mylamasia.easy_rpg.life;

import lombok.Data;

@Data
public class LifeObj {
    private String name;
    private int level;
    private int maxExp;
    private int curExp;
    private int maxHp;
    private int curHp;
    private int str;
    private int dex;
    private int luc;

    public LifeObj createLife(String name){
        this.name=name;
        this.level=1;
        this.maxHp=100;
        this.curHp=100;
        this.maxExp=calculateExp();
        this.curExp=0;
        this.str=1;
        this.dex=1;
        this.luc=1;
        return this;
    }

    public void attack(LifeObj target){
        
    }

    private int calculateExp(){
        return level*10;
    }
}
