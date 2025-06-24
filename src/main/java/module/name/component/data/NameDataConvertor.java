package module.name.component.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import module.name.NameType;
import module.name.Nation;
import module.name.entity.NameEntity;
import module.name.entity.NameMapEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yoskir
 */
@Component
public class NameDataConvertor {
    public NameMapEntity convert(String nameDataJson){
        try {
            JSONObject nameJson=new JSONObject(nameDataJson);
            Map<Nation, NameEntity> nameMap=new HashMap<>();
            ObjectMapper objectMapper=new ObjectMapper();
            for(Nation nation:Nation.values()){
                JSONObject nameListJson=nameJson.getJSONObject(nation.name());
                String nameArrJson=nameListJson.getString(NameType.first_names.name());
                List<String> firstName= objectMapper.readValue(nameArrJson,new TypeReference<>(){});
                nameArrJson=nameListJson.getString(NameType.last_names.name());
                List<String> lastName= objectMapper.readValue(nameArrJson,new TypeReference<>(){});
                nameMap.put(nation,new NameEntity(firstName,lastName));
            }
            return new NameMapEntity(nameMap);
        } catch (JSONException | JsonProcessingException e) {
            Printer.DebugLog("Json轉換物件失敗 關閉系統\n",e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
