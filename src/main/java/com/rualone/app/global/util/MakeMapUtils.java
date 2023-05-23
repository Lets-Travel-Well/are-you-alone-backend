package com.rualone.app.global.util;

import com.rualone.app.domain.journey.dto.request.AttractionInfoPathRequest;
import com.rualone.app.domain.journey.dto.response.AttractionInfoPathResponse;

import java.util.*;

public class MakeMapUtils {
    private static final int MAX = Integer.MAX_VALUE;
    public static double[][] map, dp;
    public static Queue<Integer> list = new LinkedList<>();
    public static ArrayList<Double> highList = new ArrayList<>();
    public static int[] temp;
    public static double[] high;
    public static int size;
    public static double answer;
    public static List<AttractionInfoPathResponse> makeShortestPath(List<AttractionInfoPathRequest> attractionInfoPathRequests){
        /*
        변수명 바꾸고 리팩토링중입니다.
         */
        List<AttractionInfoPathResponse> journeyPlacePathResponse = new ArrayList<>();
        size = attractionInfoPathRequests.size();
        map = new double[size][size];
        dp = new double[size][1<<size];

        for(int i = 0; i < size; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j = i; j < size; j++){
                double len = getLength(attractionInfoPathRequests.get(i), attractionInfoPathRequests.get(j));
                map[i][j] = len;
                map[j][i] = len;
            }
        }
        temp = new int[size];
        high = new double[size];
        dp[0][1] = 0;
        temp[0] = 0;
        answer = MAX;
        double max = Integer.MIN_VALUE;
        int index = -1;
        dfs(0, 1, 1);
        for(int i = 0; i < highList.size(); i++){
            if(highList.get(i) > max){
                max = highList.get(i);
                index = i;
            }
        }
        for(int i = 0; i < index; i++){
            list.add(list.poll());
        }
        System.out.println(list);
        for(Integer temp : list){
            journeyPlacePathResponse.add(new AttractionInfoPathResponse(attractionInfoPathRequests.get(temp)));
        }
        return journeyPlacePathResponse;
    }
    public static void dfs(int now, int visited, int cur){
        if(visited == ((1<<size)-1)){
            if(map[now][0]==0) return;
            double compare = dp[now][visited] + map[now][0];
            high[0] = map[now][0];
//            answer = Math.min(answer, compare);
            if(answer > compare){
                answer = compare;
                list = new LinkedList<>();
                highList = new ArrayList<>();
                for(Integer tmp : temp){
                    list.add(tmp);
                }
                for(double tmp : high){
                    highList.add(tmp);
                }
            }
            return;
        }

        for(int i=0; i<size; i++){
            int next = (1<<i);
            if((visited | next) == visited) continue;
            if(map[now][i] == 0) continue;
            if(dp[now][visited] + map[now][i] < dp[i][visited|next]){
                dp[i][visited|next] = dp[now][visited] + map[now][i];
                temp[cur] = i;
                high[cur] = map[now][i];
                dfs(i, visited|next, cur + 1);
                temp[cur] = -1;
            }
        }
    }
    private static double getLength(AttractionInfoPathRequest myAttractionDto1, AttractionInfoPathRequest myAttractionDto2){
        double lon1 = myAttractionDto1.getLongitude();
        double lon2 = myAttractionDto2.getLongitude();
        double lat1 = myAttractionDto1.getLatitude();
        double lat2 = myAttractionDto2.getLatitude();
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))* Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2))*Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60*1.1515*1609.344;

        return dist; //단위 meter
    }
    //10진수를 radian(라디안)으로 변환
    private static double deg2rad(double deg){
        return (deg * Math.PI/180.0);
    }
    //radian(라디안)을 10진수로 변환
    private static double rad2deg(double rad){
        return (rad * 180 / Math.PI);
    }
}
