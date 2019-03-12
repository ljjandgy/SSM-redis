package com.example.springredis.redis.geoHash.test;

import java.util.ArrayList;
import java.util.List;

public class GeoHashHelper {
    public final double Max_Lat = 90;
    public final double Min_Lat = -90;
    public final double Max_Lng = 180;
    public final double Min_Lng = -180;
    private final int length = 20;
    private final double latUnit = (Max_Lat - Min_Lat) / (1 << 20);
    private final double lngUnit = (Max_Lng - Min_Lng) / (1 << 20);
    private final String[] base32Lookup =
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "b", "c", "d", "e", "f", "g", "h",
                    "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    /**
     * 计算经纬度对应的hash值
     * @param min 经度或者维度的最小值
     * @param max 经度或者维度的最大值
     * @param value 当前元素的经度或者维度
     * @param list 用于存储hash值的list
     */
    private void convert(double min, double max, double value, List<Character> list) {
        if (list.size() > (length - 1)) {
            return;
        }
        double mid = (max + min) / 2;
        if (value < mid) {
            list.add('0');
            convert(min, mid, value, list);
        } else {
            list.add('1');
            convert(mid, max, value, list);
        }
    }

    /**
     * 对计算出来的hash值（偶数经度，奇数是维度）进行base32编码
     * @param str hash值
     * @return
     */
    private String base32Encode(final String str) {
        String unit = "";
        StringBuilder sb = new StringBuilder();
        for (int start = 0; start < str.length(); start = start + 5) {
            unit = str.substring(start, start + 5);
            sb.append(base32Lookup[convertToIndex(unit)]);
        }
        return sb.toString();
    }

    /**
     *  计算数组取值下标
     * @param str 截取的hash值
     * @return
     */
    private int convertToIndex(String str) {
        int length = str.length();
        int result = 0;
        for (int index = 0; index < length; index++) {
            result += str.charAt(index) == '0' ? 0 : 1 << (length - 1 - index);
        }
        return result;
    }

    /**
     * 把经纬度转换为hash值，偶数是经度，奇数是纬度
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    public String encode(double lat, double lng) {
        List<Character> latList = new ArrayList<Character>();
        List<Character> lngList = new ArrayList<Character>();
        convert(Min_Lat, Max_Lat, lat, latList);
        convert(Min_Lng, Max_Lng, lng, lngList);
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < latList.size(); index++) {
            sb.append(lngList.get(index)).append(latList.get(index));
        }
        return base32Encode(sb.toString());
    }

    /**
     * 获取周边的坐标点
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    public List<String> around(double lat, double lng) {
        List<String> list = new ArrayList<String>();
        list.add(encode(lat, lng));
        list.add(encode(lat + latUnit, lng));
        list.add(encode(lat - latUnit, lng));
        list.add(encode(lat, lng + lngUnit));
        list.add(encode(lat, lng - lngUnit));
        list.add(encode(lat + latUnit, lng + lngUnit));
        list.add(encode(lat + latUnit, lng - lngUnit));
        list.add(encode(lat - latUnit, lng + lngUnit));
        list.add(encode(lat - latUnit, lng - lngUnit));
        return list;
    }
}
