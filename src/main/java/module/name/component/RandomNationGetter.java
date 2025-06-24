package module.name.component;

import module.name.Nation;
import org.springframework.stereotype.Component;


import java.util.Random;

/**
 * @author yoskir
 */
@Component
public class RandomNationGetter {
    private final int nationCount;
    public RandomNationGetter() {
        nationCount= Nation.values().length;
    }
    public Nation getRansomNation() {
        return Nation.values()[new Random().nextInt(nationCount)];
    }
}
