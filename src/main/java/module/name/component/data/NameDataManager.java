package module.name.component.data;


import module.name.Nation;
import module.name.entity.NameEntity;
import module.name.entity.NameMapEntity;
import org.springframework.stereotype.Component;



/**
 * @author yoskir
 */
@Component
public class NameDataManager {
    private final NameMapEntity nameMapEntity;

    public NameDataManager(FileService fileService, NameDataConvertor nameDataConvertor) {
        String nameDataStr=fileService.readFile(DataFile.name);
        nameMapEntity=nameDataConvertor.convert(nameDataStr);
    }

    public NameEntity getNationName(Nation nation){
        return nameMapEntity.nameMap().get(nation);
    }
}
