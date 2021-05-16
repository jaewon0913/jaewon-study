package com.study.jaewonstudy.webservice.web.json.controller;

import com.study.jaewonstudy.webservice.web.json.model.JsonModelList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class JsonRestcontroller {

    @GetMapping("/list")
    public Object test(@ModelAttribute JsonModelList jsonModelList){

        JSONObject obj = new JSONObject();
        try {
            JSONArray jArray = new JSONArray();//배열이 필요할때
            for (int i = 0; i < jsonModelList.getMember().size(); i++)//배열
            {
                JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
                sObject.put("name", jsonModelList.getMember().get(i).getName());
                sObject.put("age", jsonModelList.getMember().get(i).getAge());
                jArray.put(sObject);
            }
            obj.put("success", "성공");
            obj.put("member", jArray);//배열을 넣음

        } catch (Exception e) {
            e.printStackTrace();
            obj.put("success", "실패");
        }

        return obj.toString();
    }
}
