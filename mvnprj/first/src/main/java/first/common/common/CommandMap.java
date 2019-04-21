package first.common.common;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class CommandMap {
	
    Map<String,Object> map = new HashMap<String,Object>();
    //오브젝트이기때문에 세상모든객체가 저장이된다는장점!
    //굳이 타입같은거안따져도 된다
    public Map<String,Object> getMap(){
        return map;//이렇게 맵객체를 얻는거
    }
    public Object get(String key){
        return map.get(key);
    }
    public void put(String key, Object value){
        map.put(key, value);
    }
    public Object remove(String key){
        return map.remove(key);
    }
    public boolean containsKey(String key){
        return map.containsKey(key);//키가있는지확인
    }
    public boolean containsValue(Object value){
        return map.containsValue(value);//값이 있는지 확인
    }
    public void clear(){//클리어로 깔끔히 정리
        map.clear();
    }
    public Set<Entry<String, Object>> entrySet(){
        return map.entrySet();
    }
    public Set<String> keySet(){
        return map.keySet();
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }
    public void putAll(Map<? extends String, ?extends Object> m){
        map.putAll(m);
    }
}