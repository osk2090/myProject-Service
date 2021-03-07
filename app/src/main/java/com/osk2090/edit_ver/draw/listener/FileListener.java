package com.osk2090.edit_ver.draw.listener;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.osk2090.context.ApplicationContextListener;
import com.osk2090.edit_ver.draw.domain.Client;
import com.osk2090.edit_ver.draw.util.CsvObject;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FileListener implements ApplicationContextListener {

    //데이터 파일 정보
    File clientFile = new File("clients.json");

    //VO를 저장할 컬렉션 객체
    List<Client> clientList;

    @Override
    public void contextInitialized(Map<String, Object> context) {
        clientList = loadClients(clientFile, Client.class);
        context.put("clientList", clientList);
    }

    @Override
    public void contextDestroyed(Map<String, Object> context) {
        saveClients(clientFile, clientList);
    }

    private <T> List<T> loadClients(File file, Class<T> elementType) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            StringBuilder strBuilder = new StringBuilder();
            String str = null;
            while ((str = in.readLine()) != null) {
                strBuilder.append(str);
            }
            Type listType = TypeToken.getParameterized(ArrayList.class, elementType).getType();
            List<T> list = new Gson().fromJson(strBuilder.toString(), listType);
            System.out.printf("%s 파일 데이터 로딩!\n", file.getName());
            return list;
        } catch (Exception e) {
            System.out.printf("%s 파일 데이터 로딩 중 오류 발생!\n", file.getName());
            return new ArrayList<T>();
        }
    }

    static <T extends CsvObject> void saveClients(File file, List<T> list) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(new Gson().toJson(list));
            System.out.printf("%s 파일 데이터 저장!\n", file.getName());
        } catch (Exception e) {
            System.out.printf("%s 파일 데이터 저장하는 중 오류 발생!\n", file.getName());
        }
    }
}