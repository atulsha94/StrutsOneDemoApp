package com.acc.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MessageTag  extends TagSupport {
	private String mess;

	   public void setMess(String msg) {
	      this.mess = msg;
	   }
	   
	   public int doStartTag() throws JspException {  
		    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
		    try{  
		    	 if (mess != null) {
			         out.println( mess );
			      } 
		    }catch(Exception e){System.out.println(e);}  
		    return SKIP_BODY;//will not evaluate the body content of the tag  
		} 
	   
	 
	   }
