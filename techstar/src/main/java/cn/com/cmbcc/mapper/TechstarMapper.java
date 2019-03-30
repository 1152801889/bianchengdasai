package cn.com.cmbcc.mapper;

import java.util.List;
import java.util.Map;

public interface TechstarMapper {
    public Map<String, Object> getInfoById(int id);
    public List<Map<String, Object>> getInfoLimit(Map<String, Object> map);
    public void updateInfo(Map<String, Object> map);
    public void batchUpdate(List<Map<String, Object>>  map);
}
