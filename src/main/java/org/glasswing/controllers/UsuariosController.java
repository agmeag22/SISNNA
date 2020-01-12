/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.controllers;

import java.util.logging.Logger;
import org.glasswing.service.UserService;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //manda a llamar a los metodos
public class UsuariosController {

	static Logger log = Logger.getLogger(UsuariosController.class.getName());


// static List<InfoUsuario> list = new ArrayList<InfoUsuario>();
	@RequestMapping("/usuarios")
	public ModelAndView initMain() {

		ModelAndView mav = new ModelAndView();
//                mav.addObject("allUsers",ServicioUsuario.getUsers());
		mav.setViewName("usuarios/index");
		return mav;
	}

        @RequestMapping("/usuarios/nuevo")
	public ModelAndView crearUsuario() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("usuarios/nuevo");
		return mav;
	}

        @RequestMapping("/usuarios/modificar")
	public ModelAndView editarUsuario(@RequestParam(value="userNumber") int number) {
		ModelAndView mav = new ModelAndView();

                //Usuario user = ServicioUsuario.getUsers().get(userNumber-1);

//                Usuario user=new Usuario();                
                //searching for the user with the specific number
                //buscando al usuario con el numero especifico.
//                for(int i =0; i<UserService..size();i++){
//                    if(ServicioUsuario.getUsers().get(i).getNumber() == number){
//                        user=ServicioUsuario.getUsers().get(i);
//                    }
//                }
//                mav.addObject("user",user);
		mav.setViewName("usuarios/modificar");
		return mav;
	}



	@RequestMapping(value="/usuarios/nuevo",method=RequestMethod.POST)
	public ModelAndView create(@RequestParam(value="id") String id,
                @RequestParam(value="username") String username,@RequestParam(value="password") String password,
                @RequestParam(value="name") String name, @RequestParam(value="lastname") String lastName,
                        @RequestParam(value="role") String role, @RequestParam(value="department") String department,
                        @RequestParam(value="committee") String committee,
                        @RequestParam(value="email") String email, @RequestParam(value="createdAlert") String createdAlert,
                        @RequestParam(value="assignedAlert") String assignedAlert, @RequestParam(value="state") String state) {

		ModelAndView mav = new ModelAndView();

//                Usuario user= new Usuario();
//
//                user.setId(id);
//                user.setUsername(username);
//                user.setPassword(password);
//                user.setName(name);
//                user.setLastname(lastName);
//                user.setRole(role);
//                user.setDepartment(department);
//                user.setCommittee(committee);
//                user.setEmail(email);
//                user.setCreatedAlert(createdAlert);
//                user.setAssignedAlert(assignedAlert);
//                user.setState(state);


                //user.setNumber(ServicioUsuario.getUsersNumber()+1);
//                ServicioUsuario.setUsersNumber(ServicioUsuario.getUsersNumber()+1);

//                int usersEver = ServicioUsuario.getUsersEver()+1;
//                ServicioUsuario.setUsersEver(usersEver);
//                user.setNumber(usersEver);

//                ServicioUsuario.setNewUser(user);

                mav.addObject("respuesta","Usuario añadido con éxito");
                /*
                if(username.equals("usuario") && password.equals("glasswing")){
		if(userServ.findOneUser(username, password)) {
			log.info("Entrando a funcion init-min" + log.getName());    
			mav.setViewName("main");
		}else {
                        mav.addObject("error", "Las credenciales son invalidas");
			mav.setViewName("login");
		}
                */
			log.info("No se pudo realizar" + log.getName() +"u:::::::"+ username+ "p::::::"+password);
		return mav; 
	}

        @RequestMapping("/usuarios/modificado")
	public ModelAndView modify(@RequestParam(value="id") String id,
                @RequestParam(value="username") String username,@RequestParam(value="password") String password,
                @RequestParam(value="name") String name, @RequestParam(value="lastname") String lastName, 
                        @RequestParam(value="role") String role, @RequestParam(value="department") String department,
                        @RequestParam(value="committee") String committee,
                        @RequestParam(value="email") String email, @RequestParam(value="createdAlert") String createdAlert,
                        @RequestParam(value="assignedAlert") String assignedAlert, @RequestParam(value="state") String state,
                        @RequestParam(value="userNumber") int number) {

		ModelAndView mav = new ModelAndView();
                mav.setViewName("usuarios/modificar");
                //int userNumber= number-1;
                //Usuario user= new Usuario();
//                Usuario user=new Usuario();
                int indice=0;
                //searching for the user with the specific number
                //buscando al usuario con el numero especifico.
//                for(int i =0; i<ServicioUsuario.getUsers().size();i++){
//                    if(ServicioUsuario.getUsers().get(i).getNumber() == number){
//                        user=ServicioUsuario.getUsers().get(i);
//                        indice=ServicioUsuario.getUsers().indexOf(user);
//                    }
//                }
                /*
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setName(name);
                user.setLastname(lastName);
                user.setRole(role);
                user.setDepartment(department);
                user.setCommittee(committee);
                user.setEmail(email);
                user.setCreatedAlert(createdAlert);
                user.setAssignedAlert(assignedAlert);
                user.setState(state);*/

//                ServicioUsuario.getUsers().get(indice).setId(id);
//                ServicioUsuario.getUsers().get(indice).setUsername(username);
//                ServicioUsuario.getUsers().get(indice).setPassword(password);
//                ServicioUsuario.getUsers().get(indice).setName(name);
//                ServicioUsuario.getUsers().get(indice).setLastname(lastName);
//                ServicioUsuario.getUsers().get(indice).setRole(role);
//                ServicioUsuario.getUsers().get(indice).setDepartment(department);
//                ServicioUsuario.getUsers().get(indice).setCommittee(committee);
//                ServicioUsuario.getUsers().get(indice).setEmail(email);
//                ServicioUsuario.getUsers().get(indice).setCreatedAlert(createdAlert);
//                ServicioUsuario.getUsers().get(indice).setAssignedAlert(assignedAlert);
//                ServicioUsuario.getUsers().get(indice).setState(state);

                //user.setNumber(ServicioUsuario.getUsersNumber()+1);
                //ServicioUsuario.setUsersNumber(ServicioUsuario.getUsersNumber()+1);

                //ServicioUsuario.setNewUser(user);

                mav.addObject("respuesta","Usuario modificado con éxito");


//                mav.addObject("user",user);
		return mav; 
	}


        @RequestMapping("/usuarios/eliminar") //Borrar usuario.
	public ModelAndView eliminarUsuario(@RequestParam(value="userNumber") int number) {

		ModelAndView mav = new ModelAndView();
                //int userNumber=number-1; //posicion en el arraylist
//                int numeroActualUsuarios=ServicioUsuario.getUsersNumber()-1; //total actual de usuarios
//                Usuario user=new Usuario();                
//                //searching for the user with the specific number
//                //buscando al usuario con el numero especifico.
//                for(int i =0; i<ServicioUsuario.getUsers().size();i++){
//                    if(ServicioUsuario.getUsers().get(i).getNumber() == number){
//                        user=ServicioUsuario.getUsers().get(i);
//                    }
//                }
//
//                //Al obtener el usuario especifico, se elimina. Se baja el numero de usuarios.
//                ServicioUsuario.getUsers().remove(user);                
//                ServicioUsuario.setUsersNumber(numeroActualUsuarios);
//                //UserService.removeUser(users.indexOf(user));            
//                //users.remove(user);     
//                mav.addObject("allUsers",ServicioUsuario.getUsers());
		mav.setViewName("usuarios/index");
		return mav;
	}




}