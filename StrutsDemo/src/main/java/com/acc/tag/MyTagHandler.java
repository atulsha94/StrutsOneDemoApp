package com.acc.tag;

import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{
	public int doStartTag() throws JspException {  
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    
	    try{  
	     out.print(java.time.LocalTime.now());//printing time using JspWriter  
	    }catch(Exception e){System.out.println(e);}  
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
}
