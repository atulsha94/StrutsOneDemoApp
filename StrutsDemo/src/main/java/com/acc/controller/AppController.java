
  package com.acc.controller;
  
  import java.sql.SQLException; 
  
  import java.util.List;
  
  import javax.servlet.http.HttpServletRequest;
  
  import org.springframework.stereotype.Controller; 
  import org.springframework.ui.Model; 
  import org.springframework.web.bind.annotation.PostMapping; 
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;
  
  import com.acc.bean.ProjectBean; import com.acc.dao.DbUtils;
  
  @Controller
  public class AppController {
  
  
  
  
		
  @RequestMapping("api/projectDashboard") 
  public String viewProject(Model model) {
  model.addAttribute("projectList", DbUtils.getAllProject()); 
  return "projectDashboard"; 
  }
  
  
  

  @PostMapping("/api/addProject")
  public String addProject(@RequestParam("projectName") String projectName, Model model) {
  
  ProjectBean project = new ProjectBean();
  project.setProjectName(projectName);
  
  DbUtils.addProject(project);
  model.addAttribute("employeeList", DbUtils.getAllProject());
  return "redirect:projectDashboard"; 
  }
 
  
  
  @PostMapping("/api/updateProject") public String
  updateEmployee(@RequestParam("id") String projectId,@RequestParam("projectName") String projectName,  Model model) throws SQLException {
  
  ProjectBean bean = new ProjectBean(); 
  bean.setId(projectId);
  bean.setProjectName(projectName);
  boolean updatedSuccessfully = DbUtils.updateProject(bean);
  model.addAttribute("updateRecord", updatedSuccessfully);
  return   "updateProjectSuccess"; 
  
  }

  @PostMapping("/api/deleteProject") public String
  deleteEmployee(@RequestParam(name = "projectId", required = false) String projectId,
  Model model, HttpServletRequest request) {
	  boolean deletedSuccessfully =DbUtils.deleteProject(projectId);
	  model.addAttribute("projectDeleted",deletedSuccessfully);
	  return "deleteProjectSuccess"; }
 
  }
 