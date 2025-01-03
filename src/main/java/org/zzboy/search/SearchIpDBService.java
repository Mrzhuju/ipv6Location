package org.zzboy.search;


import cn.hutool.core.io.FileUtil;
import org.zzboy.search.domain.IpRegion;
import org.zzboy.util.Ipv6Util;
import org.zzboy.search.domain.Ipv6DB;

import java.io.File;

public class SearchIpDBService {

    private final Ipv6DB ipv6DB;

    public SearchIpDBService() {
        this.ipv6DB = Ipv6DB.init(FileUtil.getAbsolutePath(this.getClass().getClassLoader().getResource("ipv6.db").getPath()));
    }

    /**
     * 初始化ipv6数据库
     */
    public SearchIpDBService(String ipDbPath) {
        this.ipv6DB = Ipv6DB.init(ipDbPath);
    }

    /**
     *  根据ipv6查询地址
     * @param ip
     * @return
     */
    public IpRegion searchIpv6Region(String ip){
        //todo ipv6 校验
        ip =Ipv6Util.parseIpv6(ip);
        long ipv6ToLong = Ipv6Util.ipv6ToLong(ip);
        return ipv6DB.searchRegion(ipv6ToLong);
    }

    /**
     *  根据ipv6查询地址
     * @param ip
     * @return
     */
    public String searchIpv6RegionStr(String ip){
        //todo ipv6 校验
        long ipv6ToLong = Ipv6Util.ipv6ToLong(ip);
        return ipv6DB.searchRegionString(ipv6ToLong);
    }

}
