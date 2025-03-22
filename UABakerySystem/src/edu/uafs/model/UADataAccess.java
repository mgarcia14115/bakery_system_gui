/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uafs.model;
import java.util.List;
/**
 *
 * @author mgarcia
 */
public interface UADataAccess <Entity>{
    
    public List<Entity> getAllItemsFromDatabase();
    
    public Entity getItem(int key);
    
    public void update (Entity item);
    
    public void delete (Entity item);
    
    public void insert (Entity item);
    
}
