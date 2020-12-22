package com.promotion.service.promotion.service;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class JsonReader {

    public void readAndCalcPromotionfromJson()
    {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("employees.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeObject(JSONObject employee) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");


        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");


        String grade = (String) employeeObject.get("grade");

        String yofexp = (String) employeeObject.get("yearsofexp");

        if (yofexp > 5 && grade == "Manager") {
            System.out.println("Promoted to SM");
        }

    }


}




        }
