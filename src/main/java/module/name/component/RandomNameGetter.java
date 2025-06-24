package module.name.component;

import module.name.Nation;
import module.name.component.data.NameDataManager;
import module.name.entity.NameEntity;
import org.springframework.stereotype.Component;


import java.util.Random;

/**
 * @author yoskir
 */
@Component
public class RandomNameGetter {
    private final NameDataManager nameDataManager;

    public RandomNameGetter(NameDataManager nameDataManager) {
        this.nameDataManager = nameDataManager;
    }

    public String getRandomName(Nation nation) {
        NameEntity nameEntity=nameDataManager.getNationName(nation);
        int firstNameCount=nameEntity.firstName().size();
        int lastNameCount=nameEntity.lastName().size();
        Random random=new Random();
        String firstName=nameEntity.firstName().get(random.nextInt(firstNameCount));
        String lastName=nameEntity.lastName().get(random.nextInt(lastNameCount));

        if(nation==Nation.Western){
            return firstName+lastName;
        }
        return lastName+firstName;
    }
}
