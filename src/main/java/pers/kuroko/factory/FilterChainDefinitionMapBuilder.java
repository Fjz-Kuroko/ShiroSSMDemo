package pers.kuroko.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // 应该操作数据库
        map.put("/view/register.jsp", "anon");
        map.put("/view/login.jsp", "anon");

        map.put("/index/doLogin", "anon");
        map.put("/index/doRegister", "anon");
        map.put("/index/logout", "logout");
        map.put("/view/admin.jsp", "roles[admin]");
        map.put("/**", "authc");
        return map;
    }

}
