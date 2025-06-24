package module.name;


import org.springframework.stereotype.Service;
import module.name.component.RandomNameGetter;
import module.name.component.RandomNationGetter;

/**
 * @author yoskir
 */
@Service
public class NameService {
    private final RandomNameGetter randomNameGetter;
    private final RandomNationGetter randomNationGetter;

    public NameService(RandomNameGetter randomNameGetter, RandomNationGetter randomNationGetter){
        this.randomNameGetter = randomNameGetter;
        this.randomNationGetter = randomNationGetter;
    }

    public String getRandomName() {
        return randomNameGetter.getRandomName(randomNationGetter.getRansomNation());
    }
}
