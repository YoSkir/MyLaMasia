package module.name.entity;



import module.name.Nation;

import java.util.Map;

/**
 * @author yoskir
 */
public record NameMapEntity (Map<Nation,NameEntity> nameMap){}
