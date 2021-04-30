/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Pefes
 */
public class Main {
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        
        String count = getCount(client);
        System.out.println("Count: " + count);
        
        String complaints = getComplaints(client);
        System.out.println("Complaints: " + complaints);
        
        int openedComplaintId = getOpenedComplaintId(complaints);
        String openedComplaint = getOpenedComplaint(client, openedComplaintId);
        System.out.println("Opened complaint: " + openedComplaint);
        
        modifyOpenedComplaint(client, openedComplaintId, openedComplaint);
        
        String allOpenedComplaints = getAllOpenedComplaints(client);
        System.out.println("All opened complaints" + allOpenedComplaints);

        client.close(); 
    }
    
    public static String getCount(Client client) {
        return client.target("http://localhost:8080/Complaints/resources/complaints/count")
        .request(MediaType.TEXT_PLAIN)
        .get(String.class);
    }
    
    public static String getComplaints(Client client) {
        return client.target("http://localhost:8080/Complaints/resources/complaints")
        .request(MediaType.APPLICATION_JSON)
        .get(String.class);
    }
    
    public static int getOpenedComplaintId(String complaints) {
        JSONArray arr = new JSONArray(complaints);
        
        for (int i = 0; i < arr.length(); i++) {
            JSONObject com = arr.getJSONObject(i);
            if ("open".equals(com.getString("status"))) {
                return com.getInt("id");
            }
        }
        
        return -1;
    }
    
    public static String getOpenedComplaint(Client client, int id) {
        if (id != -1) {
            return client.target("http://localhost:8080/Complaints/resources/complaints/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        }
        
        return "";
    }
    
    public static void modifyOpenedComplaint(Client client, int id, String openedComplaint) {
        if (id != -1 && !"".equals(openedComplaint)) {
            JSONObject modifiedComplaint = new JSONObject(openedComplaint);
            modifiedComplaint.put("status", "closed");
            
            client.target("http://localhost:8080/Complaints/resources/complaints/" + id)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(modifiedComplaint.toString()));
        }
    }
    
    public static String getAllOpenedComplaints(Client client) {
        return client.target("http://localhost:8080/Complaints/resources/complaints?status=open")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);
    }
}
