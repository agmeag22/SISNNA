/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 *
 * @author Azure
 */

public class ServicioUsuario implements Serializable {
    
    private static List<Usuario> users = new ArrayList<Usuario>();
    private static Usuario user= new Usuario();
    private static int usersNumber,usersEver;
        static{
                user.setId("1");
                user.setUsername("usuario");
                user.setPassword("glasswing");
                user.setName("Juan");
                user.setLastname("Perez");
                user.setRole("User");
                user.setDepartment("Finanza");
                user.setCommittee("a");
                user.setEmail("email1@server.com");
                user.setCreatedAlert("1,2");
                user.setAssignedAlert("-");
                user.setState("Activo");
                user.setNumber(1);
                
                users.add(user);
                usersNumber=1;
                usersEver=1;
        }

    public ServicioUsuario() {
    }

        
    public static List<Usuario> getUsers() {
        
        return users;
    }

    public static void setUsers(List<Usuario> users) {
        ServicioUsuario.users = users;
    }

    @ModelAttribute("usuario")
    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        ServicioUsuario.user = user;
    }
    
    public static void setNewUser(Usuario user){
        ServicioUsuario.users.add(user);
    }
    
    public static void deleteUser(Usuario user){
        ServicioUsuario.users.remove(user);
    }

    
    //El total actual en la base de datos.
    public static int getUsersNumber() {
        return usersNumber;
    }

    public static void setUsersNumber(int usersNumber) {
        ServicioUsuario.usersNumber = usersNumber;
    }

    
    //The total of users ever been in data base
    //El total de usuarios que ha habido en la base de datos
    public static int getUsersEver() {
        return usersEver;
    }

    public static void setUsersEver(int usersEver) {
        ServicioUsuario.usersEver = usersEver;
    }
    
    
    
        
        
}
